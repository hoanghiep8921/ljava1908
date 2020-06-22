package com.example.backendkyc.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "REQUEST_SERVICE")
public class RequestService {
    @Transient
    private long index;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DEVICE_ID")
    private String deviceId;
    @Column(name = "IMEI")
    private String imei;
    @Column(name = "REQUEST_ID")
    private String requestId;
    @Column(name = "CLIENT_ID")
    private String clientId;
    @Column(name = "TIME")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    @OneToOne(fetch = FetchType.EAGER,
            cascade =  CascadeType.ALL,
            mappedBy = "request")
    @JsonIgnoreProperties("request")
    private FACService facService;

    @OneToOne(fetch = FetchType.EAGER,
            cascade =  CascadeType.ALL,
            mappedBy = "request")
    @JsonIgnoreProperties("request")
    private NLPService nlpService;

    @OneToOne(fetch = FetchType.EAGER,
            cascade =  CascadeType.ALL,
            mappedBy = "request")
    @JsonIgnoreProperties("request")
    private OCRService ocrService;

    @OneToOne(fetch = FetchType.EAGER,
            cascade =  CascadeType.ALL,
            mappedBy = "request")
    @JsonIgnoreProperties("request")
    private PPRService pprService;

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public FACService getFacService() {
        return facService;
    }

    public void setFacService(FACService facService) {
        this.facService = facService;
    }

    public NLPService getNlpService() {
        return nlpService;
    }

    public void setNlpService(NLPService nlpService) {
        this.nlpService = nlpService;
    }

    public OCRService getOcrService() {
        return ocrService;
    }

    public void setOcrService(OCRService ocrService) {
        this.ocrService = ocrService;
    }

    public PPRService getPprService() {
        return pprService;
    }

    public void setPprService(PPRService pprService) {
        this.pprService = pprService;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
