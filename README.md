# Project created for learning selenium

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [How to run all tests using maven?](#how-to-run-all-tests-using-maven)

## General info

This project is a part of onboarding and learning in my internship as a QA engineer. The goal of this project is for me to understand and learn how to write automatic tests using Selenium Web Driver.

## Technologies

Project is created with Java 11.
Framework is using Maven 3 and TestNG 7.

## Setup

To run this project, install it locally using technologies listed above.
For tests to run properly you need to either: 
* in the `WebDriver.properties` file, change the path to the one to the `chromedriver` file on your computer.
* put your `chromedriver` file in the `drivers` package inside the project.

## How to run all tests using maven?

Run following maven command: `mvn test`.

## How to run a single test class using maven?

Run following maven command: `mvn test -Dtest=TestClassName`.
