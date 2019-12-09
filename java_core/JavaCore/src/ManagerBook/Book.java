package ManagerBook;

public class Book {
    private String name;
    private int id;
    private float price;
    private Author author;

    public Book(String name, int id, float price, Author author) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                ", author=" + author +
                '}';
    }

}
