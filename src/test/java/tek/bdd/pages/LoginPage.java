package tek.bdd.pages;

import org.openqa.selenium.By;

public class LoginPage {

    public static final By EMAIL_INPUT = By.name("email");

    public static final By PASSWORD_INPUT = By.name("password");

    public static final By LOGIN_BUTTON = By.id("loginBtn");

    public static final By ERROR_MESSAGE = By.cssSelector("div.error");

    public static final By CREATE_ACCOUNT_LINK = By.linkText("Create New Account");

}
