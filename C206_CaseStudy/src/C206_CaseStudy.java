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
		Helper.line(30, "=");
		System.out.println("Welcome to the Radio Control Car Part Menu");
		Helper.line(30, "=");
		System.out.println("1. Add Radio Control Car Part");
		System.out.println("2. Delete Radio Control Car Part");
		System.out.println("3. View Radio Control Car Part");
		System.out.println("4. Search Radio Control Car Part");
		System.out.println("5. Quit");

	}
	public static void radioControlCarPartOption() {
		int quit = 5;
		int option = 0;
		
		while(option != quit) {
			radioControlCarPartMenu();
			option = Helper.readInt("Enter an option > ");
			if(option == 1) {
				radioControlCarPart rCCP = inputRCCPAdd();
				C206_CaseStudy.addRadioControlCarPart(radioControlCarPartList, rCCP);
			}
			else if(option == 2) {
				Integer rCCPTag = inputRCCPDelete();
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
				System.out.println("Successfully Exited Radio Control Car Part Menu");
			}
			else {
				System.out.println("Invalid Option!");
			}
		}
		System.out.println("Successfully Exited Radio Control Car Menu");
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
	public static void deleteRadioControlCarPart(ArrayList<radioControlCarPart> radioControlCarPartList,Integer inputRCCPDelete) {
		
		radioControlCarPartList.remove(inputRCCPDelete - 1);
		
		System.out.println("Successfully Deleted");
	}
	public static void viewRadioControlCarPart() {
		String output = String.format("%-10s %-20s %-20s %-10s \n", "Asset Tag","Type","Description","Available");
		for(int i = 0; i < radioControlCarPartList.size(); i++) {
			output += radioControlCarPartList.get(i).display();
		}
		System.out.println(output);
	}
	public static String inputRCCPSearch() {
		String searchType = Helper.readString("Enter the Type > ");
		
		return searchType;
	}
	public static void searchRadioControlCarPart(ArrayList<radioControlCarPart> radioControlCarPartList,String inputRCCPSearch) {
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
