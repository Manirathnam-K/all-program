package Java_collection;

import java.util.*;

public class array_list {

	public static void main(String[] args) {
	List<String> lang = new ArrayList<>();
	
	lang.add("Java");
	lang.add("Python");
	lang.add("C++");
	lang.add("JavaScript");
	System.out.println(lang);	
	lang.remove("C++");
	System.out.println(lang);
	System.out.println(lang.get(1));
	System.out.println(lang.size());
	System.out.println(lang.contains("Java"));
	System.out.println(lang.isEmpty());
	lang.set(1, "Ruby");
	System.out.println(lang);
	lang.clear();
	System.out.println(lang);
	System.out.println(lang.isEmpty());	
	
	
	String[] temp = { "Abc", "Def", "Ghi", "Jkl" };
    // Conversion of array to ArrayList using Arrays.asList
    List conv = Arrays.asList(temp);
    System.out.println(conv);
    
	}

}
