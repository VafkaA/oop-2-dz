public class Library {
    Rack[] racks;

    public Library(Rack[] racks) {
        this.racks = racks;
    }

    Rack getRacks(int index) { // конкретный стеллаж
        if (index <= 0) return null;
        return racks[index];
    }

    int totalBooks() {
        int total = 0;
        for (int i = 0; i < racks.length; i++) {
            if (racks[i] != null) {
                Shelf[] shelves = racks[i].getShelves();
                for (Shelf shelf : shelves) {
                    if (shelf != null) {
                        Book[] books = shelf.getBooks();
                        if (books != null) {
                            total += books.length;
                        }
                    }
                }
            }
        }
        return total;
    }

    int findFirstByTitle(String title) {
        for (int i = 0; i < racks.length; i++) {
            if (racks[i] != null) {
                Shelf[] shelves = racks[i].getShelves(); // выгрузить полки
                for (Shelf shelf : shelves) {
                    if (shelf != null) {
                        Book[] books = shelf.getBooks(); // выгрузить книги
                        if (books != null) {
                            for (Book book : books) {
                                if (book != null && book.getTitle().equals(title)) { // получить название + проверить равенство
                                    return i;
                                }
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
    Book findByTitle(String title) {
        for (int i = 0; i < racks.length; i++) {
            if (racks[i] != null) {
                Shelf[] shelves = racks[i].getShelves(); // выгрузить полки
                for (Shelf shelf : shelves) {
                    if (shelf != null) {
                        Book[] books = shelf.getBooks(); // выгрузить книги
                        if (books != null) {
                            for (Book book : books) {
                                if (book != null && book.getTitle().equals(title)) { // получить название + проверить равенство
                                    return book;
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
    @Override
    public String toString (){
        StringBuilder sb = new StringBuilder();
        sb.append("В библиотеке: ");
        for (int i = 0; i < racks.length; i++) {
            Rack rack = racks[i];
            if (rack != null) {
                sb.append("стеллажей ").append(i).append(" на них:");
                Shelf [] shelves = rack.getShelves();
                for (int j = 0; j < shelves.length; j++) {
                    Shelf shelf = shelves[i];
                    if (shelf != null) {
                        int countBook = 0;
                        Book [] books = shelf.getBooks();
                        if (books != null) {
                            countBook = books.length;
                        }
                        sb.append(" полок: ").append(j).append(" на них: ").append(" книг :"). append(countBook);
                    }
                }
            }
        }
        return toString();
    }
}