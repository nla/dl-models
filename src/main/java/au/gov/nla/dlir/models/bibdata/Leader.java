package au.gov.nla.dlir.models.bibdata;

public class Leader {
    private String content;
    private String type;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Leader{" +
                "content='" + content + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
