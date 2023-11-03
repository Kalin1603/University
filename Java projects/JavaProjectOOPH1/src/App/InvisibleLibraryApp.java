package App;

import Models.Book;
import Models.Library;

import java.util.List;
import java.util.Scanner;

public class InvisibleLibraryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = createLibrary(scanner);

        while (true) {
            displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Book book = createBook(scanner);
                    library.addBook(book);
                    break;
                case 2:
                    System.out.print("Enter the ISBN of the book to remove: ");
                    int isbn = scanner.nextInt();
                    scanner.nextLine();
                    library.removeBookByISBN(isbn);
                    break;
                case 3:
                    System.out.print("Enter search term: ");
                    String searchTerm = scanner.nextLine();

                    System.out.print("Enter search type (title/author/year/isbn): ");
                    String searchType = scanner.nextLine();

                    List<Book> searchResults = library.searchBooks(searchTerm, searchType);

                    if (!searchResults.isEmpty()) {
                        System.out.println("Search results:");
                        for (Book newbook : searchResults) {
                            System.out.println(newbook.bookInfo());
                        }
                    } else {
                        System.out.println("No books found for the given criteria.");
                    }
                    break;
                case 4:
                    System.out.print("Enter the ISBN of the book to update: ");
                    int isbnToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    library.updateBookInfoByISBN(isbnToUpdate, scanner);
                    break;
                case 5:
                    library.printBookList();
                    break;
                case 6:
                    // Изход
                    System.out.println("Thanks for using the system. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please, enter valid choice.");
            }
        }
    }

    private static Library createLibrary(Scanner scanner) {
        System.out.println("Hello, please enter library information!");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        int employeesCount;
        do {
            System.out.print("Enter employees: ");
            employeesCount = scanner.nextInt();
            if (employeesCount <= 0 || employeesCount >= 10) {
                System.out.println("Employees must be more than 0 and less than 10. Try again!");
            }
        } while (employeesCount <= 0 || employeesCount >= 10);

        return new Library(name, address, employeesCount);
    }

    private static Book createBook(Scanner scanner){
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter publishers: ");
        String publishers = scanner.nextLine();
        System.out.print("Enter ISBN number: ");
        int ISBN = scanner.nextInt();
        System.out.print("Enter pageCount: ");
        int pageCount = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter language: ");
        String language = scanner.nextLine();
        System.out.print("Enter year of issue: ");
        int yearOfIssue = scanner.nextInt();
        scanner.nextLine();

        Book newBook = new Book(title, genre, author, publishers, yearOfIssue, ISBN, pageCount, language, true, null, null, 0, 0);
        return newBook;
    }

    private static void displayMainMenu() {
        System.out.println("Main menu:");
        System.out.println("1. Add book");
        System.out.println("2. Remove book");
        System.out.println("3. Search book");
        System.out.println("4. Update book");
        System.out.println("5. List of books");
        System.out.println("6. Exit");
        System.out.print("Choose option: ");
    }
}
