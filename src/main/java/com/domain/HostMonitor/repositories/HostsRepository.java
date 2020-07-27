package com.domain.HostMonitor.repositories;

import com.domain.HostMonitor.models.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostsRepository extends JpaRepository<Host, Long> {

}
