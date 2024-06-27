package algorithms;

import java.util.Scanner;

public class program1 {

	public static void main(String[] args) {
		Scanner ss=new Scanner(System.in);
		int a[]=new int[20];
		int sum=0;
		for(int i=0;i<5;i++)
			a[i]=ss.nextInt();
		for(int i=0;i<5;i++)
		{
			if(a[i]%2==0 || a[i] %3==0)
			{
				sum +=a[i];
			}
		}
		System.out.println(sum);
		String s1=Integer.toBinaryString(12);
		System.out.println(s1);

	}

}
