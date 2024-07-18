# TechStore

![image](src/main/resources/static/images/techsotre.png)


TechStore is an e-commerce website that allows users to browse and purchase technology products online. It is built using the following technologies:

- Spring Boot
- Thymeleaf
- Spring Security
- Hibernate Validator
- Spring JPA
- MySQL 
- Bootstrap 5

The project includes the following modules:

- `login`: This module allows users to log in to the website using their email and password.
- `register`: This module allows users to create a new account on the website.
- `profile`: This module allows users to update their personal information and change their password.
- `user-panel`: This module provides an interface for normal users to view the status of their orders.
- `cart`: This module allows users to add items to their shopping cart and manage its contents.
- `checkout`: This module handles the checkout process, including calculating the total cost of the items in the cart and processing the payment. Currently, only COD (Cash on Delivery) is available.
- `product-detailed-page`: This module provides a detailed view of a product, including its description, price, and reviews.

## Installation

To install and run this project, you'll need to have [Java](https://www.java.com) and [Maven](https://maven.apache.org) installed on your computer, as well as a MySQL 8 server. Then, follow these steps:

1. Clone or download this repository.
2. Create a new database on your MySQL server and update the `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password` properties in the `src/main/resources/application.properties` file to match your MySQL server configuration.
3. Navigate to the project directory and run `mvn clean install` to build the project.

Once the application is running, you can access the website at http://localhost:8080. Use the following credentials to log in:


## Importent:

**Due to lack of time (reserve service) I have some shortcomings and bugs in the program:
The users' data enters the database in a secure manner but is not extracted from there in a good way.
I wanted to create a profile page for each user where they could change their personal information.
So is an admin page that can control the orders and users.**   