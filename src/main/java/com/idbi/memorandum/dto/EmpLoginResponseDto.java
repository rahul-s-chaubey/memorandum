package com.idbi.memorandum.dto;

public class EmpLoginResponseDto {

    private String message;
    private String token;

    public EmpLoginResponseDto(String message, String token) {
        this.message = message;
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }
}
