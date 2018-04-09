/* This class creates an object that parses the information in a scanned business
 * card's file.
 */
import java.io.*;
public class BusinessCardParser {
	public BusinessCardParser() {
		
	}
	/**
	 *  This method loads the file referred to by document and reads through it to 
	 * find the name, phone number, and email address of the individual
	 * 
	 * @param document is a string referring to a file containing business card information
	 * @return Returns a ContactInfo object if parsing is successful, and NULL otherwise
	 */
	public ContactInfo getContactInfo(String document) {
		
		String line = null;
		String name = null;
		String phone = "";
		String email = null;
		
		try {
			//Open File
			/* If the file cannot be found, uncomment the following line:
			 * System.out.println(new File(".").getAbsoluteFile());
			 */
			FileReader fr = new FileReader(document);
			BufferedReader bf = new BufferedReader(fr);
			while((line = bf.readLine()) != null) {
				//Check if line contains name, phone or email
				//An email address should be the only line containing an @ symbol
				if(line.contains("@")) {
					email = line;
				}
				/*Phone numbers were given 3 basic formats in the example input.
				 * This section checks for lines matching that format.
				 */
				else if((line.contains("Phone:") || line.contains("Tel:")) && phone == "") {
					for(int i = line.indexOf(' '); i < line.length(); i++) {
						if(Character.isDigit(line.charAt(i))) {
							phone = phone + line.charAt(i);
						}
					}
				}
				else if(line.contains("(") && phone == "") {
					for(int i = line.indexOf('('); i < line.length(); i++) {
						if(Character.isDigit(line.charAt(i))) {
							phone = phone + line.charAt(i);
						}
					}
				}
				/*The name is typically the shortest line on a business card.
				 * This looks for the shortest line and assigns it to the name field
				 */
				else {
					if(name == null) {
						name = line;
					}
					else{
						if(line.length() < name.length()) {
							name = line;
						}
					}
				}
			}
			bf.close();
		}
		catch(FileNotFoundException ex) {
			System.out.println("Unable to open '" + document + "'");
		}
		catch(IOException ex) {
			System.out.println("Error reading file '" + document + "'");
		}
		//Test to make sure that the parsing found each piece of information
		if(name != null && phone != "" && email!= null) {
			return new ContactInfo(name, phone, email);
		}
		else {
			return null;
		}
	
	}
}
