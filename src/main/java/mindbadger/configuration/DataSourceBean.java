package mindbadger.configuration;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Component;

/* 
 * Not used, but left in the codebase as an illustration of how we can do this without propreties files in the future if necessary
 */
//@Configuration
//@Component
public class DataSourceBean {

	@ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    @Primary
	public DataSource getDataSource() {
		return DataSourceBuilder.create()
			.url("jdbc:mysql://localhost/football_test")
			.username("root")
			.password("password")
			.driverClassName("com.mysql.jdbc.Driver")
			.build();
	}
}
