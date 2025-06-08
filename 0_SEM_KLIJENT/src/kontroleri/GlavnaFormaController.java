/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import cordinator.Cordinator;
import domen.Pacijent;
import domen.Pregled;
import domen.Racun;
import domen.StavkaRacuna;
import domen.Tretman;
import domen.Zaposleni;
import forme.FormaMod;
import forme.GlavnaForma;
import forme.LoginForma;
import forme.model.ModelTabeleStavkaRacuna;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
 

/**
 *
 * @author vanja
 */
public class GlavnaFormaController {
      private final GlavnaForma gf;
      
     public GlavnaFormaController(GlavnaForma gf) {
        this.gf = gf;
        addActionListeners();
    }

    private void addActionListeners() {
         gf.dodajStavkuAddActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 //
                 dodaj(e);
             }

             private void dodaj(ActionEvent e)  {  //throws ParseException
                 Tretman t =  (Tretman) gf.getjComboBoxTretmani().getSelectedItem();
                 int kolicina = Integer.parseInt(gf.getjTextFieldKolicina().getText());
                 double cena = kolicina*t.getCena();
            
                 StavkaRacuna s = new StavkaRacuna(); 
                 s.setTretman(t);
                 s.setCena(cena);
                 s.setKolicina(kolicina);
                
                 ModelTabeleStavkaRacuna mts = (ModelTabeleStavkaRacuna) gf.getjTable1().getModel();
                 mts.dodajStavku(s);
                
                 
                 
             }
         });
         
         
        gf.obrisiStavkuAddActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 //
                 obrisi(e);
             }

             private void obrisi(ActionEvent e)  {  //throws ParseException
                 int red = gf.getjTable1().getSelectedRow();
                 if(red==-1){
                     
                 }else{
                   ModelTabeleStavkaRacuna mts = (ModelTabeleStavkaRacuna) gf.getjTable1().getModel();
                   StavkaRacuna s =  mts.getLista().get(red);
                    mts.obrisiStavku(s);
                 } 
             }
         });
        
         gf.dodajRacunAddActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 try {
                     //
                     dodaj(e);
                 } catch (Exception ex) {
                     Logger.getLogger(GlavnaFormaController.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }

             private void dodaj(ActionEvent e) throws Exception  {  //throws ParseException
                  try{
                      
                 
                    Racun r = new Racun();
                    String datumString= gf.getjTextFieldDatum().getText();
                     SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                     Date datum =  sdf.parse(datumString);
                    r.setDatum(datum);
                    r.setZaposleni(Cordinator.getInstanca().getUlogovani());
                    r.setPacijent((Pacijent) gf.getjComboBoxPacijenti().getSelectedItem());
                    r.setPregled((Pregled) gf.getjComboBoxPregledi().getSelectedItem());

                    ModelTabeleStavkaRacuna mts = (ModelTabeleStavkaRacuna) gf.getjTable1().getModel();
                    List<StavkaRacuna> stavke = mts.getLista();
                    r.setStavke(stavke);

                     Komunikacija.getInstanca().dodajRacun(r);
                    JOptionPane.showMessageDialog(null, "Sistem  je uspesno kreirao racun", "USPEH", JOptionPane.INFORMATION_MESSAGE);

                     
                  }catch(Exception ex){
                     ex.printStackTrace();
                     JOptionPane.showMessageDialog(null, "Sistem ne moze da kreira racun", "GRESKA", JOptionPane.ERROR_MESSAGE);
                  
                  }
                
                 
                
                 
                 
             }
         });
         gf.izmeniRacunAddActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 try {
                     //
                     izmeni(e);
                 } catch (Exception ex) {
                     Logger.getLogger(GlavnaFormaController.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }

             private void izmeni(ActionEvent e) throws Exception  {  //throws ParseException
                  try{
                      
                 
                    Racun r = new Racun();
                    int id= Integer.parseInt(gf.getjTextFieldID().getText());
                    r.setRacunID(id);
                    String datumString= gf.getjTextFieldDatum().getText();
                     SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                     Date datum =  sdf.parse(datumString);
                    r.setDatum(datum);
                    r.setZaposleni(Cordinator.getInstanca().getUlogovani());
                    r.setPacijent((Pacijent) gf.getjComboBoxPacijenti().getSelectedItem());
                    r.setPregled((Pregled) gf.getjComboBoxPregledi().getSelectedItem());
                        
                    ModelTabeleStavkaRacuna mts = (ModelTabeleStavkaRacuna) gf.getjTable1().getModel();
                    List<StavkaRacuna> stavke = mts.getLista();
                    r.setStavke(stavke);

                      System.out.println("KLASA GFK");
                      System.out.println(r);
                    System.out.println(r.getStavke());
                     Komunikacija.getInstanca().izmeniRacun(r);
                    JOptionPane.showMessageDialog(null, "Sistem  je uspesno izmeni racun", "USPEH", JOptionPane.INFORMATION_MESSAGE);

                     
                  }catch(Exception ex){
                     ex.printStackTrace();
                     JOptionPane.showMessageDialog(null, "Sistem ne moze da izmeni racun", "GRESKA", JOptionPane.ERROR_MESSAGE);
                  
                  }
                
                 
                
                 
                 
             }
         });
        
        
        
        
        
        
        
        
        
        
        
        
    }

    public void otvoriFormu() {
        
        gf.getjButtonIzmeniRacun().setVisible(false);
        Zaposleni ulogovani = cordinator.Cordinator.getInstanca().getUlogovani();
        String imePrezime = ulogovani.getIme()+" "+ulogovani.getPrezime();
        gf.setVisible(true);
        gf.getjLabelUlogovani().setText(imePrezime);
        
        List<StavkaRacuna> praznaLista = new ArrayList<>();
        ModelTabeleStavkaRacuna mts =  new ModelTabeleStavkaRacuna(praznaLista);
        gf.getjTable1().setModel(mts);
        
        popuniComboboxeve();
    }

    private void popuniComboboxeve() {
        
        List<Pacijent> sviPacijenti = Komunikacija.getInstanca().ucitajPacijente();
        gf.getjComboBoxPacijenti().removeAllItems();
        for (Pacijent p : sviPacijenti) {
            gf.getjComboBoxPacijenti().addItem(p);
        }
        
         List<Pregled> sviPregledi = Komunikacija.getInstanca().ucitajPreglede();
            gf.getjComboBoxPregledi().removeAllItems();
            for (Pregled pr : sviPregledi) {
                gf.getjComboBoxPregledi().addItem(pr);
            }
            
            
          List<Tretman> sviTretmani = Komunikacija.getInstanca().ucitajTretmane();
        gf.getjComboBoxTretmani().removeAllItems();
        for (Tretman t : sviTretmani) {
            gf.getjComboBoxTretmani().addItem(t);
        }
    }

    public void otvoriFormu(FormaMod formaMod) {
        popuniComboboxeve();
        Zaposleni ulogovani = cordinator.Cordinator.getInstanca().getUlogovani();
        String imePrezime = ulogovani.getIme()+" "+ulogovani.getPrezime();
        gf.setVisible(true);
        gf.getjLabelUlogovani().setText(imePrezime);
        
        List<StavkaRacuna> praznaLista = new ArrayList<>();
        ModelTabeleStavkaRacuna mts =  new ModelTabeleStavkaRacuna(praznaLista);
        gf.getjTable1().setModel(mts);
        if(formaMod==FormaMod.IZMENI){
            gf.getjButtonKreirajRacun().setVisible(false);
            Racun r = (Racun) Cordinator.getInstanca().vratiParam("racun_za_izmenu");
            mts.setLista(r.getStavke());
            gf.getjTextFieldID().setEnabled(false);
            gf.getjTextFieldID().setText( r.getRacunID()+"");
           gf.getjComboBoxPregledi().setSelectedItem(r.getPregled());
             gf.getjComboBoxPacijenti().setSelectedItem(r.getPacijent());
             
             SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy");
             String datumString = formater.format(r.getDatum());
             gf.getjTextFieldDatum().setText(datumString);
            
        }
        
        
        
    }

      
}
