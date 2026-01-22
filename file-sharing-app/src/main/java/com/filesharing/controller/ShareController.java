package com.filesharing.controller;

import com.filesharing.dto.ShareLinkResponse;
import com.filesharing.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for file sharing operations
 * Handles share link generation and file download via share links
 */
@RestController
@RequestMapping("/api/share")
@CrossOrigin(origins = "*")
public class ShareController {
    
    @Autowired
    private ShareService shareService;
    
    /**
     * Generate share link for a file
     * POST /api/share/{fileId}
     */
    @PostMapping("/{fileId}")
    public ResponseEntity<ShareLinkResponse> generateShareLink(
            @PathVariable Long fileId,
            Authentication authentication) {
        String userEmail = authentication.getName();
        ShareLinkResponse response = shareService.generateShareLink(fileId, userEmail);
        return ResponseEntity.ok(response);
    }
    
    /**
     * Download file using share token
     * GET /api/share/download/{token}
     * This endpoint is public - no authentication required
     */
    @GetMapping("/download/{token}")
    public ResponseEntity<Resource> downloadFileByToken(@PathVariable String token) {
        Resource resource = shareService.downloadFileByToken(token);
        String filename = shareService.getFilenameByToken(token);
        
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, 
                        "attachment; filename=\"" + filename + "\"")
                .body(resource);
    }
}
