package com.casestudy.contactapplogin.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.contactapplogin.exception.UserNotFound;
import com.casestudy.contactapplogin.model.Contacts;
import com.casestudy.contactapplogin.service.contactDao;

@RestController
public class contactController {
	
	@Autowired
	private contactDao contactDao;
	
	@PostMapping(value="/contacts", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	private Contacts create(@RequestBody Contacts contact) {
		return contactDao.save(contact);
	}
	
	@GetMapping("/contacts")
	private Iterable<Contacts> view(){
		return contactDao.findAll();
	}
	
	@DeleteMapping("/contacts/{id}")
	private String deleteContact(@PathVariable("id") int id) throws UserNotFound {
		String result = contactDao.deleteContact(id);
		return result;
		
	}
	
	@GetMapping("/contacts/{uid}")
	private ResponseEntity<Object> findById(@PathVariable("uid") int uid) throws UserNotFound {
		ResponseEntity<Object> response = null;
		ArrayList<Contacts> con = contactDao.findByUserId(uid);
		response = ResponseEntity.status(200).body(con);
		return response;
	}

}
