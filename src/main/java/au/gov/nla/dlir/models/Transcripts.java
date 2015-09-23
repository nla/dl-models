package au.gov.nla.dlir.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This is copied from RelatedDocs.java to fix tarkine compile issue in uat branch. NOTE: It should be deleted after 2nd
 * tarkine releases from today.
 * 
 * @author bsingh 23-sep-15
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transcripts {
    List<RelatedDocument> transcripts;

    public List<RelatedDocument> getTranscripts() {
        return transcripts;
    }

    public void setTranscripts(List<RelatedDocument> documents) {
        this.transcripts = documents;
    }

}
