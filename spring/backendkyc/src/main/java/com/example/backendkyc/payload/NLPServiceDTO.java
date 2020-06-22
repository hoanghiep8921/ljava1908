package com.example.backendkyc.payload;

import com.example.backendkyc.model.RequestService;

import javax.persistence.*;
import java.util.Date;

public class NLPServiceDTO {

    private Integer id;
    private int responseCode;
    private String responseData;
    private String responseMessage;
    private long processTime;
    private int prevServiceId;
    private String prevServiceType;
    private String idSide;
    private String nameCard;
    private String nationalCard;
    private Date dateOfBirth;
    private String placeOfBirth;
    private String sex;
    private String type;
    private String number;
    private Date expiryDate;
    private String residence;
    private Date issueDate;
    private String issuePlace;
    private String cardInformation;
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

    public String getIdSide() {
        return idSide;
    }

    public void setIdSide(String idSide) {
        this.idSide = idSide;
    }

    public String getNameCard() {
        return nameCard;
    }

    public void setNameCard(String nameCard) {
        this.nameCard = nameCard;
    }

    public String getNationalCard() {
        return nationalCard;
    }

    public void setNationalCard(String nationalCard) {
        this.nationalCard = nationalCard;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssuePlace() {
        return issuePlace;
    }

    public void setIssuePlace(String issuePlace) {
        this.issuePlace = issuePlace;
    }

    public String getCardInformation() {
        return cardInformation;
    }

    public void setCardInformation(String cardInformation) {
        this.cardInformation = cardInformation;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
}
