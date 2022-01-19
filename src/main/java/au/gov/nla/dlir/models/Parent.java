package au.gov.nla.dlir.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Parent {

    public static final String DATE_PATTERN = "EEE, d MMM yyyy";

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
    private boolean ocrMetsCopyAvaliable;
    private String creator;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN, locale = "en_AU")
    private Date issueDate;
}
