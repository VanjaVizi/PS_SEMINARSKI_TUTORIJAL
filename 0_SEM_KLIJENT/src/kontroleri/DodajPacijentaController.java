/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import cordinator.Cordinator;
import domen.Pacijent;
import domen.Zaposleni;
import forme.DodajPacijentaForm;
import forme.FormaMod;
import forme.PrikazPacijenataForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author vanja
 */
public class DodajPacijentaController {
    
    private final DodajPacijentaForm dpf;
      
     public DodajPacijentaController(DodajPacijentaForm dpf) {
        this.dpf = dpf;
         addActionListener();
    }

    public void otvoriFormu(FormaMod mod) { 
        pripremiformu(mod);
        dpf.setVisible(true);
        
    }

    private void addActionListener() {
          dpf.dodajAddActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 //
                 dodaj(e);
             }

             private void dodaj(ActionEvent e)  {  //throws ParseException
                 String ime = dpf.getjTextFieldIme().getText().trim();
                 String rasa = dpf.getjTextFieldRasa().getText().trim();
                 String vlasnik = dpf.getjTextFieldVlasnik().getText().trim();
                  
               // String datumString = dpf.getjTextField1().getText().trim();
                //Date datumUtil = (new SimpleDateFormat("dd.MM.yyyy")).parse(datumString);
                
                 Pacijent p = new Pacijent(-1,ime,rasa,vlasnik);
                 try{
                     Komunikacija.getInstanca().dodajPacijenta(p);
                     JOptionPane.showMessageDialog(dpf, "USPEH","USPEH",JOptionPane.INFORMATION_MESSAGE);
                    
                     dpf.dispose();
                    
                 }catch(Exception exp){
                     JOptionPane.showMessageDialog(dpf, "GRESKA","GRESKA",JOptionPane.ERROR_MESSAGE);
                     exp.printStackTrace();
                 }
                 
                 
             }
         });
          dpf.izmeniAddActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 //
                 izmeni(e);
             }

             private void izmeni(ActionEvent e)  {  //throws ParseException
                 int id = Integer.parseInt(dpf.getjTextFieldid().getText());
                 String ime = dpf.getjTextFieldIme().getText().trim();
                 String rasa = dpf.getjTextFieldRasa().getText().trim();
                 String vlasnik = dpf.getjTextFieldVlasnik().getText().trim();
                  
               // String datumString = dpf.getjTextField1().getText().trim();
                //Date datumUtil = (new SimpleDateFormat("dd.MM.yyyy")).parse(datumString);
                
                 Pacijent p = new Pacijent(id,ime,rasa,vlasnik);
                 try{
                     Komunikacija.getInstanca().azurirajPacijenta(p);
                     JOptionPane.showMessageDialog(dpf, "USPEH","USPEH",JOptionPane.INFORMATION_MESSAGE);
                    
                     dpf.dispose();
                    
                 }catch(Exception exp){
                     JOptionPane.showMessageDialog(dpf, "GRESKA","GRESKA",JOptionPane.ERROR_MESSAGE);
                     exp.printStackTrace();
                 }
                 
                 
             }
         });
    }

    private void pripremiformu(FormaMod mod) {
        switch (mod) {
            case DODAJ:
                dpf.getjTextFieldid().setEnabled(false);
                dpf.getjButtonAzuriraj().setVisible(false);
                dpf.getjButtonDodaj().setVisible(true); 
                dpf.getjButtonDodaj().setEnabled(true);
                break;
                
            case IZMENI:
                 dpf.getjButtonDodaj().setVisible(false);
                dpf.getjButtonAzuriraj().setVisible(true); 
                dpf.getjButtonAzuriraj().setEnabled(true);
                
                Pacijent p = (Pacijent) Cordinator.getInstanca().vratiParam("pacijent");
                dpf.getjTextFieldIme().setText(p.getIme());
                dpf.getjTextFieldRasa().setText(p.getRasa());
                dpf.getjTextFieldVlasnik().setText(p.getVlasnik());
                dpf.getjTextFieldid().setText(p.getPacijentID()+"");
                
                break;
            default:
                throw new AssertionError();
        }
    }
    
}
