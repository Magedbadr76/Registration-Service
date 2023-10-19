package com.stc.config;

public class TestQ {
	
	public static String stringTst(String input)
	{
		String []words =input.split(" ");
		StringBuilder result =new StringBuilder();
		
		for(String word : words)
		{
			if(!word.isEmpty())
			{
				char firstChar = Character.toUpperCase(word.charAt(0));
				result.append(firstChar).append(word.substring(1));
				result.append(" ");
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		String test ="hello world";
		String output = stringTst(test);
		System.out.println("Capitalized : "+output);

	}

}
