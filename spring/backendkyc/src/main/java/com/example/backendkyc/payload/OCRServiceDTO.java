package com.example.backendkyc.payload;

import com.example.backendkyc.model.RequestService;

import javax.persistence.*;

public class OCRServiceDTO {
    private Integer id;
    private int responseCode;
    private String responseData;
    private String responseMessage;
    private long processTime;
    private int prevServiceId;
    private String prevServiceType;
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

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
}
