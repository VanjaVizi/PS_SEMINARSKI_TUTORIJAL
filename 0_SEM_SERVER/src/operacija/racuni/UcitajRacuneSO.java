/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.racuni;

 
import domen.Racun;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author vanja
 */
public class UcitajRacuneSO extends ApstraktnaGenerickaOperacija {
    List<Racun> racuni;
    @Override
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        racuni = broker.getAll(new Racun(), " JOIN \n" +
                    "    zaposleni ON racun.zaposleni = zaposleni.zaposleniID\n" +
                    "JOIN \n" +
                    "    pacijent ON racun.pacijent = pacijent.pacijentID\n" +
                    "JOIN \n" +
                    "    pregled ON racun.pregled = pregled.id");
    }

    public List<Racun> getRacuni() {
        return racuni;
    }

    
}