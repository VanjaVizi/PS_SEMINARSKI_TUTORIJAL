/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Pacijent;
import forme.GlavnaForma;
import forme.PrikazPacijenataForma;
import forme.model.ModelTabelePacijent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author vanja
 */
public class PrikazPacijenataController {
    
    private final PrikazPacijenataForma ppf;
      
     public PrikazPacijenataController(PrikazPacijenataForma ppf) {
        this.ppf = ppf;
         addActionListener();
    }

    public void otvoriFormu() {
        pripremiFormu();
        ppf.setVisible(true);
        ////
    }

    public void pripremiFormu() {
        List<Pacijent> pacijenti = komunikacija.Komunikacija.getInstanca().ucitajPacijente();
        ModelTabelePacijent mtp = new ModelTabelePacijent(pacijenti);
        ppf.getjTablePacijenti().setModel(mtp);
    }

    private void addActionListener() {
        ppf.addBtnObrisiActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = ppf.getjTablePacijenti().getSelectedRow();
                if(red==-1){
                     JOptionPane.showMessageDialog(ppf, "Sistem ne moze da obrise pacijenta", "Greska", JOptionPane.ERROR_MESSAGE);
                }else{
                    ModelTabelePacijent mtp = (ModelTabelePacijent) ppf.getjTablePacijenti().getModel();
                    Pacijent p = mtp.getLista().get(red);
                    try{
                        Komunikacija.getInstanca().obrisiPacijenta(p);
                        JOptionPane.showMessageDialog(ppf, "Sistem je uspesno obrisao pacijenta", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                        pripremiFormu();
                    }catch(Exception exc){
                        JOptionPane.showMessageDialog(ppf, "Sistem ne moze da obrise pacijenta", "Greska", JOptionPane.ERROR_MESSAGE);
                    }
                    
                            
                }
            }
        });
        ppf.addBtnAzuraijActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = ppf.getjTablePacijenti().getSelectedRow();
                if(red==-1){
                     JOptionPane.showMessageDialog(ppf, "Sistem ne moze da obrise pacijenta", "Greska", JOptionPane.ERROR_MESSAGE);
                }else{
                    ModelTabelePacijent mtp = (ModelTabelePacijent) ppf.getjTablePacijenti().getModel();
                    Pacijent p = mtp.getLista().get(red);
                    cordinator.Cordinator.getInstanca().dodajParam("pacijent", p);
                    cordinator.Cordinator.getInstanca().otvoriIzmeniPacijentaFormu();
                     
                            
                }
            }
        });
        ppf.addBtnPretraziActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ime = ppf.getjTextFieldIme().getText().trim();
                String rasa = ppf.getjTextFieldRasa().getText().trim();
                String vlasnik = ppf.getjTextFieldVlasnik().getText().trim();
                 
                ModelTabelePacijent mtp = (ModelTabelePacijent) ppf.getjTablePacijenti().getModel();
                mtp.pretrazi(ime,rasa,vlasnik);
                 
                 
            }
        });
        ppf.addBtnResetujActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 pripremiFormu();
                
                 
                 
            }
        });
    }

    
    public void osveziFormu() {
         pripremiFormu();
    }

 
    
}
