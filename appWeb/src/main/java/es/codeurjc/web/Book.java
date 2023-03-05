package es.codeurjc.web;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

	
    private String name;
    private String description;
    private String genre;


    protected Book(){}

    public Book(String name, String description, String genre) {
        this.name = name;
        this.description = description;
        this.genre = genre;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

    

    
}
