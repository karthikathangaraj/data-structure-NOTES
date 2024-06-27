package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class progrm6 {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
         int n=sc.nextInt();
         List<String> l1=new ArrayList<>();
         for(int i=1;i<=n;i++)
         {
        	 l1.add(String.valueOf(i));
         }
         Collections.sort(l1);
        	 System.out.println(l1);
         }
    
	}


