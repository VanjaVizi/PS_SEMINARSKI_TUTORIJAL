package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author vanja
 */
public class Tretman implements ApstraktniDomenskiObjekat {
    private int tretmanID;
    private String naziv;
    private String opis;
    private double cena;

    public Tretman() {
    }

    public Tretman(int tretmanID, String naziv, String opis, double cena) {
        this.tretmanID = tretmanID;
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
    }

    public int getTretmanID() {
        return tretmanID;
    }

    public void setTretmanID(int tretmanID) {
        this.tretmanID = tretmanID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return naziv + " - " + cena + " RSD";
    }

    @Override
    public int hashCode() {
        return Objects.hash(tretmanID, naziv, opis, cena);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Tretman other = (Tretman) obj;
        return tretmanID == other.tretmanID &&
               Double.compare(other.cena, cena) == 0 &&
               Objects.equals(naziv, other.naziv) &&
               Objects.equals(opis, other.opis);
    }

    @Override
    public String vratiNazivTabele() {
        return "tretman";
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv,opis,cena";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + naziv + "','" + opis + "'," + cena;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "tretman.tretmanID=" + tretmanID;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "naziv='" + naziv + "', opis='" + opis + "', cena=" + cena;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        int id = rs.getInt("tretmanID");
        String naziv = rs.getString("naziv");
        String opis = rs.getString("opis");
        double cena = rs.getDouble("cena");

        return new Tretman(id, naziv, opis, cena);
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("tretmanID");
            String naziv = rs.getString("naziv");
            String opis = rs.getString("opis");
            double cena = rs.getDouble("cena");
            lista.add(new Tretman(id, naziv, opis, cena));
        }
        return lista;
    }
}
