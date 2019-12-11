/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Daniel Pérez Ramírez
 */
public class Conexion {
    private static Connection miConexion;
    private static String host; //Host que contiene la BBDD
    private static String bbdd; //Nombre de la BBDD
    private static String login; //Login 
    private static String password; //Password
    //LAS VARIABLES ESTATICAS NO SE PUEDEN USAR EN LA CLASE CON "THIS" SINO QUE HAY QUE 
    //HAY QUE INSTANCIARLOS CON LA CLASE PARA PODER USARLOS
    private static boolean estado;
    private static Conexion instance=null;
    
    private Conexion(){
        this.estado=false;
        this.conectar();
    }
    
    public static Conexion getInstance(){
        if(instance == null){
            try{
                /*  
                Singleton sin valor => tenemos que instanciar.
                Se evitara que esta clase sea utilizada por otra usando un singleton
                pasandole como datos (server,user,password,db)
                Utilizaremos un archivo XML para coger esos datos para que cuando lo
                tengamos que cambiar lo haremos atraves de este archivo
                */
                Conexion.getConf();
            }catch(ParserConfigurationException | SAXException | IOException | TransformerException ex){
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            instance = new Conexion();
        }
        return instance;
    }
    
    
    public static boolean conectar(){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            //Driver para la conexion a la base de datos

            //conexion normal

            Conexion.miConexion= DriverManager.getConnection("jdbc:mysql://"+Conexion.host+"/"+Conexion.bbdd+"?allowMultiQueries=true&user="+Conexion.login+"&password="+Conexion.password);
         
            //conexión completa para evitar errores de sincronizacion con el servidor
            //miConexion= DriverManager.getConnection("jdbc:mysql://"+this.host+"/"+this.bbdd+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user= "+this.login+"&password=S"+this.password);
            //miConexion = DriverManager.getConnection("jdbc:mysql://localhost/policia", "root", "");

            Conexion.estado=true;
            } 
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return estado;

    }
    
    public Connection getConexion(){
        return miConexion;
    }
    public boolean getEstado(){
	return estado;		
    }
    public boolean cerrarConexion() throws Exception{
        boolean seCerro=false;
        try{
            this.miConexion.close();
            seCerro=true;

        }catch(SQLException se){
                se.printStackTrace();
        }
        return seCerro;
		
    }
    
    private static void getConf() throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException{
        File file=new File(".\\bbdd.xml");
        DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        if (doc.hasChildNodes()) {
            NodeList nodeList = doc
                    .getDocumentElement()
                    .getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    switch (node.getNodeName()) {
                        case "host":
                            Conexion.host = node.getTextContent();
                            break;
                        case "bbdd":
                            Conexion.bbdd = node.getTextContent();
                            break;
                        case "login":
                            Conexion.login = node.getTextContent();
                            break;
                        case "password":
                            Conexion.password = node.getTextContent();
                            break;
                    }
                }                
            }
        }
    }
    
    public ResultSet execute_Select(String sql) throws SQLException{
            Statement sentencia;
            
            sentencia = this.getConexion().createStatement();
            //ejecutamos la sentencia;
            return sentencia.executeQuery(sql);
    }
    
    public void execute_All(String sql) throws SQLException{
            boolean aply = false;
            Statement sentencia;
            
            sentencia = this.getConexion().createStatement();
            sentencia.executeUpdate(sql);
            aply = true;   
    }
    
    
    
}
