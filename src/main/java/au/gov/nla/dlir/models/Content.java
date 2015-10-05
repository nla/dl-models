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

    @JsonProperty("my_parent_id")
    private List<String> myParentId;

    private List<String> format;
    private List<String> callnumber;
    private List<String> edition;
    
    @JsonProperty("physical")
    private List<String> physical;   
    
    @JsonProperty("description")
    private List<String> description;
    
    @JsonProperty("pages")
    private List<String> pages;
    
    @JsonProperty("pi")
    private Object piObj;
    
    private String pi; 
    private List<String> publisher;
    private String title;
    
    private String printer;
    
    private List<String> summary;
    private String reproduction;
    
    private List<String> subject;
    
    @JsonProperty("date_lower")
    private String dateLower;
    
    @JsonProperty("date_upper")
    private String dateUpper;
    
    private String language;
    
    @JsonProperty("language_code")
    private String languageCode;
    
    @JsonProperty("my_parent")
    private String myParent;
    
    @JsonProperty("publish_date")
    private List<String> publishDates;
    
    private String publishDate;
    
    private String author;
    
    @JsonProperty("other_author")
    private List<String> otherAuthor;
    
    @JsonProperty("author_with_relator")
    private List<String> authorWithRelator;
    
    @JsonProperty("other_author_with_relator")
    private List<String> otherAuthorWithRelator;
    
    @JsonProperty("publisher_place")
    private List<String> publisherPlace;
    
   
    private String collection;
    private List<String> notes;
    
    @JsonProperty("title_start")
    private String titleStart;
   
    
    @JsonProperty("url_the_work")
    private List<Url> urlTheWork;
    
    @JsonProperty("url_copy_of")
    private List<Url> urlCopyOf;
    
    @JsonProperty("973_related_record")
    private String RelatedRecord973;
    
    @JsonProperty("973_w")
    private String field973w;
    
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
      // do something: put to a Map; log a warning, whatever
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getFormat() {
        return format;
	}

	public void setFormat(Object value) {
        this.format = convertToList(value);
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

	public List<String> getSubject() {
		return subject;
	}

	public void setSubject(Object value) {
		this.subject = convertToList(value);
	}

	public String getDateLower() {
		return dateLower;
	}

	public void setDateLower(String dateLower) {
		this.dateLower = dateLower;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getMyParent() {
		return myParent;
	}

	public void setMyParent(String myParent) {
		this.myParent = myParent;
	}

	public String getPublishDate() {
	    
	    if (publishDate != null) {
            return publishDate;
        }
        
        if (publishDates != null && publishDates.size() > 0 && 
            citedYears != null & citedYears.size() > 0) {
            return citedYears.get(0);
        }
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public List<String> getAuthorWithRelator() {
		return authorWithRelator;
	}

	public void setAuthorWithRelator(Object value) {
		this.authorWithRelator = convertToList(value);
	}

	public List<String> getDescription() {
		return description;
	}

	public void setDescription(Object description) {
		this.description = convertToList(description);
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public List<String> getNotes() {
		return notes;
	}

	public void setNotes(Object value) {
		this.notes = convertToList(value);
	}

	public String getTitleStart() {
		return titleStart;
	}

	public void setTitleStart(String titleStart) {
		this.titleStart = titleStart;
	}

	public List<String> getPages() {
		return pages;
	}

	public void setPages(Object pages) {
		this.pages = convertToList(pages);
	}

	public String getRelatedRecord973() {
		return RelatedRecord973;
	}

	public void setRelatedRecord973(String relatedRecord973) {
		RelatedRecord973 = relatedRecord973;
	}

	public String getField973w() {
		return field973w;
	}

	public void setField973w(String field973w) {
		this.field973w = field973w;
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

	public List<Url> getUrlTheWork() {
		return urlTheWork;
	}

	public void setUrlTheWork(List<Url> urlTheWork) {
		this.urlTheWork = urlTheWork;
	}

	public List<String> getOtherAuthor() {
		return otherAuthor;
	}

	public void setOtherAuthor(Object value) {
		this.otherAuthor = convertToList(value);
	}

	public List<String> getOtherAuthorWithRelator() {
		return otherAuthorWithRelator;
	}

	public void setOtherAuthorWithRelator(Object value) {
		this.otherAuthorWithRelator = convertToList(value);
	}

	public List<String> getEdition() {
		return edition;
	}

	public void setEdition(List<String> edition) {
		this.edition = edition;
	}

	public String getPrinter() {
		return printer;
	}

	public void setPrinter(String printer) {
		this.printer = printer;
	}

	public String getDateUpper() {
		return dateUpper;
	}

	public void setDateUpper(String dateUpper) {
		this.dateUpper = dateUpper;
	}
	
	public String getReproduction() {
		return reproduction;
	}

	public void setReproduction(String reproduction) {
		this.reproduction = reproduction;
	}

	public List<String> getMyParentId() {
		return myParentId;
	}

	public void setMyParentId(Object value) {
		this.myParentId = convertToList(value);
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

    public List<String> getPublisherPlace() {
        return publisherPlace;
    }

    public void setPublisherPlace(List<String> publisherPlace) {
        this.publisherPlace = publisherPlace;
    }

    public List<String> getSummary() {
        return summary;
    }

    public void setSummary(List<String> summary) {
        this.summary = summary;
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

    public String getPi() {
        if (pi != null) {
            return pi;
        }     
    
        // only populate pi if String not ArrayList<E>
        if(piObj instanceof String) {
            pi = (String)piObj;
        }        
        
        return pi;
    }

    public List<String> getBioHistories() {
        return bioHistories;
    }

    public void setBioHistories(List<String> bioHistories) {
        this.bioHistories = bioHistories;
    }

    public Object getPiObj() {
        return piObj;
    }

    public void setPiObj(Object pis) {
        this.piObj = pis;
    }

    public List<String> getPhysical() {        
        return physical;
    }

    public void setPhysicals(Object physical) {
        this.physical = convertToList(physical);
    }	
}
