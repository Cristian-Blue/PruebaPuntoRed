package com.example.prueba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaccion")
public class BuyModel {

    @Id
    int id_trasaccion;
    String documento;
    String tipo;
    long valor;
    String destion ;
    long telefono;

    public int getId_trasaccion() {return id_trasaccion;}

    public void setId_trasaccion(int id_trasaccion) {this.id_trasaccion = id_trasaccion;}

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public String getDestion() {
        return destion;
    }

    public void setDestion(String destion) {
        this.destion = destion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }


}
