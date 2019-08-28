package ah3866_asg_wordSearch;

import java.lang.reflect.Array;
import java.util.*;


public class SplicingBooks {
	String bookText = "";
	String[] textData;
	String[] textCleaning;
	HashMap <String, String>cleanWords = new HashMap <String, String>();
	ArrayList<String> pronouns = new ArrayList<String>();
	
	public SplicingBooks(String[] bookData) {
		textData = bookData;
		textCleaning = bookData;
	}
	
	
	public void Update() {
		System.out.println("cleansing");
	}
	
	public void cleanUpWords() {
		
		//call pronoun collection
		collectPronouns();
		
		
		//sorting 
		abcComp abcd = new abcComp();
		MergeSort.mergeSort(textData, abcd);
		
			//ignore punctuation end and beginning 
			for (int i=0; i<textData.length; i++) {
				//not a number or punctuation
				if (!isNumeric(textData[i]) && !isPunc(textData[i])) {
				if (textData[i].length()>0) {
					String cleansingWord = textData[i];
					if (cleansingWord.length()>0) {
					if (isPunctuation(textData[i].charAt(0))){
						cleansingWord = cleansingWord.substring(1, textData[i].length());
						
						}
							
					}
					
					if (isPunctuation(textData[i].charAt(textData[i].length()-1))){
						cleansingWord = cleansingWord.substring(0, textData[i].length()-1);
						if (textData[i].length()>1) {
							if (isPunctuation(textData[i].charAt(textData[i].length()-2))){
								cleansingWord = cleansingWord.substring(0, textData[i].length()-2);
							}
						}
						if (textData[i].length()>2) {
							if (isPunctuation(textData[i].charAt(textData[i].length()-3))){
								cleansingWord = cleansingWord.substring(0, textData[i].length()-3);
							}
						}
							
					}
					String punctuations = "\"([-]-+)[?:!.,;]* ";

					//taking care of endings/beginnings that were not caught
					
					
					
					
					
					if (textData[i].charAt(textData[i].length()-1) == '-'){
						cleansingWord = cleansingWord.replace("-",  "");
						if (punctuations.contains(cleansingWord.substring(cleansingWord.length()-1))) {
							cleansingWord = cleansingWord.replace(cleansingWord.substring(cleansingWord.length()-1, cleansingWord.length()), "");
						}
						
					}
					if (cleansingWord.length() >0) {
					if (punctuations.contains(cleansingWord.substring(cleansingWord.length()-1))) {
						cleansingWord = cleansingWord.replace(cleansingWord.substring(cleansingWord.length()-1, cleansingWord.length()), "");
					}
					if (punctuations.contains(cleansingWord.substring(0, 1))) {
						cleansingWord = cleansingWord.replace(cleansingWord.substring(0, 1), "");
						
					}
					}
					
					//remove -ed and -ing
					if (cleansingWord.endsWith("ing")) {
						cleansingWord = cleansingWord.substring(0, cleansingWord.length()-3);
					}
					if (cleansingWord.endsWith("ed")) {
						cleansingWord = cleansingWord.substring(0, cleansingWord.length()-2);
					}
					
					
					
					
					
					if (!cleanWords.containsKey(cleansingWord)) {
						
						String cleanVal;
						if (pronouns.contains(cleansingWord)) {
							cleanVal = "Proper Pronoun";
						}
						else {
							cleanVal = "Regular";
						}
						cleanWords.put(cleansingWord, cleanVal);
						System.out.println("cleanse loading . . .");
						
					}
					
					
					
					
				}
				}
				}
			
			}
			
		    
		    
		    
					
					
				
			
				
				
				
				
				
			
		
			
			
		
		
		
	
	
	
	public void collectPronouns() {
		//capitals without I
		ArrayList<String> capital = new ArrayList<String> (Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"));
		
		
		
		
		
		for (int d=1; d<textData.length;d++) {
			/**/
			int len = textData[d-1].length();
			String prev = textData[d-1];
			
			
			
			if (/**LAST INDEX**/(!(prev.endsWith("!")) && !(prev.endsWith(".")) && !(prev.endsWith("?")))) {
					if ((len>=2) &&  (prev.substring(len-2, len-1) != "!" && prev.substring(len-2, len-1) != "." && prev.substring(len-2, len-1) != "?"))      {
						if ((len>=3) &&  (prev.substring(len-3, len-2) != "!" && prev.substring(len-3, len-2) != "." && prev.substring(len-3, len-2) != "?"))
			
			
				for (int c=0; c<capital.size(); c++) {
					if (textData[d].startsWith(capital.get(c))) {
						while (!OnlyAlpha(textData[d].substring(textData[d].length()-1))){
							textData[d] = textData[d].substring(0, textData[d].length()-1);
							
						}
						if (!pronouns.contains(textData[d])) {
							
							pronouns.add(textData[d]);
						}
						
					}
		
				}
			}
			
		}
		}
		
		
		String[] pro = new String[pronouns.size()];
		for (int g =0; g<pronouns.size(); g++) {
			pro[g] = pronouns.get(g);
		}
		abcComp abcd = new abcComp();
		MergeSort.mergeSort(pro, abcd);
	
		
		
		
			
			
			
	}
	
	
	
	
	//USED INTERNALLY

	//CHECK FOR whether it is just alphabet and not punctuation/numeric
	public static boolean OnlyAlpha(String str) 
	{ 
	    return ((str != null) 
	            && (!str.equals("")) 
	            && (str.matches("^[a-zA-Z]*$"))); 
	} 
	
	
	
	//CHECK FOR End punctuation
	public static boolean endPunc(String str) 
	{ 
		String punctuations = "([-]+)[?:!.,;]* ";
		ArrayList <Character> puncArr = new ArrayList <Character>();
		
		for (int j=0; j<punctuations.length(); j++) {
			puncArr.add(j, punctuations.charAt(j));
		}
		puncArr.add('"');
		
		boolean checkEnd = false;
		for (int i=0; i<puncArr.size();i++) {
			if (str.endsWith(Character.toString(puncArr.get(i)))) {
				if (str.endsWith("\"")) {
				checkEnd = true;
				}
			}
		}
		
		return checkEnd;
		
	}
	
	
	
	
	public static boolean startPunc(String str) 
	{ 
		String punctuations = "(-[-]+)[?:!.,;]* ";
		ArrayList <Character> puncArr = new ArrayList <Character>();
		
		for (int j=0; j<punctuations.length(); j++) {
			puncArr.add(j, punctuations.charAt(j));
		}
		puncArr.add('"');
		
		boolean checkEnd = false;
		for (int i=0; i<puncArr.size();i++) {
			if (str.startsWith(Character.toString(puncArr.get(i)))) {
				checkEnd = true;
			}
		}
		
		return checkEnd;
		
	}
	
	
	public static boolean isNumeric(String s) {  
	    return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
	}  
	
	public static boolean isPunc(String s) {  
		String punctuations = "([-]-+)[?:!.,;]* ";
		boolean allPunc = true;
	    for (int j=0; j<s.length(); j++) {
	    	if (!punctuations.contains(s.substring(j, j+1))){
	    		allPunc = false;
	    	}
	    }
	    return allPunc;
	}  
	
	
	public static String remSuffix(String s) {
		if (s.length()>3) {
			if ((s.charAt(s.length()-1) == 'g') && (s.charAt(s.length()-2) == 'n') && (s.charAt(s.length()-3) == 'i')) {
				s = s.substring(0,s.length()-3 );
			}
			else if ((s.charAt(s.length()-1) == 'd') && (s.charAt(s.length()-2) == 'e')) {
				s = s.substring(0,s.length()-2 );
			}
			
		}
		return s;
	}
	
	public static boolean isPunctuation(char c) {
        return c == ','
            || c == '.'
            || c == '!'
            || c == '?'
            || c == ':'
            || c == ';'
            || c == '\"'
            || c == '\''
            || c == ')'
            || c == '('
            || c == '—'
            || c == '-'
            ;
    }

	
	
}

