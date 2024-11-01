package com.example.prueba.dto;

public class BuyDTO {

    private String message;
    private String transactionalID;
    private String cellPhone;
    private String value;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTransactionalID() {
        return transactionalID;
    }

    public void setTransactionalID(String transactionalID) {
        this.transactionalID = transactionalID;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
