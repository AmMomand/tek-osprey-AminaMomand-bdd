package tek.bdd.pages;

import org.openqa.selenium.By;

public class AccountProfilePage {
    public static final By YOUR_PROFILE_TEXT = By.className("account__personal-title");
    public static final By PROFILE_NAME_TEXT = By.xpath("//h1[@class='account__information-username']");
    public static final By PROFILE_EMAIL_TEXT = By.xpath("//h1[@class='account__information-email']");
}
