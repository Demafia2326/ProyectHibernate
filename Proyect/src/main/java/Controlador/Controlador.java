/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAOS.ClienteDAO;
import DAOS.ColaboradorDAO;
import DAOS.PagoDAO;
import DAOS.ProyectoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel Pérez Ramírez
 */
public class Controlador {

    public static Scanner scan = new Scanner(System.in);

    public static ResultSet mostrarCliente() throws SQLException {

        System.out.println("¿Desea mostrar todos o solo buscar por numero_social?");
        System.out.println("1.- Por Numero_Social");
        System.out.println("2.- Todos");
        int op = scan.nextInt();
        ResultSet resultado = null;

        switch (op) {
            case 1:
                Scanner scn = new Scanner(System.in);
                System.out.println("Especifique el nombre de la Sede que desea inspeccionar");
                int num = scn.nextInt();
                resultado = ClienteDAO.mostrar(num);
                break;
            case 2:
                resultado = ClienteDAO.mostrarTodos();
                break;
        }
        return resultado;

    }

    public static boolean crearCliente() throws SQLException {
        boolean yep = false;
        Scanner scn = new Scanner(System.in);

        System.out.println("Introduzca su Num_social");
        int num = scan.nextInt();

        System.out.println("Introduzca domicilio de residencia ");
        String dom = scn.nextLine();

        System.out.println("Introduzca su Presupuesto");
        int tlf = scan.nextInt();

        if ("".equals(num)) {
            System.out.println("Non comand recibed");
        } else {
            ClienteDAO.crear(num, dom, tlf);
            yep = true;
        }
        return yep;
    }

    public static boolean modificarCliente() throws SQLException {
        boolean yep = false;
        Scanner scn = new Scanner(System.in);

        System.out.println("Introduzca el ID del cliente que vaya a cambiar");
        int id = scn.nextInt();

        System.out.println("Introduzca num_social");
        int num = scan.nextInt();

        System.out.println("Introduzca el nombre: ");
        String dom = scan.nextLine();

        System.out.println("Introduzca nuevo telefono");
        int tlf = scan.nextInt();

        if (("".equals(num)) || ("".equals(id))) {
            System.out.println("Non comand recibed");
        } else {
            ClienteDAO.modificar(id, num, dom, tlf);
            yep = true;
        }

        return yep;

    }

    public static boolean borrarCliente() throws SQLException {
        boolean yep = false;
        Scanner scn = new Scanner(System.in);

        System.out.println("Introduzca el nombre: ");
        int num = scan.nextInt();

        System.out.println("Introduzca la id");
        int id = scan.nextInt();

        if (("".equals(num)) || ("".equals(id))) {
            System.out.println("Non comand recibed");
        } else {
            ClienteDAO.borrar(num, id);
            yep = true;
        }

        return yep;

    }

    /*
     _____________________________________________________________________________________________________________________________________________________________
     */
    
    public static ResultSet mostrarProyecto() throws SQLException {

        System.out.println("¿Desea mostrar todos o solo buscar por numero_social?");
        System.out.println("1.- Por Numero_Social");
        System.out.println("2.- Todos");
        int op = scan.nextInt();
        ResultSet resultado = null;

        switch (op) {
            case 1:
                Scanner scn = new Scanner(System.in);
                System.out.println("Especifique el codigo del Proyecto que desea inspeccionar");
                int num = scn.nextInt();
                resultado = ProyectoDAO.mostrar(num);
                break;
            case 2:
                resultado = ProyectoDAO.mostrarTodos();
                break;
        }
        return resultado;

    }

    public static boolean crearProyecto() throws SQLException {
        boolean yep = false;
        Scanner scn = new Scanner(System.in);

        System.out.println("Introduzca Descripcion del proyecto");
        String des = scan.nextLine();

        System.out.println("Introduzca una fecha de Inicio/De no introducir una se generara la de este dia");
        String fi = scan.nextLine();

        System.out.println("Introduzca su Fecha de finalizacion estimada");
        String ff = scan.nextLine();
        
        System.out.println("Introduzca un telefono");
        int tlf = scn.nextInt();
        
        System.out.println("Introduzca el codigo de un CLIENTE");
        int c = scn.nextInt();

        if ("".equals(tlf)) {
            System.out.println("Non comand recibed");
        } else {
            try {
                ProyectoDAO.crear(des, fi, ff,tlf,c);
                yep = true;
            } catch (ParseException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return yep;
    }

    public static boolean modificarProyecto() throws SQLException {
        boolean yep = false;
        Scanner scn = new Scanner(System.in);

        System.out.println("Introduzca el ID del Proyecto que vaya a cambiar");
        int id = scn.nextInt();

        System.out.println("Introduzca La nueva descripcion");
        String des = scan.nextLine();

        System.out.println("Introduzca Nueva fecha de inicio");
        String fi = scan.nextLine();

        System.out.println("Introduzca nueva fecha Final (Haga lo mismo con PMD Porfavor)");
        String ff = scan.nextLine();

        if (("".equals(ff)) || ("".equals(id))) {
            System.out.println("Non comand recibed");
        } else {
            ProyectoDAO.modificar(id,des,fi, ff);
            yep = true;
        }

        return yep;

    }

    public static boolean borrarProyecto() throws SQLException {
        boolean yep = false;
        Scanner scn = new Scanner(System.in);

        

        System.out.println("Introduzca la id");
        int id = scan.nextInt();

        if ("".equals(id)) {
            System.out.println("Non comand recibed");
        } else {
            ProyectoDAO.borrar( id);
            yep = true;
        }

        return yep;

    }

    /*
     _____________________________________________________________________________________________________________________________________________________________
     */
    
    
     public static ResultSet mostrarColab() throws SQLException {

        System.out.println("¿Desea mostrar todos o solo buscar por numero_social?");
        System.out.println("1.- Por Numero_Social");
        System.out.println("2.- Todos");
        int op = scan.nextInt();
        ResultSet resultado = null;

        switch (op) {
            case 1:
                Scanner scn = new Scanner(System.in);
                System.out.println("Especifique el codigo del Colaborador que desea inspeccionar");
                int num = scn.nextInt();
                resultado = ColaboradorDAO.mostrar(num);
                break;
            case 2:
                resultado = ColaboradorDAO.mostrarTodos();
                break;
        }
        return resultado;

    }

    public static boolean crearColab() throws SQLException {
        boolean yep = false;
        Scanner scn = new Scanner(System.in);

        System.out.println("Introduzca Nombre");
        String des = scan.nextLine();

        System.out.println("Introduzca un domicilio valido");
        String fi = scan.nextLine();

        System.out.println("Introduzca Banco");
        String ff = scan.nextLine();
        
        System.out.println("Introduzca Numero de su cuente (TOTALMENTE SEGURO COMO VERA)");
        int num = scan.nextInt();
        
        System.out.println("Introduzca su NIF");
        String nif = scan.nextLine();
        
        System.out.println("Introduzca un telefono");
        int tlf = scn.nextInt();

        if ("".equals(tlf)) {
            System.out.println("Non comand recibed");
        } else {
            ColaboradorDAO.crear(des, fi, ff,num,nif,tlf);
            yep = true;
        }
        return yep;
    }

    public static boolean modificarColab() throws SQLException {
        boolean yep = false;
        Scanner scn = new Scanner(System.in);

        System.out.println("Introduzca el ID del Colaborador");
        int id = scn.nextInt();

        System.out.println("Introduzca Nuevo nombre");
        String des = scan.nextLine();

        System.out.println("Introduzca Nuevo domicilio");
        String fi = scan.nextLine();

        

        if ("".equals(id)) {
            System.out.println("Non comand recibed");
        } else {
            ColaboradorDAO.modificar(id,des,fi);
            yep = true;
        }

        return yep;

    }

    public static boolean borrarColab() throws SQLException {
        boolean yep = false;
        Scanner scn = new Scanner(System.in);

        

        System.out.println("Introduzca la id");
        int id = scan.nextInt();

        if ("".equals(id)) {
            System.out.println("Non comand recibed");
        } else {
            ColaboradorDAO.borrar( id);
            yep = true;
        }

        return yep;

    }

    /*
     _____________________________________________________________________________________________________________________________________________________________
     */
    
    public static ResultSet mostrarPago() throws SQLException {

        System.out.println("¿Desea mostrar todos o solo buscar por numero_social?");
        System.out.println("1.- Por Numero_Social");
        System.out.println("2.- Todos");
        int op = scan.nextInt();
        ResultSet resultado = null;

        switch (op) {
            case 1:
                Scanner scn = new Scanner(System.in);
                System.out.println("Especifique el codigo del Pago que desea inspeccionar");
                int num = scn.nextInt();
                resultado = PagoDAO.mostrar(num);
                break;
            case 2:
                resultado = PagoDAO.mostrarTodos();
                break;
        }
        return resultado;

    }

    public static boolean crearPago() throws SQLException {
        boolean yep = false;
        Scanner scn = new Scanner(System.in);

        System.out.println("Introduzca Numero de pago");
        int des = scan.nextInt();

        System.out.println("Introduzca concepto de pago");
        String fi = scn.nextLine();

        System.out.println("Introduzca Cantidad");
        int ff = scan.nextInt();
        
        System.out.println("Introduzca fecha de pago");
        String num = scn.nextLine();
        
        System.out.println("Introduzca el nif del Colaborador");
        String nif = scn.nextLine();
        
        

        if ("".equals(nif)) {
            System.out.println("Non comand recibed");
        } else {
            try {
                PagoDAO.crear(des, fi, ff,num,nif);
            } catch (ParseException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            yep = true;
        }
        return yep;
    }

    public static boolean modificarPago() throws SQLException {
        boolean yep = false;
        Scanner scn = new Scanner(System.in);

        System.out.println("Introduzca el ID del Colaborador");
        int id = scn.nextInt();

        

        System.out.println("Introduzca Nuevo Concepto");
        String fi = scan.nextLine();

        

        if ("".equals(id)) {
            System.out.println("Non comand recibed");
        } else {
            PagoDAO.modificar(id,fi);
            yep = true;
        }

        return yep;

    }

    public static boolean borrarPago() throws SQLException {
        boolean yep = false;
        Scanner scn = new Scanner(System.in);

        

        System.out.println("Introduzca la id");
        int id = scan.nextInt();

        if ("".equals(id)) {
            System.out.println("Non comand recibed");
        } else {
            PagoDAO.borrar( id);
            yep = true;
        }

        return yep;

    }
    
    
    

}
