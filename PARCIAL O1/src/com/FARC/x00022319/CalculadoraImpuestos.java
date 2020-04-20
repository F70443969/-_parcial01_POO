package com.FARC.x00022319;

public final class CalculadoraImpuestos {
    private static double TOTALRenta = 0, TOTALISSS = 0, TOTALAFP = 0;

    public CalculadoraImpuestos() {
    }

    public static double calcularPago(Empleado Worker) {
        double renta = 0, ISSS = 0, AFP = 0;
        double salario = 0;

        if (Worker instanceof ServicioProfesional) {

            renta = 0.1 * Worker.getSalario();
            salario = Worker.getSalario()- renta;
            TOTALRenta = TOTALRenta + renta;

        }
        if (Worker instanceof PlazaFija) {

            AFP = 0.0625 * Worker.getSalario();
            ISSS = 0.03*Worker.getSalario();
            salario = Worker.getSalario()- AFP - ISSS;

            TOTALAFP = TOTALAFP + AFP;
            TOTALISSS = TOTALISSS + ISSS;

            if( salario >= 0.01 && salario <= 472.00){
                renta = 0;
                salario = salario - renta;
                TOTALRenta = TOTALRenta + renta;
            }
            if(salario >= 472.01 && salario <= 895.24){
                renta = 0.1 * (salario - 472) + 17.67;
                salario = salario - renta;
                TOTALRenta = TOTALRenta + renta;
            }

            if(salario >= 895.25 && salario <= 2038.10){
                renta = 0.2 * (salario - 895.24) + 60;
                salario = salario - renta;
                TOTALRenta = TOTALRenta + renta;
            }

            if(salario >= 2038.11){
                renta = 0.3 * (salario - 2038.10);
                salario = salario - renta;
                TOTALRenta = TOTALRenta + renta;
            }

        }
        return salario;
    }

