import java.io.BufferedReader;
import java.io.File;
 import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


/**
 * Reads a .csv file with natural numbers and puts the values into an ArrayList.
 * 
 * @author Roland Sprang
 *
 */
public class DocumentParser {
	/**
	 * Private inner Class for Singleton Design Pattern
	 *
	 */
	private static final class InstanceHolder {
		private static final DocumentParser INSTANCE = new DocumentParser();
	}
	
	private DocumentParser() {}
	
	public static DocumentParser getInstance() {
		return InstanceHolder.INSTANCE;
	}
	
	/**
	 * Splits a .csv file into its individual natural numbers and stores the values as integers in an ArrayList.
	 * 
	 * @param path complete path to the the .csv file
	 * @return an {@link ArrayList} containing all numbers of the .csv file as {@link Integer} value
	 */
	public static ArrayList<Integer> parseCsvFile(final String path) {
		
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		
		try {
			File file = new File(path);
			if (!file.exists()) {
				System.out.println("Can not find file from path: " + path);
				return null;
			}
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String currentLine = reader.readLine();
			while(currentLine != null) {
				String line = currentLine;
				final StringTokenizer st = new StringTokenizer(line, ";");
				while(st.hasMoreTokens()) {
					String tempStr = st.nextToken();
					numberList.add(Integer.valueOf(tempStr.trim()));
				}
				currentLine = reader.readLine();
			}
			reader.close();
			return numberList;
			
		} catch (IOException e) {
			System.out.println("Can not read file from: " + path);
//			e.printStackTrace();
		}
		
		return null;
	}
}
