package algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class prog4 {
    public static int calc(String s1)//abbccc
    {
    	int[] freq=new int[26];
    	String s2=s1.toLowerCase();//a b b c c c
    	for(char ch:s2.toCharArray())//a b b c c c
    	{
    		if(ch >='a' && ch<='z')
    			freq[ch-'a']++;
    		
    	}
        Arrays.sort(freq); 
        int tb=0;
        int bv=26;
        for(int i=25;i>=0;i--)
        {
        	if(freq[i]>0)
        	{
        		tb +=freq[i]*bv;//3*36 =78+2*25+ 1*24=152
        		bv--;
        	}
        	else
        		break;
        }
        return tb;
        
    }
   

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        String s1=scanner.next();//aabbcc
        int b1=calc(s1);
        
        System.out.println(b1);
	}

}
