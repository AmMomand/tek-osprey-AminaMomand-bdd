package tek.bdd.steps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tek.bdd.pages.AccountProfilePage;
import tek.bdd.pages.LoginPage;
import tek.bdd.pages.SignUpPage;
import tek.bdd.utility.DataGeneratorUtility;
import tek.bdd.utility.SeleniumUtilities;

import java.util.List;
import java.util.Map;
public class CreateAccountSteps extends SeleniumUtilities {
    private String generatedRandomEmail;

    @Given("User click on Create Account")
    public void user_click_on_create_account() {
        clickElement(LoginPage.CREATE_ACCOUNT_LINK);
    }

    @When("User fill Form {string} and {string} and {string}")
    public void user_fill_form_and_and(String name, String email, String password) {
        // calling the static method to generate a random email:
        generatedRandomEmail = DataGeneratorUtility.randomEmail(email);

        sendTextToElement(SignUpPage.NAME_INPUT, name);
        sendTextToElement(SignUpPage.EMAIL_INPUT, generatedRandomEmail);
        sendTextToElement(SignUpPage.PASSWORD_INPUT, password);
        sendTextToElement(SignUpPage.CONFIRM_PASSWORD_INPUT, password);
    }

    @When("User fill up Sign up Form")
    public void user_fill_up_sign_up_form(DataTable dataTable) {
        //Step 1) Converting Data Table to Map.
        // when using asMap() this means that this is a single map and not a collection of maps.
        Map<String, String> data = dataTable.asMap();
        String email = data.get("email");
        String name = data.get("name");
        String password = data.get("password");

        generatedRandomEmail = DataGeneratorUtility.randomEmail(email);

        sendTextToElement(SignUpPage.NAME_INPUT, name);
        sendTextToElement(SignUpPage.EMAIL_INPUT, generatedRandomEmail);
        sendTextToElement(SignUpPage.PASSWORD_INPUT, password);
        sendTextToElement(SignUpPage.CONFIRM_PASSWORD_INPUT, password);
    }

    @When("User fill up Sign up Form With List Of Map Data Table")
    public void user_fill_up_sign_up_form_with_list_of_map_data_table(DataTable dataTable) {
        //Converting data table to List of maps. asMaps()
        // when using asMaps(), this means that it's a collection of maps
        List<Map<String, String>> data = dataTable.asMaps();
        //Extract first row Data
        // if we have multiple rows, we need to loop through them to get the data
        Map<String, String> dataMap  = data.get(0);

        String email = dataMap.get("email");
        String name = dataMap.get("name");
        String password = dataMap.get("password");

        generatedRandomEmail = DataGeneratorUtility.randomEmail(email);

        sendTextToElement(SignUpPage.NAME_INPUT, name);
        sendTextToElement(SignUpPage.EMAIL_INPUT, generatedRandomEmail);
        sendTextToElement(SignUpPage.PASSWORD_INPUT, password);
        sendTextToElement(SignUpPage.CONFIRM_PASSWORD_INPUT, password);
    }

    @When("User fill up Sign up Form With List Data Table")
    public void user_fill_up_sign_up_form_with_list_data_table(DataTable dataTable) {
        //This Example used List of Data. Converting Data table to List.
        List<String> data = dataTable.asList();
        String name = data.get(0);
        String email = data.get(1);
        String password = data.get(2);


        generatedRandomEmail = DataGeneratorUtility.randomEmail(email);

        sendTextToElement(SignUpPage.NAME_INPUT, name);
        sendTextToElement(SignUpPage.EMAIL_INPUT, generatedRandomEmail);
        sendTextToElement(SignUpPage.PASSWORD_INPUT, password);
        sendTextToElement(SignUpPage.CONFIRM_PASSWORD_INPUT, password);

    }

    @When("User fill up Sign up Form With List Of List Data Table")
    public void user_fill_up_sign_up_form_with_list_of_list_data_table(DataTable dataTable) {
        //Convert data table to List of List asLists().
        List<List<String>> rawData = dataTable.asLists();
        //Extracting the first row of List
        List<String> data = rawData.get(0);

        // since list of list doest not have column names, we have to rely on the order of the data in the list, so we
        // use indexes of the data, which provides the location of the data in the table:
        // | John | john@tekschool.us | 123456Ab@ |
        //     0          1                2
        String name = data.get(0);
        String email = data.get(1);
        String password = data.get(2);

        generatedRandomEmail = DataGeneratorUtility.randomEmail(email);

        sendTextToElement(SignUpPage.NAME_INPUT, name);
        sendTextToElement(SignUpPage.EMAIL_INPUT, generatedRandomEmail);
        sendTextToElement(SignUpPage.PASSWORD_INPUT, password);
        sendTextToElement(SignUpPage.CONFIRM_PASSWORD_INPUT, password);
    }


    @When("User Click on Sign up button")
    public void user_click_on_sign_up_button() {
        clickElement(SignUpPage.SIGN_UP_BUTTON);
    }

    @Then("User will navigate to Account Profile Page")
    public void user_will_navigate_to_account_profile_page() {
        boolean isDisplayed = isElementDisplayed(AccountProfilePage.YOUR_PROFILE_TEXT);
        Assert.assertTrue(isDisplayed);
    }

    @Then("Validate {string} and email in account page")
    public void validate_and_in_account_page(String expectedName) {
        String actualName = getElementText(AccountProfilePage.PROFILE_NAME_TEXT);
        Assert.assertEquals(expectedName, actualName);

        String actualEmail = getElementText(AccountProfilePage.PROFILE_EMAIL_TEXT);
        Assert.assertEquals(generatedRandomEmail, actualEmail);
    }

}
/*
Explanations of some parts of the code:
Part 1:
        List<List<String>> rawData = dataTable.asLists();
        //Extracting first row of List
        List<String> data = rawData.get(0);

        String name = data.get(0);
        String email = data.get(1);
        String password = data.get(2);

This code snippet is extracting data from a Cucumber data table, converting it to a list of lists, and then retrieving
values from the first row of the list.

Here’s a breakdown of each line:

	1.	List<List<String>> rawData = dataTable.asLists();:
	•	This line converts the Cucumber data table (dataTable) into a list of lists (rawData). Each inner list represents
	    a row of data from the data table.
	•	Each element of the inner lists is of type String.

	2.	List<String> data = rawData.get(0);:
	•	This line retrieves the first row of the list of lists (rawData) and stores it in a separate list called data.
	•	rawData.get(0) fetches the first inner list from rawData, which corresponds to the first row of the data table.

	3.	String name = data.get(0);:
	•	This line extracts the first element (column) from the data list and assigns it to the variable name.
	•	The index 0 represents the first element in the data list, which corresponds to the first column of the data table.

	4.	String email = data.get(1);:
	•	This line extracts the second element (column) from the data list and assigns it to the variable email.
	•	The index 1 represents the second element in the data list, which corresponds to the second column of the data table.

	5.	String password = data.get(2);:
	•	This line extracts the third element (column) from the data list and assigns it to the variable password.
	•	The index 2 represents the third element in the data list, which corresponds to the third column of the data table.

Overall,
these lines of code extract data from a Cucumber data table, assuming it has at least one row, and assign the values from
the first row to specific variables (name, email, password).
________________________________________________________________________________________________________________________

Part 2:
        List<Map<String, String>> data = dataTable.asMaps();
        Map<String, String> dataMap  = data.get(0);

        String email = dataMap.get("email");
        String name = dataMap.get("name");
        String password = dataMap.get("password");

This code snippet is extracting data from a Cucumber data table, converting it to a list of maps, and then retrieving
values from the first row of the list.

Here’s a breakdown of each line:

	1.	List<Map<String, String>> data = dataTable.asMaps();:
	•	This line converts the Cucumber data table (dataTable) into a list of maps (data).
	•	Each map in the list represents a row of data from the data table, where the keys are the column headers (names)
	    from the data table, and the values are the corresponding cell values.

	2.	Map<String, String> dataMap  = data.get(0);:
	•	This line retrieves the first map (row) from the list of maps (data) and stores it in a separate map called dataMap.
	•	data.get(0) fetches the first map from the data list, which corresponds to the first row of the data table.

	3.	String email = dataMap.get("email");:
	•	This line retrieves the value associated with the key "email" from the dataMap map and assigns it to the variable
	    email.
	•	The key "email" corresponds to the column header (name) from the data table.

	4.	String name = dataMap.get("name");:
	•	This line retrieves the value associated with the key "name" from the dataMap map and assigns it to the variable
	    name.
	•	The key "name" corresponds to another column header (name) from the data table.

	5.	String password = dataMap.get("password");:
	•	This line retrieves the value associated with the key "password" from the dataMap map and assigns it to the
	    variable password.
	•	The key "password" corresponds to yet another column header (name) from the data table.

Overall,
these lines of code extract data from a Cucumber data table, assuming it has at least one row, and assign the values from
the first row to specific variables (name, email, password). This approach is useful for handling data tables with named
columns.
________________________________________________________________________________________________________________________

Part 3:
        List<Map<String, String>> data = dataTable.asMaps();
        Map<String, String> dataMap  = data.get(0);

        String email = dataMap.get("email");
        String name = dataMap.get("name");
        String password = dataMap.get("password");

This code snippet also extracts data from a Cucumber data table, but it directly retrieves values using named keys from
the first row of the data table.

Here’s a breakdown:

	1.	List<Map<String, String>> data = dataTable.asMaps();:
	•	This line converts the Cucumber data table (dataTable) into a list of maps (data), where each map represents a
	    row of data.
	•	Each map in the list contains key-value pairs, where the keys are column headers (names) from the data table,
	    and the values are the corresponding cell values.

	2.	Map<String, String> dataMap = data.get(0);:
	•	This line retrieves the first map (row) from the list of maps (data) and stores it in a separate map called dataMap.
	•	data.get(0) fetches the first map from the data list, representing the first row of the data table.

	3.	String email = dataMap.get("email");:
	•	This line retrieves the value associated with the key "email" from the dataMap map and assigns it to the variable
	    email.
	•	The key "email" corresponds to the column header (name) from the data table.

	4.	String name = dataMap.get("name");:
	•	This line retrieves the value associated with the key "name" from the dataMap map and assigns it to the variable
	    name.
	•	The key "name" corresponds to another column header (name) from the data table.

	5.	String password = dataMap.get("password");:
	•	This line retrieves the value associated with the key "password" from the dataMap map and assigns it to the
	    variable password.
	•	The key "password" corresponds to yet another column header (name) from the data table.

Similar to the previous example,
this code snippet extracts data from a Cucumber data table, assuming it has at least one row, and assigns the values from
the first row to specific variables (name, email, password). This approach is useful for handling data tables with named
columns.
________________________________________________________________________________________________________________________

 */