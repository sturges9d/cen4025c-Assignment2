package cen4025;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * For Assignment 2, CEN 4025C-15911, Software Development II, Valencia College.
 * 
 * @author	Stephen Sturges Jr
 * @version	09/07/2022
 */
public class TestClass {
	
	// Scanner for this Class.
	static Scanner input = new Scanner(System.in);
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ToDoList list = new ToDoList();
		int userInput;
		
		// TODO Remove the lines below before submitting.
		list.addTask("Task one.");
		list.addTask("Task two.");
		list.addTask("Task three.");
		list.addTask("Task four.");
		
		do {
			displayMenu();
			userInput = userInputInt("\nPlease enter your selection: ", 1, 4);
			switch (userInput) {
				case 1:
					list.displayTasks();
					break;
				case 2:
					list.addTask();
					break;
				case 3:
					list.removeTask();
					break;
				case 4:
					marquee("Have a great day!", '-', 3);
					break;
			} // End of switch statement.
		} while (userInput != 4);
	} // End of main method.
	
	/**
	 * 
	 */
	public static void displayMenu() {
		marquee("Main To-Do List Menu", '=', 3);
		System.out.println("[1] Display To-Do List.");
		System.out.println("[2] Add Task.");
		System.out.println("[3] Remove Task.");
		System.out.println("[4] Exit.");
	} // End of displayMenu method.

	/**
	 * 
	 * @param message
	 * @param symbol
	 * @param horizontalPadding
	 */
	public static void marquee(String message, char symbol, int horizontalPadding) {
		int horizontalPaddingBorder = (horizontalPadding * 2) + 2;
		StringBuilder builder = new StringBuilder();
		
		// Build string for top and bottom borders.
		for (int i = 0; i < message.length() + (horizontalPaddingBorder); i++) {
			builder.append(symbol);
		}
		String border = builder.toString();
		// Clear border string.
		builder.delete(0, message.length() + horizontalPaddingBorder);
		
		// Build string for message line.
		for (int i = 0; i < horizontalPadding; i++) {
			builder.append(symbol);
		}
		builder.append(" " + message + " ");
		for (int i = 0; i < horizontalPadding; i++) {
			builder.append(symbol);
		}
		String messageLine = builder.toString();
		
		// Output marquee.
		System.out.println(border);
		System.out.println(messageLine);
		System.out.println(border);
	} // End of marquee method.
	
	/**
	 * 
	 * @param inputPrompt
	 * @param lowerBound
	 * @param upperBound
	 * @return
	 */
	public static int userInputInt(String inputPrompt, int lowerBound, int upperBound) {
		int userInput = 0;	// Return variable.
		boolean goodInput = false;	// Loop control variable.
		// User input validation loop.
		while (!goodInput) {
			try {
				System.out.print(inputPrompt);
				userInput = input.nextInt();
				if (userInput >= lowerBound && userInput <= upperBound) {
					goodInput = true;
				} else {
					System.out.println("\nINVALID ENTRY: Please enter a value between " + lowerBound + " and " + upperBound + ".");
					goodInput = false;
				} // End of if-else statement.
			} catch (InputMismatchException ime) {
				System.out.println("\nINVALID ENTRY: Please enter a whole number only.");
				goodInput = false;
			} // End of try-catch statement.
		} // End of while loop.
		return userInput;
	} // End of userInputInt method.
	
} // End of TestClass class.
