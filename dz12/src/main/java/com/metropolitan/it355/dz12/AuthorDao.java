/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.it355.dz12;

import com.metropolitan.it355.dz12.model.Author;
import java.util.List;

/**
 *
 * @author Goran
 */
public interface AuthorDao {
    
    List<Author> getAuthors();
    
    Author createAuthor();
    
    Author getAuthor(String id);
    
    Author getAuthor(String name, String lastName);
    
    void addAuthor(Author a);
    
    void deleteAuthor(String id);
    
    void editAuthor(Author author);
    
}
