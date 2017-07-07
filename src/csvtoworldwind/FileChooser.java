package csvtoworldwind;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class FileChooser extends JFrame implements ActionListener {

    private JMenuItem miOpen;
    private File csvFile = new File(".");
    private JFileChooser fc = new JFileChooser();
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private DataModel dataModel = new DataModel();

    public FileChooser() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Choose .csv File");
        setBounds(screenSize.width / 2 - 250, screenSize.height / 2 - 150, 500, 300);
        JMenuBar mbFile = new JMenuBar();
        JMenu mFile = new JMenu("File");
        setJMenuBar(mbFile);
        mbFile.add(mFile);
        mFile.add(miOpen = new JMenuItem("Open..."));
        miOpen.addActionListener(this);
        setVisible(true);
        fc.setFileFilter(new CsvFileFilter());

    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == miOpen) {
            open();
        }
    }

    private void open() {
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {                          //7
            csvFile = fc.getSelectedFile();
            try {
                dataModel.readFile(csvFile);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FileChooser.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error", "File Not Found", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(FileChooser.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error", "Error Reading File", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
