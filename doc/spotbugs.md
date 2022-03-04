# Custom bugs
The following bugs were intentionally added to test the functionalities of SpotBugs according to the given assignment. Of course, after adding them to the code and having a report generated, the bugs were removed so as not to break the build. 

An HTML report of the buggy code can be found in ...
## 1. Unread field
A variable `unreadVar` of type `String` was declared inside the `BookCase` class. However, since it is never used by any methods or other classes, The `UnreadFields` detector of SpotBugs found this and returns an `URF_UNREAD_FIELD` error.

## 2. Repeated conditional
In the `addBook` function of the BookCase class, the condition `books.size() < limit` was repeated one more time in the `if` statement (so `books.size() < limit || books.size() < limit` instead of just `books.size() < limit`). This leads to the error `RpC_REPEATED_CONDITIONAL_TEST` being thrown by the `RepeatedConditionals
` detector.

## 3. Inefficient new String(String) constructor
The 'filename' field in the `Application` class was changed to be made by calling the `new String` constructor. This wastes memory because the object constructed will be functionally indistinguishable from the String passed as a parameter. The error `DM_STRING_CTOR` was therefore returned by the `DumbMethods` detector.

