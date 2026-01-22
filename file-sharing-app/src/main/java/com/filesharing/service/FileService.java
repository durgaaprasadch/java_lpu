package com.filesharing.service;

import com.filesharing.dto.FileResponse;
import com.filesharing.entity.FileEntity;
import com.filesharing.entity.User;
import com.filesharing.exception.FileStorageException;
import com.filesharing.exception.ResourceNotFoundException;
import com.filesharing.repository.FileRepository;
import com.filesharing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Service class for file operations
 * Handles file upload, download, and metadata management
 */
@Service
public class FileService {
    
    @Autowired
    private FileRepository fileRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Value("${file.upload.dir}")
    private String uploadDir;
    
    private static final List<String> ALLOWED_EXTENSIONS = Arrays.asList("pdf", "jpg", "png", "txt");
    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024; // 10MB
    
    /**
     * Upload a file
     * Validates file type and size, stores file on server
     */
    public FileResponse uploadFile(MultipartFile file, String userEmail) {
        // Get user
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        // Validate file
        validateFile(file);
        
        try {
            // Create upload directory if it doesn't exist
            Path uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();
            Files.createDirectories(uploadPath);
            
            // Generate unique filename
            String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
            String fileExtension = getFileExtension(originalFilename);
            String uniqueFilename = UUID.randomUUID().toString() + "." + fileExtension;
            
            // Copy file to upload directory
            Path targetLocation = uploadPath.resolve(uniqueFilename);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            
            // Save file metadata to database
            FileEntity fileEntity = new FileEntity();
            fileEntity.setFilename(originalFilename);
            fileEntity.setFileType(fileExtension);
            fileEntity.setSize(file.getSize());
            fileEntity.setFilePath(uniqueFilename);
            fileEntity.setUploadedBy(user);
            fileEntity.setUploadTime(LocalDateTime.now());
            
            fileRepository.save(fileEntity);
            
            return mapToFileResponse(fileEntity);
            
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file. Please try again!", ex);
        }
    }
    
    /**
     * Get all files uploaded by a user
     */
    public List<FileResponse> getMyFiles(String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        List<FileEntity> files = fileRepository.findByUploadedBy(user);
        return files.stream()
                .map(this::mapToFileResponse)
                .collect(Collectors.toList());
    }
    
    /**
     * Download a file by ID
     * Only the owner can download their file directly
     */
    public Resource downloadFile(Long fileId, String userEmail) {
        FileEntity file = fileRepository.findById(fileId)
                .orElseThrow(() -> new ResourceNotFoundException("File not found"));
        
        // Check if user is the owner
        if (!file.getUploadedBy().getEmail().equals(userEmail)) {
            throw new RuntimeException("You don't have permission to download this file");
        }
        
        return loadFileAsResource(file.getFilePath());
    }
    
    /**
     * Get file entity by ID (for share functionality)
     */
    public FileEntity getFileById(Long fileId) {
        return fileRepository.findById(fileId)
                .orElseThrow(() -> new ResourceNotFoundException("File not found"));
    }
    
    /**
     * Load file as resource for download
     */
    public Resource loadFileAsResource(String filename) {
        try {
            Path filePath = Paths.get(uploadDir).toAbsolutePath().normalize().resolve(filename);
            Resource resource = new UrlResource(filePath.toUri());
            
            if (resource.exists()) {
                return resource;
            } else {
                throw new ResourceNotFoundException("File not found: " + filename);
            }
        } catch (MalformedURLException ex) {
            throw new ResourceNotFoundException("File not found: " + filename);
        }
    }
    
    /**
     * Validate file type and size
     */
    private void validateFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new FileStorageException("Cannot upload empty file");
        }
        
        // Check file size
        if (file.getSize() > MAX_FILE_SIZE) {
            throw new FileStorageException("File size exceeds maximum limit of 10MB");
        }
        
        // Check file extension
        String filename = file.getOriginalFilename();
        String extension = getFileExtension(filename);
        
        if (!ALLOWED_EXTENSIONS.contains(extension.toLowerCase())) {
            throw new FileStorageException("Invalid file type. Only PDF, JPG, PNG, and TXT files are allowed");
        }
    }
    
    /**
     * Get file extension from filename
     */
    private String getFileExtension(String filename) {
        if (filename == null || !filename.contains(".")) {
            return "";
        }
        return filename.substring(filename.lastIndexOf(".") + 1);
    }
    
    /**
     * Map FileEntity to FileResponse DTO
     */
    private FileResponse mapToFileResponse(FileEntity file) {
        return new FileResponse(
            file.getId(),
            file.getFilename(),
            file.getFileType(),
            file.getSize(),
            file.getUploadTime()
        );
    }
}
