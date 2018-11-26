package au.gov.nla.dlir.models.bibdata;

import java.util.List;

public class DataField {
    private String tag;
    private String ind1;
    private String ind2;
    private List<Subfield> subfield;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getInd1() {
        return ind1;
    }

    public void setInd1(String ind1) {
        this.ind1 = ind1;
    }

    public String getInd2() {
        return ind2;
    }

    public void setInd2(String ind2) {
        this.ind2 = ind2;
    }

    public List<Subfield> getSubfield() {
        return subfield;
    }

    public void setSubfield(List<Subfield> subfield) {
        this.subfield = subfield;
    }

    public Subfield getSubfield(String code) {
        for (Subfield s : this.subfield) {
            if (s.getCode().equalsIgnoreCase(code)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "DataField{" +
                "tag='" + tag + '\'' +
                ", ind1='" + ind1 + '\'' +
                ", ind2='" + ind2 + '\'' +
                ", subfield=" + subfield +
                '}';
    }
}
