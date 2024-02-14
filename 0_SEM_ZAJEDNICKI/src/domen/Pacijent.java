/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author vanja
 */
public class Pacijent implements ApstraktniDomenskiObjekat{
    private int pacijentID;
    private String ime;
    private String rasa;
    private String vlasnik;
    private Date datumrodj;

    public Pacijent() {
    }

    public Pacijent(int pacijentID, String ime, String rasa, String vlasnik) {
        this.pacijentID = pacijentID;
        this.ime = ime;
        this.rasa = rasa;
        this.vlasnik = vlasnik;
    }

    @Override
    public String toString() {
        return  ime ;
    }

    public int getPacijentID() {
        return pacijentID;
    }

    public void setPacijentID(int pacijentID) {
        this.pacijentID = pacijentID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    public String getVlasnik() {
        return vlasnik;
    }

    public void setVlasnik(String vlasnik) {
        this.vlasnik = vlasnik;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pacijent other = (Pacijent) obj;
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.rasa, other.rasa)) {
            return false;
        }
        return Objects.equals(this.vlasnik, other.vlasnik);
    }

    @Override
    public String vratiNazivTabele() {
        return "pacijent";
    }
    @Override
    public String vratiKoloneZaUbacivanje() { 
        return "ime,vlasnik,rasa";
    }
    @Override
    public String vratiVrednostiZaUbacivanje() {
        //"      '  mrva ','    vanja  ','  bison  '  "
        return  "'"+ime+"','"+vlasnik+"','"+rasa +"'";
        
    }
    @Override
    public String vratiVrednostiZaIzmenu() {
        return "ime='"+ime+"', vlasnik='"+vlasnik+"', rasa='"+rasa+"'";
    
    }
    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int pacijentId = rs.getInt("pacijent.pacijentID");
            String ime   = rs.getString("pacijent.ime");
             String vlasnik   = rs.getString("pacijent.vlasnik");
              String rasa   = rs.getString("pacijent.rasa");
              
              Pacijent p = new Pacijent(pacijentId, ime, rasa, vlasnik);
              lista.add(p);
              
        }
            System.out.println("KLASA PACIJENT:" +lista);
        
        return lista;
    }





    @Override
    public String vratiPrimarniKljuc() {
        //pacijent.pacijentId=2
        return "pacijent.pacijentId="+pacijentID;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
    
    
}
