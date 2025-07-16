package com.example.demo;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class emailService {

    private final WebClient webClient;

   @Value("${gemini.api.url}")
    private String geminiApiUrl;
    @Value("${gemini.api.key}")
    private String geminiApiKey;

    public emailService(WebClient.Builder webClientbuilder) {
        this.webClient = webClientbuilder
                .baseUrl("https://generativelanguage.googleapis.com")
                .build();
    }


    public String generateEmailReply(EmailRequest emailRequest){
    // build prompt and craft the request , do request and get response  finally return
    String prompt = buildPrompt(emailRequest);
   // 1.
        Map<String, Object> requestBody = Map.of(
                "contents", List.of(
                        Map.of(
                                "role", "user",
                                "parts", List.of(
                                        Map.of("text", prompt)
                                )
                        )
                )
        );



        // since it is a post request
        String response = webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path(geminiApiUrl)
                        .queryParam("key", geminiApiKey)
                        .build())
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .onStatus(
                        status -> status.is4xxClientError() || status.is5xxServerError(),
                        clientResponse -> clientResponse.bodyToMono(String.class)
                                .flatMap(errorBody -> {
                                    System.err.println("Error response: " + errorBody);
                                    return reactor.core.publisher.Mono.error(
                                            new RuntimeException("Gemini API Error: " + errorBody));
                                })
                )
                .bodyToMono(String.class)
                .block();

        // extract response and  return
         return extractResponseContent(response);

}

    private String extractResponseContent(String response) {
        try{
     //2.
            ObjectMapper mapper = new ObjectMapper();
            // since we have to iterate through json
             JsonNode rootNode = mapper.readTree(response);
             return rootNode.path("candidates")
                     .get(0)
                     .path("content")
                     .path("parts")
                     .get(0)
                     .path("text")
                     .asText();
        }
        catch(Exception e ){
            return "Error processing Request : " + e.getMessage();
        }
    }

    private String buildPrompt(EmailRequest emailRequest) {
   StringBuilder  prompt = new StringBuilder();
   prompt.append(
           """ 
           Reply based on the tone set by the client, make sure the reply is impressive .
           Never generate a subject line .
           """

           );
if(emailRequest.getTone() !=  null &&  !emailRequest.getTone().isEmpty()){
 prompt.append("Use a ").append(emailRequest.getTone()).append("Tone.");
}

 prompt.append("\n Original email: \n ").append(emailRequest.getEmailContent());
   return prompt.toString();
    }


}
