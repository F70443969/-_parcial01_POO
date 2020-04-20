package com.FARC.x00022319;

import javax.swing.*;
import java.util.ArrayList;

public class Empresa {

    private static String Nombre;
    private static ArrayList<Empleado> planilla = new ArrayList<>();
    private static Empleado newEmpleado;
    private static int opc2 = 0;
    private static String nommbre, numero;
    public Empresa(String nombre) {
        Nombre = nombre;
    }

    public static void addEmpleado(Empleado newEmpleado){
        planilla.add(newEmpleado);

        AgregarDoc();

    }

    public static ArrayList<Empleado> getPlanilla() {
        return planilla;
    }

    public static void quitEmpleado(String nombre){
        final String nombreFinal = nombre;

        planilla.removeIf(s->s.getNombre().equals(nombreFinal));

        for(Empleado i : planilla){
            if(i.getNombre().equals(nombreFinal)){planilla.remove(i);
                JOptionPane.showMessageDialog(null, "se ha despedido ha esa persona");}else{JOptionPane.showMessageDialog(null, "No se a encontrado a "+ nombreFinal);};
        }}


    public static String getNombre() {
        return Nombre;
    }

    public static void AgregarDoc(){


        nombreM();
        numeroM();

        Documento worker2 = new Documento(nommbre,numero);
        newEmpleado.addDocumento(worker2);

    }

    public static void opc2(){
        try { do{
            opc2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea agreagr otro documento?\n" +
                    "1. Si\n" +
                    "0. No"));
            switch (opc2){ case 1:  AgregarDoc();
                break;
                case 0: break;
                default:JOptionPane.showMessageDialog(null, "Digite una opcion valida");
                    break;}
        }while(opc2 != 0);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha introducido un caracter/valor invalido intentelo de nuevo");
            opc2();}; }


    public static void nombreM(){
        try { nommbre = JOptionPane.showInputDialog(null, "Agregando documentos...\n" +
                "Digite el nombre del documento que desea agregar: ");
            if (nommbre.equals("")) {  JOptionPane.showMessageDialog(null, "Enserio no tiene DUI, no es salvadoreño o como?");
                nombreM();
            } else{}}catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ha introducido un valor invalido intentelo de nuevo");
            nombreM();
        }}

    public static void numeroM(){
        try { numero = JOptionPane.showInputDialog(null, "Agregando documentos...\n" +
                "Digite el numero del documento que desea agregar: ");
            if (numero.equals("")) {  JOptionPane.showMessageDialog(null, "Usted maneja el BoteMovil invisible o como?");
                numeroM();
            } else{}}catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ha introducido un valor invalido intentelo de nuevo");
            numeroM();
        }}


}