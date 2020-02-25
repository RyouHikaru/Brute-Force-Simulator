package brute.force.simulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
    //<editor-fold defaultstate="collapsed" desc="Variable Declaration">
    private final JLabel wpLabel;
    private final JLabel wcLabel;
    private JPanel wcPanel;
    private JButton selectionButton;
    private JButton bubbleButton;
    private JLabel welcomeLabel;
    private JLabel chooseLabel;
    //</editor-fold>
   
    public MainFrame() {
        super("Brute-force Simulator");
        
        wpLabel = new JLabel(new ImageIcon("pixelwp.png"));
        wcLabel = new JLabel(new ImageIcon("welcome.png"));
        
        initComponents();
        
        this.add(wcPanel);    
        this.add(wpLabel);
        this.setLayout(null);
        this.setSize(680, 500);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Initialize Components">                          
    private void initComponents() { 
        wcPanel = new JPanel();
        wcPanel.add(wcLabel);
        wcPanel.setBounds(130, 75, 400, 110);
        wcPanel.setOpaque(false);
        
        wpLabel.setBounds(0, 0, 680, 500);
        welcomeLabel = new JLabel();
        chooseLabel = new JLabel();
        selectionButton = new JButton();
        bubbleButton = new JButton();

        welcomeLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        welcomeLabel.setText("Welcome to Brute-force Algorithm Simulator!");
        welcomeLabel.setBounds(100, 80, 500, 100);

        chooseLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        chooseLabel.setText("Choose what kind of Sorting algorithm you want to test:");
        chooseLabel.setBounds(110, 200, 500, 100);
        this.add(chooseLabel);

        selectionButton.setText("Selection");
        selectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionButtonActionPerformed(evt);
            }
        });
        selectionButton.setBounds(165, 300, 100, 50);
        selectionButton.setFocusable(false);
        this.add(selectionButton);

        bubbleButton.setText("Bubble");
        bubbleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bubbleButtonActionPerformed(evt);
            }
        });
        bubbleButton.setBounds(400, 300, 100, 50);
        bubbleButton.setFocusable(false);
        this.add(bubbleButton);
    }
    // </editor-fold> 
    /**
     * Method invoked if Selection Sort is selected.
     * Creates a new InputFrame class to simulate selection sort.
     * @param evt action event to be recognized
     */
    private void selectionButtonActionPerformed(ActionEvent evt) {       
        this.setVisible(false);
        InputFrame sFrame = new InputFrame(0);
        sFrame.setVisible(true);
        sFrame.add(wpLabel);
    }
    /**
     * Method invoked if Bubble Sort is selected.
     * Creates a new InputFrame class to simulate bubble sort.
     * @param evt action event to be recognized
     */
    private void bubbleButtonActionPerformed(ActionEvent evt) {     
        this.setVisible(false);
        InputFrame sFrame = new InputFrame(1);
        sFrame.setVisible(true);
        sFrame.add(wpLabel);
    }    
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Nimbus look and feel (Auto-generated) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        // Creating a Sample object
        new MainFrame();
    }            
}
