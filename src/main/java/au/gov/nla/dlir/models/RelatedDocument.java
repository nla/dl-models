package au.gov.nla.dlir.models;

import au.gov.nla.dlir.util.NaturalSort;

public class RelatedDocument implements Comparable<Object> {
    private String id;
    private String copyRoleCode;
    private String copyRoleText;
    private String fileType;
    private Long fileSize;

    public Object getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCopyRoleCode() {
        return copyRoleCode;
    }

    public void setCopyRoleCode(String copyRoleCode) {
        this.copyRoleCode = copyRoleCode;
    }

    public String getCopyRoleText() {
        return copyRoleText;
    }

    public void setCopyRoleText(String copyRoleText) {
        this.copyRoleText = copyRoleText;
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
        String type1 = (fileType == null) ? "" : fileType;
        String type2 = (doc.getFileType() == null) ? "" : doc.getFileType();
        return NaturalSort.compareNaturalIgnoreCaseAscii(type1, type2);
    }
}