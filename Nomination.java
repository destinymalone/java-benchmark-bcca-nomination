
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Nomination {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Nominator> nominators = loadForm();
        System.out.println("Student Nomination Form");

        for (Nominator nominator : nominators) {
            System.out.println(nominator.name);
        }

        Nominator nominator = startForm();

        nominators.add(nominator);

        displayForm(nominator);

        saveNominations(nominators);

    }

    private static Nominator startForm() {
        while (true) {
            System.out.print("Your Name: ");
            String name = in.nextLine();
            System.out.print("Email Address: ");
            String emailAddress = in.nextLine();
            System.out.print("School District/Affiliation: ");
            String schoolDistrictOrAffiliation = in.nextLine();
            System.out.print("Position: ");
            String position = in.nextLine();
            System.out.print("Relationship to Nominee: ");
            String relationshipToNominee = in.nextLine();
            System.out.print("[Q]uit: ");
            String quite = in.nextLine();
            if (quite.equalsIgnoreCase("Q")) {
                return null;
            } else {
                return new Nominator(name, emailAddress, schoolDistrictOrAffiliation, position, relationshipToNominee);
            }
        }
    }

    // public static void displayList(ArrayList<Nominee> nominees) {
    // for (int i = 0; i < nominees.size(); i++)
    // System.out.println(nominees.get(i));
    // }

    private static void displayForm(Nominator nominator) {
        System.out.println("--- Nomination Form ---");
        System.out.println("Nominator: " + nominator.name);
        System.out.println("Email: " + nominator.emailAddress);
        System.out.println("School District/Affiliation: " + nominator.schoolDistrictOrAffiliation);
        System.out.println("Position: " + nominator.position);
        System.out.println("Relationship to Nominee: " + nominator.relationshipToNominee);

    }

    public static ArrayList<Nominator> loadForm() {
        try {
            FileInputStream fileStream = new FileInputStream("nominations.ser");
            ObjectInputStream os = new ObjectInputStream(fileStream);
            ArrayList<Nominator> nominators = (ArrayList<Nominator>) os.readObject();
            os.close();
            return nominators;
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<Nominator>();
        }
    }

    private static void saveNominations(ArrayList<Nominator> nominators) {
        try {
            FileOutputStream fileStream = new FileOutputStream("nominations.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(nominators);
            os.close();
        } catch (IOException ex) {
            System.out.println("Failed to save nominations.");
        }
    }
}