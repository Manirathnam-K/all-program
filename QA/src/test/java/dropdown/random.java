package dropdown;
import java.util.Random;
import java.util.*;
public class random {

//	public static void main(String[] args) {
//		Random random = new Random();
//
//        int randomNum = random.nextInt(140000);  // Random number
//        
//        
//        String randomEmail = "user" + randomNum + "@test.com";       
//        String randomPassword = "Pass@" + randomNum;
//
//        System.out.println("Email: " + randomEmail);
//        System.out.println("Password: " + randomPassword);
//        
//        String uniqueID = UUID.randomUUID().toString();
//        String dynamicEmail = "user_" + uniqueID.substring(0, 5) + "@gmail.com";
//
//        System.out.println("Dynamic Email: " + dynamicEmail);
//       
//
//	}
	
	public static void main(String[] args) {

        Random random = new Random();

        String[] productList = {"Mobile", "Laptop", "Headphones", "Monitor", "Keyboard", "Mouse"};
        String product = productList[random.nextInt(productList.length)] 
                         + "_" + UUID.randomUUID().toString().substring(0, 4);

        int qty = random.nextInt(10) + 1;
        double price = 100 + (1000 - 100) * random.nextDouble();
        double total = Math.round(price * qty * 100.0) / 100.0;

        System.out.println("Product: " + product);
        System.out.println("Quantity: " + qty);
        System.out.println("Price per unit: ₹" + String.format("%.2f", price));
        System.out.println("Total amount: ₹" + String.format("%.2f", total));
    }
}