package service;

import model.Book;

import java.util.List;

public interface IBookService {
    void addBook(Book book);
    void getBookId(String id);
    List<Book> getBookByCategory(Object category);
    void deleteBookById(String id);
    void getAllBooks();
    double caculateTotalValue();
}
