package au.gov.nla.dlir.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Acknowledgement {
    private String id;
    private String type;
    private String kindOfSupport;
    private Double weighting;
    private String urlToOriginal;
    private String date; //date of Acknowledgement
    private String orgName;
    private String orgUrl;
    private String orgLogoUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKindOfSupport() {
        return kindOfSupport;
    }

    public void setKindOfSupport(String kindOfSupport) {
        this.kindOfSupport = kindOfSupport;
    }

    public Double getWeighting() {
        return weighting;
    }

    public void setWeighting(Double weighting) {
        this.weighting = weighting;
    }

    public String getUrlToOriginal() {
        return urlToOriginal;
    }

    public void setUrlToOriginal(String urlToOriginal) {
        this.urlToOriginal = urlToOriginal;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgUrl() {
        return orgUrl;
    }

    public void setOrgUrl(String orgUrl) {
        this.orgUrl = orgUrl;
    }

    public String getOrgLogoUrl() {
        return orgLogoUrl;
    }

    public void setOrgLogoUrl(String orgLogoUrl) {
        this.orgLogoUrl = orgLogoUrl;
    }
}
