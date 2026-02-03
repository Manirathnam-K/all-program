package stringpro;

import data.data;

public class Stringreplace {

	public static void main(String[] args) {
		String name = "Mani rathnam";
	    String replaced = data.name.replace("a", "Z");
	    String repall = data.name.replaceAll("a", "qqqqqq");
	    String removedSpaces = data.name.replaceAll(" ", "");
	    
	    
	    System.out.println("Replace the word  : "+ replaced);
	    System.out.println("Replace the word  : "+ repall);	
	    System.out.println("Replace the word  : "+ removedSpaces);	
	}
}