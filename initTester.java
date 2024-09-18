import java.io.File;

public class initTester {
    public static void deleteCurrent () {
        File gitDirectory = new File ("git");
        File objectsDirectory = new File ("git/objects");
        File indexFile = new File ("git/index");
        if (gitDirectory.exists() && objectsDirectory.exists() && indexFile.exists()) {
            gitDirectory.delete();
            objectsDirectory.delete();
            indexFile.delete();
            System.out.println("Git Directory, Objects Directory, and Index File DELETED.");
        }
        else if (gitDirectory.exists() && objectsDirectory.exists() && !indexFile.exists()) {
            gitDirectory.delete();
            objectsDirectory.delete();
            System.out.println("Git Directory, and Objects Directory DELETED. Index File DID NOT EXIST.");
        }
        else if (gitDirectory.exists() && !objectsDirectory.exists() && indexFile.exists()) {
            gitDirectory.delete();
            indexFile.delete();
            System.out.println("Git Directory, and Index File DELETED. Objects Directory DID NOT EXIST.");
        }
        else if (!gitDirectory.exists() && objectsDirectory.exists() && indexFile.exists()) {
            objectsDirectory.delete();
            indexFile.delete();
            System.out.println("Objects Directory, and Index File DELETED. Git Directory DID NOT EXIST.");
        }
        else if (!gitDirectory.exists() && !objectsDirectory.exists() && indexFile.exists()) {
            indexFile.delete();
            System.out.println("Index File DELETED. Git Directory and Objects Directory DID NOT EXIST.");
        }
        else if (!gitDirectory.exists() && objectsDirectory.exists() && !indexFile.exists()) {
            objectsDirectory.delete();
            System.out.println("Objects Directory DELETED. Git Directory and Index File DID NOT EXIST.");
        }
        else if (gitDirectory.exists() && !objectsDirectory.exists() && !indexFile.exists()) {
            gitDirectory.delete();
            System.out.println("Git Directory DELETED. Objects Directory and Index File DID NOT EXIST.");
        }
        else {
            System.out.println("Git Directory, Objects Directory, and Index File ALL DID NOT EXIST");
        }

    }
    public static void main (String [] args) {
        File gitDirectory = new File ("git");
        File objectsDirectory = new File ("git/objects");
        File indexFile = new File ("git/index");
        Git myGit = new Git();
        System.out.println("Case 1: Has Everything");
        System.out.println("Expected Output: Git Directory, Objects Directory, and Index File DELETED.");
        System.out.print("Tester Output: ");
        deleteCurrent();
        System.out.println("");
        

    }
}
