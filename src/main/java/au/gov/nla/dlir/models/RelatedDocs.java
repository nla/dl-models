package au.gov.nla.dlir.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class RelatedDocs {
    List<RelatedDocument> documents;
   
    public List<RelatedDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(List<RelatedDocument> documents) {
        this.documents = documents;
    }
}