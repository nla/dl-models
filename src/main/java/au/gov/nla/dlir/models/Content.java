package au.gov.nla.dlir.models;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * There has been a hug problem with this class in DESERIALIZATION as the service
 * often returns single values as arrays. These are random.
 * @see WorkData where DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY is set to true.
 * This means that many single values are forced into an array.
 */
public class Content {
	
    private String id;

    private List<String> callnumber;

    @JsonProperty("description")
    private List<String> description;
    
    private List<String> publisher;
    private String title;
        
    @JsonProperty("publish_date")
    private List<String> publishDates;
    
    private String publishDate;
    
    private String author;
    
    @JsonProperty("cited_publisher_place")
    private String citedPublisherPlace;
    
    @JsonProperty("cited_publisher_name")
    private String citedPublisherName;
    
    @JsonProperty("cited_publisher")
    private String citedPublisher;
    
    @JsonProperty("cited_year")
    private List<String> citedYears;
    
    private String citedYear;
    
    @JsonProperty("cited_authors")
    private List<String> citedAuthors;
    
    @JsonProperty("cited_title")
    private String citedTitle;
    
    @JsonProperty("bio_history")
    private List<String> bioHistories;
    
    private String bioHistory;

    private List<String> summary;

    private List<String> isbn;
    private List<String> ismn;
    private List<String> issn;
    private List<String> otherStandardIds;
    private String scale;
    private String language;
    private String series;
    private String edition;
    private String issue;

    
    /**
     * To cater with instances where an Object could be a 
     * List<String> or a single.
     * 
     * Either returns the List or converts the String to
     * single item List.
     */
    @SuppressWarnings("unchecked")
	private List<String> convertToList(Object value) {
    	if (value instanceof Collection) {
            return (List<String>) value;
        } else {
            return (Arrays.asList((String) value));
        }
    }
    
    /**
     * Basically ignore unknown values
     * @param key
     * @param value
     */
    @JsonAnySetter
    public void handleUnknown(String key, Object value) {
      // Ignore unknown values
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


	public List<String> getCallnumber() {
		return callnumber;
	}

	public void setCallnumber(Object value) {		
		this.callnumber = convertToList(value);
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishDate() {
	    
	    if (publishDate != null) {
            return publishDate;
        }
        
        if (publishDates != null && publishDates.size() > 0 && 
            citedYears != null && citedYears.size() > 0) {
            return citedYears.get(0);
        }
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public List<String> getDescription() {
		return description;
	}

	public void setDescription(Object description) {
		this.description = convertToList(description);
	}

	public String getCitedPublisherPlace() {
		return citedPublisherPlace;
	}

	public void setCitedPublisherPlace(String citedPublisherPlace) {
		this.citedPublisherPlace = citedPublisherPlace;
	}

	public String getCitedPublisherName() {
		return citedPublisherName;
	}

	public void setCitedPublisherName(String citedPublisherName) {
		this.citedPublisherName = citedPublisherName;
	}

	public String getCitedPublisher() {
		return citedPublisher;
	}

	public void setCitedPublisher(String citedPublisher) {
		this.citedPublisher = citedPublisher;
	}

	/**
	 * Return citedYear or the first item of the citedYears
	 * @return
	 */
	public String getCitedYear() {
	    
	    if (citedYear != null) {
	        return citedYear;
	    }
	    
	    if (citedYears != null && citedYears.size() > 0) {
	        citedYear = citedYears.get(0);
	    }
	    
        return citedYear;
	}

	public void setCitedYear(String citedYear) {
		this.citedYear = citedYear;
	}

	public List<String> getCitedAuthors() {
		return citedAuthors;
	}

	public void setCitedAuthors(Object value) {
		this.citedAuthors = convertToList(value); 
	}

	public String getCitedTitle() {
		return citedTitle;
	}

	public void setCitedTitle(String citedTitle) {
		this.citedTitle = citedTitle;
	}

    public List<String> getPublishDates() {
        return publishDates;
    }

    public void setPublishDates(List<String> publishDates) {
        this.publishDates = publishDates;
    }

    public List<String> getCitedYears() {
        return citedYears;
    }

    public void setCitedYears(List<String> citedYears) {
        this.citedYears = citedYears;
    }

    public List<String> getPublisher() {
        return publisher;
    }

    public void setPublisher(List<String> publisher) {
        this.publisher = publisher;
    }

    public String getBioHistory() {
        if (bioHistory != null) {
            return bioHistory;
        }
        
        if (bioHistories != null && bioHistories.size() > 0) {
            bioHistory = bioHistories.get(0);
        }        
       
        return bioHistory;
    }

    public void setBioHistory(String bioHistory) {
        this.bioHistory = bioHistory;
    }

    public List<String> getBioHistories() {
        return bioHistories;
    }

    public void setBioHistories(List<String> bioHistories) {
        this.bioHistories = bioHistories;
    }

    public List<String> getSummary() {
        return summary;
    }

    public void setSummary(List<String> summary) {
        this.summary = summary;
    }

    public List<String> getIsbn() {
        return isbn;
    }

    public void setIsbn(List<String> isbn) {
        this.isbn = isbn;
    }

    public List<String> getIsmn() {
        return ismn;
    }

    public void setIsmn(List<String> ismn) {
        this.ismn = ismn;
    }

    public List<String> getIssn() {
        return issn;
    }

    public void setIssn(List<String> issn) {
        this.issn = issn;
    }

    public List<String> getOtherStandardIds() {
        return otherStandardIds;
    }

    public void setOtherStandardIds(List<String> otherStandardIds) {
        this.otherStandardIds = otherStandardIds;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }
}
