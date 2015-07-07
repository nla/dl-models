package au.gov.nla.dlir.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "itemList")
public class CopyrightStatusItemList {
        
    private CopyrightStatusItem item;

    public CopyrightStatusItem getItem() {
        return item;
    }

    public void setItem(CopyrightStatusItem item) {
        this.item = item;
    }
    
}
