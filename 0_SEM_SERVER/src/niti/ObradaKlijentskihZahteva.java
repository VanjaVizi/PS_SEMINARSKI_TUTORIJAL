/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import controller.Controller;
import domen.Pacijent;
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
