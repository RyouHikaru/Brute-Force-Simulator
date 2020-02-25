package brute.force.simulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputFrame extends JFrame {             
    //<editor-fold defaultstate="collapsed" desc="Variable Declaration">
    private JButton addButton;
    private JButton doneButton;
    private JButton returnButton;
    private JTextField inputTextField;
    private ArrayList<Integer> aList;
    private JPanel inPanel;
    private final JLabel inLabel = new JLabel(new ImageIcon("input.png"));
    private final int sortingOption;  // just an extra variable to decide if Selection or Bubble
    //</editor-fold>
    
    public InputFrame(int s) {
        super("Input");
        
        aList = new ArrayList();
        sortingOption = s;
        inPanel = new JPanel();
        
        initComponents();
        inPanel.add(inLabel);
        inPanel.setBounds(45, 50, 400, 110);
        inPanel.setOpaque(false);
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.add(inPanel);
    }
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code: Initialize Components">                          
    private void initComponents() {
        inputTextField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        doneButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inputTextField.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        inputTextField.setToolTipText("Press ENTER to add. Press F if your'e finished.");
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        inputTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_ENTER) {
                    addElement();
                    inputTextField.setText("");
                }
                else if (key == KeyEvent.VK_F) {
                    inputTextField.setFocusable(false);
                    inputTextField.setText("");
                    doneAdding();
                    inputTextField.setFocusable(true);
                    inputTextField.requestFocus();
                }
                else {
                    inputTextField.requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
        
        doneButton.setText("DONE");
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });
        
        returnButton = new JButton("RETURN");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnOption = JOptionPane.showConfirmDialog(rootPane, "Return back to Main Screen?", "Cancel operation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (returnOption == 0) {
                    returnButtonActionPerformed(e); 
                }
            }
        });
        //<editor-fold defaultstate="collapsed" desc="Layout">
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(163, 163, 163)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(22, 22, 22)
                                                                .addComponent(doneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(inputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(42, 42, 42)
                                                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(203, 203, 203)
                                                .addComponent(returnButton)))
                                .addContainerGap(168, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(184, Short.MAX_VALUE)
                                .addComponent(inputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addButton)
                                .addGap(44, 44, 44)
                                .addComponent(doneButton)
                                .addGap(18, 18, 18)
                                .addComponent(returnButton)
                                .addGap(18, 18, 18))
        );
        pack();
    }
    //</editor-fold>
    // </editor-fold>                                                               

    /**
     * Method invoked when the Add button is pressed.
     * @param evt action event to be handled.
     */
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) { 
        addElement();
    }   
    /**
     * Method called upon pressing Enter or pressing the Add button. This method
     * is responsible for adding elements in the array to be simulated. Input
     * validation is included.
     */
    public void addElement() {
        int currElement = 0;
        //<editor-fold defaultstate="collapsed" desc="Exception Handling">
        try {
            currElement = Integer.parseInt(inputTextField.getText());
            if (currElement < 0) {
                throw new NegativeNumberException();
            }
        }
        catch(NumberFormatException nfe) {
            JOptionPane.showConfirmDialog(rootPane, "Please enter numbers only", "Invalid Input", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
            return;
        }
        catch (NegativeNumberException ex) {
            JOptionPane.showConfirmDialog(rootPane, ex.getMessage(), "Negative Number Found", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
            return;
        }
        //</editor-fold>
        
        if (aList.contains(currElement)) {
            System.out.println("Duplicate found.");
            JOptionPane.showConfirmDialog(rootPane, "Number already added.", "Duplicate Found", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            inputTextField.setText("");
            return;
        }
        aList.add(Integer.parseInt(inputTextField.getText()));
        inputTextField.setText("");
        System.out.println(aList);
        
    }
    /**
     * Method invoked when the Done button is pressed.
     * @param evt action event to be handled.
     */
    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {    
        doneAdding();
    }    
    /**
     * Prompts the user if he is finished adding elements to the array
     */
    public void doneAdding() {  
        int option = JOptionPane.showConfirmDialog(rootPane, "Done adding?");
        if (option == 0) {
            if (aList.isEmpty()) {
                JOptionPane.showConfirmDialog(rootPane, "Please add atleast 1 number", "No elements added.", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if (sortingOption == 0) {   // If SELECTION SORT is chosen DO THIS
                System.out.println("Selection");
                int cap = aList.size();
                SelectionSortAlgorithm s = new SelectionSortAlgorithm(toInt(aList, cap), cap); // create a new frame for Selection Sort
            }
            else {  // If BUBBLE SORT is chosen DO THIS
                System.out.println("Bubble");
                int cap = aList.size();
                BubbleSortAlgorithm b = new BubbleSortAlgorithm(toInt(aList, cap), cap); // create a new frame for Bubble Sort
            }   
            super.dispose();    // dispose this frame
        }
        else {
            return;
        }
    }
    /**
     * Method to convert ArrayList<Integer> to integer array
     * @param a the ArrayList to be converted
     * @param length the size of ArrayList
     * @return an integer array from the converted ArrayList
     */
    public int[] toInt(ArrayList<Integer> a, int length) {
        int[] ret = new int[length];
        for (int i = 0; i < length; i++) {
            ret[i] = a.get(i);
        }
        return ret;
    }
    /**
     * Method invoked when the Return Button is pressed.
     * @param evt action event to be handled.
     */
    public void returnButtonActionPerformed(ActionEvent evt) {
        new MainFrame();
        dispose();
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
            java.util.logging.Logger.getLogger(InputFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }            
}
