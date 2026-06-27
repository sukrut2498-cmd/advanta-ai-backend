package com.tcs.aifriday.campaign.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CampaignRequest {
    @NotBlank(message = "Product name cannot be blank")
    @Size(max = 100, message = "Product name must be under 100 characters")
    private String productName;

    @NotBlank(message = "Product description cannot be blank")
    @Size(min = 10, max = 1000, message = "Product description must be between 10 and 1000 characters")
    private String productDescription;

    @NotBlank(message = "Target audience cannot be blank")
    private String targetAudience;

    @NotBlank(message = "Channel is mandatory (e.g., social, email, web)")
    private String channel;

    private String toneOfVoice = "Professional";
}