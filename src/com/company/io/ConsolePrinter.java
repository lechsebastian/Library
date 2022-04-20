package com.company.io;

import com.company.model.Book;
import com.company.model.Magazine;
import com.company.model.Publication;

public class ConsolePrinter {
    public void printBooks(Publication[] publications){
        int countBooks = 0;
        for (Publication publication : publications) {
            if (publication instanceof Book) {
                System.out.println(publication);
                countBooks++;
            }
        }
        if(countBooks == 0)
            printLine("Brak ksiazek w bibliotece!");
    }

    public void printMagazines(Publication[] publications){
        int countMagazines = 0;
        for (Publication publication : publications) {
            if(publication instanceof Magazine) {
                System.out.println(publication);
                countMagazines++;
            }
        }
        if(countMagazines == 0)
            printLine("Brak magazynow w bibliotece!");
    }

    public void printLine(String text) {
        System.out.println(text);
    }
}
