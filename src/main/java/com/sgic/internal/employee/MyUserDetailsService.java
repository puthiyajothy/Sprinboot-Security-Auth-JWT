package com.sgic.internal.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sgic.internal.employee.entities.User;
import com.sgic.internal.employee.repositories.UserRepository;


@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired 
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepo.findByusername(username);	
		if(user == null)
			throw new UsernameNotFoundException("User 404");
		
		return new UserPrincipal(user);
	}

}
