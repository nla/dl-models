package au.gov.nla.dlir.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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
    private boolean ocrMetsCopyAvaliable;
}
