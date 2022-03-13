package com.company.app;

import com.company.io.DataReader;
import com.company.model.Book;
import com.company.model.Library;

class LibraryControl {
    private static final int EXIT = 0;
    private static final int ADD_BOOK = 1;
    private static final int PRINT_BOOKS = 2;
    private DataReader dataReader = new DataReader();
    private Library library = new Library();

    public void controlLoop(){
        int option;

        do{
            printOptions();
            option = dataReader.getInt();

            switch (option) {
                case ADD_BOOK -> addBook();
                case PRINT_BOOKS -> printBooks();
                case EXIT -> exit();
                default -> System.out.println("Nie ma takiej opcji! Sprobuj ponownie!");
            }
        }while(option != EXIT);
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
        System.out.println(EXIT + " - wyjscie z programu");
        System.out.println(ADD_BOOK + " - dodanie nowej ksiazki");
        System.out.println(PRINT_BOOKS + " - wyswietl dostepne ksiazki");
        System.out.print("Wybierz opcję: ");
    }
}
