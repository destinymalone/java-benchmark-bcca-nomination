
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class NomineeInformation {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Nominee> nominees = loadForm();

        System.out.println("Student Nomination Form");

        // for (Nominee nominee : nominees) {
        // System.out.println(nominee.name);
        // }

        Nominee nominee = startForm();

        nominees.add(nominee);

        displayForm(nominee);

        saveNominations(nominees);

    }

    private static Nominee startForm() {
        while (true) {
            System.out.print("Your Name: ");
            String name = in.nextLine();
            System.out.print("Age: ");
            String age = in.nextLine();
            System.out.print("Student Contact Information: ");
            String contactInfo = in.nextLine();
            System.out.print("Expected Graduation Date(mm/dd/yyyy): ");
            String expectedGradDate = in.nextLine();
            System.out.println(
                    "Base Camp Coding Academy looks for students with the aptitude and dedication to succeed in this program. Please explain why you believe this student will make an excellent candidate: ");
            System.out.println("Aptitude: ");
            System.out.println(
                    "Do you have any experiences when this student has demonstrated a string ability to think logically and/or strategically? ");
            String aptitude = in.nextLine();
            System.out.println("Perseverance: ");
            System.out.println(
                    "Is there any evidence of the applicant being engaged in something they are passionate about? (This can be clubs, sports teams, band, church groups, hobbies,etc.)");
            String perseverance = in.nextLine();
            System.out.println("Dedication: ");
            System.out.println(
                    "Do you think the applicant would be able to reliably attend the program five days a week in Water Valley? (Please explain any truancy challenges the applicant may have faced in the past.)");
            String dedication = in.nextLine();
            System.out.print("Work Ethic/Heart: Why does this student deserve a position at Base Camp? ");
            String workEthicOrHeart = in.nextLine();
            System.out.println("Anything else you'd like to share about this nominee? ");
            String anythingElse = in.nextLine();
            System.out.print("[Q]uit: ");
            String quite = in.nextLine();
            if (quite.equalsIgnoreCase("Q")) {
                return null;
            } else {
                return new Nominee(name, age, contactInfo, expectedGradDate, aptitude, perseverance, dedication,
                        workEthicOrHeart, anythingElse);
            }
        }
    }

    // public static void displayList(ArrayList<Nominee> nominees) {
    // for (int i = 0; i < nominees.size(); i++)
    // System.out.println(nominees.get(i));
    // }
    private static void displayForm(Nominee nominee) {
        System.out.println("--- Nomination Form ---");
        System.out.println("Nominee: " + nominee.name);
        System.out.println("Age: " + nominee.age);
        System.out.println("Contact Information: " + nominee.contactInfo);
        System.out.println("Expected Graduation Date: " + nominee.expectedGradDate);

    }

    public static ArrayList<Nominee> loadForm() {
        try {
            FileInputStream fileStream = new FileInputStream("nominees.ser");
            ObjectInputStream os = new ObjectInputStream(fileStream);
            ArrayList<Nominee> nominees = (ArrayList<Nominee>) os.readObject();
            os.close();
            return nominees;
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<Nominee>();
        }
    }

    private static void saveNominations(ArrayList<Nominee> nominees) {
        try {
            FileOutputStream fileStream = new FileOutputStream("nominees.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(nominees);
            os.close();
        } catch (IOException ex) {
            System.out.println("Failed to save nominations.");
        }
    }
}