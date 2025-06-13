/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import controller.Controller;
import domen.Pacijent;
import domen.Pregled;
import domen.Racun;
import domen.StavkaRacuna;
import domen.Tretman;
import domen.Zaposleni;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Odgovor;
import komunikacija.Posiljalac;
import komunikacija.Primalac;
import komunikacija.Zahtev;

/**
 *
 * @author vanja
 */
public class ObradaKlijentskihZahteva extends Thread {
    Socket socket;
    Posiljalac posiljalac;
    Primalac primalac;
    boolean kraj=false;
    public ObradaKlijentskihZahteva(Socket socket) {
        this.socket=socket;
        posiljalac = new Posiljalac(socket);
        primalac= new Primalac(socket);
    }
 
    @Override
    public void run() {
        while(!kraj){
            try {
            Zahtev zahtev = (Zahtev) primalac.primi();
            Odgovor odgovor = new Odgovor();
            switch (zahtev.getOperacija()) {
                case LOGIN:
                    Zaposleni z = (Zaposleni) zahtev.getParametar(); 
                    z = Controller.getInstance().login(z);
                   odgovor.setOdgovor(z);                 
                    break; 
                case UCITAJ_PACIJENTE:
                    List<Pacijent> pacijenti = Controller.getInstance().ucitajPacijente();
                   
                   odgovor.setOdgovor(pacijenti);                 
                    break; 
               case OBRISI_PACIJENTA:
                   try{
                        Pacijent p = (Pacijent) zahtev.getParametar(); 
                        Controller.getInstance().obrisiPacijenta(p);
                        odgovor.setOdgovor(null);
                   }catch (Exception e){
                       odgovor.setOdgovor(e);
                   }
                   
                    break; 
               case DODAJ_PACIJENTA:
                   Pacijent p = (Pacijent) zahtev.getParametar(); 
                    Controller.getInstance().dodajPacijenta(p);
                   odgovor.setOdgovor(null);                 
                    break; 
                case AZURIRAJ_PACIJENTA:
                   Pacijent p1 = (Pacijent) zahtev.getParametar(); 
                    Controller.getInstance().azurirajPacijenta(p1);
                   odgovor.setOdgovor(null);                 
                    break; 
                    
                    
                case UCITAJ_RACUNE:
                    List<Racun> racuni = Controller.getInstance().ucitajRacune();
                    System.out.println("KLASA OKZ: ");
                    System.out.println(racuni);
                    odgovor.setOdgovor(racuni);                 
                    break; 
                case UCITAJ_STAVKE:
                    List<StavkaRacuna> stavke = Controller.getInstance().ucitajStavke((int)zahtev.getParametar());
                    System.out.println("KLASA OKZ: ");
                    System.out.println(stavke);
                    odgovor.setOdgovor(stavke);                 
                    break; 
                case OBRISI_RACUN:
                   try{
                        Racun r = (Racun) zahtev.getParametar(); 
                        Controller.getInstance().obrisiRacun(r);
                        odgovor.setOdgovor(null);
                   }catch (Exception e){
                       odgovor.setOdgovor(e);
                   }
                   break;
                case UCITAJ_PREGLEDE:
                    try {
                        List<Pregled> pregledi = Controller.getInstance().ucitajPreglede();
                        odgovor.setOdgovor(pregledi);
                    } catch (Exception e) {
                        odgovor.setOdgovor(e);
                    }

                    break;

            case UCITAJ_TRETMANE:
                try {
                    List<Tretman> tretmani = Controller.getInstance().ucitajTretmane();
                    odgovor.setOdgovor(tretmani);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                break;
            case DODAJ_RACUN:
                   Racun r = (Racun) zahtev.getParametar(); 
                    Controller.getInstance().dodajRacun(r);
                   odgovor.setOdgovor(null);                 
                    break; 
                   
           case OBRISI_STAVKU:
                   try{
                        StavkaRacuna sr = (StavkaRacuna) zahtev.getParametar(); 
                        Controller.getInstance().obrisiStavkuRacuna(sr);
                        odgovor.setOdgovor(null);
                   }catch (Exception e){
                       odgovor.setOdgovor(e);
                   }
                   break;
                   
            case AZURIRAJ_STAVKU:
                   StavkaRacuna sr = (StavkaRacuna) zahtev.getParametar(); 
                    Controller.getInstance().azurirajStavku(sr);
                   odgovor.setOdgovor(null);                 
                    break; 
             case AZURIRAJ_RACUN:
                   Racun racun = (Racun) zahtev.getParametar(); 
                    Controller.getInstance().azurirajRacun(racun);
                   odgovor.setOdgovor(null);                 
                    break; 
           default:
                    System.out.println("GRESKA, TA OPERACIJA NE POSTOJI");
                    
                    
                    
            }
            posiljalac.posalji(odgovor);
             } catch (Exception ex) {
                        Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    }
        } 
    }
    public void prekini(){
        kraj=true;
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        interrupt();
    }
    
    

}
