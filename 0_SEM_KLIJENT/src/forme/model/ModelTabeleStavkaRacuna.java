/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Racun;
import domen.StavkaRacuna;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vanja
 */
public class ModelTabeleStavkaRacuna extends AbstractTableModel {
    List<StavkaRacuna> lista;
    String[] kolone = {"rb","kolicina","cena","tretman" };

    public ModelTabeleStavkaRacuna(List<StavkaRacuna> lista) {
        this.lista = lista;
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
         StavkaRacuna sr = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return sr.getRb();
            case 1: return sr.getKolicina();
            case 2: return sr.getCena();
            case 3: return sr.getTretman().getNaziv(); 
            default: return "NA";
        }
    }

    public List<StavkaRacuna> getLista() {
        return lista;
    }

    public void setLista(List<StavkaRacuna> lista) {
        this.lista = lista;
    }

  
 
 
}

