package org.example.streams;

/*
   Exercise 8: Mapping, Grouping, and Collecting to Map
    Given a list of people with their ages, map each person to their age group (e.g., child, adult, senior),
    and collect them into a map where the key is the age group and the value is the list of people belonging
    to that age group.
    Person(name,age) - clasa de obiect

    Input -> List<Person>:

    Alice: 26 ani
    Bob: 40 ani
    Charlie: 18 ani
    David: 55 ani
    Eve: 70 ani

    AgeCategory - o enumeratie
    Child: age <=18
    Adult: age <= 65
    Senior: age > 66

    Output -> Map<AgeCategory, List<Person>>:
    K1(child) -> V1:Charlie
    K2(adult) -> V2: Alice, Bob, David
    K3(senior) -> V3: Eve
 */

import lombok.*;

import java.util.*;
import java.util.stream.Collectors;

@ToString
@Setter
@Getter
@AllArgsConstructor
// va adauga clasei de obiect construcotrul parametrizat pt toate atributele -> public Person (String name, int age) { this = value}
@NoArgsConstructor // va adauga clase de obiect constructorul neparametrizat -> public Person(){}

class Person {
    private String name;
    private int age;

}

/*
 O enumeratie este o clasa Java cu proprietatea speciala ca poate stoca obiecte ( variabile/obiecte de diverse tipuri
 de date care sunt constante.
 Ca si caz de utilizare generic, enumeratia se utilizeaza cand dorim sa generalizam constantele dintr-un proiect
 astfel incat sa nu repetam o informatie, ci doar sa o apelam.

 O enumeratie poate sa aiba atat atribute, cat si constructori sau getters/setters.

 Intotdeauna constantele se scriu cu majuscula si se despart intre ele cu "_".

 -MAX_LIMIT, MINIMUM_AGE, etc.

 De ce am folosi o enumeratie si pur si simplu nu am utiliza constanta direct in clasele dorite?

    Pentru ca in situatia in care acea constanta ar fi actualizata cu o noua valoare, modificarea ar trebui propagata
    in toate locatiile de identificare.

    Daca constanta ar fi trecuta manual peste tot, ar trebui o actualizare manuala in toate locatiile.

Intr-o enumeratie, dpdv default , toate etichetele sunt valori String
Daca nu se specifica un constructor de definitie al etichetelor, acestea sunt construite
folosind constructorul neparametrizat subinteles al clasei de enumeratie su toate etichetele
se definesc ca stringuri.
 */
enum AgeCategory {
    CHILD,
    ADULT,
    SENIOR
}

public class PersonGrouping {
    public static void main(String[] args) {

        //Input
        List<Person> people = Arrays.asList(
                new Person("Alice", 26),
                new Person("Bob", 40),
                new Person("Charlie", 18),
                new Person("David", 55),
                new Person("Eve", 70)
        );

        //Iterativ
        Map<AgeCategory,List<Person>> personGropingIteratively = new HashMap<>();
        //todo: inlocuiti enhanced for-ul de mai jos cu un for each
        for (Person it : people) {
            AgeCategory currentAgeCategoryOfPerson = getAgeCategory(it.getAge());
            if (personGropingIteratively.containsKey(currentAgeCategoryOfPerson)) {
                // pentru barnchul de adevar, prezumtia e aceea ca Key-ul nostru exita in mapa
                // daca exista in mapa, doar actualizam lista de valori
                personGropingIteratively.get(currentAgeCategoryOfPerson).add(it);

            } else {
                // pentru barnchul de adevar, prezumtia e aceea ca Key-ul nostru nu exita in mapa
                // prin urmare, vom adauga o noua pereche, definita de cheie si o lista de valori ce contine elementul din if
                personGropingIteratively.put(currentAgeCategoryOfPerson,new ArrayList<>(List.of((it)))); //
                //facem conversie de la  List.of care creeaza automat o lista IMUTABILA = nemodificabila
            }
        }



        //Stream
        //Metoda groupingBy are rolul de a crea o mata de perechi definita pe baza unei chei unice si a unei valori
        //Prin urmare groupingBy primeste ca si argument o expresie lambda definita pe baza elementului curent si a
        //metodei de clasificare a cheii.

        Map<AgeCategory,List<Person>> personGropingStream = people
                .stream()
               .collect(Collectors.groupingBy(it -> getAgeCategory(it.getAge())));

        //Output

        displayPersonGroupingMap(personGropingStream);
        System.out.println("-----------------------------------------------");
        displayPersonGroupingMap(personGropingIteratively);
    }

    private static void displayPersonGroupingMap(Map<AgeCategory, List<Person>> personGroping) {
        //todo: faceti algoritmul de display in modul iterativ clasic
        personGroping.forEach((ItK,ItV) -> {
            System.out.println("Age Group: " + ItK);
            ItV.forEach(itPerson -> {
                System.out.println("- "+ itPerson.getName() + " has " + itPerson.getAge() + " years");
            });
            System.out.println();
        });
    }

    private static AgeCategory getAgeCategory(int age) {
        if (age <= 18)
            return AgeCategory.CHILD;
        else if (age <= 65)
            return AgeCategory.ADULT;
        else
            return AgeCategory.SENIOR;
    }
}
