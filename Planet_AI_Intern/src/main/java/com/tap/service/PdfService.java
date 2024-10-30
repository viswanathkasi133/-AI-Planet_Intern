package com.tap.service;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tap.Entity.DocumentMetadata;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class PdfService {

    @PersistenceContext
    private EntityManager entityManager;

    private static final String UPLOAD_DIR = "uploads/";

    public DocumentMetadata uploadPdf(MultipartFile file) throws IOException {
        Files.createDirectories(Paths.get(UPLOAD_DIR));

        Path filePath = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
        Files.write(filePath, file.getBytes());

        PDDocument document = PDDocument.load(filePath.toFile());
        PDFTextStripper pdfStripper = new PDFTextStripper();
        String text = pdfStripper.getText(document);
        document.close();

        DocumentMetadata docMetadata = new DocumentMetadata();
        docMetadata.setFilename(file.getOriginalFilename());
        docMetadata.setTextContent(text);
        entityManager.persist(docMetadata);

        return docMetadata;
    }
}

