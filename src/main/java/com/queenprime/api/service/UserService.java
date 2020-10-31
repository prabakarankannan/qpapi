package com.queenprime.api.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.queenprime.api.domain.User;
import com.queenprime.api.repository.UserRepository;


@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> listAll() {
        return userRepository.findAll();
    }
     
    public void save(User user) {
    	userRepository.save(user);
    }
     
    public User get(Integer id) {
        return userRepository.findById(id).get();
    }
     
    public void delete(Integer id) {
    	userRepository.deleteById(id);
    }

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
}
