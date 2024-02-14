/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import com.sun.java.accessibility.util.AWTEventMonitor;
import cordinator.Cordinator;
import domen.Zaposleni;
import forme.LoginForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import komunikacija.Zahtev;

/**
 *
 * @author vanja
 */
public class LoginController {
    private final LoginForma lf;

    public LoginController(LoginForma lf) {
        this.lf = lf;
        addActionListeners();
    }

    private void addActionListeners() {
        
         lf.loginAddActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 prijava(e);
             }

             private void prijava(ActionEvent e) {
                 String ki = lf.getjTextFieldUsername().getText().trim();
                 String pass =  String.valueOf(lf.getjPasswordField1().getPassword());
                  
                 Komunikacija.getInstanca().konekcija();
                 Zaposleni ulogovani =Komunikacija.getInstanca().login(ki,pass);
                 
                 if(ulogovani==null){
                      JOptionPane.showMessageDialog(lf, "Prijava na sistem neuspesna","GRESKA",JOptionPane.ERROR_MESSAGE);
                 }else{
                     Cordinator.getInstanca().setUlogovani(ulogovani);
                      JOptionPane.showMessageDialog(lf, "Prijava na sistem uspesna","Uspeh",JOptionPane.INFORMATION_MESSAGE);
                     Cordinator.getInstanca().otvoriGlavnuFormu();
                      lf.dispose();
                 }
             }
         });
        
    }

    public void otvoriFormu() {
        lf.setVisible(true);
    }
    
    
    
    
    
}
