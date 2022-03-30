package com.leablogs.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

public class DataSourceConfig {
	public void DataSourceConfigs() throws IOException, SQLException {
		DataSourceFactory dFactory = new UnpooledDataSourceFactory();
//		new  PooledDataSourceFactory();
		Properties properties = new Properties();
		InputStream configStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("database.properties");
		properties.load(configStream);
		System.out.println(properties);
		dFactory.setProperties(properties);
		DataSource dataSource = dFactory.getDataSource();
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
//		System.out.println(connection);
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet resultSet = statement.executeQuery("select * from student");
		while(resultSet.next()) {
			System.out.println(resultSet.getInt("id"));
			System.out.println(resultSet.getString("name"));
			System.out.println(resultSet.getString("sex"));
			System.out.println("==========================");
		}
	}
	public static void main(String[] args) throws IOException, SQLException {
		DataSourceConfig dataSourceConfig = new DataSourceConfig();
		dataSourceConfig.DataSourceConfigs();
	}
}
