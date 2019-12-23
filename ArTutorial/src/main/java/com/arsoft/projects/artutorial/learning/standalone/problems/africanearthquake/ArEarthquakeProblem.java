package com.arsoft.projects.artutorial.learning.standalone.problems.africanearthquake;

import java.util.Scanner;
import java.util.logging.Logger;

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

public class ArEarthquakeProblem {
	
	private static final String TEXT_NOT_GREATER_THAN = " should not be greater than ";
	private static final String TEXT_TOTAL_CITIES = " Total Cities ";
	private static final String TEXT_TOTAL_ROADS = " Total Roads ";
	private static final String TEXT_TOTAL_AFFECTED_CITIES = " Total Affected Cities ";
	private static final String TEXT_INVALID_VALUE = " Invalid value ";
	private static final String TEXT_FOR = " for ";
	private static final String TEXT_EXCEPTION_IS  =" . Exception is: ";
	private static final String TEXT_GIVEN_INPUT_STRING = " in the given input string viz. ";
	
	private static Logger logger = Logger.getLogger(ArEarthquakeProblem.class.getName());
	private static int totalCities;
	private static int totalRoads;
	private static int totalAffectedCities;
	private static int totalUnaffectedCities;
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String inputString = scanner.nextLine();
		ArEarthquakeProblem problemBase = new ArEarthquakeProblem();
		problemBase.validateInput(inputString);
		scanner.close();
	}
	
	public boolean validateInput(String inputString) {
		String logMessage = "";
		if (inputString == null || "".contentEquals(inputString)) {
			logMessage = "Input string is empty";
			logger.severe(logMessage);
			return false;
		}else {
			String[] inputStringSplit = inputString.split(" ");
			if (inputStringSplit.length != 3) {
				logMessage = "Input string should contain 3 integer values separated by space i.e. '"+TEXT_TOTAL_CITIES+"'  '"+TEXT_TOTAL_ROADS+"'  '"+TEXT_TOTAL_AFFECTED_CITIES +"' e.g. 3 3 1";
				logger.severe(logMessage);
				return false;
			}
			try {
				totalCities = Integer.parseInt(inputStringSplit[0]);
				if (totalCities <= 0) {
					logMessage = TEXT_INVALID_VALUE + totalCities + TEXT_FOR + TEXT_TOTAL_CITIES + TEXT_GIVEN_INPUT_STRING + inputString ;
					logger.severe(logMessage);
					return false;
				}
			}catch(NumberFormatException e) {
				logMessage = TEXT_INVALID_VALUE + inputStringSplit[0] + TEXT_FOR + TEXT_TOTAL_CITIES + TEXT_GIVEN_INPUT_STRING + inputString + TEXT_EXCEPTION_IS + e.getLocalizedMessage();
				logger.severe(logMessage);
				return false;
			}
			try {
				totalRoads = Integer.parseInt(inputStringSplit[1]);
				if (totalRoads <= 0) {
					logMessage = TEXT_INVALID_VALUE + totalRoads + TEXT_FOR + TEXT_TOTAL_ROADS + TEXT_GIVEN_INPUT_STRING + inputString ;
					logger.severe(logMessage);
					return false;
				}
			}catch(NumberFormatException e) {
				logMessage = TEXT_INVALID_VALUE + inputStringSplit[1] + TEXT_FOR  + TEXT_TOTAL_ROADS + TEXT_GIVEN_INPUT_STRING + inputString + TEXT_EXCEPTION_IS + e.getLocalizedMessage();
				logger.severe(logMessage);
				return false;
			}
			try {
				totalAffectedCities = Integer.parseInt(inputStringSplit[2]);
				if (totalAffectedCities <= 0) {
					logMessage = TEXT_INVALID_VALUE  + totalAffectedCities + TEXT_FOR + TEXT_TOTAL_AFFECTED_CITIES + TEXT_GIVEN_INPUT_STRING + inputString ;
					logger.severe(logMessage);
					return false;
				}
				if (totalAffectedCities > totalCities) {
					logMessage = TEXT_TOTAL_AFFECTED_CITIES + totalAffectedCities + TEXT_NOT_GREATER_THAN + TEXT_TOTAL_CITIES + totalCities;
					logger.severe(logMessage);
					return false;
				}
				totalUnaffectedCities = totalCities - totalAffectedCities;
				logMessage = TEXT_TOTAL_CITIES + totalCities + TEXT_TOTAL_ROADS + totalRoads + TEXT_TOTAL_AFFECTED_CITIES + totalUnaffectedCities;
				//TODO Change logging level to fine
				logger.severe(logMessage);
				
				return true;
			}catch(NumberFormatException e) {
				logMessage = TEXT_INVALID_VALUE + inputStringSplit[2] + TEXT_FOR + TEXT_TOTAL_AFFECTED_CITIES + TEXT_GIVEN_INPUT_STRING + inputString + TEXT_EXCEPTION_IS + e.getLocalizedMessage();
				logger.severe(logMessage);
				return false;
			}
		}
	}
}
