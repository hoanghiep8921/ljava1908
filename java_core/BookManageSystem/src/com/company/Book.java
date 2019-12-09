package com.company;

import java.util.Date;
import java.util.Scanner;

public class Book implements Comparable<Book> {
    private int id;
    private String name;
    private int year;
    private Author author;
    private String category;
    private double price;
    private static String seller = "T3H";

    public Book(int id, String name, int year, Author author, String category, double price) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.author = author;
        this.category = category;
        this.price = price;
    }

    public void inputAuthor(){
        System.out.println("Nhap thong tin tac gia quyen sach : " + this.getName());
        author = new Author("Author",new Date(),"Ha Noi",1);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ten tac gia : ");
        String nameAuthor = scanner.nextLine();
        author.setName(nameAuthor);

        System.out.println("Nhap gioi tinh tac gia :");
        int sex = scanner.nextInt();
        author.setSex(sex);
        scanner.nextLine();

        System.out.println("Nhap que quan tac gia :");
        String  address = scanner.nextLine();
        author.setAddress(address);
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static String getSeller() {
        return seller;
    }

    public static void setSeller(String seller) {
        Book.seller = seller;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", author=" + author +
                ", category=" + category +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        if(this.getPrice() > o.getPrice()){
            return 1;
        }
        if(this.getPrice() < o.getPrice()){
            return -1;
        }
        return 0;
    }
}