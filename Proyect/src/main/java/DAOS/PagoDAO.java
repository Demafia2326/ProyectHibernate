/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import Model.Colaborador;
import Model.Conexion;
import Model.Pago;
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
public class PagoDAO {
    public static Conexion miConexion = Conexion.getInstance();
    

    public static ResultSet mostrar(int cod) throws SQLException {     //Que pida un nombre y lo busque
        int nFilas = 0;
        String lineaSQL = "Select * from pago WHERE codigo LIKE '%"+ cod +"%';" ;
        ResultSet resultado = Conexion.getInstance().execute_Select(lineaSQL);
       
        return resultado;
        
    }
    
    public static boolean crear(int num,String conc,int cant,String fp,String nif) throws SQLException, ParseException {          
        
        
            
            boolean insertados = true;
            int i;
            Pago cob;
            //Cadena donde irán las sentencias sql de creación de tablas
            String lineaSQL;
            //Objeto de tipo Statement
            Statement sentencia = null;
            Date fechai=(Date) new SimpleDateFormat("dd/MM/yyyy").parse(fp);
            //comando sql generico para la inserción
            lineaSQL = "INSERT INTO pago (id, numero, concepto,cantidad,fecha_pago,nif_colaborador) values (NULL, ?, ?,?,?,?)";
            
                
                
                //conectamos el objeto preparedStmt a la base de datos
                PreparedStatement preparedStmt = miConexion.getConexion().prepareStatement(lineaSQL);
                
                //creamos un nuevo socio
                cob = new Pago(num, conc,cant,fechai);
                
                
                
                preparedStmt.setInt(1, cob.getNumero());
                preparedStmt.setString(2, cob.getConcepto());
                preparedStmt.setInt(3, cob.getCantidad());
                preparedStmt.setDate(4, cob.getFechaPago());
                preparedStmt.setString(5, nif);
                
                
                
                
                // la ejecutamos
                preparedStmt.execute();
                
                
                // habría que cerrar la conexion
                
            
        
            
            return insertados;
            
      
        

    }
    
    public static ResultSet mostrarTodos() throws SQLException {     
        int nFilas = 0;
        String lineaSQL = "Select * from pago;" ;
        ResultSet resultado = Conexion.getInstance().execute_Select(lineaSQL);
        
        return resultado;
        
    }
    
    
    public static void modificar(int id,String name) throws SQLException{
               
        String lineaSQL="UPDATE pago SET concepto='"+name+"' WHERE codigo="+id+";";
        Conexion.getInstance().execute_All(lineaSQL);      
    }
    
    
    public static void borrar(int id) throws SQLException {   
        
            String lineaSQL = "DELETE FROM pago WHERE codigo LIKE '"+id+"';" ;
            Conexion.getInstance().execute_All(lineaSQL);

    }
}
