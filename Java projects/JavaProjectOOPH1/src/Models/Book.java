package Models;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Book {
    private String title;
    private String genre;
    private String author;
    private String publishers;
    private int yearOfIssue;
    private int isbnNumber;
    private int pageCount;
    private String language;
    private boolean available;
    private Date bookTakeDate;
    private Date bookReturnDate;
    private int periodOfTaking;
    private int timesBorrowed;
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    public Book(String title, String genre, String author, String publishers, int yearOfIssue, int isbnNumber, int pageCount, String language, boolean available, Date bookTakeDate, Date bookReturnDate, int periodOfTaking, int timesBorrowed) {
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.publishers = publishers;
        this.yearOfIssue = yearOfIssue;
        this.isbnNumber = isbnNumber;
        this.pageCount = pageCount;
        this.language = language;
        this.available = true;
        this.bookTakeDate = bookTakeDate;
        this.bookReturnDate = bookReturnDate;
        this.periodOfTaking = periodOfTaking;
        this.timesBorrowed = timesBorrowed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (this.title.length() > 100 || this.title.length() == 0){
            throw new IllegalArgumentException("Your title must be from 1 to 100 symbols!");
        }
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (this.author.length() > 50 || this.author.length() == 0){
            throw new IllegalArgumentException("Your author must be from 1 to 50 symbols!");
        }
        this.author = author;
    }

    public String getPublishers() {
        return publishers;
    }

    public void setPublishers(String publishers) {
        if (this.publishers.length() > 50 || this.publishers.length() == 0){
            throw new IllegalArgumentException("Your publishers must be from 1 to 50 symbols!");
        }
        this.publishers = publishers;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (this.yearOfIssue < 0 || this.yearOfIssue > currentYear){
            throw new IllegalArgumentException("Your year of issue must not be negative number and not in the future!");
        }
        this.yearOfIssue = yearOfIssue;
    }

    public int getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(int isbnNumber) {
        if (this.isbnNumber > 10){
            throw new IllegalArgumentException("Your ISBN number must not be more than 10 symbols!");
        }
        this.isbnNumber = isbnNumber;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        if (this.pageCount < 0 || this.pageCount == 0){
            throw new IllegalArgumentException("Your page count must not be negative number or 0!");
        }
        this.pageCount = pageCount;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Date getBookTakeDate() {
        return bookTakeDate;
    }

    public void setBookTakeDate(Date bookTakeDate) {
        this.bookTakeDate = bookTakeDate;
    }

    public Date getBookReturnDate() {
        return bookReturnDate;
    }

    public void setBookReturnDate(Date bookReturnDate) {
        this.bookReturnDate = bookReturnDate;
    }

    public int getPeriodOfTaking() {
        return periodOfTaking;
    }

    public void setPeriodOfTaking(int periodOfTaking) {
        this.periodOfTaking = periodOfTaking;
    }

    public int getTimesBorrowed() {
        return timesBorrowed;
    }

    public void setTimesBorrowed(int timesBorrowed) {
        if (this.timesBorrowed < 0 || this.timesBorrowed == 0){
            throw new IllegalArgumentException("Your times borrowed book must not be negative number or 0!");
        }
        this.timesBorrowed = timesBorrowed;
    }

    public String bookInfo() {
        return String.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s",
                title, genre, author, publishers, yearOfIssue, isbnNumber, pageCount, language,
                available ? "Да" : "Не",
                bookTakeDate != null ? sdf.format(bookTakeDate) : "-",
                bookReturnDate != null ? sdf.format(bookReturnDate) : "-");
    }
}
