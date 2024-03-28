@Regression
Feature: Create New Account Page

  @CreateNewAccount
  Scenario: Create new Account with valid credential
    Given User click on Sign In Button
    Given User click on Create Account
    When User fill Form "Mohammad" and "instructor@tekschool.us" and "123456Ab@"
    When User Click on Sign up button
    Then User will navigate to Account Profile Page
    Then Validate "Mohammad" and email in account page


  @CreateNewAccount_2
  Scenario: Create new Account with valid credential Using Map Data Table
    Given User click on Sign In Button
    Given User click on Create Account
    When User fill up Sign up Form
      | email    | instructor@tekschool.us |
      | password | 123456Ab@               |
      | name     | Mohammad                |
    When User Click on Sign up button
    Then User will navigate to Account Profile Page
    Then Validate "Mohammad" and email in account page


  @CreateNewAccount_3
  Scenario: Create new Account with valid credential Using Map Data Table
    Given User click on Sign In Button
    Given User click on Create Account
    When User fill up Sign up Form With List Data Table
      | Mohammad                |
      | instructor@tekschool.us |
      | 123456Ab@               |
    When User Click on Sign up button
    Then User will navigate to Account Profile Page
    Then Validate "Mohammad" and email in account page


  # List of Maps, means we can have multiple rows of data depending on our needs, each row is a list of data
  @CreateNewAccount_4
  Scenario: Create new Account with valid credential Using List of Maps.
    Given User click on Sign In Button
    Given User click on Create Account
    When User fill up Sign up Form With List Of Map Data Table
      | name | email             | password  |
      | John | john@tekschool.us | 123456Ab@ |
    When User Click on Sign up button
    Then User will navigate to Account Profile Page
    Then Validate "John" and email in account page


# In a list of lists, there are no column names, we have to rely on the order of the data
  @CreateNewAccount_5
  Scenario: Create new Account with valid credential Using List of List.
    Given User click on Sign In Button
    Given User click on Create Account
    When User fill up Sign up Form With List Of List Data Table
      | John | john@tekschool.us | 123456Ab@ |
    When User Click on Sign up button
    Then User will navigate to Account Profile Page
    Then Validate "John" and email in account page