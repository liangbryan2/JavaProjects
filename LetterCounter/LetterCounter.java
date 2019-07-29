/**
Monica Cua, Bryan Liang
July 17, 2019
Project 3, #1

Program reads line of text. 
Displays occurences of each letter in first sentence in alphabetical order. 
Allow for loops until user quits. 
**/

import java.util.Scanner;

public class project3
{
	public static Scanner input=new Scanner(System.in);

//method to take character and return int value
	public static int letter(char a)
	{
		return a-97;
	}


//main method
	public static void main(String[] args) 
	{
		String answer="y";

//do...while loop continues as long as user wants
	do{
		String str1;

		System.out.println("Please enter a sentence that ends with a period: ");
		str1=input.nextLine().toLowerCase();

		if(! str1.contains("."))
		{
			continue;
		}
//split string array by sentence by period
		String [] str=str1.split("\\.");
		String str2=str[0];
		int [] amount=new int [26];

		System.out.println(str[0]);

//loop through sentence to count occurences of each letter in order
		for (int i=0; i<str2.length();i++)
		{
			char c=str2.charAt(i);
			int n=letter(c);
		if (n<26 && n>=0)
			{
			amount[n]++;
			}
		}

//display all occurences of each letter 
		for(int i=0;i<amount.length;i++)
		{
			if (amount[i]>0)
			{
				int x=i+97;
				char c=(char)(x);
				System.out.println(c+": "+amount[i]);
			}
		}

//allows user to loop as many times as they wish
		System.out.println("Do you want to continue? Y/N");
		answer=input.next().toLowerCase().trim();
		input.nextLine();

	}while(answer.equals("y"));

	}

}