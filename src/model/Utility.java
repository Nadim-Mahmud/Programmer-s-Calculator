package model;

import java.util.Stack;

/**
 * this utility class will contain utiltiy mathods for various needs
 * @author Nadim Mahmud
 */

public class Utility {
	
	/**
	 * @param str number
	 * @return if the number is integer retunrn nuber after cutting off last zeros 
	 */
	public static String doubleToInt(String str) {
		String result = "";
		boolean flag = false;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='.') {
				flag = true;
				
			}
			else if(!flag)result += str.charAt(i);
			else if(flag&&(str.charAt(i)!='0')) return str;
		}
		return result;
	}
	
	public static boolean isBracketStarting(char ch) {
		
		if(ch=='('||ch=='{'||ch=='[') return true;
		return false;
	}
	
	public static boolean isBracketEnding(char ch) {
		
		if(ch==')'||ch=='}'||ch==']') return true;
		return false;
	}
	
	public static boolean isBracket(char ch) {
		if(ch=='('||ch=='{'||ch=='['||ch==')'||ch=='}'||ch==']') return true;
		return false;
	}
	
	public static boolean isOperator(char ch) {
		
		if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='^'||ch=='%'||ch=='!') return true;
		return false;
	}
	
	public static boolean isDigit(char ch) {
		if(ch>='0'&&ch<='9') return true;
		return false;
	}
	
	/**
	 * 
	 * @param ch
	 * @return precidence of operator
	 */
	public static int Prec(char ch){
		switch (ch) {
			case '+':
			case '-':
				return 1;
	
			case '*':
			case '/':
				return 2;
			case '%':
			case '!':
				return 3;
			case '^':
				return 4;
		}
		return -1;
	}
	
	public static char ending(char ch) {
		
		switch(ch) {
		case ')' : return '(' ;
		case '}' : return '{';
		case ']' : return '[';
		}
		return ' ';		
	}
	/**
	 * @param str the given expression
	 * @return if valid return true else return false
	 */
	
	public static boolean isValidExpression(String str) {
		
		Stack<Character> stack = new Stack<>();
		int sz = str.length()-1;
		
		for(int i=0; i<=sz; i++) {
			
			char ch = str.charAt(i);
			
			//checking for invalid charecter
			if(!isBracket(ch)&&!isOperator(ch)&&!isDigit(ch)&&ch!='.'&&ch!='E'&&ch!='!') return false;
			
			//checking for blank space
			if(ch==' ') return false;
			
			//Checking opeator realted error
			if(i>0&&i<sz) {
				
				char ch1 = str.charAt(i-1);
				char ch2 = str.charAt(i+1);
				
				if(isOperator(ch)) {
					if(isOperator(ch1)||isOperator(ch2)) return false;
				}
				else if(isBracketStarting(ch)) {
					if(isOperator(ch2)||isBracketEnding(ch2)) return false;
				}
				else if(isBracketEnding(ch)) {
					if(isOperator(ch1)) return false;
				}
			}
			else if(isOperator(ch)) return false;
			
			///Checking braket sequenece
			if(isBracketStarting(ch)) {
				stack.push(ch);
			}
			else if(isBracketEnding(ch)) {
				if(stack.empty()) return false;
				if(stack.peek()!=ending(ch)) return false;
				stack.pop();
			}
		}
		return true;
	}

}
