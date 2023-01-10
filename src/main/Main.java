package main;

import java.util.Scanner;  //importing scanner

public class Main {
	
	//main method 
	public static void main(String[] args) {
		
		while(true) {
			Scanner scanner = new Scanner(System.in);  //scanner to take input from the user
			int choice = startUp();

			
			if(choice == 1) {
				//NUMBER POWER
				System.out.print("Enter A Number Whose Power Would You Like To Calculate: ");
				int baseNumber = scanner.nextInt();  //prompting user to enter a base number
				
				System.out.print("Enter Power: ");
				int powerNumber = scanner.nextInt();  //prompting user to enter power for the base number
				
				//printing out the result by calling method 
				System.out.println("Result: "+getPower(baseNumber,powerNumber));
				
			}
			else if(choice == 2) {
				//PALINDROME
				System.out.print("Enter A String: ");
				String word = scanner.nextLine();  //prompting user to enter a string 
				
				//if the method returned true
				//means that the word is palindrome
				if(getPalindrome(word,word.length()-1,0)) {
					System.out.println(word+" is palindrome");  //printing out the result
				}
				else {  //if the method returned false, means that the word is not palindrome
					System.out.println(word+" is not plaindrome");  //printing out the result
				}
				
			}
			
			//if the choice is 3
			else if(choice == 3){
				System.out.println("Enter a string that you would like to reverse: ");
				String string = scanner.nextLine();  //taking user input using scanner
				getStringReverse(string, 0);  //calling method
			}
			
			//if the choice is 4
			else if(choice == 4) {
				String[] array = {"why","do","we","have","to","use","recursion"};  //creating an array
				
				System.out.println("Before Revering;");
				
				//using for loop to print the array
				for(int x =0;x<array.length;x++) {
					System.out.print(array[x]+",");
				}
				
				
				getReverseArray(array,0,array.length - 1);  //calling method 
				System.out.println();  //leaving a line
				System.out.println("After Reversing:");
				
				//printing the array after reversing it
				for(int x =0;x<array.length;x++) {
					System.out.print(array[x]+",");
				}
			}
			
			//if the choice is 5
			else if(choice == 5) {
				System.out.print("Enter a string: ");
				String word = scanner.nextLine();  //taking user input using scanner
				char[] array = new char[word.length()];  //initializing an array
				
				//using for loop to print the array
				for(int x =0;x<word.length();x++) {
					array[x] = word.charAt(x);
				}
				
				//calling method to perform permutation
				permutationRecursion(array, array.length);
			}
			

		}
	}
	
	private static int startUp() {
		int choice;
		System.out.println();
		System.out.println("1. Number Power\n"+"2. Palindrome\n"+"3. Reverse String\n"+"4. Reverse Array");
		System.out.print("Enter your choice: ");
		Scanner scanner = new Scanner(System.in);  //initializing scanner to get user input
		
		//using try and catch statement
		try {
			choice = scanner.nextInt();  //getting user input
		}catch(Exception e) {  //throwing exception
			return 0;
		}
		
		return choice;  //returning user choice
	}
	
	//number power method 
	private static int getPower(int base, int power) {
		if(power == 0) {  //base case of the recursive method 
			return 1;
		}
		else {
			return base * getPower(base, (power - 1));
		}
	}
	
	//palindrome method 
	private static boolean getPalindrome(String word, int last, int first) {
		
		int wordLength = word.length();  //getting length of the string 
		
		//if the integer first is greater or equals to wordLength
		if(first >= wordLength) {  //base case of the recursive method 
			return true;
		}
		else {
			char start = Character.toLowerCase(word.charAt(first));  //getting a char from the string
			char end = Character.toLowerCase(word.charAt(last));  //getting a char from the string but starting from the very back
			
			if(start == end) {  // if both of the chars are same 
				return getPalindrome(word, last - 1,first + 1);  //method calling itself
			}
			else {  //if both of the chars are not same 
				return false;  //returning false
			}
		}
		
	}
	
	
	//method reversing string
	private static void getStringReverse(String string, int x) {
		
		//base case
		if(x >= string.length()) {
			return;  //returning method
		}
		else {
			getStringReverse(string, x+1);  //method calling itself
			System.out.print(string.charAt(x));  //printing character after calling method to make it look reversed
		}
	}
	
	//method reversing an array
	private static void getReverseArray(String[] array,int start, int end) {
		
		//base case
		if(start >= end ) {
			return;  //returning 
		}
		else {
			String temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			getReverseArray(array, start +1, end -1);  //method calling itself
		}
	}
	
	
	//permutation without recursion
	private static void permutation(char[] array) {
		
		//using for loop to print the array
		for(int x =0;x<array.length;x++) {
			System.out.println(array[x]);
		}
		

		//initializing integer variable
		int m = array.length;
		
		//using while loop
		while(m > 0) {
		
			int n = array.length - 1;  //integer variable
			int x  =0;
			
			//using while loop
			while(x < n) {
				char temp = array[n - 1];
				array[n - 1] = array[n];
				array[n] = temp;
				
				n--;  //decrementing variable
				
				//using for loop to print the array
				for(int y=0;y<array.length;y++) {
					System.out.print(array[y]);
				}
				System.out.println();  //leaving a line
			}
			m--;  //decrementing variable
		}
	}
	
	//method performing permutation using recursion
	private static void permutationRecursion(char[] array, int n) {
		
		//using for loop to perform the task
		for(int x = array.length -1;x > 0;x--) {
			
			if(n != 0) {
				
				//formula
				char temp = array[x - 1];
				array[x - 1] = array[x];
				array[x] = temp;
				
				//using for loop to print the array
				for(int y=0;y<array.length;y++) {
					System.out.print(array[y]);
				}
				System.out.println();  //leaving a line
				
			}
			else {
				return;  //returning 
			}	
		}
		permutationRecursion(array, n-1);  //method calling itself 
	}

}
