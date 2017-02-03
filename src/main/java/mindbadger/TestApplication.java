package mindbadger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import mindbadger.footballresultsanalyser.domain.Season;
import mindbadger.footballresultsanalyser.domain.SeasonDivision;

@SpringBootApplication
public class TestApplication {

	private static final Logger log = LoggerFactory.getLogger(TestApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class);
	}

	@Bean
	public CommandLineRunner demo(DivisionRepository divisionRepository, SeasonRepository seasonRepository) {
		return (args) -> {
			// save a couple of customers
			SeasonImpl season = new SeasonImpl (2003);

			DivisionImpl division1 = new DivisionImpl("100", "Premier League");
			
			SeasonDivision seasonDivision = new SeasonDivisionImpl(season, division1, 1);
			
			
			season.getSeasonDivisions().add(seasonDivision);
			
			log.info ("Season: " + season.getSeasonNumber() + " / " + season.getSeasonDivisions().size());
			
			SeasonDivision foundSeasonDivision = season.getSeasonDivisions().iterator().next();
			log.info ("SeasonDivision: " + foundSeasonDivision.getSeason().getSeasonNumber() + " / " + foundSeasonDivision.getDivision().getDivisionName() + " / " + foundSeasonDivision.getDivisionPosition());
			
			divisionRepository.save(division1);
			seasonRepository.save(season);
			
			
			//season.getDivsionsInSeason().
			
			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (DivisionImpl division : divisionRepository.findAll()) {
				log.info(division.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			DivisionImpl division = divisionRepository.findOne("1");
			log.info(division.getDivisionId());
			log.info(division.getDivisionName());
			log.info("");

		};
	}

}
