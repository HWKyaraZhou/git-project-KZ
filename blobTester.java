import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

public class blobTester {
    public static void main (String [] args) throws NoSuchAlgorithmException, IOException {
        Git myGit = new Git();

        boolean one = true;
        boolean two = true;
        boolean three = true;

        String input1 = JOptionPane.showInputDialog("What is your favorite ice cream flavor? Why? ");
        if (input1 == null || input1.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No input was provided!", "Error", JOptionPane.ERROR_MESSAGE);
            one = false;
        }
        String input2 = JOptionPane.showInputDialog("Do you have a favorite student? Why? ");
        if (input2 == null || input2.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No input was provided!", "Error", JOptionPane.ERROR_MESSAGE);
            two = false;
        }
        String input3 = JOptionPane.showInputDialog("Will you give me an A? Why? ");
        if (input3 == null || input3.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No input was provided!", "Error", JOptionPane.ERROR_MESSAGE);
            three = false;
        }

        if (one == false && two == false && three == false) {
            JOptionPane.showMessageDialog(null, "You provided no answers to any of my questions...I guess you hate me!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            File file1 = new File("file1");
            File file2 = new File ("file2");
            File file3 = new File ("file3");
            BufferedWriter bw1 = new BufferedWriter(new FileWriter(file1));
            bw1.write(input1);
            bw1.close();
            BufferedWriter bw2 = new BufferedWriter(new FileWriter(file2));
            bw2.write(input2);
            bw2.close();
            BufferedWriter bw3 = new BufferedWriter(new FileWriter(file3));
            bw3.write(input3);
            bw3.close();

            myGit.makeBLOB("file1");
            myGit.makeBLOB("file2");
            myGit.makeBLOB("file3");
        }
    }
}
