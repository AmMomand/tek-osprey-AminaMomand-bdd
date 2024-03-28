package tek.bdd.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.bdd.base.BaseSetup;

import java.time.Duration;

// according to the design of the framework, "SeleniumUtilities" class should inherit the "BaseSetup" class which has all
// the properties needed for the driver and the read-only(getter method) that we need to work with.
// to use inheritance, we use the "extend" keyword for classes, "implement" keyword is used for interfaces and not classes.
public class SeleniumUtilities extends BaseSetup {

// we mostly repeat the WebDriverWait in every method that is not a good thing, to avoid that problem, we need to create
// a method that returns the webDriverWait, this can be public or private:
// so now whenever we need the WebDriverWait we can just use this getWait method:
    public WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        return wait;

    }

// Activity:
// In selenium utilities, create a method that takes By object and click on the element.

// creating a public method and making the method as void because we are not expecting anything in return from this method,
// creating the method as to parameterize it to take the value of a By object, any locator, find that locator and click on
// that element:
    public void clickElement(By locator){
    // we need to apply wait method to every code in the method:
    // since we made the "driver" as private, we can't access it directly and add to the wait method, we need to call the
    // getter method for that driver which is read-only:

        // since we have created the By object within the parameter of the method, we can just call the variable created
        // for that By object, instead of using the "By.Locator" again:
        // we created a method for the WebDriverWait so we can just use that instead of creating the Object of it again.
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();

    }

    // Creating a method that will return us the text:
    public String getElementText(By locator){
        String text = getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
        return text;

    }

    public boolean isElementEnabled(By locator){
        boolean isEnabled = getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).isEnabled();
        return isEnabled;

    }

    public void sendTextToElement(By locator, String text) {
        getWait().until(
                        ExpectedConditions.visibilityOfElementLocated(locator))
                .sendKeys(text);
    }

    public boolean isElementDisplayed(By locator) {
        return getWait().until(ExpectedConditions
                        .visibilityOfElementLocated(locator))
                .isDisplayed();
    }



}
