# Lets Book It Web Application

A web application that allows an end user to manage events and/or reserve a
spot at the event.

## Features Implemented on the Back End - Data Model:
* Create, find, update, or delete an end user account.
* Create, find, update, or delete a market, which also represents a conference or convention.
* Create, find, update, or delete an event, which represents the date of the market.

## Features Implemented on the Front End - User:
* Find all(List Screen) or delete(Edit Screen) an end user account.
* Find all(List Screen) or delete(Edit Screen) a market, which also represents a conference or convention.
* Find all(List Screen) or delete(Edit Screen) an event, which represents the date of the market.

## Getting Started

* This project was built in IntelliJ using Spring Boot.

* Download the letsbookit package onto your local machine.

* When getting started, the back end and part of the front end will be running on port 8080, while the other part of the front end is running on port 3000.  Please note that you may have to utilize the back button in your browser to get back to the webpage landing on part 3000.

### Building Java Program

Please see the pom.xml file for dependencies. </br>

To build the Java program, open the letsbookit package in IntelliJ, or preferred IDE.  Navigate to the pom.xml and load the dependencies and build the project. </br>

You should be able to make CRUD requests in Postman. </br>

### Front End

To setup the front end, in your terminal, change your directory to libby-app.  Once in said package, type the below in:

```
cd app
npm install
```

npm install will install and load the dependencies to run the front end.  From there, once you have the QuantifiedSelfApplciation running, in your terminal, input ```npm start```
