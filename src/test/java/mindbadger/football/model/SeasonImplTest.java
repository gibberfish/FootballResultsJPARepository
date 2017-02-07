package mindbadger.football.model;

import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import mindbadger.footballresultsanalyser.domain.SeasonDivision;

public class SeasonImplTest {
	SeasonImpl objectUnderTest;
	
	@Mock private SeasonImpl mockSeason;
	@Mock private DivisionImpl mockDivision;
	@Mock private SeasonDivisionImpl mockSeasonDivision;
	
	@Before
	public void setup () {
		MockitoAnnotations.initMocks(this);
		
		objectUnderTest = new SeasonImpl();
		objectUnderTest.setSeasonNumber(2013);
		
		when(mockSeason.getSeasonNumber()).thenReturn(2013);
		when(mockDivision.getDivisionId()).thenReturn("10");
		when(mockDivision.toString()).thenReturn("Division[10]");
		
		when(mockSeasonDivision.getSeason()).thenReturn(mockSeason);
		when(mockSeasonDivision.getDivision()).thenReturn(mockDivision);
		when(mockSeasonDivision.getDivisionPosition()).thenReturn(1);
	}
	
	
	@Test
	public void shouldProduceAReadableToStringForASeasonWithoutDivsions () {
		// Given
		
		// When
		String toString = objectUnderTest.toString();
		
		// Then
		assertEquals("Season[2013]", toString);
	}

	@Test
	public void shouldProduceAReadableToStringForASeasonWithDivsions () {
		// Given
		Set<SeasonDivision> seasonDivisions = new HashSet<SeasonDivision> ();
		seasonDivisions.add(mockSeasonDivision);
		when(mockSeason.getSeasonDivisions()).thenReturn(seasonDivisions);
		objectUnderTest.setSeasonDivisions(seasonDivisions);
		
		// When
		String toString = objectUnderTest.toString();
		
		// Then
		assertEquals("Season[2013]Division[10]", toString);
	}

	@Test
	public void shouldProduceAHashCode () {
		// When
		int hashCode = objectUnderTest.hashCode();
		
		// Then
		assertEquals(2044, hashCode);
	}
	
	@Test
	public void shouldBeEqualToAnotherDivisionWithTheSameSeasonNumber () {
		// Given
		SeasonImpl comparedSeason = new SeasonImpl();
		comparedSeason.setSeasonNumber(2013);
		
		// When
		boolean theyAreEqual = objectUnderTest.equals(comparedSeason);
		
		// Then
		assertTrue(theyAreEqual);
	}

	@Test
	public void shouldNotBeEqualToAnotherDivisionWithDifferentSeasonNumber () {
		// Given
		SeasonImpl comparedSeason = new SeasonImpl();
		comparedSeason.setSeasonNumber(2014);
		
		// When
		boolean theyAreEqual = objectUnderTest.equals(comparedSeason);
		
		// Then
		assertFalse(theyAreEqual);
	}

	@Test
	public void shouldBeEqualToAnotherDivisionWithTheSameSeasonNumberEvenIfItHasExtraDivisions () {
		// Given
		Set<SeasonDivision> seasonDivisions = new HashSet<SeasonDivision> ();
		seasonDivisions.add(mockSeasonDivision);
		when(mockSeason.getSeasonDivisions()).thenReturn(seasonDivisions);

		SeasonImpl comparedSeason = new SeasonImpl();
		comparedSeason.setSeasonNumber(2013);
		comparedSeason.setSeasonDivisions(seasonDivisions);
		
		// When
		boolean toStringsAreEqual = objectUnderTest.toString().equals(comparedSeason.toString()); 
		
		// Then
		assertFalse(toStringsAreEqual);
		
		// When
		boolean theyAreEqual = objectUnderTest.equals(comparedSeason);
		
		// Then
		assertTrue(theyAreEqual);
	}

}
