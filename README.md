## Welcome to my UI testing repository for Suncorp Job Application.

### Description
My goal with this repository is show my understanding and use of differentes aspects of this framework.
I'm using TradME site https://www.trademe.co.nz/a/ for build different tests cases.

> DISCLAIMER: I know this framwork could iimprove but I think it's enough to show you my skill for the possition. Enjoy it :)

**Framework**
Gradle
Java
Cucumber
Selenium
JUnit



**Desing Patterns**
POM: Page Object Model
Singleton: for web browser creation (FactoryBrowserDriver)

**Run**
./gradlew test -DcucumberOptions="--tags @Regression"

Or

You can run with Runner class. Its path is ***/src/test/java/runner/Runner.java***

**Reporting**
You can find de reporting here *** build/reports/tests/test/index.html ***