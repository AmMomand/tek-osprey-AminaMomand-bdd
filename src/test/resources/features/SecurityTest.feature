@Regression
Feature: Retail app security test feature.

  Background: Description about the background
    Given User click on Sign In Button

  @Security_Positive
  Scenario Outline: Validate Valid user credential
    When User enter "<username>" and "<password>" and click on Login
    Then User will see Account button on home page.

    Examples:
      | username                     | password    |
      | mohammad_osprey@tekschool.us | 12345678Ab@ |
      | mansoor@gmail.com            | Ruya@2014   |

  @Security_Negative
  Scenario Outline: Validate Sign in with Invalid Credentials
    When User enter "<username>" and "<password>" and click on Login
    Then validate error message "<errorMessage>"

    Examples:
      | username          | password      | errorMessage               |
      | Wrong@gmail.com   | 12345678Ab@   | wrong username or password |
      | mansoor@gmail.com | wrongPassword | wrong username or password |
      | wrong@gamil.com   | wrongPassword | wrong username or password |