package au.gov.nla.dlir.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;

public class PhysicalWorkContext {

    private static Logger log = LoggerFactory.getLogger(PhysicalWorkContext.class);

    private LinkedHashMap<String, String> physicalContext;

    public PhysicalWorkContext(LinkedHashMap<String, String> physicalContext) {
        this.physicalContext = physicalContext;
    }

    public static PhysicalWorkContext loadFromUrl(String url) {
        return loadWork(url);
    }

    private static PhysicalWorkContext loadWork(String url) {
        RestTemplate rt = new RestTemplate();
        try {
            LinkedHashMap<String, String> physicalContext = rt.getForObject(url, LinkedHashMap.class);
            if (physicalContext == null || physicalContext.isEmpty()) {
                return null;
            }
            return new PhysicalWorkContext(physicalContext);
        }
        catch (RestClientException rce) {
            log.warn("Could not retrieve physical context.", rce);
        }
        return null;
    }

    public LinkedHashMap<String, String> getPhysicalContext() {
        return physicalContext;
    }

    public void setPhysicalContext(LinkedHashMap<String, String> physicalContext) {
        this.physicalContext = physicalContext;
    }
}
