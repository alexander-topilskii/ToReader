package dto;

import java.io.IOException;

public enum Ref {
    XLINK_HREF, XLINK_TYPE, XML_LANG;

    public String toValue() {
        switch (this) {
            case XLINK_HREF:
                return "xlink:href";
            case XLINK_TYPE:
                return "xlink:type";
            case XML_LANG:
                return "xml:lang";
        }
        return null;
    }

    public static Ref forValue(String value) throws IOException {
        if (value.equals("xlink:href")) return XLINK_HREF;
        if (value.equals("xlink:type")) return XLINK_TYPE;
        if (value.equals("xml:lang")) return XML_LANG;
        throw new IOException("Cannot deserialize Ref");
    }
}
