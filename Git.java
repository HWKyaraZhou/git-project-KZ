import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Git {
    public Git () throws IOException {
        File gitDirectory = new File ("git");
        File objectsDirectory = new File ("git/objects");
        String indexFileName = "index";
        File indexFile = new File (gitDirectory, indexFileName);
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

    public void makeBLOB (String fileName) throws IOException, NoSuchAlgorithmException {
        String hash = hashingFunction(fileName);
        File newObject = new File ("git/objects/hash");
        newObject.mkdirs();
    }

}