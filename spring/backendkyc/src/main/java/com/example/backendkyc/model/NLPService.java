package com.example.backendkyc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "NLP_SERVICE")
public class NLPService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "RESPONSE_CODE")
    private int responseCode;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "REQUEST_ID", nullable = false)
    @JsonIgnoreProperties("nlpService")
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
    @Column(name = "ID_SIDE")
    private String idSide;
    @Column(name = "NAME_CARD")
    private String nameCard;
    @Column(name = "NATIONAL_CARD")
    private String nationalCard;
    @Column(name = "DATEOFBIRTH_CARD")
    private Date dateOfBirth;
    @Column(name = "PLACEOFBIRTH_CARD")
    private String placeOfBirth;
    @Column(name = "SEX_CARD")
    private String sex;
    @Column(name = "TYPE_CARD")
    private String type;
    @Column(name = "NUMBER_CARD")
    private String number;
    @Column(name = "EXPIRYDATE_CARD")
    private Date expiryDate;
    @Column(name = "RESDIENCE_CARD")
    private String residence;
    @Column(name = "ISSUEDATE_CARD")
    private Date issueDate;
    @Column(name = "ISSUEPLACE_CARD")
    private String issuePlace;
    @Column(name = "CARD_INFORMATION")
    private String cardInformation;
    @Column(name = "TRACE_ID")
    private String traceId;

    public String getCardInformation() {
        return cardInformation;
    }

    public void setCardInformation(String cardInformation) {
        this.cardInformation = cardInformation;
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

    public String getIdSide() {
        return idSide;
    }

    public void setIdSide(String idSide) {
        this.idSide = idSide;
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

    public int getPrevServiceId() {
        return prevServiceId;
    }

    public void setPrevServiceId(int prevServiceId) {
        this.prevServiceId = prevServiceId;
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
