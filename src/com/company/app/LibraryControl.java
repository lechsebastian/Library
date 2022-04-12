package com.company.app;

import com.company.io.DataReader;
import com.company.model.Book;
import com.company.model.Library;
import com.company.model.Magazine;

class LibraryControl {

    private DataReader dataReader = new DataReader();
    private Library library = new Library();

    public void controlLoop(){
        Option option;

        do{
            printOptions();
            option = Option.createFromInt(dataReader.getInt());

            switch (option) {
                case ADD_BOOK -> addBook();
                case ADD_MAGAZINE -> addMagazine();
                case PRINT_BOOKS -> printBooks();
                case PRINT_MAGAZINES -> printMagazines();
                case EXIT -> exit();
                default -> System.out.println("Nie ma takiej opcji! Sprobuj ponownie!");
            }
        }while(option != Option.EXIT);
    }

    private void exit() {
        System.out.println("Koniec programu!");
        dataReader.close();
    }

    private void printBooks() {
        library.printBooks();
    }

    private void printMagazines() {
        library.printMagazines();
    }

    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }

    private void addMagazine() {
        Magazine magazine = dataReader.readAndCreateMagazine();
        library.addMagazine(magazine);
    }

    private void printOptions() {
        System.out.println();
        for (Option value : Option.values()) {
            System.out.println(value);
        }
        System.out.print("Wybierz opcję: ");
    }
}
