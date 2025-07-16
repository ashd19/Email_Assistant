package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin(origins ="http://localhost:5173")
@RequestMapping("/api/email")
public class emailController {

    private final emailService EmailService;
    @PostMapping("/generate")
    public ResponseEntity<String> generateEmail(@RequestBody EmailRequest emailRequest){
     String response = EmailService.generateEmailReply(emailRequest);
      return  ResponseEntity.ok(response);
  }


}
