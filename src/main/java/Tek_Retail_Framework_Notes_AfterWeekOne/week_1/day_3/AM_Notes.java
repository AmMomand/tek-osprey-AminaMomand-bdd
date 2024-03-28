package Tek_Retail_Framework_Notes_AfterWeekOne.week_1.day_3;

public class AM_Notes {
/*
1. Review:
   Cucumber is a framework used mostly for testing, it helps the testers to create feature files, their test steps and step
   by step implementations with java and any other tools required for testing.
   Cucumber framework helps to have a clean, reusable and maintainable project for testing, specifically when the projects
   get bigger and bigger, also helps with reporting to managers and adding proof of screenshots and reports of execution.
   We can also execute tests all together by grouping them, cucumber is annotation-based.
   When creating a feature file, we need to have at least one scenario and steps for that scenario should be meaningful and
   clear, these steps are in plain English and everyone can think differently based on how the user story or the scenario
   is divided, it's up to the testers what to choose as Given, When and Then based on the scenario and what the tester
   thinks is a prerequisite, actions, and validations there is no problem with that part, as long as we have the correct
   implementation for that step definition, and it's doing the task that is required which is the final goal.
   Cucumber framework is based on Given(prerequisites), When(action steps) and Then(validation steps), each step of the
   scenario needs to have only one implementation in Java language, which are methods with annotations of type Given, When
   and Then and the text for the step definition which needs to be exactly as the steps in the feature file so cucumber
   understands which step should connect to which method.
   In java, executions happen from top to bottom, left to right, but in a Cucumber framework, execution happens from scenario
   Top to bottom and one by one step by step, once one step is executed it goes to the next and so on until all the steps
   are executed.
   Feature files always start with "Feature:" keyword, we have to make sure that we have ":" after the Feature and scenario,
   otherwise we will be faced with a parse exception or error, but we don't need to add ":" after Given, When and Then.
   Each feature file has to have at least one scenario.
   We can have Scenario Outline in a Feature file if the steps are the same number as the regular scenario.
   It's a must for Scenario outline to have an Examples table that contains the data that will replace the placeholder
   value in the Scenario, as many data as we have in a feature file for a scenario, the scenario will be executed that many
   times, if in a feature file we have 3 values in an Examples table for Scenario outline and also one regular scenario
   the test will be executed 4 times, 3 for the values in the Scenario outline and 1 from the regular scenario.
   Commenting in a feature file is different from a Java file, we need to use "#" for comments instead of "//".
   Sometimes we need to comment the developer of the test's name at the top of the feature files.

   Yesterday we worked on working on tek retail WebApplication, and combined cucumber with Selenium and Java.
   Feature file -> MajorFunctionality.feature
   Step definitions and implementations-> MajorFunctionalitySteps
   Runner -> MajorFunctionalityRunner

   We need to catch up on the previous projects because the next projects will be connected to the previous projects.

________________________________________________________________________________________________________________________

2. Explanation and keynotes for this feature file: --> MajorFunctionality.feature
   	1.	Feature File Structure:
	•	The feature file represents a high-level description of the major functionality of the Retail App.
	•	Each feature file typically corresponds to a specific application or module, containing multiple scenarios related
	    to that functionality.

	2.	Scenario Descriptions:
	•	Scenarios describe specific test cases or scenarios that validate different aspects of the Retail App’s functionality.
	•	Each scenario consists of a series of steps that outline the actions and verifications to be performed during the test.

	3.	Scenario 1: Validate Landing Page Title:
	•	This scenario verifies the title displayed in the top-left corner of the landing page.
	•	It includes steps to open the browser, navigate to the Retail App, validate the top-left corner title, and close
	    the browser.

	4.	Scenario 2: Validate Sign In Button:
	•	This scenario validates the availability and state of the “Sign In” button on the Retail App.
	•	Since the number of steps differs from Scenario 1 and there’s no need for multiple data executions, a regular
	    scenario is used instead of a scenario outline.

	5.	Implementation Considerations:
	•	When implementing Scenario 2, only the step specific to that scenario needs to be implemented, as the other steps
	    are already covered in Scenario 1.
	•	Options for implementing the missing step include manual implementation or use the dryRun option in the runner
	    class to identify missing steps and generate step definitions automatically.

	6.	Ensuring Test Completeness:
	•	All steps in the feature file must have corresponding implementations in the step definition class for the test to
	    run successfully.
	•	If any step lacks an implementation, the test will not execute, highlighting the importance of completing all
	    step definitions for comprehensive test coverage.

	7.	Scenario Outline Consideration:
	•	Scenario Outline is suitable when multiple data executions are required for the same set of steps.
	•	It allows for parameterization of scenarios, enabling efficient testing with various input data combinations.

In summary,
the feature file provides a structured representation of test scenarios for validating the major functionality of the
Retail App. Each scenario is described in detail, and implementation considerations ensure comprehensive test coverage
and maintainability of the automated tests.
________________________________________________________________________________________________________________________

3. dryRun is used to scan if all the steps in the feature file have an implementation, as long as the dryRun stays true,
   the execution will not happen, and if we want the execution to happen, we have to either delete this option or change
   the value to false.
   	1.	Purpose of Dry Run:
	•	dryRun is a feature provided by Cucumber that allows testers to perform a preliminary scan of the feature file
	    and step definitions without executing the actual test scenarios.
	•	It is primarily used to validate whether all the steps in the feature file have corresponding implementations in
	    the step definition files.

	2.	Scanning for Missing Implementations:
	•	When dryRun is set to true, Cucumber scans the feature file and checks each step against the step definitions.
	•	If any step in the feature file lacks an implementation in the step definitions, Cucumber identifies it as an
	    undefined step.
	•	The purpose is to catch missing or incomplete step definitions early in the development process, preventing test
	    failures during actual execution.

	3.	Preventing Unintended Execution:
	•	By keeping dryRun as true, testers ensure that the test scenarios are not executed inadvertently during the
	    scanning process.
	•	This prevents accidental test executions that may lead to false positives or undesired side effects.
	•	Testers have control over when to initiate the actual test execution by either removing the dryRun option or
	    setting it to false.

	4.	Enabling Execution:
	•	Once all the steps in the feature file have been implemented in the step definitions, testers can disable dryRun
	    to initiate the actual test execution.
	•	The test execution proceeds normally, with Cucumber executing the scenarios and validating the application’s
	    behavior against the expected outcomes.

	5.	Integration with Development Workflow:
	•	dryRun facilitates a seamless integration of test development into the overall software development workflow.
	•	Testers can iteratively develop and refine step definitions while continuously validating their completeness and
	    correctness using dryRun.
	•	It promotes early detection and resolution of issues, resulting in more robust and reliable automated tests.

In summary,
dryRun in Cucumber serves as a proactive tool for ensuring the completeness and correctness of step definitions before
initiating the actual test execution. By scanning for missing implementations, it helps maintain the integrity and
effectiveness of the automated test suite.

________________________________________________________________________________________________________________________

4. Assertion and its methods:
   An assertion is a statement in automated testing that verifies whether an expected condition or behavior holds true
   during test execution. Assertions play a crucial role in validating the correctness of the application’s behavior
   against expected outcomes. In Java, assertions are commonly implemented using assertion methods provided by testing
   frameworks like JUnit or TestNG.
   Here are some commonly used assertion methods along with their purposes and examples:

	1.	assertEquals(expected, actual):
	•	Purpose: Compares whether the expected value is equal to the actual value.
	•	Example:
    import static org.junit.Assert.assertEquals;

    public class ExampleTest {
        @Test
        public void testAddition() {
            int result = Calculator.add(2, 3);
            assertEquals(5, result);
        }
    }
---------------------------------------------------------------

	2.	assertTrue(condition):
	•	Purpose: Verifies that a given condition is true.
	•	Example:
    import static org.junit.Assert.assertTrue;

    public class ExampleTest {
        @Test
        public void testIsPositive() {
            int number = 10;
            assertTrue(number > 0);
        }
    }

-----------------------------------------------------------

	3.	assertFalse(condition):
	•	Purpose: Verifies that a given condition is false.
	•	Example:
    import static org.junit.Assert.assertFalse;

    public class ExampleTest {
        @Test
        public void testIsNegative() {
            int number = -5;
            assertFalse(number > 0);
        }
    }

--------------------------------------------------------------

	4.	assertNotNull(object):
	•	Purpose: Verifies that a given object reference is not null.
	•	Example:
    import static org.junit.Assert.assertNotNull;

    public class ExampleTest {
        @Test
        public void testNotNull() {
            String text = "Hello";
            assertNotNull(text);
        }
    }

--------------------------------------------------------------

	5.	assertNull(object):
	•	Purpose: Verifies that a given object reference is null.
	•	Example:
    import static org.junit.Assert.assertNull;

    public class ExampleTest {
        @Test
        public void testNull() {
            String text = null;
            assertNull(text);
        }
    }

-----------------------------------------------------------------------------

	6.	assertSame(expected, actual):
	•	Purpose: Verifies that two object references refer to the same object.
	•	Example:
    import static org.junit.Assert.assertSame;

    public class ExampleTest {
        @Test
        public void testSameObject() {
            String text1 = "Hello";
            String text2 = text1;
            assertSame(text1, text2);
        }
    }

------------------------------------------------------------------------------------

	7.	assertNotSame(expected, actual):
	•	Purpose: Verifies that two object references do not refer to the same object.
	•	Example:
    import static org.junit.Assert.assertNotSame;

    public class ExampleTest {
        @Test
        public void testDifferentObjects() {
            String text1 = "Hello";
            String text2 = new String("Hello");
            assertNotSame(text1, text2);
        }
    }

------------------------------------------------------------------------------------

These assertion methods help ensure that the application behaves as expected during automated testing, providing confidence
in the correctness of the software under test.

________________________________________________________________________________________________________________________

5. By using feature and glue options, we can run multiple scenarios within the same feature file, so we can add additional
   scenarios to the feature file and implement those steps that require implementing, with no change to the runner class.

   In Cucumber, the feature and glue options in the CucumberOptions annotation provide a convenient way to specify which
   feature files to execute and where to find the step definitions (glue code). Here’s a further explanation:

	1.	Feature Option:
	•	The "features" option allows you to specify the path or paths to the feature files that contain the scenarios you
	    want to execute.
	•	You can provide a single feature file or multiple feature files by specifying their paths or directories.
	•	Cucumber will parse and execute all the scenarios defined within the specified feature files.

	2.	Glue Option:
	•	The "glue" option specifies the package or packages where Cucumber should look for the step definitions (glue code)
	    corresponding to the scenarios defined in the feature files.
	•	You specify the package containing your step definitions, and Cucumber will automatically map the steps in the
	    feature files to the corresponding step definition methods.

By using these options effectively, you can run multiple scenarios within the same feature file without the need to modify
the runner class.
Here’s how it works:

	•	Suppose you have a feature file named MyFeature.feature containing multiple scenarios.
	•	You have corresponding step definitions in a Java class located in the package com.example.steps.
	•	In your runner class, you specify the feature file(s) using the features option and the package containing the
	    step definitions using the glue option.
     Example CucumberOptions annotation in the runner class:

    @RunWith(Cucumber.class)
    @CucumberOptions(
        features = "classpath:features/MyFeature.feature", // Path to the feature file(s)
        glue = "com.example.steps" // Package containing the step definitions
    )
    public class MyRunner {
        // Runner class code
    }

With this setup,
you can add additional scenarios to MyFeature.feature and implement the necessary steps in the corresponding step definition
class (com.example.steps) without making any changes to the runner class.
Cucumber will automatically detect and execute the new scenarios along with the existing ones based on the specified feature
and glue options.
________________________________________________________________________________________________________________________

6. Using an implemented step from one feature file to another:
   In Cucumber, step definitions (glue code) are not tied to specific feature files. This means that once a step is
   implemented in a Java class, it can be reused across multiple feature files without the need for reimplementation.
   Here’s a further explanation:

	1.	Reusability of Step Definitions:
	•	Cucumber allows for the reuse of step definitions across different feature files.
	•	Once a step definition is implemented for a particular step, it becomes available for use in any feature file that
	    includes that step.

	2.	Copying Steps Between Feature Files:
	•	You can copy a step from one feature file to another without the need to reimplement it in the corresponding Java
	    step definition class.
	•	This means that you can reuse existing steps from other feature files without duplicating the implementation effort.

	3.	Implementation Requirements:
	•	When adding a step from one feature file to another, you only need to implement the steps that have not been
	    implemented previously in the Java step definition class.
	•	If a step has already been implemented for a different feature file, Cucumber will automatically use the existing
	    implementation for that step.

	4.	Efficiency and Maintainability:
	•	Reusing step definitions promotes efficiency and maintainability of the test automation framework.
	•	It eliminates redundancy by centralizing step implementations and encourages modularization of test code.

	5.	Flexibility in Test Design:
	•	Test scenarios can be composed of steps from various feature files, allowing for flexible and modular test design.
	•	Testers can assemble scenarios by selecting and combining appropriate steps from different feature files as needed.

Overall,
the ability to reuse step definitions across feature files enhances the maintainability, flexibility, and efficiency of
Cucumber test automation projects. It encourages code reuse and modularization, resulting in more robust and maintainable
automated test suites.
________________________________________________________________________________________________________________________

7. If a code is duplicated its not reliable anymore, we need to give access to the instance private variable of
   "private ChromeDriver driver" so that we do not need to re write the entire code we wrote in a separate method and then
   used this instance private varibale in that method which was in the same class as the instance private variable.
   How can we use that instance private variable in another java step definition class to avoide re writing those codes again?

   To access an instance variable (private ChromeDriver driver) from another Java class without duplicating code, you can
   follow these steps:

	1.	Encapsulation:
	•	Ensure that the instance variable driver is encapsulated within its class by making it private.
	•	This encapsulation protects the variable’s state and restricts direct access from outside the class.

	2.	Provide Accessor Method:
	•	Create a public accessor method within the class containing the driver variable.
	•	This method should return the instance of ChromeDriver.

	3.	Accessor Method Implementation:
	•	Implement the accessor method to return the driver instance.

	4.	Using the Accessor Method:
	•	In the other Java class where you want to access the driver instance, instantiate an object of the class containing
	    the driver variable.
	•	Call the accessor method on this object to obtain the driver instance.

Here’s an example illustrating these steps:

// Class containing the instance variable "driver"
public class WebDriverManager {
    private ChromeDriver driver;

    public WebDriverManager() {
        // Initialize ChromeDriver
        driver = new ChromeDriver();
        // Additional configuration/setup if needed
    }

    // Accessor method to provide access to the driver instance
    public ChromeDriver getDriver() {
        return driver;
    }
}

// Another Java class where you want to access the "driver" instance
public class AnotherClass {
    public void someMethod() {
        // Instantiate an object of the class containing the "driver" instance
        WebDriverManager webDriverManager = new WebDriverManager();

        // Access the "driver" instance using the accessor method
        ChromeDriver driver = webDriverManager.getDriver();

        // Use the "driver" instance as needed
        driver.get("https://example.com");
    }
}

By following this approach,
you avoid duplicating code related to the instantiation and setup of the ChromeDriver instance. Instead, you encapsulate
this logic within a separate class and provide access to the instance through an accessor method, promoting code reuse and
maintainability.

________________________________________________________________________________________________________________________

8. If we have 3-step definition java class and all these classes require a chromeDriver variable of driver, if we have
   this variable initiated in another java class called baseSetup, how can we use the initiated driver variable in all
   other 3 classes?

   We can use the inheritance concept to be able to use the properties of one parent class in other child classes.

   To use the initialized ChromeDriver variable from the BaseSetup class in multiple other Java classes, including the
   step definition classes, you can follow these steps:

	1.	Encapsulation and Accessor Method:
	•	Encapsulate the ChromeDriver variable within the BaseSetup class and provide a public accessor method to access it.
	2.	Initialization in BaseSetup:
	•	Initialize the ChromeDriver variable in the BaseSetup class.
	3.	Access from Other Classes:
	•	In the other Java classes, including the step definition classes, instantiate an object of the BaseSetup class.
	•	Call the accessor method on this object to obtain the ChromeDriver instance.

Here’s an example demonstrating these steps:

// BaseSetup class with ChromeDriver initialization
public class BaseSetup {
    private ChromeDriver driver;

    public BaseSetup() {
        // Initialize ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        driver = new ChromeDriver();
        // Additional configuration/setup if needed
    }

    // Accessor method to provide access to the driver instance
    public ChromeDriver getDriver() {
        return driver;
    }
}

// Step definition class 1
public class StepDefinition1 {
    public void someMethod() {
        // Instantiate an object of BaseSetup class
        BaseSetup baseSetup = new BaseSetup();

        // Access the driver instance using the accessor method
        ChromeDriver driver = baseSetup.getDriver();

        // Use the driver instance as needed
        driver.get("https://example.com");
    }
}

// Step definition class 2
public class StepDefinition2 {
    public void someMethod() {
        // Instantiate an object of BaseSetup class
        BaseSetup baseSetup = new BaseSetup();

        // Access the driver instance using the accessor method
        ChromeDriver driver = baseSetup.getDriver();

        // Use the driver instance as needed
        driver.findElement(By.id("someId")).click();
    }
}

// Step definition class 3
public class StepDefinition3 {
    public void someMethod() {
        // Instantiate an object of BaseSetup class
        BaseSetup baseSetup = new BaseSetup();

        // Access the driver instance using the accessor method
        ChromeDriver driver = baseSetup.getDriver();

        // Use the driver instance as needed
        driver.findElement(By.name("someName")).sendKeys("someText");
    }
}

By following this approach,
you centralize the initialization of the ChromeDriver instance in the BaseSetup class and provide access to it through
an accessor method. Other classes, including the step definition classes, can then obtain the ChromeDriver instance by
instantiating an object of the BaseSetup class and calling the accessor method. This promotes code reuse and
maintainability across multiple classes.
________________________________________________________________________________________________________________________

9. When we want to use one driver for multiple Java step definition classes, we can use the concept of inheritance for
   this, this is when child classes inherit the properties of the parent class:
   If we have 3-step definition classes, and one base setup Java class, we can create another Java class for example,
   Selenium utilities, in that class we can pass in the driver from the Super_class(BaseSetup) to the Sub_class
   (SeleniumUtilities) and from that class to the 3 Sub_classes of step definitions, now we created 2 layers of inheritance
   In Java, we can have multiple Sub_classes inheriting from one Super_class but these Sub_classes cannot inherit from
   multiple Super_classes at the same time, so we can have multi_level inheritance but not multi_inheritance.
   so if we have a method called Click() in the Super_class(SeleniumUtilities), each of the 3 Sub_classes will have access
   to that method, but the Super_class for (SeleniumUtilities), which is BaseSetup class, cannot have access to this method
   because only child_classes(sub_classes) inherit from the parent_class(super_class) and a parent_class cannot have
   access to the properties of the child_class, so we can't give to parent we can only get from parent.
   If we have a method called Close() in the Super_class(BaseSetup), SeleniumUtilities class along with all 3 of the
   Step definition classes will have access to this method based on multi_level inheritance.
   So when working with frameworks, when we locate an element, we should not locate it again, we just have to store that
   locator, so it can be used again, so if an element is located using By object by the id, one time, we should not
   locate that element again, we can just store that locator as a variable somewhere, and we can use that variable in any
   Step definition classes.
   In our framework we will have something called POM; this is not related to POM.XML file, this POM is "Page Object Model
   Pattern", this is a pattern or design that we have to follow in each framework, this pattern will have classes called
   Pages, for example, we have classes called "HomePage", "LoginPage", "AccountPage", each of this page or Java class
   is holding the locators for that page in the application, so if we are in the Home page, any element found in that page
   will go into the "HomePage" class, if we find element in the Sign-in page, any element found in that page will go into
   the "SignInPage" class, and if we find elements in the account page, any element found in that page will be stored into
   the "AccountPage" class and so on, so every page in an Application will have its own Java class that will store the
   Element locators found in that page.

   Keynotes:
   	1.	Inheritance for Reusing Driver:
	•	Utilize inheritance to share a single driver instance across multiple Java step definition classes.
	•	Create a superclass, such as BaseSetup, containing driver initialization and configuration.
	•	Use inheritance to pass the driver instance from the superclass to subclasses.

	2.	Two Layers of Inheritance:
	•	Establish a hierarchy with two layers of inheritance: superclass (BaseSetup) and subclass (SeleniumUtilities),
	    and step definition subclasses.
	•	Implement multiple subclasses inheriting properties from the superclass, enabling code reuse and maintainability.

	3.	Multi-Level Inheritance vs. Multi-Inheritance:
	•	Achieve multi-level inheritance where subclasses inherit from a single superclass (BaseSetup).
	•	Note that Java supports multi-level inheritance but not multi-inheritance (inheriting from multiple superclasses
	    simultaneously).

	4.	Accessing Methods in Inherited Classes:
	•	Methods defined in the superclass (BaseSetup) are accessible to all subclasses, including SeleniumUtilities and
	    step definition classes.
	•	Subclasses inherit methods from the superclass, facilitating code reuse and consistency across classes.

	5.	Efficient Element Location with Page Object Model (POM):
	•	Emphasize efficient element location by storing locators and reusing them across step definition classes.
	•	Implement the Page Object Model (POM) pattern to organize and manage locators for each page in the application.

	6.	Page Object Model (POM) Pattern:
	•	Implement the POM pattern with separate Java classes for each page in the application (e.g., HomePage, LoginPage,
	    AccountPage).
	•	Store element locators specific to each page within its corresponding class, promoting code organization and
	    maintainability.

In summary,
leveraging inheritance and the Page Object Model pattern enables efficient code reuse, organization, and maintenance in
Cucumber test automation frameworks. By structuring classes hierarchically and adhering to design patterns, developers
can achieve cleaner, more maintainable codebases for automated testing.

________________________________________________________________________________________________________________________

10. We created a new framework to work with the Page Object Model (POM) pattern and store the corresponding element locator
   to its related Java class.
   Creating a Structured Framework avoids the project from being messy, everything goes into its designated places, and
   Everywhere we go there is a Framework, a Structure and inheritance and Usage of the Java Concepts, inheritance being
   the most used concepts of the Java in a framework.
   There are other concepts of Java that are being used in the framework too like, encapsulation, interface and others
   as the framework gets more and more complex, a framework is a complex matter that never stays the same and gets more
   complex and bigger as the time goes by.
   So we can never create a perfect framework that is also simple and small, frameworks grow and get improved, and as
   a result, those frameworks get more complex.

   Keynotes:
   	1.	Structured Framework for Organization:
	•	Establishing a structured framework prevents projects from becoming disorganized and messy.
	•	Designate specific locations for different components within the framework, ensuring clarity and ease of navigation.

	2.	Integration of Java Concepts:
	•	Frameworks heavily rely on Java concepts such as inheritance, encapsulation, interfaces, and others.
	•	Inheritance stands out as one of the most frequently used Java concepts in framework development, facilitating
	    code reuse and hierarchy.

	3.	Evolution of Framework Complexity:
	•	Frameworks evolve over time and become increasingly complex as project requirements grow and change.
	•	As the framework matures, it expands in size and complexity to accommodate new features, enhancements, and
	    integrations.

	4.	Continuous Improvement and Growth:
	•	Framework development is an ongoing process of continuous improvement and growth.
	•	There is no such thing as a perfect framework; instead, frameworks evolve and improve iteratively based on
	    feedback, requirements, and technological advancements.

	5.	Balancing Complexity and Simplicity:
	•	Striking a balance between complexity and simplicity is essential in framework design.
	•	While frameworks tend to become more complex over time, efforts should be made to maintain simplicity where
	    possible to enhance usability and maintainability.

	6.	Adaptability and Flexibility:
	•	Frameworks must be adaptable and flexible to accommodate changes in project scope, requirements, and technologies.
	•	Employing design patterns and modular architecture allows frameworks to scale and adapt effectively to evolving
	    project needs.

In summary,
structured frameworks provide organization and clarity, leveraging Java concepts like inheritance and encapsulation. As
frameworks evolve, they become more complex but also more capable of meeting project requirements. Continuous improvement
and adaptability are crucial for ensuring that frameworks remain effective and relevant over time.

________________________________________________________________________________________________________________________

11. As of now, whenever we are navigating to a WebApplication, it's always the TekRetail app, we work on one app different
    environment per framework; this is usually done this way, one app per framework.
    if we have multiple apps per framework, this makes that framework more complicated and complex, so we have to change
    the design and navigate the framework in a different way.
    The new project for this new framework is --> tek-osprey-retail-bdd
________________________________________________________________________________________________________________________

12. making the ChromeDriver driver variable as an instance variable so that it's not just a local variable that can be
    only accessed within the scope of the method it was created in.
    so now this diver will go as an instance variable accessible throughout the class and if set as a Super_class using
    inheritance, accessible within all the Sub_classes.
    All the Variables are either Static (shared with all Objects, an object needs to be created to access this variable)
    or NonStatic (LocalVariable, scope is within where it was initilized).
    so a Static driver will be shared across the parent_class and all the sub_classes to that Super_class.

    Keynotes:
    1.	Instance Variable vs. Local Variable:
	•	An instance variable is declared within a class but outside any method, making it accessible throughout the class.
	•	In contrast, a local variable is declared within a method and is only accessible within that method’s scope.

	2.	Scope and Accessibility:
	•	Declaring ChromeDriver driver as an instance variable allows it to be accessed across all methods within the class.
	•	This ensures that the driver variable is not limited to the scope of a single method but can be used throughout
	    the class.

	3.	Inheritance and Access:
	•	By setting driver as an instance variable in a superclass using inheritance, it becomes accessible to all subclasses.
	•	Subclasses inherit instance variables from their superclass, granting them access to the shared driver variable.

	4.	Static vs. Non-Static Variables:
	•	Static variables are shared across all instances of a class and can be accessed without creating an object of
	    the class.
	•	Non-static variables, including instance variables, are unique to each instance of the class and require object
	    instantiation to access.

	5.	Shared Driver Across Classes:
	•	Making driver static would result in a single shared instance of the driver variable across all instances of the
	    class hierarchy.
	•	This means that any changes made to the driver variable in one class would be reflected across all classes sharing
	    the static variable.

In summary,
by declaring "driver" as an instance variable, it becomes accessible throughout the class and its subclasses.
Understanding the distinction between instance and static variables is crucial for effectively managing shared resources,
such as the ChromeDriver instance, across class hierarchies in Java frameworks.

________________________________________________________________________________________________________________________

13. If a Static Variable is Public, this can be accessed from anywhere in the project, not just the class or the package,
    so if this variable is accessible anywhere, we can also modify the value of this static variable.

    keynotes:
    1.	Public Static Variables:
	•	When a variable is declared as public static, it can be accessed from anywhere within the project, regardless of
	    the class or package.
	•	This accessibility allows other classes, even those in different packages, to access and modify the value of the
	    static variable.

	2.	Access and Modification:
	•	Public static variables can be accessed using the class name followed by the dot operator, regardless of where
	    they are declared.
	•	Other classes can modify the value of a public static variable by assigning a new value to it directly or through
	    a setter method if provided.

	3.	Global Scope and Usage:
	•	Public static variables effectively have a global scope within the project, making them accessible and modifiable
	    from any part of the codebase.
	•	This global accessibility can be convenient for sharing common data or configurations across different components
	    of the project.

	4.	Considerations and Best Practices:
	•	While public static variables offer flexibility and ease of access, they can also lead to potential issues such
	    as unintended modifications and tight coupling between classes.
	•	It’s essential to use public static variables judiciously and consider encapsulation techniques, such as providing
	    getter and setter methods, to control access and modification.

In summary,
public static variables provide global accessibility within a project, allowing them to be accessed and modified from any
part of the codebase.
However, careful consideration and proper management are necessary to avoid potential issues related to unintended
modifications and tight coupling.

________________________________________________________________________________________________________________________

14. Encapsulation, getter and setter methods:
    Encapsulation is a fundamental principle in object-oriented programming (OOP) that involves bundling data (variables)
    and methods (functions) that operate on the data within a single unit, known as a class. It aims to hide the internal
    state of an object and only expose a controlled interface for interacting with it. Getter and setter methods are commonly
    used in encapsulation to provide controlled access to the class’s attributes.

Here’s a deeper explanation of encapsulation and getter/setter methods:

	1.	Encapsulation:
	•	Encapsulation involves bundling the data (attributes or variables) and methods (functions or behaviors) that
	    operate on that data within a single class.
	•	The internal state of an object is hidden from the outside world, and access to it is restricted to methods
	    defined within the class.
	•	This helps in achieving data hiding, abstraction, and modularization, leading to better organization and
	    maintenance of code.

	2.	Getter Methods:
	•	Getter methods, also known as accessor methods, are used to retrieve the values of private attributes (variables)
	    from a class.
	•	These methods typically have a naming convention like getVariableName() and return the value of the corresponding
	    attribute.
	•	Getter methods provide read-only access to the private attributes, allowing other classes to retrieve their values
	    but not modify them directly.

	3.	Setter Methods:
	•	Setter methods, also known as mutator methods, are used to modify the values of private attributes within a class.
	•	These methods typically have a naming convention like setVariableName(value) and accept a parameter to update the
	    value of the corresponding attribute.
	•	Setter methods provide a controlled way to modify the internal state of an object, allowing validation and logic
	    to be applied before updating the attribute.

	4.	Benefits of Encapsulation and Getter/Setter Methods:
	•	Encapsulation protects the internal state of an object from external interference, promoting data integrity and
	    security.
	•	Getter and setter methods provide a controlled interface for accessing and modifying the object’s attributes,
	    enabling better control over how the object’s state is accessed and modified.
	•	Using getter and setter methods allows for easier maintenance and evolution of code, as internal implementations
	    can be changed without affecting external code that relies on the class’s interface.

In summary,
encapsulation, along with getter and setter methods, form the foundation of object-oriented programming by promoting
data hiding, abstraction, and modularity. They help in creating robust, maintainable, and reusable code by providing
controlled access to an object’s internal state.
________________________________________________________________________________________________________________________

15. Why do we need to use getter and setter in a framework for variables?
    In a framework, the use of getter and setter methods for variables provides several benefits related to encapsulation,
    control, and flexibility. Here’s why we need to use getter and setter methods in a framework for variables:

	1.	Encapsulation:
	•	Getter and setter methods encapsulate the access to class variables by controlling how their values are retrieved
	    and modified.
	•	By making variables private and providing public getter and setter methods, we hide the internal state of the
	    class from external classes, promoting data security and integrity.

	2.	Controlled Access:
	•	Getter and setter methods allow us to control access to class variables and enforce rules or logic before allowing
	    modifications.
	•	For example, we can validate input values, perform data transformations, or trigger additional actions when
	    setting or retrieving variable values using getter and setter methods.

	3.	Flexibility and Evolution:
	•	Using getter and setter methods provides a flexible interface for interacting with class variables, allowing us
	    to change internal implementations without affecting external code.
	•	If the internal representation of data changes in the future, we can modify the getter and setter methods to
	    accommodate the changes without impacting other parts of the codebase.

	4.	Debugging and Logging:
	•	Getter and setter methods can be instrumented with debugging or logging logic to track changes to variable values
	    during runtime.
	•	This facilitates troubleshooting and monitoring of the application’s behavior, helping developers identify and
	    resolve issues more effectively.

	5.	Interoperability and Integration:
	•	Getter and setter methods adhere to standard conventions and programming practices, making the framework more
	    interoperable and easier to integrate with other components or libraries.
	•	Other developers working with the framework can easily understand and interact with class variables through
	    well-defined getter and setter methods.

In summary,
using getter and setter methods in a framework for variables enhances encapsulation, provides controlled access to data,
ensures flexibility and evolution, facilitates debugging and logging, and promotes interoperability and integration.
These benefits contribute to the robustness, maintainability, and usability of the framework.

________________________________________________________________________________________________________________________

16. we are creating a getter so that we are limiting direct access to the instance variable, and providing indirect access
    with getters and setters, so we need to create read-only access to the driver instance variable because we don't want
    any classes to set something for this driver, so all classes can read the drive but not modify it.
    The reason is we don't want the driver instance changed in the middle of the Test, Once the driver is opened, it should
    do whatever action we want until it's closed, so no access to writing, only to reading.

    keynotes:
    rationale behind creating read-only access to the driver instance variable using getters:

	1.	Limiting Direct Access:
	•	By making the driver instance variable private and providing only a getter method, we restrict direct access to
	    the variable from other classes.
	•	This prevents external classes from modifying the driver instance directly, reducing the risk of unintended
	    changes or misuse.

	2.	Indirect Access with Getters:
	•	Getter methods allow for indirect access to the driver instance variable by providing a controlled way to retrieve
	    its value.
	•	Other classes can still obtain the driver instance for reading purposes through the getter method, but they cannot
	    modify its value.

	3.	Read-Only Access:
	•	Creating read-only access to the driver instance ensures that classes can only retrieve its value without the
	    ability to modify it.
	•	This is essential in maintaining the integrity and consistency of the testing process, as the driver instance
	    should remain unchanged once initialized for a test scenario.

	4.	Ensuring Test Stability:
	•	By preventing the driver instance from being modified during a test execution, we ensure the stability and
	    reliability of the testing environment.
	•	Once the driver is opened and configured for testing, it should remain unchanged until the test scenario is
	    completed and the driver is closed.

	5.	Preventing Mid-Test Changes:
	•	Prohibiting write access to the driver instance prevents any mid-test changes that could potentially disrupt the
	    flow of the test scenario.
	•	This safeguards against unexpected behavior or errors caused by altering the driver configuration or state during
	    the execution of a test.

In summary,
creating read-only access to the driver instance variable using a getter method helps maintain the stability and integrity
of the testing environment by limiting direct access and preventing mid-test changes. This ensures consistent and reliable
execution of test scenarios without compromising the integrity of the testing process.
________________________________________________________________________________________________________________________

17. Cross Browsing:
    Cross browsing in the context of Cucumber and Selenium refers to the practice of testing web applications across
    multiple web browsers to ensure compatibility and functionality across different browser environments. This involves
    executing the same test scenarios on various web browsers such as Google Chrome, Mozilla Firefox, Microsoft Edge,
    Safari, etc.

Here’s a further explanation of cross browsing in Cucumber Selenium testing:

	1.	Browser Compatibility Testing:
	•	Cross browsing involves testing web applications on different browsers to verify that they render and function
	    correctly across various browser types and versions.
	•	Each web browser may interpret HTML, CSS, and JavaScript slightly differently, leading to variations in layout,
	    styling, and behavior. Cross browsing ensures that the application behaves consistently across these variations.

	2.	Identifying Browser-Specific Issues:
	•	Cross browsing helps in identifying and addressing browser-specific issues or inconsistencies in the application’s
	    behavior.
	•	By testing on multiple browsers, testers can pinpoint any browser-specific bugs or compatibility issues and
	    implement fixes to ensure a seamless user experience across all supported browsers.

	3.	Enhancing User Experience:
	•	Ensuring compatibility across different browsers enhances the overall user experience by providing a consistent
	    and reliable application experience regardless of the browser used.
	•	Users accessing the web application from different browsers should have a similar experience in terms of
	    functionality, performance, and visual presentation.

	4.	Cross Browsing in Cucumber Selenium:
	•	In Cucumber Selenium testing, cross browsing involves writing test scenarios using Cucumber’s Gherkin syntax and
	    executing them across multiple browsers using Selenium WebDriver.
	•	Test scripts are designed to be browser-agnostic(not specific to any particular web browser, and thus capable of
	    working with any web browser without requiring modifications.), allowing them to run seamlessly on different
	    browsers by specifying browser-specific configurations or capabilities.
	•	Selenium WebDriver provides support for interacting with various browsers, enabling testers to automate the
	    execution of test scenarios on different browser environments.

	5.	Regression Testing:
	•	Cross browsing is also an essential aspect of regression testing, where previously tested functionalities are
	    retested across different browsers to ensure that recent changes or updates have not introduced any browser-specific
	    regressions or defects.

In summary,
cross browsing in Cucumber Selenium testing involves verifying the compatibility and functionality of web applications
across multiple browsers to ensure a consistent and reliable user experience across different browser environments. T
his practice helps in identifying and addressing browser-specific issues, enhancing overall application quality and user
satisfaction.

________________________________________________________________________________________________________________________

18. Browser agnostic testing(not specific to any particular web browser, and thus capable of working with any web browser
    without requiring modifications.)
    In the context of software testing, “browser agnostic” refers to the ability of a test or test script to run on any
    web browser without requiring modifications specific to a particular browser. A browser-agnostic test is designed to
    function consistently across different web browsers, regardless of their type, version, or underlying technology.

Here’s a further explanation of browser agnosticism in the context of testing:
	1.	Platform Independence:
	•	Browser-agnostic tests are not tied to a specific browser platform or technology stack. They can run on any browser
	    platform, including Google Chrome, Mozilla Firefox, Microsoft Edge, Safari, etc., without modification.

	2.	Flexibility and Compatibility:
	•	Browser-agnostic tests are compatible with multiple browsers, offering flexibility in test execution across
	    different browser environments.
	•	Test scripts written in a browser-agnostic(not specific to any particular web browser, and thus capable of working
	    with any web browser without requiring modifications.) manner can be executed seamlessly on various browsers,
	    ensuring consistent test coverage and compatibility validation.

	3.	No Browser-Specific Dependencies:
	•	Browser-agnostic tests do not rely on browser-specific features, functions, or behaviors that may vary between
	    different browser implementations.
	•	They are designed to interact with web elements and execute actions in a standardized way that is compatible
	    with all supported browsers.

	4.	Reduced Maintenance Overhead:
	•	By designing tests to be browser agnostic, testers can avoid the need for maintaining separate test scripts or
	    configurations for each supported browser.
	•	This reduces the maintenance overhead associated with updating or adapting tests to accommodate changes in browser
	    versions or technologies.

	5.	Enhanced Portability:
	•	Browser-agnostic tests are portable and can be easily transferred or deployed across different testing environments
	    or infrastructure setups.
	•	They offer consistent test results regardless of the browser environment in which they are executed, enhancing
	    the reliability and reproducibility of test outcomes.

In summary,
browser agnosticism in testing enables tests to be executed seamlessly across multiple web browsers, promoting flexibility,
compatibility, and consistency in test execution. By decoupling tests from specific browser dependencies, testers can ensure
broader coverage and more robust validation of web applications across diverse browser environments.
________________________________________________________________________________________________________________________

19. When we create read-only access(getter) to the driver, that will only allow the using of the driver from other classes
    but cannot be modified from other Sub_classes, in encapsulation, we can just create a getter method if we don't want
    the write access to be accessible by other classes.
    If we create both getter and setter methods for a private variable, we are giving both read and write access to the
    sub_classes of the super_class, even though in inheritance, a sub_class can access all the properties of the super_class
    we can still limit that access however we want by making that property as private so that it can be accessed only
    within the scope of the class it was created in and not the sub_classes or we can limit that access to read-only
    (getter method) or write-only access(setter method) or both getter and setter methods or none at all.

    keynotes:
    concept of encapsulation and the implications of providing read-only or read-write access to class properties through
    getter and setter methods:

	1.	Encapsulation and Access Control:
	•	Encapsulation is the principle of bundling data (properties) and methods (functions) that operate on the data
	    into a single unit, known as a class.
	•	It allows for better control over the accessibility of class members, such as instance variables.

	2.	Getter and Setter Methods:
	•	Getter methods (accessors) are used to retrieve the values of private instance variables.
	•	Setter methods (mutators) are used to modify the values of private instance variables.
	•	By providing getter and setter methods, we control how external classes interact with the private properties of
	    a class.

	3.	Read-Only Access (Getter Method):
	•	If we only provide a getter method for a private variable, we allow read-only access to that variable from other
	    classes.
	•	Other classes can retrieve the value of the variable but cannot modify it directly.
	•	This approach is useful when we want to restrict external classes from modifying the state of an object’s property.

	4.	Read-Write Access (Getter and Setter Methods):
	•	Providing both getter and setter methods gives external classes read-write access to the private variable.
	•	External classes can retrieve the current value of the variable using the getter method and modify its value using
	    the setter method.
	•	This approach allows for more flexibility in interacting with the object’s state but requires careful consideration
	    to maintain data integrity.

	5.	Access Control Modifiers:
	•	In Java, access control modifiers (e.g., private, public, protected) are used to specify the accessibility of class
	    members.
	•	By declaring instance variables as private, we restrict direct access to those variables from outside the class,
	    enforcing encapsulation.
	•	Getter and setter methods can be used to provide controlled access to private variables while maintaining data
	    encapsulation.

In summary,
encapsulation in Java allows us to control the accessibility of class members, including instance variables. By providing
getter and setter methods, we can regulate read-only or read-write access to private variables, ensuring data integrity
and promoting code maintainability. This approach follows the principles of encapsulation and access control in object-oriented
programming.
________________________________________________________________________________________________________________________

20. in a feature file for each scenario we have two common steps which are "Open Browser" and "Close Browser", so if we
    are repeating an action at the beginning and at the end of every scenario not a few, repeatedly and not just once,
    cucumber will say why are we bothering ourself by creating that step definition and repeating that step in the feature
    file, this is when "hooks testing" comes into play, this is one of the abilities of the cucumber framework.
    Hooks are the events that can run before or after scenarios, cucumber has multiple hooks but the most common used
    one are:
    1. @Before: will run before each scenario
    2. @After: will run after each scenario
    these will run before and after scenarios no matter what happens to that scenario or if that scenario passes or fails
    the execution, hooks will attach to the scenario and run before or after scenarios, with the help of the hooks
    we can get rid of the repeated steps that are happening in each scenario, for example, "opening a browser" and "closing
    a browser" steps that are 2 of the repeated steps in each scenario in the feature file.
    Hooks is nothing else but a simple java class that is similar to the step definition class, this class can have any name
    but mostly we can use "HookSteps" as the class name to make it more clear.

    Feature and Scenario only focuses on on the test and not preparing for the test.

________________________________________________________________________________________________________________________

21. Hooks testing in Cucumber:
    Hooks in Cucumber are a feature that allows you to define pre and post-execution actions for scenarios. They provide
    a way to set up and tear down resources before and after scenario execution. Hooks are commonly used for tasks such
    as setting up test data, starting and stopping services, or logging test execution.

Here’s an explanation of hooks testing in Cucumber:

	1.	Pre-conditions and Post-conditions:
	•	Hooks allow you to define actions that should be performed before and after scenario execution.
	•	Pre-hooks are executed before each scenario, while post-hooks are executed after each scenario, regardless of
	    whether the scenario passes or fails.

	2.	Common Use Cases:
	•	Setting up test environment: Hooks can be used to initialize the test environment before scenario execution, such
	    as launching a web browser or connecting to a database.
	•	Data preparation: Hooks can be used to populate test data or set up test fixtures required for scenario execution.
	•	Cleanup tasks: Hooks can be used to clean up resources after scenario execution, such as closing database
	    connections or releasing allocated memory.

	3.	Annotation and Implementation:
	•	In Cucumber, hooks are implemented using annotations such as @Before and @After.
	•	Methods annotated with @Before are executed before each scenario, while methods annotated with @After are executed
	    after each scenario.
	•	These methods can contain code to perform the necessary setup or tear down actions.

	4.	Scope and Order:
	•	Hooks can have different scopes, including scenario scope, feature scope, or global scope.
	•	The order of execution of hooks can be controlled using annotations such as @Before(order) and @After(order),
	    where the order value determines the sequence in which hooks are executed.

	5.	Flexibility and Reusability:
	•	Hooks provide flexibility in managing test execution and can be customized to meet specific testing requirements.
	•	They allow for reusable setup and tear down logic, reducing duplication and improving maintainability of test code.

In summary,
hooks testing in Cucumber enables you to define pre and post-execution actions for scenarios, allowing for setup and
cleanup tasks to be performed automatically before and after scenario execution. This feature enhances the reliability
and efficiency of test execution in Cucumber-based test automation frameworks.

________________________________________________________________________________________________________________________

22.
________________________________________________________________________________________________________________________
23.
________________________________________________________________________________________________________________________
24.
________________________________________________________________________________________________________________________
25.
________________________________________________________________________________________________________________________
26.
________________________________________________________________________________________________________________________
27.
________________________________________________________________________________________________________________________
28.
________________________________________________________________________________________________________________________
29.
________________________________________________________________________________________________________________________
30.
________________________________________________________________________________________________________________________
31.
________________________________________________________________________________________________________________________
32.
________________________________________________________________________________________________________________________
33.
________________________________________________________________________________________________________________________
34.
________________________________________________________________________________________________________________________
35.
________________________________________________________________________________________________________________________
36.
________________________________________________________________________________________________________________________
37.
________________________________________________________________________________________________________________________
38.
________________________________________________________________________________________________________________________
39.
________________________________________________________________________________________________________________________
40.
________________________________________________________________________________________________________________________
41.
________________________________________________________________________________________________________________________
42.
________________________________________________________________________________________________________________________
43.
________________________________________________________________________________________________________________________
44.
________________________________________________________________________________________________________________________
45.
________________________________________________________________________________________________________________________
46.
________________________________________________________________________________________________________________________
47.
________________________________________________________________________________________________________________________
48.
________________________________________________________________________________________________________________________
49.
________________________________________________________________________________________________________________________
50.
________________________________________________________________________________________________________________________
51.
________________________________________________________________________________________________________________________
52.
________________________________________________________________________________________________________________________
53.
________________________________________________________________________________________________________________________
54.
________________________________________________________________________________________________________________________
55.
________________________________________________________________________________________________________________________
56.
________________________________________________________________________________________________________________________
57.
________________________________________________________________________________________________________________________
58.
________________________________________________________________________________________________________________________
59.
________________________________________________________________________________________________________________________
60.
________________________________________________________________________________________________________________________
61.
________________________________________________________________________________________________________________________
62.
________________________________________________________________________________________________________________________
63.
________________________________________________________________________________________________________________________
64.
________________________________________________________________________________________________________________________
65.
________________________________________________________________________________________________________________________
66.
________________________________________________________________________________________________________________________
67.
________________________________________________________________________________________________________________________
68.
________________________________________________________________________________________________________________________
69.
________________________________________________________________________________________________________________________
70.
________________________________________________________________________________________________________________________
*/

}
