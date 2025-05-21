# BFHL Spring Boot Assignment – Webhook + SQL Submission

## Overview

This Spring Boot application:

- Sends a POST request on startup to generate a webhook and access token.
- Constructs and submits the correct SQL query based on Question 1.
- Uses JWT Bearer Authorization for secure webhook submission.

## Technologies Used

- Java 17
- Spring Boot
- RestTemplate
- Maven (or Gradle)

## How to Run

```bash
mvn spring-boot:run
