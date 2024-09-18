import java.io.File;

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
}