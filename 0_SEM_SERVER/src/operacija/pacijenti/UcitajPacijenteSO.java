/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.pacijenti;

import domen.Pacijent;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author vanja
 */
public class UcitajPacijenteSO extends ApstraktnaGenerickaOperacija {
    List<Pacijent> pacijenti;
    @Override
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        pacijenti = broker.getAll(new Pacijent(), "");
    }

    public List<Pacijent> getPacijenti() {
        return pacijenti;
    }
    
}
