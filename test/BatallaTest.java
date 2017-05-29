
import Model.Gladiadores;
import java.util.concurrent.ThreadLocalRandom;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Javi
 */
public class BatallaTest {

    static int strOwn = 10;
    static int agiOwn = 9;
    static int defOwn = 8;
    static int vitOwn = 7;
    //static int vitOwnMax = vitOwn;
    static int ronda = 0;
    static int strEne = 10;
    static int agiEne = 9;
    static int defEne = 8;
    static int vitEne = 7;
    //static int vitEneMax = vitEne;

    
    static String texto = "";
    
    public static void main(String[] args) {

        
        do{ 
           
            ronda++;
            System.out.println("\nRonda: " + ronda);
            
        
          if(procesoStats(agiOwn,agiEne)==1){
              texto = texto.concat("ÉXITO, has ganado la tirada de agilidad atacas primero.\n");
              if(procesoStats(strOwn,defEne)==1){
                  texto = texto.concat("ÉXITO, has ganado la tirada de fuerza le inflinges 1 punto de daño.\n");
              vitEne--;           
              }else{
                  texto = texto.concat("FRACASO, el enemigo se ha defendido de tu ataque.\n");
              }

          } else {
              texto = texto.concat("FRACASO, el enemigo ha ganado la tirada de agilidad atacará primero.\n");
              if(procesoStats(defOwn,strEne)==2){
                  texto = texto.concat("FRACASO, el enemigo ha ganado la tirada de fuerza te hace 1 punto de daño.\n");
              vitOwn--;
              }else{
                  texto = texto.concat("ÉXITO, te has  defendido del ataque de tu enemigo.\n");
              }
          
          }
          
            
            texto = texto.concat("Vida Propia:" + vitOwn + " ---------- Vida Enemigo: " + vitEne +"\n\n");
            System.out.println(texto);
            texto = "";

        
        }while(vitOwn>0 && vitEne>0);
        
        
        if(vitOwn==0 && vitEne==0){
        
            System.out.println("OS HABEIS MATADO MUTUAMENTE EN LA ULTIMA RONDA");
        }else{
        
        if (vitOwn==0){
        
            System.out.println("HA GANADO EL ENEMIDO le has dejado a " + (vitEne) + " puntos de vida restante");
            
        }
        
        if (vitEne==0){
        
            System.out.println("HAS GANADO, te ha dejado a " + (vitOwn) + " puntos de vida restante");
            
        }
        
        }
        
        

    }

    public void procesoBatalla() {

    }

    public static int procesoStats(int statsOwn, int statsEne) {
        int unoRes;
        int dosRes;
        int ganador = 0; //1==own  2==eni

        do {
            unoRes = ThreadLocalRandom.current().nextInt(0, statsOwn + 1);
            dosRes = ThreadLocalRandom.current().nextInt(0, statsEne + 1);
            if (unoRes > dosRes) {
                ganador = 1;
            } else if (dosRes > unoRes) {
                ganador = 2;
            }
        } while (unoRes == dosRes);
        
        
        texto = texto.concat("Has sacado un " + unoRes + " y el enemigo ha sacado un " + dosRes +".\n");
        
        return ganador;
    }

}
