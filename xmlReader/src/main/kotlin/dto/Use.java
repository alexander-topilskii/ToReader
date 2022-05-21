package dto;

import java.io.IOException;

public enum Use {
    OPTIONAL, REQUIRED;

    public String toValue() {
        switch (this) {
            case OPTIONAL:
                return "optional";
            case REQUIRED:
                return "required";
        }
        return null;
    }

    public static Use forValue(String value) throws IOException {
        if (value.equals("optional")) return OPTIONAL;
        if (value.equals("required")) return REQUIRED;
        throw new IOException("Cannot deserialize Use");
    }
}
