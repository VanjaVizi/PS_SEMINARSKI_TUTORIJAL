/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.racuni;

import domen.Racun;
import domen.StavkaRacuna;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author vanja
 */
public class AzurirajRacunSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Racun)) {
            throw new Exception("Sistem ne može da doda račun: neispravan objekat.");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        Racun r =(Racun) param;
        broker.edit(r);
        System.out.println("USPESNO ZAVRSENO AZURIRANJE 1 AR.SO");
      //  r.getStavke()   //dodajemo
        String uslov = " JOIN tretman on tretman.tretmanId=stavkaracuna.tretman WHERE racun="+r.getRacunID()+" ";
        List<StavkaRacuna> stareStavke = broker.getAll(new StavkaRacuna(), uslov);
        for (StavkaRacuna sr : stareStavke) {
            broker.delete(sr);
        }
        
        System.out.println("USPESNO ZAVRSENO AZURIRANJE 2 AR.SO");
        List<StavkaRacuna> noveStavke = r.getStavke();
        for (StavkaRacuna sr : noveStavke) {
            sr.setRacunId(r.getRacunID());
            broker.add(sr);
        }
        System.out.println("USPESNO ZAVRSENO AZURIRANJE 3 AR.SO");
    
    }
    
}
