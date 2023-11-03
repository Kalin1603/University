package Models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Library {
    private String name;
    private String address;
    private int employeesCount;
    private List<Book> availableBooks;

    public Library(String name, String address, int employeesCount) {
        this.name = name;
        this.address = address;
        this.employeesCount = employeesCount;
        this.availableBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (this.name.length() > 100 || this.name.length() == 0){
            throw new IllegalArgumentException("Your name must be from 1 to 100 symbols!");
        }
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (this.address.length() > 500 || this.name.length() == 0){
            throw new IllegalArgumentException("Your address must be from 1 to 100 symbols!");
        }
        this.address = address;
    }

    public int getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(int employeesCount) {
        if (this.employeesCount >= 50 || this.employeesCount == 0){
            throw new IllegalArgumentException("Your employees number must be between 1 to 49!");
        }
        this.employeesCount = employeesCount;
    }

    public List<Book> getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(List<Book> availableBooks) {
        this.availableBooks = availableBooks;
    }

    public void addBook(Book book) {
        availableBooks.add(book);
    }

    public void removeBook(Book book) {
        availableBooks.remove(book);
    }

    public void removeBookByTitle(String title) {
        String lowerCaseTitle = title.toLowerCase();

        for (Book book : availableBooks) {
            String bookTitle = book.getTitle().toLowerCase();

            if (bookTitle.equals(lowerCaseTitle)) {
                availableBooks.remove(book);
                System.out.println("Book with title \"" + book.getTitle() + "\" is removed.");
            }
        }
        System.out.println("Book with title \"" + title + "\" is not found.");
    }

    public void removeBookByISBN(int isbn) {
        for (Book book : availableBooks) {
            if (book.getIsbnNumber() == isbn) {
                availableBooks.remove(book);
                System.out.println("Book with ISBN number \"" + book.getIsbnNumber() + "\" is removed.");
                return;
            }
        }
        System.out.println("Book with ISBN number \"" + isbn + "\" is not found.");
    }

    public List<Book> searchBooks(String searchTerm, String searchType) {
        List<Book> results = new ArrayList<>();

        for (Book book : availableBooks) {
            String bookInfo = "";

            switch (searchType) {
                case "title":
                    bookInfo = book.getTitle().toLowerCase();
                    break;
                case "author":
                    bookInfo = book.getAuthor().toLowerCase();
                    break;
                case "year":
                    bookInfo = String.valueOf(book.getYearOfIssue());
                    break;
                case "isbn":
                    bookInfo = String.valueOf(book.getIsbnNumber());
                    break;
            }

            if (bookInfo.contains(searchTerm.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    public void updateBookInfoByISBN(int isbn, Scanner scanner) {
        Book bookToUpdate = null;
        for (Book book : availableBooks) {
            if (book.getIsbnNumber() == isbn) {
                bookToUpdate = book;
                break;
            }
        }

        if (bookToUpdate == null) {
            System.out.println("Book with ISBN number " + isbn + " is not found.");
            return;
        }

        System.out.println("Update book with ISBN number: " + isbn);
        displayUpdateMenu();
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                updateAvailability(bookToUpdate, scanner);
                break;
            case 2:
                updateBookTakeDate(bookToUpdate, scanner);
                break;
            case 3:
                updateBookReturnDate(bookToUpdate, scanner);
                break;
            case 4:
                updatePeriodOfTaking(bookToUpdate, scanner);
                break;
            case 5:
                updateTimesBorrowed(bookToUpdate, scanner);
                break;
            default:
                System.out.println("Please, enter valid choice.");
        }
    }

    private void displayUpdateMenu() {
        System.out.println("Моля изберете какво искате да обновите:");
        System.out.println("1. Наличност");
        System.out.println("2. Дата, на която е взета книгата");
        System.out.println("3. Дата, на която трябва да се върне книгата");
        System.out.println("4. Период на вземане");
        System.out.println("5. Колко пъти книгата е взимана от библиотеката");
        System.out.print("Избор: ");
    }

    private void updateAvailability(Book book, Scanner scanner) {
        System.out.print("Enter available (true/false): ");
        boolean availability = scanner.nextBoolean();
        book.setAvailable(availability);
        System.out.println("Availability of the book updated successfully.");
    }

    private void updateBookTakeDate(Book book, Scanner scanner) {
        System.out.print("Please, enter new date of taking the book (yyyy-MM-dd): ");
        String newDateStr = scanner.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date newDate = sdf.parse(newDateStr);
            book.setBookTakeDate(newDate);
            System.out.println("Successfully updated date of taking the book.");
        } catch (ParseException e) {
            System.out.println("Not valid data format. Please enter yyyy-MM-dd.");
        }
    }

    private void updateBookReturnDate(Book book, Scanner scanner) {
        System.out.print("Please, enter new date of returning the book (yyyy-MM-dd): ");
        String newReturnDateStr = scanner.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date newReturnDate = sdf.parse(newReturnDateStr);
            book.setBookReturnDate(newReturnDate);
            System.out.println("Successfully updated date of returning the book.");
        } catch (ParseException e) {
            System.out.println("Not valid data format. Please enter yyyy-MM-dd.");
        }
    }

    private void updatePeriodOfTaking(Book book, Scanner scanner) {
        System.out.print("Enter new period of taking: ");
        int newPeriod = scanner.nextInt();

        if (newPeriod > 0) {
            book.setPeriodOfTaking(newPeriod);
            System.out.println("Successfully updated period of taking.");
        } else {
            System.out.println("Invalid period. The period must be more than 0.");
        }
    }

    private void updateTimesBorrowed(Book book, Scanner scanner) {
        System.out.print("Enter new period of taking: ");
        int newTimesBorrowed = scanner.nextInt();

        if (newTimesBorrowed >= 0) {
            book.setTimesBorrowed(newTimesBorrowed);
            System.out.println("Successfully updated times borrowed.");
        } else {
            System.out.println("Invalid. The times borrowed must be positive number.");
        }
    }

    public void printBookList() {
        System.out.println("Пълен списък с книги в библиотеката:");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s%n",
                "Заглавие", "Жанр", "Автор", "Издателство", "Година на издаване", "ISBN", "Брой страници",
                "Език", "Наличност", "Дата на вземане", "Дата на връщане");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        for (Book book : availableBooks) {
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s%n",
                    book.getTitle(), book.getGenre(), book.getAuthor(), book.getPublishers(),
                    book.getYearOfIssue(), book.getIsbnNumber(), book.getPageCount(),
                    book.getLanguage(), book.isAvailable() ? "Да" : "Не",
                    book.getBookTakeDate() != null ? sdf.format(book.getBookTakeDate()) : "-",
                    book.getBookReturnDate() != null ? sdf.format(book.getBookReturnDate()) : "-");
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
