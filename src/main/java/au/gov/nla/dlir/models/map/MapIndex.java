package au.gov.nla.dlir.models.map;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class MapIndex {
    private static final String MAP_COPY_ROLE_INDEX = "i";
    private static final String MAP_COPY_ROLE_FLIGHT_DIAGRAM = "fd";
    
    private String pid;
    private List<String> copyRole;
    private boolean hasIndexCopy;
    private boolean hasFlightDiagramCopy;
    private String interactiveHtml;
    private List<Neighbour> navigation;
    private String collection;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public List<String> getCopyRole() {
        return copyRole;
    }

    public void setCopyRole(List<String> copyRole) {
        this.copyRole = copyRole;
        populateCopyRoleFlags(copyRole);
    }

    private void populateCopyRoleFlags(List<String> copyRole) {
        if (copyRole != null && !copyRole.isEmpty()) {
            if (copyRole.contains(MAP_COPY_ROLE_INDEX)) {
                setHasIndexCopy(true);
            }

            if (copyRole.contains(MAP_COPY_ROLE_FLIGHT_DIAGRAM)) {
                setHasFlightDiagramCopy(true);
            }
        }
    }

    public boolean isHasIndexCopy() {
        return hasIndexCopy;
    }

    public void setHasIndexCopy(boolean hasIndexCopy) {
        this.hasIndexCopy = hasIndexCopy;
    }

    public boolean isHasFlightDiagramCopy() {
        return hasFlightDiagramCopy;
    }

    public void setHasFlightDiagramCopy(boolean hasCopyRoleFlightDiagram) {
        this.hasFlightDiagramCopy = hasCopyRoleFlightDiagram;
    }

    public String getInteractiveHtml() {
        return interactiveHtml;
    }

    public void setInteractiveHtml(String interactiveHtml) {
        this.interactiveHtml = interactiveHtml;
    }

    public List<Neighbour> getNavigation() {
        return navigation;
    }

    public void setNavigation(List<Neighbour> navigation) {
        this.navigation = navigation;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }
}
