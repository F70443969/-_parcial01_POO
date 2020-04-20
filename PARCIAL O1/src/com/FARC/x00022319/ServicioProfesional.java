package com.FARC.x00022319;

public class ServicioProfesional extends Empleado {
    private int MesesContratado = 0;

    public ServicioProfesional(String nombre, String puesto, double salario, int mesesContratado) {
        super(nombre, puesto, salario);
        MesesContratado = mesesContratado;
    }
}