package au.gov.nla.dlir.models;

import java.util.List;

public class Page {

    private String id;
    private String subType;
    private String subUnitType = "";
    private String subUnitNo = "";
    private String description = " "; // TO DO Remove
    private String pid;
    private List<Copies> copies;
    private String accessConditions = "Unrestricted";
    private String copyrightPolicy;
    private String sensitiveMaterial;
    private List<String> sensitiveReason;
    private String form;
    private String bibLevel;
    private String digitalStatus;
    private String title;
    private String holdingNumber;
    private String commentsExternal;
    private String bibId;

    public String getHoldingNumber() {
        return holdingNumber;
    }

    public void setHoldingNumber(String holdingNumber) {
        this.holdingNumber = holdingNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public List<Copies> getCopies() {
        return copies;
    }

    public void setCopies(List<Copies> copies) {
        this.copies = copies;
    }

    public String getAccessConditions() {
        return accessConditions;
    }

    public void setAccessConditions(String accessConditions) {
        this.accessConditions = accessConditions;
    }

    public String getCopyrightPolicy() {
        return copyrightPolicy;
    }

    public void setCopyrightPolicy(String copyrightPolicy) {
        this.copyrightPolicy = copyrightPolicy;
    }

    public String getSubUnitType() {
        return subUnitType;
    }

    public void setSubUnitType(String subUnitType) {
        this.subUnitType = subUnitType;
    }

    public String getSubUnitNo() {
        return subUnitNo;
    }

    public void setSubUnitNo(String subUnitNo) {
        this.subUnitNo = subUnitNo;
    }

    public String getSensitiveMaterial() {
        return sensitiveMaterial;
    }

    public void setSensitiveMaterial(String sensitiveMaterial) {
        this.sensitiveMaterial = sensitiveMaterial;
    }

    public List<String> getSensitiveReason() {
        return sensitiveReason;
    }

    public void setSensitiveReason(List<String> sensitiveReason) {
        this.sensitiveReason = sensitiveReason;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getBibLevel() {
        return bibLevel;
    }

    public void setBibLevel(String bibLevel) {
        this.bibLevel = bibLevel;
    }

    public String getDigitalStatus() {
        return digitalStatus;
    }

    public void setDigitalStatus(String digitalStatus) {
        this.digitalStatus = digitalStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCommentsExternal() {
        return commentsExternal;
    }

    public void setCommentsExternal(String commentsExternal) {
        this.commentsExternal = commentsExternal;
    }

    public String getBibId() {
        return bibId;
    }

    public void setBibId(String bibId) {
        this.bibId = bibId;
    }
}
