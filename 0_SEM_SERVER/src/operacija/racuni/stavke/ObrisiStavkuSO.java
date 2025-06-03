/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.racuni.stavke;

import domen.StavkaRacuna;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author vanja
 */
public class ObrisiStavkuSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object param) throws Exception {
         if(param==null || !(param instanceof  StavkaRacuna)){
            throw new Exception("Sistem ne moze da obrise stavku racuna");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        StavkaRacuna sr = (StavkaRacuna) param;
        broker.delete(sr);
    }
    
}
