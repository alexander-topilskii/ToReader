package dto;

public class StickyElement {
    private String name;
    private String type;
    private String minOccurs;
    private Prefix prefix;
    private Annotation annotation;
    private String maxOccurs;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public String getMinOccurs() {
        return minOccurs;
    }

    public void setMinOccurs(String value) {
        this.minOccurs = value;
    }

    public Prefix getPrefix() {
        return prefix;
    }

    public void setPrefix(Prefix value) {
        this.prefix = value;
    }

    public Annotation getAnnotation() {
        return annotation;
    }

    public void setAnnotation(Annotation value) {
        this.annotation = value;
    }

    public String getMaxOccurs() {
        return maxOccurs;
    }

    public void setMaxOccurs(String value) {
        this.maxOccurs = value;
    }
}
