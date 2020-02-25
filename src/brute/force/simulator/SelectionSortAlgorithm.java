package brute.force.simulator;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SelectionSortAlgorithm extends JFrame{
    //<editor-fold defaultstate="collapsed" desc="Variable declaration">
    private static boolean alreadySorted;
    private static int[] array;
    private static int swapCount;
    private static String pass;
    private final JLabel wpLabel;
    private static JLabel label1;
    private JButton returnButton;
    private static JScrollPane scrollPane;
    private static JTextArea textArea;
    //</editor-fold>
    
    public SelectionSortAlgorithm(int[] a, int aLength) {
        super("Selection Sort");
        alreadySorted = false;
        pass = "Original Array\n\n";
        
        swapCount = 0;
        array = new int[aLength];
        array = a;
        
        wpLabel = new JLabel(new ImageIcon("pixelwp.png"));
        wpLabel.setBounds(0, 0, 550, 600);
        
        label1 = new JLabel();
        textArea = new JTextArea(10, 10);
        scrollPane = new JScrollPane(textArea);
        
        returnButton = new JButton("Return");
        returnButton.setBounds(220, 500, 100, 25);
        returnButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == returnButton) {
                   new MainFrame();
                   dispose();
                }
            }  
        });
        label1.setBounds(500, 0, 100, 20);
        scrollPane.setBounds(65, 40, 400, 400);
        textArea.setEditable(false);
        
        this.add(scrollPane);
        this.add(returnButton);
        this.add(wpLabel);
         
        this.setLayout(null);
        this.setSize(550, 600);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        originalInput();
        selectionSort(array);
    }
    /**
     * The core method of this class, which contains the selection sort algorithm.
     * @param a integer array to be sorted.
     */
    public static void selectionSort(int[] a) {
        int min = 0;
        int aLength = a.length;
        int minIndex = 0;
        
        if (aLength == 1) {
            alreadySorted = true;
            pass = pass + "Pass # 1\n\n";
            pass += "   " + a[0] + " retained.\n\n";
            pass += formulateString(a);
            pass += "Total swap: " + 0;
        }
        else  {
        //<editor-fold defaultstate="collapsed" desc="Main Algorithm">
            for (int i = 0; i < aLength; i++) {
                pass = pass + "Pass # " + (i + 1) + "\n\n  ";
                min = a[i];
                minIndex = i;
                for (int j = i + 1; j < aLength; j++) {
                    if (a[j] < min) {
                        min = a[j];
                        minIndex = j;
                    }
                }
                pass = pass + "Min: " + Integer.toString(min) + "\n\n";
                
                if (minIndex == i) 
                    pass += "       " + a[minIndex] + " retained\n\n"; 
                else 
                    pass += "       " + a[minIndex] + " swapped with " + a[i] + "\n\n";
                
                a[minIndex] = a[i];
                if (a[minIndex] == a[i] && (alreadySorted == false)) {
                    swapCount++;
                    if (minIndex == i) 
                        swapCount--;
                }
                a[i] = min;
                if ((isSorted(a, aLength) == true) && (alreadySorted == false)) {
                    alreadySorted = true;
                }
                
                pass += formulateString(a);
            }
            //</editor-fold>
            pass += "Total swaps: " + swapCount;
        }
        textArea.setFont(new Font("Ink Free", Font.PLAIN, 20));
        textArea.setText(pass);
        pass = "Original Array\n\n";
    }      
    /**
     * Method used to display the elements of the array.
     * @param a integer array to be displayed.
     * @param length length of the array.
     */
    public static void displayArray(int[] a, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\n");
    }
    /**
     * Method used in checking if the array is sorted.
     * @param a integer array to be checked.
     * @param length the length of the array.
     * @return TRUE if it is already sorted, otherwise FALSE
     */
    public static boolean isSorted(int[] a, int length) {
        boolean sorted = true;
        
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (a[i] > a[j]) {
                    sorted = false;
                    break;
                }
            }
        }
        return sorted;
    }
    /**
     * Method used in formulating string for each Passes during the simulation.
     * @param a integer array which elements will be put in the string.
     * @return String containing array a's elements.
     */
    public static String formulateString(int[] a) {
        String str = "   ";
        for (int i = 0; i < a.length; i++) {
            str = str + a[i] + "  ";
        }
        return str + "\n\n";
    }
    /**
     * Method used in fetching the original order of the array.
     */
    public static void originalInput() {
        int length = array.length;
        pass += "   ";
        for (int i = 0; i < length; i++) {
            pass = pass + array[i] + "  ";
        }
        pass += "\n\n";
    }
}
