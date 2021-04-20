package tqs.lab5;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private final List<Book> store = new ArrayList<>();

    public void addBook(final Book book){
        store.add(book);
    }

    public List<Book> findBooks(final LocalDateTime from, final LocalDateTime to){
        Calendar end = Calendar.getInstance();
        Date date = Date.from(from.atZone(ZoneId.systemDefault()).toInstant());
        end.setTime(date);
        end.roll(Calendar.YEAR, 1);

        return store.stream().filter(book -> {
            return Date.from(from.atZone(ZoneId.systemDefault()).toInstant()).before(Date.from(book.getPublished().atZone(ZoneId.systemDefault()).toInstant())) && end.getTime().after(Date.from(book.getPublished().atZone(ZoneId.systemDefault()).toInstant()));})
            .sorted(Comparator.comparing(Book::getPublished).reversed()).collect(Collectors.toList());
    }
}