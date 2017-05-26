package Model;



public class Gladiadores {
    
    private int Id; 
    private String Nombre;
    private String Descripcion;
    private int Precio;
    private int Victorias;
    private int Derrotas;
    private int Fuerza;
    private int Agilidad;
    private int Vitalidad;
    private int Propietario;
    private int Defensa;
    
    
    
    
    // id es auto incrementable no hace falta ponerla en el constructor, de momento
    public Gladiadores(int Id,String Nombre,String Descripcion, int Precio, int Victorias, int Derrotas, int Fuerza, int Agilidad, int Vitalidad,int Defensa, int Propietario){
    
    this.Id = Id;
    this.Nombre=Nombre;
    this.Precio=Precio;
    this.Victorias=Victorias;
    this.Derrotas=Derrotas;
    this.Descripcion=Descripcion;
    this.Fuerza=Fuerza;
    this.Agilidad=Agilidad;
    this.Vitalidad=Vitalidad;
    this.Defensa=Defensa;
    this.Propietario=Propietario;
    
    
    }
    
    public Gladiadores(){
    
    }

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    /**
     * @return the Precio
     */
    public int getPrecio() {
        return Precio;
    }

    /**
     * @param Precio the Precio to set
     */
    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    /**
     * @return the Victorias
     */
    public int getVictorias() {
        return Victorias;
    }

    /**
     * @param Victorias the Victorias to set
     */
    public void setVictorias(int Victorias) {
        this.Victorias = Victorias;
    }

    /**
     * @return the Derrotas
     */
    public int getDerrotas() {
        return Derrotas;
    }

    /**
     * @param Derrotas the Derrotas to set
     */
    public void setDerrotas(int Derrotas) {
        this.Derrotas = Derrotas;
    }

    /**
     * @return the Fuerza
     */
    public int getFuerza() {
        return Fuerza;
    }

    /**
     * @param Fuerza the Fuerza to set
     */
    public void setFuerza(int Fuerza) {
        this.Fuerza = Fuerza;
    }

    /**
     * @return the Agilidad
     */
    public int getAgilidad() {
        return Agilidad;
    }

    /**
     * @param Agilidad the Agilidad to set
     */
    public void setAgilidad(int Agilidad) {
        this.Agilidad = Agilidad;
    }

    /**
     * @return the Vitalidad
     */
    public int getVitalidad() {
        return Vitalidad;
    }

    /**
     * @param Vitalidad the Vitalidad to set
     */
    public void setVitalidad(int Vitalidad) {
        this.Vitalidad = Vitalidad;
    }

    /**
     * @return the Propietario
     */
    public int getPropietario() {
        return Propietario;
    }

    /**
     * @param Propietario the Propietario to set
     */
    public void setPropietario(int Propietario) {
        this.Propietario = Propietario;
    }

    /**
     * @return the Defensa
     */
    public int getDefensa() {
        return Defensa;
    }

    /**
     * @param Defensa the Defensa to set
     */
    public void setDefensa(int Defensa) {
        this.Defensa = Defensa;
    }
    
    
    
}
