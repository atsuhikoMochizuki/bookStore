package com.bookstore.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.service.BookService;

@Controller
public class BookController {

    /*Injection automatique du service  */
    @Autowired
    private BookService service;

    /* GetMapping est une version composée de @RequestMapping
     * et agit comme un raccourci pour @RequestMapping(method = RequestMethod.GET)
     * Une méthode annotée @GetMapping gère la requete HTTP GET pour l'uri fournie en paramètres
     */
    @GetMapping("/") // retourne la racine de l'application
    public String home(){
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBook(){
       List<Book> list= service.getAllBook();
    //    ModelAndView m = new ModelAndView();
    //    m.setViewName("bookList");
    //    m.addObject("book",list);
       return new ModelAndView("bookList","book",list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b){
        service.save(b);
        return "redirect:/available_books";
    }

    @GetMapping("/my_books")
    public String getMyBooks(){
        return "myBooks";
    }

}
