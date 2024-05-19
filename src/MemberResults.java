public class MemberResults {
    private Member member;

    private double trainingButterfly;
    private double competitveButterfly;
    private double trainingFreestyle;
    private double competitiveFreestyle;
    private double trainingBackCrawl;
    private double competitiveBackCrawl;
    private double trainingBreaststroke;
    private double competitiveBreastStroke;

    public MemberResults(Member member) {
        this.member = member;
        this.trainingButterfly = 0.0;
        this.competitveButterfly = 0.0;
        this.trainingFreestyle = 0.0;
        this.competitiveFreestyle = 0.0;
        this.trainingBackCrawl = 0.0;
        this.competitiveBackCrawl = 0.0;
        this.trainingBreaststroke = 0.0;
        this.competitiveBreastStroke = 0.0;
    }
    public MemberResults(Member member, double trainingButterfly, double competitveButterfly, double trainingFreestyle, double competitiveFreestyle, double trainingBackCrawl, double competitiveBackCrawl, double trainingBreaststroke, double competitiveBreastStroke) {
        this.member = member;
        this.trainingButterfly = trainingButterfly;
        this.competitveButterfly = competitveButterfly;
        this.trainingFreestyle = trainingFreestyle;
        this.competitiveFreestyle = competitiveFreestyle;
        this.trainingBackCrawl = trainingBackCrawl;
        this.competitiveBackCrawl = competitiveBackCrawl;
        this.trainingBreaststroke = trainingBreaststroke;
        this.competitiveBreastStroke = competitiveBreastStroke;
    }


    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public double getTrainingButterfly() {
        return trainingButterfly;
    }

    public void setTrainingButterfly(double trainingButterfly) {
        this.trainingButterfly = trainingButterfly;
    }

    public double getCompetitveButterfly() {
        return competitveButterfly;
    }

    public void setCompetitveButterfly(double competitveButterfly) {
        this.competitveButterfly = competitveButterfly;
    }

    public double getTrainingFreestyle() {
        return trainingFreestyle;
    }

    public void setTrainingFreestyle(double trainingFreestyle) {
        this.trainingFreestyle = trainingFreestyle;
    }

    public double getCompetitiveFreestyle() {
        return competitiveFreestyle;
    }

    public void setCompetitiveFreestyle(double competitiveFreestyle) {
        this.competitiveFreestyle = competitiveFreestyle;
    }

    public double getTrainingBackCrawl() {
        return trainingBackCrawl;
    }

    public void setTrainingBackCrawl(double trainingBackCrawl) {
        this.trainingBackCrawl = trainingBackCrawl;
    }

    public double getCompetitiveBackCrawl() {
        return competitiveBackCrawl;
    }

    public void setCompetitiveBackCrawl(double competitiveBackCrawl) {
        this.competitiveBackCrawl = competitiveBackCrawl;
    }

    public double getTrainingBreaststroke() {
        return trainingBreaststroke;
    }

    public void setTrainingBreaststroke(double trainingBreaststroke) {
        this.trainingBreaststroke = trainingBreaststroke;
    }

    public double getCompetitiveBreastStroke() {
        return competitiveBreastStroke;
    }

    public void setCompetitiveBreastStroke(double competitiveBreastStroke) {
        this.competitiveBreastStroke = competitiveBreastStroke;
    }
    public String getStringToSave(){
        return member.getStringToSave() + "," + trainingButterfly + "," + competitveButterfly + "," + trainingFreestyle + "," + competitiveFreestyle + "," + trainingBackCrawl + "," + competitiveBackCrawl + "," + trainingBreaststroke + "," + competitiveBreastStroke;
    }

    public String toString() {
        return member.getFirstName() + "\nTræning Butterfly: " + trainingButterfly + "\nkonkurrence Butterfly: " + competitveButterfly + "\nTræning Fristil: " + trainingFreestyle + "\nKonkurrence Fristil: " + competitiveFreestyle + "\nTræning Rygcrawl: " + trainingBackCrawl + "\nKonkurrence Rygcrawl: " + competitiveBackCrawl + "\nTræning Brystsvømning: " + trainingBreaststroke + "\nKonkurrence Brystsvømning: " + competitiveBreastStroke + "\n------------------------------";
    }
}
