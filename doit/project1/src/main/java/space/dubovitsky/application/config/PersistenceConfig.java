package space.dubovitsky.application.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement //! <tx:annotation-driven/>
@PropertySource("classpath:persistence.properties")
@EnableJpaRepositories("space.dubovitsky.application.repository") //! <jpa:repositories base-package="space.dubovitsky.application.repository"/>
public class PersistenceConfig {

    @Bean
    public DataSource dataSource(
            @Value("${DriverClassName}") String driver,
            @Value("${url}") String url,
            @Value("${password}") String password,
            @Value("${username}") String username
            ) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5433/project1");
        dataSource.setPassword("root");
        dataSource.setUsername("postgres");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean(DataSource dataSource) {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("space.dubovitsky.application.entity");
        factoryBean.setHibernateProperties(new Properties(){{
            put("hibernate.show_sql", true);
        }});
        return factoryBean;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSource);
        bean.setPackagesToScan("space.dubovitsky.application.entity");
        bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        bean.afterPropertiesSet();
        return bean.getObject();
    }

    @Bean(name="transactionManager")
    public JpaTransactionManager jpaTransactionManager(
            EntityManagerFactory entityManagerFactory
    ) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        return jpaTransactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        PersistenceExceptionTranslationPostProcessor translationPostProcessor = new PersistenceExceptionTranslationPostProcessor();
        return translationPostProcessor;
    }

}
