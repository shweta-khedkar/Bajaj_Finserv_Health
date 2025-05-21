package com.example.bfhlassignment.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    @Autowired
    private RestTemplate restTemplate;

    public void generateWebhook() {
        String url = "https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA";

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", "Shweta Khedkar");
        requestBody.put("regNo", "1262242025");
        requestBody.put("email", "shweta.khedkar@mitwpu.edu.in");

        ResponseEntity<Map> response = restTemplate.postForEntity(url, requestBody, Map.class);

        String webhookUrl = (String) response.getBody().get("webhook");
        String accessToken = (String) response.getBody().get("accessToken");

        System.out.println("Webhook URL: " + webhookUrl);
        System.out.println("Access Token: " + accessToken);

        // Example SQL query placeholder — you'll replace this later
        String finalQuery = "SELECT P.AMOUNT AS SALARY, CONCAT(E.FIRST_NAME, ' ', E.LAST_NAME) AS NAME, "
                + "FLOOR(DATEDIFF(CURRENT_DATE, E.DOB)/365) AS AGE, D.DEPARTMENT_NAME "
                + "FROM PAYMENTS P "
                + "JOIN EMPLOYEE E ON P.EMP_ID = E.EMP_ID "
                + "JOIN DEPARTMENT D ON E.DEPARTMENT = D.DEPARTMENT_ID "
                + "WHERE DAY(P.PAYMENT_TIME) != 1 "
                + "ORDER BY P.AMOUNT DESC LIMIT 1;";

        sendFinalQuery(webhookUrl, accessToken, finalQuery);
    }

    public void sendFinalQuery(String webhookUrl, String token, String query) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> body = new HashMap<>();
        body.put("finalQuery", query);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(webhookUrl, entity, String.class);

        System.out.println("Submission Response: " + response.getBody());
    }
}
