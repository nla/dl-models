package au.gov.nla.dlir.models;

public class Parent {
    
    private String id;
    private String collection;
    private String form;
    private String number;
    private String type;
    private String bibLevel;
    private String subType;
    private String subUnitType;
    private String subUnitNo = "";
    private String link;
    private String pid;
    private String title;
    private String accessConditions = "Unrestricted";
    private String copyrightPolicy;
    private BibData bibData;
    private Boolean interactiveIndexAvailable = false;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCollection() {
        return collection;
    }
    public void setCollection(String collection) {
        this.collection = collection;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getSubType() {
        return subType;
    }
    public void setSubType(String subType) {
        this.subType = subType;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public String getPid() {
        return pid;
    }
    public void setPid(String pid) {
        this.pid = pid;
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
    public BibData getBibData() {
        return bibData;
    }
    public void setBibData(BibData bibData) {
        this.bibData = bibData;
    }
    public String getForm() {
        return form;
    }
    public void setForm(String form) {
        this.form = form;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getSubUnitType() {
        return subUnitType;
    }
    public void setSubUnitType(String subUnitType) {
        this.subUnitType = subUnitType;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBibLevel() {
        return bibLevel;
    }
    public void setBibLevel(String bibLevel) {
        this.bibLevel = bibLevel;
    }
    public String getSubUnitNo() {
        return subUnitNo;
    }
    public void setSubUnitNo(String subUnitNo) {
        this.subUnitNo = subUnitNo;
    }
    public Boolean getInteractiveIndexAvailable() {
        return interactiveIndexAvailable;
    }
    public void setInteractiveIndexAvailable(Boolean interactiveIndexAvailable) {
        this.interactiveIndexAvailable = interactiveIndexAvailable;
    }
}
