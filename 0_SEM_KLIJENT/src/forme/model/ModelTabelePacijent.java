/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

 
import domen.Pacijent;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vanja
 */
public class ModelTabelePacijent extends AbstractTableModel {

    List<Pacijent> lista;
    String[] kolone = {"id","ime","rasa","vlasnik"};

    public ModelTabelePacijent(List<Pacijent> lista) {
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
        Pacijent p = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return p.getPacijentID();
            case 1: return p.getIme();
            case 2: return p.getRasa();
            case 3: return p.getVlasnik();
            default: return "NA";
        }
    }

    public List<Pacijent> getLista() {
        return lista;
    }

    public void pretrazi(String ime, String rasa, String vlasnik) {
        
         List<Pacijent> filteredList = lista.stream()
            .filter(p -> (ime == null || ime.isEmpty() || p.getIme().toLowerCase().contains(ime.toLowerCase())))
            .filter(p -> (rasa == null || rasa.isEmpty() || p.getRasa().toLowerCase().contains(rasa.toLowerCase())))
            .filter(p -> (vlasnik == null || vlasnik.isEmpty() || p.getVlasnik().toLowerCase().contains(vlasnik.toLowerCase())))
            .collect(Collectors.toList());
         this.lista = filteredList;
         fireTableDataChanged();
    }
    
}
