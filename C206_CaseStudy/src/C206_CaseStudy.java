import java.util.ArrayList;

public class C206_CaseStudy {
	
	private static final int QUIT = 6; //Change when done
	
	private static final ArrayList<buyer> buyerList = new ArrayList<buyer>();
	private static final ArrayList<radioControlCar> radioControlCarList = new ArrayList<radioControlCar>();
	private static final ArrayList<radioControlCarPart> radioControlCarPartList = new ArrayList<radioControlCarPart>();
	private static final ArrayList<appointment> appointmentList = new ArrayList<appointment>();
	private static final ArrayList<feedBack> feedBackList = new ArrayList<feedBack>();
	private static final ArrayList<adminAccount> adminAccountList = new ArrayList<adminAccount>();
	
	public static void main(String[] args) {
		
		buyerList.add(new buyer(1,"Adam",85658898));
		buyerList.add(new buyer(2,"Bryan",97765571));
		
		radioControlCarList.add(new radioControlCar(1,"Monster Truck","aluminum","Brushless",10.47,29.92));
		radioControlCarList.add(new radioControlCar(2,"Xray","Graphite","T-brace",9.89,28.72));
		
		radioControlCarPartList.add(new radioControlCarPart(1,"Wheel","Mountain"));
		radioControlCarPartList.add(new radioControlCarPart(2,"Body Part","SuperLight"));
		
		appointmentList.add(new appointment(1,"Charles","23-Aug-2021","3.00PM"));
		appointmentList.add(new appointment(2,"Dillon","20-Aug-2021","12.30PM"));
		
		feedBackList.add(new feedBack(1,"Filip","Some parts are missing"));
		feedBackList.add(new feedBack(2,"Eunice","Some parts are broken"));
		
		adminAccountList.add(new adminAccount(1,"admin","admin123")); // Name/Password Use this to login to system
		
		int option = 0;
		Helper.line(30, "=");
		System.out.println("Login to access");
		Helper.line(30, "=");
		
		if(valid() == true) {
			while (option != QUIT) {
				menu();
				option = Helper.readInt("Enter an option > ");
				if(option == 1) {
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
				}
				else if(option == 5) {
					feedBackMenu();
				}
				else if(option == 6) {
					System.out.println("Successfully Exited the Application");
				}
				else {
					System.out.println("Invalid Option!");
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
		System.out.println("1. Add/View/Delete (Buyer)");
		System.out.println("2. Add/Delete/View (Radio Control Car)");
		System.out.println("3. Add/Delete/View/Search (Radio Control Car Part)");
		System.out.println("4. Add/Delete/View (Appointment)");
		System.out.println("5. Add/Delete/View (feedback)");
		System.out.println("6. Quit");
	}
	public static void buyerMenu() {
		
	}
	public static void radioControlCarMenu() {
		
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
	public static void appointmentMenu() {
		
	}
	public static void feedBackMenu() {
		
	}

}
