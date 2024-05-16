import java.util.*;

public class Library {
    private Map<String, List<Book>> library;

    public Library() {
        library = new HashMap<>();
    }

    public void addBook(String field, Book book) {
        library.computeIfAbsent(field, k -> new ArrayList<>()).add(book);
    }



    public void removeBook(String field, String author, String title, int year) {

        List<Book> books = library.get(field);
        if (books != null) {

            books.removeIf(book -> book.getTitle().equals(title) && book.getYear() == year && book.getAuthor().equals(author));
            if (books.isEmpty()) {
                library.remove(field);
            }
        }
    }

    public void displayLibraryABC() {
        System.out.println("Содержимое научной библиотеки в алфавитном порядке:");

        // Собираем все книги из всех направлений в один список
        List<Book> allBooks = new ArrayList<>();
        library.values().forEach(allBooks::addAll);

        // Сортируем список книг по названию
        Collections.sort(allBooks, Comparator.comparing(Book::getTitle));

        // Выводим отсортированные книги
        allBooks.forEach(book -> System.out.println("\t" + book));
    }

    public void displayLibrary() {
        System.out.println("Содержимое научной библиотеки:");
        library.forEach((field, books) -> {

            System.out.println("Направление: " + field);
            books.forEach(book -> System.out.println("\t" + book));
        });
    }
}
