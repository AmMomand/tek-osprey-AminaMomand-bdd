package Tek_Retail_Framework_Notes_AfterWeekOne.week_3.day_1;

public class AM_Notes {

/*
1. When using selenium, Screen shots only apply to the UI(User Interface) only if selenium is used.

________________________________________________________________________________________________________________________

2. Configuration files:
   A configuration file, often referred to as a config file, is a file used to store parameters, settings, or configuration
   data for a software application. It allows developers to separate configuration details from the code, making it easier
   to manage and update settings without modifying the source code.

    Here are some key aspects of configuration files:

	1.	Format: Configuration files can be in various formats, including plain text (such as .ini or .conf files), XML,
	    JSON, YAML, or properties files. Each format has its syntax and rules for defining configuration settings.

	2.	Parameters: Configuration files contain parameters or settings that control the behavior or settings of the
	    application. These parameters can include database connection details, logging levels, feature toggles,
	    environment-specific settings, and more.

	3.	Organization: Configuration files are typically organized hierarchically or into sections to group related settings.
	    This helps to maintain clarity and organization, especially in larger applications with many configuration options.

	4.	Readability: Config files are often designed to be human-readable, making it easy for developers and administrators
	    to understand and modify the settings. Comments are commonly used to provide additional context or explanations
	    for specific settings.

	5.	Location: Configuration files can be located in different directories or locations within an application’s directory
	    structure. They may be stored alongside the application code, in a separate configuration directory, or in system-wide
	    configuration directories.

	6.	Loading and Parsing: The application must have mechanisms to load and parse the configuration file at runtime.
	    This process involves reading the file, parsing its contents, and applying the settings to the application. Many
	    programming languages provide libraries or built-in functionality to handle configuration files.

	7.	Dynamic Updates: In some cases, configuration files support dynamic updates, allowing settings to be modified while
	    the application is running without requiring a restart. This feature is particularly useful for applications that
	    need to adapt to changing conditions or requirements.

Overall,
configuration files play a crucial role in software development by providing a flexible and customizable way to configure
application behavior without altering the code. They promote separation of concerns, improve maintainability, and
facilitate environment-specific configurations.
________________________________________________________________________________________________________________________

3. Parameters in one Step of the Scenario in a feature file:
   For the sake of the quality of the code, it's better not to have more than 6 to 8 parameters in one step even though
   it's possible and can be done.
   That is why Cucumber provides the data tables, these data tables will run for any data to be passed on the steps of the
   scenario.
   data table has 4 different types, Map, List,
________________________________________________________________________________________________________________________

4. Data Table:
In Cucumber, a data table is a way to pass tabular data from a feature file to a step definition. It allows you to define
structured data directly within the Gherkin syntax of a feature file. Data tables are enclosed within vertical bars (|)
and can have multiple rows and columns.

There are four types of data tables commonly used in Cucumber:

	1.	Basic Data Table:
	•	A basic data table consists of rows and columns separated by vertical bars (|).
	•	Each row represents a set of data, and each column represents a data field or attribute.
	•	This type of data table is used to pass simple tabular data to a step definition.
        Example:

        Given the following users:
          | Name   | Age | Gender |
          | Alice  | 30  | Female |
          | Bob    | 25  | Male   |


	2.	Vertical Data Table:
	•	In a vertical data table, each row is represented vertically, with each column separated by a new line.
	•	The data is still structured into rows and columns, but the formatting differs from a basic data table.
	•	This format is useful when the data for each attribute is lengthy or when displaying nested structures.
        Example:

        Given the following users:
          | Name   | Alice  |
          | Age    | 30     |
          | Gender | Female |


	3.	DataTable Transform:
	•	A DataTable transform is a way to convert a data table into a collection of objects in a step definition.
	•	It allows you to map the structured data from the feature file directly to custom objects or data structures in
	    your code.
	•	This approach is useful for handling more complex data structures or when you need to perform data manipulation
	    or validation.
        Example (Java Step Definition):

        @Given("the following users:")
        public void processUsers(DataTable dataTable) {
            List<Map<String, String>> users = dataTable.asMaps();
            // Process the list of users
        }


	4.	Inline Data Table:
	•	An inline data table is used within a step to define a set of data directly without enclosing it in a separate
	    keyword.
	•	It allows you to pass tabular data directly within a step, making the feature file more concise for simple scenarios.
	•	This format is suitable for scenarios where the data is specific to a single step and does not need to be reused
	    elsewhere.
        Example:

        Given the following users:
          | Name   | Age | Gender |
          | Alice  | 30  | Female |
          | Bob    | 25  | Male   |



These types of data tables provide flexibility in representing structured data within feature files, allowing for clearer
and more expressive scenarios. Depending on the complexity of your data and the requirements of your scenarios, you can
choose the appropriate type of data table to use.

Map and List:
While a map and a list are both data structures commonly used to store and manipulate collections of data, they are not
types of data tables in the context of Cucumber feature files. In Cucumber, a data table specifically refers to tabular
data structured within a Gherkin scenario using vertical bars (|) to delineate rows and columns.

	•	Map: A map is a collection of key-value pairs where each unique key maps to a specific value. In Java, for example,
	    you can use HashMap, TreeMap, or LinkedHashMap to implement a map. Maps are useful for associating related pieces
	    of information and accessing values based on their keys.
	•	List: A list is an ordered collection of elements where each element is identified by its index position. In Java,
	    ArrayList and LinkedList are commonly used implementations of lists. Lists are suitable for storing sequences of
	    data that need to be accessed sequentially or iterated over.

While maps and lists can be used to represent structured data in code, they are not directly comparable to the concept
of a data table in Cucumber. In Cucumber, a data table is specifically a tabular representation of data within a Gherkin
scenario, typically used to pass test data or expected outcomes to step definitions.
________________________________________________________________________________________________________________________

5. List of Maps:
   List of Maps means we can have multiple rows of data depending on our needs, each row is a list of data.
   A list of maps is a data structure that combines the features of both lists and maps. It is essentially a collection
   of map objects where each map represents a set of key-value pairs, and the list contains these maps as its elements.

   In Java, for example, you can define a list of maps using the List interface and the Map interface as follows:
   List<Map<String, Object>> listOfMaps = new ArrayList<>();

   Each element in the list is a map object, and you can access individual maps in the list using index notation. Each
   map within the list can contain different sets of key-value pairs, offering flexibility in organizing and storing
   structured data.

   List of maps are commonly used in scenarios where you need to represent a collection of related data where each
   element has multiple attributes or properties, and you want to maintain the order of the elements while still being
   able to access them using key-value pairs.

________________________________________________________________________________________________________________________

6. List of Lists:
   A list of lists is a data structure where each element of the outer list is itself a list. This structure allows you
   to organize and store data in a hierarchical manner, similar to a two-dimensional array.

   In Java, you can define a list of lists using the List interface as follows:
   List<List<String>> listOfLists = new ArrayList<>();

   Each element in the outer list represents an inner list, and you can access individual elements in the inner lists
   using index notation. Each inner list can contain elements of the same type or different types, depending on your
   requirements.

   List of lists are commonly used in scenarios where you need to represent tabular or matrix-like data structures, such
   as storing data from CSV files, database query results, or spreadsheet-like data. They provide flexibility in handling
   structured data and allow for easy manipulation and traversal.

________________________________________________________________________________________________________________________

7. List Of Lists VS List Of Maps:
   When in a feature file, In a list of lists, there are no column names, we have to rely on the order of the data.
   In a list of lists, the data is organized in a sequential manner without any explicit column names. Each inner list
   represents a row of data, and the order of the elements within each inner list corresponds to the columns of the data.
   Here’s an example:
    List<List<String>> listOfLists = new ArrayList<>();
    listOfLists.add(Arrays.asList("John", "Doe", "30"));
    listOfLists.add(Arrays.asList("Jane", "Smith", "25"));

   In this example,
   each inner list represents a row, where the first element is the first name, the second element is the last name, and
   the third element is the age.

   In contrast,
   a list of maps associates each row of data with a set of column names, allowing for more structured access to the data.
   Each map in the list represents a row, where the keys of the map correspond to the column names, and the values
   represent the data in those columns.
   Here’s an example:
    List<Map<String, String>> listOfMaps = new ArrayList<>();
    Map<String, String> row1 = new HashMap<>();
    row1.put("FirstName", "John");
    row1.put("LastName", "Doe");
    row1.put("Age", "30");
    listOfMaps.add(row1);

    Map<String, String> row2 = new HashMap<>();
    row2.put("FirstName", "Jane");
    row2.put("LastName", "Smith");
    row2.put("Age", "25");
    listOfMaps.add(row2);

In this example,
each map represents a row, and the keys (“FirstName”, “LastName”, “Age”) serve as column names, providing a more
structured way to access the data compared to a list of lists.
________________________________________________________________________________________________________________________

8. The best way to use if we are dealing with forms and filling up the forms is a map, because it's easier to implement,
   easier to read, and are reliable, we can just map the values.
   For tables, it's recommended to use Maps
   For Tables, it's recommended to use List of maps
   For confirming the table rows, it's recommended to use List

________________________________________________________________________________________________________________________

9. List Vs Map tables in a cucumber feature file:
   In a Cucumber feature file, both map and list tables have their own advantages and are suitable for different situations.
   Here’s a comparison of the two along with their pros and cons:

   1. List Tables:
   Pros:
	1.	Ordered Data: List tables maintain the order of data entries, making it suitable for scenarios where the sequence
	    of data is important.
	2.	Simplicity: List tables are straightforward and easy to understand, especially for simple data structures.
	3.	No Need for Column Headers: Since list tables rely on the order of entries, there’s no need to define column
	    headers, which can simplify the feature file.

    Cons:
	1.	Limited Flexibility: List tables provide less flexibility compared to map tables because each entry is treated as
	    a single value without any explicit keys.
	2.	Difficulty with Complex Data: For scenarios with complex data structures or when data needs to be referenced by
	    specific names or keys, list tables may not be the best choice.


    2. Map Tables:
    Pros:
	1.	Named Data: Map tables allow data to be organized and accessed using meaningful keys, providing clarity and
	    flexibility in defining and accessing data.
	2.	Ease of Reference: With map tables, data entries can be easily referenced by their keys, making it convenient to
	    retrieve and use specific pieces of information.
	3.	Support for Complex Structures: Map tables can represent more complex data structures, including nested maps,
	    which can be beneficial for scenarios requiring hierarchical or nested data.

    Cons:
	1.	Overhead of Column Headers: Map tables require specifying column headers (keys) for each entry, which adds
	    overhead, especially for simpler data structures.
	2.	Potential for Data Redundancy: In cases where multiple rows contain similar keys (e.g., multiple rows with
	    “name” or “email” keys), there may be redundancy in specifying column headers, leading to larger feature files.

	3. List of Maps:
	Pros:
	1.	Combines Order and Naming: List of maps offers the benefits of both ordered data (via the list) and named data
	    (via the maps), providing a balance between sequence and structure.
	2.	Flexibility: It allows for the representation of more complex data structures compared to list tables alone, as
	    each entry can contain multiple key-value pairs.
	3.	Easy to Access and Iterate: Data can be accessed and iterated over easily using a combination of list and map
	    operations, making it convenient for scenarios with varying levels of complexity.

    Cons:
	1.	Increased Complexity: List of maps can introduce additional complexity, especially for feature files with large
	    or nested data structures, which may require more effort to understand and maintain.
	2.	Potential for Redundancy: Similar to map tables, there’s a risk of redundancy if multiple rows contain similar
	    keys across different maps within the list, potentially leading to larger feature files.


Choosing Between List and Map Tables and List of Maps:

	•	Use list tables when:
	•	Data entries need to be maintained in a specific order.
	•	The data structure is simple and doesn’t require named keys.
	•	There’s a need to represent sequential or ordered data.

	•	Use map tables when:
	•	Data needs to be organized and accessed by meaningful keys.
	•	There’s a need for flexibility in defining complex data structures.
	•	Data entries require clear and distinct identification using keys.

	•	Use list of maps when:
	•	There’s a need to balance between ordered data (maintaining sequence) and named data (organizing by keys).
	•	The scenario requires representing more complex data structures with multiple key-value pairs.
	•	Flexibility in accessing and manipulating data is important, such as iterating over nested structures or
	    performing operations on specific subsets of data.

Ultimately,
the choice between list and map tables depends on the specific requirements of the scenario being described in the feature
file.

In summary,
list of maps provides a middle ground between list tables and map tables, offering a versatile approach for representing
and organizing data in feature files. It’s particularly useful for scenarios where both order and naming are important,
and where data structures require flexibility and complexity. However, it’s essential to consider the potential for increased
complexity and redundancy when using list of maps, especially in larger or more intricate feature files.

________________________________________________________________________________________________________________________

10. Fundamental(Base) of the Framework, we need to make the framework to work with any application and not just a specific
    one, so we have to outsource(Bringing out) the configuration files, this means that bringing out the hard coded parts of
    the codes like, Browser type, URLs, in case the URLs or the Browsers change, we have to make our framework ready and
    acceptable to changes that might occur.
    These parts of the codes that might change based on the environments should not be in the "Base data" classes, these
    should be in the configuration file, Then your framework should read that configuration file and then feed the base data.
    so the base data should be fed through the config files.
    Every Framework has a config (Configuration File); config file has 2 types,
    1. Properties Files
    2. YAML or JSON Files.
    both of them are doing the same thing but different formating and readings, the property file being the most popular
    one.



    The fundamental base of a framework lies in its ability to be adaptable and reusable across different applications
    and scenarios. Outsourcing or externalizing configuration files is a crucial aspect of achieving this flexibility.
    Here’s why it’s important and how it works:

	1.	Adaptability to Changes: By externalizing configuration details such as browser types and URLs, the framework
	    becomes less dependent on hardcoded values within the code. This means that if there are any changes to these
	    configurations, such as switching to a different browser or updating URLs, the framework can easily accommodate
	    these changes without requiring modifications to the core codebase.

	2.	Ease of Maintenance: Separating configuration from the code promotes better organization and simplifies maintenance
	    efforts. Configuration files can be centrally located and managed, making it easier to update settings across the
	    entire framework without needing to navigate through the codebase.

	3.	Reusability Across Projects: A framework with externalized configurations can be reused across multiple projects
	    with minimal modifications. Developers can simply adjust the configuration files to match the requirements of each
	    project, rather than rewriting or refactoring code for each new application.

	4.	Improved Collaboration: Externalizing configurations promotes collaboration among team members, as it provides a
	    clear separation between code logic and configuration settings. Team members can work on different aspects of the
	    framework without stepping on each other’s toes, leading to smoother development workflows.

Overall,
outsourcing configuration files is a fundamental practice in framework development, enabling adaptability, maintainability,
reusability, and collaboration across projects. It ensures that the framework remains robust and agile in the face of
changing requirements and evolving technologies.
________________________________________________________________________________________________________________________

11. Config files in a framework:
    A configuration file is a file used to store parameters, settings, and other configuration data for a software application.
    It helps in separating the configuration details from the application code, making it easier to modify settings without
    altering the code itself.

    There are primarily two types of configuration files:

	1.	Properties Files: These files store configuration data in a key-value pair format. Examples include .properties
	    files in Java.
	2.	YAML or JSON Files: These files use structured formats like YAML (YAML Ain’t Markup Language) or JSON (JavaScript
	    Object Notation) to store configuration data.

    It is necessary to have a configuration file in a framework for several reasons:

	•	Flexibility: Configuration files allow users to customize settings without modifying the source code. This flexibility
	    makes it easier to adapt the framework to different environments or requirements.
	•	Scalability: As the application grows or changes, having a configuration file makes it easier to manage various
	    settings and parameters.
	•	Portability: Configuration files make it easier to deploy the application to different environments or systems
	    without worrying about hard-coded settings.
	•	Maintenance: Separating configuration data from code improves the maintainability of the application. It’s easier
	    to troubleshoot issues, update settings, and manage changes.

Overall, having a configuration file enhances the modularity, flexibility, and maintainability of a framework or application.

________________________________________________________________________________________________________________________

12. In a frameworks, base of that framework should work with different applications and Environments, other parts of the
    framework can be specific to the application or the user stories we have for that application.
    In a framework, the foundation or base should be designed to be versatile and adaptable to different applications
    and environments. This ensures that the framework can be reused across various projects without significant modifications
    to its core components. Here’s why this approach is beneficial:

	1.	Reusability: By creating a flexible and generic foundation, the framework can be reused across multiple projects
	    without reinventing the wheel. This saves time and effort in development.

	2.	Scalability: As the number of projects or applications grows, having a base framework that can accommodate
	    different requirements and environments allows for easier scalability. New features or functionalities can be
	    added without having to redesign the entire framework.

	3.	Consistency: Using a consistent base framework across projects promotes consistency in coding standards, practices,
	    and architecture. Developers familiar with the framework can easily transition between projects, reducing the
	    learning curve.

	4.	Maintenance: A modular and adaptable base framework simplifies maintenance and updates. Changes can be made to
	    specific modules or components without affecting the entire system, reducing the risk of introducing bugs or errors.

	5.	Interoperability: A flexible framework can integrate seamlessly with other tools, libraries, or systems commonly
	    used in software development. This enhances interoperability and compatibility with existing technologies.

Overall,
designing a framework with a versatile and adaptable base ensures long-term sustainability, reusability, and efficiency
across different applications and environments. Specific features or functionalities can then be built on top of this
foundation to address the unique requirements of each project.

________________________________________________________________________________________________________________________

13. How to write a Config file, and the naming conventions:
    Writing a config file involves defining key-value pairs that store configuration settings or parameters used by your
    application or framework. Here’s how you can write a config file along with some naming conventions:

	1.	Choose a Format: Config files can be written in various formats such as properties files (.properties), YAML files
	    (.yaml), JSON files (.json), or XML files (.xml). Choose a format that suits your preferences and the requirements
	    of your project.

	2.	Define Key-Value Pairs: Each configuration parameter should have a corresponding key-value pair. The key represents
	    the name of the parameter, and the value represents its associated setting or value.

	3.	Organize Settings: Organize settings into sections or categories if necessary, especially if your config file
	    contains a large number of parameters. This improves readability and maintainability.

	4.	Use Descriptive Names: Choose descriptive and meaningful names for keys to make it easier to understand their
	    purpose. Avoid using cryptic abbreviations or overly generic names.

	5.	Follow Naming Conventions: Adhere to naming conventions to ensure consistency and clarity throughout the config
	    file. Some common conventions include:
	•	Use lowercase letters for keys and separate words with underscores or hyphens (e.g., max_connections, log_file_path).
	•	Use uppercase letters for constants or values that should not be changed (e.g., DEBUG_MODE = true).
	•	Use comments to provide explanations or context for specific settings.
	•	Group related settings together and use indentation or whitespace for better readability.

	6.	Provide Default Values: When applicable, provide default values for configuration parameters to ensure that your
	    application can function even if certain settings are not explicitly specified in the config file.

	7.	Document: Include documentation or comments within the config file to describe the purpose of each setting, its
	    valid values, and any potential side effects of changing it.

Here’s an example of a simple config file written in the properties file format:

# Application Configuration Settings

# Database Connection Settings
db_host = localhost
db_port = 3306
db_name = my_database
db_user = admin
db_password = password123

# Server Settings
server_port = 8080
server_timeout = 30000

In this example,
each key-value pair represents a specific configuration setting, and comments provide additional context or explanations.
The settings are organized into sections (e.g., Database Connection Settings, Server Settings) for better organization.
________________________________________________________________________________________________________________________

14. How to choose what properties should be used as a configurations in a config file?
    Choosing which properties to include in a config file depends on various factors, including the requirements of your
    application, the environment in which it will run, and the flexibility and maintainability you want to achieve.
    Here are some guidelines to help you decide what properties to use as configurations:

	1.	Environment-specific Settings: Identify settings that may vary across different environments (e.g., development,
	    testing, production). These include database connection details, server URLs, API endpoints, and logging levels.
	    Configuring these settings separately for each environment allows for easy deployment and testing.

	2.	Application Behavior: Consider parameters that affect the behavior or functionality of your application. This may
	    include features toggles, default language/locale, caching configurations, and error handling settings.

	3.	Security: Include properties related to security settings, such as encryption keys, authentication credentials,
	    access control lists (ACLs), and session management parameters. Ensure sensitive information is properly secured
	    within the config file and never committed to version control repositories.

	4.	Performance Tuning: Determine settings that impact the performance of your application, such as connection pool
	    sizes, cache sizes, thread pool configurations, and timeout thresholds. Fine-tuning these parameters can optimize
	    resource utilization and improve overall system performance.

	5.	External Dependencies: Identify properties related to external dependencies or integrations, such as API keys,
	    OAuth tokens, third-party service endpoints, and version numbers. Configuring these settings separately facilitates
	    easier integration with external services and libraries.

	6.	Logging and Monitoring: Include properties for configuring logging levels, log file paths, log rotation policies,
	    and monitoring thresholds. Proper logging and monitoring configurations are essential for debugging, troubleshooting,
	    and maintaining the health of your application.

	7.	User Preferences: Consider settings that allow users to customize their experience, such as theme colors,
	    font sizes, language preferences, and notification settings. Providing configurable options enhances user satisfaction
	    and usability.

	8.	Defaults and Overrides: Define default values for properties that are commonly used across environments or scenarios.
	    Allow for overrides or customization of these defaults to accommodate specific requirements or preferences.

	9.	Documentation and Comments: Document each configuration property with descriptive comments or documentation to
	    explain its purpose, valid values, and potential impacts. Clear documentation helps developers understand the
	    significance of each setting and how to configure them appropriately.

By carefully selecting and organizing configuration properties in your config file, you can effectively manage the behavior,
performance, security, and usability of your application across different environments and use cases. Regularly review
and update your configuration settings as your application evolves to ensure they remain aligned with your current
requirements and best practices.

________________________________________________________________________________________________________________________

15. we can only create an object of a class, if we call its constructor, one class can have one constructor which is the
    default constructor, or we can implement multiple constructors which is called constructor overloading.
    when creating an object of a class, the constructor is being executed, especially in cases of inheritance, when there is
    a super_class involved, when using its properties for the sub_class, the constructor of that super_class is being
    executed, a default constructor is only created when there are no constructors created by the user, if there are
    other constructors, then the defalut constructor is not created nor executed.
    In object-oriented programming, a constructor is a special type of method that is automatically called when an object
    of a class is created. Its main purpose is to initialize the object’s state, allocate memory, and perform any necessary
    setup tasks. Here’s a more detailed explanation of constructors and their role in object creation:

	1.	Default Constructor: Every class in Java has a default constructor, which is automatically provided by the
	    compiler if no other constructors are defined explicitly. This default constructor initializes the object with
	    default values for its instance variables and performs any necessary setup. If you don’t explicitly define a
	    constructor in your class, the default constructor is used.

	2.	Parameterized Constructor: In addition to the default constructor, you can define one or more parameterized
	    constructors in your class. These constructors accept arguments, allowing you to initialize the object with
	    specific values provided at the time of object creation. Parameterized constructors enable flexibility and
	    customization when creating objects, as they allow you to specify initial state based on external input.

	3.	Constructor Overloading: Constructor overloading refers to the practice of defining multiple constructors with
	    different parameter lists within the same class. Each overloaded constructor provides a different way to initialize
	    objects of the class, allowing clients to choose the most appropriate constructor based on their requirements.
	    Overloading constructors is a common practice to provide convenience and flexibility in object creation.

	4.	Execution of Constructors: When you create an object of a class using the new keyword, the constructor corresponding
	    to the object’s class is automatically invoked. If the class inherits from a superclass, the superclass constructor
	    is also executed before the subclass constructor. This process continues recursively up the class hierarchy until
	    the constructor of the topmost superclass (i.e., Object class) is reached.

	5.	Initialization Order: Constructors are responsible for initializing the object’s state, including its instance
	    variables and any superclass members. Initialization order is determined by the sequence of constructor calls in
	    the class hierarchy. Constructors are executed in a top-down order, with superclass constructors being invoked
	    before subclass constructors. This ensures that all parts of the object are properly initialized before it can be
	    used.

Overall,
constructors play a crucial role in object creation and initialization in Java. They allow you to define how objects of
your class are created and initialized, providing flexibility, customization, and consistency in object creation across
your application. Understanding constructors and their behavior is fundamental to effective object-oriented design and
programming.

________________________________________________________________________________________________________________________

16. A default constructor is only created when there are no constructors created by the user, if there are
    other constructors, then the defalut constructor is not created nor executed.
    In Java, a default constructor is only automatically generated by the compiler when there are no other constructors
    defined explicitly in the class. If you provide any constructor, whether it’s a default constructor or a parameterized
    constructor, the compiler will not generate a default constructor for you.

    Additionally,
    if you provide one or more constructors in your class, but you still want to include a default constructor, you must
    define it explicitly in your class. Otherwise, only the constructors you define will be available for object
    instantiation.

    Here’s a summary of the behavior regarding default constructors:

	1.	Automatic Generation: If no constructors are defined in a class, the compiler automatically generates a default
	    constructor with no parameters.

	2.	User-Defined Constructors: If you define one or more constructors in your class (regardless of whether they’re
	    default or parameterized), the compiler does not generate a default constructor.

	3.	Explicit Default Constructor: If you want to include a default constructor in your class, you must define it
	    explicitly, even if you have other constructors defined.

	4.	Execution: The default constructor, if present, is invoked when an object is created using the new keyword without
	    passing any arguments. It initializes the object’s state to default values or performs any necessary setup.

Understanding the behavior of default constructors is important when designing and implementing classes in Java, as it
affects object creation and initialization in your program.
________________________________________________________________________________________________________________________

17. Creating a user-defined constructor for the base class of a framework for configuration file purposes:
    Creating a user-defined constructor in the base class of a framework, especially for configuration file purposes, serves
    several important purposes:

	1.	Initialization: By defining a constructor in the superclass, you can initialize essential variables and
	    configurations needed by the framework before any actions are performed. This ensures that the framework is in a
	    consistent and ready state when it starts executing its methods.

	2.	Encapsulation: The constructor can encapsulate the logic for loading configuration data from external sources such
	    as property files, YAML files, or databases. This helps in keeping the code modular, organized, and easier to maintain.

	3.	Default Settings: The constructor can set default values for configuration parameters if specific values are not
	    provided. This ensures that the framework can still function correctly even if certain configuration parameters
	    are not explicitly specified.

	4.	Preparation for Action: As mentioned, initializing values in the constructor ensures that essential configurations
	    are ready before any actions, such as opening a browser, are performed. For example, the constructor can load
	    browser settings, timeouts, URLs, or other environment-specific configurations needed for subsequent actions.

	5.	Consistency: Having a consistent way to initialize the framework ensures that all parts of the framework start
	    in a known state. This reduces the likelihood of errors or unexpected behavior due to uninitialized or improperly
	    configured components.

Overall,
using a user-defined constructor in the base class of a framework for configuration purposes helps in maintaining a clean
and organized codebase, improves readability, and ensures that the framework is properly initialized and ready for
execution.

________________________________________________________________________________________________________________________

18. //TODO something something:
    The //TODO comment is a special type of comment commonly used by developers to indicate areas of code that require
    attention or further implementation. It stands for “to do” and is often used to mark tasks or improvements that need
    to be addressed in the future.

    Developers can easily search for TODO comments in their codebase to find unfinished tasks or areas that need improvement.
    It helps in organizing and prioritizing development efforts by keeping track of pending work items.
________________________________________________________________________________________________________________________

19. BrowserName-headless in a config file:
    In a configuration file, “headless” refers to a setting or option that enables headless mode for a web browser. Headless
    mode allows the browser to run without a graphical user interface (GUI), meaning it operates in the background
    without displaying the browser window to the user.

    Enabling headless mode can be useful in various scenarios such as automated testing, web scraping, or server-side
    rendering, where there’s no need for the browser to be visible to the user. It can improve performance, reduce
    resource consumption, and facilitate automated processes without human intervention.
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
