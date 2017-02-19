package mindbadger.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.eclipse.persistence.config.BatchWriting;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.logging.SessionLog;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.jta.JtaTransactionManager;

@Configuration
@ComponentScan 
@EnableAutoConfiguration 
public class RepositoryConfiguration extends JpaBaseConfiguration {

	protected RepositoryConfiguration(DataSource dataSource, JpaProperties properties,
			ObjectProvider<JtaTransactionManager> jtaTransactionManagerProvider) {
		super(dataSource, properties, jtaTransactionManagerProvider);
	}

	@Override
	protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
		EclipseLinkJpaVendorAdapter adapter = new EclipseLinkJpaVendorAdapter();
		return adapter;
	}

	@Override
	protected Map<String, Object> getVendorProperties() {
		HashMap<String, Object> map = new HashMap<String, Object>();
        map.put(PersistenceUnitProperties.BATCH_WRITING, BatchWriting.JDBC);
        map.put(PersistenceUnitProperties.LOGGING_LEVEL, SessionLog.FINE_LABEL);
		return map;
	}

}
