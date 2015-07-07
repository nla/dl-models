package au.gov.nla.dlir.models;

import java.util.List;

public class Article {
	
	private String id;
	private String subType;
	private String subUnitType = "";
	private String subUnitNo = "";
	private String pid;
	private String title;
	private String creator;
	private String category;
	private List<ExistsOn> existson;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<ExistsOn> getExistson() {
		return existson;
	}
	public void setExistson(List<ExistsOn> existson) {
		this.existson = existson;
	}
    public String getSubUnitNo() {
        return subUnitNo;
    }
    public void setSubUnitNo(String subUnitNo) {
        this.subUnitNo = subUnitNo;
    }
    public String getSubUnitType() {
        return subUnitType;
    }
    public void setSubUnitType(String subUnitType) {
        this.subUnitType = subUnitType;
    }

}
