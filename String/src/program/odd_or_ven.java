package program;

public class odd_or_ven {
	public static void main(String[]args) {
		//int num = 7;
		int [] num = {1,4,6,7,9};
		//for(int i=0;i<num.length;i++) 
		for(int nums:num) {
		
	if(nums%2==0)
	{
		System.out.println(nums+" is even");
		}
	else{
		System.out.println(nums+" is odd");
		}
		
		}
	
	}

}


