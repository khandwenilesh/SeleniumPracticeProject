SeleniumPracticeProject

This project contains a minimal Selenium setup with WebDriverManager and a JUnit 5 test.

Prerequisites (Windows, cmd.exe):
- Java 21 (JDK) installed and JAVA_HOME set.
- Apache Maven installed and `mvn` available on PATH.
- Google Chrome installed (WebDriverManager will download a compatible ChromeDriver binary).

Quick checks (open a Windows cmd.exe):

- Check Java:
```
java -version
```

- Check Maven:
```
mvn -v
```

Run the test:

1) From the project root (where `pom.xml` is):
```
mvn test -e
```

2) If you want to see the browser window (not headless):
```
set HEADLESS=false
mvn test -e
```

Troubleshooting:
- If `mvn` is not recognized, download Apache Maven (binary zip) from https://maven.apache.org/download.cgi, unzip it, and add the `bin` folder to your PATH. Example (replace the path with your Maven folder):
```
setx PATH "%PATH%;C:\apache-maven-3.9.5\bin"
```
Then restart your cmd.exe and run `mvn -v` to verify.

- If Java isn't found, install a JDK 21 (from Adoptium or Oracle) and set JAVA_HOME and update PATH. Example:
```
setx JAVA_HOME "C:\Program Files\Java\jdk-21"
setx PATH "%PATH%;%JAVA_HOME%\bin"
```

Notes:
- The sample test `SeleniumTest` uses WebDriverManager to automatically download the driver binary. It opens https://example.com and asserts the page title contains "example".
- By default the test runs headless (Chrome headless). Set `HEADLESS=false` to run with a visible browser.

If you want, I can add a Maven Wrapper (`mvnw`) to avoid requiring a user-wide Maven install — tell me if you'd like that and I can add it.

