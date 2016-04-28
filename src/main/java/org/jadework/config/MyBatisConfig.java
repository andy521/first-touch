package org.jadework.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import javax.sql.DataSource;

/**
 * aliyun mysql datasource config
 *
 * @author Jade ZHANG E-mail:pioneer_zcy@163.com
 * @copyright 2015-2016 sh.lianjia.com.
 * @date 16/4/19
 */
@Configuration
public class MyBatisConfig {

    /**
     * 普通sqlSession
     */
    @Bean(name = BeanNames.SQL_SESSION)
    public SqlSessionTemplate SqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryBean());
    }

    /**
     * 通用sqlSessionFactory
     */
    @Bean(name = "sqlSessionFactory")
    protected SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(dataSource());

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mybatis/mapper/*.xml"));
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:mybatis/mybatis-config.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    /**
     * springbootjdbc datasource
     */
    @Primary
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.server.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * inner interface
     */
    public interface BeanNames {
        String SQL_SESSION = "sqlSession";
    }
}



