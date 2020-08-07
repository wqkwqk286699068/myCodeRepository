package com.springbootDemo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

//@Configuration
public class SqlSessionConfig {

	@Value("${mybatis.mapper-locations}")
	public String mapperLocations;

	// 将这个对象放入Spring容器中
	@Bean(name = "test1DataSource")
	// 表示这个数据源是默认数据源
	@Primary
	// 读取application.properties中的配置参数映射成为一个对象
	// prefix表示参数的前缀
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource getDateSource1() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "test1SqlSessionFactory")
	// 表示这个数据源是默认数据源
	@Primary
	// @Qualifier表示查找Spring容器中名字为test1DataSource的对象
	public SqlSessionFactory test1SqlSessionFactory(
			@Qualifier("test1DataSource") DataSource datasource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(datasource);
		bean.setMapperLocations(
		// 设置mybatis的xml所在位置
		new PathMatchingResourcePatternResolver().getResources(mapperLocations));
		return bean.getObject();
	}

	@Bean("test1SqlSessionTemplate")
	// 表示这个数据源是默认数据源
	@Primary
	public SqlSessionTemplate test1SqlSessionTemplate(
			@Qualifier("test1SqlSessionFactory") SqlSessionFactory sessionFactory) {
		return new SqlSessionTemplate(sessionFactory);
	}

}
