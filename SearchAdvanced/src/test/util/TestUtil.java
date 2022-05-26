package test.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

/**
 * Utility class to handle common APIs.
 * @author lakshman-3231
 *
 */
public class TestUtil {

	public static boolean isContentEqual(String actualFile, String expectedFile) 
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
