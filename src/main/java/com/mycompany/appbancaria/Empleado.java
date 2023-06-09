package com.mycompany.appbancaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Empleado {
     String url = "jdbc:postgresql://localhost:5432/AppBancaria";
     String user = "postgres";
     String password = "root";
     
     private String numEmpleado;
     private String nombre;
     private String apellidos;
     private String puesto;
     private float sueldo;
     public String getNumEmpleado() {
          return numEmpleado;
     }
     public void setNumEmpleado(String numEmpleado) {
          this.numEmpleado = numEmpleado;
     }
     public String getNombre() {
          return nombre;
     }
     public void setNombre(String nombre) {
          this.nombre = nombre;
     }
     public String getApellidos() {
          return apellidos;
     }
     public void setApellidos(String apellidos) {
          this.apellidos = apellidos;
     }
     public String getPuesto() {
          return puesto;
     }
     public void setPuesto(String puesto) {
          this.puesto = puesto;
     }
     public float getSueldo() {
          return sueldo;
     }
     public void setSueldo(float sueldo) {
          this.sueldo = sueldo;
     }
     
     public ResultSet viewEmployed() {
          ResultSet rs = null;
          try{
               Connection conn= DriverManager.getConnection(url, user, password);
               PreparedStatement select = conn.prepareStatement("SELECT *"
                       + "FROM empleados");
               rs = select.executeQuery();
          }catch( Exception e){
               JOptionPane.showMessageDialog(null,"Error: "+ e);
          }
          return rs;
     }
}
