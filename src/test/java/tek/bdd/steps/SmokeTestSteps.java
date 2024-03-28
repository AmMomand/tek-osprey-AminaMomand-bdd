package tek.bdd.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.bdd.pages.HomePage;
import tek.bdd.utility.SeleniumUtilities;

import java.time.Duration;

// According to the design of our framework that we are using, each step definition class is require d to be extended to
// the parent_class of SeleniumUtilities class to inherit properties from that parent_class:
public class SmokeTestSteps extends SeleniumUtilities {

    // Implementing the method for the step definition in the feature file for the scenario step:
    // every step definition should have the "void" return type because there is no return for these methods.
    // Also, all of these methods of the step definitions should have a public access type so that are visible to the
    // Cucumber and JVM library.
    @Then("Validate top left corner is {string}")
    public void validateTopLeftCorner(String expectedTitle){
        // all we have to do is to get the text and use assertions to validate if the expected title is equal to the actual
        // title (outcome):
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        // using the method created in the parent_class for the WebDriverWait instead of repeating the object creation:
        // and withing the parameters of that DriverWait method, we should provide the By Object:

        // we made the element locator as a final static variable that cannot be changes so we can call that variable by
        // using the className.VariableName:
        String actualTitle = getElementText(HomePage.TOP_NAV_LOGO);

        // Validation using Assertion:
        Assert.assertEquals(expectedTitle, actualTitle);


    }

    @Then("Validate Sign In button is Enabled")
    public void validateSignInButtonIsEnabled() {
        boolean isButtonEnabled = isElementEnabled(HomePage.SING_IN_BUTTON);
        Assert.assertTrue(isButtonEnabled);

    }


}
