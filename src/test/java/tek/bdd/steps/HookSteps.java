package tek.bdd.steps;

//-> Hooks are the events that can run before or after scenarios
// According to the design of the framework that we are using; Hook class will be extended to the SeleniumUtilities class,
// Which means the SeleniumUtilities class is the Super_class and the Hook class will be the Sub_class.
// So now this class can access the properties of the SeleniumUtilities class

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import tek.bdd.utility.SeleniumUtilities;

public class HookSteps extends SeleniumUtilities {

// First, we need to open the Browser, so we are going to create a method to do that and then annotate the method with
// @Before method from Hooks, we need to be careful about which "Before" are we importing because importing the wrong
// Before method will cause problems, we need to import the Before method from "io.cucumber.java" and not "org.junit".
// Hook that runs before each scenario:
@Before
    public void initiateTest(){
    // Importing the openBrowser method from the parent class(BaseSetup) to avoid rewriting the method all over and taking
    // advantage of the inheritance concept, we can access this method, since its public method:
    openBrowser();

    }
// Hook that runs after each scenario, even if the scenario fails, this will clean up the test:
@After
    public void closingTest(Scenario scenario){
    // taking screenshot before the browser is closed, creating object of takes screenshot, and casting our driver
    if(scenario.isFailed()) { //--> only take a screenshot if the scenario is failed, otherwise just quit the browser.
        TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        byte[] capture = screenshot.getScreenshotAs(OutputType.BYTES);

        scenario.attach(capture, "image/png", "screenshot");
    }
    // closing the browser, if that driver is initiated, closes the Browser no matter what happens to the scenario:
    // this method is enough for now but can be improved in the future if needed.
    getDriver().quit();
}
/*
Explanation of the @After method:
    1.	@After: This annotation marks the method as an “after hook,” which means it will be executed after each scenario
        in the Cucumber test.

	2.	public void closingTest(Scenario scenario): This is the method signature for the closingTest method, which takes
	    a Scenario object as a parameter. The Scenario object represents the current scenario being executed in the test.

	3.	if (scenario.isFailed()) { ... }: This condition checks if the current scenario has failed. If the scenario has
	    failed, the code inside the block will be executed to take a screenshot.

	4.	TakesScreenshot screenshot = (TakesScreenshot) getDriver();: This line creates an object of type TakesScreenshot
	    by casting the WebDriver instance (obtained using getDriver()) to the TakesScreenshot interface. This allows
	    capturing screenshots using the WebDriver instance.

	5.	byte[] capture = screenshot.getScreenshotAs(OutputType.BYTES);: This line captures a screenshot of the current
	    state of the browser window and stores it as a byte array (byte[]). The screenshot is obtained using the
	    getScreenshotAs() method of the TakesScreenshot interface, specifying the output type as OutputType.BYTES.

	6.	scenario.attach(capture, "image/png", "screenshot");: This line attaches the captured screenshot to the current
	    scenario. The attach() method is used to attach additional data (in this case, the screenshot) to the scenario.
	    The screenshot data (byte array), MIME type (image/png), and a description (screenshot) are provided as parameters.

	7.	getDriver().quit();: This line closes the browser window by calling the quit() method on the WebDriver instance
	    obtained using getDriver(). This ensures that the browser is closed after the scenario execution, regardless of
	    whether the scenario passed or failed.

Overall,
this code segment ensures that a screenshot is taken and attached to the scenario if the scenario fails, and it closes
the browser window after each scenario execution. This helps in capturing evidence of failures and maintaining clean
test environment between scenarios.
 */

}
