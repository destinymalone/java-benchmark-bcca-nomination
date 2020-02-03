import java.io.Serializable;

public class Nominee implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    String age;
    String contactInfo;
    String expectedGradDate;
    String aptitude;
    String perseverance;
    String dedication;
    String workEthicOrHeart;
    String anythingElse;

    public Nominee(String name, String age, String contactInfo, String expectedGradDate, String aptitude,
            String perseverance, String dedication, String workEthicOrHeart, String anythingElse) {
        this.name = name;
        this.age = age;
        this.contactInfo = contactInfo;
        this.expectedGradDate = expectedGradDate;
        this.aptitude = aptitude;
        this.perseverance = perseverance;
        this.dedication = dedication;
        this.workEthicOrHeart = workEthicOrHeart;
        this.anythingElse = anythingElse;
    }
}