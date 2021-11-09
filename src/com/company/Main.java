package com.company;

import java.io.*;
import java.util.Scanner;

/*
1	Opret en klasse VareData, med konstruktør, set og get funktioner.                                                   ok
2	Opret et array af VareData objekter.                                                                                ok
3	Indlæs informationerne fra tekstfilen ”bestilling.txt” i VareData-objekter.                                         ok
4	Lav en funktion udskriv, som modtager et array af VareData og som udskriver indholdet til skærm.                    ok
5	Skriv indholdet af arrayet med VareData til en datafil “varer.ser” med ObjectOutputStream.                          ok
6	Indlæs fra datafil “varer.ser” med ObjectInputStream til et array af VareData objekter. Kald funktionen udskriv.    ok
7	Lav funktion som beregner den samlede pris for hver vare med og uden rabat.
8	Lav funktion, som beregner saldoen for det samlede varekøb med og uden rabatter.
9	Lav funktion, som udskriver faktura hvor der er informationer om: hvilke varer der er købt, antallet af hver vare, prisen for hver vare med og uden rabat, og den samlede saldo med og uden rabat. Fakturaen skal både udskrives til skærm og til en ny tekstfil ”faktura.txt”.

 */
public class Main {

    public static void main(String[] args) {
// 2 Opret et array af VareData objekter.
        Varedata[] arrayOfVaredata = new Varedata[20];
        for (int i = 0; i < 20; i++) {
        arrayOfVaredata[i] = new Varedata();
        }
        int antalVarer;

        antalVarer = readFile(arrayOfVaredata);
        udskriv(arrayOfVaredata, antalVarer);

        skrivObjFil(arrayOfVaredata, antalVarer);
        antalVarer = readObjFil(arrayOfVaredata);
        udskriv(arrayOfVaredata, antalVarer);

    }
//----------------------------------------------------------------------------------------------------------------------
//3	Indlæs informationerne fra tekstfilen ”bestilling.txt” i VareData-objekter.
    static int readFile(Varedata[] a){
        int i =0;

        try {
            File myObj = new File("Bestilling.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNext()){
            //for (int i = 0; i < antal; i++) {
                a[i].setAntal(myReader.nextInt());
                a[i].setVareNavn(myReader.next());
                a[i].setPris(myReader.nextDouble());
                i++;
            }
            myReader.close();
            System.out.println("readFile is good\n");
        } catch (Exception e) {
            System.out.println("fail in readFile");
            e.printStackTrace();
        }
        return i;
//----------------------------------------------------------------------------------------------------------------------
    }
    //4	Lav en funktion udskriv, som modtager et array af VareData og som udskriver indholdet til skærm.
    public static void udskriv (Varedata[] a , int antal) {
        for (int i = 0; i < antal; i++) {
            System.out.printf("%d %s %.2f \n", a[i].getAntal(),a[i].getVareNavn(), a[i].getPris());

        }
        System.out.println(" ");
    }
//----------------------------------------------------------------------------------------------------------------------
//5	Skriv indholdet af arrayet med VareData til en datafil “varer.ser” med ObjectOutputStream.
    public static int readObjFil(Varedata[] a){
        int i = 0;
        try{
            FileInputStream f =new FileInputStream("varer.ser");
            ObjectInputStream in = new ObjectInputStream(f);
            while(f.available()>0){
                a[i] = (Varedata) in.readObject();
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public static void skrivObjFil(Varedata[] a, int antal){
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("varer.ser"));
            for (int i = 0; i < antal; i++) {
                out.writeObject(a[i]);
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//-------------------------------------------------------------------------------------------------------------------
//6	Indlæs fra datafil “varer.ser” med ObjectInputStream til et array af VareData objekter. Kald funktionen udskriv.
    public static void udskrivObj(Varedata[] a) {
        try{

        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
