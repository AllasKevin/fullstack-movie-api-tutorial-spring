package com.example.moviestutorial.service;

import com.example.moviestutorial.model.Movie;
import com.example.moviestutorial.model.Review;
import com.example.moviestutorial.repository.ReviewRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId) {
        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }

    public String deleteReview(ObjectId id) {

        if(reviewRepository.findById(id).isPresent()) {
            reviewRepository.deleteById(id);
            return "Deleted successfully.";
        }
        else {
            return "There was no review with that Id.";  // TODO detta kanske är onödig information att läcka.
        }

    }
}
