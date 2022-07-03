package com.example.demo.query;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Service
public class AuthorQueyResolver implements GraphQLQueryResolver{
	@Autowired
	private AuthorRepository authorRepository;
	
	
	

	 
	 
	 public Iterable<Author> allAuthor(){
	        return authorRepository.findAll();
	    }
	 
	 Optional <Author> authorById(Integer id) {
	        return authorRepository.findById(id);
	   }
}
