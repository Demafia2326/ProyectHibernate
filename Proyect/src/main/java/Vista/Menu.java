/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import Model.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Daniel Pérez Ramírez
 */
public class Menu {

    private static Conexion newcon;

    public static void menuVista() throws InputMismatchException {
        newcon = Conexion.getInstance();

        if (newcon.conectar() != true) {
            System.out.println("Fallo al conectar con la base de datos");
        } else {
            System.out.println("Conexion satisfactoria");

            //if(EstructuraDAO.generarEstructura()){
            Scanner scan = new Scanner(System.in);
            int opcion = 0;

            do {
                System.out.println("1.- Opciones de Proyecto");
                System.out.println("2.- Opciones de Cliente");
                System.out.println("3.- Opciones de Colaborador");
                System.out.println("4.- Opciones de Pago");
                System.out.println("5.- Opciones de Participacion");
                System.out.println("0.- Salir");
                opcion = scan.nextInt();

                switch (opcion) {
                    case 1:
                        menuProyecto();
                        break;
                    case 2:
                        menuCliente();
                        break;
                    case 3:
                        menuColab();
                        break;
                    case 4:
                        menuPago();
                        break;
                    

                }

            } while (opcion > 0 && opcion < 6);

            //}
        }

    }

    private static void menuCliente() {
        Scanner scSede = new Scanner(System.in);
        int opcion = 0;
        try {
            do {
                System.out.println("1.- Añadir Cliente");
                System.out.println("2.- Modificar Cliente");
                System.out.println("3.- Borrar Cliente");
                System.out.println("4.- Mostrar los Clientes");

                opcion = scSede.nextInt();

                switch (opcion) {
                    case 1:
                        Scanner scan = new Scanner(System.in);
                        Scanner scn = new Scanner(System.in);

                        Controlador.crearCliente();
                        break;
                    case 2:
                        if (Controlador.modificarCliente()) {
                            System.out.println("Clinete modificado CORRECTAMENTE");
                        } else {
                            System.out.println("ERROR");
                        }
                        break;
                    case 3:
                        Controlador.borrarCliente();
                        break;
                    case 4:
                        ResultSet resultado;
                        int nFilas = 0;
                        resultado = Controlador.mostrarCliente();
                        System.out.println("LISTADO DE Cliente");
                        System.out.println("ID   Num_Social    Domicilio    Telefono    Descripcion de Proyectos");
                        while (resultado.next()) {
                            nFilas++;
                            System.out.println(resultado.getInt("codigo") + "   " + resultado.getString("num_social") + "   " + resultado.getString("domicilio") + "      " + resultado.getString("telefono") + "        " + resultado.getString("descripcion"));

                        }//SELECT cliente.codigo, cliente.num_social, cliente.domicilio, cliente.telefono, proyecto.descripcion FROM cliente INNER JOIN proyecto ON cliente.codigo = proyecto.cod_cliente
                        System.out.println("Se han mostrado " + nFilas + " Notas apuntadas");
                        break;
                }
            } while (opcion < 0 && opcion > 5);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private static void menuProyecto() {
        Scanner scSede = new Scanner(System.in);
        int opcion = 0;
        try {
            do {
                System.out.println("1.- Añadir Proyecto");
                System.out.println("2.- Modificar Proyecto");
                System.out.println("3.- Borrar Proyecto");
                System.out.println("4.- Mostrar los Proyectos");

                opcion = scSede.nextInt();

                switch (opcion) {
                    case 1:
                        Scanner scan = new Scanner(System.in);
                        Scanner scn = new Scanner(System.in);

                        Controlador.crearProyecto();
                        break;
                    case 2:
                        if (Controlador.modificarProyecto()) {
                            System.out.println("Proyecto modificado CORRECTAMENTE");
                        } else {
                            System.out.println("ERROR");
                        }
                        break;
                    case 3:
                        Controlador.borrarProyecto();
                        break;
                    case 4:
                        ResultSet resultado;
                        int nFilas = 0;
                        resultado = Controlador.mostrarProyecto();
                        System.out.println("LISTADO DE Cliente");
                        System.out.println("ID   Descripcion    Fecha de Inicio    Fecha Final    Cuantia de proyecto       Cliente");
                        while (resultado.next()) {
                            nFilas++;
                            System.out.println(resultado.getInt("codigo") + "   " + resultado.getString("descripcion") + "   " + resultado.getTimestamp("fecha_inicio") + "      "
                                    + "" + resultado.getTimestamp("fecha_fin") + "        " + resultado.getInt("descripcion") + "     " + resultado.getInt("num_social"));

                        }//SELECT cliente.codigo, cliente.num_social, cliente.domicilio, cliente.telefono, proyecto.descripcion FROM cliente INNER JOIN proyecto ON cliente.codigo = proyecto.cod_cliente
                        System.out.println("Se han mostrado " + nFilas + " Notas apuntadas");
                        break;
                }
            } while (opcion < 0 && opcion > 5);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private static void menuColab() {
        Scanner scSede = new Scanner(System.in);
        int opcion = 0;
        try {
            do {
                System.out.println("1.- Añadir ");
                System.out.println("2.- Modificar ");
                System.out.println("3.- Borrar ");
                System.out.println("4.- Mostrar ");

                opcion = scSede.nextInt();

                switch (opcion) {
                    case 1:
                        Scanner scan = new Scanner(System.in);
                        Scanner scn = new Scanner(System.in);

                        Controlador.crearColab();
                        break;
                    case 2:
                        if (Controlador.modificarColab()) {
                            System.out.println("Proyecto modificado CORRECTAMENTE");
                        } else {
                            System.out.println("ERROR");
                        }
                        break;
                    case 3:
                        Controlador.borrarColab();
                        break;
                    case 4:
                        ResultSet resultado;
                        int nFilas = 0;
                        resultado = Controlador.mostrarColab();
                        
                        System.out.println("ID   Nombre    Domicilio    Banco    Num_Cuenta       Nif       Telefono");
                        while (resultado.next()) {
                            nFilas++;
                            System.out.println(resultado.getInt("codigo") + "   " + resultado.getString("nombre") + "   " + resultado.getString("domicilio") + "      "
                                    + "" + resultado.getString("banco") + "        " + resultado.getInt("num_cuenta") + "     " + resultado.getString("nif")+ "     "
                                    + "" + resultado.getInt("telefono"));

                        }//SELECT cliente.codigo, cliente.num_social, cliente.domicilio, cliente.telefono, proyecto.descripcion FROM cliente INNER JOIN proyecto ON cliente.codigo = proyecto.cod_cliente
                        
                        break;
                }
            } while (opcion < 0 && opcion > 5);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    
    private static void menuPago() {
        Scanner scSede = new Scanner(System.in);
        int opcion = 0;
        try {
            do {
                System.out.println("1.- Añadir ");
                System.out.println("2.- Modificar ");
                System.out.println("3.- Borrar ");
                System.out.println("4.- Mostrar ");

                opcion = scSede.nextInt();

                switch (opcion) {
                    case 1:
                        Scanner scan = new Scanner(System.in);
                        Scanner scn = new Scanner(System.in);

                        Controlador.crearPago();
                        break;
                    case 2:
                        if (Controlador.modificarPago()) {
                            System.out.println("Proyecto modificado CORRECTAMENTE");
                        } else {
                            System.out.println("ERROR");
                        }
                        break;
                    case 3:
                        Controlador.borrarPago();
                        break;
                    case 4:
                        ResultSet resultado;
                        int nFilas = 0;
                        resultado = Controlador.mostrarPago();
                        
                        System.out.println("ID   Numero    Concepto     Cantidad        Fecha_pago      Nif_colaborador");
                        while (resultado.next()) {
                            nFilas++;
                            System.out.println(resultado.getInt("codigo") + "   " + resultado.getInt("numero") + "   " + resultado.getString("concepto") + "      "
                                    + "" + resultado.getInt("cantidad") + "        " + resultado.getTimestamp("fecha_pago") + "     "
                                    + "" + resultado.getString("nif_colaborador"));

                        }//SELECT cliente.codigo, cliente.num_social, cliente.domicilio, cliente.telefono, proyecto.descripcion FROM cliente INNER JOIN proyecto ON cliente.codigo = proyecto.cod_cliente
                        
                        break;
                }
            } while (opcion < 0 && opcion > 5);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    
    
    
}
