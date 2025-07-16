package com.example.demo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Email_assistant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Details {
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Id
   private Long id;
   private String email;
   private String query;
   private String tone;
   private String response;



}

