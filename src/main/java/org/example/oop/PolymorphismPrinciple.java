package org.example.oop;

/*
Polimorfismul permite obiectelor din diferite clase sa fie tratate asemeni clasei in care sunt suprascrise
(override) sau supraincarcate (overload).

Override:
-se asigura prin folosirea adnotarii Override
-ne permite sa oferim o implementare personalizata unei metode preluata din clasa parinte
-putem suprascrie in 2 feluri:
    -suprascriere din clasa parinte:metoda din Mammel este predefinita in Dog cu o alta implementare
    -suprascriere din interfata: metoda "display" din I1 primeste o implementare fiindca nu are niciuna
Overload:
-se asigura la nivel de clasa!
-se pastreaza integral denumirea metodei, dar putem schimba semnatura complet(alt tip de returnat si/sau alta
implementare
overload - doar pe clasa curenta
 */
class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    float add(float a, float b, float c) {
        return a + b + c;
    }
}

public class PolymorphismPrinciple {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        System.out.println(calculator.add(17, 2.2));
    }
}
