package stringpro;

import data.data;

public class Stringsplit {

	public static void main(String[] args) {
		//String name = "Manirathnam";
		
		{

		        // Split into individual characters
		        char[] characters = data.name.toCharArray();

		        System.out.println("Each character:");
		        for (int i = 0; i < characters.length; i++) {
		            System.out.println("Char " + (i + 1) + ": " + characters[i]);
		        }
		    }
	}
	
	}

