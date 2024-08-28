package org.example.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Stream-urile se utilizeaza doar in contextul structurilor de date!!!!!!!!!

    Streams = este un contract de metode(API =Aplication Programming Interface) care pune in valoare o maniera
    de programare axata pe utilizarea operatiilor functionale

    O operatie functionala se refera la prelucrarea unui set de date intr-o forma generica astfel incat sa putem
    extrage diverse metrici indiferent de structura de date utilizata.

    Deci streamurile au scopul de a generaliza operatiile clasice iterative de:
        - utilizare a instructiunilor conditionale (If, switch)
        - utilizare a instructiunilor repetitive(for, while, do-while)
        - utilizare a instructiunilor de conversie

    Avantaje:
        - declarative: standardizare a codului dupa o intelegere comuna a membrilor echipei
        - lazy evaluation: operatiile pe stream-uri sunt invocate in momentul executiei instructiunii, fara a mai avea
        nevoie de faze intermediare de prelucrare/stocare
        - pipeline: (builder type class) executia unei operatiuni folosind streamuri va avea invocari repetate a
        obiectului curent pentru toate etapele intermediare
 */
public class StreamsTheory {
    public static void main(String[] args) {
List<String> names = Arrays.asList("Alice","Bobo","Anna","Beatrice");

List<String> orderedNames = names
        .stream()
        .sorted()
        .toList();

        System.out.println("Lista dezordonata: " + names);
        System.out.println("Lista ordonata: " + orderedNames);
    }
}
