package org.example.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Fie o lista de stringuri cu litere mici, creati o lista de dimensiune identica care sa contina toate stingurile cu
    litera mare
 */
public class UppercaseList {
    public static void main(String[] args) {
        List<String> fructe = Arrays.asList("cirese" ,
                "mere" ,
                "pere" ,
                "banane");

        System.out.println("Lista iterativa: " + convertToUpperCaseIteratively(fructe));
        System.out.println("Lista cu streams: " + convertToUpperCaseStreams(fructe));
    }

    private static List <String> convertToUpperCaseStreams(List<String> fructe) {
        return fructe
                .stream()
                .map(it -> it.toUpperCase())
                .toList();
    }

    private static List<String> convertToUpperCaseIteratively(List<String> fructe) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i<fructe.size(); i++){
            result.add(fructe.get(i).toUpperCase());
        }
        //reminder: merge si cu enhanced for
        return result;
    }
}