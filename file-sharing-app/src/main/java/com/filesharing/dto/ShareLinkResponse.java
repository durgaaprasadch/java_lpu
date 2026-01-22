package com.filesharing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for share link response
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShareLinkResponse {
    
    private String shareLink;
    private String token;
    private String expiryTime;
    private String message;
}
