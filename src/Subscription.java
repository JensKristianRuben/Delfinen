import java.util.ArrayList;

public class Subscription {
    private Member member;
    private int subscription;
    private boolean restance;


    public Subscription(Member member) {
        this.member = member;
        this.subscription = calculateSubscription(member);
        this.restance = false;
    }
    public Subscription(Member member, boolean restance) {
        this.member = member;
        this.subscription = calculateSubscription(member);
        this.restance = restance;
    }
    public Subscription(){

    }


    public int calculateSubscription(Member member) {
        if (member.getActiveMember()) {
            if (member.getActiveMember() && member.getAge() < 18)
                return 1000;
            if (member.getActiveMember() && member.getAge() < 60) {
                return 1600;
            }
            if (member.getSeniorMember() && member.getAge() > 60) {
                return (int) (1600 * 0.75);
            }
        } else {
            return 500;
        }
        return 1000;
    }

    public int calculateYearlyIncome(ArrayList<Subscription> subscriptions) {
        int yearlyIncome = 0;
        for (Subscription subscription : subscriptions) {
            yearlyIncome += subscription.getSubscription();
        }
        return yearlyIncome;
    }
    public void getRestanceList(ArrayList<Subscription> subscriptionsArraysList){
        for (Subscription subscriptions : subscriptionsArraysList){
            if (subscriptions.restance == true){
                System.out.println(subscriptions.toString());
            }
        }
    }
    public String getStringToSave(){
        return member.getStringToSave() + "," + restance;
    }

    public String toString() {
        String isCompetitive;
        String memberStatus = null;
        if (member.getCompetitiveMember()) {
            isCompetitive = "Ja";
        } else {
            isCompetitive = "Nej";
        }
        if (member.getActiveMember() && member.getSeniorMember()) {
            memberStatus = "Senior";
        }
        if (member.getActiveMember() && !member.getSeniorMember()) {
            memberStatus = "Junior";
        }
        if (!member.getActiveMember()) {
            memberStatus = "Passiv";
        }
        return "Name: " + member.getFirstName() + "\nAge: " + member.getAge() + "\nMedlemsstatus: " + memberStatus + "\nKonkurrencesvømmer: " + isCompetitive + "\nKontingent: " + subscription + " Kr." + "\n---------------";
    }

    public int getSubscription() {
        return subscription;
    }

    public boolean isRestance() {
        return restance;
    }

    public void setRestance(boolean restance) {
        this.restance = restance;
    }

    public Member getMember() {
        return member;
    }
}
