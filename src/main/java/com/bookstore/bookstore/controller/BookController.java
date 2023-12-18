package com.bookstore.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
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
    public String getAllBook(){
        return "bookList";
    }

}
