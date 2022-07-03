package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
//@AllArgsConstructor
@Entity
public class Author {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy ="author", cascade = CascadeType.ALL)
	private List<Book> books = new ArrayList<>();
	
    public Author(Integer id) {
        this.id = id;
    }
    
    public Author() {
    	
    }

	public Author(Integer id, String name) {
		this.id = id;
		this.name = name;
	}


}
