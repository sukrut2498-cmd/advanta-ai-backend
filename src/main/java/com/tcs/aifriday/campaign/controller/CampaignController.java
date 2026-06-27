package com.tcs.aifriday.campaign.controller;

import com.tcs.aifriday.campaign.dto.CampaignResponse;
import com.tcs.aifriday.campaign.service.CampaignService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/campaigns")
@CrossOrigin(origins = "*")
public class CampaignController {

    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @PostMapping(value = "/generate", consumes = {"multipart/form-data"})
    public ResponseEntity<?> handleGenerationRequest(
            @RequestParam("productName") String productName,
            @RequestParam("productDescription") String productDescription,
            @RequestParam("targetAudience") String targetAudience,
            @RequestParam("channel") String channel,
            @RequestParam(value = "version", defaultValue = "1") int version,
            @RequestParam(value = "file", required = false) MultipartFile file) {

        // 1. Strict Backend Zero-Byte File Validation
        if (file != null && file.isEmpty()) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("file", "Security Violation: Uploaded file is empty (0 bytes). Processing aborted.");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        // 2. Structural Text Form Validation
        if (productName.trim().isEmpty() || productDescription.trim().length() < 10) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("form", "Validation Error: Missing fields or description length under 10 characters.");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        // 3. Process file context if present
        String fileContext = "";
        if (file != null) {
            fileContext = "[Attached File: " + file.getOriginalFilename() + " (" + file.getSize() + " bytes)]";
        }

        CampaignResponse result = campaignService.processAndEvaluate(
                productName, productDescription + " " + fileContext, targetAudience, channel, version
        );

        return ResponseEntity.ok(result);
    }
}