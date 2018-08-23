/**
 * 
 */
package com.fa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fa.dto.AppUsersDto;
import com.fa.service.UserService;

/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/users") 
public class UsersController {
	
	@Autowired
	UserService userService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/getallusers",method=RequestMethod.POST,produces = { "application/json", "application/xml" })
	public ResponseEntity<List<AppUsersDto>> getAllUsersList(){
		
		List<AppUsersDto> appUsersDtoList=userService.findAllUsers();
		if(appUsersDtoList.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<AppUsersDto>>(appUsersDtoList,HttpStatus.OK);
	}

}
