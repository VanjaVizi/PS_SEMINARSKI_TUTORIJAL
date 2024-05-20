/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Pacijent;
import domen.Racun;
import domen.StavkaRacuna;
import forme.PrikazPacijenataForma;
import forme.PrikazRacunaForma;
import forme.model.ModelTabelePacijent;
import forme.model.ModelTabeleRacuni;
import forme.model.ModelTabeleStavkaRacuna;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

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
        System.out.println("KLASA PRCONTROLLER");
        System.out.println(racuni);
        ModelTabeleRacuni mtp = new ModelTabeleRacuni(racuni);
        prf.getjTableRacuni().setModel(mtp);
        
        
        
        
        List<StavkaRacuna> stavke = new ArrayList<>();
        System.out.println("KLASA PRCONTROLLER");
        System.out.println(stavke);
        ModelTabeleStavkaRacuna mtsr = new ModelTabeleStavkaRacuna(stavke);
        prf.getjTableStavke().setModel(mtsr);
    }

    private void addActionListener() {
        
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
