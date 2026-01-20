package week4collections.javagenerics.marketplace;

/**
 * Book category with specific price range
 */
public class BookCategory {
    private String genre;
    private double minPrice;
    private double maxPrice;

    public BookCategory(String genre, double minPrice, double maxPrice) {
        this.genre = genre;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public String getGenre() {
        return genre;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    @Override
    public String toString() {
        return "Book (" + genre + ", $" + minPrice + "-$" + maxPrice + ")";
    }
}
