package au.gov.nla.dlir.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class CopyrightStatusResponse {
    
    @XmlElement(name = "itemList")
    private CopyrightStatusItemList itemList;

    /**
     * Returns the response of the copyright status service
     */
    public CopyrightStatusItem getResponse() {
        return itemList.getItem();
    }
    
    public void setResponse(CopyrightStatusItem copyrightStatusItem) {
        itemList = new CopyrightStatusItemList();
        itemList.setItem(copyrightStatusItem);        
    }
    
    /**
     * Returns the full message for the ContextMsg from the
     * copyright status service;
     */
    public String getContextMessageText() {        
        String contextMsg = itemList.getItem().getContextMsg();
                        
        String message = "";        
        switch (contextMsg) {
            case "1.1": 
                message = "You may copy under some circumstances, for example you may copy a portion for research or study. Order a copy. Contact us for further information about copying.";
                break;
            case "1.2":
                message = "You may order a copy through Copies Direct or use the online copy for research or study; for other uses contact us.";
                break; 
            case "2.1":
                message = "You may order a copy through Copies Direct or use the online copy for research or study; for other uses contact us.";
                break;
            case "1.3": 
                message = "You may have full rights to copy, or may be able to copy only under some circumstances, for example a portion for research or study. Contact us for further information about copying."; 
                break;
            case "2.2":
                message = "Copyright varies with each issue and article. You may have full rights to copy, or may be able to copy only under some circumstances, for example a portion for research or study. Order a copy where circumstances allow or contact us for further information.";
                break;
            case "3": 
                break;
            case "4": 
                message = "This collection may have multiple rights owners; If you wish to copy or order copies, Contact us.";
                break;
            case "5": 
                message = "You may order a copy or use the online copy for research or study; for other uses Contact us."; 
                break;
            case "6":
                message = "Contact us for information about copying.";
                break;
            case "7": 
                message = "Contact us for information about copying."; 
                break;
            case "8": 
                message = "You may order a copy for research or study; for other uses Contact us."; 
                break;
            default:
                break;
        }        
        return message;        
    }
}