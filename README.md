# ClipBoardHealthAutomationFramework

This Repo Contains Code for ClipBoardHealth Automation Framework

@author
anish batra

# gitHub Url

https://github.com/anishbatra

# Tech Stack Used

Selenium for Test Automation
Java(11) for enhancements in Test Cases
TestNG for Test Driven and Data Driven Testing
Maven as a build tool
Git for Code Maintenance
GitHub Actions for CI/CD
Docker Desktop for executing test cases locally on Docker
Extent Reports
Log4J for logs

# Installation

Clone the project from https://github.com/anishbatra/ClipBoardHealthAutomationFramework
Set JDK 11 under the Project settings
Change Project support to Maven
Build the Project

# Running Tests

Run tests through various ways

## Local Browsers

1. Go to /Users/anish.batra/Documents/ClipBoardHealthAutomationFramework/Configuration/config.properties
2. Change runType to "local"
3. Run testng.xml

## Docker Locally

pre-requisite :-

1. Make sure Docker Desktop is installed in your system
2. Run command "**docker-compose up**" (this will start the selenium hub and will attach browser containers to the hub
   as defined in docker compose file )
3. Go to /Users/anish.batra/Documents/ClipBoardHealthAutomationFramework/Configuration/config.properties
4. Change runType to "docker" in config.properties file
5. Run testng.xml
6. After finishing the run, make sure to bring down the selenium hub using command **"docker-compose down"**

# GitHub Actions

1. ci.yml at /Users/anish.batra/Documents/ClipBoardHealthAutomationFramework/.github/workflows/ci.yml contains the steps
   to run test cases on GitHub Actions
2. Test run on Selenoid server on GitHub Servers
3. ci.yml defines the actions / steps to run the test cases on Git Hub servers
4. Here our tests will run on machine having Ubuntu - Linux O.S
5. Tests will run in headless mode , logs will be visible in GitHub Actions account

# Through CLI

1. After building the project successfully
2. Install maven cli in your system
3. Run the command  **"mvn clean install"**

# Reporting

Local/docker Test Execution report can be seen under test-output folder
Remote Test Execution report will be published on Git Hub Pages. below is the Url

# Logs

1. Implemented using log4J maven dependancy
2. configuration is loaded in log4j.properties file.
3. Once test case execution is finsihed , a file named application.log will be generated in root of the project
4. logs also gets displayed on console.
