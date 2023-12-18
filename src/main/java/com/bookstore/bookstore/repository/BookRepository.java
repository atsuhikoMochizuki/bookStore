package com.bookstore.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.bookstore.entity.Book;

/* L'annotaion @Repository est utilisée pour indiquer que la classe fournit
 * le méchanisme de stockage, récupération, recherche, mise à jour et suppression des objets.
 * C'est une spécialisation de @Component ( qui sera donc automatiquement
 * détectée en tant que composant) qui apporte une valeur
 * sémantique supplémentaire.
 * Tout comme @Component, elle permet de déclarer auprès de Spring que cette classe
 * est un bean à exploiter.
 * Son nomn @Repository, permet simplement par rapport à @Component, de fournir
 * au développeur une indication sémantique. 
 * Un composant @repository est très proche du pattern DAO.
 * Lorsque l'on utilise Spring-data pour gérer les opérations en base de données,
 * il faut utiliser l'interface Spring data @Repository
 * Le framework ORM Spring data jpa met en pratique le design pattern DAO,
 * Le concept est le suivant:
 * Une données est modélisée via une classe.
 * Les opérations sur la base de données concernant cette donnée sont spécifiées
 * via cette interface BookRepository.
 * Ces opérations sont implémentées.
 * Spring data demande de respecter les principes suivants:
 * implémenter des classes qui représentent les données (les entités)
 * créer des interfaces  pour manipuler ces entités : les repositories.
 * 
 * MAIS OÙ EST DONC CETTE IMPLÉMENTATION?
 * Où allons nous implémenter le code qui exécute les actions
 * pour communiquer avec la base de données?
 * Un code qui soit capable d'éxécuter des requêtes SQL
 * 
 * => C'est Spring Data qui s'en charge de façon transparente !
 * ce qui est très très bien, car cette classe est en réalité la plus
 * longue et la plus complexe à implémenter!
 * Le gain de temps est très considérable!
 * De plus c'est également le framework ORM, Spring Data JPA, qui va se charger
 * se générer la structure de la base de données!
 * 
 * Spring Data Jpa se base sur le design pattern DAO pour la structure des classes
 * et des interfaces.
 * Les données sont représentées en entités au sein du code. 
 * Une entité est une classe Java avec des attributs et des getters/setters.
 * Nul besoin d'implémenter les requêtes SQL pour interagir avec la base de données, 
 * Spring Data Jpa permet d'écrire des interfaces qui étendent l'interface CrudRepository
 * qui respecte le design pattern Repository.
 * 
 * Utiliser JpaRepository ou CrudRepository?
 * CrudRepository
 *      -> CrudRepository is a base interface and extends the Repository interface.
 *         CrudRepository mainly provides CRUD (Create, Read, Update, Delete) operations.
 *         Return type of saveAll() method is Iterable.
 *         => Use Case : To perform CRUD operations, define repository extending CrudRepository.
 * 
 * JpaRepository
 *      -> JpaRepository extends PagingAndSortingRepository that extends CrudRepository.
 *         JpaRepository provides CRUD and pagination operations, along with additional 
 *         methods like flush(), saveAndFlush(), and deleteInBatch(), etc.
 *         Return type of saveAll() method is a List.
 *         => Use Case - To perform CRUD as well as batch operations, define repository extends JpaRepository.
 *
 * NOTA : En gros JpaRepository semble un peu plus spécialisé que CrudRepository.
 * En général, la meilleure idée est d'utiliser CrudRepository ou PagingAndSortingRepository selon que vous avez besoin de tri et de pagination ou non.
 * JpaRepository doit être évité si possible, car il lie vos référentiels à la technologie de persistance JPA, et dans la plupart des cas, vous n'utiliserez 
 * probablement même pas les méthodes supplémentaires qu'il fournit.
 */
@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{

}
