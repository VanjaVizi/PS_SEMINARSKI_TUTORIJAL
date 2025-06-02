package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author vanja
 */
public class Pregled implements ApstraktniDomenskiObjekat {
    private int id;
    private String naziv;
    private double cena; 

    public Pregled() {
    }

    public Pregled(int id, String naziv, double cena) {
        this.id = id;
        this.naziv = naziv;
        this.cena = cena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return naziv + " (" + cena + " RSD)";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naziv, cena);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Pregled other = (Pregled) obj;
        return id == other.id &&
               Double.compare(other.cena, cena) == 0 &&
               Objects.equals(naziv, other.naziv);
    }

    @Override
    public String vratiNazivTabele() {
        return "pregled";
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv,cena";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() { 
        return "'" + naziv + "'," + cena;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "pregled.id=" + id;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String naziv = rs.getString("naziv");
        double cena = rs.getDouble("cena");
        return new Pregled(id, naziv, cena);
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "naziv='" + naziv + "', cena=" + cena;
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String naziv = rs.getString("naziv");
            double cena = rs.getDouble("cena");
            lista.add(new Pregled(id, naziv, cena));
        }
        return lista;
    }
}
