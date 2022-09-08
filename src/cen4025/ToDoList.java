package cen4025;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * To-Do List class for Assignment 2, CEN 4025C-15911, Software Development II, Valencia College.
 * 
 * @author	Stephen Sturges Jr
 * @version	09/07/2022
 */
public class ToDoList {
	
	// Scanner for this Object.
	private static Scanner input = new Scanner(System.in);

	// Create an ArrayList to hold To-Do List items.
	private ArrayList<String> toDoList = new ArrayList<String>();
	
	// Constants.
	private final String noTasksMessage = "\nThere are no tasks on the list.\n";
	
	/**
	 * Adds a task to the To-Do list.
	 */
	public void addTask() {
		String task = userInputString("Please enter your task: ");
		toDoList.add(task);
	}
	
	/**
	 * Adds a task to the To-Do list.
	 * 
	 * @param task
	 */
	public void addTask(String task) {
		toDoList.add(task);
	}
	
	/**
	 * Loops through the ArrayList containing To-Do list tasks and outputs tasks to the console.
	 */
	public void displayTasks() {
		if (toDoList.size() == 0) {
			System.out.println(noTasksMessage);
		} else {
			System.out.println("\nTo-Do List:");
			for (int i = 0; i < toDoList.size(); i++) {
				System.out.println("[" + (i + 1) + "] " + toDoList.get(i));
			}
		}
		System.out.println(); // Blank line for formatting.
	}
	
	/**
	 * Removes a task from the To-Do list.
	 */
	public void removeTask() {
		if (toDoList.size() == 0) {
			System.out.println(noTasksMessage);
		} else {
			displayTasks();
			System.out.println("Or enter [" + (toDoListSize() + 1) + "] to return to the main menu.");
			int index = userInputInt("\nPlease enter the number of the task you wish to remove: ", 1, toDoListSize() + 1);
			if (index != toDoListSize() + 1) {
				toDoList.remove(index - 1);
				System.out.println("\nTask [" + (index - 1) + "] removed.\n");
			}
		}
	}
	
	/**
	 * Removes a task from the To-Do list.
	 * 
	 * @param index	
	 */
	public void removeTask(int index) {
		if (toDoList.size() == 0) {
			System.out.println(noTasksMessage);
		} else {
			toDoList.remove(index - 1);
		}
	}
	
	/**
	 * Returns the size of the ArrayList containing To-Do list items.
	 * 
	 * @return
	 */
	public int toDoListSize() {
		return toDoList.size();
	}
	
	/**
	 * 
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
				userInput = Integer.parseInt(input.nextLine());
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
	
	/**
	 * 
	 * 
	 * @param inputPrompt
	 * @return
	 */
	public static String userInputString(String inputPrompt) {
		System.out.print(inputPrompt);
		String userInput = input.nextLine();
		return userInput;
	}
	
}
