Feature: Major Functionality for smoke Test

  # First Scenario:
  # we only need the necessary and odd step of the scenario, the opening and closing steps are handled by Hooks:
  Scenario: validate Home page title.
    Then Validate top left corner is "TEKSCHOOL"

  # Previously:
  # we put the value as the wrong one to test the failure of the scenario
  # Then Validate top left corner is "TekSchool"
  # if we want to test to pass we need to put the value as "TEKSCHOOL".

  # Second Scenario:
  Scenario: Validate Home page title and SignIn button
    Then Validate top left corner is "TEKSCHOOL"
    Then Validate Sign In button is Enabled

  # Third Scenario:
