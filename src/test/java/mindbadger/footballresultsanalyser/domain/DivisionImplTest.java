package mindbadger.footballresultsanalyser.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mindbadger.footballresultsanalyser.domain.DivisionImpl;

public class DivisionImplTest {
	DivisionImpl objectUnderTest;
	
	@Before
	public void setup () {
		objectUnderTest = new DivisionImpl();
		objectUnderTest.setDivisionId("10");
		objectUnderTest.setDivisionName("Premier");
	}
	
	
	@Test
	public void shouldProduceAReadableToString () {
		// Given
		
		// When
		String toString = objectUnderTest.toString();
		
		// Then
		assertEquals("Division[10:Premier]", toString);
	}
	
	@Test
	public void shouldProduceAHashCode () {
		// When
		int hashCode = objectUnderTest.hashCode();
		
		// Then
		assertEquals(-2040051011, hashCode);
	}
	
	@Test
	public void shouldBeEqualToAnotherDivisionWithTheSameIdAndName () {
		// Given
		DivisionImpl comparedDivision = new DivisionImpl();
		comparedDivision.setDivisionId("10");
		comparedDivision.setDivisionName("Premier");
		
		// When
		boolean theyAreEqual = objectUnderTest.equals(comparedDivision);
		
		// Then
		assertTrue(theyAreEqual);
	}

	@Test
	public void shouldNotBeEqualToAnotherDivisionWithDifferentIdOrName () {
		// Given
		DivisionImpl comparedDivision = new DivisionImpl();
		comparedDivision.setDivisionId("10");
		comparedDivision.setDivisionName("xxxx");
		
		// When
		boolean theyAreEqual = objectUnderTest.equals(comparedDivision);
		
		// Then
		assertFalse(theyAreEqual);
	}

}
