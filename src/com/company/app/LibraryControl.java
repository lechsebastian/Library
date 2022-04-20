package com.company.app;

import com.company.exception.NoSuchOptionException;
import com.company.io.ConsolePrinter;
import com.company.io.DataReader;
import com.company.model.Book;
import com.company.model.Library;
import com.company.model.Magazine;
import com.company.model.Publication;

import java.util.InputMismatchException;

class LibraryControl {

    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);
    private Library library = new Library();

    public void controlLoop(){
        Option option;

        do{
            printOptions();
            option = getOption();

            switch (option) {
                case ADD_BOOK -> addBook();
                case ADD_MAGAZINE -> addMagazine();
                case PRINT_BOOKS -> printBooks();
                case PRINT_MAGAZINES -> printMagazines();
                case EXIT -> exit();
                default -> printer.printLine("Nie ma takiej opcji! Sprobuj ponownie!");
            }
        }while(option != Option.EXIT);
    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while(!optionOk) {
            try {
                option = Option.createFromInt(dataReader.getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage());
            } catch (InputMismatchException e) {
                printer.printLine("Wprowadz wartosc, ktora jest liczba!");
            }
        }
        return option;
    }

    private void exit() {
        printer.printLine("Koniec programu!");
        dataReader.close();
    }

    private void printBooks() {
        Publication[] publications = library.getPublications();
        printer.printBooks(publications);
    }

    private void printMagazines() {
        Publication[] publications = library.getPublications();
        printer.printMagazines(publications);
    }

    private void addBook() {
        try {
            Book book = dataReader.readAndCreateBook();
            library.addBook(book);
        } catch (InputMismatchException e) {
            printer.printLine("Nie udało się utworzyć książki! Niepoprawne dane.");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine(e.getMessage());
        }
    }

    private void addMagazine() {
        try {
            Magazine magazine = dataReader.readAndCreateMagazine();
            library.addMagazine(magazine);
        } catch (InputMismatchException e) {
            printer.printLine("Nie udało się utworzyć magazynu! Niepoprawne dane.");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine(e.getMessage());
        }
    }

    private void printOptions() {
        System.out.println();
        for (Option value : Option.values()) {
            printer.printLine(value.toString());
        }
        printer.printLine("Wybierz opcję: ");
    }
}
