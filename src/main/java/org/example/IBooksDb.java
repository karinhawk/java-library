package org.example;

public interface IBooksDb {

    void readBook(String bookName);

    void writeBook(Book book);

}

//
//public class CsvDB implements IBooksDb {
//
//    @Override
//    public void readBook(String bookName) {
//
//    }
//
//    @Override
//    public void writeBook(Book book) {
//
//    }
//}
//
//public class JsonDB implements IBooksDb {
//
//    @Override
//    public void readBook(String bookName) {
//        // Use gSon to read a book from a file
//    }
//
//    @Override
//    public void writeBook(Book book) {
//        // use gSon to write a book to the file
//    }
//}
