/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Zaposleni;
import forme.GlavnaForma;
import forme.LoginForma;
 

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
        //todo
    }

    public void otvoriFormu() {
        Zaposleni ulogovani = cordinator.Cordinator.getInstanca().getUlogovani();
        String imePrezime = ulogovani.getIme()+" "+ulogovani.getPrezime();
        gf.setVisible(true);
        gf.getjLabelUlogovani().setText(imePrezime);
    }

      
}
