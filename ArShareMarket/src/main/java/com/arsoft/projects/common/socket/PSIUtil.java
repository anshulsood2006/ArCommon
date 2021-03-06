package com.arsoft.projects.common.socket;

public class PSIUtil {
	
	public static void main(String[] args) {
		String hexString = "68656c6c6f20636f6d7075746572";
		byte[] byteArray = convertStringToByteArray(hexString);
		hexString = convertByteArrayToString(byteArray);
		System.out.println("Hex Value is: "+hexString);
		String asciiString = convertHexStringToAsciiString(hexString);
		System.out.println("Actual Value is: "+asciiString);
		System.out.println("Length of actual value is: "+asciiString.length());
		hexString = "0x0000000f";
		System.out.println("Integer value is: "+Integer.decode(hexString));
	}

	public static String convertByteArrayToString(byte[] byteArray) {
		return new String (byteArray);
	}

	public static byte[] convertStringToByteArray(String string) {
		return string.getBytes();
	}
	
	public static String convertHexStringToAsciiString(String hexString) {
		StringBuilder output = new StringBuilder("");
		for (int i = 0; i < hexString.length(); i += 2)
		{
			String str = hexString.substring(i, i + 2);
			output.append((char) Integer.parseInt(str, 16));
			
		}
		return output.toString();
	}
	
	public static int convertByteToInt(byte[] data){
		int high = data[1] >= 0 ? data[1] : 256 + data[1];
		int low = data[0] >= 0 ? data[0] : 256 + data[0];
		int res = low | (high << 8);
		return res;
	}
	
	
	
	
}
