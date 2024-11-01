package com.example.prueba.dto;

public class ResponseDTO {


    boolean status;
    String message;
    Object data;

    public ResponseDTO(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseDTO(boolean status, Object data) {
        this.status = status;
        this.data = data;
    }

    public ResponseDTO(boolean status, String message , Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
