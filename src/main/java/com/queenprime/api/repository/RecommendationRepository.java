package com.queenprime.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.queenprime.api.domain.Recommendation;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {

    List<Recommendation> findAllByVideoId(Long videoId);
}
