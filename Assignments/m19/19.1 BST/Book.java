/**
 * Class for book.
 */
class Book implements Comparable<Book> {
    /**
     * name of the book.
     */
    private String name;
    /**
     * author of the book.
     */
    private String author;
    /**
     * price of the book.
     */
    private double price;
    /**
     * Constructs the object.
     * @param      n     name.
     * @param      a     author.
     * @param      p     price.
     */
    Book(final String name, final String author,
        final double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }
    /**
     * Gets the name.
     * @return     The name.
     */
    String getName() {
        return name;
    }
    /**
     * Gets the author.
     * @return     The author.
     */
    String getAuthor() {
        return author;
    }
    /**
     * Gets the price.
     * @return     The price.
     */
    double getPrice() {
        return price;
    }
    /**
     * compareTo method.
     * @param      b     b of type Book.
     * @return     integer.
     */
    public int compareTo(final Book b) {
        return getName().compareTo(b.getName());
    }
}
