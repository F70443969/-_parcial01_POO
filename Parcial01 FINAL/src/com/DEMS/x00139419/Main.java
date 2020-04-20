package com.DEMS.x00139419;

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
    // fin de main

    public static String NombreEmpresa(){return "Bienvenido\n" +
            "Digite el nombre de la empresa: ";};

    public static String Menu(){return "1. Agregar empleado\n" +
            "2. Despedir empleado\n" +
            "3. Ver lista de empleados\n" +
            "4. Calcular Sueldo\n" +
            "5. Mostar totales\n" +
            "0. Cerrar";};

    public static String servicioOplaza(){return "Bienvenido\n" +
            "1. Servicio profesional\n" +
            "2. Plaza Fija ";};

    public static String dariaError(){return "No se digito una opcion valida.\n" +
            "Regresando....";}

    public static Empleado addServicioProfesionales(){

        nombreM();
        PuestoM();
        salarioM();
        mesesDeContratoM();
        return new ServicioProfesional(nombre, puesto, salario, mesesDeContrato);
    }

    public static Empleado addPlazafija(){
        nombreM();
        PuestoM();
        salarioM();
        extensionM();
        return new PlazaFija(nombre, puesto, salario, extension);
    }

    public static void pedir(){
        try { opc2 = Byte.parseByte(JOptionPane.showInputDialog(null, Menu()));
            opc = opc2;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha introducido un caracter/valor invalido intentelo de nuevo");
            pedir();}; }


    public static void salarioM(){
        try { salario = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite el salario: "));
            if(salario <= 0){JOptionPane.showMessageDialog(null, "Enserio gana " + salario+ "?" );
            salarioM();}else{};}
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha introducido un caracter/valor invalido intentelo de nuevo");
            salarioM();}; }

    public static void extensionM(){
        try { extension = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite en numero de telefono: "));
            if(extension <= 0){JOptionPane.showMessageDialog(null, "Enserio su numero es negativo?" );
                extensionM();}else{};}
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha introducido un caracter/valor invalido intentelo de nuevo");
            extensionM();}; }

    public static void mesesDeContratoM(){
        try {
            mesesDeContrato = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la cantidad de meses de contrato: "));

            if (mesesDeContrato <=0) { JOptionPane.showMessageDialog(null, "No se puede trabajar en tiempo negativo o si?");

                mesesDeContratoM();
            } else{}
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha introducido un caracter/valor invalido intentelo de nuevo");
            mesesDeContratoM();};
    }

    public static void PuestoM(){
        try{   puesto = JOptionPane.showInputDialog(null, "Digite el puesto del empleado:");
            if(puesto.equals("")){JOptionPane.showMessageDialog(null, "No trabaja aqui o como?");
                PuestoM();}else{};}catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ha introducido un valor invalido intentelo de nuevo");

        }}

    public static void nombreM(){
        try {nombre = JOptionPane.showInputDialog(null, "Digite el nombre del empleado:");
            if (nombre.equals("")) {  JOptionPane.showMessageDialog(null, "Enserio no tiene nombre?");
                nombreM();
            } else{}}catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ha introducido un valor invalido intentelo de nuevo");
            nombreM();
    }}

    public static void opcServicioOPlazaM(){
        try { opcServicioOPlaza = Byte.parseByte(JOptionPane.showInputDialog(null, servicioOplaza()));

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha introducido un caracter/valor invalido intentelo de nuevo");
            opcServicioOPlazaM();}
    }

    public static void nombreE() {
        try {

            nombreEmpresa = JOptionPane.showInputDialog(null, "Digite el nombre de su empresa:");

            if (nombreEmpresa.equals("")){

                opc2 = Byte.parseByte(JOptionPane.showInputDialog(null, "Seguro que su empresa no tiene nombre?\n" +
                        "1. Si\n" +
                        "0. No"));

                switch (opc2) {
                    case 0:
                        nombreE();
                    case 1:
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Digite una opcion valida");
                        break;
                }


                ;
            }else{}}catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ni superman oculta tanto su identidad" );

            nombreE();
    }};



}//fin de proyecto


//      try{}catch(ConcurrentModificationException e){J}