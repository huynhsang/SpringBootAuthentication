package com.se52.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.se52.entity.User;
import com.se52.model.UserContext;
import com.se52.repository.UserDAO;


@Service
public class UserServiceImpl implements UserDetailsService{

	private final UserDAO userDAO;
    
    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
	
    public UserDAO getUserDAO(){
    	return userDAO;
    }
    
	@Override
	public UserContext loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDAO.findByUsername(username);
		if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
        	return UserContext.create(user.getUsername(), user.getPassword(),
        			mapAuthorities(user), user.getEnabled(), user.getLastPasswordResetDate());
        }
	}
	
	private List<GrantedAuthority> mapAuthorities(User user){
		return user.getAuthorities().stream()
				.map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
				.collect(Collectors.toList());
	}

}
