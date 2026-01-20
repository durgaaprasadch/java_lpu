package com.filesharing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * DTO for file information response
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileResponse {
    
    private Long id;
    private String filename;
    private String fileType;
    private Long size;
    private LocalDateTime uploadTime;
}
