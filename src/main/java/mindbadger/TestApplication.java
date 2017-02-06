package mindbadger;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.jta.JtaTransactionManager;

import mindbadger.footballresultsanalyser.domain.Season;
import mindbadger.footballresultsanalyser.domain.SeasonDivision;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class TestApplication extends JpaBaseConfiguration {

	protected TestApplication(DataSource dataSource, JpaProperties properties,
			ObjectProvider<JtaTransactionManager> jtaTransactionManagerProvider) {
		super(dataSource, properties, jtaTransactionManagerProvider);
		// TODO Auto-generated constructor stub
	}

	private static final Logger log = LoggerFactory.getLogger(TestApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class);
	}

	@Bean
	public CommandLineRunner demo(DivisionRepository divisionRepository, SeasonRepository seasonRepository) {
		return (args) -> {
			
			log.error("************ STEP 1: Create new division *************");
			
			DivisionImpl division1 = new DivisionImpl("100", "Premier Fish");
			log.info("Created new Division : " + division1.toString());
			
			DivisionImpl savedDivision = divisionRepository.save(division1);

			log.info("division1 hashCode: " + division1.hashCode() + " / savedDivsion hashCode: " + savedDivision.hashCode());
			if (division1 == savedDivision) {
				log.info("The Division returned by save is the same as the one passed in");
			}
			if (division1.equals(savedDivision)) {
				log.info("The Division returned by save is the same as the one passed in (using equals method)");
			}

			
			
			log.error("************ STEP 2: Find saved division *************");
			
			savedDivision = divisionRepository.findOne("100");
			
			log.info("Retrieved Division : " + savedDivision.toString());
			
			log.error("************ STEP 3: Fix division name *************");
			
			savedDivision.setDivisionName("Premier League");
			savedDivision = divisionRepository.save(savedDivision);
			
			log.info("Re-retrieved Division : " + savedDivision.toString());
			
			
			log.error("************ STEP 4: Create new season *************");
			
			SeasonImpl season = new SeasonImpl (2003);
			log.info("Created new Season : " + season.toString());
			
			SeasonImpl origSavedSeason = seasonRepository.save(season);
			log.info("Original non-persisted Season Instance : " + System.identityHashCode(season));
			log.info("Original Saved Season Instance : " + System.identityHashCode(origSavedSeason));
			
			log.error("************ STEP 5: Find saved season *************");
			
			SeasonImpl retrievedSeason = seasonRepository.findOne(2003);
			
			log.info("Retrieved Season : " + retrievedSeason.toString());
			log.info("Retrieved Season Instance : " + System.identityHashCode(retrievedSeason));

			log.info("season hashCode: " + season.hashCode() + " / retrieved Season hashCode: " + retrievedSeason.hashCode() + " / saved Season hashCode: " + origSavedSeason.hashCode());
			if (season == retrievedSeason) {
				log.info("The Season returned by save is the same as the one passed in");
			}
			if (season.equals(retrievedSeason)) {
				log.info("The Season returned by save is the same as the one passed in (using equals method)");
			}

			
			log.error("************ STEP 6: Create new season division relationship *************");
			
			SeasonDivision seasonDivision = new SeasonDivisionImpl();
			seasonDivision.setSeason(origSavedSeason);
			seasonDivision.setDivision(savedDivision);
			seasonDivision.setDivisionPosition(1);
			
			Set<SeasonDivision> newSeasonDivisions = new HashSet<SeasonDivision> ();
			newSeasonDivisions.add(seasonDivision);
			//retrievedSeason.getSeasonDivisions().add(seasonDivision);
			retrievedSeason.setSeasonDivisions(newSeasonDivisions);
			
			log.info("Season with division attached : " + retrievedSeason.toString());
			log.info("Retrieved Season Instance : " + System.identityHashCode(retrievedSeason));
			
			log.error("************ STEP 7: Save the season with this new relationship *************");
			
			//seasonRepository.flush();
			seasonRepository.save(retrievedSeason);

			DivisionImpl division2 = new DivisionImpl("101", "Championship");
			divisionRepository.save(division2);

			
			SeasonDivision seasonDivision2 = new SeasonDivisionImpl();
			seasonDivision2.setSeason(origSavedSeason);
			seasonDivision2.setDivision(division2);
			seasonDivision2.setDivisionPosition(2);
			
			retrievedSeason.getSeasonDivisions().add(seasonDivision2);
			seasonRepository.save(retrievedSeason);

			
			
			//season.getDivsionsInSeason().
			
			// fetch all customers
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (DivisionImpl division : divisionRepository.findAll()) {
//				log.info(division.toString());
//			}
//			log.info("");
//
//			// fetch an individual customer by ID
//			DivisionImpl division = divisionRepository.findOne("1");
//			log.info(division.getDivisionId());
//			log.info(division.getDivisionName());
//			log.info("");

		};
	}

	@Override
	protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
		EclipseLinkJpaVendorAdapter adapter = new EclipseLinkJpaVendorAdapter();
		return adapter;
	}

	@Override
	protected Map<String, Object> getVendorProperties() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		return map;
	}

}
