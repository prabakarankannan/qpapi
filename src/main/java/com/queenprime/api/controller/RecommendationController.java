package com.queenprime.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.queenprime.api.domain.Recommendation;
import com.queenprime.api.repository.RecommendationRepository;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    @Autowired
    RecommendationRepository recommendationRepository;

    @GetMapping("/{videoId}/all")
    public List<Recommendation> getRecommendations(@PathVariable("videoId") Long videoId){
        List<Recommendation> allByVideoId = recommendationRepository.findAllByVideoId(videoId);
        System.out.println(allByVideoId);
        return allByVideoId;
    }

    @PostMapping("/add")
    public void addNewRecommendation(@RequestBody Recommendation recommendation){
        System.out.println(recommendation);
        recommendationRepository.save(recommendation);
    }

}