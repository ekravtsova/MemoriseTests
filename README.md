# MemoriseTests
UI tests for project https://github.com/edu-xored/memorise

## Installation and start
For use tests from this project you need:
1. Started Memorise - see https://github.com/edu-xored/memorise
2. Maven 3.2+
3. Java 1.8+
4. Git

## How to use tests
You can start tests from IDE by Run or Debug buttons. 

And you can start MemoriseTests from cmd. For start from cmd you need:
1. Open cmd.
2. Navigate to the directory with pom.xml file for MemoriseTests project.
3. Execute command
>mvn test
to start all tests with default parameters.
4. Execution of UI tests should be started. By default using Firefox webdriver.
5. At the end of testing you can see the result: BUILD FAILURE or BUILD SUCCESS and the report about testing.

### Parameters for test execution

You can change the browser for tests. For example, use command
>mvn -Dselenide.browser=chrome test
for start tests in Chrome. 
Please, find additional information in http://ru.selenide.org/faq.html

## Using resources

UI tests in current project are developed using Selenide framework (http://selenide.org/ru/index.html). This framework is very convenient for UI tests, because it solve several problems. For example, initialization of the browser, waiting of AJAX and so on.

JUnit is used as testing framework, because it has simple features for this project needs and preinstalled in IntelliJ IDEA, which was used as IDE.

For building and management of the tests using Maven. The tested project using Maven too, so it can be used for tests as a simplest way.
