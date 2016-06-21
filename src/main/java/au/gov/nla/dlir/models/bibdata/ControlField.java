package au.gov.nla.dlir.models.bibdata;

public class ControlField {
    private String tag;
    private String content;

    public ControlField(String tag, String content) {
        this.tag = tag;
        this.content = content;
    }

    public ControlField() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "ControlField{" +
                "content='" + content + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
