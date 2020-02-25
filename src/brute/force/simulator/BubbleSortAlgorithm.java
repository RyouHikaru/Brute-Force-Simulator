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

public class BubbleSortAlgorithm extends JFrame{
    //<editor-fold defaultstate="collapsed" desc="Variable declaration">
    private static boolean alreadySorted;
    private static int[] array;
    private static int swapCount;
    private static int swapTotalCount;
    private static String pass;
    private final JLabel wpLabel;
    private static JLabel label1;
    private JButton returnButton;
    private static JScrollPane scrollPane;
    private static JTextArea textArea;
    //</editor-fold>
    
    public BubbleSortAlgorithm(int[] a, int aLength) {
        super("Bubble Sort");
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
                   swapCount = 0;
                   swapTotalCount = 0;
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
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        originalInput();
        bubbleSort(array);
    }
    /**
     * The core method of this class, which contains the bubble sort algorithm.
     * @param a integer array to be sorted.
     */
    public static void bubbleSort(int[] a) {
        int aLength = a.length;
        
        if (aLength == 1) {
            alreadySorted = true;
            pass = pass + "Pass # 1\n\n";
            pass += "   " + a[0] + " retained.\n\n";
            pass += formulateString(a);
            pass += "\nTotal swap: " + 0;
        }
        else  {
            //<editor-fold defaultstate="collapsed" desc="Main Algorithm">
            for (int i = 0; i < aLength - 1; i++) {
                pass = pass + "Pass # " + (i + 1) + "\n\n";
                for (int j = 0; j < aLength - i - 1; j++) {
                    if (a[j] > a[j + 1]) {
                        pass += "       " + a[j] + " swapped with " + a[j + 1] + "\n";
                        int temp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = temp;
                        swapCount++;
                    }
                    pass += formulateString(a);
                }
                pass = pass + "\n   Swap: " + swapCount + "\n\n";
                swapTotalCount += swapCount;
                swapCount = 0;
            }
            pass += "Total swaps: " + swapTotalCount;
        }
            //</editor-fold>
        
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
        return str + "\n";
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
