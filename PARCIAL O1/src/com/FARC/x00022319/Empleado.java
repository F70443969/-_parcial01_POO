package com.FARC.x00022319;

import java.util.ArrayList;

public abstract class  Empleado {

    static protected String nombre, puesto;
    static protected double salario = 0;
    static protected ArrayList<Documento> documentos = new ArrayList<>();

    public Empleado(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", puesto='" + puesto + '\'' +
                ", salario=" + salario +
                ", documentos=" + documentos +
                "}\n";
    }

    public static void addDocumento(Documento x){
        documentos.add(x);
    }


}