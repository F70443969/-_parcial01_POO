package com.DEMS.x00139419;

import javax.swing.*;
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

    public static void setSalario(double salario) {
        Empleado.salario = salario;


    }
    public static void removeDocumento(String nombre) {
            try{    if(documentos.isEmpty()){
                JOptionPane.showMessageDialog(null, "La lista de documentos esta vacia.");
            }else{  final String finalNombre = nombre;
                documentos.removeIf(s->s.equals(finalNombre));};
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ha introducido un valor invalido intentelo de nuevo");}
        }
        }




