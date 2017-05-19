package spartacusapp;

import java.sql.Date;



public class Usuario {
    
    
    int Id;
    String Nombre;
    int Permisos;
    int Saldo;
    int Victorias;
    int Derrotas;
    Date Fecha;
    String Login;
    String Pass;
    
    
    
    // id es auto incrementable no hace falta ponerla en el constructor, de momento
public Usuario(String Nombre, int Permisos, int Saldo, int Victorias, int Derrotas, Date Fecha, String Login, String Pass){

this.Nombre=Nombre;
this.Permisos=Permisos;
this.Saldo=Saldo;
this.Victorias=Victorias;
this.Derrotas=Derrotas;
this.Fecha=Fecha;
this.Login=Login;
this.Pass=Pass;

}
    
}
