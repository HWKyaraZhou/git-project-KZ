import java.io.File;

public class Git {
    public Git () {
        File gitDirectory = new File ("git");
        if (!gitDirectory.exists()) {
            gitDirectory.mkdir();
            File objectsDirectory = new File ("git/objects");
            objectsDirectory.mkdirs();
            File indexFile = new File ("git/index");
            indexFile.mkdirs();

        }
    }
    
    public static void main (String [] args)
    {
        Git newGit = new Git();
        System.out.println ("Made a Git!");
    }
}