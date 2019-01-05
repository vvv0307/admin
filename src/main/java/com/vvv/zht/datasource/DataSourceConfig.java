package com.vvv.zht.datasource;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.vvv.zht.dao",sqlSessionFactoryRef = "adminSqlSessionFactory")
public class DataSourceConfig {

    @Value("${spring.datasource.min-poolsize}")
    private int minimumPoolSize;
    @Value("${spring.datasource.max-poolsize}")
    private int maximumPoolSize;
    @Value("${spring.datasource.connect-timeout-ms}")
    private long connectTimeout;
    @Value("${spring.datasource.validate-timeout-ms}")
    private long validateTimeout;
    @Value("${spring.datasource.url}")
    private String Url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Bean(name = "adminHikariConfig")
    public HikariConfig adminHikariConfig() {
        HikariConfig conf = new HikariConfig();
        conf.setJdbcUrl(Url);
        conf.setUsername(username);
        conf.setPassword(password);
        conf.setConnectionTestQuery("SELECT 1");
        conf.setPoolName("admin-datasource");
        conf.setConnectionTimeout(connectTimeout);
        conf.setValidationTimeout(validateTimeout);
        conf.setMaximumPoolSize(maximumPoolSize);
        return conf;
    }

    @Bean(name = "adminDataSource")
    public DataSource adminDataSource() {
        return new HikariDataSource(adminHikariConfig());
    }

    @Bean(name = "adminSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(adminDataSource());
        sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactoryBean.getObject();
    }
}
