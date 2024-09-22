import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Git {
    File gitDirectory = new File ("git");
    File objectsDirectory = new File ("git/objects");
    String indexFileName = "index";
    File indexFile = new File (gitDirectory, indexFileName);
    public Git () throws IOException {
        if (!gitDirectory.exists()) {
            gitDirectory.mkdir();
            objectsDirectory.mkdirs();
            indexFile.createNewFile();
        }
        else if (objectsDirectory.exists() && !indexFile.exists()){
            indexFile.createNewFile();
        }
        else if (indexFile.exists() && !objectsDirectory.exists()) {
            objectsDirectory.mkdirs();
        }
        else if (!indexFile.exists() && !objectsDirectory.exists()) {
            indexFile.createNewFile();
            objectsDirectory.mkdirs();
        }
        else {
            System.out.println("Git Repository already exists");
        }
    }
    
    public String hashingFunction(String fileName) throws FileNotFoundException, NoSuchAlgorithmException, IOException {
        File file = new File(fileName);
        MessageDigest digest = MessageDigest.getInstance("SHA-1");

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] byteArray = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(byteArray)) != -1) {
                digest.update(byteArray, 0, bytesRead);
            }
        }
        
        byte[] hash = digest.digest();
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public void fileWriter (String toRead, File toWrite) throws IOException {
        BufferedWriter bw = new BufferedWriter (new FileWriter (toWrite));
        BufferedReader br = new BufferedReader(new FileReader(toRead));
        while (br.ready()) {
            bw.append((char) br.read());
        }
        br.close();
        bw.close(); 
    }

    public void makeBLOB (String fileName) throws IOException, NoSuchAlgorithmException {
        String hash = hashingFunction(fileName);
        File file = new File ("git/objects", hash);
        file.createNewFile();
        fileWriter (fileName,file);
        String toAppend = hash + " " + new File(fileName).getName();
        BufferedWriter bw = new BufferedWriter(new FileWriter (indexFile));
        for (int i = 0; i < toAppend.length(); i++) {
            bw.append(toAppend.charAt(i));
        }
        bw.append("\n");
        bw.close();
    }

}