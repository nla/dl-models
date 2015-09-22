package au.gov.nla.dlir.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class AcknowledgementList {
    List<Acknowledgement> acknowledgements;

    public List<Acknowledgement> getAcknowledgements() {
        return acknowledgements;
    }

    public void setAcknowledgements(List<Acknowledgement> acknowledgements) {
        this.acknowledgements = acknowledgements;
    }
}
