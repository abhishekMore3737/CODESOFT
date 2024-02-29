package com;

import java.util.Scanner;
import java.util.Random;
public class JavaPro  {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();

	        System.out.println("Welcome to the Guess the Number game!");

	        // Set the range for the random number
	        int lowerLimit = 1;
	        int upperLimit = 100;
	        int secretNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;

	        // Set the maximum number of attempts
	        int maxAttempts = 7;
	        int attempts = 0;

	        while (attempts < maxAttempts) {
	            System.out.print("Guess the number between " + lowerLimit + " and " + upperLimit + ": ");
	            int userGuess = scanner.nextInt();

	            if (userGuess == secretNumber) {
	                System.out.println("Congratulations! You guessed the correct number " + secretNumber +
	                        " in " + (attempts + 1) + " attempts.");
	                break;
	            } else if (userGuess < secretNumber) {
	                System.out.println("Too low! Try again.");
	            } else {
	                System.out.println("Too high! Try again.");
	            }

	            attempts++;
	        }

	        if (attempts == maxAttempts) {
	            System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + secretNumber + ".");
	        }

	        // Close the Scanner
	        scanner.close();
	    }
	}


