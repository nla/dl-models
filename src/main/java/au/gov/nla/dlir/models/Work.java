package au.gov.nla.dlir.models;

import au.gov.nla.dlir.models.bibdata.MarcData;
import au.gov.nla.dlir.util.NaturalSort;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter
public class Work implements Comparable<Object> {

    public static final String DATE_PATTERN = "EEE, dd MMM yyyy";

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN, locale = "en_AU")
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
    private String representativeWorkAccessConditions;
    private Boolean representativeWorkAllowHighResDownload = false;
    private String firstChild;
    private String firstChildAccessConditions;
    private Boolean firstChildAllowHighResDownload = false;
    private Boolean displayTitlePage = false;
    private String commentsExternal;
    private String bibliography;
    private String digitalStatus;
    private String startDate;
    private String endDate;
    private String ebookType;
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
    private String additionalSeriesStatement;
    private MarcData marcData;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
    private Date expiryDate;
    private String depositType;
    private boolean isOriginalCopyAvaliable;
    private boolean ocrMetsCopyAvaliable;
    private String topLevelCollection;
    private List<String> standardIds = new ArrayList<>();
    private String ownerLibrary;
    private List<String> accessOnsiteAt = new ArrayList<>();
    private String librariesAustraliaId;
    private String nedReference;
    private PlaceOfPublication placeOfPublication;
    private String publisherName;
    private Boolean allowSearchEngineIndexing = false;
    private boolean atomisedInTrove;
    private String partnerHoldingNumber;
    private String partnerHoldingNuc;

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

    @Override
    public int compareTo(Object object) {
        Work work = (Work) object;
        String displayOrder1 = (displayOrder == null ? "" : displayOrder);
        String displayOrder2 = (work.getDisplayOrder() == null ? "" : work.getDisplayOrder());
        return NaturalSort.compareNaturalIgnoreCaseAscii(displayOrder1, displayOrder2);
    }

    /**
     * True if the work has a copy matching the supplied copy role.
     *
     * @param copyRole the copy role to search for
     * @return true if a copy is found with this copy role
     */
    public boolean hasCopy(String copyRole) {
        if (copyRole == null || getCopies() == null) return false;

        for (Copies copy : getCopies()) {
            if (copyRole.equalsIgnoreCase(copy.getCopyrole())) {
                return true;
            }
        }

        return false;
    }

}
