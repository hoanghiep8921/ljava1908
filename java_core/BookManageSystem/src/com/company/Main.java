package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MyBook myBook;

    // Ctr +Shift+F
    public static void main(String[] args) {
        myBook = new MyBook("Shop sach JVeverReturn");
        System.out.println("Chuong trinh quan ly cua hang sach cua " + myBook.getName());
        printMenuChoice();

        boolean flag = true;

        while (flag) {
            System.out.println("Nhap su lua chon");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("In ra huong dan");
                    printMenuChoice();
                    break;
                case 1:
                    displayAllBooks();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    modifyBook();
                    break;
                case 4:
                    deleleBook();
                    break;
                case 5:
                    searchBook();
                    break;
                case 6:
                {
                    System.out.print("Nhap vao thu hang can tim kiem: ");
                    int thuHang = scanner.nextInt();
                    timKiemGiaTien(thuHang);
                    break;
                }
                case 7:
                    System.out.println("Thoat chuong trinh");
                    flag = false;
                    break;

            }

        }
        System.out.println("Chuong trinh ket thuc");
    }

    // Hien thi list book
    public static void displayAllBooks() {
        myBook.displayAllBooks();
    }

    // Them sinh vien
    public static void addBook() {
        System.out.println("Nhap so luong sach muon them");
        int num = scanner.nextInt();
        scanner.nextLine();

        for(int i=0;i<num;i++){
            Book book = new Book();
            System.out.println("Them quyen sach thu : "+ (i+1));

            System.out.println("Nhap ten quyen sach");
            String name = scanner.nextLine();
            book.setName(name);

            System.out.println("Nhap ten the loai");
            String category = scanner.nextLine();
            book.setCategory(category);

            System.out.println("Nhap gia quyen sach");
            int price = scanner.nextInt();
            book.setPrice(price);
            scanner.nextLine();

            System.out.println("Nhap ma quyen sach");
            int id = scanner.nextInt();
            book.setId(id);
            scanner.nextLine();

            System.out.println("Nhap nam xuat ban");
            int year = scanner.nextInt();
            book.setYear(year);
            scanner.nextLine();

            book.inputAuthor();
            myBook.addBook(book);
        }
    }

    // Sua thong tin sach
    public static void modifyBook() {
        System.out.println("Chuc nang sua ten sach");
        System.out.println("Nhap vi tri quyen sach muon sua");
        int index = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Book> bookList = myBook.getBookArrayList();
        Book book = bookList.get(index);
        System.out.println("Nhap ten moi muon sua");
        String newBookName = scanner.nextLine();
        book.setName(newBookName);
        myBook.editBook(index, book);
    }

    // Xoa sach
    public static void deleleBook() {
        System.out.println("Chuc nang xoa sach");
        System.out.println("Nhap vao ten quyen sach muon xoa");
        String bookName = scanner.nextLine();
        myBook.deleteBook(bookName);
    }

    public static void searchBook() {
        System.out.print("Nhap vao ten can tim kiem: ");
        String name = new Scanner(System.in).nextLine();
        Book book = myBook.searchBook(name);
        if (book == null) {
            System.out.println("Khong tim thay sach");
        } else {
            System.out.println(book);
        }
    }

    public static void printMenuChoice() {
        System.out.println("Vui long chon 1 trong cac chuc nang");
        System.out.println("0. In ra huong dan");
        System.out.println("1. In ra danh sach toan bo quyen sach");
        System.out.println("2. Them sach");
        System.out.println("3. Sua sach");
        System.out.println("4. Xoa sach");
        System.out.println("5. Tim kiem sach");
        System.out.println("6. Tim kiem theo top gia tien");
        System.out.println("7. Thoat chuong trinh");
    }

    public static void sapXepTheoGia() {
        Comparator<Book> comparator = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                // TODO Auto-generated method stub
                if (o1.getPrice() < o2.getPrice()) {
                    return 1;
                } else if (o1.getPrice() == o2.getPrice()) {
                    return 0;
                }
                return -1;
            }
        };
        Collections.sort(myBook.getBookArrayList(), comparator);
    }

    public static void timKiemGiaTien(int thuHang) {
        sapXepTheoGia();
        System.out.println("Thong tin sach co thu hang " + thuHang + " :");
        //myclass.getBookList().get(thuHang - 1).toString();
        System.out.println(myBook.getBookArrayList().get(thuHang-1));;
    }
}
