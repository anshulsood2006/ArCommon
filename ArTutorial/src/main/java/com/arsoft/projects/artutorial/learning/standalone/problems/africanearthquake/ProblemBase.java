package com.arsoft.projects.artutorial.learning.standalone.problems.africanearthquake;

import java.util.Scanner;

/*
 * Problem: Reference is https://www.techgig.com/practice/question/Y0Y2NndVR2FYTUFxZElLRkhRYzdPQT09
 * Total Cities = N
 * Affected Cities = K
 * Unaffected Cities = N - K
 * Base B is one out of these N - K unaffected cities and truck goes to all K affected areas from here daily and returns back to base
 * No of bidirectional roads between two cities is M
 * 
 * Requirement:
 * Find the unaffected city from where total distance is minimum 
 * 
 * 
 * Input format
 * Line #1 N M K e.g  6 9 3 represent number of cities, number of roads, and number of affected cities
 * 
 * 
 * Next M viz. 9 lines u v and l represents city 1 , city 2 and distance between them
 * 1 2 7
 * 1 6 6
 * 2 3 1
 * 2 6 5
 * 3 4 1
 * 3 5 3
 * 4 5 1
 * 4 6 4
 * 5 6 10
 * 
 * Next K viz. 3 lines represent the affected city 
 * 3
 * 4
 * 5
 * 
 * So the unaffected cities are 1 2 and 6
 * 
 * Required output
 * The minimum distance the truck needs to travel in a day if the base is set in an optimal location.
 * 
 * N can not be less than 1
 * K can not be less than 0
 * K can not be greater than N
 *   
 * 
 * 
 * 
 * 
 */

public class ProblemBase {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] arrSplit = input.split(" ");
		int totalNumberOfCities;
		int totalAffectedCities;
		int totalUnaffectedCities;
		if (arrSplit == null || arrSplit.length !=  3) {
			System.out.println("Incorrect input");
		}else {
			System.out.println();
		}
	}
	
	public boolean validateInput(String inputString) {
		if (inputString == null ||)
		return false;
	}
}
