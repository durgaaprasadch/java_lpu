package com.filesharing.repository;

import com.filesharing.entity.ShareToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Repository interface for ShareToken entity
 * Provides database operations for share token management
 */
@Repository
public interface ShareTokenRepository extends JpaRepository<ShareToken, Long> {
    
    /**
     * Find share token by token string
     * @param token The token string
     * @return Optional containing ShareToken if found
     */
    Optional<ShareToken> findByToken(String token);
}
