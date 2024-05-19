public class Member {
    private String firstName;
    private String secondName;
    private int age;
    private boolean competitiveMember;
    private boolean activeMember;
    private boolean seniorMember;


    public Member(String name, String secondName, int age, boolean competitiveMember) {
        this.firstName = name;
        this.secondName = secondName;
        this.age = age;
        this.competitiveMember = competitiveMember;
        this.seniorMember = memberStatus();
        this.activeMember = true;
    }

    public Member(String name, String secondName, int age, boolean activeMember, boolean competitiveMember, boolean seniorMember) {
        this.firstName = name;
        this.secondName = secondName;
        this.age = age;
        this.activeMember = activeMember;
        this.competitiveMember = competitiveMember;
        this.seniorMember = seniorMember;
    }
    public Member(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getCompetitiveMember() {
        return competitiveMember;
    }

    public void setCompetitiveMember(boolean competitiveMember) {
        this.competitiveMember = competitiveMember;
    }

    public boolean getActiveMember() {
        return activeMember;
    }

    public void setActiveMember(boolean activeMember) {
        this.activeMember = activeMember;
    }

    public boolean getSeniorMember() {
        return seniorMember;
    }

    public void setSeniorMember(boolean seniorMember) {
        this.seniorMember = seniorMember;
    }

    public boolean memberStatus() {
        boolean memberstatus = true;
        if (getAge() <= 18) {
            memberstatus = false;
        }
        return memberstatus;
    }

    public String getStringToSave() {
        return getFirstName() + "," + getSecondName() + "," + getAge() + "," + getActiveMember() + "," + getCompetitiveMember() + "," + getSeniorMember();
    }

    public String toString() {
        String isCompetitive;
        String memberStatus = null;
        if (competitiveMember = true) {
            isCompetitive = "Ja";
        } else {
            isCompetitive = "Nej";
        }
        if (activeMember && seniorMember) {
            memberStatus = "Senior";
        }
        if (activeMember && !seniorMember) {
            memberStatus = "Junior";
        }
        if (!activeMember) {
            memberStatus = "Passiv";
        }
        return "Fornavn: " + firstName + "\nEfternavn: " + secondName + "\nAlder: " + age + "\nMedlemsstatus: " + memberStatus + "\nKonkurrencesvømmer: " + isCompetitive + "\n---------------------------";
    }
}
