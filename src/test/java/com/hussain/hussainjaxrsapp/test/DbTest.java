package com.hussain.hussainjaxrsapp.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import com.hussain.hussainjaxrsapp.config.DbConnection;

public class DbTest {
	
	@Test
	public void testConnection() {
		DbConnection dbConnection = DbConnection.getInstance();
		Connection actual = dbConnection.getConnection();
	
	    assertNotNull(actual);
	}
}
	
