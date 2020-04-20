package com.FARC.x00022319;

import javax.swing.*;
import java.util.ConcurrentModificationException;

public class Main {

    static byte opc2 = 0, opc = 0, opcServicioOPlaza = 0;
    static String nombre, puesto, nombreEmpresa;
    static double salario = 0;
    static int mesesDeContrato = 0, extension = 0;

    public static void main(String[] args) {
        String nombre, puesto, nombreEmpleado;

        Empresa Objeto =  new Empresa(nombreEmpresa);

        nombreE();

        do {
            pedir();
            switch (opc) {
                case 1:

                    opcServicioOPlazaM();

                    switch (opcServicioOPlaza) {
                        case 1:
                            Objeto.addEmpleado(addServicioProfesionales());
                            break;
                        case 2:
                            Objeto.addEmpleado(addPlazafija());
                            break;
                        case 0:
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, dariaError());
                            break;
                    }
                    ;
                    break;


                case 2:
                    if (Objeto.getPlanilla().isEmpty()) {

                        JOptionPane.showMessageDialog(null, "La lista esta vacia, no hay empleados aun ");
                    } else {
                        nombre = JOptionPane.showInputDialog(null, "Digite el nombre de la persona que desea despedir: ");
                        try {
                            Objeto.quitEmpleado(nombre);
                        } catch (ConcurrentModificationException e) {
                            JOptionPane.showMessageDialog(null, "La lista esta vacia.");
                        }
                    }
                    break;

                case 3:

                    if (Objeto.getPlanilla().isEmpty()) {

                        JOptionPane.showMessageDialog(null, "La lista esta vacia ");
                    } else {
                        JOptionPane.showMessageDialog(null, Objeto.getPlanilla() + "\n");
                    }
                    break;
                case 4:
                    if (Objeto.getPlanilla().isEmpty()) {

                        JOptionPane.showMessageDialog(null, "La lista esta vacia, no se puede calcular el salario de 'nadie'");
                    } else {

                        nombre = JOptionPane.showInputDialog(null, "Digite el nombre de la persona que desea calcular el salario: ");

                        try {
                            final String nombreFinal = nombre;
                            for (Empleado i : Objeto.getPlanilla()) {
                                if (i.getNombre().equals(nombreFinal)) {
                                    JOptionPane.showMessageDialog(null, CalculadoraImpuestos.calcularPago(i));
                                }
                            }
                        } catch (ConcurrentModificationException e) {
                            JOptionPane.showMessageDialog(null, "La lista esta vacia.");
                        }
                    };




                    break;


                case 5:


                    if (Objeto.getPlanilla().isEmpty()) {

                        JOptionPane.showMessageDialog(null, "No se han inscrito ningun empleado, no se puede calcular el total de 'nada'");
                    } else {JOptionPane.showMessageDialog(null, CalculadoraImpuestos.MostrarTotales());
                    }


                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Cerrando...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, dariaError());
                    break;
            }

        } while (opc != 0);
    };