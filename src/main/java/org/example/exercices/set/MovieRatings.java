package org.example.exercices.set;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/*
    Movie Ratings:
    Implement a movie rating system using both a HashSet and a TreeSet where movies are stored and sorted based on
     their ratings.
 */

class Movie {
    private String title;
    private Double rating;
    private LocalDate relaseDate;

    public Movie(String title, Double rating, LocalDate relaseDate) {
        this.title = title;
        this.rating = rating;
        this.relaseDate = relaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public LocalDate getRelaseDate() {
        return relaseDate;
    }

    public void setRelaseDate(LocalDate relaseDate) {
        this.relaseDate = relaseDate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                ", relaseDate=" + relaseDate +
                '}';
    }
}
public class MovieRatings {
    public static void main(String[] args) {




        Set<Movie> movieUnorderedSet = new HashSet<>();

        movieUnorderedSet.add(new Movie("Inception",8.8,LocalDate.of(2004,12,4)));
        movieUnorderedSet.add(new Movie("The Dark Knight",5.2,LocalDate.of(2006,12,5)));
        movieUnorderedSet.add(new Movie("Pulp Fiction",9.1,LocalDate.of(2004,6,4)));
        movieUnorderedSet.add(new Movie("Interstellar",8.8,LocalDate.of(2004,6,2)));


        System.out.println(movieUnorderedSet);
        System.out.println();

        //ArrayList si sort
        List<Movie> movieSortedList = new ArrayList<>(movieUnorderedSet);
        System.out.println("Lista neordonata contine:");
        displayList(movieSortedList);

        /* Comparator are structura de Builder class

        Ce este un Builder?
        Este o clasa de obiect unde semnatura metodelor cu tip de returnare contine clasa curenta, astfel incat sa
        putem avea chained invocations(apelari inlantuite)

        Comparator
           .comparing(...)
           .thenCompare(...)
           .etc;
        */
        movieSortedList.sort(Comparator
                .comparing(Movie::getRating)
                .thenComparing(Movie::getRelaseDate)
                .reversed()
        );
        System.out.println("Lista sortata contine:");
        displayList(movieSortedList);
        /*
        Comparator.comparing(Movie::getRating)
        -se uita intern in clasa Movie
        -compara 2 elemente random din lista noastra pe baza metodei de referinta
        -metoda de referinta este de regula un getter(fiind datele noastre sunt private)
        -referentierea directa prin numele clasei::metoda (Movie::getRatting) functioneaza doar pentru metodele
        neparametrizate
         */
        //Collections si sort
    }
    public static void displayList(List<Movie>list){
        for (Movie it: list){
            System.out.println(it.getTitle() + " " + it.getRating() + " " + it.getRelaseDate() );
        }
        System.out.println();
    }
}
