package org.example.exercices.OOP;

/*
    Clasa parinte(clasa de configuratie):
    - poate fi abstracta deoarece nu ne intereseaza sa o utilizam pentru a instantia obiecte, pt acest scop vom avea
    clasele copil care o mostenesc.
    -atributele pot fi protected deoarece ne intereseaza ca ele sa poata fi vizibile in clasele copil fara a utiliza
    getters/setters
    -constructori neparametrizati sau parametrizati // getter/setter/toString
    -metodele pot fi abstracte, deoarece daca mi cautam sa instantiam obiecte dupa clasa parinte,
    nu va fi necesar sa stocam metode cu corp de implementare pentru ca nu vor fi apelate niciodata.
 */
public abstract class MultimediaItem {
    protected String title;

    public MultimediaItem(){

    }
    public MultimediaItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "MultimediaItem{" +
                "title='" + title + '\'' +
                '}';
    }

    public abstract void play();

    public abstract void stop();
}

class MultimediaAudio extends MultimediaItem {
    public MultimediaAudio(String title) {
        super(title);
    }

    @Override
    public void play() {
        System.out.println("MultimediaAudio"+ title+ "plays");
    }

    @Override
    public void stop() {
        System.out.println("MultimediaAudio"+ title+ "stops");

    }
}

class MultimediaVideo extends MultimediaItem {
    @Override
    public void play() {
        System.out.println("MultimediaVideo"+ title+ "plays");
    }

    @Override
    public void stop() {
        System.out.println("MultimediaVideo"+ title+ "stops");
    }

    public MultimediaVideo(String title) {
        super(title);
    }
}

