/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Pacijent;
import domen.Zaposleni;
import java.util.List;
import operacija.pacijenti.UcitajPacijenteSO;
import operacija.login.LoginOperacija;
import operacija.pacijenti.AzurirajPacijentaSO;
import operacija.pacijenti.KreirajPacijentaSO;
import operacija.pacijenti.ObrisiPacijentaSO;


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

         
}
