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
			
			DivisionImpl division1 = new DivisionImpl("100", "Premier Fish");
			log.info("Created new Division : " + division1.toString());
			
			DivisionImpl savedDivision = divisionRepository.save(division1);

			savedDivision = divisionRepository.findOne("100");
			
			log.info("Retrieved Division : " + savedDivision.toString());
			
			savedDivision.setDivisionName("Premier League");
			savedDivision = divisionRepository.save(savedDivision);
			
			log.info("Re-retrieved Division : " + savedDivision.toString());
			
			
			
			
			SeasonImpl season = new SeasonImpl (2003);
			log.info("Created new Season : " + season.toString());
			
			SeasonImpl savedSeason = seasonRepository.save(season);
			savedSeason = seasonRepository.findOne(2003);
			
			log.info("Retrieved Season : " + savedSeason.toString());

			
			
			
			SeasonDivision seasonDivision = new SeasonDivisionImpl();
			seasonDivision.setSeason(savedSeason);
			seasonDivision.setDivision(savedDivision);
			seasonDivision.setDivisionPosition(1);
			
			savedSeason.getSeasonDivisions().add(seasonDivision);

			log.info("Season with division attached : " + savedSeason.toString());
			
			seasonRepository.save(savedSeason);

			
			
			
//			log.info ("Season: " + season.getSeasonNumber() + " / " + season.getSeasonDivisions().size());
//			
//			SeasonDivision foundSeasonDivision = season.getSeasonDivisions().iterator().next();
//			log.info ("SeasonDivision: " + foundSeasonDivision.getSeason().getSeasonNumber() + " / " + foundSeasonDivision.getDivision().getDivisionName() + " / " + foundSeasonDivision.getDivisionPosition());
			

			
			
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

}
