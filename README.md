
# SearchAdvanced

Command-line search application that outputs matching snippets in the given file based on the search word.



## Project Requirements
- JDK 1.8
- Ant 1.10.2
## Run locally
- Step 1 : Clone or [download](https://github.com/lakshmanrevella/Search/archive/refs/heads/master.zip) the project.
- Step 2 : Open terminal
- Step 3 : Ensure JAVA_HOME & ANT_HOME is set in this terminal path.
- Step 4 : Navigate to *SearchAdvanced* dir in terminal.
- Step 5 : To deploy , enter following command to setup application *build*
   
        ant  

- Step 6 : To setup TestSuite , enter following command
       
       ant -buildfile build_test.xml
- Step 7 : To start using the application navigate to *SearchAdvanced/build/bin*  directory in terminal and execute script as follows:
 
      sh search.sh FilePath SearchWord
    
- Step 8 : To test the application navigate to *SearchAdvanced/build_test/* directory in terminal and execute command as follows :
    
      ant -buildfile runTest.xml

- Step 9 : Once the above command is executed, open below file in web-browser to view Test Reports.

      SearchAdvanced/build_test/reports/html/index.html

- Step 10 : Open below file in web-browser to view Coverage Reports.

      SearchAdvanced/build_test/coverage_report/index.html

### Directory Layout post deployment

    SearchAdvanced
    |
    ├──── src                
    |     ├──── com                #contains main functionality source files.
    |     |
    |     ├──── test               #contains testing source files.                       
    |
    |
    |
    ├──── build                    #generated during deployment, this is used for core search functionality.                   
    |     ├──── bin 
    |     |     ├──── search.sh    #used to get snippets from file based on search word.
    |     |
    |     |
    |     ├──── classes            #compiled source classes     
    |     |
    |     |
    |     ├──── lib     
    |     |     ├──── search.jar   #executable jar created using compiled classes.
    |
    |
    |
    ├──── build_test               #Test Suite to run test cases, generate test reports along with coverage reports.                    
    |     ├──── src 
    |     |     ├──── test         #contains testing source files. 
    |     |
    |     |
    |     ├──── classes            #compiled test source classes     
    |     |
    |     |
    |     ├──── lib                #contains all the dependant (jacoco,junit ) jars and search.jar
    |     |     
    |     |
    |     ├──── test_data          #contains data files that are used for testing.
    |     |    
    |     |
    |     ├──── reports            #contains testcase reports.
    |     |   
    |     |
    |     ├──── coverage_report    #contains coverage reports for the testcases.
    |     |   
    |     |
    |     ├──── runTest.xml        #ant build file that triggers the regression testing 
    |
    |
    |
    ├──── build_test.xml           #ant build file, used to generate test suite(build_test directory).           
    | 
    |
    |
    ├──── build.xml                #ant build file, used to generate build( directory ).                    
    | 
    ├──── runTest.xml              #This file will be shipped to test suite during its generation.          
    | 
    |
    |
    ├──── search.sh                #This file will be shipped to build during its generation. .                    
    | 
                         
  
## CommandLine Outputs
- Check out the screenshots of above commands executed and their outputs [here](https://github.com/lakshmanrevella/Search/tree/master/Output).