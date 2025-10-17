public class Rack {
    Shelf[] shelves;

    public Shelf[] getShelves() {
        return shelves;
    }

    Shelf getShelf(int index) { //конкретная полка
        return shelves[index];
    }

    public Rack(Shelf[] shelves) {
        this.shelves = shelves;
    }

    int totalBooks() {
        int total = 0;
        for (int i = 0; i < shelves.length; i++) {
            if (shelves[i] != null) {
                Book[] books = shelves[i].getBooks(); // получить кол-во книг на полке
                if (books != null) {
                    total += books.length;
                }
            }
        }
        return total;
    }
    int findFirstByTitle(String title) {
        for (int i = 0; i < shelves.length; i++) {
            if (shelves[i] != null) {
                Book[] books = shelves[i].getBooks();
                if (books != null) {
                    for (Book book : books) {
                        if (book != null && book.getTitle().equals(title)) { // получить название + проверить равенство
                            return i;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
