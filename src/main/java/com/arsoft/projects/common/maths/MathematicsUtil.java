package com.arsoft.projects.common.maths;

import java.math.BigInteger;

public class MathematicsUtil {
	
	public static String getBinary(String number){
		String binary = null;		
		BigInteger bigIntNum = new BigInteger(number);
		BigInteger remainder = null;
		BigInteger quotient = null;
		while (bigIntNum.compareTo(MathematicsConstant.BIGINTEGER_ZERO) > 0){
			remainder = bigIntNum.divide(MathematicsConstant.BIGINTEGER_TWO);
			quotient = bigIntNum.mod(MathematicsConstant.BIGINTEGER_TWO);
			System.out.println(remainder );
			System.out.println(quotient);
			bigIntNum = remainder;
		}
		return binary;
	}
}
