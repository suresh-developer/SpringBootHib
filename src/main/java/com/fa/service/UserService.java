/**
 * 
 */
package com.fa.service;

import java.util.List;

import com.fa.dto.AppUsersDto;
import com.fa.model.AppUsers;

/**
 * @author Administrator
 *
 */
public interface UserService {
	
	AppUsersDto findById(int id);
    
	AppUsersDto findBySSO(String sso);
     
    void saveUser(AppUsersDto user);
     
    void updateUser(AppUsersDto user);
     
    void deleteUserBySSO(String sso);
 
    List<AppUsersDto> findAllUsers(); 
     
    boolean isUserSSOUnique(Integer id, String sso);
}
