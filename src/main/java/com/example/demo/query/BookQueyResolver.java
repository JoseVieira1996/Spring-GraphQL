package com.example.demo.query;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Service
public class BookQueyResolver implements GraphQLQueryResolver{
	
	@Autowired
	private BookRepository bookRepository;
	
	

	 public Iterable<Book> allBook(){
	        return bookRepository.findAll();
	    }
	 
	 

	 Optional <Book> bookById(Integer id) {
	        return bookRepository.findById(id);
	   }
	
}
