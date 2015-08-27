package au.gov.nla.dlir.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Transcripts {
    List<RelatedDocument> transcripts;
   
    public List<RelatedDocument> getTranscripts() {
        return transcripts;
    }

    public void setTranscripts(List<RelatedDocument> transcripts) {
        this.transcripts = transcripts;
    }
}