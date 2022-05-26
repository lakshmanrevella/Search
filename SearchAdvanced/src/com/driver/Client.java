package com.driver;

import java.io.IOException;
import com.advanced.Search;
import com.advanced.factory.SearchFactory;

public class Client {

	public static void main(String[] args) throws IOException {
		
		if(args.length<2)
		{
			throw new IllegalArgumentException("Invalid arguments passed !!");
		}
		
		String filePath = args[0];
		String searchKey = args[1];
		
		Search search = SearchFactory.getSearch(filePath);
		search.search(filePath, searchKey);
		
	}
}
