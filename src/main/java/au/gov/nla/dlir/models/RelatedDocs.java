package au.gov.nla.dlir.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class RelatedDocs {
    List<RelatedDocument> docs;
    
    public List<RelatedDocument> getDocs() {
        return docs;
    }

    public void setDocs(List<RelatedDocument> documents) {
        this.docs = documents;
    }
}