import java.util.InputMismatchException;
import java.util.Scanner;
import java.awt.GridLayout;
import java.lang.Math.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class SimpleCalculator {

	// instance variable to holds values
	private static double results = 0;
	static Scanner sc = new Scanner(System.in);
	private static JTextField jtfAnswer;
	 
	public static void main(String[] args) {

		// frame object
		JFrame frame = new JFrame();

		// Create panel1 to hold the text field

		
		JPanel panel1 = new JPanel(new GridLayout(2,2) );
		 
		 jtfAnswer = new JTextField(20);
			panel1.add(jtfAnswer);
		  jtfAnswer.setEditable(false);
		 
		
		
		 
 
		// Create panel2 to hold buttons
		JPanel panel2 = new JPanel();
		 panel2.setLayout(new GridLayout(4,4,2,2)); // flow layout manager by default

		JPanel panel4 = new JPanel(new GridLayout(2,2));
		panel4.add(panel1, BorderLayout.NORTH);
		panel4.add(panel2, BorderLayout.CENTER);

		// Create a JButton object
				JButton buttonOne = new JButton("1");
				JButton buttonTwo = new JButton("2");
				JButton buttonThree = new JButton("3");
				JButton buttonFour = new JButton("4");
				JButton buttonfive = new JButton("5");
				JButton buttonSix = new JButton("6");
				JButton buttonSeven = new JButton("7");
				JButton buttonEight = new JButton("8");
				JButton buttonNine = new JButton("9");
				JButton buttonCero = new JButton("0");
				JButton buttonDiv = new JButton("/");
				JButton buttonMul = new JButton("*");
				JButton buttonAdd = new JButton("-");
				JButton buttonSub = new JButton("+");
				JButton buttonPer = new JButton("%");
				JButton buttonDel = new JButton("←");

				// add bottons to panel2
				panel2.add(buttonOne);
				panel2.add(buttonTwo);
				panel2.add(buttonThree);
				panel2.add(buttonDel);
				panel2.add(buttonFour);
				panel2.add(buttonfive);
				panel2.add(buttonSix);
				panel2.add(buttonDiv);
				panel2.add(buttonSeven);
				panel2.add(buttonEight);
				panel2.add(buttonNine);
				panel2.add(buttonMul);
				panel2.add(buttonPer);
				panel2.add(buttonCero);
				panel2.add(buttonAdd);
				panel2.add(buttonSub);

		// Center the frame
		frame.setLocationRelativeTo(null);
		// Close the frame upon exit
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Display the frame
		frame.setVisible(true);
		// Set the frame size
		frame.setSize(300, 450); // 400 pixels wide and 300 pixels high
		frame.add(panel4);
		frame.setTitle("Calculator");

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

	// dataProcessor to prompt user for input and process the value of results from
	// method firstData
	public static void dataProcessor() {
		// local variable
		double totalToBeProcessed = 0;
		String symbol;
		boolean runingLoop2 = true;

		// for loop to prompt user for inputs
		while (runingLoop2) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter a number: ");
			totalToBeProcessed = sc.nextDouble();
			System.out.println("Enter Symbol: ");
			symbol = sc.next();

			// condition to warn user about not dividing by 0
			if (symbol.equals("/") && (totalToBeProcessed == 0)) {
				System.out.println("You can't divide by 0");
				continue;
			} else if (symbol.equals("/") && (totalToBeProcessed > 0)) {

			}

			// Switch statement to assign the right equation
			switch (symbol) {
			case "+":

				results += totalToBeProcessed;

				break;

			case "-":
				results -= totalToBeProcessed;
				break;

			case "/":
				results /= totalToBeProcessed;
				break;

			case "*":
				results *= totalToBeProcessed;
				break;

			case "%":
				results = results * totalToBeProcessed / 100;
				break;
			}
			System.out.println(results);

		}

	}

}
