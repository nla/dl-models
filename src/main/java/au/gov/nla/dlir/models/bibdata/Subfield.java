package au.gov.nla.dlir.models.bibdata;

public class Subfield {
    private String content;
    private String code;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Subfield{" +
                "content='" + content + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
