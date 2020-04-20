package com.DEMS.x00139419;

public class Documento {
    private String nommbre, numero;

    public Documento(String nommbre, String numero) {
        this.nommbre = nommbre;
        this.numero = numero;
    }

    public String getNommbre() {
        return nommbre;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Documento{" +
                "nommbre='" + nommbre + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
