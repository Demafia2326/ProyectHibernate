/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import Model.Cliente;
import Model.Conexion;
import Model.Proyecto;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.h2.engine.Session;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

/**
 *
 * @author Daniel Pérez Ramírez
 */
public class ProyectoDAO {
    public static Conexion miConexion= Conexion.getInstance();
    Session session;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static ResultSet mostrar(int cod) throws SQLException {     //Que pida un nombre y lo busque
        int nFilas = 0;
        String lineaSQL = "SELECT proyecto.codigo, proyecto.descripcion, proyecto.fecha_inicio, proyecto.fecha_fin, "
                + "proyecto.cuantia, cliente.num_social FROM proyecto LEFT JOIN cliente ON proyecto.cod_cliente = cliente.codigo "
                + "WHERE proyecto.codigo LIKE '%"+ cod +"%';" ;
        ResultSet resultado = Conexion.getInstance().execute_Select(lineaSQL);
       
        return resultado;
        
    }
    
    public static boolean crear(String descripcion,String fecha_inicio, String fecha_fin, int cuantia, int cod_cliente) throws SQLException, ParseException {          
        
        boolean insertados = true;
        int i;
        
        Date fechai=(Date) new SimpleDateFormat("dd/MM/yyyy").parse(fecha_inicio);
        Date fechaf=(Date) new SimpleDateFormat("dd/MM/yyyy").parse(fecha_fin);
        Proyecto cd;
        //Cadena donde irán las sentencias sql de creación de tablas
        String lineaSQL;
        //Objeto de tipo Statement
        Statement sentencia = null;
        Cliente c = new Cliente();
        c.setCodigo(cod_cliente);

        //comando sql generico para la inserción
        lineaSQL = "INSERT INTO cliente (codigo, descripcion ,fecha_inicio, fecha_fin, cuantia, cod_cliente) values (NULL, ?, ?, ?, ?, ? )";
        try {
                 
            
            //conectamos el objeto preparedStmt a la base de datos
            PreparedStatement preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);

            //creamos un nuevo socio
            cd = new Proyecto(descripcion, fechai, fechaf,cuantia,c);

          
                
                preparedStmt.setString(1, cd.getDescripcion());
                preparedStmt.setDate(2, cd.getFechaInicio());
                preparedStmt.setDate(3, cd.getFechaFin());
                preparedStmt.setInt(4, cd.getCuantia());
                preparedStmt.setInt(5, cod_cliente);
                
                               
                
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
        String lineaSQL = "SELECT proyecto.codigo, proyecto.descripcion, proyecto.fecha_inicio, proyecto.fecha_fin, "
                + "proyecto.cuantia, cliente.num_social FROM proyecto LEFT JOIN cliente ON proyecto.cod_cliente = cliente.codigo" ;
        ResultSet resultado = Conexion.getInstance().execute_Select(lineaSQL);
        
        return resultado;
        
    }
    
    
    public static void modificar(int id,String descrip,String fini, String ffin) throws SQLException{
               
       
        try {
            Date fechai = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(fini);
            Date fechaf = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(ffin);
            
            String lineaSQL="UPDATE proyecto SET descripcion='"+descrip+"', fecha_inicio='"+fechai+"', fecha_fin='"+fechaf+"' WHERE codigo="+id+";";
            Conexion.getInstance().execute_All(lineaSQL);  
        } catch (ParseException ex) {
            Logger.getLogger(ProyectoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
            
    }
    
    
    public static void borrar(int id) throws SQLException {   
        
            String lineaSQL = "DELETE FROM proyecto WHERE codigo LIKE '"+id+"';" ;
            Conexion.getInstance().execute_All(lineaSQL);

    }
}
