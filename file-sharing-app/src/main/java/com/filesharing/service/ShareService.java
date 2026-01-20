package com.filesharing.service;

import com.filesharing.dto.ShareLinkResponse;
import com.filesharing.entity.FileEntity;
import com.filesharing.entity.ShareToken;
import com.filesharing.exception.ResourceNotFoundException;
import com.filesharing.repository.ShareTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * Service class for file sharing operations
 * Handles share link generation and file download via share tokens
 */
@Service
public class ShareService {
    
    @Autowired
    private ShareTokenRepository shareTokenRepository;
    
    @Autowired
    private FileService fileService;
    
    private static final int DEFAULT_EXPIRY_HOURS = 24;
    
    /**
     * Generate share link for a file
     * Creates a unique token with 24-hour expiry
     */
    public ShareLinkResponse generateShareLink(Long fileId, String userEmail) {
        // Get file and verify ownership
        FileEntity file = fileService.getFileById(fileId);
        
        if (!file.getUploadedBy().getEmail().equals(userEmail)) {
            throw new RuntimeException("You don't have permission to share this file");
        }
        
        // Generate unique token
        String token = UUID.randomUUID().toString();
        
        // Set expiry time (24 hours from now)
        LocalDateTime expiryTime = LocalDateTime.now().plusHours(DEFAULT_EXPIRY_HOURS);
        
        // Create and save share token
        ShareToken shareToken = new ShareToken();
        shareToken.setToken(token);
        shareToken.setFile(file);
        shareToken.setExpiryTime(expiryTime);
        shareToken.setCreatedTime(LocalDateTime.now());
        
        shareTokenRepository.save(shareToken);
        
        // Create share link
        String shareLink = "http://localhost:8080/api/share/download/" + token;
        
        // Format expiry time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedExpiry = expiryTime.format(formatter);
        
        return new ShareLinkResponse(
            shareLink,
            token,
            formattedExpiry,
            "Share link generated successfully. Valid for 24 hours."
        );
    }
    
    /**
     * Download file using share token
     * Validates token and checks expiry before allowing download
     */
    public Resource downloadFileByToken(String token) {
        // Find share token
        ShareToken shareToken = shareTokenRepository.findByToken(token)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid share link"));
        
        // Check if token is expired
        if (shareToken.getExpiryTime().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Share link has expired");
        }
        
        // Load and return file
        FileEntity file = shareToken.getFile();
        return fileService.loadFileAsResource(file.getFilePath());
    }
    
    /**
     * Get filename for download
     */
    public String getFilenameByToken(String token) {
        ShareToken shareToken = shareTokenRepository.findByToken(token)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid share link"));
        
        if (shareToken.getExpiryTime().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Share link has expired");
        }
        
        return shareToken.getFile().getFilename();
    }
}
