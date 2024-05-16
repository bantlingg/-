import java.util.*;

public class Main {
    public static void main(String[] args) {
        Library sciLibrary = new Library();
        Scanner scanner = new Scanner(System.in); // Удалено лишнее объявление scanner

        sciLibrary.addBook("Математика", new Book("Новоселов Д.Н.", "Теория игр", 2020));
        sciLibrary.addBook("Физика", new Book("Романов Н.С.", "Физика том 2", 2018));
        sciLibrary.addBook("Информатика", new Book("Соснин С.Д.", "C++ для чайников", 2019));
        sciLibrary.addBook("Физика", new Book("Романов Н.С", "Физика том 1", 2022));

        sciLibrary.displayLibrary();

        sciLibrary.removeBook("Математика","Новоселов Д.Н.", "Теория игр", 2020);

        sciLibrary.displayLibrary();

        sciLibrary.displayLibraryABC();


        String a;
        boolean b=true;
        while ( b) {
            System.out.println("Выберите действие:");
            System.out.println("1. Показать библиотеку");
            System.out.println("2. Показать библиотеку в алфавитном порядке");
            System.out.println("3. Добавить книгу");
            System.out.println("4. Удалить книгу");
            System.out.println("5. Выход");


            a = scanner.nextLine();

            switch (a) {
                case "1":
                    sciLibrary.displayLibrary();
                    break;
                case "2":
                    sciLibrary.displayLibraryABC();
                    break;
                case "3":
                    System.out.println("Введите данные книги (автор, название, год):");
                    String author = scanner.nextLine();
                    String title = scanner.nextLine();
                    int year = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Введите направление книги:");
                    String field = scanner.nextLine();

                    sciLibrary.addBook(field, new Book(author, title, year));

                    System.out.println("Книга успешно добавлена в библиотеку.");
                    break;
                case "4":
                    System.out.println("Введите данные книги (автор, название, год):");
                     author = scanner.nextLine();
                     title = scanner.nextLine();
                     year = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Введите направление книги:");
                     field = scanner.nextLine();

                    sciLibrary.removeBook(field,author, title, year);

                    System.out.println("Книга успешно добавлена в библиотеку.");
                    break;
                case "5":
                    b=false;
                    break;
                default:
                    System.out.println("Введите заново.");
                    break;
            }
        }
    }
}
