/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import cordinator.Cordinator;
import domen.Pacijent;
import domen.StavkaRacuna;
import domen.Tretman;
import forme.DodajStavkuForm;
import forme.FormaMod;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author vanja
 */
public class DodajStavkuController {
     private final DodajStavkuForm dsf;

    public DodajStavkuController(DodajStavkuForm dsf) {
        this.dsf = dsf;
         addActionListener();
    }
      
   
 
    public void otvoriFormu(FormaMod mod) { 
        pripremiformu(mod);
        dsf.setVisible(true);
        
    }

    private void addActionListener() {
          
          dsf.izmeniAddActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 //
                 izmeni(e);
             }

             private void izmeni(ActionEvent e)  {  //throws ParseException
                int id = Integer.parseInt(dsf.getjTextFieldracunID().getText());
                int rb = Integer.parseInt(dsf.getjTextFieldRB().getText());
                int kolicina = Integer.parseInt(dsf.getjTextFieldKolicina().getText());
                double cena = Double.parseDouble(dsf.getjTextFieldCena().getText());
                Tretman t = (Tretman) dsf.getjComboBoxTretmani().getSelectedItem();
                
                    StavkaRacuna sr = new StavkaRacuna();
                    sr.setCena(cena);
                    sr.setKolicina(kolicina);
                    sr.setRacunId(id);
                    sr.setRb(rb);
                    sr.setTretman(t);
                  
              
                 try{
                     Komunikacija.getInstanca().azurirajStavku(sr);
                     JOptionPane.showMessageDialog(dsf, "USPEH","USPEH",JOptionPane.INFORMATION_MESSAGE);
                    
                     dsf.dispose();
                    
                 }catch(Exception exp){
                     JOptionPane.showMessageDialog(dsf, "GRESKA","GRESKA",JOptionPane.ERROR_MESSAGE);
                     exp.printStackTrace();
                 }
                 
                 
             }
         });
    }

    private void pripremiformu(FormaMod mod) {
        List<Tretman> sviTretmani = Komunikacija.getInstanca().ucitajTretmane();
        dsf.getjComboBoxTretmani().removeAllItems();
        for (Tretman t : sviTretmani) {
            dsf.getjComboBoxTretmani().addItem(t);
        }
        
        
        switch (mod) {
            case DODAJ:
                dsf.getjTextFieldracunID().setEnabled(false);
                dsf.getjTextFieldRB().setEnabled(false);
                dsf.getjButtonIzmeni().setVisible(false);
                dsf.getjButton1().setVisible(true); 
                dsf.getjButton1().setEnabled(true);
                break;
                
            case IZMENI:
                dsf.getjTextFieldracunID().setEnabled(false);
                 dsf.getjTextFieldRB().setEnabled(false);
                dsf.getjButton1().setVisible(false);
                dsf.getjButtonIzmeni().setVisible(true); 
                dsf.getjButtonIzmeni().setEnabled(true);
                
                StavkaRacuna sr = (StavkaRacuna) Cordinator.getInstanca().vratiParam("stavka_za_izmenu");
                dsf.getjTextFieldracunID().setText(sr.getRacunId()+"");
                dsf.getjTextFieldKolicina().setText(sr.getKolicina()+"");
                dsf.getjComboBoxTretmani().setSelectedItem(sr.getTretman());
                dsf.getjTextFieldRB().setText(sr.getRb()+"");
                double cena =  sr.getKolicina()*sr.getTretman().getCena();
                dsf.getjTextFieldCena().setText(cena+"");
               
                break;
            default:
                throw new AssertionError();
        }
    }
}
