/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import domen.Pacijent;
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
    
    
    
    
    
}
