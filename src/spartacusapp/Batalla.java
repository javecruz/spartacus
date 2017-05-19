package spartacusapp;

import java.sql.Date;

public class Batalla {
    
    int Id; // id arena
    int Id1; // id gladiador que invita
    int Id2;  // id gladiador que es invitado
    int Ganador; // id del ganador
    Date Fecha; //fecha del combate
    int Premio; // cantidad de oro ganado

    // id es auto incrementable no hace falta ponerla en el constructor, de momento
    public Batalla(int Id1, int Id2, int Ganador, Date Fecha, int Premio){
    
   
    this.Id1=Id1;
    this.Id2=Id2;
    this.Ganador=Ganador;
    this.Fecha=Fecha;
    this.Premio=Premio;
    
 
    }
    
    
    
}
