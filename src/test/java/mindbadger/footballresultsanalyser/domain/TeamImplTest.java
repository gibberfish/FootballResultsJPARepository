package mindbadger.footballresultsanalyser.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mindbadger.football.domain.TeamImpl;

public class TeamImplTest {
	TeamImpl objectUnderTest;
	
	@Before
	public void setup () {
		objectUnderTest = new TeamImpl();
		objectUnderTest.setTeamId("10");
		objectUnderTest.setTeamName("Portsmouth");
	}
	
	@Test
	public void shouldProduceAReadableToString () {
		// Given
		
		// When
		String toString = objectUnderTest.toString();
		
		// Then
		assertEquals("Team[10:Portsmouth]", toString);
	}
	
	@Test
	public void shouldProduceAHashCode () {
		// When
		int hashCode = objectUnderTest.hashCode();
		
		// Then
		assertEquals(1472434986, hashCode);
	}
	
	@Test
	public void shouldBeEqualToAnotherTeamWithTheSameIdAndName () {
		// Given
		TeamImpl comparedTeam = new TeamImpl();
		comparedTeam.setTeamId("10");
		comparedTeam.setTeamName("Portsmouth");
		
		// When
		boolean theyAreEqual = objectUnderTest.equals(comparedTeam);
		
		// Then
		assertTrue(theyAreEqual);
	}

	@Test
	public void shouldNotBeEqualToAnotherTeamWithDifferentIdOrName () {
		// Given
		TeamImpl comparedTeam = new TeamImpl();
		comparedTeam.setTeamId("10");
		comparedTeam.setTeamName("xxxx");
		
		// When
		boolean theyAreEqual = objectUnderTest.equals(comparedTeam);
		
		// Then
		assertFalse(theyAreEqual);
	}

}
