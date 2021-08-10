import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private radioControlCarPart rCCP1;
	private radioControlCarPart rCCP2;
	
	private ArrayList<radioControlCarPart> radioControlCarPartList;

	@Before
	public void setUp() throws Exception {
		//prepare test data
		rCCP1 = new radioControlCarPart(1,"Wheel","Mountain");
		rCCP2 = new radioControlCarPart(2,"Body Part","SuperLight");
		
		radioControlCarPartList = new ArrayList<radioControlCarPart>();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	
	}
	public void addRadioControlCarPartTest() {
		assertNotNull("Check if there is valid Radio Control Car Part arraylist to add to", radioControlCarPartList);
		
		C206_CaseStudy.addRadioControlCarPart(radioControlCarPartList,rCCP1);
		assertEquals("Test that radioControlCarPartList size is 1",1,radioControlCarPartList.size());
		assertSame("Test that rCCP1 is added into radioControlCarPartList",rCCP1,radioControlCarPartList.get(0));
		
		assertSame("Test that Asset Tag is correctly reflected",1,radioControlCarPartList.get(0).getAssetTag());
		
		assertSame("Test that Type is correctly reflected","Wheel",radioControlCarPartList.get(0).getType());
		
		assertSame("Test that Description is correctly reflected","Mountain Wheel",radioControlCarPartList.get(0).getDescription());
		
		C206_CaseStudy.addRadioControlCarPart(radioControlCarPartList,rCCP2);
		assertEquals("Test that radioControlCarPartList size is 2",2,radioControlCarPartList.size());
		assertSame("Test that rCCP1 is added into radioControlCarPartList",rCCP2,radioControlCarPartList.get(1));
		
		assertSame("Test that Asset Tag is correctly reflected",2,radioControlCarPartList.get(1).getAssetTag());
		
		assertSame("Test that Type is correctly reflected","Body Part",radioControlCarPartList.get(1).getType());
		
		assertSame("Test that Description is correctly reflected","SuperLight",radioControlCarPartList.get(1).getDescription());
		
	}
	public void deleteRadioControlCarPartTest() {
		assertNotNull("Check if there is valid Radio Control Car Part arraylist to add to", radioControlCarPartList);
		
		C206_CaseStudy.deleteRadioControlCarPart(radioControlCarPartList,radioControlCarPartList.get(0).getAssetTag());
		assertEquals("Test that radioControlCarPartList size is 1",1,radioControlCarPartList.size());
	}

}
