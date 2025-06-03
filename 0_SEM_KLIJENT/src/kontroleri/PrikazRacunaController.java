/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import cordinator.Cordinator;
import domen.Pacijent;
import domen.Racun;
import domen.StavkaRacuna;
import forme.PrikazPacijenataForma;
import forme.PrikazRacunaForma;
import forme.model.ModelTabelePacijent;
import forme.model.ModelTabeleRacuni;
import forme.model.ModelTabeleStavkaRacuna;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author vanja
 */
public class PrikazRacunaController {
    private final PrikazRacunaForma prf;
      
     public PrikazRacunaController(PrikazRacunaForma prf) {
        this.prf = prf;
        addActionListener();
        addMouseListener();
    }

    public void otvoriFormu() {
        pripremiFormu();
        prf.setVisible(true);
       
    }

    public void pripremiFormu() {
        List<Racun> racuni = komunikacija.Komunikacija.getInstanca().ucitajRacune();
        ModelTabeleRacuni mtp = new ModelTabeleRacuni(racuni);
        prf.getjTableRacuni().setModel(mtp);
        
        
        
        
        List<StavkaRacuna> stavke = new ArrayList<>();
        ModelTabeleStavkaRacuna mtsr = new ModelTabeleStavkaRacuna(stavke);
        prf.getjTableStavke().setModel(mtsr);
    }

    private void addActionListener() {
        //obrisiAddActionListener
         prf.obrisiAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = prf.getjTableRacuni().getSelectedRow();
                if(red==-1){
                     JOptionPane.showMessageDialog(prf, "Sistem ne moze da obrise racun", "Greska", JOptionPane.ERROR_MESSAGE);
                }else{
                    ModelTabeleRacuni mtr = (ModelTabeleRacuni) prf.getjTableRacuni().getModel();
                    Racun r = mtr.getLista().get(red);
                    
                   List<StavkaRacuna> stavke = Komunikacija.getInstanca().ucitajStavke(r.getRacunID());
                   r.setStavke(stavke);

                    try{
                        Komunikacija.getInstanca().obrisiRacun(r);
                        JOptionPane.showMessageDialog(prf, "Sistem je uspesno obrisao racun", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                        pripremiFormu();
                    }catch(Exception exc){
                        JOptionPane.showMessageDialog(prf, "Sistem ne moze da obrise racun", "Greska", JOptionPane.ERROR_MESSAGE);
                    }
                    
                            
                }
            }
        });
          prf.obrisiStavkuAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = prf.getjTableStavke().getSelectedRow();
                if(red==-1){
                     JOptionPane.showMessageDialog(prf, "Sistem ne moze da obrise stavku", "Greska", JOptionPane.ERROR_MESSAGE);
                }else{
                    ModelTabeleStavkaRacuna mtsr = (ModelTabeleStavkaRacuna) prf.getjTableStavke().getModel();
                    StavkaRacuna sr = mtsr.getLista().get(red);
                    
                

                    try{
                        Komunikacija.getInstanca().obrisiStavku(sr);
                        JOptionPane.showMessageDialog(prf, "Sistem je uspesno obrisao stavku racuna", "USPEH", JOptionPane.INFORMATION_MESSAGE);
                        mtsr.obrisiStavku(sr);
                        //pripremiFormu();
                    }catch(Exception exc){
                        JOptionPane.showMessageDialog(prf, "Sistem ne moze da obrise stavku racuna", "Greska", JOptionPane.ERROR_MESSAGE);
                    }
                    
                            
                }
            }
        });
          
        prf.azurirajStavkuAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = prf.getjTableStavke().getSelectedRow();
                if(red==-1){
                     JOptionPane.showMessageDialog(prf, "Sistem ne moze da azurira stavku", "Greska", JOptionPane.ERROR_MESSAGE);
                }else{
                    ModelTabeleStavkaRacuna mtsr =  (ModelTabeleStavkaRacuna) prf.getjTableStavke().getModel();
                    StavkaRacuna sr = mtsr.getLista().get(red);
                    Cordinator.getInstanca().otvoriIzmeniStavkuFormu();
                     Cordinator.getInstanca().dodajParam("stavka_za_izmenu", sr);
                            
                }
            }
        });
    }

    private void addMouseListener() {
         prf.getjTableRacuni().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int red = prf.getjTableRacuni().getSelectedRow();
                if (red != -1) {
                    ModelTabeleRacuni mtr = (ModelTabeleRacuni) prf.getjTableRacuni().getModel();
                    Racun racun = mtr.getLista().get(red);
                    List<StavkaRacuna> stavke = komunikacija.Komunikacija.getInstanca().ucitajStavke(racun.getRacunID());
                    ModelTabeleStavkaRacuna mts = new ModelTabeleStavkaRacuna(stavke);
                    prf.getjTableStavke().setModel(mts);
                }
            }
        });
    }
    
}
