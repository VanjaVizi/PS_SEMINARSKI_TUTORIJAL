package operacija.pregledi;

import domen.Pregled;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author vanja
 */
public class UcitajPregledeSO extends ApstraktnaGenerickaOperacija {

    private List<Pregled> pregledi;

    @Override
    protected void preduslovi(Object param) throws Exception {
        // Nema posebnih preduslova za ovu operaciju
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        pregledi = broker.getAll(new Pregled(), "");
    }

    public List<Pregled> getPregledi() {
        return pregledi;
    }
}
