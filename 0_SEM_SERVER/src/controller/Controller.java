/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Pacijent;
import domen.Pregled;
import domen.Racun;
import domen.StavkaRacuna;
import domen.Tretman;
import domen.Zaposleni;
import java.util.List;
import operacija.pacijenti.UcitajPacijenteSO;
import operacija.login.LoginOperacija;
import operacija.pacijenti.AzurirajPacijentaSO;
import operacija.pacijenti.KreirajPacijentaSO;
import operacija.pacijenti.ObrisiPacijentaSO;
import operacija.pregledi.UcitajPregledeSO;
import operacija.racuni.DodajRacunSO;
import operacija.racuni.ObrisiRacunSO;
import operacija.racuni.UcitajRacuneSO;
import operacija.racuni.stavke.AzurirajStavkuSO;
import operacija.racuni.stavke.ObrisiStavkuSO;
import operacija.racuni.stavke.UcitajStavkeSO;
import operacija.tretmani.UcitajTretmaneSO;


/**
 *
 * @author vanja
 */
public class Controller {
    private static  Controller instance;

    private Controller() {
    }
    public static Controller getInstance (){
             if(instance==null){
                 instance=new Controller();
             }
             return instance;
     }

    public Zaposleni login(Zaposleni z) throws Exception {
        LoginOperacija operacija = new LoginOperacija();
        operacija.izvrsi(z, null);
        System.out.println("KLASA CONTROLLER :"+operacija.getZaposleni());
        return operacija.getZaposleni();
    }

    public List<Pacijent> ucitajPacijente() throws Exception {
        UcitajPacijenteSO operacija = new UcitajPacijenteSO();
        operacija.izvrsi(null, null);
       System.out.println("KLASA CONTROLLER :"+operacija.getPacijenti());
        return operacija.getPacijenti();
    }

    public void obrisiPacijenta(Pacijent p) throws Exception {
        
        ObrisiPacijentaSO operacija = new ObrisiPacijentaSO();
        operacija.izvrsi(p, null);
    }

    public void dodajPacijenta(Pacijent p) throws Exception {
        
         KreirajPacijentaSO operacija = new KreirajPacijentaSO();
        operacija.izvrsi(p, null);
        
    }

    public void azurirajPacijenta(Pacijent p) throws Exception {
        
        AzurirajPacijentaSO operacija= new AzurirajPacijentaSO();
        operacija.izvrsi(p, null);
        
    }

    public List<Racun> ucitajRacune() throws Exception {
        UcitajRacuneSO operacija = new UcitajRacuneSO();
        operacija.izvrsi(null, null);
        System.out.println("KLASA CONTROLLER :"+operacija.getRacuni());
        return operacija.getRacuni();
         
    }

    public List<StavkaRacuna> ucitajStavke(int id) throws Exception {
         UcitajStavkeSO operacija = new UcitajStavkeSO();
        operacija.izvrsi(id, null);
        System.out.println("KLASA CONTROLLER :"+operacija.getStavke());
        return operacija.getStavke();
        
    }

    public void obrisiRacun(Racun r) throws Exception {
        ObrisiRacunSO operacija = new ObrisiRacunSO();
        operacija.izvrsi(r, null);
        
        
    }
    public List<Pregled> ucitajPreglede() throws Exception {
        UcitajPregledeSO operacija = new UcitajPregledeSO();
        operacija.izvrsi(null, null);
        System.out.println("KLASA CONTROLLER :" + operacija.getPregledi());
        return operacija.getPregledi();
    }

    public List<Tretman> ucitajTretmane() throws Exception {
        UcitajTretmaneSO operacija = new UcitajTretmaneSO();
        operacija.izvrsi(null, null);
        System.out.println("KLASA CONTROLLER :" + operacija.getTretmani());
        return operacija.getTretmani();
    }

    public void dodajRacun(Racun r) throws Exception {
        DodajRacunSO operacija = new DodajRacunSO();
        operacija.izvrsi(r, null);
    }

    public void obrisiStavkuRacuna(StavkaRacuna sr) throws Exception {
        ObrisiStavkuSO operacija = new ObrisiStavkuSO();
        operacija.izvrsi(sr, null);
        
        
    }

    public void azurirajStavku(StavkaRacuna sr) throws Exception {
        AzurirajStavkuSO operacija= new AzurirajStavkuSO();
        operacija.izvrsi(sr, null);
    }

         
}
