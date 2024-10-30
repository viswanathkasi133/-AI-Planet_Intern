package com.tap.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tap.Entity.DocumentMetadata;

@Repository
public interface Pdfrepo extends JpaRepository<DocumentMetadata, Long> {
    // Additional query methods if needed
}
