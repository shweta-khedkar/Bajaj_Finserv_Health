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

SELECT P.AMOUNT AS SALARY, CONCAT(E.FIRST_NAME, ' ', E.LAST_NAME) AS NAME,
FLOOR(DATEDIFF(CURRENT_DATE, E.DOB)/365) AS AGE, D.DEPARTMENT_NAME
FROM PAYMENTS P
JOIN EMPLOYEE E ON P.EMP_ID = E.EMP_ID
JOIN DEPARTMENT D ON E.DEPARTMENT = D.DEPARTMENT_ID
WHERE DAY(P.PAYMENT_TIME) != 1
ORDER BY P.AMOUNT DESC
LIMIT 1;

Output:
{
  Webhook URL: https://bfhldevapigw.healthrx.co.in/hiring/testWebhook/JAVA
Access Token: eyJhbGciOiJIUzI1NiJ9.eyJyZWdObyI6IjEyNjIyNDIwMjUiLCJuYW1lIjoiU2h3ZXRhIEtoZWRrYXIiLCJlbWFpbCI6InNod2V0YS5raGVka2FyQG1pdHdwdS5lZHUuaW4iLCJzdWIiOiJ3ZWJob29rLXVzZXIiLCJpYXQiOjE3NDc4MzAyNjksImV4cCI6MTc0NzgzMTE2OX0.9b_4JLSiv7wJyBxiTb6KvGrvpnzASRoYvUBE1M8eThs
Submission Response: {"success":true,"message":"Webhook processed successfully"}
}
Author
Shweta Khedkar
Reg No: 1262242025
Email: shweta.khedkar@mitwpu.edu.in
