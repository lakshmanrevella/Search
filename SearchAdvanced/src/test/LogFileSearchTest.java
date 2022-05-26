package test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.advanced.LogFileSearch;

import test.util.TestUtil;

@RunWith(Enclosed.class)
public class LogFileSearchTest
{
	private static LogFileSearch logFile = new LogFileSearch();

	@RunWith(Parameterized.class)
	public static class LogFileSearchTestParameterized
	{


		String testName=null;
		String inputFilePath=null;
		String searchWord=null;
		String actualOutputFilePath=null;
		String expectedOutputFilePath=null;


		@Parameters(name = "{0}")
		public static List<Object[]> testCases() 
		{
			/**
			 * testName -> Name of the test
			 * inputFilePath -> File in which searchWord will be scanned.
			 * searchWord 
			 * 
			 * actualOutputFilePath -> Filepath of the file to which output is redirected from search API.
			 * expectedOutputFilePath -> Filepath of the file which has expected output.
			 */

			List <Object[]>  parameters= new ArrayList<Object[]>();

			parameters.add(new Object[]{"VerySmallFile",
					"test_data/logSearch/logFile_verysmall_input.log",
					"[42]",
					"test_data/logSearch/logFile_verysmall_actualOutput.txt",
			"test_data/logSearch/logFile_verysmall_expectedOutput.txt"});

			parameters.add(new Object[]{"MediumFile",
					"test_data/logSearch/logFile_medium_input.log",
					"[165]",
					"test_data/logSearch/logFile_medium_actualOutput.txt",
			"test_data/logSearch/logFile_medium_expectedOutput.txt"});

			parameters.add(new Object[]{"LargeFile",
					"test_data/logSearch/logFile_large_input.log",
					"[234]",
					"test_data/logSearch/logFile_large_actualOutput.txt",
			"test_data/logSearch/logFile_large_expectedOutput.txt"});



			return parameters;
		}

		public LogFileSearchTestParameterized(String testName,String inputFilePath, String searchWord,String actualOutputFilePath,String expectedOutputFilePath)
		{
			this.testName = testName;
			this.inputFilePath = inputFilePath;
			this.searchWord = searchWord;
			this.actualOutputFilePath = actualOutputFilePath;
			this.expectedOutputFilePath = expectedOutputFilePath;
		}


		@Test
		public void testLogFileSearch_() throws IOException
		{

			PrintStream o = new PrintStream(new File(actualOutputFilePath));
			System.setOut(o);

			logFile.search(inputFilePath, searchWord);

			assertTrue("Both Files should contain same content!!!",TestUtil.isContentEqual(actualOutputFilePath,expectedOutputFilePath));
		}



	}


	public static class LogFileSearchTestNonParameterized
	{
		@Test
		public void testLogFileSearch_InvalidFile()
		{
			String filePath ="";
			String searchWord = "webservers";

			try {
				logFile.search(filePath, searchWord);
				assertTrue("Should throw an IO Excetion due to invalid file param.",false);
			} 
			catch (IOException e) 
			{
				assertTrue("Exception is thrown as expected! ",true);
			}

		}

		@Test
		public void testLogFileSearch_InvalidSearchWord() throws IOException
		{
			String filePath ="test_data/logSearch/logFile_verysmall_input.log";
			String searchWord = "   ";

			try {
				logFile.search(filePath, searchWord);
				assertTrue("Should throw an IO Excetion due to invalid file param.",false);
			} 
			catch (IllegalArgumentException e) 
			{
				assertTrue("Exception is thrown as expected! ",true);
			}

		}
	}


}
