package au.gov.nla.dlir.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class RelatedDocs {
    List<RelatedDocument> documents;
   
    public List<RelatedDocument> getTranscripts() {
        return documents;
    }

    public void setTranscripts(List<RelatedDocument> transcripts) {
        this.documents = transcripts;
    }
}