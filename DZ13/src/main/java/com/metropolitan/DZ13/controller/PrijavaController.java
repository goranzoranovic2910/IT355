/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.DZ13.controller;

import com.metropolitan.DZ13.model.Ispit;
import com.metropolitan.DZ13.model.Prijava;
import com.metropolitan.DZ13.model.User;
import com.metropolitan.DZ13.service.IspitService;
import com.metropolitan.DZ13.service.UserService;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.cglib.core.Predicate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Goran
 */
@Controller
public class PrijavaController {
    
    @Autowired
    IspitService ispitService;
    
    @Autowired
    private UserService userService;

    @RequestMapping(value="/prijava", method = RequestMethod.GET)
    public ModelAndView prijava(){
        ModelAndView modelAndView = new ModelAndView();
        Prijava p = new Prijava();
        
        List<Ispit> ispiti = ispitService.getAll();
        p.setIspit(ispiti.get(0));
        p.setIdIspita(p.getIspit().getIspitId());
        
        modelAndView.addObject("prijava", p);   
        modelAndView.addObject("ispiti", ispitService.getAll());
        
        modelAndView.setViewName("prijava");
        return modelAndView;
    }   
    
    @RequestMapping(value = "/prijava", method = RequestMethod.POST)
    public ModelAndView apply(Prijava prijava, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        List<Ispit> ispiti = ispitService.getAll();
        
        Collection<Ispit> result = CollectionUtils.filter(ispiti, new Predicate (){

            public boolean evaluate(Object o){
                return prijava.getIdIspita() == ((Ispit)o).getIspitId();
            }
        });
        
        prijava.setIspit(result.iterator().next());
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User student = userService.findUserByEmail(auth.getName());
        prijava.setStudent(student);
        
        prijava.setVremePrijave(Calendar.getInstance().getTime());
        
        ispitService.apply(prijava);       
        
        modelAndView.setViewName("prijavaSuccess");
        return modelAndView;
    }
    
    @RequestMapping(value="/odjava", method = RequestMethod.GET)
    public ModelAndView odjava(){
        ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.addObject("prijave", ispitService.getAllPrijave());   

        return modelAndView;
    }
    
    @RequestMapping(value="/odjavi", params = {"pid"})
    public ModelAndView odjavi(@RequestParam(value = "pid") int pid){
        ispitService.cancel(pid);
        
         ModelAndView modelAndView = new ModelAndView("odjava");
        
        modelAndView.addObject("prijave", ispitService.getAllPrijave());   
        
        return modelAndView;
    }
}
