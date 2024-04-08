package com.example.assaigmentjava4.service;

import com.example.assaigmentjava4.entity.Video;

import java.util.List;

public interface VideoService {
    List<Video> getAllVideo();
    Video getVideoById(int id);
    int addVideo(Video video);
    int updateVideo(Video video);
    int deleteVideo(int id);
}
