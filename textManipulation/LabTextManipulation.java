package textManipulation;
/**
 * Stores a list of National Parks input by the user and edits the users input for proper capitalization. 
 * 
 * @author BrittanyPruneau 
 * 
 * 
 */
import java.util.ArrayList;

import java.util.Scanner; 

public class LabTextManipulation 
{

	public static void main(String[] args) 
	{
		ArrayList<String> parks = new ArrayList<String>(); 
		String done = "done";
		Scanner scan = new Scanner(System.in); 
		
		boolean doneDone = true; 
		while(doneDone)
		{
			System.out.print("Please enter your favorite National Park or DONE to stop: ");
			String input = scan.nextLine();
			
			int complete = input.compareToIgnoreCase(done);
			if(complete == 0)
			{
			doneDone = false;
			}
			else
			{
				parks.add(input);
			}
		}
		
		String separator = " | ";
		String nationalParks = combineNationalParks(parks, separator);
		String updatedString = updateSpelling(nationalParks);
		System.out.println();
		System.out.println("Favorite National Parks: " + updatedString);
	}
	
	/*
	 * @returns a string of National Parks.
	 * @param parksEntered 		National Park names entered by the user.
	 * @param seperator 		Specified separator between each National Park name. 
	 */
	private static String combineNationalParks(ArrayList<String> parksEntered, String separator)
	{
		StringBuilder sb = new StringBuilder(); 
		boolean first = true; 
		for(String el : parksEntered)
		{
			if(first)
			first = false; 
			else
			{
				sb.append(separator);
			}
			sb.append(el);
		}
		String nationalParks = sb.toString();
		return nationalParks;
	}
	
	/*
	 * @returns a string of National Parks that have a capital letter at the beginning of every word and " | " between each National Park. 
	 * @param	text	Represents an ArrayList of National Parks with no uniform capitalization. 
	 */
	private static String updateSpelling(String text)
	{
		StringBuilder updatedParks = new StringBuilder(text.length());
		char k = Character.toUpperCase(text.charAt(0));
		updatedParks.append(k); // first is upper Y
		for(int i=1; i<text.length(); i++) 
		{
			if(Character.isSpaceChar(text.charAt(i)) && !Character.isLetterOrDigit(text.charAt(i+1)))
			{
				char m = text.charAt(i+1);
				updatedParks.append(" ").append(m);
				i++;
			}
			else if(Character.isSpaceChar(text.charAt(i)) && Character.isLetter(text.charAt(i+1)))
			{
				char s = Character.toUpperCase(text.charAt(i+1));
				updatedParks.append(" ").append(s);
				i++;
			}
			else
			{
				char s = Character.toLowerCase(text.charAt(i));
				updatedParks.append(s);
			}
		}
		
		return updatedParks.toString(); 
	}	
}

