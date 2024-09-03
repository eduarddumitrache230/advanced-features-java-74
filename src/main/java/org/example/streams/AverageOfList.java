package org.example.streams;

/*
    Exercise 10: Filtering, Sorting, and Reducing to Single Value
    Given a list of student objects,
    - filter out the students who passed the exam,
    - sort them based on their scores in descending order,
    - find the average score of the top 10 students.

    Student: name, score, passedExam (va fi calculat pe baza scorului
    -nane su scire vor fi valori pe care le trimitem prin constructor
    - passedExam va fi true daca score-ul este mai mare sau egal cu 5, altfel false
 */

import lombok.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Setter
@AllArgsConstructor //ne va crea concstrucotrul parametrizat
@NoArgsConstructor //ne va crea concstrucotrul neparametrizat
@Getter
@ToString

class Student{
    private String name;
    //todo: in loc de un singur scor, am putea avea o lista de scoruri pe baza careia sa se calculeze o medie
    // per student, si la final o medie generala a listei de studenti
    private int score;
    private boolean passedExam;

    //alternativa lombok pt constrcutori partiali este @RequiredConstructor
    //doar ca nu e util situatia actuala, pt ca in constrcutor, unul dintre atribute il vom determina pe baza altuia
    public Student(String name, int score){
        this.name = name;
        this.score = score;
        //todo: inlocuti if-ul clasic cu un if tertiar (google it)
        //conditional checkup
        if(this.score   >= 5 ) {
            this.passedExam = true;
        }else {
            this.passedExam = false;
        }
    }

}

public class AverageOfList {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<Student>();
        students.add(new Student("John", 8));
        students.add(new Student("Alice", 7));
        students.add(new Student("Bob", 9));
        students.add(new Student("Charlie", 5));
        students.add(new Student("David", 6));
        students.add(new Student("Eve", 8));
        students.add(new Student("Frank", 10));
        students.add(new Student("Grace", 2));
        students.add(new Student("Henry", 3));
        students.add(new Student("Irene", 2));

        //Algoritmul iterativ
        //filter by passed exam - vrem sa creeam o sublista unde se avem doar studentii care au promovat examenul
        List<Student> filterStudents = new ArrayList<>();
        for (Student it : students){
            if (it.isPassedExam()) //se face verificarea de egalitate subinteleasca cu TRUE
                filterStudents.add(it);
        }


        //sort
        filterStudents.sort(Comparator.comparingInt(Student::getScore).reversed());
        //Comparator.comparingInt(Student::getScore) = sorteaza ascendent in functie de scorul fiecarui student
        //Student::getScore = invocare a metodei de referinta = regula care seteaza modul de comparatie
        //.reversed() = inverseaza lista(ultimul index devine primul ..)

        //average of scores
        double sum = 0;
        for (Student it : filterStudents) {
            sum += it.getScore();
        }
        System.out.println("Media aritmetica este: " + sum/filterStudents.size());

        //Algoritmul cu stream
        double resultStream = students.stream()
                //conversie a structurii de date(list) la secventa de date(stream)
                .filter(it -> it.isPassedExam())
                //crearea unei subliste pe baza unei filtrari dupa isPassedExam
                .sorted(Comparator.comparingInt(Student::getScore).reversed())
                //sortare inversa dupa getScore
                .mapToDouble(it -> it.getScore())
                //average: prima data cream sublista de elemente double
                .average().getAsDouble();
                // average la final facem media tuturor elementelor double din sublista
                // si stocam rezultatul in variabila resultStream

        System.out.println("Media aritmetica cu stream: " + resultStream);

    }
}
