package org.example.DSA;

import java.util.*;

/*
    Set = este o structura de date care styocheaza colectii de elemente distincte
    Daca se va incerca sintr-un set sa se introduca elemente identice, mereu se va pastra prima aparitie

    In set nu mai exista conceptul de intex, ci de iterator.

    Setul este la baza o interfata care e implementata de catre HashSet.

    !!!!!!!!! vizibilitatea unui obiect in cod este restrictionata de zona de definitie.
    Daca definim spre exemplu un obiect in interiorul unei instructiuni conditionale/repetitive, aceasta va avea
    posibilitatea de accesare doar in contextul metodei si nu in afara ei

    D
 */
public class SetTheory {
    public static void main(String[] args) {
        // Initializare si definire a unui set

        Set<String> myHashSet = new HashSet<>();

        // ADD & ADD ALL

        myHashSet.add("apple"); //valoarea nu exista in set asa ca a fost adaugata
        myHashSet.add("pear");
        myHashSet.add("cherry");
        System.out.println(myHashSet);

        myHashSet.add("apple");

        System.out.println(myHashSet); //false, setul a ramas neschimbat

        myHashSet.addAll(new HashSet<>(Set.of("apple","banana"))); //se adauga doar elementele care nu exista
        //daca folosim ca si parametru un set,se va face uniunea celor 2 prin concatenarea setului original la
        //cel dat ca parametru.
        System.out.println(myHashSet);
        System.out.println("------------------------------");

        // ITERATION METHODS

        // enhanced for (functioneaza la orice structura de date : List, Set,Map)
        //nu avem control asupra indexului, putem face operatiuni exclusiv pe elementul curent reprezentat de it
        System.out.print("Enhanced for example: ");
        for (String it:myHashSet){
            System.out.print(it + " ");
            int a =3;
        }

        System.out.println();
        //iterator object using while (functioneaza la orice structura de date...)
        System.out.println("Iterator while example: ");
        Iterator<String> it = myHashSet.iterator();
        while (it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println("\n------------------------------------------");
        // Remove
        System.out.println(myHashSet.remove("apple") + " -> " + myHashSet);
        System.out.println(myHashSet.remove("apple") + " -> " + myHashSet);

        //todo: removeAll
        System.out.println("\n--------------------------------");
        // CONTAINS

        System.out.println(myHashSet.contains("apple"));
        System.out.println(myHashSet.contains("cherry"));
        //todo:containsAll
        System.out.println("\n--------------------------------");
        //todo: size,clear,isEmpty

        //List to Set
        //Elimina toate elementele duplicitare dintr-o lista

        List<Integer> numberList = new ArrayList<>(List.of(1,5,1,11,5,5,6,32,1));

        // Varianta babeasca
        //todo: creati o noua lista pe baza iteratiei celei originale in care verificati conditional cu un if daca
        // lista noua CONTINE valoarea curenta din for

        //Varianta smart

        Set<Integer> uniqueNumbersList = new HashSet<>(numberList);

        System.out.println(uniqueNumbersList);
    }
}
