/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author vanja
 */
public class DodajPacijentaForm extends javax.swing.JFrame {

    /**
     * Creates new form DodajPacijentaForm
     */
    public DodajPacijentaForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldIme = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldRasa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldVlasnik = new javax.swing.JTextField();
        jButtonDodaj = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldDatum = new javax.swing.JTextField();
        jButtonAzuriraj = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ime");

        jTextFieldIme.setText("mrva");

        jLabel2.setText("rasa");

        jTextFieldRasa.setText("bison");

        jLabel3.setText("vlasnik");

        jTextFieldVlasnik.setText("vanja");

        jButtonDodaj.setText("dodaj");

        jLabel4.setText("dat. rodj (dd.MM.gggg)");

        jTextFieldDatum.setText("1.5.2022");

        jButtonAzuriraj.setText("azuriraj");

        jLabel5.setText("id");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(256, Short.MAX_VALUE)
                .addComponent(jButtonAzuriraj)
                .addGap(29, 29, 29)
                .addComponent(jButtonDodaj)
                .addGap(129, 129, 129))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldVlasnik)
                            .addComponent(jTextFieldDatum)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldid)
                                    .addComponent(jTextFieldIme)
                                    .addComponent(jTextFieldRasa, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldRasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldVlasnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDodaj)
                    .addComponent(jButtonAzuriraj))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAzuriraj;
    private javax.swing.JButton jButtonDodaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextFieldDatum;
    private javax.swing.JTextField jTextFieldIme;
    private javax.swing.JTextField jTextFieldRasa;
    private javax.swing.JTextField jTextFieldVlasnik;
    private javax.swing.JTextField jTextFieldid;
    // End of variables declaration//GEN-END:variables

    public void dodajAddActionListener(ActionListener actionListener) {
        jButtonDodaj.addActionListener(actionListener);
    }
    public void izmeniAddActionListener(ActionListener actionListener) {
        jButtonAzuriraj.addActionListener(actionListener);
    }
    public JTextField getjTextField1() {
        return jTextFieldDatum;
    }

    public JTextField getjTextFieldIme() {
        return jTextFieldIme;
    }

    public JTextField getjTextFieldRasa() {
        return jTextFieldRasa;
    }

    public JTextField getjTextFieldVlasnik() {
        return jTextFieldVlasnik;
    }

    public JButton getjButtonAzuriraj() {
        return jButtonAzuriraj;
    }

    public void setjButtonAzuriraj(JButton jButtonAzuriraj) {
        this.jButtonAzuriraj = jButtonAzuriraj;
    }

    public JButton getjButtonDodaj() {
        return jButtonDodaj;
    }

    public void setjButtonDodaj(JButton jButtonDodaj) {
        this.jButtonDodaj = jButtonDodaj;
    }

    public JTextField getjTextFieldDatum() {
        return jTextFieldDatum;
    }

    public void setjTextFieldDatum(JTextField jTextFieldDatum) {
        this.jTextFieldDatum = jTextFieldDatum;
    }

    public JTextField getjTextFieldid() {
        return jTextFieldid;
    }

    public void setjTextFieldid(JTextField jTextFieldid) {
        this.jTextFieldid = jTextFieldid;
    }
    
    
    
    
    
}
