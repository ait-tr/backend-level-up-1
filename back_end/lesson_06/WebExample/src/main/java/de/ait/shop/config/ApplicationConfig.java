package de.ait.shop.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import freemarker.cache.ClassTemplateLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import freemarker.template.Configuration;
import javax.sql.DataSource;

/**
 * 9/25/2023
 * Spring - Java Config
 *
 * @author Marsel Sidikov (AIT TR)
 */
@org.springframework.context.annotation.Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "de.ait.shop")
public class ApplicationConfig {

    @Autowired
    private Environment environment;

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DataSource dataSource(HikariConfig config) {
        return new HikariDataSource(config);
    }

    @Bean
    public Configuration freemarkerConfig() {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
        configuration.setDefaultEncoding("UTF-8");

        configuration.setTemplateLoader(new ClassTemplateLoader(this.getClass().getClassLoader(), "\\templates"));

        return configuration;
    }

    @Bean
    public HikariConfig hikariConfig() {
        try {
            Class.forName("org.postgresql.Driver"); // принудительная загрузка драйвера
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }

        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(environment.getProperty("hikari.jdbc.url"));
        config.setUsername(environment.getProperty("hikari.jdbc.username"));
        config.setPassword(environment.getProperty("hikari.jdbc.password"));
        config.setMaximumPoolSize(environment.getProperty("hikari.jdbc.maxPoolSize", Integer.class));

        return config;
    }
}
