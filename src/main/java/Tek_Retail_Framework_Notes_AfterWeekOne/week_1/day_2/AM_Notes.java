package Tek_Retail_Framework_Notes_AfterWeekOne.week_1.day_2;

public class AM_Notes {
/*
1. In gherkin language for Cucumber, Given, When and Then are prerequisites before doing any action or achieving a goal.
________________________________________________________________________________________________________________________

2. In Gherkin language, which is used in Cucumber for writing feature files, Given, When, and Then are keywords that help
   structure and define test scenarios in a clear and organized manner. These keywords represent different types of steps
   in a scenario, and they serve specific purposes in defining the behavior of the system being tested:

	1.	Given (prerequisite):
	•	The "Given" keyword is used to set up the initial context or preconditions for the scenario.
	•	It describes the state of the system before the action or event being tested occurs.
	•	Given steps establish the starting point for the scenario and provide the necessary context for the subsequent
	    steps to be executed.

	2.	When (action steps):
	•	The "When" keyword is used to describe the action or event that triggers a change in the system.
	•	It represents the specific behavior or action being performed by the user or the system under test.
	•	When steps define the specific interaction or operation that the scenario is testing.

	3.	Then (validation steps):
	•	The "Then" keyword is used to specify the expected outcome or result of the action described in the When step.
	•	It represents the verification or validation of the system’s behavior after the action has been performed.
	•	Then steps assert the expected state or behavior of the system and verify that it meets the specified criteria.

By using Given, When, and Then steps in Gherkin scenarios, testers and stakeholders can clearly define the sequence of
events, actions, and expected outcomes in a structured and readable format. This approach promotes collaboration between
team members, enhances understanding of the test scenarios, and facilitates automated testing using Cucumber and other
BDD frameworks.
________________________________________________________________________________________________________________________

3. Scenario and scenario outline are the same, but a scenario will be executed on time, but if we have a scenario that should
   run multiple times, with different data, instead of copying and pasting the same scenario but different data, and ending up
   with a long feature file, we can use scenario outfile instead, and add Examples as a data storage box that holds multiple
   data that can be replaced with the value that is a placeholder for the actual values.
   By using Scenario outline, cucumber will execute the entire scenario for each row of data in the Examples box.
   so if we have a column with 5 rows in the Examples box, our scenario will be executed 5 times, but to do that, we have
   to have parameterized methods in step definition's class to be mapped to each step of the scenario that we have, so the
   value can be replaced each time with the next value in queue.
   As many rows as we have, the scenario will be executed one time, the number of rows can be as much as we want, but it's
   recommended not to have lots of rows for one feature file because this will make the feature file more complex than its
   needed.

________________________________________________________________________________________________________________________

4. In Cucumber, we have 3 layers to the Structure of Cucumber:
   1. Feature files: Feature is the functionality we are testing, or the test that is being done or performed, every feature
      file must have at least one scenario, or it'll not work and will be useless.
   2. Step definitions: for every step in the scenario, we should only have one-step definition in the entire project, if we
      have 2-steps definitions for the same test step(steps in feature) the compiler will throw a duplicate step definition
      exception.
   3. Runner: this is the JUnit runner that runs the test without the need for the main method, we have multiple parameters
      inside the CucumberOptions() annotation, some parameters are optional but "feature" and "glue" are necessary
      to be in the parameters.
      Explanation,
    1.	JUnit Runner:
	•	The JUnit runner is a component provided by the JUnit framework that executes tests without the need for a main
	    method.
	•	It allows you to run tests written using JUnit annotations and conventions.
	•	In the context of Cucumber, we use the JUnit runner (@RunWith(Cucumber.class)) to trigger the execution of Cucumber
	    tests.

	2.	CucumberOptions Annotation:
	•	@CucumberOptions annotation is used to provide configuration options for Cucumber tests.
	•	It allows you to customize various aspects of test execution, such as specifying feature files, step definitions,
	    output formats, and more.
	•	Some parameters within @CucumberOptions are optional, while others are required for proper test execution.

	3.	Feature Parameter:
	•	The "features" parameter within @CucumberOptions specifies the location(s) of the feature files that contain the
	    scenarios to be executed.
	•	This parameter is mandatory because it tells Cucumber where to find the feature files that define the behavior to
	    be tested.
	•	Feature files typically have a .feature extension and contain scenarios written in Gherkin syntax.

	4.	Glue Parameter:
	•	The glue parameter within @CucumberOptions specifies the package(s) where Cucumber should look for step definitions.
	•	Step definitions contain the automation logic that maps the steps in feature files to executable code.
	•	This parameter is necessary because it tells Cucumber where to find the Java classes containing step definitions.
	•	Without the glue parameter, Cucumber won’t be able to link the steps in feature files to their corresponding step
	    definitions.

In summary,
the JUnit runner and @CucumberOptions annotation work together to configure and execute Cucumber tests. The features and
glue parameters are essential for defining the location of feature files and step definitions, respectively, ensuring that
Cucumber can find and execute the tests correctly.
________________________________________________________________________________________________________________________

5. Referring to the feature file in @CucumberOptions:
   In Cucumber, to refer to the feature file(s) within the @CucumberOptions annotation, you specify the path to the feature
   file(s) using the features parameter. There are several techniques you can use to specify the path to the feature file(s):

	1.	Absolute Path:
	•	You can provide the absolute path to the feature file(s) on your file system.
	•	Example: features = "/path/to/your/feature/file.feature"

	2.	Relative Path:
	•	You can provide a relative path to the feature file(s) based on the current working directory.
	•	Example: features = "src/test/resources/features/featureFile.feature"

  * 3.	Classpath Resource:
	•	You can provide a classpath resource reference to the feature file(s) using the classpath: prefix.
	•	Example: features = "classpath:features/featureFile.feature"
	•	This technique allows you to reference feature files located within your project’s resources directory.

	4.	Directory Path:
	•	If your feature files are located within a directory, you can specify the path to the directory.
	•	Example: features = "src/test/resources/features"
	•	Cucumber will automatically scan the specified directory for feature files and execute all of them.

	5.	Wildcard Pattern:
	•	You can use wildcard patterns to match multiple feature files based on a common pattern.
	•	Example: features = "src/test/resources/features/*.feature"
	•	This technique allows you to include all feature files within a directory or matching a specific pattern.

Choose the technique that best fits your project structure and organization. Using relative paths or classpath resources
is often preferred as they provide flexibility and portability across different environments and team members.
Additionally, organizing your feature files within a dedicated directory structure helps maintain clarity and organization
in your test suite.
________________________________________________________________________________________________________________________

6. Feature File notes:
   By using the # sign we can comment on a feature file.
   A feature file starts with "Feature:" keyword along with a small description of the entire feature (functionality).
   A Feature is functionality that every application will be created from piece by piece, each piece is a Feature, and
   each of this piece(feature) can have multiple tests that will be run to test the functionality.

   We can have multiple Given, When and Then in our Scenario steps, it all depends on how we break down the user story
   to a scenario, we can have a long "Given" step or divide it in few "Given" steps, it's not recommended to have long
   steps for a scenario for Given, When and Then, it's better to break down long steps into small steps.
   having long or short steps for a scenario is not about readability, it is about how we maintain these steps later on
   and that if we can use these steps for anywhere else or not, also we have to keep in mind that for these long steps
   writing the step definitions in Java language can be challenging, because if even one factor of the step is changed
   in the Feature file, we have to change the step definitions in Java Class too.
   1. Given -> prerequisites
   2. When -> action steps
   3. Then -> validation steps

   we can have a long "Given" step or divide it in many "Given" steps:
   For example a long "Given" step in scenario:
   Given Student name Mohammad Shokriyan in class Osprey with Subject Automation
   Or we can break it down into a few steps like this:
    Scenario: Student result in Subjects.
      Given Student name "Mohammad Shokriyan"
      Given Student class name is Osprey
      Given In Subject Automation
      When Student score is 80
      Then Student result is passed

   the steps for the scenario is in plain English and whatever we want to write as long as the order of step and recognizing
   which is the prerequisites which is the action steps and which is the validation steps.
   for example, if the score for the student is 40, the expectation changes from 80 which was passed to failed.
   so depending on the action we take, the expectations will change.

   as we can see we have 2 scenarios of the same type in one feature file but with different values we can avoid copying
   and pasting the scenarios by just creating a Scenario outline and an Examples box which we can provide different values
   in that, which can be replaces by the placeholder value in the Scenario steps.
   But before we can use the Scenario outline, we have to parameterize the scenario steps from the first scenario in Step
   definitions of a java class


________________________________________________________________________________________________________________________

7. Explanation of the above note:
   	1.	Comments in Feature File:
	•	Comments in feature files can be added using the # symbol.
	•	Comments are used to provide additional context, explanations, or notes within the feature file.
	•	They are ignored during test execution and serve only as documentation for human readers.

	2.	Feature Keyword:
	•	Every feature file begins with the Feature: keyword followed by a brief description of the functionality being tested.
	•	The description provides an overview of the feature and its purpose within the application.
	•	Features represent high-level functionalities or capabilities of the system under test.

	3.	Scenarios and Steps:
	•	Scenarios in feature files describe specific test cases or user interactions with the application.
	•	Each scenario consists of a sequence of steps, typically starting with Given, followed by When, and ending with
	    Then.
	•	Steps are written in plain English and describe the actions, events, or verifications performed during the test.
	•	Scenarios should be concise, focused, and cover a single logical flow or behavior of the application.

	4.	Given-When-Then Structure:
	•	The Given-When-Then structure is used to organize steps within a scenario:
	•	Given: Describes the initial context or prerequisites for the scenario.
	•	When: Represents the action or event that triggers a change in the system.
	•	Then: Specify the expected outcome or validation criteria for the scenario.
	•	Following this structure helps in maintaining clarity and consistency across scenarios.

	5.	Step Length and Readability:
	•	Steps in scenarios can vary in length, but it’s recommended to keep them short and focused.
	•	Long steps can be divided into smaller, more manageable steps to improve readability and maintainability.
	•	Shorter steps are easier to understand, reuse, and maintain in step definition files.

	6.	Scenario Outline and Examples:
	•	Scenario Outline is used to avoid duplicating similar scenarios with different data.
	•	It allows for parameterizing scenarios by replacing placeholder values with actual data.
	•	The Examples table provides different sets of data that are substituted into the scenario outline during execution.
	•	Scenario Outline helps in writing concise and maintainable feature files by promoting reusability and parameterization.

By following these best practices and principles, feature files can effectively document the behavior of the application
and serve as executable specifications for automated testing with Cucumber. They provide a common language for collaboration
between stakeholders, testers, and developers, ensuring that everyone involved understands the intended functionality and
behavior of the system under test.
________________________________________________________________________________________________________________________

8. How to parameterize the Step Definitions and Methods:
   Parameterizing step definitions and methods in Cucumber, allows you to make your tests more flexible and reusable by
   passing dynamic values to them. Here’s how you can parameterize step definitions and methods in Cucumber:

	1.	Using Regular Expressions:
	•	You can use regular expressions to capture dynamic values from the feature file steps.
	•	Define placeholders in your feature file steps using regular expression patterns.
	•	Extract these values in your step definitions using capture groups.
	•	Example:
	•	Feature file step: Given the user with ID "123" is logged in
	•	Step definition: @Given("the user with ID \"(\\d+)\" is logged in")

	2.	Using Scenario Outline and Examples:
	•	If you have scenarios with similar steps but different data, use a Scenario Outline with Examples table.
	•	Define placeholders in your scenario steps within the Scenario Outline.
	•	Provide different sets of data in the Examples table to be substituted into the scenario steps.
	•	Example:
	•	Scenario Outline:
	Given the user with ID "<user_id>" is logged in
    When the user performs action "<action>"
    Then the user should see "<result>"
	•	Examples table:

| user_id | action   | result |
| 123     | view     | success|
| 456     | update   | failure|


	3.	Using Scenario Context or World Object:
	•	Maintain a scenario context or world object that stores dynamic values throughout the scenario execution.
	•	Set these values in one step definition and retrieve them in subsequent step definitions.
	•	This approach is useful when you need to share state across multiple steps within the same scenario.
	•	Example:
public class ScenarioContext {
    private String userId;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}

public class MyStepDefinitions {
    private ScenarioContext scenarioContext;

    public MyStepDefinitions(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Given("the user with ID {string} is logged in")
    public void setUserLoggedIn(String userId) {
        scenarioContext.setUserId(userId);
    }

    @When("the user performs action {string}")
    public void performAction(String action) {
        String userId = scenarioContext.getUserId();
        // Use userId and action to perform the action
    }
}


	4.	Using Test Data Providers or External Sources:
	•	Retrieve dynamic test data from external sources such as property files, databases, or APIs.
	•	Use test data providers or utility methods to fetch and provide dynamic data to your step definitions and methods.
	•	This approach helps in separating test data from test logic and promotes maintainability.
	•	Example:
	•	Use a utility method to fetch user IDs from a database and pass them to step definitions.

By parameterizing your step definitions and methods, you can create more flexible and maintainable tests in Cucumber,
enabling easier test maintenance and reuse. Choose the approach that best fits your testing requirements and project
architecture.

________________________________________________________________________________________________________________________

9. In the feature file, we have to put String values in "" but for int values it's not needed.
________________________________________________________________________________________________________________________
10. When we create steps in the feature file, and we want to run it, we cant run it unless all the steps in the feature file
    have implementation.
    When creating steps in a feature file, it’s essential to provide corresponding implementations in the step definition
    files before running the tests. Here’s why:

	1.	Binding Steps to Implementations:
	•	Each step in a feature file serves as a placeholder for an action or verification that needs to be executed during
	    the test.
	•	Cucumber matches these steps to their corresponding step definitions based on predefined patterns or regular expressions.
	•	Without implementations for all the steps, Cucumber won’t be able to execute the test scenarios because it cannot
	    find a match for the steps in the feature file.

	2.	Ensuring Test Execution:
	•	Cucumber validates the step definitions against the steps in the feature file before executing the tests.
	•	If any step in the feature file lacks an implementation, Cucumber will report it as an undefined step during test
	    execution.
	•	Undefined steps result in test failures or errors, preventing the execution of the test scenarios until all steps
	    have implementations.

	3.	Maintaining Test Completeness:
	•	Having implementations for all steps ensures that the test scenarios are complete and cover all aspects of the
	    feature being tested.
	•	It helps in identifying missing or incomplete test coverage and ensures that all intended behaviors are tested
	    thoroughly.
	•	By enforcing the implementation of all steps, you can maintain the integrity and reliability of your test suite.

In summary,
providing implementations for all steps in the feature file is crucial for ensuring that the test scenarios can be executed
successfully. It helps in binding the steps to their corresponding automation logic and ensures comprehensive test coverage
of the application’s functionality.
________________________________________________________________________________________________________________________

11. dryRun options for runner:
    In Cucumber, the dryRun option in the runner class’s @CucumberOptions annotation is used to perform a quick check of
    the feature files and step definitions without actually executing the test scenarios. When dryRun is set to true,
    Cucumber will scan the feature files and step definitions to ensure that there are no syntax errors or mismatches
    between the steps in the feature files and their corresponding step definitions.

Here’s how dryRun works and its significance:
	1.	Syntax Validation:
	•	When dryRun is enabled, Cucumber only checks the syntax and structure of the feature files and step definitions.
	•	It verifies that all steps in the feature files have matching step definitions in the code.
	•	Any undefined steps or syntax errors in the feature files or step definitions are reported without executing the
	    actual test scenarios.

	2.	Quick Verification:
	•	dryRun allows testers to quickly verify the correctness of their feature files and step definitions before running
	    the full test suite.
	•	It helps catch common mistakes such as missing or mismatched step definitions early in the development process.
	•	This quick verification can save time and effort by identifying issues upfront and preventing test failures during
	    actual execution.

	3.	Performance Considerations:
	•	Since dryRun only performs syntax validation without executing the tests, it is faster than running the full
	    test suite.
	•	It’s particularly useful in scenarios where you want to validate changes to feature files or step definitions
	    quickly without waiting for the entire test suite to execute.

	4.	Usage:
	•	To enable dryRun, you set the dryRun option to true in the @CucumberOptions annotation in the runner class.
	•	Example: dryRun = true

In summary,
dryRun in Cucumber provides a convenient way to perform a quick syntax check of feature files and step definitions without
executing the actual test scenarios. It’s a valuable tool for ensuring the correctness and completeness of your test
suite before running extensive test executions.
________________________________________________________________________________________________________________________

12. We can also use the dryRun option to automatically create the step definition for a step in feature file by adding ""
    around a value that we want to act as replacement then running it from runner with drRun option, then we can copy
    the method for that step from the console shown as error message and make changes to the step definition as required.

    Runner has also another option called dryRun; this will look for the steps that have not been implemented
    when dryRun is true, it'll not do anything but just scan the implementations.
    So if we want the program to run, we either need to delete this option or just change the value to false.

    if a feature file has a step that has not been implemented than that feature file will not be executed.
________________________________________________________________________________________________________________________

13. Shortcut to reformat a feature file in intellij:
    TO reformat the code:
    Option + Command + L
________________________________________________________________________________________________________________________

14. As many rows of data we have, the scenario will be run that many times.
    When using Scenario Outline in Cucumber, each row of data in the Examples table corresponds to a separate execution
    of the scenario. Here’s a further explanation:

	1.	Scenario Execution:
	•	For each row of data in the Examples table, Cucumber generates a separate instance of the scenario.
	•	Each instance of the scenario represents a unique combination of input values provided in the Examples table.
	•	Cucumber executes the scenario once for each row of data, effectively running the scenario multiple times with
	    different input values.

	2.	Data-Driven Testing:
	•	Scenario Outline with Examples table enables data-driven testing, where the same scenario is executed with
	    different sets of test data.
	•	This approach allows testers to validate the behavior of the application against various input conditions and
	    edge cases.
	•	It helps in increasing test coverage and identifying potential issues across different scenarios and data
	    combinations.

	3.	Parameterization:
	•	The placeholders in the Scenario Outline template are replaced by values from the Examples table during scenario
	    execution.
	•	Cucumber substitutes each placeholder with the corresponding value from the current row of data in the Examples
	    table.
	•	This parameterization allows for dynamic generation of scenarios based on the provided input data.

	4.	Iterative Execution:
	•	The number of iterations or executions of the scenario is equal to the number of rows in the Examples table.
	•	If there are N rows of data in the Examples table, the scenario will be executed N times, each time with a
	    different set of input values.
	•	Each execution of the scenario represents a separate test case, allowing testers to validate the application’s
	    behavior under various scenarios.

In summary,
Scenario Outline with Examples table enables iterative execution of scenarios, with each row of data driving a separate
instance of the scenario. This data-driven approach facilitates thorough testing by covering multiple test scenarios and
input conditions.

________________________________________________________________________________________________________________________

15. We can only use Scenario outline after a Scenario, if the second scenario has the exact number of steps, if even
    One step extra, we cannot use Scenario Outline for it.
    When using Scenario Outline in Cucumber, it’s essential to ensure that each scenario within the feature file has the
    same structure and the same number of steps. This limitation arises from the nature of Scenario Outline and its
    associated Examples table.
    Here’s a further explanation:

	1.	Consistent Structure:
	•	Scenario Outline allows you to define a template for scenarios, with placeholders that are filled in by values from
	    an Examples table.
	•	Each scenario must adhere to this template structure, with placeholders replaced by concrete values from the
	    Examples table.
	•	If scenarios have different numbers of steps or a different structure, they cannot be effectively parameterized
	    using Scenario Outline.

	2.	Matching Step Definitions:
	•	Cucumber matches each step in a scenario to its corresponding step definition based on predefined patterns or
	    regular expressions.
	•	For Scenario Outline, Cucumber generates multiple scenarios based on the Examples table, each having the same
	    number of steps and structure.
	•	Step definitions associated with Scenario Outline must be able to handle the parameterized steps consistently
	    across all generated scenarios.

	3.	Examples Table Alignment:
	•	The Examples table provides sets of data to be substituted into the Scenario Outline template.
	•	Each row in the Examples table corresponds to a separate scenario generated by replacing placeholders with values.
	•	All scenarios derived from the same Scenario Outline must have the same number of columns (representing placeholders)
	    in the Examples table.

	4.	Maintaining Consistency:
	•	To use Scenario Outline effectively, ensure that all scenarios within the feature file have a consistent structure
	    and number of steps.
	•	If even one scenario has an extra step or a different structure, it cannot be effectively parameterized using
	    Scenario Outline.
	•	In such cases, consider either refactoring the scenarios to maintain consistency or using regular scenarios
	    without Scenario Outline.

In summary,
the limitation of using Scenario Outline arises from the need for consistency in scenario structure and step count across
all scenarios generated from the same Scenario Outline. Ensuring this consistency allows for effective parameterization
and reusability of steps and step definitions.
________________________________________________________________________________________________________________________

16. 99% of the time, one feature focuses on one application at a time it can be multiple environment but one application
    not all the applications but some do.

________________________________________________________________________________________________________________________

17. Assertion and asserEquals method from JUnit in a cucumber framework:
    In Cucumber framework, assertions are used to verify the expected behavior of the application under test. assertEquals
    method from JUnit is one of the commonly used assertion methods for comparing expected and actual values in automated
    tests.
    Here’s a further explanation:

	1.	Assertion:
	•	An assertion is a statement that verifies whether a certain condition or expectation holds true during test
	    execution.
	•	Assertions are essential in automated testing to validate the correctness of the application’s behavior.
	•	They help in identifying discrepancies between expected and actual outcomes, allowing testers to detect defects
	    and ensure the application’s reliability.

	2.	assertEquals Method:
	•	assertEquals is a method provided by the JUnit testing framework for performing assertion-based comparisons.
	•	It verifies that two values are equal, failing the test if they are not.
	•	The method takes two parameters: the expected value and the actual value to be compared.
	•	If the expected value matches the actual value, the test passes; otherwise, it fails, and an assertion error is
	    raised.

	3.	Usage in Cucumber Framework:
	•	In Cucumber tests, assertions are commonly used within step definitions to validate the expected behavior of the
	    application based on scenario outcomes.
	•	After performing actions or operations in the step definitions, testers use assertions to verify that the application
	    behaves as expected.
	•	assertEquals method can be used to compare actual results returned by the application with the expected results
	    defined in the feature files.
	    Example:

import static org.junit.Assert.assertEquals;

public class MyStepDefinitions {

    @Given("I have a variable {int}")
    public void iHaveAVariable(int number) {
        // Perform some actions to set up the scenario
    }

    @When("I multiply the variable by {int}")
    public void iMultiplyTheVariableBy(int multiplier) {
        // Perform some actions to multiply the variable
    }

    @Then("the result should be {int}")
    public void theResultShouldBe(int expectedResult) {
        // Retrieve the actual result from the application
        int actualResult = getActualResult();

        // Assert that the actual result matches the expected result
        assertEquals(expectedResult, actualResult);
    }

    // Method to simulate getting actual result from the application
    private int getActualResult() {
        // Simulated logic to calculate actual result
        return 10; // Assuming actual result is 10
    }
}

In this example,
assertEquals method is used within the theResultShouldBe step definition to compare the expected result defined in the
feature file with the actual result obtained from the application. If the actual result matches the expected result, the
test passes; otherwise, it fails, indicating a discrepancy in the application’s behavior.

________________________________________________________________________________________________________________________

18. Notes and Explanations for the MajorFunctionalitySteps file section:
    keynotes and Tips:

	1.	Instance Variable Usage:
	•	The ChromeDriver driver variable is declared as an instance variable to be accessible by both methods within the
	    class.
	•	Using an instance variable ensures that the same driver instance is used across multiple steps, maintaining
	    browser state consistency.

	2.	Method Specific Coding:
	•	Each method in the step definition class corresponds to a specific step in the feature file.
	•	Methods are coded only for what is required to fulfill the corresponding step’s functionality, avoiding unnecessary
	    code.

	3.	Parameterization:
	•	Parameterization is used to make steps and methods dynamic, allowing different values to be passed during test
	    execution.
	•	{string} placeholder in the step definition is replaced with actual values provided in the feature file.
	•	Method parameters, such as String expectedTitle, are used to receive and use dynamic values in the step definition
	    code.

	4.	Sharing Instance Variables:
	•	Since methods in the same class do not share local variables, instance variables are used for sharing data between
	    methods.
	•	Changing the local variable ChromeDriver driver to a static instance variable ensures its accessibility across
	    all methods within the class.

	5.	Validation with Assertions:
	•	Assertions are used for validation in automated testing to determine whether expected outcomes match actual results.
	•	Assert.assertEquals(expectedTitle, actualText) ensures that the expected title matches the actual text retrieved
	    from the application.
	•	If the values do not match, the assertion fails, causing the test to fail automatically, indicating a discrepancy
	    in the application’s behavior.

	6.	Browser Cleanup:
	•	Proper browser cleanup is essential to release system resources and maintain test environment cleanliness.
	•	The closeBrowser() method ensures that the browser window is closed after completing the test scenario, preventing
	    resource leaks.

By following these keynotes and tips, you can create effective and maintainable step definitions in your Cucumber test
automation framework. It promotes clarity, reusability, and reliability in your automated tests.
________________________________________________________________________________________________________________________

19.
________________________________________________________________________________________________________________________
20.
________________________________________________________________________________________________________________________
21.
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
