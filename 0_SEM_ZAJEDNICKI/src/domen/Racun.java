/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
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
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Racun racun = new Racun();
            racun.setRacunID(rs.getInt("racunID"));
            racun.setDatum(rs.getDate("datum"));

            // Kreiraj Zaposleni objekat
            Zaposleni zaposleni = new Zaposleni();
            zaposleni.setZaposleniID(rs.getInt("zaposleni.zaposleniID"));
            zaposleni.setIme(rs.getString("zaposleni.ime"));
            zaposleni.setPrezime(rs.getString("zaposleni.prezime"));
            racun.setZaposleni(zaposleni);

            // Kreiraj Pacijent objekat
            Pacijent pacijent = new Pacijent();
            pacijent.setPacijentID(rs.getInt("pacijentID"));
            pacijent.setIme(rs.getString("pacijent.ime"));
            pacijent.setVlasnik(rs.getString("vlasnik"));
            racun.setPacijent(pacijent);

            // Kreiraj Pregled objekat
            Pregled pregled = new Pregled();
            pregled.setId(rs.getInt("pregled.id"));
            pregled.setNaziv(rs.getString("pregled.naziv"));
            pregled.setCena(rs.getDouble("pregled.cena"));
            racun.setPregled(pregled);

            racun.setStavke(new ArrayList<>()); // Inicijalizuj praznu listu stavki
            lista.add(racun);
        }
        return lista;
        
        
        
        
        
        
    } 
    @Override
    public String vratiKoloneZaUbacivanje() {
        return "datum,zaposleni,pregled,pacijent";
    }
   @Override
    public String vratiVrednostiZaUbacivanje() {
        java.sql.Date sqlDatum = new java.sql.Date(datum.getTime());
          return  "'"+sqlDatum+"', "+zaposleni.getZaposleniID()+", "+
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
         java.sql.Date sqlDatum = new java.sql.Date(datum.getTime());
        return "datum='" + sqlDatum + "', " +
           "zaposleni=" + zaposleni.getZaposleniID() + ", " +
           "pregled=" + pregled.getId() + ", " +
           "pacijent=" + pacijent.getPacijentID();
    }

    public int getRacunID() {
        return racunID;
    }

    public void setRacunID(int racunID) {
        this.racunID = racunID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public Pregled getPregled() {
        return pregled;
    }

    public void setPregled(Pregled pregled) {
        this.pregled = pregled;
    }

    public Pacijent getPacijent() {
        return pacijent;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }

    public List<StavkaRacuna> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaRacuna> stavke) {
        this.stavke = stavke;
    }

    @Override
    public String toString() {
        return "Racun{" + "racunID=" + racunID + ", datum=" + datum + ", zaposleni=" + zaposleni + ", pregled=" + pregled + ", pacijent=" + pacijent + ", stavke=" + stavke + '}';
    }
    
    
    
    
    
    
}
