package com.DEMS.x00139419;

public class PlazaFija extends Empleado {
    private int extension = 0;

    public PlazaFija(String nombre, String puesto, double salario, int extension) {
        super(nombre, puesto, salario);
        this.extension = extension;
    }

}
