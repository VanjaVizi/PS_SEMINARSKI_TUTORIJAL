/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cordinator;

import domen.Zaposleni;
import forme.DodajPacijentaForm;
import forme.DodajStavkuForm; 
import forme.FormaMod;
import forme.GlavnaForma;
import forme.LoginForma;
import forme.PrikazPacijenataForma;
import forme.PrikazRacunaForma;
import java.util.HashMap;
import java.util.Map;
import kontroleri.DodajPacijentaController;
import kontroleri.GlavnaFormaController;
import kontroleri.LoginController;
import kontroleri.PrikazPacijenataController;
import kontroleri.PrikazRacunaController;
import kontroleri.DodajStavkuController;
/**
 *
 * @author vanja
 */
public class Cordinator {
    private static Cordinator instanca;
    private Zaposleni ulogovani;
    private LoginController loginController;
    private GlavnaFormaController glavnaFormaController;
    private PrikazPacijenataController ppController;
    private DodajPacijentaController dpController;
    private PrikazRacunaController prController;
    private DodajStavkuController dsController;
    
    
    
    private Map<String, Object> parametri;
    
    
    
    private Cordinator() {
         parametri = new HashMap<>();
    }
    public static Cordinator getInstanca() {
        if (instanca == null) {
            instanca = new Cordinator();
        }
        return instanca;
    }

    public void otvoriLoginFormu() {
        loginController = new LoginController(new LoginForma());
        loginController.otvoriFormu();
    }

    public void otvoriGlavnuFormu() {
        glavnaFormaController = new GlavnaFormaController(new GlavnaForma());
        glavnaFormaController.otvoriFormu();
    }
    public void otvoriPrikazPacijenataFormu() {
         ppController = new PrikazPacijenataController(new PrikazPacijenataForma());
        ppController.otvoriFormu();
    }
    public Zaposleni getUlogovani() {
        return ulogovani;
    }

    public void setUlogovani(Zaposleni ulogovani) {
        this.ulogovani = ulogovani;
    }

    public void otvoriDodajPacijentaFormu() {
         dpController = new DodajPacijentaController(new DodajPacijentaForm());
        dpController.otvoriFormu(FormaMod.DODAJ);
    }

 
    public void dodajParam(String s, Object o) {
        parametri.put(s, o);
    }

    public Object vratiParam(String s) {
        return parametri.get(s);
    }

    public void otvoriIzmeniPacijentaFormu() {
        dpController = new DodajPacijentaController(new DodajPacijentaForm());
        dpController.otvoriFormu(FormaMod.IZMENI);
    }

    public void otvoriPrikazRacunaFormu() {
         prController = new PrikazRacunaController(new PrikazRacunaForma());
        prController.otvoriFormu();
    }
    public void osveziFormu() {
        ppController.osveziFormu();
    }

    public void otvoriIzmeniStavkuFormu() {
        dsController = new DodajStavkuController(new DodajStavkuForm());
        dsController.otvoriFormu(FormaMod.IZMENI);
    }

    
}
