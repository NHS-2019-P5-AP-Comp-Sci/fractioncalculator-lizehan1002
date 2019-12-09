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
		int index = s.indexOf(" ");
		int length = s.length();
		String value1 = s.substring(0, index); // first value
		String value2 = s.substring(index + 3, length); // second value
		String operator = s.substring(index + 1, index + 2);

		int index1 = value1.indexOf("_"); // The distance of first from beginning to _.
		int index2 = value1.indexOf("/"); // The distance of first from beginning to /.

		int index3 = value2.indexOf("_"); // The distance from beginning to _.
		int index4 = value2.indexOf("/"); // The distance from beginning to /.

		int indexnegative1 = value1.indexOf("-");
		int indexnegative2 = value2.indexOf("-");

		String wholenumber1 = "";
		String numerator1 = "";
		String denominator1 = "";

		String wholenumber2 = "";
		String numerator2 = "";
		String denominator2 = "";

		if (index1 == -1 && index2 == -1) {
			wholenumber1 = value1.substring(0);
			numerator1 = "0";
			denominator1 = "1";
		}

		else if (index1 == -1 && index2 != -1) {
			wholenumber1 = "0";
			numerator1 = value1.substring(0, index2);
			denominator1 = value1.substring(index2 + 1);
		}

		else {
			wholenumber1 = value1.substring(0, index1);
			numerator1 = value1.substring(index1 + 1, index2);
			denominator1 = value1.substring(index2 + 1);
		}

		if (index3 == -1 && index4 == -1) {
			wholenumber2 = value2.substring(0);
			numerator2 = "0";
			denominator2 = "1";
		}

		else if (index3 == -1 && index4 != -1) {
			wholenumber2 = "0";
			numerator2 = value2.substring(0, index4);
			denominator2 = value2.substring(index4 + 1);
		} else { // if (index3 != -1 && index4 != -1)
			wholenumber2 = value2.substring(0, index3);
			numerator2 = value2.substring(index3 + 1, index4);
			denominator2 = value2.substring(index4 + 1);
		}
		int whole1 = Integer.parseInt(wholenumber1);
		int whole2 = Integer.parseInt(wholenumber2);
		int numerator3 = Integer.parseInt(numerator1);
		int numerator4 = Integer.parseInt(numerator2);
		int denominator3 = Integer.parseInt(denominator1);
		int denominator4 = Integer.parseInt(denominator2);
		int whole = 0;
		int numerator = 0;
		int denominator = 0;
		int gcd = 0;
		String fin = "";

		if (operator.equals("+")) {
			if (denominator3 == denominator4) {
				denominator = denominator3;
				whole = whole1 + whole2;
				if (whole1 == 0 && whole2 == 0) {
					if (indexnegative1 == -1 && indexnegative2 != -1) {
						numerator = numerator3 + numerator4;
					} else if (indexnegative1 != -1 && indexnegative2 == -1) {
						numerator = numerator3 + numerator4;
					} else {
						numerator = numerator3 + numerator4;
					}
				} else {
					if (indexnegative1 == -1 && indexnegative2 != -1) {
						numerator = Math.abs(numerator3 + -1 * numerator4);
					} else if (indexnegative1 != -1 && indexnegative2 == -1) {
						numerator = Math.abs(-1 * numerator3 + numerator4);
					} else {
						numerator = Math.abs(numerator3 + numerator4);
					}
				}
			} else if (denominator3 != denominator4) {
				denominator = denominator3 * denominator4;

				if (indexnegative1 == -1 && indexnegative2 != -1) {
					numerator = Math.abs(numerator3 * denominator4 + (-1) * numerator4 * denominator3);
				} else if (indexnegative1 != -1 && indexnegative2 == -1) {
					numerator = Math.abs(-1 * numerator3 * denominator4 + numerator4 * denominator3);
				} else {
					numerator = Math.abs(numerator3 * denominator4 + numerator4 * denominator3);
				}
				whole = whole1 + whole2;
			}
		}

		else if (operator.equals("-")) {
			whole = 0;
			if (denominator3 == denominator4) {
				denominator = denominator3;
				if (indexnegative1 == -1 && indexnegative2 != -1) {
					numerator = (Math.abs(denominator3) * Math.abs(whole1) + Math.abs(numerator3))
							- -1 * (Math.abs(denominator4) * Math.abs(whole2) + Math.abs(numerator4));
				} else if (indexnegative1 != -1 && indexnegative2 == -1) {
					numerator = -1 * (Math.abs(denominator3) * Math.abs(whole1) + Math.abs(numerator3))
							- (Math.abs(denominator4) * Math.abs(whole2) + Math.abs(numerator4));
				} else if (indexnegative1 != -1 && indexnegative2 != -1) {
					numerator = -1 * (Math.abs(denominator3) * Math.abs(whole1) + Math.abs(numerator3))
							- -1 * (Math.abs(denominator4) * Math.abs(whole2) + Math.abs(numerator4));
				} else {
					numerator = (Math.abs(denominator3) * Math.abs(whole1) + Math.abs(numerator3))
							- (Math.abs(denominator4) * Math.abs(whole2) + Math.abs(numerator4));
				}
			} else if (denominator3 != denominator4) {
				denominator = denominator3 * denominator4;
				if (indexnegative1 == -1 && indexnegative2 != -1) {
					numerator = (Math.abs(denominator3) * Math.abs(whole1) + Math.abs(numerator3)) * denominator4
							- -1 * (Math.abs(denominator4) * Math.abs(whole2) + Math.abs(numerator4)) * denominator3;
				} else if (indexnegative1 != -1 && indexnegative2 == -1) {
					numerator = -1 * (Math.abs(denominator3) * Math.abs(whole1) + Math.abs(numerator3)) * denominator4
							- (Math.abs(denominator4) * Math.abs(whole2) + Math.abs(numerator4)) * denominator3;
				} else if (indexnegative1 != -1 && indexnegative2 != -1) {
					numerator = -1 * (Math.abs(denominator3) * Math.abs(whole1) + Math.abs(numerator3)) * denominator4
							- -1 * (Math.abs(denominator4) * Math.abs(whole2) + Math.abs(numerator4)) * denominator3;
				} else {
					numerator = (Math.abs(denominator3) * Math.abs(whole1) + Math.abs(numerator3)) * denominator4
							- (Math.abs(denominator4) * Math.abs(whole2) + Math.abs(numerator4)) * denominator3;
				}
			}

		}

		else if (operator.equals("*")) {
			if ((indexnegative1 != -1 && indexnegative2 == -1) || (indexnegative1 == -1 && indexnegative2 != -1)) {
				numerator = (Math.abs(whole1 * denominator3) + (numerator3))
						* (Math.abs(whole2 * denominator4) + (numerator4));
				denominator = denominator3 * denominator4;
				whole = Math.abs(numerator / denominator) * -1;
				numerator = numerator % denominator;
			} else {
				numerator = (Math.abs(whole1 * denominator3) + (numerator3))
						* (Math.abs(whole2 * denominator4) + (numerator4));
				denominator = denominator3 * denominator4;
				whole = numerator / denominator;
				numerator = numerator % denominator;
			}
		}

		else {
			if ((indexnegative1 != -1 && indexnegative2 == -1) || (indexnegative1 == -1 && indexnegative2 != -1)) {
				numerator = Math.abs((Math.abs(whole1 * denominator3) + numerator3) * denominator4);
				denominator = Math.abs(denominator3 * (Math.abs(whole2 * denominator4) + numerator4));
				whole = -1 * Math.abs(numerator / denominator);
				if (whole != 0) {
					numerator = Math.abs(numerator % denominator);
				} else {
					numerator = -1 * Math.abs(numerator % denominator);
				}
			} else {
				numerator = Math.abs((Math.abs(whole1 * denominator3) + numerator3) * denominator4);
				denominator = Math.abs(denominator3 * (Math.abs(whole2 * denominator4) + numerator4));
				whole = numerator / denominator;
				numerator = numerator % denominator;
			}
		}

		if (numerator == 0 && whole == 0) {
			fin = "0";
		} else if (numerator == 0 && whole != 0) {
			fin = whole + "";
		} else {

			for (int i = 1; i <= Math.abs(numerator) && i <= Math.abs(denominator); i++) {
				if (numerator % i == 0 && denominator % i == 0)
					gcd = i;
			}

			numerator = numerator / gcd;
			denominator = denominator / gcd;

			if (Math.abs(numerator) > denominator && denominator != 1) {
				if (whole >= 0) {
					whole = whole + numerator / denominator;
				} else {
					whole = whole - numerator / denominator;
				}
				numerator = Math.abs(numerator % denominator);
				denominator = denominator;
				fin = whole + "_" + numerator + "/" + denominator;
			} else if (denominator == 1 && numerator != 0) {
				numerator = numerator / denominator;
				if (whole >= 0) {
					whole = whole + numerator;
				} else {
					whole = whole - numerator;
				}
				fin = whole + "";
			}

			else if (numerator < denominator && whole == 0 && numerator != 0) {
				fin = numerator + "/" + denominator;
			} else if (numerator < denominator && whole != 0) {
				fin = whole + "_" + numerator + "/" + denominator;
			}
		}

		// TODO: Implement this function to produce the solution to the input
		return fin;
	}

// TODO: Fill in the space below with any helper methods that you think you will
// need

}
