package org.example.oop;

/*
        // ----------------------keywords---------------------
        Nu puteti avea mai multe metode main intr-o clasa deoarece scopul acesteia este de a compila codul din punct
        de vedere sintactic.
        Insa chiar daca metoda main e uica la nivelul unei clase, pot avea fiecare o metoda main.
        Sinonime:
            Librarie - proiect java
            Metoda - functie

        Keywords sunt instructiuni predefinite in Java prin care putem interactiona cu functionalitatile compilatorului.
        Class - este o schita generala a unei tipologii de obiect
        Obiectul este instanta unei clase
        Metoda = este functionalitatea clasei
        Semnatura metodei = reprezinta modul de definitie al unei functii/metode
        Corpul metodei = reprezinta instructiunile definite intre acoladele metodei.

        Clasa se poate utiliza pentru mai multe scopuri
        -tip de date: acesta reprezinta natura obiectului/variabilei/constantei pe care o definim.

        // ----------------------Abstraction-------------------

        Abstractizarea este unul din principalele principii ale programarii orientate pe obiecte si se refera la
        conceptul de ascundere a detaliilor de implementare ale clasei prin expunerea partilor esentiale la nivel
        de obiect.
        Putem reprezenta abstractizarea in urmatoarele moduri:
        1. calasa wrapper = reprezinta o clasa ce se comporta ca un invelis peste un anumit context functional
            -tipuri de date primitive : int,float,double,byte,short,char.
            -tipurile de date wrapper : Integer,Double,Float,Byte,Short,Character...
        2. clase abstracte
        3. interfete

        Interfata:
        -este o clasa care are ca si scop stabilirea unei liste care cuprinde comportamentul unei tipologii de
        obiect, punand la dispozitie semnatura metodelor constituente
        -nu poate stoca atribute/caracteristici comune
        -toate metodele sunt in mod standard publice
        toate metodele sunt in mod standard abstracte fara implementare
        -putem instantia obiecte pe care le definim prin constructorul clasei de implementare ->
         List<String> shoppingList = new ArrayList()<>;
         -nu avem constructori

         cand folosim interfata?
            -utilizam interfata in momentul in care vrem sa generalizam o serie de metode pentru mai multe clase
            indiferent de localizarea lor in proiect

        Clasa abstracta:
        -keyword-ul "abstract" se utilizeaza in 2 scenarii - > la nivel de clasa si la nivel de metoda
        -este o clasa care are ca si scop definirea unui set comun de caracteristici sau comportamente comune
        pentru a fi mai departe mostenita -> clasa de configuratie (clasa parinte)
        -metodele pot fi marcate cu orice modificator de acces dorit(public,privat,default,protected)
        -metodele pot fi fie abstracte cu sau fara implememtare sau concreta
        -nu putem instantia obiecte
        -avem constructori

          cand folosim clasa abstracta?
            -utilizam clasa abstracta in momentul in care vrem sa generalizam o serie de atribute/metode comune
            pentru mai multe clase localizate in acelasi pachet parinte/subpachet, si avand acelasi context funtional

 */

// Aplicatie: Dat fiind 3 clase identificand tipuri geometrice, imi doresc sa creez o clasa abstracta si o interfata
// care sa defineasca un nivel comun de configuratie pentru toate figurile discutate (cerc,patrat,dreptunghi...)

//* Clasa parinte de configuratie
abstract class Shape {
    protected double perimeter;
    protected double area;

    public abstract double calculateArea();

    public abstract double calculatePerimeter();

    public void display() {
        System.out.println("Perimeter: " + perimeter + ", Area: " + area);
    }
}

interface ShapeInterface {
//interfata pentru metode comune

    void draw();
}
//clase COPIL
class Circle extends Shape implements ShapeInterface {

    private double radius;

    Circle(double radius) {
        this.radius = radius;
        this.area = calculateArea();
        this.perimeter = calculatePerimeter();

    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle!");

    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", perimeter=" + perimeter +
                ", area=" + area +
                '}';
    }
}

class Square extends Shape implements ShapeInterface {

    private double value;

    Square(double value) {
        this.value = value;
        this.area = calculateArea();
        this.perimeter = calculatePerimeter();
    }

    @Override
    public double calculateArea() {
        return value * value;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * value;
    }

    @Override
    public void draw() {
        System.out.println("This is a square!");

    }
}

class Rectangle extends Shape implements ShapeInterface {

    private double lenght;
    private double width;

    Rectangle(double lenght, double width){
        this.lenght = lenght;
        this.width = width;
        this.area = calculateArea();
        this.perimeter = calculatePerimeter();
    }
    @Override
    public double calculateArea() {
        return lenght*width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (lenght*width);
    }

    @Override
    public void draw() {
        System.out.println("This is an Rectangle!");

    }
}

class Triangle extends Shape implements ShapeInterface{
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.area = calculateArea();
        this.perimeter = calculatePerimeter();
    }

    @Override
    public double calculateArea() {
        double semiPerimeter = (side1+side2+side3)/2;
        return Math.sqrt( semiPerimeter* (semiPerimeter-side1)*(semiPerimeter-side2)*
                (semiPerimeter-side3));
    }

    @Override
    public double calculatePerimeter() {
        return (side1+side2+side3);
    }

    @Override
    public void display() {
        super.display();
    }

    @Override
    public void draw() {
        System.out.println("This is an Triangle!");

    }
}

//todo: create a Triange class
public class AbstractionPrinciple {
    public static void main(String[] args) {
        /** Exemplu 1 : Abstractizarea prin clase Wrapper */

        Integer nr1 = 98;
        Integer nr2 = 78;

        //valorile booleane(true,false) sunt criptate in java in cod binar(1,0)
        /*
        nr1>nr2 = 1
        nr1=nr2 = 0
        nr1<nr2 =-1
         */
        System.out.println(nr1.compareTo(nr2));

        /** Exemplu 2 : Abstractizarea prin clase copil ce mostenesc o clasa parinte abstracta si implementeaza o
         * interfata*/

        Circle circle = new Circle(4.5);
        Square square = new Square(6);
        Rectangle rectangle = new Rectangle(7,8);
        Triangle triangle = new Triangle(5.0,6.0,7.0);

        circle.display();
        square.display();
        rectangle.display();
        triangle.display();
        System.out.println(circle);


    }
}
