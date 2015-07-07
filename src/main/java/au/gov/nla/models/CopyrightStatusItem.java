package au.gov.nla.dlir.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
public class CopyrightStatusItem {
        
    private String copyrightStatus;
    private String creatorAliveStatus;
    private String creatorDateOfDeath;
    private String copyrightStatusReason;
    private String creationDate;
    private String materialType;
    private String publicationDate;
    private String publishedStatus;
    private String govtCopyrightOwnership;
    private String contextMsg;

    public String getCopyrightStatus() {
        return copyrightStatus;
    }

    public void setCopyrightStatus(String copyrightStatus) {
        this.copyrightStatus = copyrightStatus;
    }

    public String getCreatorAliveStatus() {
        return creatorAliveStatus;
    }

    public void setCreatorAliveStatus(String creatorAliveStatus) {
        this.creatorAliveStatus = creatorAliveStatus;
    }

    public String getCreatorDateOfDeath() {
        return creatorDateOfDeath;
    }

    public void setCreatorDateOfDeath(String creatorDateOfDeath) {
        this.creatorDateOfDeath = creatorDateOfDeath;
    }

    public String getCopyrightStatusReason() {
        return copyrightStatusReason;
    }

    public void setCopyrightStatusReason(String copyrightStatusReason) {
        this.copyrightStatusReason = copyrightStatusReason;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getPublishedStatus() {
        return publishedStatus;
    }

    public void setPublishedStatus(String publishedStatus) {
        this.publishedStatus = publishedStatus;
    }

    public String getGovtCopyrightOwnership() {
        return govtCopyrightOwnership;
    }

    public void setGovtCopyrightOwnership(String govtCopyrightOwnership) {
        this.govtCopyrightOwnership = govtCopyrightOwnership;
    }

    public String getContextMsg() {
        return contextMsg;
    }

    public void setContextMsg(String contextMsg) {
        this.contextMsg = contextMsg;
    }
    
}
