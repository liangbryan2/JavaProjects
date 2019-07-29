/**
Author: Monica Cua, Bryan Liang
Date: July 3
Assignment: Project 2 Hangman

This game: 
-Utilized stringbuilder class
-Utilized random class
-Built command line version of classic hangman game
**/

import java.util.Scanner;
import java.util.Random;
import java.lang.StringBuilder;

public class Hangman
{


public static void main(String [] args)
{
	Scanner input=new Scanner(System.in);
	StringBuilder stringbuilder=new StringBuilder(); //created new stringbuilder class for input
	StringBuilder userguesses=new StringBuilder(); //created new stringbuilder for guesses
	Random random=new Random(); //created random class generate random number to get random string

	String [] colors = {"red", "blue", "green", "yellow", "orange", "navy blue", "purple", "dark green", "emerald green", "flamingo pink"};
	//word bank
	int x, guessesLeft=8;
	String currentWord;
	char userInput;
	boolean correctguess=false;

	x=random.nextInt(10);
	// System.out.println(colors[x]);
	currentWord=colors[x];

	System.out.println("Welcome to Hangman!");
	System.out.println("Objective: User must correctly guess word by guessing all characters.");
	System.out.println("1. Enter any letter or digit");
	System.out.println("2. If incorrect letter or digit, guesses will decrease by one");
	System.out.println("3. You will have 8 guesses. If 8 run out, game will end.");

	for (int i=0; i<currentWord.length();i++) //created string builder's hidden phrase 
	{
		if (currentWord.charAt(i)!=' ')
		{
			stringbuilder.append("*");
		}

		else
		{
			stringbuilder.append(' '); //if there was a space in the world, it would not put asterisks 
		}
	}

	while (!stringbuilder.toString().equals(currentWord) && guessesLeft>0) //game runs until user guesses correctly OR no more guesses
	{
		System.out.println("Enter letter:");
		userInput=input.next().toLowerCase().charAt(0);
		correctguess=false;
		// System.out.println(currentWord);
		// System.out.println(stringbuilder.toString());
		while(!Character.isLetterOrDigit(userInput)) //making sure it is a digit or character,not a special character 
		{
		System.out.println("Incorrect input!");
		System.out.println("Please enter character or digit");
		userInput=input.next().toLowerCase().charAt(0);
		}

		if (userguesses.indexOf(String.valueOf(userInput)) != -1)//checking if user already guessed previous character 
			{
				System.out.println("User already input same letter");
				System.out.println("Guesses left:"+guessesLeft);
				System.out.println("Guesses made:"+userguesses);
				correctguess=true;
			}
		else {
		for  (int i=0; i<currentWord.length();i++)//checking for character and replacing if correct guess 
		{
			if (currentWord.charAt(i)==userInput){
				stringbuilder.setCharAt(i, userInput);
				correctguess=true;
				
			}

		}
		System.out.println(stringbuilder);
	}
		userguesses.append(userInput);

		if (!correctguess) //if guess is incorrect, guesses left will decrease 
			{
				guessesLeft--;
				System.out.println("Guesses left:" +guessesLeft);
			}

		if (stringbuilder.toString().equals(currentWord)) //output if user meets all conditions and wins 
		{
			System.out.println("You win!");
		}

		else if (guessesLeft==0) //output if user does not meet conditions and loses 
		{
			System.out.println("You lose!");
			System.out.println("Correct word: "+currentWord);
		}


	}



}
}

