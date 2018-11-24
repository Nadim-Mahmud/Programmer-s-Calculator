package model;

public class Functions {
	
	public static long factorial(long n) {
		long  fct = 1,i=1;
		
		for(i=1;i<=n;i++) {
			fct *= i;
		}
		return fct;
	}
}
