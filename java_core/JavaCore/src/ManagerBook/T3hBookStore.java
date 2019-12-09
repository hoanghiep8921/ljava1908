package ManagerBook;

import java.util.ArrayList;
import java.util.List;

public class T3hBookStore {
    private static String name = " T3h Book Store";
    private List<Book> bookList ;

    //thêm sách vào kho
    public List<Book> addBook(Book book){
        this.bookList.add(book);
        return this.bookList;
    }

    //TÌm kiếm sách theo tên tác giả
    public List<Book> findBookByAuthor(String nameAuthor){
        List<Book> listSearch = new ArrayList<>();
        for(Book b : this.bookList){
            if(b.getAuthor().equals(nameAuthor)){
                listSearch.add(b);
            }
        }
        return listSearch;
    }


    public void printListsBook(){
        for(Book b : this.bookList){
            System.out.println(b.toString());
        }
    }


}
