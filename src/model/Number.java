package model;

public class Number {
	
	private static double number;
	
	public static double stringToDouble(String str) {
		number = Double.parseDouble(str);
		return number;
	}
}
