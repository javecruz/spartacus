package spartacusapp;



public class Gladiadores {
    
    int Id; 
    String Nombre;
    int Precio;
    int Victorias;
    int Derrotas;
    String Descripcion;
    int Fuerza;
    int Agilidad;
    int Vitalidad;
    int Propietario;
    
    
    // id es auto incrementable no hace falta ponerla en el constructor, de momento
    public Gladiadores(String Nombre, int Precio, int Victorias, int Derrotas, String Descripcion, int Fuerza, int Agilidad, int Vitalidad, int Propietario){
    
    
    this.Nombre=Nombre;
    this.Precio=Precio;
    this.Victorias=Victorias;
    this.Derrotas=Derrotas;
    this.Descripcion=Descripcion;
    this.Fuerza=Fuerza;
    this.Agilidad=Agilidad;
    this.Vitalidad=Vitalidad;
    this.Propietario=Propietario;
    
    
    }
    
    
    
    
}
