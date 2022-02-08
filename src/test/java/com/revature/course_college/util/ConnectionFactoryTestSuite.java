package com.revature.course_college.util;

import java.sql.Connection;
import org.junit.*;
public class ConnectionFactoryTestSuite {

	@Test
	public void test_getConnection_returnValidConnection_givenProvidenCredentials() {
		try (Connection connection = ConnectionFactory.getInstance().getConnection()){
			System.out.println(connection);
			Assert.assertNotNull(connection);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
}
