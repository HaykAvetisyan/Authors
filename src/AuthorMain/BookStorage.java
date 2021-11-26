package AuthorMain;

public class BookStorage {
    private Book[] books = new Book[10];
    private int size = 0;

    public void add(Book book) {
        if (size == books.length) {
            extend();
        }
        books[size++] = book;
    }

    private void extend() {
        Book[] tmp = new Book[books.length + 10];
        System.arraycopy(books, 0, tmp, 0, size);
        books = tmp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }

    public void searchByTitle(String keyword) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().contains(keyword)) {
                System.out.println(books[i]);
            }
        }
    }

    public Book getByTitle(String keyword) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().contains(keyword)) {
                return books[i];
            }
        }
        return null;
    }

    public void searchByAuthorEmail(String email) {
        for (int i = 0; i <size; i++) {
            if(books[i].getAuthor().getEmail().equals(email)){
                System.out.println(books[i]);
            }

        }
    }

    public void searchByCountAuthorEmail(String email) {
        int count = 0;
        for (int i = 0; i <size; i++) {
            if(books[i].getAuthor().getEmail().equals(email)){
                System.out.println(books[i].getCount());
                count++;
            }
            System.out.println(count);

        }


    }

    public Book changeAuthorbyBook(String title) {
        for (int i = 0; i <size ; i++) {
            if(books[i].getTitle().equals(title)){
                return books[i];
            }
        }
        return null;

    }

    public void deleteAuthorsBooks(Author byEmail) {
        for (int i = getIndex(byEmail.getEmail()); i < size; i++) {
            if(books[i].getAuthor().equals(byEmail)){
                books[i] = books[i+1];
                size--;
            }
        }
    }

    public void deleteBooks(String title) {
        for (int i = getIndex(title); i < size; i++) {
                books[i] = books[i+1];
                size--;

        }
    }

    private int getIndex(String email){
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equals(email)){
                return i;
            }
        }
        return -1;
    }
}
