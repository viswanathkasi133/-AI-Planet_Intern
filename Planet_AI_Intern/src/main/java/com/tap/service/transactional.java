package com.tap.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tap.Entity.DocumentMetadata;
import com.tap.repo.Pdfrepo;

@Service
public class transactional {
    
    private final Pdfrepo repo;

    public transactional(Pdfrepo yourRepository) {
        this.repo = yourRepository;
    }

    @Transactional
    public void uploadPdfAndPersist(DocumentMetadata pdfEntity) {
        repo.save(pdfEntity);
    }
}

