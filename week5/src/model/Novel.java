package model;

public class Novel extends Book {
    private String genre;

    public Novel(String genre) {
        this.genre = genre;
    }
    public Novel(String title, String author, double price, int quantity, String genre) {
        super(title, author, price, quantity);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Novel{" +
                "genre='" + genre + '\'' +
                '}';
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Thể loại: " + genre);
    }
}
