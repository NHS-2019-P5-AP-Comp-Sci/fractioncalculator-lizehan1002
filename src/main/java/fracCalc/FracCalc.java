/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

import org.checkerframework.checker.units.qual.s;

public class FracCalc {

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
		Scanner console = new Scanner(System.in);
		System.out.print("What is the things you want to calculate?    ");
		String input = console.nextLine();
		System.out.println(produceAnswer(input));
	}

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated. For your program, this
	// will be the user input.
	// e.g. input ==> "1/2 + 3/4"
	//
	// The function should return the result of the fraction after it has been
	// calculated
	// e.g. return ==> "1_1/4"
	public static String produceAnswer(String input) {
		String s = input;
		int index = input.indexOf(" ");
		int length = s.length();
		String value2 = s.substring(index + 3, length);

		int index2 = value2.indexOf("_"); // The distance from beginning to _.
		int index3 = value2.indexOf("/"); // The distance from beginning to /.

		String wholenumber = "";
		String numerator = "";
		String denominator = "";

		if (index2 == -1 && index3 == -1) {
			wholenumber = value2.substring(0);
			numerator = "0";
			denominator = "1";
		}

		else if (index2 == -1 && index3 != -1) {
			wholenumber = "0";
			numerator = value2.substring(0, index3);
			denominator = value2.substring(index3 + 1);
		}

		else {
			// if (index2 != -1 && index != -1)
			wholenumber = value2.substring(0, index2);
			numerator = value2.substring(index2 + 1, index3);
			denominator = value2.substring(index3 + 1);
		}

		// TODO: Implement this function to produce the solution to the input
		return "whole:" + wholenumber + " numerator:" + numerator + " denominator:" + denominator;
	}

	// TODO: Fill in the space below with any helper methods that you think you will
	// need

}
