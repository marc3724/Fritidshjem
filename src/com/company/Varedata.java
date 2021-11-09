package com.company;

public class Varedata implements java.io.Serializable {
int antal;
String vareNavn;
double pris;
//Opret en klasse VareData, med konstruktør, set og get funktioner.
    public Varedata(){
    }

    public Varedata(int antal, String vareNavn, double pris) {
        this.antal = antal;
        this.vareNavn = vareNavn;
        this.pris = pris;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public String getVareNavn() {
        return vareNavn;
    }

    public void setVareNavn(String vareNavn) {
        this.vareNavn = vareNavn;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }
}
