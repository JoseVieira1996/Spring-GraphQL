package com.example.demo.mutation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

import graphql.kickstart.tools.GraphQLMutationResolver;


@Component
public class BookMutation implements GraphQLMutationResolver {

    @Autowired
    BookRepository bookRepository;

    public Book newBook(String title, String publisher){
        Book book =  new Book();
        book.setTitle(title);
        book.setPublisher(publisher);
        return bookRepository.save(book);
    }

    public Book deleteBook(Integer id){
        Book deleteBook = new Book();
        Optional<Book> findBook =  bookRepository.findById(id);
        if(findBook.isPresent()){
            bookRepository.delete(findBook.get());
            deleteBook = findBook.get();
        }
        return deleteBook;
    }
    
    public Book updateBook(Integer id, String title, String publisher) {
        Book book =  bookRepository.findById(id).get();
        book.setPublisher(publisher);
        book.setTitle(title);
        bookRepository.save(book);
		return book;
	}
    
    
}
