package mindbadger.footballresultsanalyser.domain;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import mindbadger.football.domain.*;
import org.mockito.*;
import org.junit.Before;
import org.junit.Test;

public class FixtureImplTest {
	FixtureImpl objectUnderTest;
	
	@Mock
	private Season mockSeason;
	
	@Mock
	private Division mockDivision;

	@Mock
	private SeasonDivision mockSeasonDivision;

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
		when (mockDivision.getDivisionId()).thenReturn("44");

		when (mockSeasonDivision.getSeason()).thenReturn(mockSeason);
		when (mockSeasonDivision.getDivision()).thenReturn(mockDivision);

		when (mockHomeTeam.getTeamId()).thenReturn("200");
		when (mockAwayTeam.getTeamId()).thenReturn("301");
		
		objectUnderTest.setSeasonDivision(mockSeasonDivision);
		objectUnderTest.setHomeTeam(mockHomeTeam);
		objectUnderTest.setAwayTeam(mockAwayTeam);
		
		// When
		String toString = objectUnderTest.toString();
		
		// Then
		assertEquals("Fixture[ssn:2003,div:44,hmTm:200,awTm:301]", toString);
	}
}
