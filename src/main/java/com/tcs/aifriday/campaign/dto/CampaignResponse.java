package com.tcs.aifriday.campaign.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class CampaignResponse {
    private String generatedContent;
    private double complianceScore;
    private List<String> complianceAnnotations;
    private int version;
}