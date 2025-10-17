public class Shelf {
    Book [] books;

    public Shelf (Book[] books) {
        this.books = books;
    }
    int indexOfByTitle (String title) {
        int i = 0;
        for (i = 0; i < books.length; i++) {
            if (books[i].equals(title)) {
                return i;
            }
        }
        return -1;
    }
    Book get(int index) {
        if (index < 0 || index >= books.length){
            return null;
        }
            return books[index];
    }
    void infoShelf (){
        int size = books.length;
        System.out.println(String.format("На полке хранится %d книг", size));
    }

    public Book[] getBooks() {
        return books;
    }

}
