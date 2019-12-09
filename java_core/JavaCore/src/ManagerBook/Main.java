package ManagerBook;

public class Main {
    public static void main(String[] args) {
        T3hBookStore store = new T3hBookStore();
        Author namCao = new Author("Nam Cao",78,"Việt Nam");
        Book book1 = new Book("Lão Hạc",1,100000.00f,namCao);
        Book book2 = new Book("Tắt đèn",2,200000.00f,
                new Author("Ngô Tất Tố",80,"Hà nội"));
        Book book3 = new Book("Truyện Kiều",3,5000000.00f,
                new Author("Nguyễn Du",100,"Thanh Hóa"));
        Book book4 = new Book("Chí Phèo",4,500000.00f,namCao);
        store.addBook(book1);
        store.addBook(book2);
        store.addBook(book3);
        store.addBook(book4);

        store.printListsBook();

    }
}
