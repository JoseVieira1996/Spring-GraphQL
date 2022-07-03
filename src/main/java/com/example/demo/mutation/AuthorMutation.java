package com.example.demo.mutation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;

import graphql.kickstart.tools.GraphQLMutationResolver;


@Component
public class AuthorMutation implements GraphQLMutationResolver {

    @Autowired
    AuthorRepository authorRepository;

    public Author newAuthor(String name){
        Author author =  new Author();
        author.setName(name);
        return authorRepository.save(author);
    }

    public Author deleteAuthor(Integer id){
        Author deleteAuthor = new Author();
        Optional<Author> findAuthor =  authorRepository.findById(id);
        if(findAuthor.isPresent()){
            authorRepository.delete(findAuthor.get());
            deleteAuthor = findAuthor.get();
        }
        return deleteAuthor;
    }
    
    public Author updateAuthor(Integer id, String name) {
        Author author =  authorRepository.findById(id).get();
        author.setName(name);
        authorRepository.save(author);
		return author;
	}
    
    
}
