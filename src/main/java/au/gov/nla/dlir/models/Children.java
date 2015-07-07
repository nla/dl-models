package au.gov.nla.dlir.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Children {
	
	@JsonProperty("page")
	private List<Page> pages;
	 
	@JsonProperty("article")
	private List<Article> articles;
	
	@JsonProperty("chapter")
	private List<Chapter> chapters;
	
	@JsonProperty("book")
    private List<Work> books;
	
	@JsonProperty("volume")
    private List<Work> volumes;
	
	@JsonProperty("manuscript")
    private List<Work> manuscripts;
	
	@JsonProperty("other")
    private List<Work> others;

	public List<Work> getManuscripts() {
        return manuscripts;
    }

    public void setManuscripts(List<Work> manuscripts) {
        this.manuscripts = manuscripts;
    }

    public List<Page> getPages() {
		return pages;
	}
	
	public Boolean hasPages() {
	    if (getPages() != null && getPages().size() > 0) {
	        return true;
	    } else {
	        return false;
	    }
	}
	
	public void setPages(List<Page> pages) {
		this.pages = pages;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public List<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}

    public List<Work> getBooks() {
        return books;
    }

    public void setBooks(List<Work> books) {
        this.books = books;
    }

    public List<Work> getVolumes() {
        return volumes;
    }

    public void setVolumes(List<Work> volumes) {
        this.volumes = volumes;
    }

    public List<Work> getOthers() {
        return others;
    }

    public void setOthers(List<Work> others) {
        this.others = others;
    }
    
    public Boolean hasOthers() {
        if (getOthers() != null && getOthers().size() > 0) {
            return true;
        } else {
            return false;
        }
    }

}
