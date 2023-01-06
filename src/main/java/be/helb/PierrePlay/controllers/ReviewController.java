package be.helb.PierrePlay.controllers;

import be.helb.PierrePlay.models.Review;
import be.helb.PierrePlay.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("reviews")
    public List<Review> ReviewList()
    {
        return reviewService.getAll();
    }

    @GetMapping("reviews/{id}")
    public Review reviewById(@PathVariable long id) {
        return reviewService.getById(id);
    }
}
