package tek.bdd.utility;

import java.util.Random;

// This class will have everything related to the data generation utility class:
public class DataGeneratorUtility {
    public static String randomEmail(String email) {
        Random random = new Random();
        int number = random.nextInt(1000);
        int indexOfAtSign = email.indexOf("@"); // finding the @ sign and then splitting the email into 2 parts.
        String firstPart = email.substring(0, indexOfAtSign);
        String secondPart = email.substring(indexOfAtSign);

        return firstPart + number + secondPart; //-> appending the 2 parts and returning a complete new random email.
    }
    /*
    Explanation:
    This code defines a method named randomEmail that generates a random email address based on a given email.
    Here’s what each part of the method does:

	1.	Random random = new Random();: Creates a new instance of the Random class to generate random numbers.
	2.	int number = random.nextInt(1000);: Generates a random integer between 0 (inclusive) and 1000 (exclusive). This
	    number is used to make the email address unique.
	3.	int indexOfAtSign = email.indexOf("@");: Finds the index of the “@” symbol in the given email address.
	4.	String firstPart = email.substring(0, indexOfAtSign);: Extracts the substring from the start of the email address
	    to just before the “@” symbol. This part represents the username or prefix of the email address.
	5.	String secondPart = email.substring(indexOfAtSign);: Extracts the substring from the “@” symbol to the end of
	    the email address. This part represents the domain name or suffix of the email address.
	6.	return firstPart + number + secondPart;: Combines the first part, random number, and second part to create a new
	    email address. The random number is inserted between the first and second parts to ensure uniqueness.

Overall,
this method takes an email address as input, generates a random number, and constructs a new email address by inserting
the random number between the username and domain parts of the original email address.
     */
}
