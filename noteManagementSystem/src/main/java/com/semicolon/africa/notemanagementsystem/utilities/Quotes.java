package com.semicolon.africa.notemanagementsystem.utilities;


import lombok.Getter;
import lombok.Setter;

@Getter
public enum Quotes {
    RATE_US("Rate our app over 10"),
    WHY_DELETE("why are you deleting this note"),
    EXPERIENCE("what can we change to make your Experience better");

    private final String quotes;

    Quotes(String quotes) {
        this.quotes = quotes;
    }
    public String getQuotes(){
        return quotes;
    }

}
