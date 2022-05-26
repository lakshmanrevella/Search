package com.advanced;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * 
 * Deals with log documents(.txt or .log) in which each line ends with a nextline(\n).
 * Note : nextline is treated as sentence terminator.
 * @author lakshman
 *
 */
public class LogFileSearch implements Search {

	@Override
	public void search(String filePath, String searchWord) throws IOException 
	{
		validateSearchWord(searchWord);

		File f = new File(filePath);
		try(BufferedReader b = new BufferedReader(new FileReader(f)))
		{
			Stream<String> lines = b.lines();

			lines.forEach((line)->{
				if(line.contains(searchWord))
				{
					System.out.println(line);
				}
			});
		}
	}

}
