package program;
import java.util.*;
import java.util.HashMap;

public class find_repeated_charactor {

	public static void main(String[] args) {
		String Word = "programming";
		HashMap<Character, Integer> Value = new HashMap<>();
		for (int i = 0; i < Word.length(); i++) {
			char count = Word.charAt(i);
			if (Value.containsKey(count)) {
				Value.put(count, Value.get(count) + 1);
			} else {
				Value.put(count, 1);
			}
		}
		System.out.print("Repeated characters are: ");
		for (Map.Entry<Character, Integer> entry : Value.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.print(entry.getKey() + " ");
			}
		}
		System.out.println();
	}
}