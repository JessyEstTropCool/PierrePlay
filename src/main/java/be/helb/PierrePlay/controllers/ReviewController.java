package be.helb.PierrePlay.controllers;

import be.helb.PierrePlay.models.Review;
import be.helb.PierrePlay.models.Review;
import be.helb.PierrePlay.services.ReviewService;
import be.helb.PierrePlay.services.ReviewService;
import be.helb.PierrePlay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ReviewController {

    private ReviewService reviewService;
    private UserService userService;

    @Autowired
    public ReviewController(ReviewService reviewService, UserService userService)
    {
        this.reviewService = reviewService;
        this.userService = userService;

    }

    @GetMapping("reviews")
    public List<Review> ReviewList()
    {
        return reviewService.getAll();
    }

    @GetMapping("reviews/{id}")
    public Review reviewById(@PathVariable long id) {
        return reviewService.getById(id);
    }

    @PostMapping(path="reviews/add")
    public Review addReview(@RequestBody Review review) {
        review.setReviewId(null);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) auth.getPrincipal();
        review.setAuthor( userService.getByUsername(username) );
        reviewService.save(review);
        return review;
    }

    @DeleteMapping(path="reviews/{id}")
    public @ResponseBody String deleteReview(@PathVariable long id) {
        Review review = reviewService.getById(id);

        if ( review != null )
        {
            reviewService.delete(review);
            return "Delete Successfully";
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found");
    }

    @PutMapping(path="reviews/{id}")
    public Review updateReview(@PathVariable long id, @RequestBody Review review) {
        review.setReviewId(id);
        if (reviewService.getById(id) != null)
        {
            reviewService.save(review);
            return review;
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found");
    }
}
