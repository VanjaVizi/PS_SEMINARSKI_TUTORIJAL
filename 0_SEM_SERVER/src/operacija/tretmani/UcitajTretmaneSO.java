/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.tretmani;

import domen.Pregled;
import domen.Tretman;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author vanja
 */
public class UcitajTretmaneSO extends ApstraktnaGenerickaOperacija {
     private List<Tretman> tretmani;

    @Override
    protected void preduslovi(Object param) throws Exception {
        // Nema posebnih preduslova za ovu operaciju
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        tretmani = broker.getAll(new Tretman(), "");
    }

    public List<Tretman> getTretmani() {
        return tretmani;
    }

 
}
