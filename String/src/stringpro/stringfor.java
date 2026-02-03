package stringpro;

import data.data;

public class stringfor {
	
	
	public static void main(String[] args) {
		
		//String name ="Manirathnam";
		String reverse ="";
		//StringBuilder reverse1 = new StringBuilder();

	for (int i = data.name.length()-1;i>=0;i--)
	{
		reverse+=data.name.charAt(i);
		
		//char ch = data.name.charAt(i);
	   // reverse1.append(data.name.charAt(i));

	}
	System.out.println("Orginal   " + data.name );
	System.out.println("Reverse   " + reverse);
	//System.out.println("Reverse   " + reverse1);
		
		
	}

}



