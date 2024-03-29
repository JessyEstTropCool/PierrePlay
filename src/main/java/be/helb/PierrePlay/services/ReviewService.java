package be.helb.PierrePlay.services;

import be.helb.PierrePlay.daos.ReviewDao;
import be.helb.PierrePlay.models.Review;
import be.helb.PierrePlay.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewDao reviewDao;
    public ReviewService(ReviewDao reviewDao) { this.reviewDao = reviewDao; }

    public List<Review> getAll() { return reviewDao.findAll(); }

    public Review getById(Long id) { return reviewDao.findById(id).orElse(null); }

    public Review save(Review review) { return reviewDao.save(review); }

    public void delete(Review review) { reviewDao.delete(review); }

    public void update(Review review) { reviewDao.save(review); }

    public ReviewDao getReviewDao() {
        return reviewDao;
    }

    public void setReviewDao(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }
}