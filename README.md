# plataforma-digital
ui automated tests running on multiple browsers

## Getting Started
This code was developed to the technical challenge at the Plataforma Digital Sicredi.(enjoy)

These instructions will get you a copy of the project up and running on your local machine for development and testing 
purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

* Java JRE
* Java JDK
* Apache Maven
* Google Chrome
* Mozilla Firefox
* Selenium Webdriver
* IDE (ex. eclipse)

### Installing

To running this project, you need do it the following steps:

```
At Eclipse IDE
```

```
Access File > Import...
```

```
Projects from Git
```

```
Select a wizard to use importing projects choose the option Import as general project
```

```
Right click on the project and choose an option
```

```
Configure > Convert to Maven Project
```

Double check

```
verify that all dependencies of the project have been downloaded.
```

## Running the tests

To run the suite test, you should execute the file suite.xml, located at folder src/main/resources.
You can also run by command line through maven commands.


### Maven commands

```
open the terminal.
```

```
navigate to root folder of the project.
```

```
run the command: mvn clean.
```

```
run the command: mvn compile.
```

```
run the command: mvn test.
```

The browsers configured was Google Chrome and Mozilla Firefox, but you can change the browser, just change the parameter (value="chrome" />) on suite.xml.
Make sure that you have the drivers dependencies for the selected browsers.


### Purpose of the tests


```
The tests created simulate an finance invest.
Were explored different types of locators and strategies.
```

### Design Pattern

The below design patterns are used at this project

```
DSL
```

```
Factory
```

```
Singleton
```

```
Strategy
```

```
page object
```

## Deployment

You just must execute the suite test (suite.xml).

## Built With

* [SELENIUM WEBDRIVER](http://seleniumwebdriver.org/selenium-webdriver/) - The automation framework used
* [TestNG](https://testng.org/doc/documentation-main.html/) - The automation framework used
* [MAVEN](https://maven.apache.org/) - Dependency Management
* [JAVA](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html/) - Programing language
* [SonarLint](https://www.sonarlint.org/eclipse/) - Lint


## Versioning

Was used [Sourcetree](https://www.sourcetreeapp.com//) for versioning. 

## Authors

* **Anderson Mann** - *Sr. QA Engineer* - [GitHub](https://github.com/andersonmann)

## License

This project is licensed under the GNU License.

## Acknowledgments

* With this tool you do not have to develop methods to perform various interactions with elements and web components, saving time to perform more productive tasks.


