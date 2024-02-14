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
public class ObrisiPacijentaSO extends ApstraktnaGenerickaOperacija {
 
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param==null || !(param instanceof Pacijent)){
            throw new Exception("Sistem nije mogao da obrise pacijenta");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.delete((Pacijent)param);
    }
    
}
