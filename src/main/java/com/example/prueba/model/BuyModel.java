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
    String destino ;
    String remitente;

    public BuyModel( String documento, String tipo, long valor, String destino, String remitente) {
        this.documento = documento;
        this.tipo = tipo;
        this.valor = valor;
        this.destino = destino;
        this.remitente = remitente;

    }

    public BuyModel() {}

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

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }


}
