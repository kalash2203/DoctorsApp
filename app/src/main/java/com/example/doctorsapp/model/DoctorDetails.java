package com.example.doctorsapp.model;

import com.google.gson.annotations.SerializedName;

public class DoctorDetails {
    @SerializedName("docId")
    private String docId;
    @SerializedName("docName")
    private String docName;
    @SerializedName("docSpecialisation")
    private String docSpecialisation;
    @SerializedName("docYoE")
    private String docYoE;

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocSpecialisation() {
        return docSpecialisation;
    }

    public void setDocSpecialisation(String docSpecialisation) {
        this.docSpecialisation = docSpecialisation;
    }

    public String getDocYoE() {
        return docYoE;
    }

    public void setDocYoE(String docYoE) {
        this.docYoE = docYoE;
    }

    public String getDocConsultationFee() {
        return docConsultationFee;
    }

    public void setDocConsultationFee(String docConsultationFee) {
        this.docConsultationFee = docConsultationFee;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDocProfileImgUrl() {
        return docProfileImgUrl;
    }

    public void setDocProfileImgUrl(String docProfileImgUrl) {
        this.docProfileImgUrl = docProfileImgUrl;
    }

    @SerializedName("docConsultationFee")
    private String docConsultationFee;
    @SerializedName("city")
    private String city;
    @SerializedName("docProfileImgUrl")
    private String docProfileImgUrl;
}
