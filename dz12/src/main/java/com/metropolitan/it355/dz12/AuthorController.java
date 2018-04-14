/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.it355.dz12;


import com.metropolitan.it355.dz12.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Goran
 */
@Controller
@RequestMapping("VIEW")
public class AuthorController {
    
    @Autowired
    private MessageSource messageSource;
    
    @Autowired
    private AuthorDao authorDao;

    
    @RequestMapping
    public String handleRenderRequestInternal(Model model) throws Exception{    
        model.addAttribute("authors", authorDao.getAuthors());
        return "authorsList";
    }

    
}
