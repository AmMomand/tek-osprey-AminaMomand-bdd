package tek.bdd.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

// Activity:
// as of now, whenever we are navigating to a WebApplication, it's always the TekRetail app, we work on one app per
// framework; this is usually done this way, one app different environment per framework.
// if we have multiple apps per framework, this makes that framework more complicated and complex, so we have to change
// the design and navigate the framework in a different way.
public class BaseSetup { //-> superclass (BaseSetup), this will hold the attributes that will be inherited by sub_classes.


// making the ChromeDriver driver variable as an instance variable so that it's not just a local variable that can be
// only accessed within the scope of the method it was created in.
// so now this diver will go as an instance variable accessible throughout the class and if set as a Super_class using
// inheritance, accessible within all the Sub_classes.

    // All the Variables are either Static (shared with all Objects, an object needs to be created to access this variable)
// or NonStatic (LocalVariable, scope is within where it was initilized).
// Non-static variables, including instance variables, are unique to each instance of the class and require object
// instantiation to access.
    private static WebDriver driver; //-> this driver will be shared across this class and all the sub_classes to this
    // Super_class, since this is a Static variable and can be accessed all over the
    // project, this means that we can modify the value of this variable anywhere we
    // want.
    // We changed the access to this variable into private, and we created a getter
    // method to limit the access to this driver to only read and not write or modifications.

    private final Properties properties = new Properties();

    // Constructor:
// creating a user-defined constructor so that the data is accessible when "openBrowser" method is called
    public BaseSetup() {
        // To read a Properties file.
        // 1) File in System (Location of the file.)
        // 2) FileInputStream,
        // 3) Object of Properties Class.
        // To Load File Location --> System.getProperty("user.dir") return location of Project
        try {
            // anytime we need to read a file from project level, we can use this:
            String fileFilePath = System.getProperty("user.dir") //--> This returns the location for the project.
                    // Appending the project location with the configuration file location
                    + "src/test/resources/config/application-config.properties";

            File propertiesFile = new File(fileFilePath);
            FileInputStream propertyFileInputStream = new FileInputStream(propertiesFile);

            properties.load(propertyFileInputStream);

        } catch (IOException ex) {
            throw new RuntimeException("Can not read or load config file "
                    + ex.getMessage());
        }

    }


    public void openBrowser() {
        //Read browser type from Properties file
        String browserType = this.properties.getProperty("retail.browser.type");
        boolean isHeadless = Boolean.parseBoolean(
                this.properties.getProperty("retail.browser.headless"));

        if (browserType.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (isHeadless)
                options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else if (browserType.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            if (isHeadless)
                options.addArguments("--headless");
            driver = new EdgeDriver(options);
        } else if (browserType.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            if (isHeadless)
                options.addArguments("--headless");
            driver = new FirefoxDriver(options);
        }
        else {
            throw new RuntimeException("Wrong browser Type");
        }

        driver.manage().window().maximize();
        //Get Url from Property File
        String url = this.properties.getProperty("retail.ui.url");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // we are creating a getter so that we are limiting direct access to the instance variable, and providing indirect access
// with getters and setters, so we need to create read-only access to the driver instance variable because we don't want
// any classes to set something for this driver, so all classes can read the drive but not modify it.
// The reason is we don't want the driver instance changed in the middle of the Test, Once the driver is opened, it should
// do whatever action we want until it's closed, so no access to writing, only to reading.
// Creating read-only access to the driver instance ensures that classes can only retrieve its value without the ability
// to modify it.
// This is essential in maintaining the integrity and consistency of the testing process, as the driver instance should
// remain unchanged once initialized for a test scenario.
// Creating that getter for the private Static driver variable:
    public WebDriver getDriver() { //-> Just creating the read-only access to the driver to avoid modifications the driver.

        return driver;
    }

// When we create read-only access(getter) to the driver, that will only allow the using of the driver from other classes
// but cannot be modified from other Sub_classes, in encapsulation, we can just create a getter method if we don't want
// the write access to be accessible by other classes.


}
/*
Explanation of the Constructor part of the above class:
    try {
        String fileFilePath = System.getProperty("user.dir")
                + "/src/test/resources/config/application-config.properties";
        File propertiesFile = new File(fileFilePath);
        FileInputStream propertyFileInputStream = new FileInputStream(propertiesFile);

        properties.load(propertyFileInputStream);

    } catch (IOException ex) {
        throw new RuntimeException("Can not read or load config file "
                + ex.getMessage());
    }
-----------------------------------
This code snippet is responsible for loading configuration settings from a properties file named “application-config.properties”
located in the “config” directory of the test resources folder.
Let’s break down the code:

	1.	File Path Generation:
	•	String fileFilePath = System.getProperty("user.dir") + "/src/test/resources/config/application-config.properties";
	•	This line constructs the absolute file path to the properties file by appending the current directory path
	    (retrieved using System.getProperty("user.dir")) with the relative path to the properties file within the project
	    structure.
	    (user.dir):
	    user.dir is a system property in Java that represents the current working directory of the user. It provides the
	    absolute path of the directory from which the Java application is executed. This property is typically used to
	    construct file paths relative to the current working directory.

	2.	File Object Creation:
	•	File propertiesFile = new File(fileFilePath);
	•	Here, a File object named propertiesFile is created using the generated file path.

	3.	File Input Stream Creation:
	•	FileInputStream propertyFileInputStream = new FileInputStream(propertiesFile);
	•	This line creates a FileInputStream object named propertyFileInputStream to read from the properties file specified
	    by the propertiesFile object.

	4.	Loading Properties:
	•	properties.load(propertyFileInputStream);
	•	The load() method is invoked on a Properties object named properties, which reads the properties list (key-value
	    pairs) from the input stream (propertyFileInputStream) and loads them into the properties object.

	5.	Exception Handling:
	•	The loading process is wrapped in a try-catch block to handle any potential IOException that may occur during
	    file reading.
	•	If an IOException occurs, a RuntimeException is thrown with a descriptive message indicating the failure to read
	    or load the config file.

Overall,
this code snippet efficiently loads configuration settings from an external properties file into a Properties object, which
can then be accessed and utilized by the application or framework for configuration purposes.


 */
