package com.mvit.userservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository repo;
	//Inserting the records to the table in database
	public void insertRecord(User cust)
	{
		repo.save(cust);
	}
	
	//Show all the records from the table in database
	public List<User> getAllRecords()
	{
		return repo.findAll();
	}
	
	//Show specific record from the table in database
	public User getUserById(Integer id)
	{
		return repo.findById(id).orElse(null);
	}
	
	//Deleting the specific record from the table in database
	public void deleteUser(Integer id)
	{
		repo.deleteById(id);
	}
	
	//updating the existing record
	public void updateUser(Integer id,User updateUser)
	{
		User existingUser=repo.findById(id).orElse(null);
		if(existingUser!=null)
		{
			existingUser.setCid(updateUser.getCid());
			existingUser.setCname(updateUser.getCname());
			existingUser.setAddress(updateUser.getAddress());
			repo.save(existingUser);
		}

}
}