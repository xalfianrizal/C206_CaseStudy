import java.util.ArrayList;

public class C206_CaseStudy {
	
	private static final int QUIT = 6; //Change when done
	
	private static final ArrayList<buyer> buyerList = new ArrayList<buyer>();
	private static final ArrayList<radioControlCar> radioControlCarList = new ArrayList<radioControlCar>();
	private static final ArrayList<appointment> appointmentList = new ArrayList<appointment>();
	private static final ArrayList<feedBack> feedBackList = new ArrayList<feedBack>();
	private static final ArrayList<adminAccount> adminAccountList = new ArrayList<adminAccount>();
	
	public static void main(String[] args) {
		
		buyerList.add(new buyer(1,"Adam",85658898));
		buyerList.add(new buyer(2,"Bryan",97765571));
		
		radioControlCarList.add(new radioControlCar(1,"Monster Truck","aluminum","Brushless",10.47,29.92));
		radioControlCarList.add(new radioControlCar(2,"Xray","Graphite","T-brace",9.89,28.72));
		
		appointmentList.add(new appointment(1,"Charles","23-Aug-2021","3.00PM"));
		appointmentList.add(new appointment(2,"Dillon","20-Aug-2021","12.30PM"));
		
		feedBackList.add(new feedBack(1,"Filip","Some parts are missing"));
		feedBackList.add(new feedBack(2,"Eunice","Some parts are broken"));
		
		adminAccountList.add(new adminAccount(1,"admin","admin123")); // Name/Password Use this to login to system
		
		int option = 0;
		Helper.line(30, "=");
		System.out.println("Login to access");
		Helper.line(30, "=");
		
		if(valid()) {
			while (option != QUIT) {
				menu();
				option = Helper.readInt("Enter an option > ");
				if(option == 1) {
					buyerMenu();
				}
				else if(option ==2) {
					radioControlCarMenu();
				}
				else if(option == 3) {
					radioControlCarPartsMenu();
				}
				else if(option == 4) {
					appointmentMenu();
				}
				else if(option == 5) {
					feedBackMenu();
				}
				else if(option == 6) {
					System.out.println("Successfully exited!");
				}
				else {
					System.out.println("Invalid option!");
				}
			}
			
		}
		else {
			System.out.println("Wrong Login Name or/and Password");
		}
		
		
		
		
	}
	public static boolean valid() {
		String loginName = Helper.readString("Enter Login Name > ");
		String pass = Helper.readString("Enter Password > ");
		for(int i = 0;i < adminAccountList.size(); i++) {
			if(adminAccountList.get(i).getLoginName().equalsIgnoreCase(loginName) && adminAccountList.get(i).getPassword().equals(pass)) {
				return true;
			}
			else {
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
		System.out.println("3. Radio Control Car Parts Menu");
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
	//Appointment Side
	public static void showAppointmentMenu() {
		Helper.line(30, "=");
		System.out.println("APPOINTMENT MENU");
		Helper.line(30, "=");
		System.out.println("1. Add appointment");
		System.out.println("2. Delete appointment");
		System.out.println("3. View appointment");
		System.out.println("4. Exit\n");
	}
	public static void addAppointment() {
		Helper.line(30, "-");
		System.out.println("ADD APPOINTMENT");
		Helper.line(30, "-");
		
		int appointmentID = Helper.readInt("Enter an Appointment ID > ");
		String customerName = Helper.readString("Enter the Customers Name > ");
		String date = Helper.readString("Enter the date (DD-MMM-YYYY) > ");
		String time = Helper.readString("Enter the time (TT:TT(AM/PM) > ");
		
		appointmentList.add(new appointment(appointmentID,customerName,date,time));
		System.out.println("\nSuccess!");
	}

	public static void deleteAppointment() {
		
	}
	
	public static void viewAppointment() {
		
	}
	public static void appointmentMenu() {
		int option = 0;
		while (option != 4) {
			showAppointmentMenu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) {
				addAppointment();
			}
			
			else {
			System.out.println("Invalid option! Please try again!\n");
		}
			
		}
		
	}
	
	public static void feedBackMenu() {
		
	}

}
