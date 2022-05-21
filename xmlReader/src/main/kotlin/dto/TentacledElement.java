package dto;

public class TentacledElement {
    private Annotation annotation;
    private String name;
    private String type;
    private Prefix prefix;
    private String minOccurs;
    private FluffyComplexType complexType;
    private String maxOccurs;

    public Annotation getAnnotation() {
        return annotation;
    }

    public void setAnnotation(Annotation value) {
        this.annotation = value;
    }

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

    public Prefix getPrefix() {
        return prefix;
    }

    public void setPrefix(Prefix value) {
        this.prefix = value;
    }

    public String getMinOccurs() {
        return minOccurs;
    }

    public void setMinOccurs(String value) {
        this.minOccurs = value;
    }

    public FluffyComplexType getComplexType() {
        return complexType;
    }

    public void setComplexType(FluffyComplexType value) {
        this.complexType = value;
    }

    public String getMaxOccurs() {
        return maxOccurs;
    }

    public void setMaxOccurs(String value) {
        this.maxOccurs = value;
    }
}
