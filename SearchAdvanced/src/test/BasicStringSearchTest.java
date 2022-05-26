package test;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.advanced.BasicStringSearch;

@RunWith(Enclosed.class)
public class BasicStringSearchTest
{
	private static BasicStringSearch basic = new BasicStringSearch();

	@RunWith(Parameterized.class)
	public static class BasicStringSearchTestParameterized
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
					"test_data/basicSearch/basic_verysmall_input.txt",
					"webservers",
					"test_data/basicSearch/basic_verysmall_actualOutput.txt",
			"test_data/basicSearch/basic_verysmall_expectedOutput.txt"});

			parameters.add(new Object[]{"MediumFile",
					"test_data/basicSearch/basic_medium_input.txt",
					"webservers",
					"test_data/basicSearch/basic_medium_actualOutput.txt",
			"test_data/basicSearch/basic_medium_expectedOutput.txt"});

			parameters.add(new Object[]{"LargeFile",
					"test_data/basicSearch/basic_large_input.txt",
					"webservers",
					"test_data/basicSearch/basic_large_actualOutput.txt",
			"test_data/basicSearch/basic_large_expectedOutput.txt"});



			return parameters;
		}

				public BasicStringSearchTestParameterized(String testName,String inputFilePath, String searchWord,String actualOutputFilePath,String expectedOutputFilePath)
				{
					this.testName = testName;
					this.inputFilePath = inputFilePath;
					this.searchWord = searchWord;
					this.actualOutputFilePath = actualOutputFilePath;
					this.expectedOutputFilePath = expectedOutputFilePath;
				}


		@Test
		public void testBasicStringSearch_() throws IOException
		{

			PrintStream o = new PrintStream(new File(actualOutputFilePath));
			System.setOut(o);

			basic.search(inputFilePath, searchWord);

			assertTrue("Both Files should contain same content!!!",compareActualVsExepcted(actualOutputFilePath,expectedOutputFilePath));
		}



		private boolean compareActualVsExepcted(String actualFile, String expectedFile) 
		{
			Path firstFile = new File(actualFile).toPath();
			Path secondFile = new File(expectedFile).toPath();
			try {
				long size = Files.size(firstFile);
				if (size != Files.size(secondFile)) {
					return false;
				}

				if (size < 2048)
				{
					return Arrays.equals(Files.readAllBytes(firstFile),
							Files.readAllBytes(secondFile));
				}

				// Compare line-by-line
				try (BufferedReader bf1 = Files.newBufferedReader(firstFile);
						BufferedReader bf2 = Files.newBufferedReader(secondFile)) {

					String line;
					while ((line = bf1.readLine()) != null)
					{
						if (!line.equals(bf2.readLine())) {
							return false;
						}
					}
				}

				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;

		}

	}


	public static class BasicStringSearchTestNonParameterized
	{
		@Test
		public void testBasicStringSearch_InvalidFile()
		{
			String filePath ="";
			String searchWord = "webservers";

			try {
				basic.search(filePath, searchWord);
				assertTrue("Should throw an IO Excetion due to invalid file param.",false);
			} 
			catch (IOException e) 
			{
				assertTrue("Exception is thrown as expected! ",true);
			}

		}

		@Test
		public void testBasicStringSearch_InvalidSearchWord() throws IOException
		{
			String filePath ="test_data/basicSearch/basic_verysmall_input.txt";
			String searchWord = "   ";

			try {
				basic.search(filePath, searchWord);
				assertTrue("Should throw an IO Excetion due to invalid file param.",false);
			} 
			catch (IllegalArgumentException e) 
			{
				assertTrue("Exception is thrown as expected! ",true);
			}

		}
	}


}
