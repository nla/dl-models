package au.gov.nla.dlir.models;

public class Copies {

	private String copyrole;
	private String filename;
	private Technicalmetadata technicalmetadata;
	private String width;
	private String height;
	private String filesize;
	
	public String getCopyrole() {
		return copyrole;
	}
	public void setCopyrole(String copyrole) {
		this.copyrole = copyrole;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Technicalmetadata getTechnicalmetadata() {
		return technicalmetadata;
	}
	public void setTechnicalmetadata(Technicalmetadata technicalmetadata) {
		this.technicalmetadata = technicalmetadata;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
    public String getFilesize() {
        return filesize;
    }
    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

}
