package dev.hili.cloud_demo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitsRepository extends JpaRepository<Visit, Long> {
}
