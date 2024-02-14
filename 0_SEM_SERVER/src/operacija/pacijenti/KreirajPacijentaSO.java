/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.pacijenti;

import domen.Pacijent;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author vanja
 */
public class KreirajPacijentaSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
         if(param==null || !(param instanceof Pacijent)){
            throw new Exception("Sistem nije mogao da obrise pacijenta");
        }
       Pacijent p= (Pacijent) param;
       if(p.getIme()==null || p.getIme().isEmpty() || p.getIme().length()<3){ 
            throw new Exception("GRESKA IME");
       }
       if(p.getRasa()==null || p.getRasa().isEmpty() ){ 
            throw new Exception("GRESKA RASA");
       }
       if(p.getVlasnik()==null || p.getVlasnik().isEmpty() ){ 
            throw new Exception("GRESKA VLASNIK");
       }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.add((Pacijent)param);
    }
    
}
