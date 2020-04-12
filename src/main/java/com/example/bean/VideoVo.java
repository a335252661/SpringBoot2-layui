package com.example.bean;

import lombok.Data;

/**
 * @author by cld
 * @date 2020/4/4  11:05
 * @description:
 */
@Data
public class VideoVo {
    private String videoName;
    private String videoFullPathName;

    public String getVideoFullPathName() {
        return videoFullPathName;
    }

    public void setVideoFullPathName(String videoFullPathName) {
        this.videoFullPathName = videoFullPathName;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }
}
