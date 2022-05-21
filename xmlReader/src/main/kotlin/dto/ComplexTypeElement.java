package dto;

public class ComplexTypeElement {
    private Annotation annotation;
    private StickySequence sequence;
    private ComplexTypeAttributeUnion attribute;
    private String name;
    private Prefix prefix;
    private FluffyComplexContent complexContent;
    private ChoiceElement choice;
    private TentacledSimpleContent simpleContent;
    private String mixed;

    public Annotation getAnnotation() {
        return annotation;
    }

    public void setAnnotation(Annotation value) {
        this.annotation = value;
    }

    public StickySequence getSequence() {
        return sequence;
    }

    public void setSequence(StickySequence value) {
        this.sequence = value;
    }

    public ComplexTypeAttributeUnion getAttribute() {
        return attribute;
    }

    public void setAttribute(ComplexTypeAttributeUnion value) {
        this.attribute = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public Prefix getPrefix() {
        return prefix;
    }

    public void setPrefix(Prefix value) {
        this.prefix = value;
    }

    public FluffyComplexContent getComplexContent() {
        return complexContent;
    }

    public void setComplexContent(FluffyComplexContent value) {
        this.complexContent = value;
    }

    public ChoiceElement getChoice() {
        return choice;
    }

    public void setChoice(ChoiceElement value) {
        this.choice = value;
    }

    public TentacledSimpleContent getSimpleContent() {
        return simpleContent;
    }

    public void setSimpleContent(TentacledSimpleContent value) {
        this.simpleContent = value;
    }

    public String getMixed() {
        return mixed;
    }

    public void setMixed(String value) {
        this.mixed = value;
    }
}
