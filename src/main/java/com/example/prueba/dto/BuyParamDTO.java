package com.example.prueba.dto;

public class BuyParamDTO {

    private String cellPhone;
    private String value;
    private String supplierId;

    public BuyParamDTO(String cellPhone, String value, String supplierId) {
        this.cellPhone = cellPhone;
        this.value = value;
        this.supplierId = supplierId;
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

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }
}
