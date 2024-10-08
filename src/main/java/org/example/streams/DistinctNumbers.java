package org.example.streams;

import java.util.*;

/*
    Fie o lista cu numere intregi duplicate. Creati o sublista doar cu numere unice.
 */
public class DistinctNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,44,1,2,4,99,1,2,3,55,23,5,2,434,4,2,3,5,1,66,5);

        System.out.println("Distinct list with Hashset: " + extractDistinctNumbersUsingHashSet(numbers));
        System.out.println("Distinct list with Treeset: " + extractDistinctNumbersUsingTreeSet(numbers));
        System.out.println("Distinct list iteratively: " + extractDistinctNumbersIteratively(numbers));
        System.out.println("Distinct list with streams: " + extractDistinctNumbersUsingStreams(numbers));
    }

    private static List<Integer> extractDistinctNumbersUsingStreams(List<Integer> numbers) {
        return numbers
                .stream()
                .distinct()
                .sorted()
                .toList();
    }

    private static List<Integer> extractDistinctNumbersIteratively(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();

        //Filtrare a valorilor dublicitare, astfel incat result sa contina doar aparentele unice
        for(Integer it: numbers){
            if(!result.contains(it)){ //if value doesnt exist
                result.add(it);     //add to list
            }
        }
        //Sortare
        result.sort(Comparator.naturalOrder());

        return result;
    }

    private static List<Integer> extractDistinctNumbersUsingHashSet(List<Integer> numbers) {
        Set<Integer> result = new HashSet<>(numbers);
        return new ArrayList<>(result);

        // new ArrayList<>(new HashSet<>(numbers))
    }

    private static List<Integer> extractDistinctNumbersUsingTreeSet(List<Integer> numbers) {
        Set<Integer> result = new TreeSet<>(numbers);
        return new ArrayList<>(result);

        // new ArrayList<>(new TreeSet<>(numbers))
    }
}
