package Emanuele_Mangano;

import Emanuele_Mangano.Entities.*;
import Emanuele_Mangano.Enums.Periodicity;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Archive archive = new Archive();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Aggiungi un elemento al catalogo");
            System.out.println("2. Rimuovi un elemento dal catalogo");
            System.out.println("3. Ricerca per ISBN");
            System.out.println("4. Ricerca per anno di pubblicazione");
            System.out.println("5. Ricerca per autore");
            System.out.println("6. Ricerca per titolo");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addItem(archive, scanner);
                    break;
                case 2:
                    removeItem(archive, scanner);
                    break;
                case 3:
                    searchByISBN(archive, scanner);
                    break;
                case 4:
                    searchByPublicationYear(archive, scanner);
                    break;
                case 5:
                    searchByAuthor(archive, scanner);
                    break;
                case 6:
                    searchByTitle(archive, scanner);
                    break;
                case 0:
                    exit = true;
                    System.out.println("Uscita...");
                    break;
                default:
                    System.out.println("Scelta non valida -> Riprova");

            }
        }
    }


    private static void addItem(Archive archive, Scanner scanner) {
        System.out.print("Inserisci il tipo di elemento: \n1. Libro\n2. Rivista ");
        int type = Integer.parseInt(scanner.nextLine());
        System.out.print("Inserisci titolo: ");
        String title = scanner.nextLine();
        System.out.print("Inserisci anno di pubblicazione: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Inserisci numero di pagine: ");
        int pages = Integer.parseInt(scanner.nextLine());
        if (type == 1) {
            System.out.print("Inserisci autore: ");
            String author = scanner.nextLine();
            System.out.print("Inserisci genere: ");
            String genre = scanner.nextLine();
            Book book = new Book( title, year, pages, author, genre);
            archive.addCatalogItem(book);
            System.out.println("Libro aggiunto con successo.");
        } else if (type == 2) {
            System.out.print("Inserisci periodicità \n1. SETTIMANALE\n2. MENSILE\n3. SEMESTRALE ");
            int period = Integer.parseInt(scanner.nextLine());
            Periodicity periodicity = Periodicity.values()[period - 1];
            Magazine magazine = new Magazine( title, year, pages, periodicity);
            archive.addCatalogItem(magazine);
            System.out.println("Rivista aggiunta con successo");
        } else {
            System.out.println("Tipo di elemento non valido");
        }
    }

    private static void removeItem(Archive archive, Scanner scanner) {
        System.out.print("Inserisci ISBN dell'elemento da rimuovere: ");
        long isbn = Long.parseLong(scanner.nextLine());
        archive.removeCatalogItem(isbn);
        System.out.println("Elemento rimosso con successo.");
    }

    private static void searchByISBN(Archive archive, Scanner scanner) {
        System.out.print("Inserisci ISBN: ");
        long isbn = Long.parseLong(scanner.nextLine());
        Catalog item = archive.searchByISBN(isbn);
        if (item != null) {
            System.out.println("Elemento trovato: " + item.getTitle());
        } else {
            System.out.println("Elemento non trovato.");
        }
    }

    private static void searchByPublicationYear(Archive archive, Scanner scanner) {
        System.out.print("Inserisci anno di pubblicazione: ");
        int year = scanner.nextInt();
        List<Catalog> items = archive.searchByPublicationYear(year);
        for (Catalog item : items) {
            System.out.println("Elemento trovato: " + item.getTitle());
        }
    }

    private static void searchByAuthor(Archive archive, Scanner scanner) {
        System.out.print("Inserisci autore: ");
        String author = scanner.nextLine();
        List<Book> books = archive.searchByAuthor(author);
        for (Book book : books) {
            System.out.println("Libro trovato: " + book.getTitle());
        }
    }

    private static void searchByTitle(Archive archive, Scanner scanner) {
        System.out.print("Inserisci titolo o parte di esso: ");
        String title = scanner.nextLine();
        List<Catalog> items = archive.searchByTitle(title);
        for (Catalog item : items) {
            System.out.println("Elemento trovato: " + item.getTitle());
        }
    }


}
