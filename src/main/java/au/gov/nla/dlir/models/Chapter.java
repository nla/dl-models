package au.gov.nla.dlir.models;

import java.util.List;

import au.gov.nla.dlir.util.Strings;

public class Chapter implements Comparable<Object> {
	
	private String id;
	private String pid;
	private String subType;
	private String subUnitType = "";
	private String subUnitNo = "";
	private String title;
	private List<ExistsOn> existson;
	private Integer startPageIndex; // starting page number for display
	private String startPagePid; // starting page pid for display
	
	/**
	 * Specifically used to compare chapters for order
	 * but requires startPageIndex to be populated
	 */
	@Override
    public int compareTo(Object object) {       	    
	    Chapter chapter = (Chapter)object;
	    if (startPageIndex < chapter.getStartPageIndex()) {
	        return -1;
	    } else if (startPageIndex > chapter.getStartPageIndex()) {
	        return 1;
	    } else {	 
	        String t1 = (title == null ? "" : title);
	        String t2 = (chapter.getTitle() == null ? "" : chapter.getTitle());
	        return Strings.compareNaturalIgnoreCaseAscii(t1, t2);
	    }
    } 
	public Integer getStartPageIndex() {
        return startPageIndex;
    }
    public void setStartPageIndex(Integer startPageIndex) {
        this.startPageIndex = startPageIndex;
    }
    public String getStartPagePid() {
        return startPagePid;
    }
    public void setStartPagePid(String startPagePid) {
        this.startPagePid = startPagePid;
    }    	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPid() {
	    return pid;
	}
	public void setPid(String pid) {
	    this.pid = pid;
	}
	public String getSubType() {
		return subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<ExistsOn> getExistson() {
		return existson;
	}
	public void setExistson(List<ExistsOn> existson) {
		this.existson = existson;
	}
    public String getSubUnitType() {
        return subUnitType;
    }
    public void setSubUnitType(String subUnitType) {
        this.subUnitType = subUnitType;
    }
    public String getSubUnitNo() {
        return subUnitNo;
    }
    public void setSubUnitNo(String subUnitNo) {
        this.subUnitNo = subUnitNo;
    } 

}
