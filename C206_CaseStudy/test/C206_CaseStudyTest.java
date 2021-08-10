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
	
	private ArrayList<adminAccount> adminAccountList;
	//Appointment
	private appointment app1;
	private appointment app2;
	private ArrayList<appointment> appointmentList;

	@Before
	public void setUp() throws Exception {
		//prepare test data
		//Radio Control Car Part
		rCCP1 = new radioControlCarPart(1,"Wheel","Mountain");
		rCCP2 = new radioControlCarPart(2,"Body Part","SuperLight");
		
		radioControlCarPartList = new ArrayList<radioControlCarPart>();
		
		//Prepare Test Data
		aA1 = new adminAccount(1, "admin", "admin123");
		
		adminAccountList = new ArrayList<adminAccount>();
		
		//Prepare Test Data
		//Appointment
		app1 = new appointment(1, "Charles", "23-Aug-2021", "3.00PM");
		app2 = new appointment(2, "Dillon", "20-Aug-2021", "12.30PM");
		appointmentList = new ArrayList<appointment>();
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
		
	}
	
	

}
