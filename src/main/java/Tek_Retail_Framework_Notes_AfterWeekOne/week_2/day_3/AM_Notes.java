package Tek_Retail_Framework_Notes_AfterWeekOne.week_2.day_3;

public class AM_Notes {
/*
1.
Methods we created that can be used in the step definitions:
   getDriver()
   openBrowser()


   clickElement(By locator)
   getElementText(By locator)
   isElementEnabled(By locator)
   sendTextToElement(By locator, String text)
   isElementDisplayed(By locator)
________________________________________________________________________________________________________________________

2. Locators we have created along with page class, that can be used in the step definitions:
   HomePage --> TOP_NAV_LOGO
   HomePage --> SING_IN_BUTTON
   HomePage --> ACCOUNT_LINK

   LoginPage --> EMAIL_INPUT
   LoginPage --> PASSWORD_INPUT
   LoginPage --> LOGIN_BUTTON

   AccountPage --> ACCOUNT_INFORMATION_EMAIL
   AccountPage --> ACCOUNT_INFORMATION_USERNAME
________________________________________________________________________________________________________________________

3. These 2 will be handled by Hooks(@Before and @After) for each scenario:
   opening a browser -> initiateTest()
   closing the browser -> closingTest
________________________________________________________________________________________________________________________

4. substring methods:
   The substring method is a function in many programming languages, including Java, that allows you to extract a portion
   of a string based on its indices. In Java, the substring method is used to create a new string that contains a portion
   of the original string.

Here’s the syntax of the substring method in Java:

String substring (int startIndex)
String substring (int startIndex, int endIndex)

	•	startIndex: The index at which to start extracting characters. The character at this index is included in the
	    substring.
	•	endIndex: (Optional) The index before which to stop extracting characters. The character at this index is not
	    included in the substring. If omitted, the substring includes all characters from the startIndex to the end of
	    the string.

The substring method returns the extracted portion of the string as a new string.

For example:

String str = "Hello, World!";
String substr1 = str.substring(7); // Extracts "World!" from index 7 onwards
String substr2 = str.substring(0, 5); // Extracts "Hello" from index 0 to 4 (inclusive)

In this example, substr1 will contain “World!” and substr2 will contain “Hello”.
________________________________________________________________________________________________________________________

5. Random class:
   The Random class in Java is part of the java.util package and is used to generate pseudorandom numbers. It provides
   methods to generate random integers, longs, floats, doubles, and booleans, as well as to set the seed for the random
   number generation.
   Here are some key points about the Random class:

	1.	Initialization: To use the Random class, you typically create an instance of it using the new keyword.
	Random random = new Random();


	2.	Generation of Random Numbers:
	•	nextInt(): Generates a random integer.
	•	nextLong(): Generates a random long integer.
	•	nextFloat(): Generates a random float.
	•	nextDouble(): Generates a random double.
	•	nextBoolean(): Generates a random boolean value.

	3.	Seeding: You can set the seed value for the random number generator to produce a predictable sequence of random
	    numbers.
	Random random = new Random(123); // Setting seed to 123


	4.	Range: By default, the random number generator produces numbers over the entire range of the respective data type.
	    You can specify a range by using the appropriate overloaded methods or by performing arithmetic operations on the
	    generated random numbers.
	    Here’s an example of using the Random class to generate a random integer between 0 (inclusive) and 100 (exclusive):

	    Random random = new Random();
        int randomNumber = random.nextInt(100); // Generates a random integer between 0 and 99

Overall,
the Random class is commonly used in Java applications for tasks such as generating random numbers for simulations, games,
cryptography, and testing.
________________________________________________________________________________________________________________________

6. There are 2 types of utilities in framework, static or by calling the object of that utility class or interface,
   In a software framework, utilities are often used to encapsulate common functionality or operations that are frequently
   used across different parts of the application. These utilities can be categorized into two main types: static utilities
   and instance-based utilities.

	1.	Static Utilities:
	•	Static utilities consist of static methods that can be called directly using the class name, without the need to
	    create an instance of the utility class.
	•	These utilities are useful for operations that do not require maintaining state or accessing instance-specific data.
	•	They are accessed using the class name followed by the method name.
	•	Example:

public class StringUtils {
    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}

	1.		•	Usage:

boolean empty = StringUtils.isEmpty("Hello"); // Calling static method directly


	2.	Instance-based Utilities:
	•	Instance-based utilities are classes or interfaces that need to be instantiated to use their methods.
	•	They encapsulate functionality that may require maintaining state or accessing instance-specific data.
	•	These utilities are instantiated using the new keyword, and their methods are called through the instance.
	•	Example:

public class MathUtils {
    public int add(int a, int b) {
        return a + b;
    }
}

	2.		•	Usage:

MathUtils mathUtils = new MathUtils(); // Instantiate the utility class
int sum = mathUtils.add(5, 3); // Calling method through the instance



When designing a framework, it’s important to choose the appropriate type of utility based on the requirements of the
functionality being encapsulated. Static utilities are suitable for stateless operations or common operations that do
not require instance-specific data. Instance-based utilities are more appropriate for operations that require maintaining
state or accessing instance-specific data.

________________________________________________________________________________________________________________________

7. String manipulation:
   String manipulation refers to the process of modifying or manipulating strings (sequences of characters) in a
   programming language. This can involve tasks such as concatenation, splitting, extracting substrings, searching for
   specific patterns, replacing characters, and converting case.
   Here are some common string manipulation operations:

   1.	Concatenation: Combining two or more strings together to form a single string.
   Example: "Hello" + " " + "World" results in "Hello World".

	2.	Substring Extraction: Extracting a portion of a string based on specified indices or delimiters.
    Example: "Hello World".substring(6) results in "World".

	3.	Splitting: Dividing a string into substrings based on a delimiter.
    Example: "apple,banana,orange".split(",") results in ["apple", "banana", "orange"].

	4.	Search and Replace: Searching for occurrences of a substring within a string and replacing them with another substring.
    Example: "Hello World".replace("World", "Universe") results in "Hello Universe".

	5.	Case Conversion: Converting the case of characters within a string (e.g., to uppercase or lowercase).
    Example: "Hello World".toUpperCase() results in "HELLO WORLD".

String manipulation
is a fundamental aspect of programming and is commonly used in tasks such as text processing, data parsing, and user
input validation. Most programming languages provide built-in methods or libraries to perform these operations efficiently.
________________________________________________________________________________________________________________________

8. (TakesScreenshot): This is a type cast operator that converts the WebDriver instance into a TakesScreenshot instance.
   The TakesScreenshot interface is provided by Selenium and is implemented by classes that can capture screenshots.
   The TakesScreenshot interface in Selenium WebDriver provides a method to capture screenshots of the current state of
   the web browser or application. This interface is implemented by web browser driver classes such as ChromeDriver,
   FirefoxDriver, EdgeDriver, etc., allowing them to support the capability of taking screenshots.
   The main method provided by the TakesScreenshot interface is:

	•	getScreenshotAs(OutputType<T> target):
	    This method captures a screenshot of the current state of the browser window and returns it as the specified type.
	    The OutputType parameter specifies the format in which the screenshot will be returned, such as File, Bytes, or
	    Base64.

   By using the getScreenshotAs() method with an appropriate OutputType, you can capture screenshots during automated
   test execution for debugging, logging, or reporting purposes. This capability is particularly useful for identifying
   the state of the application at specific points during test execution or when encountering failures.

   Here’s an example of how you might use the TakesScreenshot interface to capture a screenshot in Selenium WebDriver:

    WebDriver driver = new ChromeDriver();
    // Navigate to a webpage
    driver.get("https://www.example.com");

    // Cast the WebDriver instance to TakesScreenshot
    TakesScreenshot screenshotDriver = (TakesScreenshot) driver;

    // Capture the screenshot and save it as a file
    File screenshotFile = screenshotDriver.getScreenshotAs(OutputType.FILE);

// Perform further operations with the screenshot file, such as saving it to a location or attaching it to a test report

By utilizing the TakesScreenshot interface,
Selenium WebDriver provides a convenient way to capture screenshots during automated testing, aiding in diagnosing issues
and enhancing test reports.
________________________________________________________________________________________________________________________

9. equalsIgnoreCase method:
   The equalsIgnoreCase() method is a Java String method used to compare two strings while ignoring differences in case.
   It checks if two strings are equal, regardless of whether the characters are uppercase or lowercase.
   Here’s how the equalsIgnoreCase() method works:

	•	It takes one parameter: another string to compare against.
	•	It returns true if the two strings contain the same characters, ignoring case differences.
	•	It returns false if the two strings are not equal, considering case differences.

For example:

String str1 = "Hello";
String str2 = "hello";

// Using equalsIgnoreCase to compare str1 and str2
boolean result = str1.equalsIgnoreCase(str2);

System.out.println(result); // Output: true

In this example,
even though “Hello” and “hello” are different in case, the equalsIgnoreCase() method returns true because it ignores
case differences when comparing the strings.

________________________________________________________________________________________________________________________

10. ChromeDriver is a specific driver, instead of a specific driver we need to use the interface of the driver which is
    WebDriver.
    Explanation:
    1.	ChromeDriver: ChromeDriver is a specific implementation of the WebDriver interface provided by Selenium WebDriver.
        It is designed specifically for automating interactions with the Chrome web browser. When you instantiate a
        ChromeDriver object, you are creating an instance of the Chrome-specific driver.
	2.	WebDriver interface: WebDriver is an interface provided by Selenium WebDriver that serves as a common interface
	    for all browser-specific drivers (such as ChromeDriver, FirefoxDriver, etc.). It defines a set of methods and
	    behaviors for interacting with web browsers, such as navigating to URLs, finding elements on a page, and performing
	    actions like clicking and typing.
	3.	Using WebDriver interface: Instead of directly instantiating a specific driver like ChromeDriver, it’s recommended
	    to use the WebDriver interface as the reference type. This allows for more flexibility in your code, as you can
	    switch between different browser implementations (e.g., Chrome, Firefox, Edge) without changing the code that
	    interacts with the browser. By coding to the interface rather than the implementation, you adhere to the principle
	    of abstraction and decouple your code from specific browser implementations.

So,
when we say “ChromeDriver is a specific driver,” we mean it’s a concrete implementation of the WebDriver interface tailored
for Chrome. However, to write more maintainable and flexible code, it’s preferable to use the WebDriver interface as the
reference type when interacting with browsers.
________________________________________________________________________________________________________________________

11. Data table:
    A data table in Cucumber is a way to pass tabular data from feature files to step definitions in Gherkin scenarios.
    It allows you to represent structured data, such as input parameters or test data, in a table format directly within
    the feature file. Data tables are typically used when you need to parameterize your scenarios with multiple sets of
    data or when you want to represent data in a more organized and readable manner.

    In Gherkin syntax, a data table is represented using pipe (|) characters to separate columns and new lines to separate
    rows. Each row represents a set of data, and each column represents a different parameter or field.
    For example, consider the following feature file snippet:

    Scenario: Add products to cart
      Given I am on the shopping website
      When I add the following products to my cart:
        | Product   | Quantity |
        | Laptop    | 1        |
        | Headphones| 2        |
        | Mouse     | 1        |
      Then my cart should contain the added products

In this scenario,
the data table after the step “When I add the following products to my cart:” contains three rows, each representing a
product and its quantity. This data table will be passed to the step definition method associated with the step, allowing
you to access and manipulate the data within your test automation code.

Data tables provide a convenient way to parameterize your scenarios and make them more expressive and readable, especially
when dealing with complex or multiple sets of data.
________________________________________________________________________________________________________________________

12. Map:
    In programming, a map is a data structure that stores key-value pairs. It allows you to associate a unique key with
    a corresponding value, enabling efficient retrieval and manipulation of data based on the key. Maps are also known by
    other names in different programming languages, such as dictionaries, associative arrays, or hash maps.

    The key in a map is used to uniquely identify the associated value, and each key must be unique within the map. This
    allows for fast lookup and retrieval of values based on their keys, typically with near-constant time complexity.

    Maps are commonly used for various purposes in software development, including:

	1.	Storing and Retrieving Data: Maps provide an efficient way to store data and retrieve values based on their keys.

	2.	Mapping Relationships: Maps can represent relationships between entities, where the keys represent one entity and
	    the values represent another entity or some associated data.

	3.	Counting and Aggregating: Maps can be used to count occurrences of items or aggregate data based on specific criteria.

	4.	Configuring and Customizing Behavior: Maps are often used to configure or customize behavior in software systems,
	    where keys represent configuration options or settings, and values represent corresponding behaviors or parameters.

	5.	Optimizing Algorithms: Maps play a crucial role in algorithm optimization, such as caching frequently accessed
	    data or memorizing function results to improve performance.

In summary,
a map provides a flexible and efficient way to organize and access data based on keys, making it a fundamental data
structure in many programming scenarios.

Examples:
1.	Storing User Information:
    Map<String, String> userInfo = new HashMap<>();
    userInfo.put("username", "john_doe");
    userInfo.put("email", "john@example.com");
    userInfo.put("age", "30");


2.	Counting Word Frequencies in a Text:
    String text = "The quick brown fox jumps over the lazy dog";
    Map<String, Integer> wordCount = new HashMap<>();
    for (String word : text.split("\\s+")) {
        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
    }


3.	Configuring Application Settings:
    Map<String, String> appSettings = new HashMap<>();
    appSettings.put("theme", "dark");
    appSettings.put("language", "English");
    appSettings.put("fontSize", "16px");


4.	Storing Product Information:
    Map<String, Double> productPrices = new HashMap<>();
    productPrices.put("Laptop", 999.99);
    productPrices.put("Smartphone", 699.99);
    productPrices.put("Tablet", 299.99);


5.	Representing Relationships:
    Map<String, List<String>> friends = new HashMap<>();
    friends.put("John", Arrays.asList("Alice", "Bob", "Charlie"));
    friends.put("Alice", Arrays.asList("John", "Bob"));
    friends.put("Bob", Arrays.asList("John", "Alice"));



These examples illustrate how maps can be used to store various types of data and relationships, such as user information,
word frequencies, application settings, product details, and social connections. Each map uses different key-value pairs
to organize and access the data efficiently.
________________________________________________________________________________________________________________________

13.
________________________________________________________________________________________________________________________
14.
________________________________________________________________________________________________________________________
15.
________________________________________________________________________________________________________________________
16.
________________________________________________________________________________________________________________________
17.
________________________________________________________________________________________________________________________
18.
________________________________________________________________________________________________________________________
19.
________________________________________________________________________________________________________________________
20.
________________________________________________________________________________________________________________________
21.
________________________________________________________________________________________________________________________
22.
________________________________________________________________________________________________________________________
23.
________________________________________________________________________________________________________________________
24.
________________________________________________________________________________________________________________________
25.
________________________________________________________________________________________________________________________
26.
________________________________________________________________________________________________________________________
27.
________________________________________________________________________________________________________________________
28.
________________________________________________________________________________________________________________________
29.
________________________________________________________________________________________________________________________
30.
________________________________________________________________________________________________________________________
31.
________________________________________________________________________________________________________________________
32.
________________________________________________________________________________________________________________________
33.
________________________________________________________________________________________________________________________
34.
________________________________________________________________________________________________________________________
35.
________________________________________________________________________________________________________________________
36.
________________________________________________________________________________________________________________________
37.
________________________________________________________________________________________________________________________
38.
________________________________________________________________________________________________________________________
39.
________________________________________________________________________________________________________________________
40.
________________________________________________________________________________________________________________________
41.
________________________________________________________________________________________________________________________
42.
________________________________________________________________________________________________________________________
43.
________________________________________________________________________________________________________________________
44.
________________________________________________________________________________________________________________________
45.
________________________________________________________________________________________________________________________
46.
________________________________________________________________________________________________________________________
47.
________________________________________________________________________________________________________________________
48.
________________________________________________________________________________________________________________________
49.
________________________________________________________________________________________________________________________
50.
________________________________________________________________________________________________________________________
51.
________________________________________________________________________________________________________________________
52.
________________________________________________________________________________________________________________________
53.
________________________________________________________________________________________________________________________
54.
________________________________________________________________________________________________________________________
55.
________________________________________________________________________________________________________________________
56.
________________________________________________________________________________________________________________________
57.
________________________________________________________________________________________________________________________
58.
________________________________________________________________________________________________________________________
59.
________________________________________________________________________________________________________________________
60.
________________________________________________________________________________________________________________________
61.
________________________________________________________________________________________________________________________
62.
________________________________________________________________________________________________________________________
63.
________________________________________________________________________________________________________________________
64.
________________________________________________________________________________________________________________________
65.
________________________________________________________________________________________________________________________
66.
________________________________________________________________________________________________________________________
67.
________________________________________________________________________________________________________________________
68.
________________________________________________________________________________________________________________________
69.
________________________________________________________________________________________________________________________
70.
________________________________________________________________________________________________________________________
*/

}
