package com.company.app;

import com.company.exception.NoSuchOptionException;

public enum Option {
    EXIT(0, " - wyjscie z programu"),
    ADD_BOOK(1, " - dodanie nowej ksiazki"),
    ADD_MAGAZINE(2, " - dodanie nowego magazynu"),
    PRINT_BOOKS(3, " - wyswietl dostepne ksiazki"),
    PRINT_MAGAZINES(4, " - wyswietl dostepne magazyny");

    private final int value;
    private final String description;

    Option(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return value + description;
    }

    static Option createFromInt(int option) throws NoSuchOptionException {
        try {
            return Option.values()[option]; //Zamiast switch mozna uzyc takiego zapisu, bo opcje sa numerowane jak tablica
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchOptionException("Brak opcji o id = " + option);
        }
    }
}
