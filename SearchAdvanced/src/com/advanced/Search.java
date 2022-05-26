package com.advanced;

import java.io.IOException;
import java.util.List;

/**
 * 
 * Acts as a template for different type of search techniques.
 * @author lakshman
 *
 */
public interface Search {

	void search(String filePath, String searchWord) throws IOException;
	
	/**
	 * Checks whether search word is valid or not.
	 * @param searchWord
	 * throws {@link IllegalArgumentException} if searchWork is invalid.
	 */
	public default void validateSearchWord(String searchWord)
	{
		if(searchWord.trim().isEmpty())
		{
			throw new IllegalArgumentException("SearchWord shouldn't be an empty string");
		}
	}
}
