package com.example.backendkyc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "FAC_SERVICE")
public class FACService {
    @Transient
    private long index;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "RESPONSE_CODE")
    private int responseCode;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "REQUEST_ID", nullable = false)
    @JsonIgnoreProperties("facService")
    private RequestService request;

    @Column(name = "RESPONSE_DATA")
    private String responseData;
    @Column(name = "RESPONSE_MESSAGE")
    private String responseMessage;
    @Column(name = "PROCESS_TIME")
    private long processTime;
    @Column(name = "PREV_SERVICE_ID")
    private int prevServiceId;
    @Column(name = "PREV_SERVICE_TYPE")
    private String prevServiceType;
    @Column(name = "IMAGE_SELFIE")
    private String imageSelfie;
    @Column(name = "SIMILARITY_SCORE")
    private String similarityScore ;
    @Column(name = "RECOMMEND_THRESHOLD")
    private String recommendThreshold ;
    @Column(name = "CONFIDENCE")
    private String confidence ;
    @Column(name = "FACE_CHARACTERISTICS")
    private String faceCharacteristics ;
    @Column(name = "TRACE_ID")
    private String traceId;

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
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

    public long getProcessTime() {
        return processTime;
    }

    public void setProcessTime(long processTime) {
        this.processTime = processTime;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public RequestService getRequest() {
        return request;
    }

    public void setRequest(RequestService request) {
        this.request = request;
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
}
