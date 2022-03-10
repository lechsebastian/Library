package com.company.app;

import com.company.io.DataReader;
import com.company.model.Book;
import com.company.model.Library;

class LibraryControl {
    private final int exit = 0;
    private final int addBook = 1;
    private final int printBooks = 2;
    private DataReader dataReader = new DataReader();
    private Library library = new Library();

    public void controlLoop(){
        int option;

        do{
            printOptions();
            option = dataReader.getInt();

            switch (option) {
                case addBook -> addBook();
                case printBooks -> printBooks();
                case exit -> exit();
                default -> System.out.println("Nie ma takiej opcji! Sprobuj ponownie!");
            }
        }while(option != exit);
    }

    private void exit() {
        System.out.println("Koniec programu!");
        dataReader.close();
    }

    private void printBooks() {
        library.printBooks();
    }

    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }

    private void printOptions() {
        System.out.println();
        System.out.println(exit + " - wyjscie z programu");
        System.out.println(addBook + " - dodanie nowej ksiazki");
        System.out.println(printBooks + " - wyswietl dostepne ksiazki");
        System.out.print("Wybierz opcję: ");
    }
}
