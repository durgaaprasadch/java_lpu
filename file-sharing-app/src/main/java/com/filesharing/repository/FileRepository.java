package com.filesharing.repository;

import com.filesharing.entity.FileEntity;
import com.filesharing.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository interface for FileEntity
 * Provides database operations for file management
 */
@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long> {
    
    /**
     * Find all files uploaded by a specific user
     * @param user The user who uploaded the files
     * @return List of files uploaded by the user
     */
    List<FileEntity> findByUploadedBy(User user);
}
