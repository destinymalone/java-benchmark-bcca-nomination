
public class Nominator {
    String name;
    String emailAddress;
    String schoolDistrictOrAffiliation;
    String position;
    String relationshipToNominee;

    public Nominator(String name, String emailAddress, String schoolDistrictOrAffiliation, String position,
            String relationshipToNominee) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.schoolDistrictOrAffiliation = schoolDistrictOrAffiliation;
        this.position = position;
        this.relationshipToNominee = relationshipToNominee;
    }
}