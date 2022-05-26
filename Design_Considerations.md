## Assumptions & Limitations
- For log type file (.log), nextline is treated as sentence terminator.
- For text type file(.txt), period and next line are treated as sentence terminators.
- Supported only in linux

## Dependency Management tool
- Chose *Ant* as dependency management tool, as I have more exposure this that maven & gradle.
- Gradle semms like a [promising tool](https://www.baeldung.com/ant-maven-gradle) and would like to explore it.

## Design Pattern
- Chose FactoryMethod design pattern as there is a need to segregate the parsing logic based on the type of the file.
- Also, this way user/client doesn't need to know about the classes involved in application.
- Would have used Strategy Pattern if client had the leverage about classes involved and can pass the respective objects. 
