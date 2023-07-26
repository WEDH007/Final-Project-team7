document.addEventListener("DOMContentLoaded", function() {
    // Retrieve and display reviews
    retrieveReviews();

    // Handle review submission
    document.getElementById("review-form").addEventListener("submit", function(event) {
        event.preventDefault();

        // Get the comment and rating values
        var comment = document.getElementById("comment").value;
        var rating = parseInt(document.getElementById("rating").value);

        // Perform validation on the comment and rating

        // Submit the review
        submitReview(comment, rating);

        // Clear the form
        document.getElementById("comment").value = "";
        document.getElementById("rating").value = "";
    });
});

function retrieveReviews() {
    // Send an AJAX request to retrieve the reviews for the book
    var bookId = 123; // Replace with the actual book ID
    var url = "retrieve_reviews.php?book_id=" + bookId; // Replace with the appropriate URL
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                // Parse the response and generate HTML for each review
                var reviews = JSON.parse(xhr.responseText);
                var reviewsHTML = "";

                reviews.forEach(function(review) {
                    reviewsHTML += "<p>Comment: " + review.comment + "</p>";
                    reviewsHTML += "<p>Rating: " + review.rating + "</p>";
                    reviewsHTML += "<hr>";
                });

                // Insert the generated HTML into the reviews div
                document.getElementById("reviews").innerHTML = reviewsHTML;
            } else {
                console.log("Error retrieving reviews");
            }
        }
    };

    xhr.open("GET", url, true);
    xhr.send();
}

function submitReview(comment, rating) {
    // Send an AJAX request to submit the review
    var bookId = 123; // Replace with the actual book ID
    var url = "submit_review.php"; // Replace with the appropriate URL
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                // Review submitted successfully
                // Retrieve and display the updated reviews
                retrieveReviews();
            } else {
                console.log("Error submitting review");
            }
        }
    };

    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send("book_id=" + bookId + "&comment=" + comment + "&rating=" + rating);
}