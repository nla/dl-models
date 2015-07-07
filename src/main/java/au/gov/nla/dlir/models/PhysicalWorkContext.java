package au.gov.nla.dlir.models;

import java.util.LinkedHashMap;

public class PhysicalWorkContext {

    private LinkedHashMap<String, String> physicalContext;

    public PhysicalWorkContext(LinkedHashMap<String, String> physicalContext) {
        this.physicalContext = physicalContext;
    }

    public LinkedHashMap<String, String> getPhysicalContext() {
        return physicalContext;
    }

    public void setPhysicalContext(LinkedHashMap<String, String> physicalContext) {
        this.physicalContext = physicalContext;
    }
}
