package edu.century.pa4;

public class Recursion {
	
	public static int C(int n, int r)
	{
		if (r == 0 || r == n) return 1;
		  return C(n-1, r-1) + C(n-1, r);
		
	}
	
	public static int bowlingPins(int b)
	{
		if(b == 1)
		{
			return 1;
		}
		else
		{
			return (b + bowlingPins(--b));
		}
	}
	
	public static void main(String[] args){
		System.out.println(bowlingPins(7));
		System.out.println(C(6,3));
	}

}
