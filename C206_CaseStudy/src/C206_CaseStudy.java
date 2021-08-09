import java.util.ArrayList;

public class C206_CaseStudy {

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

		appointmentList.add(new appointment(1, "Charles", "23-Aug-2021", "3.00PM"));
		appointmentList.add(new appointment(2, "Dillon", "20-Aug-2021", "12.30PM"));

		feedBackList.add(new feedBack(1, "Filip", "Some parts are missing"));
		feedBackList.add(new feedBack(2, "Eunice", "Some parts are broken"));

		adminAccountList.add(new adminAccount(1, "admin", "admin123")); // Name/Password Use this to login to system
		
		int option = 0;
		Helper.line(30, "=");
		System.out.println("Login to access");
		Helper.line(30, "=");

		if (valid()) {
			while (option != QUIT) {
				menu();
				option = Helper.readInt("Enter an option > ");
				if (option == 1) {
					buyerMenu();
				}
				else if(option == 2) {
					radioControlCarMenu();
				} 
				else if(option == 3) {
					radioControlCarPartMenu();
				}
				else if(option == 4) {
					appointmentMenu();
					
				} else if (option == 5) {
					feedBackMenu();
				}
				else if(option == 6) {
					System.out.println("Successfully Exited the Application");
				}
				else {
					System.out.println("Invalid option!");
				}
			}

		} else {
			System.out.println("Wrong Login Name or/and Password");
		}

	}

	public static boolean valid() {
		String loginName = Helper.readString("Enter Login Name > ");
		String pass = Helper.readString("Enter Password > ");
		for (int i = 0; i < adminAccountList.size(); i++) {
			if (adminAccountList.get(i).getLoginName().equalsIgnoreCase(loginName)
					&& adminAccountList.get(i).getPassword().equals(pass)) {
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
	}

	public static void radioControlCarPartsMenu() {

		
	}
	public static void radioControlCarPartMenu() {
		int quit = 5;
		
		Helper.line(30, "=");
		System.out.println("Welcome to the Radio Control Car Part Menu");
		Helper.line(30, "=");
		System.out.println("1. Add Radio Control Car Part");
		System.out.println("2. Delete Radio Control Car Part");
		System.out.println("3. View Radio Control Car Part");
		System.out.println("4. Search Radio Control Car Part");
		System.out.println("5. Quit");
		
		int option = Helper.readInt("Enter an option > ");
		
		while(option != quit) {
			if(option == 1) {
				addRadioControlCarPart();
			}
			else if(option == 2) {
				deleteRadioControlCarPart();
			}
			else if(option == 3) {
				viewRadioControlCarPart();
			}
			else if(option == 4) {
				searchRadioControlCarPart();
			}
			else if(option == 5) {
				System.out.println("Successfully Exited Radio Control Car Part Menu");
			}
			else {
				System.out.println("Invalid Option!");
			}
			option = Helper.readInt("Enter an option > ");
		}
		System.out.println("Successfully Exited Radio Control Car Menu");
	}
	public static void addRadioControlCarPart() {
		int tag = Helper.readInt("Enter asset tag > ");
		String type = Helper.readString("Enter type > ");
		String description = Helper.readString("Enter description > ");
		
		radioControlCarPartList.add(new radioControlCarPart(tag,type,description));

	}
	public static void deleteRadioControlCarPart() {
		boolean deleted = false;
		viewRadioControlCarPart();
		int tag = Helper.readInt("Enter asset tag to delete > ");
		for(int i = 0; i < radioControlCarPartList.size(); i++) {
			if(radioControlCarPartList.get(i).getAssetTag() == tag) {
				radioControlCarPartList.remove(i);
				deleted = true;
			}
		}
		if(deleted == true) {
			System.out.println("Asset Tag " + tag + " Successfully Deleted");
		}
		else {
			System.out.println("Asset Tag " + tag + " NOT DELETED");
		}
	}
	public static void viewRadioControlCarPart() {
		String output = String.format("%-10s %-20s %-20s %-10s \n", "Asset Tag","Type","Description","Available");
		for(int i = 0; i < radioControlCarPartList.size(); i++) {
			output += radioControlCarPartList.get(i).display();
		}
		System.out.println(output);
	}
	public static void searchRadioControlCarPart() {
		boolean found = false;
		String output = String.format("%-10s %-20s %-20s %-10s \n", "Asset Tag","Type","Description","Available");
		String searchType = Helper.readString("Enter the Type > ");
		for(int i = 0; i < radioControlCarPartList.size(); i++) {
			if(radioControlCarPartList.get(i).getType().equalsIgnoreCase(searchType)) {
				output += radioControlCarPartList.get(i).display();
				found = true;
			}
		}
		if(found == true) {
			System.out.println(output);
		}
		else {
			System.out.println("No such Type");
		}
	}

	//Appointment Feature
	public static void showAppointmentMenu() {
		Helper.line(30, "=");
		System.out.println("APPOINTMENT MENU");
		Helper.line(30, "=");
		System.out.println("1. Add appointment");
		System.out.println("2. Delete appointment");
		System.out.println("3. View appointment");
		System.out.println("4. Exit\n");
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
			showAppointmentMenu();
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

	public static void feedBackMenu() {

	}

}
