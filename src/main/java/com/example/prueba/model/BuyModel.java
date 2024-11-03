package com.example.prueba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TRANSACCION")
public class BuyModel {

    @Id
    String id_trasaccion;
    String usuario;
    long valor;
    String telefono ;

    public BuyModel( String id_trasaccion,  String usuario, long valor, String telefono) {
        this.usuario = usuario;
        this.id_trasaccion = id_trasaccion;
        this.valor = valor;
        this.telefono = telefono;

    }

    public BuyModel() {}

    public String getId_trasaccion() {return id_trasaccion;}

    public void setId_trasaccion(String id_trasaccion) {this.id_trasaccion = id_trasaccion;}

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
