/**
 * 
 */
package com.fa.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.dao.UserDao;
import com.fa.dto.AppUsersDto;
import com.fa.model.AppUsers;
import com.fa.service.UserService;

/**
 * @author Administrator
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public AppUsersDto findById(int id) {
		// TODO Auto-generated method stub
		AppUsers appUser=userDao.findById(id);
		return convertToDto(appUser);
}

	@Override
	public AppUsersDto findBySSO(String sso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUser(AppUsersDto user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(AppUsersDto user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserBySSO(String sso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AppUsersDto> findAllUsers() {
		List<AppUsers> appUsersList=userDao.findAllUsers();
		List<AppUsersDto> appUsersDtoList=appUsersList.stream().map(x->convertToDto(x)).collect(Collectors.toList());
		return appUsersDtoList;
	}

	@Override
	public boolean isUserSSOUnique(Integer id, String sso) {
		// TODO Auto-generated method stub
		return false;
	}

	private AppUsersDto convertToDto(AppUsers appUsers) {
		AppUsersDto appUsersDto= modelMapper.map(appUsers, AppUsersDto.class);;
		return appUsersDto;
	}
}
