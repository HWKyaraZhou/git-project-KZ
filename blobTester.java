import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class blobTester {
    public static void main (String [] args) throws NoSuchAlgorithmException, IOException {
        Git myGit = new Git ();
        myGit.makeBLOB("README.md");
        myGit.makeBLOB("readMe2.txt");
    }
}
