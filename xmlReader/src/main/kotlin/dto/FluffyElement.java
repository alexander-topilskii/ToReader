package dto;

public class FluffyElement {
    private String name;
    private String type;
    private Prefix prefix;
    private String minOccurs;
    private String maxOccurs;
    private Annotation annotation;
    private PurpleComplexType complexType;

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

    public String getMaxOccurs() {
        return maxOccurs;
    }

    public void setMaxOccurs(String value) {
        this.maxOccurs = value;
    }

    public Annotation getAnnotation() {
        return annotation;
    }

    public void setAnnotation(Annotation value) {
        this.annotation = value;
    }

    public PurpleComplexType getComplexType() {
        return complexType;
    }

    public void setComplexType(PurpleComplexType value) {
        this.complexType = value;
    }
}
