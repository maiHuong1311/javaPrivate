package main;

import constant.Common;
import constant.ErrorMessage;
import model.Book;
import model.Novel;
import model.TextBook;
import serviceimpl.IBookServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static ArrayList<Book> books = new ArrayList<>();
    public static void main(String[] args) {
        IBookServiceImpl service = new IBookServiceImpl();
        Scanner sc = new Scanner(System.in);
        books.add(new TextBook("Giải tích", "Nguyễn Văn An", 25500, 100, "Toán"));
        books.add(new TextBook("Đại số tuyến tính", "Trần Ngọc Bình", 22500, 50, "Toán"));
        books.add(new Novel("Tôi thấy hoa vàng trên cỏ xanh", "Nguyễn Nhật Ánh", 50000, 60, "Học đường"));
        books.add(new Novel("Chiếc thuyền ngoài xa", "Nguyễn Minh Châu", 55000, 20, "Tâm lý, hiện thực"));
        System.out.println(Common.MENU);
        while(true) {
            System.out.print(Common.ENTER_CHOICE);
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice) {
                case 1:
                    System.out.print(Common.ENTER_TYPE);
                    String type = sc.nextLine();
                    if(!type.equalsIgnoreCase("TextBook") && !type.equalsIgnoreCase("Novel")) {
                        System.out.println(ErrorMessage.INVALID_TYPE);
                    }
                    else {
                        System.out.print(Common.ENTER_TITLE);
                        String title = sc.nextLine();
                        System.out.print(Common.ENTER_AUTHOR);
                        String author = sc.nextLine();
                        System.out.print(Common.ENTER_PRICE);
                        double price = sc.nextDouble();
                        System.out.print(Common.ENTER_QUANTITY);
                        int quantity = sc.nextInt();
                        sc.nextLine();
                        switch(type.toLowerCase()) {
                            case "textbook":
                                System.out.print(Common.ENTER_SUBJECT);
                                String subject = sc.nextLine();
                                TextBook textBook = new TextBook(title, author, price, quantity, subject);
                                service.addBook(textBook);
                                break;
                            case "novel":
                                System.out.print(Common.ENTER_GENRE);
                                String genre = sc.nextLine();
                                Novel novel = new Novel(title, author, price, quantity, genre);
                                service.addBook(novel);
                                break;
                        }
                    }
                    break;
                case 2:
                    System.out.print(Common.ENTER_ID);
                    String id = sc.nextLine();
                    service.getBookId(id);
                    break;
                case 3:
                    System.out.print(Common.ENTER_TYPE);
                    String typeFilter = sc.nextLine();
                    System.out.println(Common.INFO_BOOK);
                    List<Book> result = service.getBookByCategory(typeFilter);
                    for(Book book : result) {
                        book.displayInfo();
                    }
                    break;
                case 4:
                    System.out.print(Common.ENTER_ID);
                    String idDelete = sc.nextLine();
                    service.deleteBookById(idDelete);
                    break;
                case 5:
                    service.getAllBooks();
                    break;
                case 6:
                    System.out.println(Common.TOTAL + service.caculateTotalValue());
                    break;
                case 7:
                    return;
                default:
                    System.out.print(ErrorMessage.INVALID_CHOICE);
                    break;
            }
        }
    }
}