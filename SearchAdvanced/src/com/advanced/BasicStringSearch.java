package com.advanced;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 
 * Deals with text documents that contains multiple sentences each ending with period.
 * Note : period and next line are treated as sentence terminators.
 * @author lakshman
 *
 */
public class BasicStringSearch implements Search
{
	/**
	 * filePath - Path of input file in which searchWord need to be scanned.
	 */
	@Override
	public void search(String filePath, String searchWord) throws IOException 
	{
		validateSearchWord(searchWord);
		
		File f = new File(filePath);
		try(BufferedReader b = new BufferedReader(new FileReader(f)))
		{
			Stream<String> lines = b.lines();
			lines.forEach((line)->{
				
				String[] split = line.split("\\.");
				for(String sp : split)
				{
					if(sp.contains(searchWord))
					{
						System.out.println(sp);
					}
				}
			});
			
		}
	}
}
