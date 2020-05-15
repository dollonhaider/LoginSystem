# Build a Login System using Java Spring Boot and MongoDB Database

##Project Description

I had build this project using IntelliJ.There is two api in this system.One is register api and another one is login api.

Register Api - To do regitration you need to put a valid email address and password.If anyone put invalid email
	 address it will generate error message.
			   
Login Api - To do login you need to put a registered email address and password.If it didn't match with the database 
	    it will show error message.If it matches it will show a success message.

## Getting Started

-> Clone the repository: https://github.com/dollonhaider/LoginSystem

-> Download the project

## Setup Local Environment

To run this project you need MongoDB installed in your pc.

## Running process

-> Here I didn't able to connect the frontend part with backend part.So I had attached them in seperate folder.

-> To run the backend part, hit the url from postman.The url's are - 

   For regitration(Method - POST, url - http://localhost:8082/api/user/register )
   For login (Method - POST, url - http://localhost:8082/api/user/login )
   Example of Post Request body -
   {
	"email": "admin@gmail.com",
	"password": "12345678"
   }
   
-> To show the login page double click on login-page.html
