/*
 * This class contains the user interface for the parser, allowing the user to
 * determine the file to be read, and the information that they want to know
 */
import java.util.*;

public class BusinessCard {

	public static void main(String[] args) {
		//Reads in the name of the file to be parsed
		Scanner sc = new Scanner(System.in);

		System.out.println("Please type the name of the file:");
		String doc = sc.nextLine();
		
		//Parse file using a BusinessCardParser object
		BusinessCardParser bcp = new BusinessCardParser();
		ContactInfo ci = bcp.getContactInfo(doc);
		String line = null;

		//Ensure that the file was parsed correctly
		if (ci != null) {
			/* 
			 * This section provides the user with the option to choose what information that
			 * they would like to know. it will continue to run until the user decides to stop it.
			 */
			while (true) {
				System.out.println("Please indicate what information you would like to know:");
				System.out.println("Type 'Name' for the cardholder's name");
				System.out.println("Type 'Phone' for the cardholder's phone number");
				System.out.println("Type 'Email' for the cardholder's email address ");
				System.out.println("Type 'All' to get all of the cardholder's information");
				System.out.println("Type 'Exit' to quit");
				line = sc.nextLine();
				if (line.equals("Name")) {
					System.out.println(ci.getName());
				} 
				else if (line.equals("Phone")) {
					System.out.println(ci.getPhoneNumber());
				}
				else if (line.equals("Email")) {
					System.out.println(ci.getEmailAddress());
				}
				else if (line.equals("All")) {
					System.out.println(ci.getName());
					System.out.println(ci.getPhoneNumber());
					System.out.println(ci.getEmailAddress());
				}
				else if (line.equals("Exit")) {
					break;
				}
				else {
					System.out.println("Invalid Input. Please use one of the indicated options.");
				}
			}	
		}
		sc.close();
	}

}
