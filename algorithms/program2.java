package algorithms;

import java.util.Scanner;

public class program2 {
 public static boolean palin(String str)
 {
	int left =0; 
	int right=str.length()-1; //1100
	while(left < right)
	{
		if(str.charAt(left) !=str.charAt(right))
		{
			return false;
		}
		left++;
		right--;
	}
	return true;
 }
	public static void main(String[] args) {
		Scanner s1=new Scanner(System.in);
        int n=s1.nextInt();
        String str = Integer.toBinaryString(n);
        if(palin(str))
        System.out.println("TRUE");
        else
        	System.out.println("FALSE");
	}

}
