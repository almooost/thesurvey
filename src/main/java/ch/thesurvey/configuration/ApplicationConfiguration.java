package ch.thesurvey.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by sam on 23.10.16.
 */
@Configuration
public class ApplicationConfiguration {

/*
    @Bean
    @Primary
    /*@ConfigurationProperties(prefix = "datasource.primary")
    public DataSource numberMasterDataSource() {
        return DataSourceBuilder.create().build();
    }
*/
}
