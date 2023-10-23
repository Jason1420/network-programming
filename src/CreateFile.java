import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class CreateFile extends  JFrame {


    private JPanel createFile_panel;
    private JTextField txt_folder;
    private JButton openButton;
    private JButton btn_create;
    private JTextField txt_fileName;

    public CreateFile() {
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int result = fileChooser.showOpenDialog(CreateFile.this);
                if(result == JFileChooser.APPROVE_OPTION){
                    String path = fileChooser.getSelectedFile().getAbsolutePath();
                    txt_folder.setText(path);
                }
            }
        });
        btn_create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = txt_folder.getText() +"\\"+txt_fileName.getText();
                File newFile = new File(path);
                if(txt_fileName.getText().trim().length() == 0){
                    JOptionPane.showMessageDialog(CreateFile.this,"Bạn chưa nhập tên file");
                }
                if(newFile.exists()){
                JOptionPane.showMessageDialog(CreateFile.this,"Tập tin đã tồn tại");
                }else{
                        try {
                            newFile.createNewFile();
                        }catch (Exception exception){;
                            JOptionPane.showMessageDialog(CreateFile.this,"Không thể tạo được tệp tin");
                        }
                }
            }
        });
    }

    public static void main(String[] args) {
        try {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }catch (Exception exception){
        }
        CreateFile createFile = new CreateFile();
        createFile.setContentPane(createFile.createFile_panel);
        createFile.setTitle("search ip by domain");
        createFile.setSize(400,150);
        createFile.setVisible(true);
        createFile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
