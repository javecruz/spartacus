package Model;



public class Batalla {
    
    private int Id; // id arena
    private Gladiadores gladOwn; // id gladiador que invita
    private Gladiadores gladEne;  // id gladiador que es invitado
    private int idWin;

    // id es auto incrementable no hace falta ponerla en el constructor, de momento
    public Batalla(Gladiadores gladOwn, Gladiadores gladEne){
    
        this.gladOwn = gladOwn;
        this.gladEne = gladEne;
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
     * @return the gladOwn
     */
    public Gladiadores getGladOwn() {
        return gladOwn;
    }

    /**
     * @param gladOwn the gladOwn to set
     */
    public void setGladOwn(Gladiadores gladOwn) {
        this.gladOwn = gladOwn;
    }

    /**
     * @return the gladEne
     */
    public Gladiadores getGladEne() {
        return gladEne;
    }

    /**
     * @param gladEne the gladEne to set
     */
    public void setGladEne(Gladiadores gladEne) {
        this.gladEne = gladEne;
    }

    /**
     * @return the idWin
     */
    public int getIdWin() {
        return idWin;
    }

    /**
     * @param idWin the idWin to set
     */
    public void setIdWin(int idWin) {
        this.idWin = idWin;
    }
    
    
    
}
