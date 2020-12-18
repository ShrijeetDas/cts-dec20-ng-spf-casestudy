package com.casestudy.contactapplogin.repository;

import org.springframework.data.repository.CrudRepository;

import com.casestudy.contactapplogin.model.Contacts;

public interface contactRepository extends CrudRepository<Contacts, Integer> {

}
