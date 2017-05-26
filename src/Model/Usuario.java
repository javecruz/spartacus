package Model;


import java.sql.Timestamp;



public class Usuario {
    
    
    private int Id;
    private String Nombre;
    private String Apellidos;
    private int Permisos;
    private int Saldo;
    private int Victorias;
    private int Derrotas;
    private String Login;
    private String Pass;
    private float ratio;
    
    
    
    // id es auto incrementable no hace falta ponerla en el constructor, de momento
public Usuario(String Nombre,String Apellidos, int Permisos, int Saldo, int Victorias, int Derrotas,float ratio, String Login, String Pass){

this.Nombre=Nombre;
this.Apellidos =Apellidos;
this.Permisos=Permisos;
this.Saldo=Saldo;
this.Victorias=Victorias;
this.Derrotas=Derrotas;
this.ratio=ratio;
this.Login=Login;
this.Pass=Pass;

}

public Usuario(){

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
     * @return the Permisos
     */
    public int getPermisos() {
        return Permisos;
    }

    /**
     * @param Permisos the Permisos to set
     */
    public void setPermisos(int Permisos) {
        this.Permisos = Permisos;
    }

    /**
     * @return the Saldo
     */
    public int getSaldo() {
        return Saldo;
    }

    /**
     * @param Saldo the Saldo to set
     */
    public void setSaldo(int Saldo) {
        this.Saldo = Saldo;
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
     * @return the Login
     */
    public String getLogin() {
        return Login;
    }

    /**
     * @param Login the Login to set
     */
    public void setLogin(String Login) {
        this.Login = Login;
    }

    /**
     * @return the Pass
     */
    public String getPass() {
        return Pass;
    }

    /**
     * @param Pass the Pass to set
     */
    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    /**
     * @return the Apellidos
     */
    public String getApellidos() {
        return Apellidos;
    }

    /**
     * @param Apellidos the Apellidos to set
     */
    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    /**
     * @return the ratio
     */
    public float getRatio() {
        return ratio;
    }

    /**
     * @param ratio the ratio to set
     */
    public void setRatio(float ratio) {
        this.ratio = ratio;
    }
    
}
