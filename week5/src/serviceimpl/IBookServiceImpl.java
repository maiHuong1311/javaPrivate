package serviceimpl;

import constant.Common;
import constant.ErrorMessage;
import constant.SuccessfulMessage;
import model.Book;
import model.Novel;
import model.TextBook;
import service.IBookService;
import main.Main;

import java.util.ArrayList;
import java.util.List;

public class IBookServiceImpl implements IBookService {
    public boolean isValidBook(Book book) {
        return !book.getAuthor().isEmpty() && !book.getTitle().isEmpty() && !(book.getPrice() <= 0) && book.getQuantity() > 0;
    }

    public void addBook(Book book) {
        if(!isValidBook(book))
            System.out.println(ErrorMessage.INVALID_BOOK);
        else {
            Main.books.add(book);
            System.out.println(SuccessfulMessage.SUCCESS_ADD);
        }
    }

    @Override
    public void getBookId(String id) {
        boolean found = false;
        for(Book book : Main.books) {
            if(id.equals(book.getId())) {
                System.out.println(Common.INFO_BOOK);
                book.displayInfo();
                found = true;
            }
        }
        if(!found)
            System.out.println(ErrorMessage.NOT_FOUND_BOOK);
    }

    @Override
    public List<Book> getBookByCategory(Object category) {
        List<Book> result = new ArrayList<>();
        boolean valid = true;
        for(Book book : Main.books) {
            switch(((String) category).toLowerCase()) {
                case "textbook":
                    if(book instanceof TextBook)
                        result.add(book);
                    break;
                case "novel":
                    if(book instanceof Novel)
                        result.add(book);
                    break;
                default:
                    valid = false;
            }
        }
        if(!valid)
            System.out.println(ErrorMessage.INVALID_CATEGORY);
        return result;
    }

    @Override
    public void deleteBookById(String id) {
        boolean found = false;
        for(int i = 0; i < Main.books.size(); i++) {
            if(id.equals(Main.books.get(i).getId())) {
                Main.books.remove(i);
                found = true;
                System.out.println(SuccessfulMessage.SUCCESS_DELETE);
            }
        }
        if(!found) {
            System.out.println(ErrorMessage.FAILED_DELETE);
        }
    }

    @Override
    public void getAllBooks() {
        if(Main.books.isEmpty())
            System.out.println(ErrorMessage.LIST_IS_EMPTY);
        else {
            System.out.println(Common.INFO_BOOK);
            for(Book book : Main.books) {
                book.displayInfo();
            }
        }
    }

    @Override
    public double caculateTotalValue() {
        double total = 0;
        for(Book book : Main.books) {
            total += book.getQuantity() * book.getPrice();
        }
        return total;
    }
}
