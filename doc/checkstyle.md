# Checkstyle Configuration

## 1. Method Length

Lengthy methods tend to become too complex and that makes them difficult to understand. This checkstyle prevents that by setting the maximum length for a method to **60 lines**, enforcing breaking long methods into individual methods that focus on a specific task.

***Note:** empty lines do not count to the total amount of lines*

## 2. Constant Names

An well-known Java convention is that constants should be all uppercase with words separated by underscores. We decided to stick to that convention and enforce it to our configuration.

#### Accepted examples
```java
public static final String CONSTANT = "Good constant";
public static final String GOOD_CONSTANT = "Another good constant";
```

#### Not accepted examples
```java
public static final String constant = "A bad constant";
public static final String bad_CONSTANT = "Another bad constant";
```

## 3. Braces

### 3.1. Left Curly Brace
In Java the block opening curly brace belongs on the same line as the class or function declaration. This checkstyle enforces this convention (sorry C# lads), and to increase readability there can be maximum 100 characters (including spaces) on the line the curly brace belongs to.

#### Accepted examples
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

#### Not accepted exampless
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

### 3.2. Right Curly Brace

The closing curly brace should be alone on a line. This checkstyle increases readability.

## 4. Indentation

## 5. One Staement Per Line

## 6. Switch Default Case

## 7. JavaDoc

## 8. 

## 9. 

## 10.