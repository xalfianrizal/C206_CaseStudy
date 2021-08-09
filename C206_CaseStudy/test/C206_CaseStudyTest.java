import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	//Appointment
	private appointment app1;
	private appointment app2;
	private ArrayList<appointment> appointmentList;

	@Before
	public void setUp() throws Exception {
		//Prepare Test Data
		//Appointment
		app1 = new appointment(1, "Charles", "23-Aug-2021", "3.00PM");
		app2 = new appointment(2, "Dillon", "20-Aug-2021", "12.30PM");
		appointmentList = new ArrayList<appointment>();
	}
	
	@Test
	public void testViewAppointmentMenu() {
		
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
	
	@After
	public void tearDown() throws Exception {
		//Appointment
		app1 = null;
		app2 = null;
		appointmentList = null;
	}
	
	

}
