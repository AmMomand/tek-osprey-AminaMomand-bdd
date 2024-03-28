package tek.bdd.pages;

import org.openqa.selenium.By;

public class HomePage {

    // Constant Variable POM approach
    // Constant Variable naming convention, all letters Capital and add underscore instead of spaces:
    // these are static final varibales that cannot be changed anymore after the implementation but we can change the value
    // in the class it was created in:
    public static final By TOP_NAV_LOGO = By.className("top-nav__logo");

    public static final By SING_IN_BUTTON = By.id("signinLink");

    public static final By ACCOUNT_LINK = By.linkText("Account");



}
