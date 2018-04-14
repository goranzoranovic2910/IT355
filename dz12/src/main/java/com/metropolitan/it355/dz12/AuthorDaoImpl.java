/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.it355.dz12;


import com.metropolitan.it355.dz12.model.Author;
import java.util.List;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Goran
 */

@Repository("authorDAO")
@Service
public class AuthorDaoImpl implements AuthorDao {


    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public AuthorDaoImpl() {    
    }

    @Override
    @Transactional
    public List<Author> getAuthors() {
        
        List<Author> results = (List<Author>)
        getSession().createCriteria(Author.class).list();
        return results;
    }

    @Override
    public Author createAuthor() {
        return new Author(0, "", "");
    }

    @Override
    @Transactional
    public Author getAuthor(String id) {
        Author author = (Author)getSession().createCriteria(Author.class).add(Restrictions.eq("id",Integer.parseInt(id))).uniqueResult();
        return author;
    }
    @Override
    @Transactional    
    public Author getAuthor(String name, String lastName){
         return (Author)sessionFactory
               .getCurrentSession()
               .createCriteria(Author.class)
               .add(Restrictions.eq("name",name))
               .add(Restrictions.eq("lastName",lastName)).uniqueResult();
    }
    
    @Override
    @Transactional
    public void addAuthor(Author a){
        getSession().saveOrUpdate(a);
    }

    @Override
    @Transactional
    public void deleteAuthor(String id) {
        getSession().delete(this.getAuthor(id));
    }

    @Override
    @Transactional
    public void editAuthor(Author author) {
        getSession().saveOrUpdate(author);
     }
}
