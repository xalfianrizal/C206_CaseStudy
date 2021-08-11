import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	//Radio Control Car Part
	private radioControlCarPart rCCP1;
	private radioControlCarPart rCCP2;
	
	private ArrayList<radioControlCarPart> radioControlCarPartList;
	//Admin
	private adminAccount aA1;
	
	
	private radioControlCar radioCC1;
	private radioControlCar radioCC2;
	private ArrayList<radioControlCar> radioControlCarList;

	
	private ArrayList<adminAccount> adminAccountList;
	//Appointment
	private appointment app1;
	private appointment app2;
	private ArrayList<appointment> appointmentList;
	
	//Feedback
	private feedBack fb1;
	private feedBack fb2;
	private ArrayList<feedBack> feedBackList;

	@Before
	public void setUp() throws Exception {
		//prepare test data
		//Radio Control Car Part
		rCCP1 = new radioControlCarPart(1,"Wheel","Mountain");
		rCCP2 = new radioControlCarPart(2,"Body Part","SuperLight");
		
		radioControlCarPartList = new ArrayList<radioControlCarPart>();
		
		radioCC1 = new radioControlCar(1, "Monster Truck", "aluminum", "Brushless", 10.47, 29.92);
		radioCC2 = 	new radioControlCar(2, "Xray", "Graphite", "T-brace", 9.89, 28.72);
		
		//Prepare Test Data
		aA1 = new adminAccount(1, "admin", "admin123");
		
		adminAccountList = new ArrayList<adminAccount>();
		
		//Prepare Test Data
		//Appointment
		app1 = new appointment(1, "Charles", "23-Aug-2021", "3.00PM");
		app2 = new appointment(2, "Dillon", "20-Aug-2021", "12.30PM");
		appointmentList = new ArrayList<appointment>();
		
		//Prepare Test Data
		//Feedback
		fb1 = new feedBack(1, "Filip", "Some parts are missing");
		fb2 = new feedBack(2, "Eunice", "Some parts are broken");
		feedBackList = new ArrayList<feedBack>();
	}
	
	@Test
	public void testViewAppointmentMenu() {
		String menu = "";
		menu += "==============================\n";
		menu += "APPOINTMENT MENU\n";
		menu += "==============================\n";
		menu += "1. Add appointment\n";
		menu += "2. Delete appointment\n";
		menu += "3. View appointment\n";
		menu += "4. Exit\n";
		//Test Normal | Test that both outputs are the same
		String appointmentMenu = C206_CaseStudy.showAppointmentMenu();
		assertEquals("Check that both menu are the same output", menu, appointmentMenu);
		
		//Test Error | Test that if one is not the same it is false
		String menu2 = "";
		menu2 += "==============================\n";
		menu2 += "APPOINTMENT MENU\n";
		menu2 += "==============================\n";
		menu2 += "1. Add appointment\n";
		menu2 += "2. Delete appointment\n";
		menu2 += "3. View appointment\n";
		assertNotEquals("Check that both menu are not the same output", menu2, appointmentMenu);
		
		//Test Error | Test that if we add another output, the menu is not the same.
		String menu3 = "";
		menu3 += "==============================\n";
		menu3 += "APPOINTMENT MENU\n";
		menu3 += "==============================\n";
		menu3 += "1. Add appointment\n";
		menu3 += "2. Delete appointment\n";
		menu3 += "3. View appointment\n";
		menu3 += "4. Edit appointment\n";
		menu3 += "5. Exit\n";
		assertNotEquals("Check that both menu are not the same output", menu3, appointmentMenu);
		
	}
	
	@Test
	public void testDoAddAppointment() {
		//Test Boundary | Test that the appointmentList is not null  to be able to add objects.
		assertNotNull("Check if there is a valid appointmentList ArrayList", appointmentList);
		
		//Test Normal | Test that the size of the ArrayList increases after adding an object
		C206_CaseStudy.doAddAppointment(appointmentList, app1);
		assertEquals("Check if the appointmentList size increases to one.", 1, appointmentList.size());
				
		//Test Normal | Test that the item added is the same as the one just added.
		assertSame("Check if the item just added is the same", app1, appointmentList.get(0));
				
		//Test Normal | Test that if we add another object, will the size become 2
		C206_CaseStudy.doAddAppointment(appointmentList, app2);
		assertEquals("Check if the appointmentList size increases to two.", 2, appointmentList.size());
	}
	
	@Test
	public void testDoRemoveAppointment() {
		//Test Boundary | Test that the appointmentList is not null  to be able to delete objects.
		assertNotNull("Check if there is a valid appointmentList ArrayList", appointmentList);
		
		C206_CaseStudy.doAddAppointment(appointmentList, app1);
		//Test Normal | Test that if we remove the object, will the size decrease back to 0?
		Boolean delete = C206_CaseStudy.doDeleteAppointment(appointmentList, app1.getAppointmentID());
		assertTrue("Test if that the appointment can be removed", delete);
		
		//Test Error | Test if we can remove the same object again.
		delete = C206_CaseStudy.doDeleteAppointment(appointmentList, app1.getAppointmentID());
		assertFalse("Test if  the same appointment can be removed again", delete);
		
		//Test Normal | Test that appointmentList becomes back to 0 after deletion.
		assertEquals("Check that the appointmentList size is 0.", 0, appointmentList.size());
	}
	
	@Test
	public void testViewAppointment() {
		//Test Boundary | Test that the appointmentList is not null  to be able to view the appointments.
		assertNotNull("Check if there is a valid appointmentList ArrayList", appointmentList);
		
		//Test Normal | Test that there are nothing inside the ArrayList to retrieve.
		String appointments = C206_CaseStudy.retrieveAppointment(appointmentList);
		String testAppointments = "";
		assertEquals("Check if both are the same, no retrievals.", testAppointments, appointments);
		
		//Test Normal | Add two objects and check if the arrayList size is 2.
		C206_CaseStudy.doAddAppointment(appointmentList, app1);
		C206_CaseStudy.doAddAppointment(appointmentList, app2);
		assertEquals("Check that the appointmentList size is 2.", 2, appointmentList.size());
		
		//Test Normal | Test if that the two outputs are the same once adding the two objects.
		appointments = C206_CaseStudy.retrieveAppointment(appointmentList);
		
		testAppointments += String.format("%-15d %-15s %-15s %s\n", app1.getAppointmentID(), app1.getCustomerName(), app1.getDate(), app1.getTime());
		testAppointments += String.format("%-15d %-15s %-15s %s\n", app2.getAppointmentID(), app2.getCustomerName(), app2.getDate(), app2.getTime());
		
		assertEquals("Check that both outputs are the same", testAppointments, appointments);
		
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	
	}
	@Test
	public void testradioControlCarPartMenu() {
		//normal
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
		
		String resultMenu = C206_CaseStudy.radioControlCarPartMenu();
		assertEquals("Test that the menu matches",output,resultMenu);
		
		//boundary
		String output2 = "";
		output2 += String.format("%s\n", "==========================");
		output2 += String.format("%s\n","Welcome to the Radio Control Car Part Menu");
		output2 += String.format("%s\n", "==========================");
		output2 += String.format("%s\n","1. Add Radio Control Car Part");
		output2 += String.format("%s\n","2. Delete Radio Control Car Part");
		output2 += String.format("%s\n","3. View Radio Control Car Part");
		output2 += String.format("%s\n","4. Search Radio Control Car Part");
		output2 += String.format("%s\n","5. Set Status of Radio Control Car Part");
		output2 += String.format("%s\n","5. Quit"); //Wrong should be 6
		assertNotEquals("Test that the menu do not match",output2,resultMenu);
		
		String output3 = "";
		output3 += String.format("%s\n", "==========================");
		output3 += String.format("%s\n","Welcome to the Radio Control Car Part Menu");
		output3 += String.format("%s\n", "==========================");
		output3 += String.format("%s\n","1. Add Radio Control Car Part");
		output3 += String.format("%s\n","2. Delete Radio Control Car Part");
		output3 += String.format("%s\n","3. View Radio Control Car Part");
		output3 += String.format("%s\n","4. Search Radio Control Car Part");
		output3 += String.format("%s\n","5. Set Status of Radio Control Car Part");
		
		assertNotEquals("Test that the menu do not match",output3,resultMenu);
	}
	@Test
	public void validTest() {
		//boundary
		assertNotNull("Test if there is valid admin arraylist to retrieve item from",adminAccountList);
		
		C206_CaseStudy.addAdmin(adminAccountList, aA1);
		boolean valid = C206_CaseStudy.valid(adminAccountList, "admin", "admin123");
		assertTrue("Test that password is correct",valid);
		
		valid = C206_CaseStudy.valid(adminAccountList, "admin", "Admin123");
		assertFalse("Test that password is case-sensitive",valid);
		
		valid = C206_CaseStudy.valid(adminAccountList, "admin", "111222");
		assertFalse("Test that password is incorrect",valid);
	}
	@Test
	public void retrieveRadioControlCarPartTest() {
		// Test if Item list is not null but empty - boundary
		assertNotNull("Test if there is valid Radio Control Car part arraylist to retrieve item from",radioControlCarPartList);

		// test if the list of radioControlCarPartList retrieved is empty -
		// boundary
		String allRadioControlCarPart = C206_CaseStudy.retrieveRadioControlCarPart(radioControlCarPartList);
		String testOutput = "";
		assertEquals("Test that the retrieved Chromebooklist is empty?", testOutput, allRadioControlCarPart);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		C206_CaseStudy.addRadioControlCarPart(radioControlCarPartList, rCCP1);
		C206_CaseStudy.addRadioControlCarPart(radioControlCarPartList, rCCP2);
		assertEquals("Test that radioControlCarPart arraylist size is 2", 2, radioControlCarPartList.size());

		// test if the expected output string same as the list of Radio Control Car Part
		allRadioControlCarPart = C206_CaseStudy.retrieveRadioControlCarPart(radioControlCarPartList);
		testOutput = rCCP1.display();
		testOutput += rCCP2.display();
		assertEquals("Test that radioControlCarPartList output matches", testOutput, allRadioControlCarPart);
	}
	@Test
	public void addRadioControlCarPartTest() {
		//boundary
		assertNotNull("Check if there is valid Radio Control Car Part arraylist to add to", radioControlCarPartList);
		
		C206_CaseStudy.addRadioControlCarPart(radioControlCarPartList,rCCP1);
		//Normal
		assertEquals("Test that radioControlCarPartList size is 1",1,radioControlCarPartList.size());
		assertSame("Test that rCCP1 is added into radioControlCarPartList",rCCP1,radioControlCarPartList.get(0));
		
		assertEquals("Test that Asset Tag is correctly reflected",1,rCCP1.getAssetTag());
		
		assertSame("Test that Type is correctly reflected","Wheel",rCCP1.getType());
		
		assertSame("Test that Description is correctly reflected","Mountain",rCCP1.getDescription());
		
		C206_CaseStudy.addRadioControlCarPart(radioControlCarPartList,rCCP2);
		assertEquals("Test that radioControlCarPartList size is 2",2,radioControlCarPartList.size());
		assertSame("Test that rCCP1 is added into radioControlCarPartList",rCCP2,radioControlCarPartList.get(1));
		
		assertEquals("Test that Asset Tag is correctly reflected",2,rCCP2.getAssetTag());
		
		assertSame("Test that Type is correctly reflected","Body Part",rCCP2.getType());
		
		assertSame("Test that Description is correctly reflected","SuperLight",rCCP2.getDescription());
		
	}
	@Test
	public void deleteRadioControlCarPartTest() {
		assertNotNull("Check if there is valid Radio Control Car Part arraylist to add to", radioControlCarPartList);
		
		C206_CaseStudy.addRadioControlCarPart(radioControlCarPartList,rCCP1);
		boolean isDeleted = C206_CaseStudy.deleteRadioControlCarPart(radioControlCarPartList,rCCP1.getAssetTag());
		assertTrue("Test that rCCP1 can be deleted", isDeleted);
		
		isDeleted = C206_CaseStudy.deleteRadioControlCarPart(radioControlCarPartList,rCCP1.getAssetTag());
		assertFalse("Test that rCCP1 cannot be deleted again",isDeleted);
		
		assertEquals("Test that radioControlCarPartList size is 0",0,radioControlCarPartList.size());
	}
	@Test
	public void searchRadioControlCarPartTest() {
		assertNotNull("Test if there is valid Radio Control Car part arraylist to retrieve item from",radioControlCarPartList);
		
		C206_CaseStudy.addRadioControlCarPart(radioControlCarPartList,rCCP1);
		
		boolean found = C206_CaseStudy.searchRadioControlCarPart(radioControlCarPartList, "Wheel");
		assertTrue("Test that the Type Wheel is found",found);
		
		found = C206_CaseStudy.searchRadioControlCarPart(radioControlCarPartList, "wheel");
		assertTrue("Test if it is case-sensitive",found);
		
		found = C206_CaseStudy.searchRadioControlCarPart(radioControlCarPartList, "Light");
		assertFalse("Test that the Type Light is NOT found",found);
	}
	@Test
	public void setRadioControlCarPartTest() {
		assertNotNull("Test if there is valid Radio Control Car part arraylist to set",radioControlCarPartList);
		
		C206_CaseStudy.addRadioControlCarPart(radioControlCarPartList,rCCP1);
		
		boolean set = C206_CaseStudy.setRadioControlCarPart(radioControlCarPartList, rCCP1.getAssetTag());
		assertTrue("Test that Asset Tag 1 Available can be set", set);
		assertSame("Test that Asset Tag 1 Available changed to No","No",rCCP1.showAvailability(false));
		
		set = C206_CaseStudy.setRadioControlCarPart(radioControlCarPartList, 5);
		assertFalse("Test that only available Asset Tag can set",set);
	}
	
	
	
	@Test
	public void testradioControlCarMenu() {
		String output = "";
		output += String.format("%s\n", "==========================");
		output += String.format("%s\n","Welcome to Radio Control Car Features Menu");
		output += String.format("%s\n", "==========================");
		output += String.format("%s\n","1. Add Radio Control Car Features");
		output += String.format("%s\n","2. View Radio Control Car Features");
		output += String.format("%s\n","3. Delete Radio Control Car Features");
		output += String.format("%s\n","4. Search Radio Control Car Features");
		output += String.format("%s\n","5. Quit");
		
		//Test that output have add,view,delete and search 
		String carFeaturesMenu = C206_CaseStudy.radioControlCarMenu();
		assertEquals("Check that both menu are the same output", output, carFeaturesMenu);
		
		
		String output1 = "";
		output1 += String.format("%s\n", "==========================");
		output1 += String.format("%s\n","Welcome to Radio Control Car Features Menu");
		output1 += String.format("%s\n", "==========================");
		output1 += String.format("%s\n","1. Add Radio Control Car Features");
		output1 += String.format("%s\n","2. View Radio Control Car Features");
		output1 += String.format("%s\n","3. Delete Radio Control Car Features");
		output1 += String.format("%s\n","4. Search Radio Control Car Features");
		
		//Test that output can display
		
		assertNotEquals("Check that both menu are not the same output", output1, carFeaturesMenu);
		
	
	}
	
	@Test
	public void tryAddFeatures() {
		assertEquals("Test that input is the 1",1, radioCC1.getAssetTag());

		assertSame("Test that Type is the same","Monster Truck",radioCC1.getName());
		assertSame("Test that Type is the same","aluminum",radioCC1.getMaterial());
		assertSame("Test that Type is the same","Brushless",radioCC1.getMotorType());
		
//		assertSame("Test that radioCC1 is added into radioControlCarList",radioCC1,radioControlCar.get(0));
//		
	//	C206_CaseStudy.addRadioControlCarFeatures(radioControlCarList, radioCC2);
		
//		radioCC1 = new radioControlCar(1, "Monster Truck", "aluminum", "Brushless", 10.47, 29.92);
//		
	}
	

	
	@Test
	public void testDeleteFeatures() {
		
//		public static void DeleteFeatures() {
//			viewRadioControlCarFeatures();
//			int tag = Helper.readInt("Enter asset tag to delete > ");
//			
//			if(tag == 0) {
//				System.out.println("Asset Tag is not entered.");
//			}
//			else if(checkFeaturesTag(radioControlCarList,Integer.valueOf(tag)) == false) {
//				System.out.println("No such Asset Tag");
//			}
//
//			else {
//				for(int i = 0; i < radioControlCarList.size(); i++) {
//					if(radioControlCarList.get(i).getAssetTag() == tag) {
//						radioControlCarList.remove(i);
		
		int tag = 2;
		boolean equal = false;

		
		//Test that the admin input to delete tag is the same - normal
		assertEquals("Test that deleted is same tag", tag, radioCC2.getAssetTag());
//		assertEquals("Check that the size of radioControlCarList is 1 after removing the first feedback", 2, radioControlCarList.size());
		
//
//		radioControlCarList.remove(0);
//		delete = C206_CaseStudy.doDeleteFeedback(radioControlCarList, fb1.getFeedBackID());

		
	}
	
	@Test
	public void testViewFeedbackMenu() {
		String menu = "";
		menu += "==============================\n";
		menu += "Feedback option menu\n";
		menu += "==============================\n";
		menu += "1. Add feedback\n";
		menu += "2. Delete feedback\n";
		menu += "3. View feedback\n";
		menu += "4. Exit\n";
		//Test that both outputs are the same - Normal
		String feedbackmenu = C206_CaseStudy.showFeedBackMenu();
		assertEquals("Check that both menu are the same output", menu, feedbackmenu);
		
		//Test that both outputs are different - Error
		String menu2 = "";
		menu2 += "==============================\n";
		menu2 += "Feedback option menu\n";
		menu2 += "==============================\n";
		menu2 += "1. Add feedback\n";
		menu2 += "2. Delete feedback\n";
		menu2 += "3. View feedback\n";
		assertNotEquals("Check that both menu are not the same output", menu2, feedbackmenu);
				
		//Test that both outputs are different - Error
		String menu3 = "";
		menu3 += "==============================\n";
		menu3 += "Feedback option menu\n";
		menu3 += "==============================\n";
		menu3 += "1. Add feedback\n";
		menu3 += "2. Delete feedback\n";
		menu3 += "3. View feedback\n";
		menu3 += "4. SetStatus\n";
		menu3 += "5. Exit\n";
		assertNotEquals("Check that both menu are not the same output", menu3, feedbackmenu);
	}
	
	@Test
	public void testDoAddFeedback()
	{
		//Test that feedBackList is not null so we can add in feedbacks - Boundary
		assertNotNull("Check if there is a feedBackList so that we can add in feedbacks", feedBackList);
		
		C206_CaseStudy.doAddFeedback(feedBackList, fb1);
		
		//Test that the size of feedBackList increases to 1 after adding in fb1 - Normal
		assertEquals("Check if the size of feedBackList increases to 1 after adding in fb1", 1, feedBackList.size());
				
		//Test that the feedback added is the same as the first feedback in feedBackList - Normal
		assertSame("Check if the feedback added is the same as fb1", fb1, feedBackList.get(0));
				
		//Test that the size of feedBackList increases to 2 after adding in fb2 - Normal
		C206_CaseStudy.doAddFeedback(feedBackList, fb2);
		assertEquals("Check if the size of feedBackList increases to 2 after adding in fb2", 2, feedBackList.size());
		
		//Test that the feedback added is the same as the second feedback in feedBackList - Normal
		assertSame("Check if the feedback added is the same as fb2", fb2, feedBackList.get(1));
	}
	
	@Test 
	public void testDoDeleteFeedback()
	{
		//Test that feedBackList is not null so we can add in feedbacks - Boundary
		assertNotNull("Check if there is a feedBackList so that we can delete feedbacks from feedBackList", feedBackList);
		
		C206_CaseStudy.doAddFeedback(feedBackList, fb1);
		C206_CaseStudy.doAddFeedback(feedBackList, fb2);
		//Test if the first feedback can be removed - Normal
		Boolean delete = C206_CaseStudy.doDeleteFeedback(feedBackList, fb1.getFeedBackID());
		assertTrue("Test if the first feedback can be removed", delete);
		
		//Test if we can remove the same feedback - Error
		delete = C206_CaseStudy.doDeleteFeedback(feedBackList, fb1.getFeedBackID());
		assertFalse("Test if we can remove the same feedback", delete);
		
		//Test that the size of feedBackList decreases to 1 after removing the first feedback - Normal
		assertEquals("Check that the size of feedBackList is 1 after removing the first feedback", 1, feedBackList.size());
		
		//Test if second feedback can be removed - Normal
		delete = C206_CaseStudy.doDeleteFeedback(feedBackList, fb2.getFeedBackID());
		assertTrue("Test if the second feedback can be removed", delete);
		
		//Test if we can remove the same feedback - Error
		delete = C206_CaseStudy.doDeleteFeedback(feedBackList, fb2.getFeedBackID());
		assertFalse("Test if we can remove the same feedback", delete);
		
		//Test that the size of feedBackList decreases to 0 after removing the second feedback - Normal
		assertEquals("Check that the size of feedBackList is 0 after removing the first feedback", 0, feedBackList.size());
	}
		
	@Test
	public void testViewFeedback()
	{
		//Test that feedBackList is not null so we can view feedbacks in feedBackList - Boundary
		assertNotNull("Check if there is a feedBackList so that we can add in feedbacks", feedBackList);
		
		C206_CaseStudy.doAddFeedback(feedBackList, fb1);
		//Check if size of feedBackList is 1 after adding in the first feedback
		assertEquals("Check if the size of feedBackList is 1 after adding in the first feedback", 1, feedBackList.size());
		
		C206_CaseStudy.doAddFeedback(feedBackList, fb2);
		//Check if size of feedBackList is 2 after adding in the second feedback
		assertEquals("Check if the size of feedBackList is 2 after adding in the second feedback", 2, feedBackList.size());
		
		//Check that both the outputs are the same - Normal
		String feedback = C206_CaseStudy.doViewFeedback(feedBackList);
				
		String emptyfeedback = String.format("%-15s %-15s %-30s %-10s\n", "Feedback ID", "Customer Name", "Feedback", "Status");
		emptyfeedback += fb1.display();
		emptyfeedback += fb2.display();
		
		assertEquals("Check that both outputs are the same", emptyfeedback, feedback);
	}
	
	@After
	public void tearDown() throws Exception {
		//Appointment
		app1 = null;
		app2 = null;
		appointmentList = null;
		//Radio Control Car Part
		rCCP1 = null;
		rCCP2 = null;
		radioControlCarPartList = null;
		//Admin
		aA1 = null;
		adminAccountList = null;
		//Feedback
		fb1 = null;
		fb2 = null;
		feedBackList = null;
		
		radioCC1 = null;
		radioCC2 = null;
		
	}
	
	

}
