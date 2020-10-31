package com.queenprime.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.queenprime.api.domain.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {


}