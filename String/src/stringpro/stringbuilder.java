package stringpro;

import data.data;

public class stringbuilder {

	public static void main(String[] args) {

		//String name = "Manirathnam";
		String reversed ="";
		StringBuilder String = new StringBuilder();
		
		{
			for (int i =data.name.length()-1;i>=0;i--)
				reversed += data.name.charAt(i); 
				
			System.out.println("Orginal   : " + data.name );
			System.out.println("Reverse   : " + reversed);
			

		}
	}

}


