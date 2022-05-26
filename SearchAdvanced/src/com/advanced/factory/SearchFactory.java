package com.advanced.factory;

import com.advanced.BasicStringSearch;
import com.advanced.LogFileSearch;
import com.advanced.Search;

public class SearchFactory {

	public static Search getSearch(String filePath)
	{
		if(filePath == null)
		{
			return null;
		}
		
		if(filePath.endsWith(".txt"))
		{
			return new BasicStringSearch();
		}
		else
		{
			return new LogFileSearch();
		}
	}
}
