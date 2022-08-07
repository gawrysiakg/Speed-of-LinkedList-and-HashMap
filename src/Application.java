import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class Application {
    public static void main (String[] args) throws java.lang.Exception {

        LinkedList<Book> bookList = new LinkedList<Book>();
        Map<Book, String> bookMap = new HashMap<Book, String>();

        for(int i = 0; i<500000; i++) {
            String author;
            String title;
            String bookNumber;

            author = ("Author" + (i+1));
            title = ("Title" + (i+1));
            bookNumber = ("Book number " + (i+1) );

            bookList.add(new Book(author, title));

            bookMap.put(new Book(author, title), bookNumber);
        }
        System.out.println("Liczba elementów w kolekcji LinkedList: " + bookList.size());

        long beginGetFirstLL = System.nanoTime();
        Book first = bookList.get(0);
        long endGetFirstLL = System.nanoTime();
        System.out.println("Wyszukanie elementu "+first+" z początku kolekcji LinkedList zajęło "+(endGetFirstLL-beginGetFirstLL)+ " ms.");

        long beginRemoveFirstLL = System.nanoTime();
        Book first2 = bookList.remove(0);
        long endRemovefirstLL = System.nanoTime();
        System.out.println("Usunięcie elementu "+first2+" z początku kolekcji LinkedList zajęło "+(endRemovefirstLL-beginRemoveFirstLL)+ " ms.");

        long beginGetLastLL = System.nanoTime();
        Book last = bookList.get(bookList.size()-1);
        long endGetLastLL = System.nanoTime();
        System.out.println("Wyszukanie elementu "+last+" z końca kolekcji LinkedList zajęło "+(endGetLastLL-beginGetLastLL)+ " ms.");

        long beginRemoveLastLL = System.nanoTime();
        Book deleted = bookList.remove(bookList.size()-1);
        long endRemoveLastLL = System.nanoTime();
        System.out.println("Usunięcie elementu "+ deleted+" z końca kolekcji LinkedList zajęło "+(endRemoveLastLL-beginRemoveLastLL)+ " ms.");

        long beginInsertFirstLL = System.nanoTime();
        bookList.add(0, new Book("Inserted first author", "Inserted first title"));
        long endInsertFirstLL = System.nanoTime();
        System.out.println("Wstawienie elementu na początku kolekcji LinkedList zajęło "+(endInsertFirstLL-beginInsertFirstLL)+ " ms.");

        long beginInsertLastLL = System.nanoTime();
        bookList.add(new Book("Inserted last author", "Inserted last title"));
        long endInsertLastLL = System.nanoTime();
        System.out.println("Wstawienie elementu na końcu kolekcji LinkedList zajęło "+(endInsertLastLL-beginInsertLastLL)+ " ms.");
        // HashMap
        System.out.println("\nHash Map");
        System.out.println("Liczba elementów w kolekcji HashMap: " + bookMap.size());

        long beginGetFirstHM = System.nanoTime();
        String firstHM = "Author1";
        Book key = null;
        String value = null;
        Iterator<Map.Entry<Book, String> > iterator1 = bookMap.entrySet().iterator();
        while (iterator1.hasNext()) {
            Map.Entry<Book, String> entry = iterator1.next();
            if (firstHM.equals( entry.getKey().getAuthor())) {
                System.out.println("Pobieram z Mapy: "+entry.getKey());
                key = entry.getKey();
                value = entry.getValue();
            }
        }
        long endGetFirstHM = System.nanoTime();
        System.out.println( "Wyszukanie klucza "+ key+", oraz wartości "+value +" z początku kolekcji Hash Map zajęło "+(endGetFirstHM-beginGetFirstHM)+ " ms.");

        long beginPutHM = System.nanoTime();
        bookMap.put(new Book("AuthorAdded", "TitleAdded"), "Added Book");
        long endPutHM = System.nanoTime();
        System.out.println("Dodanie elementu do kolekcji Hash Map zajęło "+(endPutHM-beginPutHM)+ " ms.");
        System.out.println("Liczba elementów w kolekcji HashMap: " + bookMap.size());


        long beginRemoveHM = System.nanoTime();

        String keyToBeRemoved = "Author129772";
        Iterator<Map.Entry<Book, String> >
                iterator = bookMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Book, String> entry = iterator.next();
            if (keyToBeRemoved.equals( entry.getKey().getAuthor())) {
                System.out.println("Usuwam "+entry.getKey());
                iterator.remove();
            }
        }
        long endRemoveHM = System.nanoTime();
        System.out.println("Usuwanie elementu z kolekcji Hash Map zajęło "+(endRemoveHM-beginRemoveHM)+ " milisekund.");

        System.out.println("Liczba elementów w kolekcji HashMap: " + bookMap.size());


    }
}
