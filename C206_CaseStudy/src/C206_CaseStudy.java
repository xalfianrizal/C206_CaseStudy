import java.util.ArrayList;

public class C206_CaseStudy {
//hehehe
	private static final int QUIT = 6; // Change when done

	private static final ArrayList<buyer> buyerList = new ArrayList<buyer>();
	private static final ArrayList<radioControlCar> radioControlCarList = new ArrayList<radioControlCar>();
	private static final ArrayList<radioControlCarPart> radioControlCarPartList = new ArrayList<radioControlCarPart>();
	private static final ArrayList<appointment> appointmentList = new ArrayList<appointment>();
	private static final ArrayList<feedBack> feedBackList = new ArrayList<feedBack>();
	private static final ArrayList<adminAccount> adminAccountList = new ArrayList<adminAccount>();

	public static void main(String[] args) {

		buyerList.add(new buyer(1, "Adam", 85658898));
		buyerList.add(new buyer(2, "Bryan", 97765571));

		radioControlCarList.add(new radioControlCar(1, "Monster Truck", "aluminum", "Brushless", 10.47, 29.92));
		radioControlCarList.add(new radioControlCar(2, "Xray", "Graphite", "T-brace", 9.89, 28.72));
		
		radioControlCarPartList.add(new radioControlCarPart(1,"Wheel","Mountain"));
		radioControlCarPartList.add(new radioControlCarPart(2,"Body Part","SuperLight"));

		appointmentList.add(new appointment(1, "Charles", "23-Aug-2021", "3.00PM"));
		appointmentList.add(new appointment(2, "Dillon", "20-Aug-2021", "12.30PM"));

		feedBackList.add(new feedBack(1, "Filip", "Some parts are missing"));
		feedBackList.add(new feedBack(2, "Eunice", "Some parts are broken"));

		adminAccountList.add(new adminAccount(1, "admin", "admin123")); // Name/Password Use this to login to system
		
		int option = 0;
		Helper.line(30, "=");
		System.out.println("Login to access");
		Helper.line(30, "=");
		
		String loginName = Helper.readString("Enter Login Name > ");
		String pass = Helper.readString("Enter Password > ");

			if (valid(adminAccountList,loginName,pass) == true) {
				while (option != QUIT) {
					menu();
					option = Helper.readInt("Enter an option > ");
					if (option == 1) {
						buyerMenu();
					} else if (option == 2) {
						radioControlCarMenu();
					} else if (option == 3) {
						radioControlCarPartOption();
					} else if (option == 4) {
						appointmentMenu();
					} else if (option == 5) {
						feedBackMenu();
					} else if (option == 6) {
						System.out.println("Successfully Exited the Application");
					} else {
						System.out.println("Invalid option!");
					}
				}
			}
			else {
				System.out.println("Wrong Login Name or/and Password");
			}

	}
	public static boolean valid(ArrayList<adminAccount> adminAccountList,String loginName,String pass) {
		for(int i = 0;i < adminAccountList.size(); i++) {
			if(adminAccountList.get(i).getLoginName().equalsIgnoreCase(loginName) && adminAccountList.get(i).getPassword().equals(pass)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public static void menu() {
		Helper.line(30, "=");
		System.out.println("Welcome to the Application");
		Helper.line(30, "=");
		System.out.println("1. Buyer Menu");
		System.out.println("2. Radio Control Car Menu");
		System.out.println("3. Radio Control Car Part Menu");
		System.out.println("4. Appointment Menu");
		System.out.println("5. Feedback Menu");
		System.out.println("6. Quit");
	}

	public static void buyerMenu() {

	}
	

	public static void radioControlCarMenu() {
		Helper.line(30, "=");
		System.out.println("Radio Control car");
		Helper.line(30, "=");
		System.out.println("1. Add Features");
		System.out.println("2. View Featues");
		System.out.println("3. Delete Features");
		System.out.println("4. Quit");
		
	}

	public static void radioControlCarFeaturesOption() {
		int quit = 5;
		int option = 0;
		
		while(option != quit) {
			radioControlCarMenu();
			option = Helper.readInt("Enter an option > ");
			
			if(option == 1) {
			radioControlCar RadioCC = addFeatures();
			C206_CaseStudy.addRadioControlCarFeatures(radioControlCarList, RadioCC);
			}
			else if(option == 2) {
				viewRadioControlCarFeatures();
			}
			else if(option == 3) {
				int deleteTag = DeleteFeatures();
				C206_CaseStudy.deleteRadioControlCarFeatures(radioControlCarList, deleteTag);
			}
			else if(option == 4) {
				String search = featuresSearch();
				C206_CaseStudy.searchcarFeatures(radioControlCarList,search);
			}
			else if(option == 5) {
				System.out.println("Successfully Exited Radio Control Car Features Menu");
			}
			else {
				System.out.println("Invalid Option!");
			}
		}
	}

	public static boolean checkFeaturesTag(ArrayList<radioControlCar> radioControlCarList,int tag) {
		for(int i = 0; i < radioControlCarList.size(); i++) {
			if(radioControlCarList.get(i).getAssetTag() == tag) {
				return true;
			}
		}
		return false;
	}
	
	
	private static void addRadioControlCarFeatures(ArrayList<radioControlCar> radioControlCarList,
			radioControlCar radioCC) {
		radioControlCarList.add(radioCC);
		System.out.println("Successfully Added");
		
	}

	
	public static radioControlCar addFeatures() {
		String tag = Helper.readString("Enter asset tag > ");
		String material = Helper.readString("Enter material > ");
		String name = Helper.readString("Enter name > ");
		String motorType = Helper.readString("Enter Motor Type > ");
		double emptyString = Double.parseDouble("");
		double height = Helper.readDouble("Enter Length > ");
		double length = Helper.readDouble("Enter Length > ");

		
		if(tag.isEmpty() || name.isEmpty() || motorType.isEmpty() || height == emptyString || length == emptyString) {
			System.out.println("Please fill in the blanks");
		}
		else if(checkFeaturesTag(radioControlCarList,Integer.valueOf(tag)) == true) {
			System.out.println("Asset Tag is not unique!");			
		}
		else {
			radioControlCar RadioCC = new radioControlCar(Integer.valueOf(tag),name , material, motorType, height, length);
			return RadioCC;
		}
		return null;

	}
	
	public static Integer DeleteFeatures() {
		viewRadioControlCarPart();
		String tag = Helper.readString("Enter asset tag to delete > ");
		
		if(tag.isEmpty()) {
			System.out.println("Asset Tag is not entered.");
		}
		else if(checkFeaturesTag(radioControlCarList,Integer.valueOf(tag)) == false) {
			System.out.println("No such Asset Tag");
		}
		else {
			return Integer.valueOf(tag);
		}
		return null;
	}
	
	private static boolean deleteRadioControlCarFeatures(ArrayList<radioControlCar> radioControlCarList, int DeleteFeatures) {
		boolean deleted = false;
		for(int i = 0; i < radioControlCarList.size(); i++) {
			if(radioControlCarList.get(i).getAssetTag() == DeleteFeatures) {
				radioControlCarList.remove(i);
				deleted = true;
			}
		}
		if(deleted == true) {
			System.out.println("Successfully Deleted");
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public static String viewRadioControlCarFeatures(ArrayList<radioControlCar> radioControlCarList) {
		String output = "";
		for(int i = 0; i < radioControlCarList.size(); i++) {
			output += radioControlCarList.get(i).display();
		}
		return output;
	}
	
	
//	public static boolean searchRadioControlCarPart(ArrayList<radioControlCarPart> radioControlCarPartList,String inputRCCPSearch) {
//		boolean found = false;
//		String output = String.format("%-10s %-20s %-20s %-10s \n", "Asset Tag","Type","Description","Available");
//		for(int i = 0; i < radioControlCarPartList.size(); i++) {
//			if(radioControlCarPartList.get(i).getType().equalsIgnoreCase(inputRCCPSearch)) {
//				output += radioControlCarPartList.get(i).display();
//				found = true;
//			}
//		}
//		if(found == true) {
//			System.out.println(output);
//			return true;
//		}
//		else {
//			System.out.println("No such Type");
//			return false;
//		}
//	}
	
	public static String featuresSearch() {
		String search = Helper.readString("Enter the features > ");
		
		return search;
	}
	
	public static boolean searchcarFeatures(ArrayList<radioControlCar> radioControlList,String featuresSearch) {
		boolean found = false;
		String output = String.format("%-10s %-20s %-20s %.2f %.2f %s \n", "Asset Tag","Name", "Motor Type", "Height", "Length" ,"Available");
		for(int i = 0; i < radioControlCarList.size(); i++) {
			if(radioControlCarPartList.get(i).getType().equalsIgnoreCase(featuresSearch)) {
				output += radioControlCarList.get(i).display();
				found = true;
			}
		}
		if(found == true) {
			System.out.println(output);
			return true;
		}
		else {
			System.out.println("No such features");
			return false;
		}
	}
	
	

	private static void viewRadioControlCarFeatures() {
		String output = String.format("%-10s %-20s %-20s %.2f %.2f %s \n", "Asset Tag","Name", "Motor Type", "Height", "Length" ,"Available");
		output += viewRadioControlCarFeatures(radioControlCarList);
		System.out.println(output);
		
	}
	
	public static void radioControlCarPartsMenu() {

		
	}
	
	public static adminAccount inputAdmin() {
		int iD = Helper.readInt("Enter an ID > ");
		String username = Helper.readString("Enter an username > ");
		String pass = Helper.readString("Enter password > ");
		adminAccount aA = new adminAccount(iD,username,pass);
		
		return aA;
	}
	public static boolean addAdmin(ArrayList<adminAccount> adminAccountList, adminAccount inputAdmin) {
		adminAccountList.add(inputAdmin);
		System.out.println("Successfully added");
		
		return true;
	}
	public static String radioControlCarPartMenu() {
		String output = "";
		output += String.format("%s\n", "==========================");
		output += String.format("%s\n","Welcome to the Radio Control Car Part Menu");
		output += String.format("%s\n", "==========================");
		output += String.format("%s\n","1. Add Radio Control Car Part");
		output += String.format("%s\n","2. Delete Radio Control Car Part");
		output += String.format("%s\n","3. View Radio Control Car Part");
		output += String.format("%s\n","4. Search Radio Control Car Part");
		output += String.format("%s\n","5. Set Status of Radio Control Car Part");
		output += String.format("%s\n","6. Quit");
		
		return output;
	}
	public static void radioControlCarPartOption() {
		int quit = 6;
		int option = 0;
		
		while(option != quit) {
			System.out.println(radioControlCarPartMenu());
			option = Helper.readInt("Enter an option > ");
			if(option == 1) {
				radioControlCarPart rCCP = inputRCCPAdd();
				C206_CaseStudy.addRadioControlCarPart(radioControlCarPartList, rCCP);
			}
			else if(option == 2) {
				int rCCPTag = inputRCCPDelete();
				C206_CaseStudy.deleteRadioControlCarPart(radioControlCarPartList, rCCPTag);
			}
			else if(option == 3) {
				viewRadioControlCarPart();
			}
			else if(option == 4) {
				String rCCPType = inputRCCPSearch();
				C206_CaseStudy.searchRadioControlCarPart(radioControlCarPartList,rCCPType);
			}
			else if(option == 5) {
				int rCCPSet = inputRCCPSet();
				C206_CaseStudy.setRadioControlCarPart(radioControlCarPartList, rCCPSet);
			}
			else if(option == 6) {
				System.out.println("Successfully Exited Radio Control Car Part Menu");
			}
			else {
				System.out.println("Invalid Option!");
			}
		}
	}
	public static boolean checkRCCPTag(ArrayList<radioControlCarPart> radioControlCarPartList,int tag) {
		for(int i = 0; i < radioControlCarPartList.size(); i++) {
			if(radioControlCarPartList.get(i).getAssetTag() == tag) {
				return true;
			}
		}
		return false;
	}
	public static radioControlCarPart inputRCCPAdd() {
		String tag = Helper.readString("Enter asset tag > ");
		String type = Helper.readString("Enter type > ");
		String description = Helper.readString("Enter description > ");
		
		if(tag.isEmpty() || type.isEmpty() || description.isEmpty()) {
			System.out.println("Please fill in the blanks");
		}
		else if(checkRCCPTag(radioControlCarPartList,Integer.valueOf(tag)) == true) {
			System.out.println("Asset Tag is not unique!");			
		}
		else {
			radioControlCarPart rCCP = new radioControlCarPart(Integer.valueOf(tag),type,description);
			
			return rCCP;
		}
		return null;
	}
	public static void addRadioControlCarPart(ArrayList<radioControlCarPart> radioControlCarPartList,radioControlCarPart rCCP) {
		
		radioControlCarPartList.add(rCCP);
		
		System.out.println("Successfully Added");
	}
	public static Integer inputRCCPDelete() {
		viewRadioControlCarPart();
		String tag = Helper.readString("Enter asset tag to delete > ");
		
		if(tag.isEmpty()) {
			System.out.println("Asset Tag is not entered.");
		}
		else if(checkRCCPTag(radioControlCarPartList,Integer.valueOf(tag)) == false) {
			System.out.println("No such Asset Tag");
		}
		else {
			return Integer.valueOf(tag);
		}
		return null;
	}
	public static boolean deleteRadioControlCarPart(ArrayList<radioControlCarPart> radioControlCarPartList,Integer inputRCCPDelete) {
		boolean deleted = false;
		for(int i = 0; i < radioControlCarPartList.size(); i++) {
			if(radioControlCarPartList.get(i).getAssetTag() == inputRCCPDelete) {
				radioControlCarPartList.remove(i);
				deleted = true;
			}
		}
		if(deleted == true) {
			System.out.println("Successfully Deleted");
			return true;
		}
		else {
			return false;
		}
	}
	public static String retrieveRadioControlCarPart(ArrayList<radioControlCarPart> radioControlCarPartList) {
		String output = "";
		for(int i = 0; i < radioControlCarPartList.size(); i++) {
			output += radioControlCarPartList.get(i).display();
		}
		return output;
	}
	public static void viewRadioControlCarPart() {
		String output = String.format("%-10s %-20s %-20s %s \n", "Asset Tag","Type","Description","Available");
		output += retrieveRadioControlCarPart(radioControlCarPartList);
		System.out.println(output);
	}
	public static String inputRCCPSearch() {
		String searchType = Helper.readString("Enter the Type > ");
		
		return searchType;
	}
	public static boolean searchRadioControlCarPart(ArrayList<radioControlCarPart> radioControlCarPartList,String inputRCCPSearch) {
		boolean found = false;
		String output = String.format("%-10s %-20s %-20s %-10s \n", "Asset Tag","Type","Description","Available");
		for(int i = 0; i < radioControlCarPartList.size(); i++) {
			if(radioControlCarPartList.get(i).getType().equalsIgnoreCase(inputRCCPSearch)) {
				output += radioControlCarPartList.get(i).display();
				found = true;
			}
		}
		if(found == true) {
			System.out.println(output);
			return true;
		}
		else {
			System.out.println("No such Type");
			return false;
		}
	}
	public static Integer inputRCCPSet() {
		viewRadioControlCarPart();
		String tag = Helper.readString("Enter asset tag to set Availability > ");
		
		if(tag.isEmpty()) {
			System.out.println("Asset Tag is not entered.");
		}
		else if(checkRCCPTag(radioControlCarPartList,Integer.valueOf(tag)) == false) {
			System.out.println("No such Asset Tag");
		}
		else {
			return Integer.valueOf(tag);
		}
		return null;
	}
	public static boolean setRadioControlCarPart(ArrayList<radioControlCarPart> radioControlCarPartList,Integer inputRCCPSet) {
		boolean set = false;
		for(int i = 0; i < radioControlCarPartList.size(); i++) {
			if(radioControlCarPartList.get(i).getAssetTag() == inputRCCPSet) {
				radioControlCarPartList.get(i).setAvailable(false);
				set = true;
			}
		}
		if(set == true) {
			System.out.println("Successfully Updated");
			
			return true;
		}
		else {
			return false;
		}
	}

	//Appointment Feature
	public static String showAppointmentMenu() {
		String output = "";
		output += "==============================\n";
		output += "APPOINTMENT MENU\n";
		output += "==============================\n";
		output += "1. Add appointment\n";
		output += "2. Delete appointment\n";
		output += "3. View appointment\n";
		output += "4. Exit\n";
		return output;
	}

	public static boolean checkAppointmentIDExists(int appID) {
		boolean check = false;
		for (int i = 0; i < appointmentList.size(); i++) {
			if (appointmentList.get(i).getAppointmentID() == appID) {
				check = true;
			}
		}
		return check;

	}

	public static boolean checkAppointmentDateTimeExists(String Date, String Time) {
		boolean check = false;
		for (int i = 0; i < appointmentList.size(); i++) {
			if (appointmentList.get(i).getDate().equals(Date) && appointmentList.get(i).getTime().equals(Time)) {
				check = true;
			}
		}
		return check;

	}
	
	public static void doAddAppointment(ArrayList<appointment> appointmentList, appointment app) {
		appointmentList.add(app);
		System.out.println("\nThe appointment has been added successfully!");
	}

	public static void addAppointment() {
		Helper.line(30, "-");
		System.out.println("ADD APPOINTMENT");
		Helper.line(30, "-");

		int appointmentID = Helper.readInt("Enter an Appointment ID > ");
		String customerName = Helper.readString("Enter the Customers Name > ");
		String date = Helper.readString("Enter the date (DD-MMM-YYYY) > ");
		String time = Helper.readString("Enter the time (TT:TT(AM/PM) > ");

		if (customerName.isEmpty() && date.isEmpty() && time.isEmpty()) {
			System.out.println("Please do not leave the fields empty! Add failed!");
		} 
		
		else if (checkAppointmentDateTimeExists(date, time) == true) {
			System.out.println("The date and timeslot  has already been taken! Add failed!");
		}

		else if (checkAppointmentIDExists(appointmentID) == true) {
			System.out.println("Appointment ID already exists! Add failed!");
		}

		else {
			appointment app = new appointment(appointmentID, customerName, date, time);
			doAddAppointment(appointmentList, app);
		}
	}
	
	public static boolean doDeleteAppointment(ArrayList<appointment> appointmentList, int appID) {
		boolean deleted = false;
		for (int i = 0; i < appointmentList.size(); i++) {
			appointment appointment = appointmentList.get(i);
			if (appointment.getAppointmentID() == appID) {
				appointmentList.remove(i);
				deleted = true;
			}
		}
		return deleted;
	}

	public static void deleteAppointment() {
		Helper.line(30, "-");
		System.out.println("DELETE APPOINTMENT");
		Helper.line(30, "-");
		String name = Helper.readString("Enter name of the customer to delete appointment > ");
		
		if (checkCustomerNameExist(name) == true) {
			displaySearch(name);
			int appointmentID = Helper.readInt("Enter the appointment ID to delete > ");
			char confirm = Helper.readChar("Confirm to delete appointment ID: " + appointmentID + " ? (Y/N)");
			
			boolean delete = doDeleteAppointment(appointmentList, appointmentID);
			if (confirm == 'Y' || confirm == 'y') {
				if (delete) {
					System.out.println("Delete complete!");
				}
				else {
					System.out.println("Delete failed!");
				}
				
			}
			
			else if (confirm == 'N' || confirm == 'n') {
				System.out.println("Delete cancelled!");
			}
			
			else {
				System.out.println("Failed to confirm, delete failed!");
			}
		}
		
		else if (!checkCustomerNameExist(name)) {
			System.out.println("Name does not exist in the records!");
		}
		
	}
	
	public static void displaySearch(String name) {
		String output = String.format("%-15s %-15s %-15s %s\n", "APPOINTMENT ID", "CUSTOMER NAME", "DATE", "TIME");
		for (int i = 0; i < appointmentList.size(); i++) {
			appointment appointment = appointmentList.get(i);
			if (appointment.getCustomerName().equalsIgnoreCase(name)) {
				output += String.format("%-15d %-15s %-15s %s\n", appointment.getAppointmentID(), appointment.getCustomerName(), appointment.getDate(), appointment.getTime());
			}
		}
		System.out.println(output);
	}
		

	private static boolean checkCustomerNameExist(String name) {
		boolean check = false;
		for (int i = 0; i < appointmentList.size(); i++) {
			appointment appointment = appointmentList.get(i);
			if (appointment.getCustomerName().equalsIgnoreCase(name)) {
				check = true;
			}
		}
		return check;
	}
	
	public static String retrieveAppointment(ArrayList<appointment> appointmentList) {
		String output = "";
		for (int i = 0; i < appointmentList.size(); i++) {
			appointment appointment = appointmentList.get(i);
			output += String.format("%-15d %-15s %-15s %s\n", appointment.getAppointmentID(), appointment.getCustomerName(), appointment.getDate(), appointment.getTime());
		}
		return output;
	}

	public static void viewAppointment(ArrayList<appointment> appointmentList) {
		Helper.line(30, "-");
		System.out.println("VIEW APPOINTMENT");
		Helper.line(30, "-");
		
		String output = String.format("%-15s %-15s %-15s %s\n", "APPOINTMENT ID", "CUSTOMER NAME", "DATE", "TIME");
		output += retrieveAppointment(appointmentList);
		
		System.out.println(output);
	}

	public static void appointmentMenu() {
		int option = 0;
		while (option != 4) {
			System.out.println(showAppointmentMenu());
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				addAppointment();
			}
			
			else if (option == 2) {
				deleteAppointment();
			}
			
			else if (option == 3) {
				viewAppointment(appointmentList);
			}

			else if (option == 4) {
				System.out.println("Returning to application menu...\n");
			}

			else {
				System.out.println("Invalid option! Please try again!\n");
			}

		}

	}
	
	//End of Appointment Feature

	public static String showFeedBackMenu() {
		String menu = "";
		menu += "==============================\n";
		menu += "Feedback option menu\n";
		menu += "==============================\n";
		menu += "1. Add feedback\n";
		menu += "2. Delete feedback\n";
		menu += "3. View feedback\n";
		menu += "4. Exit\n";
		
		return menu;
	}

	public static void feedBackMenu()
	{
		int exit = 4;
		
		int option = -1;
		
		while (option != exit)
		{
			System.out.println(showFeedBackMenu());
			option = Helper.readInt("Please enter an option > ");
			if (option == 1)
			{
				addFeedback();
			}
			
			else if (option == 2)
			{
				deleteFeedback();
			}
			
			else if (option == 3)
			{
				viewFeedback();
			}
			
			else if (option == 4)
			{
				System.out.println("Returning to main menu...");
			}
			
			else 
			{
				System.out.println("Invalid option!");
			}
		}
	}

	public static void addFeedback()
	{
		int feedbackID = Helper.readInt("Enter feedback ID > ");
		String buyerName = Helper.readString("Enter name > ");
		String feedback = Helper.readString("Enter feedback > ");
		
		String output = "";
		
		if (checkFeedbackIDExists(feedbackID) == false)
		{
			if (checkFeedbackNameExists(buyerName) == false)
			{
				if (!buyerName.isEmpty())
				{
					if (!feedback.isEmpty())
					{
						feedBack fb = new feedBack(feedbackID, buyerName, feedback);
						doAddFeedback(feedBackList, fb);
					}
					
					else
					{
						output = "Feedback is empty! Feedback not added!";
					}
				}
				
				else
				{
					output = "Name is empty! Feedback not added!";
				}
			}
			
			else
			{
				output = "Name already exists! Feedback not added!";
			}
		}
		
		else
		{
			output = "ID already exists! Feedback not added!";
		}
		
		System.out.println(output);
		feedBackMenu();
	}

	public static void doAddFeedback(ArrayList<feedBack> feedBackList, feedBack fb)
	{
		feedBackList.add(fb);
		System.out.println("The feedback has been added!");
		System.out.println("");
	}

	public static boolean checkFeedbackIDExists(int feedbackID)
	{
		boolean exists = false;
		
		for (int i = 0; i < feedBackList.size(); i++)
		{
			if (feedBackList.get(i).getFeedBackID() == feedbackID)
			{
				exists = true;
			}
		}
		
		return exists;
	}

	public static boolean checkFeedbackNameExists(String name) 
	{
		boolean exists = false;
		
		for (int i = 0; i < feedBackList.size(); i++)
		{
			if (feedBackList.get(i).getCustomerName().equalsIgnoreCase(name))
			{
				exists = true;
			}
		}
		
		return exists;
	}

	public static void deleteFeedback()
	{
		int id = Helper.readInt("Enter ID to delete > ");
		for (int i = 0; i < feedBackList.size(); i++)
		{
			if (feedBackList.get(i).getFeedBackID() == id)
			{
				char delete = Helper.readChar("Are you sure you want to delete this feedback? > ");
				
				if (delete == 'y' || delete == 'Y')
				{
					doDeleteFeedback(feedBackList, id);
				}
			}
			
		}
	}

	public static boolean doDeleteFeedback(ArrayList<feedBack> feedBackList, int fbdelete)
	{
		boolean fbdeleted = false;
		
		for (int i = 0; i < feedBackList.size(); i++)
		{
			feedBack fb = feedBackList.get(i);
			
			if (fb.getFeedBackID() == fbdelete)
			{
				feedBackList.remove(i);	
				System.out.println("Feedback deleted!");
				System.out.println("");
				fbdeleted = true;
			}
		}
		
		return fbdeleted;
	}

	public static void viewFeedback() 
	{
		String output = doViewFeedback(feedBackList);
		
		System.out.println(output);
	}
	
	public static String doViewFeedback(ArrayList<feedBack> feedBackList) {
		String output = String.format("%-15s %-15s %-30s %-10s\n", "Feedback ID", "Customer Name", "Feedback", "Status");
		for (int i = 0; i < feedBackList.size(); i++)
		{
			output += String.format("%-15d %-15s %-30s %-10s\n", feedBackList.get(i).getFeedBackID(), feedBackList.get(i).getCustomerName(), feedBackList.get(i).getMessage(), 
					feedBackList.get(i).getStatus());
		}
		return output;
	}

}
