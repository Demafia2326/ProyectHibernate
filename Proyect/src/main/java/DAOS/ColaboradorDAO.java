/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import static DAOS.ProyectoDAO.miConexion;
import Model.Cliente;
import Model.Colaborador;
import Model.Conexion;
import Model.Proyecto;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.h2.engine.Session;

/**
 *
 * @author Daniel Pérez Ramírez
 */
public class ColaboradorDAO {

    public static Conexion miConexion = Conexion.getInstance();
    Session sesion;

    public static ResultSet mostrar(int cod) throws SQLException {     //Que pida un nombre y lo busque
        int nFilas = 0;
        String lineaSQL = "Select * from colaborador WHERE codigo LIKE '%"+ cod +"%';" ;
        ResultSet resultado = Conexion.getInstance().execute_Select(lineaSQL);
       
        return resultado;
        
    }
    
    public static boolean crear(String nombre, String domicilio,String banco,int num,String nif,int tlf) throws SQLException {          
        
        boolean insertados = true;
        int i;
        Colaborador cob;
        //Cadena donde irán las sentencias sql de creación de tablas
        String lineaSQL;
        //Objeto de tipo Statement
        Statement sentencia = null;

        //comando sql generico para la inserción
        lineaSQL = "INSERT INTO colaborador (id, nombre, domicilio,banco,num_cuenta,nif,telefono) values (NULL, ?, ?,?,?,?,?)";
        try {
                 
            
            //conectamos el objeto preparedStmt a la base de datos
            PreparedStatement preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);

            //creamos un nuevo socio
            cob = new Colaborador(nombre, domicilio, banco, num,nif,tlf);

          
                
                preparedStmt.setString(1, cob.getNombre());
                preparedStmt.setString(2, cob.getDomicilio());
                preparedStmt.setString(3, cob.getBanco());
                preparedStmt.setInt(4, cob.getNumCuenta());
                preparedStmt.setString(5, cob.getNif());
                preparedStmt.setInt(6, cob.getTelefono());
                
                               
                
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
        String lineaSQL = "Select * from colaborador;" ;
        ResultSet resultado = Conexion.getInstance().execute_Select(lineaSQL);
        
        return resultado;
        
    }
    
    
    public static void modificar(int id,String name,String domicilio) throws SQLException{
               
        String lineaSQL="UPDATE colaborador SET nombre='"+name+"', domicilio='"+domicilio+"' WHERE codigo="+id+";";
        Conexion.getInstance().execute_All(lineaSQL);      
    }
    
    
    public static void borrar(int id) throws SQLException {   
        
            String lineaSQL = "DELETE FROM codigo WHERE codigo LIKE '"+id+"';" ;
            Conexion.getInstance().execute_All(lineaSQL);

    }

}
