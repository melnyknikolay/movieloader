package com.movieloader.omdb.client.api.dto;

import java.io.Serializable;

/**
 * Created by nikmlk on 03.04.17.
 */
public class Rating implements Serializable {
    private static final long serialVersionUID = -7821581381469250614L;

    private String Source;
    private String Value;

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
