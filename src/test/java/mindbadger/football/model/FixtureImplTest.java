package mindbadger.football.model;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.mockito.*;
import org.junit.Before;
import org.junit.Test;

import mindbadger.footballresultsanalyser.domain.Division;
import mindbadger.footballresultsanalyser.domain.Season;
import mindbadger.footballresultsanalyser.domain.Team;

public class FixtureImplTest {
	FixtureImpl objectUnderTest;
	
	@Mock
	private Season mockSeason;
	
	@Mock
	private Division mockDivision;
	
	@Mock
	private Team mockHomeTeam;
	
	@Mock
	private Team mockAwayTeam;
	
	@Before
	public void setup () {
		MockitoAnnotations.initMocks(this);
		objectUnderTest = new FixtureImpl();
	}
	
	@Test
	public void shouldProduceAReadableToString () {
		// Given
		when (mockSeason.getSeasonNumber()).thenReturn(2003);
		when (mockHomeTeam.getTeamId()).thenReturn("200");
		when (mockAwayTeam.getTeamId()).thenReturn("301");
		
		objectUnderTest.setSeason(mockSeason);
		objectUnderTest.setHomeTeam(mockHomeTeam);
		objectUnderTest.setAwayTeam(mockAwayTeam);
		
		// When
		String toString = objectUnderTest.toString();
		
		// Then
		assertEquals("Fixture[ssn:2003,hmTm:200,awTm:301]", toString);
	}
}
