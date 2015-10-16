package au.gov.nla.dlir.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import au.gov.nla.dlir.util.NaturalSort;

public class Work  implements Comparable<Object>{
    
    public static final String ISSUE_DATE_PATTERN = "EEE, dd MMM yyyy";

    private String id;  
    private String bibId;
    private String collection;
    private String creator;   
    private String form = ""; // Default as this is critical in delivery
    private String number;
    private String type;
    private String bibLevel = ""; // Default as this is critical in delivery
    private String subType;
    private String subUnitType;
    private String subUnitNo = "";
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern=ISSUE_DATE_PATTERN)
    private Date issueDate;
    private String holdingNumber;
    private String pid;
    private String dcmWorkPid;
    private String title;
    private String accessConditions = "Unrestricted";
    private Boolean allowHighResDownload = false;
    private String copyrightPolicy;
    private String displayOrder;
    private String extent;
    private String repository;
    private String dateRange;
    private List<String> scopeContent;
    private String collectionNumber;
    private String componentLevel;
    private String recordSource;
    private String representativeWork;
    private String sensitiveMaterial;    
    private List<String> sensitiveReason;   
    private String findingAidAvailable;
    private String representativeWorkAccessConditions = "Unrestricted";
    private Boolean representativeWorkAllowHighResDownload = false;
    private String firstChild;
    private String firstChildAccessConditions = "Unrestricted";
    private Boolean firstChildAllowHighResDownload = false;
    private Boolean displayTitlePage = false;
    private String commentsExternal;    
    private String bibliography;
    private String digitalStatus;
    private String startDate;
    private String endDate;
    private List<String> arrangement;
    private List<String> access;
    private List<String> copyPublish;
    private List<String> preferredCitation;
    private List<String> provenance;
    private List<String> relatedMaterial;
    private BibData bibData;
    private Parent parent;
    private Children children;
    private List<Copies> copies;
    private List<String> constraints;
    private int rowIndex;
    private String previousSibling;
    private String nextSibling;
    private Boolean isMissingPage = false;
    private Boolean interactiveIndexAvailable = false;
    private String sheetName;
    private String sheetCreationDate;

    /**
     * Returns the BibData of this Object or
     * if null returns the BibData of the Parent
     * if it exists.
     */
    public BibData resolveBibData() {
        if (getBibData() != null) {
            return getBibData();
        } else if (getParent() != null &&
                getParent().getBibData() != null) {
            return getParent().getBibData();
        }

        return null;
    }

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

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public BibData getBibData() {
        return bibData;
    }

    public void setBibData(BibData bibData) {
        this.bibData = bibData;
    }

    public Children getChildren() {
        return children;
    }

    public void setChildren(Children children) {
        this.children = children;
    }

    public String getAccessConditions() {
        return accessConditions;
    }

    public void setAccessConditions(String accessConditions) {
        this.accessConditions = accessConditions;
    }

    public Boolean getAllowHighResDownload() {
        return allowHighResDownload;
    }

    public void setAllowHighResDownload(Boolean allowHighResDownload) {
        this.allowHighResDownload = allowHighResDownload;
    }

    public String getCopyrightPolicy() {
        return copyrightPolicy;
    }

    public void setCopyrightPolicy(String copyrightPolicy) {
        this.copyrightPolicy = copyrightPolicy;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
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

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(String displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getCreator() {
        return creator;
    }
    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public String getDateRange() {
        return dateRange;
    }

    public void setDateRange(String dateRange) {
        this.dateRange = dateRange;
    }

    public List<String> getScopeContent() {
        return scopeContent;
    }

    public void setScopeContent(List<String> scopeContent) {
        this.scopeContent = scopeContent;
    }

    public String getCollectionNumber() {
        return collectionNumber;
    }

    public void setCollectionNumber(String collectionNumber) {
        this.collectionNumber = collectionNumber;
    }

    public String getComponentLevel() {
        return componentLevel;
    }

    public void setComponentLevel(String componentLevel) {
        this.componentLevel = componentLevel;
    }

    public String getExtent() {
        return extent;
    }

    public void setExtent(String extent) {
        this.extent = extent;
    }

    public String getRecordSource() {
        return recordSource;
    }

    public void setRecordSource(String recordSource) {
        this.recordSource = recordSource;
    }

    public String getBibId() {
        return bibId;
    }

    public void setBibId(String bibId) {
        this.bibId = bibId;
    }

    public String getRepresentativeWork() {
        return representativeWork;
    }

    public void setRepresentativeWork(String representativeWork) {
        this.representativeWork = representativeWork;
    }

    public String getRepresentativeWorkAccessConditions() {
        return representativeWorkAccessConditions;
    }

    public void setRepresentativeWorkAccessConditions(String representativeWorkAccessConditions) {
        this.representativeWorkAccessConditions = representativeWorkAccessConditions;
    }

    public Boolean getRepresentativeWorkAllowHighResDownload() {
        return representativeWorkAllowHighResDownload;
    }

    public void setRepresentativeWorkAllowHighResDownload(Boolean representativeWorkAllowHighResDownload) {
        this.representativeWorkAllowHighResDownload = representativeWorkAllowHighResDownload;
    }

    public String getFirstChild() {
        return firstChild;
    }

    public void setFirstChild(String firstChild) {
        this.firstChild = firstChild;
    }

    public String getFirstChildAccessConditions() {
        return firstChildAccessConditions;
    }

    public void setFirstChildAccessConditions(String firstChildAccessConditions) {
        this.firstChildAccessConditions = firstChildAccessConditions;
    }

    public Boolean getFirstChildAllowHighResDownload() {
        return firstChildAllowHighResDownload;
    }

    public void setFirstChildAllowHighResDownload(Boolean firstChildAllowHighResDownload) {
        this.firstChildAllowHighResDownload = firstChildAllowHighResDownload;
    }

    public Boolean getDisplayTitlePage() {
        return displayTitlePage;
    }

    public void setDisplayTitlePage(Boolean displayTitlePage) {
        this.displayTitlePage = displayTitlePage;
    }

    @Override
    public int compareTo(Object object) {
        Work work = (Work)object;
        String displayOrder1 = (displayOrder == null ? "" : displayOrder);
        String displayOrder2 = (work.getDisplayOrder() == null ? "" : work.getDisplayOrder());
       return NaturalSort.compareNaturalIgnoreCaseAscii(displayOrder1, displayOrder2);
    }

    public String getDcmWorkPid() {
        return dcmWorkPid;
    }

    public void setDcmWorkPid(String dcmWorkPid) {
        this.dcmWorkPid = dcmWorkPid;
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

    public String getFindingAidAvailable() {
        return findingAidAvailable;
    }

    public void setFindingAidAvailable(String findingAidAvailable) {
        this.findingAidAvailable = findingAidAvailable;
    }

    public String getCommentsExternal() {
        return commentsExternal;
    }

    public void setCommentsExternal(String commentsExternal) {
        this.commentsExternal = commentsExternal;
    }

    public String getBibliography() {
        return bibliography;
    }

    public void setBibliography(String bibliography) {
        this.bibliography = bibliography;
    }

    public String getDigitalStatus() {
        return digitalStatus;
    }

    public void setDigitalStatus(String digitalStatus) {
        this.digitalStatus = digitalStatus;
    }

    public List<String> getArrangement() {
        return arrangement;
    }

    public void setArrangement(List<String> arrangement) {
        this.arrangement = arrangement;
    }

    public List<String> getAccess() {
        return access;
    }

    public void setAccess(List<String> access) {
        this.access = access;
    }

    public List<String> getCopyPublish() {
        return copyPublish;
    }

    public void setCopyPublish(List<String> copyPublish) {
        this.copyPublish = copyPublish;
    }

    public List<String> getPreferredCitation() {
        return preferredCitation;
    }

    public void setPreferredCitation(List<String> preferredCitation) {
        this.preferredCitation = preferredCitation;
    }

    public List<String> getProvenance() {
        return provenance;
    }

    public void setProvenance(List<String> provenance) {
        this.provenance = provenance;
    }

    public List<String> getRelatedMaterial() {
        return relatedMaterial;
    }

    public void setRelatedMaterial(List<String> relatedMaterial) {
        this.relatedMaterial = relatedMaterial;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getHoldingNumber() {
        return holdingNumber;
    }

    public void setHoldingNumber(String holdingNumber) {
        this.holdingNumber = holdingNumber;
    }

    public List<Copies> getCopies() {
        return copies;
    }

    public void setCopies(List<Copies> copies) {
        this.copies = copies;
    }

    public List<String> getConstraints() {
        return constraints;
    }

    public void setConstraints(List<String> constraints) {
        this.constraints = constraints;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public String getPreviousSibling() {
        return previousSibling;
    }

    public void setPreviousSibling(String previousSibling) {
        this.previousSibling = previousSibling;
    }

    public String getNextSibling() {
        return nextSibling;
    }

    public void setNextSibling(String nextSibling) {
        this.nextSibling = nextSibling;
    }

    public Boolean getIsMissingPage() {
        return isMissingPage;
    }

    public void setIsMissingPage(Boolean isMissingPage) {
        this.isMissingPage = isMissingPage;
    }

    public Boolean getInteractiveIndexAvailable() {
        return interactiveIndexAvailable;
    }

    public void setInteractiveIndexAvailable(Boolean interactiveIndexAvailable) {
        this.interactiveIndexAvailable = interactiveIndexAvailable;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public String getSheetCreationDate() {
        return sheetCreationDate;
    }

    public void setSheetCreationDate(String sheetCreationDate) {
        this.sheetCreationDate = sheetCreationDate;
    }
}
