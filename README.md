Rewards Service can be started from an IDE by running `Application.java` or through maven `mvn spring-boot:run`  
It uses an in-memory H2 database and the data set used to demonstrate this solution can be found in src/main/resources/data.sql

It has 3 endpoints  
- /transactions : returns all the transactions within date range (default is 3 months)  
Examples :  
  http://localhost:8080/retail/transactions  
  http://localhost:8080/retail/transactions?startDate=2023-01-01&endDate=2024-02-13


- /rewards : returns rewards for all customers with transactions within the date range (default is 3 months)  
Examples :  
  http://localhost:8080/retail/rewards  
  http://localhost:8080/retail/rewards?startDate=2023-01-01&endDate=2024-02-13


- /rewards/{customerId} : returns rewards for a customer with transactions within the date range (default is 3 months)  
Examples :  
  http://localhost:8080/retail/rewards/benjaminbrooks  
  http://localhost:8080/retail/rewards/benjaminbrooks?startDate=2023-01-01&endDate=2024-02-13
