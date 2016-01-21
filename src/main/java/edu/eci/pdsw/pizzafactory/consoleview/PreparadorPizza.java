
package edu.eci.pdsw.pizzafactory.consoleview;

import edu.eci.pdsw.pizzafactory.model.AmasadorPizzaDelgada;
import edu.eci.pdsw.pizzafactory.model.ExcepcionParametrosInvalidos;
import edu.eci.pdsw.pizzafactory.model.HorneadorPizzaDelgada;
import edu.eci.pdsw.pizzafactory.model.Ingrediente;
import edu.eci.pdsw.pizzafactory.model.MoldeadorPizzaDelgada;
import edu.eci.pdsw.pizzafactory.model.Tamano;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hcadavid
 */
public class PreparadorPizza {

    public static void main(String args[]){
        try {
            Ingrediente[] ingredientes=new Ingrediente[]{new Ingrediente("queso",1),new Ingrediente("jamon",2)};            
            PreparadorPizza pp=new PreparadorPizza();            
            pp.prepararPizza(ingredientes, Tamano.MEDIANO);
        } catch (ExcepcionParametrosInvalidos ex) {
            Logger.getLogger(PreparadorPizza.class.getName()).log(Level.SEVERE, "Problema en la preparacion de la Pizza", ex);
        }
                
    }
    
    
    public void prepararPizza(Ingrediente[] ingredientes, Tamano tam)
            throws ExcepcionParametrosInvalidos {
        AmasadorPizzaDelgada am = new AmasadorPizzaDelgada();
        HorneadorPizzaDelgada hpd = new HorneadorPizzaDelgada();
        MoldeadorPizzaDelgada mp = new MoldeadorPizzaDelgada();
        am.amasar();
        if (tam == Tamano.PEQUENO) {
            mp.moldearPizzaPequena();
        } else if (tam == Tamano.MEDIANO) {
            mp.molderarPizzaMediana();
        } else {
            throw new ExcepcionParametrosInvalidos("Tamano de piza invalido:"+tam);
        }
	aplicarIngredientes(ingredientes);
        hpd.hornear();
    }

    private void aplicarIngredientes(Ingrediente[] ingredientes) {
        Logger.getLogger(PreparadorPizza.class.getName())
                .log(Level.INFO, "APLICANDO INGREDIENTES!:{0}", Arrays.toString(ingredientes));
        
        //CODIGO DE LLAMADO AL MICROCONTROLADOR
        
        
        
    }


}
