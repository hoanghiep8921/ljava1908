package com.example.backendkyc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "OCR_SERVICE")
public class OCRService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "RESPONSE_CODE")
    private int responseCode;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "REQUEST_ID", nullable = false)
    @JsonIgnoreProperties("ocrService")
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

    @Column(name = "TRACE_ID")
    private String traceId;

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public Integer getPrevServiceId() {
        return prevServiceId;
    }

    public void setPrevServiceId(Integer prevServiceId) {
        this.prevServiceId = prevServiceId;
    }

    public String getPrevServiceType() {
        return prevServiceType;
    }

    public void setPrevServiceType(String prevServiceType) {
        this.prevServiceType = prevServiceType;
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

    public void setPrevServiceId(int prevServiceId) {
        this.prevServiceId = prevServiceId;
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

    public long getProcessTime() {
        return processTime;
    }

    public void setProcessTime(long processTime) {
        this.processTime = processTime;
    }
}
