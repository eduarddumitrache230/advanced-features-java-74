package org.example.oop;

/*
    Mostenirea ne permite sa preluam informatii generale dintr-o clasa parinte si sa le transmitem mai departe in
    clasele copil. Scopul principal este acela de a crea un nivel de generalizare intre o serie de clase ce apartin
    aceluiasi context si de a le permite sa se diferentieze intre ele intr-un mod mult mai vizibil.

    Multilevel Inheritance = Mostenire Multipla
    In Java nu este posibil deoarece o clasa copil unui singur parinte

    Ce alternative avem?

    1.Mostenire multipla din copil in copil, adica fiecare copil la randul lui devine parinte pentru alte clase
    Mammel -> Dog -> BabyDog...

    2.Mostenire multipla la nivel de interfete
    Interfata = este un tip de clase care defineste de regula contractul comportamental al unei tipologii de obiect

    Cand utilizam mostenirea prin clase?
        -de regula atunci cand dispunem de minim 2 clase copil care au in comun un set de atribute

    Cand utilizam interfete?
        - de regula atunci cand dispunem de minim 2 clase care au in comun acelasi set de metode, insa cu implementari
        diferite

 */

class Mammel {
    int age;
    String furColour;
    String species;

    Mammel(){

    }
    Mammel(int age, String furColour, String species) {
        this.age = age;
        this.furColour = furColour;
        this.species = species;

    }

    Mammel(int age, String furColour) {
        this.age = age;
        this.furColour = furColour;

    }

    void display() {
        System.out.println("Parent Dog class: " + this.species + " " + this.furColour + " " + this.age + " ");
    }

    void sound() {
        System.out.println("Mamel makes sound!");
    }

    /*
    Child class = Derived class
     */


}

class Dog extends Mammel {

    String favoriteToy;

    Dog(int age, String furColour, String favoriteToy) {
        super(age, furColour); // apeleaza constructorul din clasa parinte pentru atributele generice
        // prin sintaxa lui de constructor
        this.favoriteToy = favoriteToy;

    }

    @Override
    void sound() {
        super.sound();  //apelam metodele sau atributele din clasa parinte prin sintaxa lui super de obiect de
        //tipul Mammel
        System.out.println("Dog barks!");
    }

    @Override
    void display() {
        super.display();
        System.out.println("Child Dog class: " + favoriteToy);
        System.out.println(super.furColour);
    }
}

class Cat extends Mammel {
    Cat(int age, String furColour, String species) {
        super(age, furColour, species);
    }
}

class BabyDog extends Dog {
    BabyDog(int age, String furColour, String favoriteToy) {
        super(age, furColour, favoriteToy);
    }
}


    interface I1 {

        void display();
        //putem avea cate metode vrem
        //mecanismul de definire al unui contract comportamental este stric legat de contextul aplicatiei
    }

    interface I2 {

        void sound();
    }

    class I implements I1,I2 {

        @Override
        public void display() {
            System.out.println("Hello world!");

        }

        @Override
        public void sound() {
            System.out.println("Ham Ham");

        }
    }
    class Other implements I2 {

        @Override
        public void sound() {
            System.out.println("Miau Miau");

        }
    }
    public class InherintancePrinciple {

        public static void main(String[] args) {
            Mammel mammel = new Mammel(5, "rosu", "raton");
            Mammel dog1 = new Dog(4, "alb", "os"); // ok functional, not really moral
            Dog dog2 = new Dog(13, "negru", "papusa");

            mammel.display();
            mammel.sound();
            System.out.println("----------------------------");
            dog1.display();
            dog1.sound();
            System.out.println("----------------------------");
            dog2.display();
            dog2.sound();

        }
    }
