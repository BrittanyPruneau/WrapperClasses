package wrapperClass;
import java.util.*;
import java.util.function.Predicate;
/**
 * Demonstrates the use of wrapper classes by showing bases, minimum and maximum 
 * values for different number types, printing a random character. 
 * 
 * @author Brittany Pruneau 
 *
 */
public class DemoWrapperClass
{
	public static void main(String[] args)
	{
		Random rand = new Random();

		// Method minMax:
		System.out.println(minMax());
		System.out.println();


		// Method numberRepresentations:
		int[] numbers = { 9, 17, getRandomThreeDigitNumber(), 9876, 12345};

		System.out.printf("%-7s %-7s %-6s %s%n", "Base 10", "Base 16", "Base 8", "Base 2");
		System.out.printf("%-7s %-7s %-6s %s%n", "-------", "-------", "------", "------");
		for(int n : numbers) {
		System.out.println(numberRepresentations(n));
		}
		System.out.println();

		// Method charProperties:
		char[] characters = {'8', ' ', '#', 'a', 'M', getRandomLetter()};

		for(char c : characters) {
		System.out.println(charProperties(c));
		}
		System.out.println();

		// Method parse:
		String[] numberArray = {"1.1", "2.5", "3.14","40.04", "5.325", "63.5"};

		String[] wholeNumbers = new String[10];
		for(int i = 0; i < wholeNumbers.length; i++) {
		wholeNumbers[i] = "" + (rand.nextInt(90) + 10);
		}

		System.out.println(Arrays.deepToString(numberArray)
		+ " .. sum = " + parseSum(numberArray));
		
		
		System.out.println("random letter: " + getRandomLetter());
		Character c = Character.forDigit(14, 16);
		System.out.println("printing c : " + c);
		
	}

	/*
	 * Demonstrates the minimum and maximum values for the number Wrapper Classes. 
	 */
	public static String minMax()
	{
		return "Byte   :" + " ["   +Byte.MIN_VALUE   +Byte.MAX_VALUE +"]\n"
			  +"Short  :" + " ["   +Short.MIN_VALUE  +Short.MAX_VALUE +"]\n"
			  +"Integer:" + " ["   +Integer.MIN_VALUE    +","   +Integer.MAX_VALUE +"]\n"
			  +"Long   :" + " ["   +Long.MIN_VALUE       +","   +Long.MAX_VALUE +"]\n"
			  +"Float  :" + " ["   +Float.MIN_VALUE      +","   +Float.MAX_VALUE +"]\n"
			  +"Double :" + " ["   +Double.MIN_VALUE     +","   +Double.MAX_VALUE +"]\n";
	}
	
	/*
	 * Demonstrates the use of the Wrapper Class Integer to show binary values. 
	 */
	public static String numberRepresentations(int n)
	{
		return String.format("%-8s %-8s %-8s %s", ""+n, Integer.toHexString(n), Integer.toOctalString(n), 
				Integer.toBinaryString(n));
	}
	
	/*
	 * Demonstrates the use of the Character wrapper class to find digits, whitespace and upper/lowercase characters. 
	 */
	public static String charProperties(char c)
	{
		if(Character.isDigit(c))
		{
			return ""+c+" number";
		}
		if(Character.isWhitespace(c))
		{
			return ""+c+" white space";
		}
		if(Character.isUpperCase(c))
		{
			return ""+c+" upper case";
		}
		if(Character.isLowerCase(c))
		{
			return ""+c+" lower case";
		}
		return ""+c+" ";
	}
	
	/*
	 * Demonstrates the use of the wrapper class Double and boxing. 
	 */
	public static double parseSum(String[] numbers)
	{
		//String numb2 = numbers.toString();
		
		double sum = 0; 

		if(numbers == null)
		{
			return 0;
		}
		for(int i=0; i< numbers.length; i++)
		{
			sum+= Double.parseDouble(numbers[i]); 
		}

		return sum; 
	}
	
	/*
	 * Demonstrates the use of wrapper class Character to convert an int to a Character.  
	 */
	public static char getRandomLetter()
	{
		Random random = new Random(); 
		int max = 122;
		int min = 65;
		int randomNumber = random.nextInt(max + 1 - min) + min;
		while(randomNumber>91 && randomNumber<97)
		{
			randomNumber = random.nextInt(max + 1 - min) + min;
		} 
		Character randomLetter = Character.forDigit(randomNumber,16); 
		
		
		return randomLetter;
	}
	
	/*
	 * Demonstrates the use of the wrapper class Integer and boxing. 
	 */
	public static int getRandomThreeDigitNumber()
	{
		int max = 999;
		int min = 100;
		int random = (int) Math.floor(Math.random() * (max - min + 1) ) + min;
		Integer randomInt = Integer.valueOf(random);
		return randomInt;
		
	}
}

