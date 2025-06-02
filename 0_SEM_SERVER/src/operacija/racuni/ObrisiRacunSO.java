/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.racuni;

import domen.Racun;
import domen.StavkaRacuna;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author vanja
 */
public class ObrisiRacunSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param==null || !(param instanceof  Racun)){
            throw new Exception("Sistem ne moze da obrise racun");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        Racun r = (Racun) param;
        
        List<StavkaRacuna> stavke = r.getStavke();
        for (StavkaRacuna s : stavke) {
            s.setRacunId(r.getRacunID());
            broker.delete(s);
        }
        
        broker.delete(r);
        
        
        
    }
    
    
    
    
    
    
}
