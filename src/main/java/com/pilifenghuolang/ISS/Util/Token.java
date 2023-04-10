package com.pilifenghuolang.ISS.Util;

import lombok.Data;

@Data
public class Token {

    private String token;

    public Token(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return token;
    }
}
