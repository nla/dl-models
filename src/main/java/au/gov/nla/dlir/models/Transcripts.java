package au.gov.nla.dlir.models;

import java.util.List;

public class Transcripts {
    List<RelatedDocument> transcripts;
   
    public List<RelatedDocument> getTranscripts() {
        return transcripts;
    }

    public void setTranscripts(List<RelatedDocument> transcripts) {
        this.transcripts = transcripts;
    }
}