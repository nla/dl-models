package au.gov.nla.dlir.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import au.gov.nla.dlir.util.NaturalSort;

@JsonIgnoreProperties(ignoreUnknown=true)
public class RelatedDocument implements Comparable<Object> {
    private String id;
    private String copyRole;
    private String externalComments;
    private String fileName;
    private String fileType;
    private Long fileSize;

    public Object getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCopyRole() {
        return copyRole;
    }

    public void setCopyRole(String copyRole) {
        this.copyRole = copyRole;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public int compareTo(Object object) {
        RelatedDocument doc = (RelatedDocument) object;
        String type1 = (fileName == null) ? "" : fileName;
        String type2 = (doc.getFileName() == null) ? "" : doc.getFileName();
        return NaturalSort.compareNaturalIgnoreCaseAscii(type1, type2);
    }

    public String getExternalComments() {
        return externalComments;
    }

    public void setExternalComments(String externalComments) {
        this.externalComments = externalComments;
    }
}