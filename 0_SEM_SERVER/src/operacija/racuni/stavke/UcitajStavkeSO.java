/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.racuni.stavke;

import domen.Racun;
import domen.StavkaRacuna;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author vanja
 */
public class UcitajStavkeSO  extends ApstraktnaGenerickaOperacija {
    List<StavkaRacuna> stavke;
    @Override
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        String uslov = " JOIN tretman on tretman.tretmanId=stavkaracuna.tretman WHERE racun="+(int)param+" ";
        stavke = broker.getAll(new StavkaRacuna(), uslov);
    }

    public List<StavkaRacuna> getStavke() {
        return stavke;
    }

 

    
}
