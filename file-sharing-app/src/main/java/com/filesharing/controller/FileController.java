package com.filesharing.controller;

import com.filesharing.dto.FileResponse;
import com.filesharing.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

/**
 * REST Controller for file operations
 * Handles file upload, download, and listing
 */
@RestController
@RequestMapping("/api/files")
@CrossOrigin(origins = "*")
public class FileController {
    
    @Autowired
    private FileService fileService;
    
    /**
     * Upload a file
     * POST /api/files/upload
     */
    @PostMapping("/upload")
    public ResponseEntity<FileResponse> uploadFile(
            @RequestParam("file") MultipartFile file,
            Authentication authentication) {
        String userEmail = authentication.getName();
        FileResponse response = fileService.uploadFile(file, userEmail);
        return ResponseEntity.ok(response);
    }
    
    /**
     * Get all files uploaded by current user
     * GET /api/files/my-files
     */
    @GetMapping("/my-files")
    public ResponseEntity<List<FileResponse>> getMyFiles(Authentication authentication) {
        String userEmail = authentication.getName();
        List<FileResponse> files = fileService.getMyFiles(userEmail);
        return ResponseEntity.ok(files);
    }
    
    /**
     * Download a file by ID
     * GET /api/files/download/{fileId}
     */
    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(
            @PathVariable Long fileId,
            Authentication authentication) {
        String userEmail = authentication.getName();
        Resource resource = fileService.downloadFile(fileId, userEmail);
        
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, 
                        "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
