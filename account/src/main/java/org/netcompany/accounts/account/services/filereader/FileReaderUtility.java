package org.netcompany.accounts.account.services.filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.netcompany.accounts.account.exceptions.DataNotFoundException;
import org.netcompany.accounts.account.exceptions.FileParserException;

/**
 * File Reader Utility
 */
public final class FileReaderUtility {

	public static final String COMMA_DELIMITER = ",";

	/**
	 * Method Read From File 
	 *
	 *method read a file and save all its content to a list
	 *
	 * @return List<List<String>>
	 * 
	 *  @throws IOException when something get wrong with the parsing of file
	 *  @throws DataNotFoundException when there is not content in the file
	 */
	public List<List<String>> readFromFile(String filename)  {
		List<List<String>> records = new ArrayList<>();
		String fileFullpath = getClass().getClassLoader().getResource(filename).getPath();
		try (BufferedReader br = new BufferedReader(new FileReader(fileFullpath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(COMMA_DELIMITER);
				records.add(Arrays.asList(values));
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
			throw new FileParserException("Error in parsing file");
		}
		records.removeFirst();
		
		if (records.isEmpty())
			throw new DataNotFoundException("Data not found");
		
		return records;
	}

}
