import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String author;
    private double rating;
    private int numRatings;
    private List<String> comments;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.rating = 0.0;
        this.numRatings = 0;
        this.comments = new ArrayList<>();
    }

    // Getters and setters

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getRating() {
        return rating;
    }

    public int getNumRatings() {
        return numRatings;
    }

    public List<String> getComments() {
        return comments;
    }

    // Rating methods

    public void rateBook(int rating) {
        // Update the book's rating by taking the average of the current rating and the new rating
        double totalRating = this.rating * this.numRatings;
        totalRating += rating;
        this.numRatings++;
        this.rating = totalRating / this.numRatings;
    }

    // Comment methods

    public void addComment(String comment) {
        comments.add(comment);
    }
}
