import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;

public class Nslookup extends JFrame {
    private JTextField textField_domain;
    private JButton btn_search;
    private JTextArea txt_result;
    private JPanel Nslookup_panel;

    public Nslookup() {
    btn_search.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String txtDomain = textField_domain.getText();
            try {
                InetAddress ipAddress = InetAddress.getByName(txtDomain);
                String ip = ipAddress.getHostAddress();
            txt_result.setText("IP: " + ip);

            }catch (Exception exception){
                txt_result.setText("Không tìm thấy địa chỉ IP");;
            }
        }
    });
}

    public static void main(String[] args) {
        Nslookup nslookup = new Nslookup();
        nslookup.setContentPane(nslookup.Nslookup_panel);
        nslookup.setTitle("search ip by domain");
        nslookup.setSize(400,150);
        nslookup.setVisible(true);
        nslookup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
