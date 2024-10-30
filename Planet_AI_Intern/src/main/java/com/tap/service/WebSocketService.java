package com.tap.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketService {

    @Autowired
    private PdfService pdfService; 
    
    @MessageMapping("/ask")
    @SendTo("/topic/answers")
    public String answerQuestion(String question) {
       
        return "Dummy answer to: " + question;
    }
}

