/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import domen.Pacijent;
import domen.Pregled;
import domen.Racun;
import domen.StavkaRacuna;
import domen.Tretman;
import domen.Zaposleni;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vanja
 */
public class Komunikacija {
     private Socket soket;
    private Posiljalac posiljalac;
    private Primalac primalac;
     private static Komunikacija instanca;
    private Komunikacija() {
    }   
     
    public static Komunikacija getInstanca() {
        if (instanca == null) {
            instanca = new Komunikacija();
        }
        return instanca;
    }

      public void konekcija()  {
         try {
             soket = new Socket("localhost", 9000);
             posiljalac = new Posiljalac(soket);
             primalac = new Primalac(soket);
         } catch (IOException ex) {
             System.out.println("SERVER NIJE POVEZAN");
         }
         
      }

    public Zaposleni login(String ki, String pass) {
        Zaposleni z = new Zaposleni();
        z.setPassword(pass);
        z.setUsername(ki);
        Zahtev zahtev = new Zahtev(Operacija.LOGIN, z);
        
        posiljalac.posalji(zahtev);
        
       Odgovor odg = (Odgovor) primalac.primi();
       
       z = (Zaposleni) odg.getOdgovor();
       return z;
        
    }

    public List<Pacijent> ucitajPacijente() {
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_PACIJENTE, null);
         List<Pacijent> pacijenti = new ArrayList<>();
        
         posiljalac.posalji(zahtev);
         ////
         Odgovor odg = (Odgovor) primalac.primi();
         pacijenti = (List<Pacijent>) odg.getOdgovor();
         return pacijenti;
    }

    public void obrisiPacijenta(Pacijent p) throws Exception {
         Zahtev zahtev = new Zahtev(Operacija.OBRISI_PACIJENTA, p);
         posiljalac.posalji(zahtev);
         
          Odgovor odg = (Odgovor) primalac.primi();
          if(odg.getOdgovor()==null){
              System.out.println("USPEH");
          }else{
                System.out.println("GRESKA");
                ((Exception)odg.getOdgovor()).printStackTrace();
                throw new Exception("GRESKA");
          }
         
    }

    public void dodajPacijenta(Pacijent p) {
         Zahtev zahtev = new Zahtev(Operacija.DODAJ_PACIJENTA, p);
         posiljalac.posalji(zahtev);
          Odgovor odg = (Odgovor) primalac.primi();
         if(odg.getOdgovor()==null){
              System.out.println("USPEH");
         }   else{
            System.out.println("GRESKA");
        }
    }

    public void azurirajPacijenta(Pacijent p) {
        Zahtev zahtev = new Zahtev(Operacija.AZURIRAJ_PACIJENTA, p);
         posiljalac.posalji(zahtev);
         
         //
          Odgovor odg = (Odgovor) primalac.primi();
         if(odg.getOdgovor()==null){
              System.out.println("USPEH");
              cordinator.Cordinator.getInstanca().osveziFormu();
         }   else{
            System.out.println("GRESKA");
        }
        
    }

    public List<Racun> ucitajRacune() {
         Zahtev zahtev = new Zahtev(Operacija.UCITAJ_RACUNE, null);
         List<Racun> racuni = new ArrayList<>();
        
         posiljalac.posalji(zahtev);
         ////
         Odgovor odg = (Odgovor) primalac.primi();
         racuni = (List<Racun>) odg.getOdgovor();
         System.out.println("KLASA KOMUNIKACIJA");
         System.out.println(racuni);
         return racuni;
        
        
    }

    public List<StavkaRacuna> ucitajStavke(int racunID) {
         Zahtev zahtev = new Zahtev(Operacija.UCITAJ_STAVKE, racunID);
         List<StavkaRacuna> stavke = new ArrayList<>();
        
         posiljalac.posalji(zahtev);
         ////
         Odgovor odg = (Odgovor) primalac.primi();
         stavke = (List<StavkaRacuna>) odg.getOdgovor();
         System.out.println("KLASA KOMUNIKACIJA");
         System.out.println(stavke);
         return stavke; 
    }

    public void obrisiRacun(Racun r) throws Exception {
         Zahtev zahtev = new Zahtev(Operacija.OBRISI_RACUN, r);
         posiljalac.posalji(zahtev);
         
          Odgovor odg = (Odgovor) primalac.primi();
          if(odg.getOdgovor()==null){
              System.out.println("USPEH");
          }else{
                System.out.println("GRESKA");
                ((Exception)odg.getOdgovor()).printStackTrace();
                throw new Exception("GRESKA");
          }
    }
    public List<Pregled> ucitajPreglede() {
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_PREGLEDE, null);
        List<Pregled> pregledi = new ArrayList<>();

        posiljalac.posalji(zahtev);
        Odgovor odg = (Odgovor) primalac.primi();
        pregledi = (List<Pregled>) odg.getOdgovor();
        return pregledi;
    }

    public List<Tretman> ucitajTretmane() {
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_TRETMANE, null);
        List<Tretman> tretmani = new ArrayList<>();

        posiljalac.posalji(zahtev);
        Odgovor odg = (Odgovor) primalac.primi();
        tretmani = (List<Tretman>) odg.getOdgovor();
        return tretmani;
    }

    public void dodajRacun(Racun r) {
        Zahtev zahtev = new Zahtev(Operacija.DODAJ_RACUN, r);
         posiljalac.posalji(zahtev);
          Odgovor odg = (Odgovor) primalac.primi();
         if(odg.getOdgovor()==null){
              System.out.println("USPEH");
         }   else{
            System.out.println("GRESKA");
        }
    }

    public void obrisiStavku(StavkaRacuna sr) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.OBRISI_STAVKU, sr);
         posiljalac.posalji(zahtev);
         
          Odgovor odg = (Odgovor) primalac.primi();
          if(odg.getOdgovor()==null){
              System.out.println("USPEH");
          }else{
                System.out.println("GRESKA");
                ((Exception)odg.getOdgovor()).printStackTrace();
                throw new Exception("GRESKA");
          }
    }

    public void azurirajStavku(StavkaRacuna sr) {
         Zahtev zahtev = new Zahtev(Operacija.AZURIRAJ_STAVKU, sr);
         posiljalac.posalji(zahtev);
         
         //
          Odgovor odg = (Odgovor) primalac.primi();
         if(odg.getOdgovor()==null){
              System.out.println("USPEH");
              cordinator.Cordinator.getInstanca().osveziFormu();
         }   else{
            System.out.println("GRESKA");
        }
        
        
    }

 
    
    
    
    
}
