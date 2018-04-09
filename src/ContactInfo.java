/*	This class stores the information gathered from the business card
 * 	and contains methods to print that information
 */
public class ContactInfo {
	String name;
	String phone;
	String email;

	/**
	* Constructor to initialize a new instance with all the provided
	* information
	* @param name the name of the individual
	* @param phone the individual's phone number
	* @param email the individual's email address
	*/
	public ContactInfo(String name, String phone, String email){
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	/**
	 * @return Returns the individual's name in the format "Name: First Last"
	 */
	public String getName(){
		return "Name: " + name;
	}

	/**
	 * @return Returns the individual's phone number in the format "Phone: Number"
	 * Where Number is the individual's number as a string of digits
	 */
	public String getPhoneNumber(){
		return "Phone: " + phone;
	}

	/**
	 * @return Returns the individual's email in the format "Email: email"
	 */
	public String getEmailAddress(){
		return "Email: " + email;
	}
}
