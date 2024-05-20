/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Pacijent;
import domen.Racun;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vanja
 */
public class ModelTabeleRacuni extends AbstractTableModel {
    List<Racun> lista;
    String[] kolone = {"id","datum","pacijent","zaposleni","pregled"};

    public ModelTabeleRacuni(List<Racun> lista) {
        this.lista = lista;
        System.out.println("KLASA MTR");
        System.out.println(lista);
    } 
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         Racun r = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return r.getRacunID();
            case 1: return r.getDatum();
            case 2: return r.getPacijent().getIme();
            case 3: return r.getZaposleni().getIme()+" "+r.getZaposleni().getPrezime();
            case 4: return r.getPregled().getNaziv();
            default: return "NA";
        }
    }

    public List<Racun> getLista() {
        return lista;
    }

    public void setLista(List<Racun> lista) {
        this.lista = lista;
    }

 
 
}
