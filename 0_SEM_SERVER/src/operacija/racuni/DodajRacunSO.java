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
public class DodajRacunSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
         if (param == null || !(param instanceof Racun)) {
            throw new Exception("Sistem ne može da doda račun: neispravan objekat.");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        Racun r = (Racun) param;
        int idRacun=broker.addReturnKey(r);
        
         List<StavkaRacuna> stavke = r.getStavke();
        for (StavkaRacuna s : stavke) {
            s.setRacunId(idRacun);
            broker.add(s);
        }
        
        
        
    }
    
}
