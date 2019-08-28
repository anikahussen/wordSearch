package ah3866_asg_wordSearch;

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;


public class CallingClass {
	public static void main (String[]args) {
		String f_book = "Jane Eyre";
		String c_book = "War and Peace";
		String JEFile = "janeeyre.txt";
		String wPFile = "war_peace.txt";
		String wordsFile = "words.txt";//IF YOU WOULD LIKE TO TEST WITH ANOTHER FILE, CHANGE THE DATA OF THIS FILE
		
		//String testJEFile = "testJaneEyre.txt";
		//String testwPFile = "testWarPeace.txt";
		
		//******Words List******//
		
		//file object to open up file 
				File WordFile = new File(wordsFile);
				//finding and storing absolute path 
				String Wordabspath = WordFile.getAbsolutePath();
				//to store raw data 
		
		
		
		
		//******JANE EYRE******//

		
		//file object to open up file 
		/***TEST FILE WITH SECTION OF BOOK		
		File janeEyreFile = new File(testJEFile);
		***/
		File janeEyreFile = new File(JEFile);
		//finding and storing absolute path 
		String Janeabspath = janeEyreFile.getAbsolutePath();
		//to store raw data 
		
		//******WAR AND PEACE******//
		
		//file object to open up file 
		/***TEST FILE WITH SECTION OF BOOK	
		File warPeaceFile = new File(testwPFile);
		**/
		File warPeaceFile = new File(wPFile);
		//finding and storing absolute path 
		String warPeaceabspath = warPeaceFile.getAbsolutePath();
		//to store raw data 
		
		try {
			//Words 
			
			Scanner wordsfileReader = new Scanner (new File(Wordabspath));
			
			String WordStr= "";
			while (wordsfileReader.hasNext()) {
				//System.out.println("word reading");
				WordStr+= wordsfileReader.nextLine() + " ";
			}
			
			//Splitting Words 
			
			String [] wordsList = WordStr.split(" ");
			
			
			//Comparator Alphabetic 
			abcComp abc = new abcComp();
			
			
			//Merge Sort Words 
			MergeSort.mergeSort(wordsList,abc);
			
			
			
			
			
			
			
			
			//Jane Eyre
			Scanner JanefileReader = new Scanner (new File(Janeabspath));
			
			String JaneStr= "";
			while (JanefileReader.hasNext()) {
				//System.out.println("jane eyre reading");
				JaneStr+= JanefileReader.nextLine() + " ";
			}
			
			
			String[] JaneData = JaneStr.split(" ");
			
			
			SplicingBooks janeEyreLoad = new SplicingBooks(JaneData);
			
			janeEyreLoad.Update();
			System.out.println("Jane Eyre");
			
			janeEyreLoad.cleanUpWords();
			
			 //War and Peace
				Scanner warPeaceReader = new Scanner (new File(warPeaceabspath));
				
				String warPeaceStr= "";
				while (warPeaceReader.hasNext()) {
					//System.out.println("war and peace reading");
					warPeaceStr+= warPeaceReader.nextLine() + " ";
				}
				
				String[] WarPeaceData = warPeaceStr.split(" ");
				
				SplicingBooks warPeaceLoad = new SplicingBooks(WarPeaceData);
				
				warPeaceLoad.Update();
				System.out.println("War and Peace");
				
				
				warPeaceLoad.cleanUpWords();
				
				
				
			wordsfileReader.close();
			
			warPeaceReader.close();
			
			JanefileReader.close();	
			
			//STORING IN HASHMAP 
			
			
			
			
			
	

			
			
			
			
			//PRINTING RESULTS 
			//words in alphabetical 
			
			//Each Individual
			
			System.out.println();
			System.out.println();
			
			System.out.print("Focus Book: " + f_book + "      ");
			System.out.print("Total Unique Words: "  + janeEyreLoad.cleanWords.size() +"      ");
			
			System.out.println ("Total Pronouns: " +  janeEyreLoad.pronouns.size() + "      ");
			System.out.print("Comparison Book: " + c_book + "      ");
			System.out.print("Total Unique Words: " + warPeaceLoad.cleanWords.size() +  "      ");
			
			System.out.println("Total Pronouns: " + warPeaceLoad.pronouns.size() + "      ");
			
			
			
			String [] JaneEyreKeySort = new String[janeEyreLoad.cleanWords.size()];
			int move =0;
			while (move<JaneEyreKeySort.length) {
			for (String key: janeEyreLoad.cleanWords.keySet()) {
				JaneEyreKeySort[move] = key;
				move+=1;
			}
			}
			MergeSort.mergeSort(JaneEyreKeySort, abc);
			
			
			String [] warPeaceKeySort = new String[warPeaceLoad.cleanWords.size()];
			
			int move2 =0;
			while (move2<warPeaceKeySort.length) {
			for (String key: warPeaceLoad.cleanWords.keySet()) {
				warPeaceKeySort[move2] = key;
				move2+=1;
			}
			}
			
			MergeSort.mergeSort(warPeaceKeySort, abc);
			
			//Compare books to each other
			
			System.out.println();
			System.out.print("Common Words in both: "  );
			int countBoth = 0;
			for (String key: janeEyreLoad.cleanWords.keySet()) {
				if (warPeaceLoad.cleanWords.containsKey(key)) {
					if (!key.equals("")) {
						countBoth+=1;
					}
				}
			}
			
			
			System.out.print(countBoth + "   ");
			
			
			System.out.print("Words in Jane Eyre Only: "  );
			int countJE =0;
			for (String key: janeEyreLoad.cleanWords.keySet()) {
				if (!warPeaceLoad.cleanWords.containsKey(key)) {
					if (!key.equals("")) {
						countJE +=1;
					}
				}
			}
			System.out.print(countJE + "    ");
			
			System.out.print("Words in War and Peace Only: "  );
			
			int countWP =0;
			for (String key: warPeaceLoad.cleanWords.keySet()) {
				if (!janeEyreLoad.cleanWords.containsKey(key)) {
					if (!key.equals("")) {
						countWP +=1;
					}
				}
			}
			System.out.println(countWP);
			
			
		
			
			
			
			System.out.println();
			
		
			
			
			System.out.print("WordList Jane Eyre only: "  );
			//More cleaning
			for (int jeS =0; jeS <JaneEyreKeySort.length; jeS++) {
				if (!warPeaceLoad.cleanWords.containsKey(JaneEyreKeySort[jeS])){
				if (!JaneEyreKeySort[jeS].equals("") && !(Character.toString(JaneEyreKeySort[jeS].charAt(0)).equals("\"")) && !(Character.toString(JaneEyreKeySort[jeS].charAt(0)).equals("\'")) && !isNumericPunc(JaneEyreKeySort[jeS])) {
						System.out.print(JaneEyreKeySort[jeS] + ", ");
				}
			}
			}
			
			System.out.println();
			System.out.print("WordList War and Peace only: " );
			
			for (int wpS =0; wpS <warPeaceKeySort.length; wpS++) {
				if (!janeEyreLoad.cleanWords.containsKey(warPeaceKeySort[wpS])){
			
				if (!warPeaceKeySort[wpS].equals("") && !(Character.toString(warPeaceKeySort[wpS].charAt(0)).equals("\"")) && !(Character.toString(warPeaceKeySort[wpS].charAt(0)).equals("\'")) && !isNumericPunc(warPeaceKeySort[wpS])) {
					System.out.print(warPeaceKeySort[wpS] + ", ");
				}
			}
			}
		
			
			System.out.println();
			
			System.out.println();
			
			//Compare books to word file
			
			System.out.print("Focus Book Jane Eyre Words in words file: " );
			
			for (int h=0; h<wordsList.length; h++ ) {
				if (janeEyreLoad.cleanWords.containsKey(wordsList[h])){
					System.out.print(wordsList[h] + ", ");
				}
				
				
			}
	
			System.out.println();
			
			System.out.print("Words NOT in Focus book, Jane Eyre, but in word file: " );
			
			for (int h=0; h<wordsList.length; h++ ) {
				if (!janeEyreLoad.cleanWords.containsKey(wordsList[h])){
					System.out.print(wordsList[h] + ", ");
				}
				
				
			}
			
			
			
		}
		//catch file not found error  
		catch(FileNotFoundException e) {
			System.out.println("A File or Multiple Files Not Found.");
		}
			
		
		
		
		
	
	}
	static boolean isNumericPunc(String s){
		String numbers = "01234567890=([-]-+)[?:!.,;]";
		if (!numbers.contains(Character.toString(s.charAt(0)))){
				return false;
				
			}
			
			
		
		return true;
	}
}



