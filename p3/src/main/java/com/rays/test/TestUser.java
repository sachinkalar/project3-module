package com.rays.test;

import com.rays.dto.UserDTO;
import com.rays.model.UserModelHibImp;

public class TestUser {
	
	public static void main(String[] args) throws Exception {
		TestAdd();
	}

	private static void TestAdd() throws Exception {
		
		UserModelHibImp UserModel = new UserModelHibImp();
		
		UserDTO dto = new UserDTO();
		
		dto.setId(1);
		dto.setFirstName("jatin");
		dto.setLastName("raghu");
		dto.setLoginId("j@gmail.com");
		dto.setPassword("pre");
		dto.setAddress("sehore");
		
		UserModel.add(dto);
		
	}

}
