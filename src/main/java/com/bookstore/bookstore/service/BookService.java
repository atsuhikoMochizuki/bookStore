package com.bookstore.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.repository.BookRepository;

/* l'annotation @Service est une spécialisation de @Component qui apporte une
 * valeur uniquement sémantique pour le développeur.
 * Elle ne peut être appliqué qu'à classes.
 * Elle permet d'indiquer sémantiquement que la classe fournit un service,
 * une fonctionnalité métier.
 * Comme elle hérite de @Component, elle sera automatiquement détectée lors du 
 * scan du contexte de Spring.
 * 
 */
@Service
public class BookService {
    /* @Autowired permet d'activer l'injection automatique de la dépendances. 
     * Cette annotation peut-être placée sur un constructeur, une méthode
     * ou directement un attribut.
     */
   @Autowired
   private BookRepository bRepo;     
    public void save(Book b){
        bRepo.save(b);
    }

    public List<Book> getAllBook(){
        return bRepo.findAll();
    }

    public Book getBookById(int id){
        return bRepo.findById(id).get();
    }

    public void deleteById(int id){
        bRepo.deleteById(id);
    }
}
