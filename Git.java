import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Git {
    public Git () {
        File gitDirectory = new File ("git");
        File objectsDirectory = new File ("git/objects");
        File indexFile = new File ("git/index");
        if (!gitDirectory.exists()) {
            gitDirectory.mkdir();
            objectsDirectory.mkdirs();
            indexFile.mkdirs();
        }
        else if (objectsDirectory.exists() && !indexFile.exists()){
            indexFile.mkdirs();
        }
        else if (indexFile.exists() && !objectsDirectory.exists()) {
            objectsDirectory.mkdirs();
        }
        else if (!indexFile.exists() && !objectsDirectory.exists()) {
            indexFile.mkdirs();
            objectsDirectory.mkdirs();
        }
        else {
            System.out.println("Git Repository already exists");
        }
    }
    
    public String hashingFunction (String fileName) throws FileNotFoundException {
        File file = new File (fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        return "";
    }
    public void fileWriter (String fileName) throws IOException {
        String hash = hashingFunction(fileName);
        File objectsDirectory = new File ("git/objects/hash");
        objectsDirectory.mkdirs();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        BufferedWriter bw = new BufferedWriter(new FileWriter("git/objects/hash"));
        while (br.ready()) {
            bw.write(br.read());
        }
        
    }

    public void makeBLOB (String fileName) throws FileNotFoundException {
        fileWriter(fileName);
    }

}