package org.example.oop;
/*
----------------Incapsulation ----------------------
Incapsularea = este un concept prin care ascundem atributele clasei prin modificatori de acces(private/protected)
in scopul limitarii vizibilitatii publice si pentru a incuraja abstractizarea la nivel de metoda.

---------------Objetct Class ----------------------
Clasa de obiect este o clasa de tipul wrapper (POJO -plain old java project) care defineste trasaturile si
comportamentul unui obiect in mod generalist
 */

class Employee {
    // atribute = trasaturile generale ale obictului de instanta al clasei
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private String team;
    // constructorul = modul de definire al schitei obiectului pe baza atributelor
    // constructorul neparametrizati = este mereu unul singur si are scopul de a defini o valoare incipienta a
    // atributelor, de regula fiind limita inferioara a tipului de date al atributului ( dar depinde de context)
    // acest tip de constructor instantiaza un obiect nedefinit
    public Employee (){
        this.id = -1;
        this.firstName = "placegolder first name";
        this.lastName = "placegolder first name";
        this.age = -1;
        this.team = "placeholder team";
    }
    // constructorii parametrizati = sunt in general o infinitate raportata la numarul de atribute
    // this = este un pointer care face referire la atributele clasei curente
    // motiv pentru care putem pastra o corelatie vizuala intre denumirea atributelor si a argumentelor
    // din constructor
    // alternativ, in cazul in care nu folosim "this." suntem  obligati sa avem denumiri diferite intre cele 2
    // pentru a nu crea confuzie compilatorului
    public Employee (long id,String firstName,String lastName,int employeeAge,String team) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        age = employeeAge; // daca nu vrem cumva cu this, nu e best practice, e doar functional
        this.team = team;
    }
    public Employee (String firstName,String lastName) {
        this.id = -1;
        this.firstName = firstName;
        this.lastName = lastName;
        age = -1; // daca nu vrem cumva cu this, nu e best practice, e doar functional
        this.team = "placeholder team";
    }
    // functionalitatile = metode de utilizare prin intermediul instantei de obiect.
        //getters/setters
        //getter = o metoda prin care interactionam cu valorile atributelor ( public <attribute type>
        //get <Attribute name>() {return this.attribute;}
        //setter = o metoda prin care setam valoarea atributelor printr-un argument dat
        //tipul de date al setterelor este mereu void, iar tipul de date al argumentelor este acelasi cu al atributelor


    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getTeam() {
        return team;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTeam(String team) {
        this.team = team;
    }
    //overridden methods

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", team='" + team + '\'' +
                '}';
    }


    //custom methods

}

public class EncapsulationPrinciple {
    public static void main(String[] args) {

        Employee worker = new Employee();
        Employee worker2 = new Employee(1,"Iancu","Jianu",26,"Ravens");
        Employee worker3 = new Employee("Alex","Alexandru");
        System.out.println("Original 1st worker: " + worker);
        System.out.println("Original 2nd worker: " + worker2);
        System.out.println("Original 3st worker: " + worker3);
        System.out.println("----------------------");

        worker.setAge(78);
        worker3.setTeam("Falcons");
        System.out.println("Modified 1st worker: " + worker);
        System.out.println("Modified 2nd worker: " + worker2);
        System.out.println("Modified 3rd worker: " + worker3);

    }
}
