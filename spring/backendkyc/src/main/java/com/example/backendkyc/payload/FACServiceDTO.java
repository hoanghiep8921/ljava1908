package com.example.backendkyc.payload;

import com.example.backendkyc.model.RequestService;

import javax.persistence.*;

public class FACServiceDTO {
    private Integer id;
    private int responseCode;
    private String responseData;
    private String responseMessage;
    private long processTime;
    private int prevServiceId;
    private String prevServiceType;
    private String imageSelfie;
    private String similarityScore ;
    private String recommendThreshold ;
    private String confidence ;
    private String faceCharacteristics ;
    private String traceId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseData() {
        return responseData;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public long getProcessTime() {
        return processTime;
    }

    public void setProcessTime(long processTime) {
        this.processTime = processTime;
    }

    public int getPrevServiceId() {
        return prevServiceId;
    }

    public void setPrevServiceId(int prevServiceId) {
        this.prevServiceId = prevServiceId;
    }

    public String getPrevServiceType() {
        return prevServiceType;
    }

    public void setPrevServiceType(String prevServiceType) {
        this.prevServiceType = prevServiceType;
    }

    public String getImageSelfie() {
        return imageSelfie;
    }

    public void setImageSelfie(String imageSelfie) {
        this.imageSelfie = imageSelfie;
    }

    public String getSimilarityScore() {
        return similarityScore;
    }

    public void setSimilarityScore(String similarityScore) {
        this.similarityScore = similarityScore;
    }

    public String getRecommendThreshold() {
        return recommendThreshold;
    }

    public void setRecommendThreshold(String recommendThreshold) {
        this.recommendThreshold = recommendThreshold;
    }

    public String getConfidence() {
        return confidence;
    }

    public void setConfidence(String confidence) {
        this.confidence = confidence;
    }

    public String getFaceCharacteristics() {
        return faceCharacteristics;
    }

    public void setFaceCharacteristics(String faceCharacteristics) {
        this.faceCharacteristics = faceCharacteristics;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
}
