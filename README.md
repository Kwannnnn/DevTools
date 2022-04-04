# DHIV2.So 2 - Java Project

Authors:
* Kristiyan Tenev - 449302
* Quan Nguyen - 490848

## 1. Checkstyle Configuration

### 1.1. Method Length

Lengthy methods tend to become too complex and that makes them difficult to understand. This checkstyle prevents that by setting the maximum length for a method to **60 lines**, enforcing breaking long methods into individual methods that focus on a specific task.

***Note:** empty lines do not count to the total amount of lines*

### 1.2. Constant Names

An well-known Java convention is that constants should be all uppercase with words separated by underscores. We decided to stick to that convention and enforce it to our configuration.

##### Accepted examples
```java
public static final String CONSTANT = "Good constant";
public static final String GOOD_CONSTANT = "Another good constant";
private static final String GOOD_PRIVATE_CONSTANT = "A good PRIVATE constant";
protected static final int PROTECTED_CONST = 37;
```

##### Not accepted examples
```java
public static final String constant = "A bad constant";
public static final String bad_CONSTANT = "Another bad constant";
```

### 1.3. Braces

#### 1.3.1. Left Curly Brace
In Java the block opening curly brace belongs on the same line as the class or function declaration. This checkstyle enforces this convention (sorry C# lads), and to increase readability there can be maximum 100 characters (including spaces) on the line the curly brace belongs to.

##### Accepted examples
```java
public static void main(String[] args) {
    // This example is completely valid
}
```

```java
public void veryLongLine(String veryLongVariableName1,
    String veryLongVariableName2,
    String veryLongVariableName2) {
    // This is is also a valid example, since the line
    // the opening curly brace is has less than 100 characters
}
```

##### Not accepted exampless
```java
public static void main(String[] args)
{
    // This is not a valid example, since the opening curly brace is
    // on a separate line
}
```

```java
public void veryLongLine(String veryLongVariableName1, String veryLongVariableName2, String veryLongVariableName2) {
    // This is not a valid example, since the opening curly brace is
    // on a line with more than 100 characters
}
```

#### 1.3.2. Right Curly Brace

The closing curly brace should be alone on a line. This checkstyle increases readability. Exceptions to this rule:

* **try ... catch ... finally** blocks
* **if ... else (if)** blocks

##### Accepted examples
```java
public static void main(String[] args) {
    String name = args[0];

    if(name.length > 32) {
        System.out.println("Name is too long!");
    // OK - else statement is an exception
    } else if(name.length < 3) {
        System.out.println("Name is too short!");
    // OK - else statement is an exception
    } else {
        System.out.println("Hello, " + name);
    } // OK
} // OK
```

##### Not accepted examples
```java
public static void main(String[] args) {
    System.out.println("Hello world!"); } /* NOT OK - Closing brace
                                             is on the same line as
                                             the last statement */
```

```java
public static void main(String[] args) {
    System.out.println("Hello world!");
// NOT OK - Closing brace is not the only character on the line
} private boolean isValid() {
    return false;
}
```

### 1.4. Indentation

### 1.5. One Statement Per Line

This checkstyle prevents having multiple statements on the same line. There are two main reasons for this: it is very difficult to read, and in case of an exception it might become difficult to trace.

##### Accepted examples
```java
public static void main(String[] args) {
    int a = 0;
    boolean b = true;
    char c = 'c';
}
```

##### Not accepted examples
```java
public static void main(String[] args) {
    int a = 0; boolean b = true; char c = 'c';
}
```

### 1.6. If Nesting

Deeply nested code becomes very difficult to read and maintain. This configuration enforces a maximum level of if depth of 1, meaning that there can be only one if statement inside an if statement.

##### Accepted examples
```java
public static void main(String[] args) {
    if(true) { // 0
        if(true) { // 1
            // OK
        }
    }
}
```

##### Not accepted examples
```java
public static void main(String[] args) {
    if(true) { // 0
        if(true) { // 1
            if(true) { // 2
                // NOT OK - nested if-else depth is 2
                // max depth alloweed is 1
            }
        }
    }
}
```

### 1.7. Switch Default Case

This checkstyle ensures that a switch statement contains a default clause. This is done to prevent the program to crash if the argument to the switch statement is not handled by any of the cases.

##### Accepted examples
```java
public void handleCommand(String command) {
    return switch(command) {
        case "SAVE" -> handleSave();
        case "OK" -> handleOk();
        case "CANCEL" -> handleCancel();
        default -> throw new IllegalArgumentException(); // OK
    }
}
```

##### Not accepted examples
```java
public void handleCommand(String command) {
    return switch(command) {
        case "SAVE" -> handleSave();
        case "OK" -> handleOk();
        case "CANCEL" -> handleCancel();
        // NOT OK - default case is missing
    }
}
```

### 1.8. JavaDoc 

Documentation is a very important aspect of programming. This configuration checks whether all public methods have JavaDoc generated.

### 1.9. 

### 1.10.

## 2. Spotbugs - Custom bugs
The following bugs were intentionally added to test the functionalities of SpotBugs according to the given assignment. Of course, after adding them to the code and having a report generated, the bugs were removed so as not to break the build. 

The report file with introduced bugs can be found [here](doc/spotbugs.html).

### 2.1. Unread field
A variable `unreadVar` of type `String` was declared inside the `BookCase` class. However, since it is never used by any methods or other classes, The `UnreadFields` detector of SpotBugs found this and returns an `URF_UNREAD_FIELD` error.

### 2.2. Repeated conditional
In the `addBook` function of the BookCase class, the condition `books.size() < limit` was repeated one more time in the `if` statement (so `books.size() < limit || books.size() < limit` instead of just `books.size() < limit`). This leads to the error `RpC_REPEATED_CONDITIONAL_TEST` being thrown by the `RepeatedConditionals
` detector.

### 2.3. Inefficient new String(String) constructor
The 'filename' field in the `Application` class was changed to be made by calling the `new String` constructor. This wastes memory because the object constructed will be functionally indistinguishable from the String passed as a parameter. The error `DM_STRING_CTOR` was therefore returned by the `DumbMethods` detector.

# 3. Sonarqube instruction manual

To run `Sonarqube` on this gradle project, you need to have a running `Sonarqube` server on your local machine. Instructions can be found here:
<https://docs.sonarqube.org/latest/setup/get-started-2-minutes/>

Once you are completed with the installation, start up the server, login and go to the following path: 

**Administration > Configuration > General Settings > Security** 

and disable the **Force user authentication** property. This is to simplify the process.

Now you just need to run the sonarqube Gradle task to run a scan, with `./gradlew sonarqube`

## 4. Zoo project errors
Below is the summary of the number of errors/bugs found after running all `test` and `check` gradle tasks on the project:

- **checkStyleMain**: 4253 errors
- **checkStyleTest**: 1062 errors
- **spotbugsMain**: 28 bugs
- **test**: 3 failed tests

More detailed information on each individual bug/error can be found in their corresponding auto-generated reports.