package org.example.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
    Exercise 11: Mapping, FlatMapping, and Collecting to List
    Given a list of lists of integers, flatten the lists into a single list of integers
    and collect the result into a new list.



    DPDV matematic:
    o matrice cu 3 linii si 3 coloane:

    1 5 6
    6 2 6
    9 8 1

    o matrice care are lungimea si latimea egale, se numeste matrice patratica

    DPDV al programarii:

    list of lists = matrix

    List = {Element0, Element1, Element2, Element3, Element4, Element5..}

    unde Element este o lista

    => List { {List0},{List1},{List2},{List3},{List4}...}
    LP:
    L0= 1 5 6
    L1= 6 2 6
    L2= 9 8 1

    flatten = reductie dimensionala de la 2D la 1D

    L1D { 1 5 6 6 2 6 9 8 1} nrOfLists * nrOfElementsOfOneList = 3*3 = 9



 */
public class MultidimensionalMaping {
    public static void main(String[] args) {
        List<List<Integer>> matrix2D = Arrays.asList(
                Arrays.asList(1, 5, 6),
                Arrays.asList(6, 2, 6),
                Arrays.asList(9, 8, 1)
        );
        System.out.println("Matrice 2D: " + matrix2D);

        //Algoritm iterativ
        //o matrice multidimensionala este parcursa de un numar de instructiuni repetitive egal cu numarul dimensiunilor
        List<Integer> list1DIteratively = new ArrayList<>();
        for (List<Integer> innerList : matrix2D) {
            for (Integer it : innerList) {
                list1DIteratively.add(it);
            }
        }
        System.out.println("Lista 1D iterativ: " + list1DIteratively);

        //Algoritm cu Streams
        List<Integer> list1DStreams = matrix2D.stream()
                .flatMap(it -> it.stream())
                .toList();
        System.out.println("Lista 1D cu streams: " + list1DStreams);

    }
}
