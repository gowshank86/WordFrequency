import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ScannerMethod {
	
	// Step 0: Main method
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner input = new Scanner (System.in);
		
		System.out.print("Enter the source file name: ");
		String fileName = input.next(); // user input to read filename

		// S1: Pass fileName to readFileName method and add it to ArrayList ipFileName
		ArrayList <String> ipFileName = readFileName(fileName); 
			
		Map<String,Integer> countByWord = new HashMap<String,Integer> ();
		
		for (int i =0; i< ipFileName.size(); i++) {
			
			System.out.println("\n"+"Working with File: "+ ipFileName.get(i));
			
			countTotalWords(ipFileName.get(i));
			
			countofEachWord(ipFileName.get(i), countByWord);
			
			System.out.println("Printing count by words.......");
			
			System.out.println(countByWord);
		}
		
		input.close();
	}
	
	// Step 1: Create a method to read file name
	
	public static ArrayList<String> readFileName(String srcFileName)throws FileNotFoundException {
		
		int fileListSize = 5;
		
		ArrayList <String> processFileName = new ArrayList<String>(fileListSize);

		String userFileName = srcFileName;
		
		File textFile = new File(userFileName);
		
		Scanner in = new Scanner(textFile);
		
		int totalFileCount = 0;
		while(in.hasNextLine()) {
			String line = in.nextLine();
			
			if(!(line.equals(""))) {
				
				processFileName.add(line);
				totalFileCount++;
				//System.out.println(line);
			}		
		}
		System.out.println("Total number of lines in the file: " +totalFileCount + "\n" );
		in.close();
		return (processFileName);
	}

	// Step 2: Create a method to count total word count
	public static void countTotalWords(String fileName) throws FileNotFoundException {
		
		int totalWordCount = 0; // variable of type integer to hold total words in the file
		
		String ipFileName = fileName;
		
		File textFile = new File(ipFileName);
		
		Scanner in = new Scanner(textFile);
		
		while(in.hasNextLine()){
			
			String line = in.nextLine();
			
			if(!(line.equals(""))) {
				String[] wordListArray = line.split("\\s+");
				totalWordCount += wordListArray.length;	
			}			
		}
		System.out.println("\n"+"Total number of words in the file is: " + totalWordCount);
		in.close();	
	}
	
	// Step 3: Create a method to identify total count by words
	public static void countofEachWord(String fileName, Map<String, Integer> countByWord) throws FileNotFoundException {
		
		String ipFileName = fileName;
		
		File textFile = new File(ipFileName);
		
		Scanner in = new Scanner(textFile);
		
		while(in.hasNext()) {
			String word = in.next();
			
			Integer wordCount = countByWord.get(word);
			
			if(wordCount != null)
				wordCount++;
			else
				wordCount = 1;
			countByWord.put(word, wordCount);
		}
		
		in.close();
	}
	
}
