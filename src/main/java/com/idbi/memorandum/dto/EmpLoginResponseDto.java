package com.idbi.memorandum.dto;

public class EmpLoginResponseDto {

    private String token;

    public EmpLoginResponseDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}

