package com.domain.HostMonitor.repositories;

import com.domain.HostMonitor.models.ApiKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiKeyRepository extends JpaRepository<ApiKey, Long> {
    ApiKey findBykeyhash(String keyhash);
}
