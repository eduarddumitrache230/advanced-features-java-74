package org.example.streams;

import java.util.Arrays;
import java.util.List;

/*
    Fie o lista de valori. Calculati suma patratelor numerelor pare din lista.

    1,2,3,4,5 -> 2^2 + 4^2 = 20 ... gen
 */
public class SumOfSquareIntegers {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("Suma patratelor pare iterativ: " + calculateSquareSumOfEvenNumbersIteratively(numbers));
        System.out.println("\nSuma patratelor pare stream: " + calculateSquareSumOfEvenNumbersStreams(numbers));
        System.out.println("\nSuma patratelor pare stream: " + calculateSquareSumOfEvenNumbersStreams2(numbers));
    }

    private static Integer calculateSquareSumOfEvenNumbersStreams(List<Integer> numbers) {
        return numbers
                //operatia de conversie
                .stream()
                //operatii intermediare
                .filter(it ->it % 2 == 0) //cream o sublista doar cu valori pare
                .peek(it -> System.out.print(it + " ")) // arata doar structura ( ce s-a intamplat pana in pct acela).
                .map(it -> it * it) //cream o sublista doar cu valori pare la patrat
                //operatia de colectare/reductie
                .reduce(0, Integer::sum);
    }
    private static Integer calculateSquareSumOfEvenNumbersStreams2(List<Integer> numbers) {
        return numbers
                //operatia de conversie
                .stream()
                //operatii intermediare
                .filter(it ->it % 2 == 0) //cream o sublista doar cu valori pare
                .map(it -> (int)Math.pow(it,2)) //cream o sublista doar cu valori pare la patrat
                //operatia de colectare/reductie
                .reduce(0, Integer::sum);
    }

    //peek nu modifica structura stream-ului in niciun fel.
    private static Integer calculateSquareSumOfEvenNumbersIteratively(List<Integer> numbers) {
        Integer result = 0;

        for (Integer it : numbers) {
            if (it % 2 == 0) {
                result += it * it; // Math.pow(it.2)
            }
        }
        return result;
    }
}
