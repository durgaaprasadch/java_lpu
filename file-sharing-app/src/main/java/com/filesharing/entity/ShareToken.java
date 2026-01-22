package com.filesharing.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * ShareToken entity represents a shareable link for a file
 * Contains a unique token and expiry time
 * Allows users to share files with others via temporary links
 */
@Entity
@Table(name = "share_tokens")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShareToken {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String token;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id", nullable = false)
    private FileEntity file;
    
    @Column(nullable = false)
    private LocalDateTime expiryTime;
    
    @Column(nullable = false)
    private LocalDateTime createdTime;
}
