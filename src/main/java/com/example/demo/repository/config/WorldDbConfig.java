package com.example.demo.repository.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties(
	prefix = "spring.datasource." + WorldDbConfig.DB_NAME
)
@MapperScan(
	basePackages = WorldDbConfig.PACKAGE_BASE + WorldDbConfig.DB_NAME,
	sqlSessionTemplateRef = WorldDbConfig.DB_NAME + "SqlSessionTemplate"
)
public class WorldDbConfig {
	static final String DB_NAME = "world";
	static final String PACKAGE_BASE = "com.example.demo.repository.mapper.";

	private String driverClassName;
	private String url;
	private String username;
	private String password;

	@Bean(name = DB_NAME + "DataSource")
	public DataSource createDataSource() {
		return DataSourceBuilder
				.create()
				.driverClassName(driverClassName)
				.url(url)
				.username(username)
				.password(password)
				.build();
	}

	@Bean(name = DB_NAME + "SqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(
		@Qualifier(DB_NAME + "DataSource") DataSource primaryDataSource
	) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(primaryDataSource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:" + PACKAGE_BASE + DB_NAME + ".*xml"));
		return bean.getObject();
	}

	@Bean(name = DB_NAME + "SqlSessionTemplate")
	public SqlSessionTemplate sqlSessionTemplate(
		@Qualifier(DB_NAME + "SqlSessionFactory") SqlSessionFactory sqlSessionFactory
	) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
