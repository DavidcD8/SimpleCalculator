import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math.*;

public class SimpleCalculator {

	// instance variable to holds values
	private static double results = 0;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// Calling methods in main
		firstData();
		dataProcessor();

	}

	// method firstDate will prompt user to enter first two digits and proccess them
	public static void firstData() {
		double digitOne = 0;
		double digitTwo = 0;
		char operator = 0;
		boolean runingLoop1 = true;
		boolean innerLoop = true;

		// for loop to prompt user for inputs
		while (runingLoop1) {
			Scanner sc = new Scanner(System.in);

			try { // try catch block to handle wrong inputs.
				System.out.println("Enter a number: ");
				digitOne = sc.nextDouble();

				// loop to prevent user from entering wrong input

				System.out.println("Enter sign: +,-,/,*,");
				operator = sc.next().charAt(0);
				// if (operator ==('+') || (operator == ('-') || (operator==('/') ||
				// (operator==('*'))))) {

				System.out.println("Enter second number: ");
				digitTwo = sc.nextDouble();

				// condition to prevent division by zero
				if (operator == ('/') && (digitOne == 0) && (digitTwo > 0)) {
					System.out.println("You can't divide by 0");
					continue;
				} else if (operator == ('/') && (digitTwo == 0) && (digitOne > 0)) {
					System.out.println("You can't divide by 0");
					continue;
				} else {
					break;
				}

			} catch (InputMismatchException msm) {
				System.out.println("Please enter a number!");
				msm.printStackTrace();
			}

		}

		// Switch statement to assign the right equation
		switch (operator) {
		case '+':

			results += digitOne + digitTwo;

			break;

		case '-':
			results = digitOne - digitTwo;
			break;

		case '/':
			results = digitOne / digitTwo;
			break;

		case '*':
			results = digitOne * digitTwo;
			break;

		case '%':
			results += digitOne * digitTwo / 100;
			break;
		}
		System.out.println(results);
	}

	// dataProcessor to prompt user for input and proccess the value of results from
	// method firstData
	public static void dataProcessor() {
		// local variable
		double totalToBeProccessed = 0;
		String symbol;
		boolean runingLoop2 = true;

		// for loop to prompt user for inputs
		while (runingLoop2) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter a number: ");
			totalToBeProccessed = sc.nextDouble();
			System.out.println("Enter Symbol: ");
			symbol = sc.next();

			// condition to warn user about not dividing by 0
			if (symbol.equals("/") && (totalToBeProccessed == 0)) {
				System.out.println("You can't divide by 0");
				continue;
			} else if (symbol.equals("/") && (totalToBeProccessed > 0)) {

			}

			// Switch statement to assign the right equation
			switch (symbol) {
			case "+":

				results += totalToBeProccessed;

				break;

			case "-":
				results -= totalToBeProccessed;
				break;

			case "/":
				results /= totalToBeProccessed;
				break;

			case "*":
				results *= totalToBeProccessed;
				break;

			case "%":
				results = results * totalToBeProccessed / 100;
				break;
			}
			System.out.println(results);

		}

	}

}
