## Welcome to my UI testing repository for Suncorp Job Application.

### Description
My goal with this repository is show my understanding and use of differentes aspects of this framework.
I'm using TradME site https://www.trademe.co.nz/a/ for build different tests cases.

> DISCLAIMER: I know this framwork could improve but I think it's enough to show you my skill for the possition.

**Framework**
Gradle
Java
Cucumber
Selenium
JUnit

**Desing Patterns**
POM: Page Object Model applied.
Singleton: for web browser creation (FactoryBrowserDriver).

**Key classes**
- src/test/java/base/FactoryBrowserDriver.java.
+ src/test/java/page/BasePage.java.
    + Features.
        + Browser Driver.
        + Wait.
        + Methods and actions to interact with the site web.
            + I'm not using them all in the test but I know how implementing and using them.
        + Read config file.
- src/test/java/utils/Locators.java.
    + Locators repository.
-  src/test/java/utils/PropertiesReader.java
    + Read config.properties file

**Run**
> Chrome executiion available.

`$  ./gradlew test -DcucumberOptions="--tags @Regression"`

Or It is possible run it with **Runner.java** class
+ Its path is /src/test/java/runner/Runner.java

**Reporting**
You can find de reporting here *** build/reports/tests/test/index.html ***

