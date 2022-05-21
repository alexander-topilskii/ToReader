package dto;

import java.io.IOException;

public enum Prefix {
    XS;

    public String toValue() {
        switch (this) {
            case XS:
                return "xs";
        }
        return null;
    }

    public static Prefix forValue(String value) throws IOException {
        if (value.equals("xs")) return XS;
        throw new IOException("Cannot deserialize Prefix");
    }
}
