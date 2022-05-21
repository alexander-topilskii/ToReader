package dto;

public class IndigoElement {
    private String name;
    private String type;
    private Prefix prefix;
    private Annotation annotation;
    private TentacledComplexType complexType;
    private String maxOccurs;
    private String minOccurs;

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

    public Annotation getAnnotation() {
        return annotation;
    }

    public void setAnnotation(Annotation value) {
        this.annotation = value;
    }

    public TentacledComplexType getComplexType() {
        return complexType;
    }

    public void setComplexType(TentacledComplexType value) {
        this.complexType = value;
    }

    public String getMaxOccurs() {
        return maxOccurs;
    }

    public void setMaxOccurs(String value) {
        this.maxOccurs = value;
    }

    public String getMinOccurs() {
        return minOccurs;
    }

    public void setMinOccurs(String value) {
        this.minOccurs = value;
    }
}
