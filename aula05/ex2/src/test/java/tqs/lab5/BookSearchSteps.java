package tqs.lab5;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static io.cucumber.messages.internal.com.google.common.base.Predicates.equalTo;


public class BookSearchSteps {
    Library library = new Library();
    List<Book> result = new ArrayList<>();

    @ParameterType("([0-9]{4})-([0-9]{2})-([0-9]{2})")
    public LocalDateTime iso8601Date(String year, String month, String day){
        return LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day),0, 0);
    }

    @Given("a book with the title {string}, written by {string} published in {int} March {int}")
    public void addNewBook(final String title, final String author,final int day, final int year){
        Book book = new Book (title, author, iso8601Date(String.valueOf(year),"03",String.valueOf(day)));
        library.addBook(book);
    }

    @Given("another book with the title {string}, written by {string} published in {int} August {int}")
    public void addNewBookAugust(final String title, final String author,final int day, final int year){
        Book book = new Book (title, author, iso8601Date(String.valueOf(year),"08",String.valueOf(day)));
        library.addBook(book);
    }

    @Given("another book with the title {string}, written by {string} published in {int} January")
    public void addNewBookJanuary(final String title, final String author,final int day){
        Book book = new Book (title, author, iso8601Date(String.valueOf(2000),"01",String.valueOf(day)));
        library.addBook(book);
    }

    @When("the customer searches for books published between {int} and {int}")
    public void setSearchParameters(final int from, final int to){
        result = library.findBooks(iso8601Date(String.valueOf(from),"01","01"), iso8601Date(String.valueOf(to), "12", "31"));
    }

    @Then("{int} books should have been found")
    public void verifyAmountOfBooksFound(final int booksFound){
        System.out.println(result.size());
        System.out.println(booksFound);
        assertThat(String.valueOf(result.size()), Boolean.valueOf(String.valueOf(equalTo(booksFound))));

    }

    @Then("Book {int} should have the title {string}")
    public void verifyBookAtPosition(final int position, final String title){
        assertThat(result.get(position-1).getTitle(), Boolean.valueOf(String.valueOf(equalTo(title))));
    }
}
