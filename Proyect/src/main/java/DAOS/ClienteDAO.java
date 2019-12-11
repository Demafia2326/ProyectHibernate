/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import Model.Cliente;
import Model.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Daniel Pérez Ramírez
 */
public class ClienteDAO {
    public static Conexion miConexion= Conexion.getInstance();
    
    public static ResultSet mostrar(int num) throws SQLException {     //Que pida un nombre y lo busque
        int nFilas = 0;
        String lineaSQL = "Select * from cliente WHERE num_social LIKE '%"+ num +"%';" ;
        ResultSet resultado = Conexion.getInstance().execute_Select(lineaSQL);
       
        return resultado;
        
    }
    
    public static boolean crear(int num_so,String domicilio,int tlf) throws SQLException {          
        
        boolean insertados = true;
        int i;
        Cliente cd;
        //Cadena donde irán las sentencias sql de creación de tablas
        String lineaSQL;
        //Objeto de tipo Statement
        Statement sentencia = null;

        //comando sql generico para la inserción
        lineaSQL = "INSERT INTO cliente (codigo, num_social, domicilio, telefono) values (NULL, ?, ?, ? )";
        try {
                 
            
            //conectamos el objeto preparedStmt a la base de datos
            PreparedStatement preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);

            //creamos un nuevo socio
            cd = new Cliente(num_so, domicilio, tlf);

          
                
                preparedStmt.setInt(1, cd.getNumSocial());
                preparedStmt.setString(2, cd.getDomicilio());
                preparedStmt.setInt(3, cd.getTelefono());
                               
                
                // la ejecutamos
                preparedStmt.execute();

              
            // habría que cerrar la conexion
          
        } catch (SQLException se) {
            insertados = false;
            se.printStackTrace();
        }

        return insertados;

    }
    
    public static ResultSet mostrarTodos() throws SQLException {     
        int nFilas = 0;
        String lineaSQL = "SELECT cliente.codigo, cliente.num_social, cliente.domicilio, cliente.telefono, proyecto.descripcion "
                + "FROM cliente LEFT JOIN proyecto ON cliente.codigo = proyecto.cod_cliente;" ;
        ResultSet resultado = Conexion.getInstance().execute_Select(lineaSQL);
        
        return resultado;
        
    }
    
    
    public static void modificar(int id,int num,String dom,int telefono) throws SQLException{
               
        String lineaSQL="UPDATE cliente SET num_social='"+num+"', domicilio='"+dom+"', telefono='"+telefono+"' WHERE codigo="+id+";";
        Conexion.getInstance().execute_All(lineaSQL);      
    }
    
    
    public static void borrar(int num, int id) throws SQLException {   
        
            String lineaSQL = "DELETE FROM cliente WHERE num_social LIKE '"+num+"' OR codigo LIKE '"+id+"';" ;
            Conexion.getInstance().execute_All(lineaSQL);

    }
}
