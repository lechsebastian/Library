package com.company.io;

import com.company.model.Book;
import com.company.model.Magazine;

import java.util.Scanner;

public class DataReader {
    private Scanner sc = new Scanner(System.in);

    public Book readAndCreateBook(){
        System.out.print("Tytul: ");
        String title = sc.nextLine();
        System.out.print("Autor: ");
        String author = sc.nextLine();
        System.out.print("Wydawnictwo: ");
        String publisher = sc.nextLine();
        System.out.print("ISBN: ");
        String isbn = sc.nextLine();
        System.out.print("Rok wydania: ");
        int releaseDate = getInt();
        System.out.print("Liczba stron: ");
        int pages = getInt();

        return new Book(title, author, releaseDate, pages, publisher, isbn);
    }

    public Magazine readAndCreateMagazine(){
        System.out.print("Tytul: ");
        String title = sc.nextLine();
        System.out.print("Wydawnictwo: ");
        String publisher = sc.nextLine();
        System.out.print("Jezyk: ");
        String language = sc.nextLine();
        System.out.print("Rok wydania: ");
        int releaseDate = getInt();
        System.out.print("Miesiac: ");
        int month = getInt();
        System.out.print("Dzien: ");
        int day = getInt();

        return new Magazine(title, publisher, language, releaseDate, month, day);
    }

    public int getInt(){
        int number = sc.nextInt();
        sc.nextLine();
        return number;
    }

    public void close(){
        sc.close();
    }
}
