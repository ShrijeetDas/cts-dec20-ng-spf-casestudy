package com.casestudy.contactapplogin.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.contactapplogin.exception.UserNotFound;
import com.casestudy.contactapplogin.model.Contacts;
import com.casestudy.contactapplogin.model.User;
import com.casestudy.contactapplogin.repository.contactRepository;

import antlr.collections.List;

@Service
public class contactDao {
	
	@Autowired
	private contactRepository dao;
	
	public Contacts save(Contacts contacts) {
		Contacts createdContacts = dao.save(contacts);
		return createdContacts;
	}
	
	public String deleteContact(int id) throws UserNotFound  {
		Optional<Contacts> option = dao.findById(id);
		if(option.isPresent()) {
			Contacts con = option.get();
			dao.deleteById(con.getId());
			return "Success";
		}
		else
			throw new UserNotFound("User not found");
	}
	
	public Iterable<Contacts> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public ArrayList<Contacts> findByUserId(int uid) {
		ArrayList<Contacts> con = new ArrayList<Contacts>();
		Iterable<Contacts> Allcon = dao.findAll();
		for(Contacts i :Allcon) {
			if(i.getUid()==uid) {
				con.add(i);
			}
		}
		return con;
	}

}
