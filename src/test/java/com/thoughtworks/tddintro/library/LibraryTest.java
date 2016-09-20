package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.joda.time.DateTime.now;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {


    /*

        List books tests. Implement the first three tests for the Verify exercise

     */


    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {

        List<String> books = new ArrayList<>();
        PrintStream printStream = mock(PrintStream.class);
        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);
        Library library = new Library(books, printStream, dateTimeFormatter);


        String title = "Book Title";
        books.add(title);
        library.listBooks();


        // add a verify statement here that shows that the book title was printed by to the printStream
        verify(printStream).println("Book Title");
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {

        // implement me
        List<String> books = new ArrayList<>();
        PrintStream printStream = mock(PrintStream.class);
        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);
        Library library = new Library(books, printStream, dateTimeFormatter);

        library.listBooks();

        verify(printStream, times(0)).println();

    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {
        // implement me
        List<String> books = new ArrayList<>();
        PrintStream printStream = mock(PrintStream.class);
        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);
        Library library = new Library(books, printStream, dateTimeFormatter);

        String title1 = "Book Title 1";
        String title2 = "Book Title 2";
        books.add((title1));
        books.add((title2));
        library.listBooks();

        verify(printStream).println("Book Title 1");
        verify(printStream).println("Book Title 2");
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {
        List<String> books = new ArrayList<>();
        PrintStream printStream = mock(PrintStream.class);
        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);
        Library library = new Library(books, printStream, dateTimeFormatter);

        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class
        DateTime time = new DateTime();
        
        library.welcome(time);
        
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {
        List<String> books = new ArrayList<>();
        PrintStream printStream = mock(PrintStream.class);
        DateTime time = new DateTime();
        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);

        when(dateTimeFormatter.print(time)).thenReturn("");

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);

        // add a verify here
        verify(printStream).println(contains(""));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {

        // implement me
        // then move common test variables into a setup method
        List<String> books = new ArrayList<>();
        PrintStream printStream = mock(PrintStream.class);
        DateTime time = new DateTime();
        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);

        when(dateTimeFormatter.print(time)).thenReturn("5:50 PM");

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);

        verify(printStream).println(contains("5:50 PM"));
    }
}
