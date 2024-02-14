/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 *
 * @author vanja
 */
public class Racun implements ApstraktniDomenskiObjekat{
    private int racunID;
    private Date datum;
    private Zaposleni zaposleni;
    private Pregled pregled;
    private Pacijent pacijent;
    private List<StavkaRacuna> stavke; //
    
    //TODO 

    @Override
    public String vratiNazivTabele() {
        return "racun";
    } 
    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    } 
    @Override
    public String vratiKoloneZaUbacivanje() {
        return "datum,zaposleni,pregled,pacijent";
    }
   @Override
    public String vratiVrednostiZaUbacivanje() {
          return  "'"+datum+"', "+zaposleni.getZaposleniID()+", "+
                  pregled.getId()+", "+pacijent.getPacijentID();
    } 
    @Override
    public String vratiPrimarniKljuc() {
         return "racun.racunId="+racunID;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
