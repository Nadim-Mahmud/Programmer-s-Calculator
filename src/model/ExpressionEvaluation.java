package model;

import java.util.Stack;
import javax.rmi.CORBA.Util;


public class ExpressionEvaluation {	
	private static double result;
	private static Stack<Double> st = new Stack<>();
	
	/**
	 * postfix evaluating when an operator
	 * @param ch
	 */
	public static void postfixEvaluation(char ch) {	
		double tmp = 1,val1,val2;
		val2 = st.pop();
		val1 = st.pop();
		switch(ch) {
			case '+' : tmp = val1+val2;
				       break;
			case '-' : tmp = val1-val2;
					   break;
			case '*' : tmp = val1*val2;
					   break;
			case '/' : tmp = val1/val2;
					   break;
			case '^' : tmp = Math.pow(val1, val2);
					   break;
			case '%' : tmp = val1%val2;
					   break;
			case '!' : 
				tmp = Functions.factorial((long)val1);
				st.push(val2);
				break;
		}
		st.push(tmp);
	}
	
	/** The infixToPostfix method that converts given infix expression
	* to postfix expression.
	* @param exp given expression in string
	*/
	public static double evaluation(String exp)
	{	
		st.clear();
		double db,tmp;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i<exp.length();i++) {
			char c = exp.charAt(i);
			if (Character.isDigit(c)) {
				db = 0.0;
				tmp = 10;
				boolean flag = false;
				while((Character.isDigit(c)||c=='.'||c=='E')) {	
					if(c=='E') {
						i++;
						c = exp.charAt(i);
						tmp = 10;
						double pw = 0;
						while(Character.isDigit(c)) {
							pw *= tmp;
							pw += ((int)c-48);
							i++;
							if(i>=exp.length()) break;
							c = exp.charAt(i);
						}
						System.out.println(pw);
						db = Math.pow(db,pw);
						break;
					}
					else if(c=='.') {
						flag = true;
						tmp = 1.0;
					}
					else if(!flag) {
						db *= tmp;
						db += (int)(c) - 48;
					}
					else {
						tmp /= 10.0;
						db += ((double)((int)c - 48))*tmp;
					}
					i++;
					if(i>=exp.length()) break;
					c = exp.charAt(i);
				}
				st.push(db);
				i --;
			}
			else if (Utility.isBracketStarting(c)) stack.push(c);
			else if (Utility.isBracketEnding(c)){
				while (!stack.isEmpty() && !Utility.isBracketStarting(stack.peek())) postfixEvaluation(stack.pop());
				stack.pop();
			}
			else {
				while (!stack.isEmpty() && Utility.Prec(c) <= Utility.Prec(stack.peek())) {
					postfixEvaluation(stack.pop());
				}
				stack.push(c);
			}
		}
		while (!stack.isEmpty()) postfixEvaluation(stack.pop());
		return st.pop();
	}
}
