package com.example.prueba.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class BuyParamDTO {

    @NotBlank
    @Pattern(regexp = "^3\\d{9}$", message = "El número debe ser de colombia")
    private String cellPhone;

    @NotBlank
    @Min(value = 1000, message = "Valor minimo de la trasancción {range.error}")
    @Max(value = 100000 , message = "Valor maximo de la transacción {range.error}")
    private String value;

    @NotBlank
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
