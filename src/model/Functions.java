package model;

import java.math.BigInteger;

public class Functions {
	
	public static long factorial(long n) {
		long  fct = 1,i=1;
		
		for(i=1;i<=n;i++) {
			fct *= i;
		}
		return fct;
	}
	
	public static String bigFactorial(long n) {
		
		BigInteger fct = new BigInteger("1");
		
		for(int i = 2; i<=n; i++) {
			fct = fct.multiply(new BigInteger(i+""));
		}
		return fct + "";
	}
}
