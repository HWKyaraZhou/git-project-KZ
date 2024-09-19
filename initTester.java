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
        Git myGit1 = new Git();
        System.out.println("Case 1: Has Everything");
        System.out.println("Expected Output: Git Directory, Objects Directory, and Index File DELETED.");
        System.out.print("Tester Output: ");
        deleteCurrent();
        System.out.println("");

        System.out.println("Case 2: Has Git Direcotry with Nothing Inside");
        Git myGit2 = new Git();
        objectsDirectory.delete();
        indexFile.delete();
        System.out.println("Expected Output: Git Directory DELETED. Objects Directory and Index File DID NOT EXIST.");
        System.out.print("Tester Output: ");
        deleteCurrent();
        System.out.println("");

        System.out.println("Case 3: Has Git Directory with No Objects Directory");
        Git myGit3 = new Git();
        objectsDirectory.delete();
        System.out.println("Expected Output: Git Directory, and Index File DELETED. Objects Directory DID NOT EXIST.");
        System.out.print("Tester Output: ");
        deleteCurrent();
        System.out.println("");

        System.out.println("Case 3: Has Git Directory with No Index File");
        Git myGit4 = new Git();
        indexFile.delete();
        System.out.println("Expected Output: Git Directory, and Objects Directory DELETED. Index File DID NOT EXIST.");
        System.out.print("Tester Output: ");
        deleteCurrent();
        System.out.println("");

        System.out.println("Case 3: Has Nothing");
        System.out.println("Expected Output: Git Directory, Objects Directory, and Index File ALL DID NOT EXIST");
        System.out.print("Tester Output: ");
        deleteCurrent();
        System.out.println("");

    }
}
