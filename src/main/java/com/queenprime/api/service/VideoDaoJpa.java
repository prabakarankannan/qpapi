package com.queenprime.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.queenprime.api.domain.Video;
import com.queenprime.api.repository.VideoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VideoDaoJpa {

    @Autowired
    private VideoRepository videoRepository;

    public List<Video> getAllVideos(){
        return videoRepository.findAll();
    }

    public Video getVideoById(Integer videoId){
        return videoRepository.findById(videoId).orElse(null);
    }

    public Video addVideoToDb(Video video){
        if (video!=null)
            videoRepository.save(video);
        return video;
    }

    public Video updateVideo(Video video){
        if (video==null)
            return null;
        if (video.getId()==null)
            return null;

        Optional<Video> videoOptional = videoRepository.findById(video.getId());
        if (videoOptional.isPresent()) {
            Video currentVideo = videoOptional.get();
            currentVideo.setTitle(video.getTitle());
            currentVideo.setFilePath(video.getFilePath());
            videoRepository.save(currentVideo);
            return currentVideo;
        }
        return null;
    }
}
