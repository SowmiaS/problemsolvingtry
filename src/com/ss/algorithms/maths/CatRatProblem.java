package com.ss.algorithms.maths;

public class CatRatProblem {

	public static void main(String[] args ){
		int R = 1;
		int T = 1000;
		int Vrat = 1;
		int VCat = 2;
		
		System.out.println("Welcome to Algorithms...");
		System.out.println("Radius of circle >>" +R);
		System.out.println("Time at which cat enters the circle through entrance >>" +T);
		System.out.println("Speed of Rat >>" +Vrat);
		System.out.println("Speed of Cat >>" +VCat);
		
		double result = getTime(R, T, Vrat, VCat);
		if(Double.compare(result, -1.0) == 0){
			System.out.println("Impossible for the Cat to catch Rat....");
		}else{
			System.out.println("Cat catches the rat in >>"+result);
		}
		
	}
	
	/**
	 * Java is statically typed , need to be declared before used.
	 */
	public static double getTime(int R, int T, int Vrat, int Vcat){
		double lengthOfCircle =  2 * 3.14 * R;
		
		if(Vcat <= Vrat){
			double timeToFinishOneCircleRat = lengthOfCircle / Vrat;
			if(T == 0 || T == ((int)timeToFinishOneCircleRat) ) return 0.0;
			else return -1.0;
		}else{
			return findTimeToCatchRat(T, Vrat, Vcat);
		}
	}
	
	/**
	 * This method is written as a basic level.
	 * @param t
	 * @param vrat
	 * @param vcat
	 * @return
	 */
	private static double findTimeToCatchRat(int t, int vrat, int vcat) {
		double timeNeededToCatch = 0;
		int drat = vrat * t;
		int dcat = 0;
		while (drat != dcat){
			drat += vrat;
			dcat += vcat;
			timeNeededToCatch  = timeNeededToCatch + 1.0;
		}
		return timeNeededToCatch;
	}
}
