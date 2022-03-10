package com.company.io;

import com.company.model.Book;

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
        int releaseDate = sc.nextInt();
        sc.nextLine();
        System.out.print("Liczba stron: ");
        int pages = sc.nextInt();
        sc.nextLine();

        return new Book(title, author, releaseDate, pages, publisher, isbn);
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
