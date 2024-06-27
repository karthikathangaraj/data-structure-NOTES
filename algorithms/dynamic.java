package algorithms;

import java.util.Scanner;

public class dynamic {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		final int a[]= {1,2,3,4};
		for(int i : a)
		    System.out.print(i+" ");
		a[1]= 9;
		System.out.println(a[1]);
		int[][] a1= new int[3][3];
		for(int i=0;i<3;i++)//1
	    for(int j=0;j<3;j++) //o,1,2,3<3
	    	a1[i][j]=sc.nextInt();//a[1][]
		for(int i=0;i<3;i++)
		{
		    for(int j=0;j<3;j++)
		    	System.out.print(a1[i][j]+" ");
		  System.out.println(); 	

	}

}
}
