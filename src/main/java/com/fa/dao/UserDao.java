/**
 * 
 */
package com.fa.dao;

import java.util.List;

import com.fa.model.AppUsers;

/**
 * @author Administrator
 *
 */
public interface UserDao {
	
	AppUsers findById(int id);
    
    AppUsers findBySSO(String sso);
     
    void save(AppUsers user);
     
    void deleteBySSO(String sso);
     
    List<AppUsers> findAllUsers();

}
