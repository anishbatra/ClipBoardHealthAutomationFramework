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
Extent Reports
Log4J for logs


# Installation

Clone the project from https://github.com/anishbatra/ClipBoardHealthAutomationFramework
Set JDK 11 under the Project settings
Change Project support to Maven
Build the Project


# Running Tests

To run tests,

## Local Browsers

Go to /Users/anish.batra/Documents/ClipBoardHealthAutomationFramework/Configuration/config.properties
Change runType to "local"
Run testng.xml

## Docker Locally
pre-requisite :- 
1. Make sure Docker Desktop is installed in your system 
2. Run command "**docker-compose up**" (this will start the selenium hub and will attach browser containers to the hub as  defined in docker compose file )
3. Go to /Users/anish.batra/Documents/ClipBoardHealthAutomationFramework/Configuration/config.properties
4. Change runType to "docker" in config.properties file
5. Run testng.xml
6. After finishing the run, make sure to bring down the selenium hub using command **"docker-compose down"**

# GitHub Actions

ci.yml at /Users/anish.batra/Documents/ClipBoardHealthAutomationFramework/.github/workflows/ci.yml contains the steps to run test cases on GitHub Actions
Test run on Selenoid server on GitHub Servers 
ci.yml defines the actions / steps to run the test cases on Git Hub servers 
Here our tests will run on machine having Ubuntu - Linux O.S
Tests will run in headless mode , logs  will be visible in GitHub Actions account

# Reporting

Local/docker  Test Execution report can be seen under test-output  folder
Remote  Test Execution report will be published on Git Hub Pages. below is the Url 
