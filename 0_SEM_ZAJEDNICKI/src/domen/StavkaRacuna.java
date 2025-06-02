/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vanja
 */
public class StavkaRacuna implements ApstraktniDomenskiObjekat{
    private int rb;
    private int kolicina;
    private double cena;
    private int racunId;
    private Tretman tretman;
    
    //TODO

    @Override
    public String vratiNazivTabele() {
        return "stavkaracuna";
    }

    public int getRacunId() {
        return racunId;
    }

    public void setRacunId(int racunId) {
        this.racunId = racunId;
    }



    @Override
    public String vratiKoloneZaUbacivanje() {
        return "rb,racun,kolicina,cena,tretman";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return rb+", "+racunId+", "+kolicina+","+cena+", "+tretman.getTretmanID();
    }

    @Override
    public String vratiPrimarniKljuc() {
       return " rb="+rb+ " AND racun="+racunId;
    }
    @Override
    public String vratiVrednostiZaIzmenu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        
         List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            StavkaRacuna stavka = new StavkaRacuna();
            stavka.setRb(rs.getInt("rb"));
            stavka.setKolicina(rs.getInt("kolicina"));
            stavka.setCena(rs.getDouble("stavkaracuna.cena"));

            Tretman tretman = new Tretman();
            tretman.setTretmanID(rs.getInt("tretmanID"));
            tretman.setNaziv(rs.getString("naziv"));
            tretman.setOpis(rs.getString("opis"));
            tretman.setCena(rs.getDouble("tretman.cena"));

            stavka.setTretman(tretman);

            lista.add(stavka);
        }
        return lista;
        
        
        
        
        
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Tretman getTretman() {
        return tretman;
    }

    public void setTretman(Tretman tretman) {
        this.tretman = tretman;
    }

    @Override
    public String toString() {
        return "StavkaRacuna{" + "rb=" + rb + ", kolicina=" + kolicina + ", cena=" + cena + ", tretman=" + tretman + '}';
    }

    
    
    
    
    
    
    
    
    
}
