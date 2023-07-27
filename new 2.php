<?php
$bookId = $_GET['book_id']; // Retrieve the book ID from the request

// Perform necessary database queries to retrieve the reviews for the book
// Replace the following code with your actual database retrieval logic
$reviews = [
    ['comment' => 'Great book! Highly recommended.', 'rating' => 5],
    ['comment' => 'Interesting read. Loved the plot.', 'rating' => 4]
];

// Return the reviews as JSON response
header('Content-Type: application/json');
echo json_encode($reviews);
?>