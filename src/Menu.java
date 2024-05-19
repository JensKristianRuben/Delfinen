import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Menu {
    private Scanner scan;
    private ArrayList<Member> members;
    private ArrayList<Subscription> subscriptions;
    private ArrayList<MemberResults> youthMemberResultsArrayList;
    private ArrayList<MemberResults> seniorMemberResultsArrayList;
    private Subscription subscription;
    private FileHandler fileHandler;


    public Menu() {
        this.members = new ArrayList<>();
        this.subscriptions = new ArrayList<>();
        this.scan = new Scanner(System.in);
        this.subscription = new Subscription();
        this.youthMemberResultsArrayList = new ArrayList<>();
        this.seniorMemberResultsArrayList = new ArrayList<>();
        this.fileHandler = new FileHandler();
        this.members.addAll(fileHandler.readFromMembersFile());
        this.subscriptions.addAll(fileHandler.readFromSubscriptionFile());
        this.youthMemberResultsArrayList.addAll(fileHandler.readFromMemberResultsFileAsYouth());
        this.seniorMemberResultsArrayList.addAll(fileHandler.readFromMemberResultsFileAsSenior());
    }

    public void menuOverveiw() throws FileNotFoundException {
        //todo: sørg for at hvis man bruger changeMember() skal den ændre informationerne i alle arrays
        boolean outerMenu = false;
        while (!outerMenu) {
            System.out.println("""
                    1. Opret nyt medlem
                    2. Se medlemsliste
                    3. Ændre medlems Information
                    4. Regnskabs funktioner
                    5. Se og rediger tidslister
                    6. Afslut programmet
                    """);
            int choice = Util.getIntInput(scan, "");
            switch (choice) {
                case 1:
                    createNewMember();
                    break;
                case 2:
                    Util.printArraylist(members);
                    break;
                case 3:
                    changeMemberInfo();
                    break;
                case 4:
                    boolean exitInner5Menu = false;
                    while (!exitInner5Menu) {
                        int choice5 = Util.getIntInput(scan, """
                                1. Generer forventet årlige indkomst
                                2. Se medlemmer i restance
                                3. Rediger Medlemmets restance status
                                4. Gå tilbage
                                """);
                        switch (choice5) {
                            case 1:
                                System.out.println(">>SAMLET INDKOMST FOR INDEVÆRENDE ÅR<<");
                                System.out.println(subscription.calculateYearlyIncome(subscriptions) + " Kr.\n");
                                break;
                            case 2:
                                System.out.println(">>ALLE MEDLEMMER I RESTANCE<<");
                                subscription.getRestanceList(subscriptions);
                                break;
                            case 3:
                                changeRestanceStatus();
                                break;
                            case 4:
                                exitInner5Menu = true;
                                break;
                            default:
                                System.out.println("Forkert input, prøv med et heltal mellem 1-4");
                        }
                    }

                    break;
                case 5:
                    boolean exitInnerMenu = false;
                    while (!exitInnerMenu) {
                        int choice1 = Util.getIntInput(scan, """
                                1. top 5 lister
                                2. Rediger tid hos medlem
                                3. gå tilbage
                                """);
                        switch (choice1) {
                            case 1:
                                boolean exitInner2menu = false;
                                while (!exitInner2menu) {
                                    int choice2 = Util.getIntInput(scan, """
                                            1. Ungdom
                                            2. Senior
                                            3. Gå tilbage
                                            """);
                                    switch (choice2) {
                                        case 1:
                                            boolean exitInner3menu = false;
                                            while (!exitInner3menu) {
                                                int choice3 = Util.getIntInput(scan, """
                                                        1. Butterfly
                                                        2. Fristil
                                                        3. Rygcrawl
                                                        4. Brystsvømning
                                                        5. Gå tilbage
                                                        """);
                                                switch (choice3) {
                                                    case 1:
                                                        generateTop5List("Butterfly", 18);
                                                        break;
                                                    case 2:
                                                        generateTop5List("Freestyle", 18);
                                                        break;
                                                    case 3:
                                                        generateTop5List("Backcrawl", 18);
                                                        break;
                                                    case 4:
                                                        generateTop5List("Breaststroke", 18);
                                                        break;
                                                    case 5:
                                                        exitInner3menu = true;
                                                        break;
                                                    default:
                                                        System.out.println("fejl input, prøv venligst igen med et heltal");
                                                }
                                            }
                                            break;
                                        case 2:
                                            boolean exitInner4menu = false;
                                            while (!exitInner4menu) {
                                                int choice4 = Util.getIntInput(scan, """
                                                        1. Butterfly
                                                        2. Fristil
                                                        3. Rygcrawl
                                                        4. Brystsvømning
                                                        5. Gå tilbage
                                                        """);
                                                switch (choice4) {
                                                    case 1:
                                                        generateTop5List("Butterfly", 19);
                                                        break;
                                                    case 2:
                                                        generateTop5List("Freestyle", 19);
                                                        break;
                                                    case 3:
                                                        generateTop5List("Backcrawl", 19);
                                                        break;
                                                    case 4:
                                                        generateTop5List("Breaststroke", 19);
                                                        break;
                                                    case 5:
                                                        exitInner4menu = true;
                                                        break;
                                                    default:
                                                        System.out.println("fejl input, prøv venligst igen med et heltal");
                                                }
                                            }
                                            break;
                                        case 3:
                                            exitInner2menu = true;
                                            break;
                                        default:
                                            System.out.println("fejl input, prøv venligst igen med et heltal");
                                    }
                                }
                                break;
                            case 2:
                                setResultsTime();
                                break;
                            case 3:
                                exitInnerMenu = true;
                                break;
                            default:
                                System.out.println("fejl input, prøv venligst igen med et heltal");
                        }
                    }
                    break;
                case 6:

                    FileHandler fileHandler = new FileHandler();
                    fileHandler.saveMemberToFile(members);
                    fileHandler.saveSubscriptionToFile(subscriptions);
                    fileHandler.clearFileContents(); //Renser memberResults Filen for data
                    fileHandler.saveMemberResultsToFile(youthMemberResultsArrayList);
                    fileHandler.saveMemberResultsToFile(seniorMemberResultsArrayList);
                    outerMenu = true;
                    break;
                default:
                    System.out.println("fejl input, prøv venligst igen med et heltal");
            }
        }
    }

    public void createNewMember() {
        String firstName = Util.getStringInput(scan, "Hvad er fornavnet på medlemmet: ");
        String secondName = Util.getStringInput(scan, "Hvad er efternavnet på medlemmet: ");
        int age = Util.getIntInput(scan, "Hvad er alderen på medlemmet: ");
        boolean competitiveMember = Util.getBooleanInput(scan, "Skal medlemmet svømme konkurrence: (ja/nej)");

        members.add(new Member(firstName, secondName, age, competitiveMember));
        subscriptions.add(new Subscription(new Member(firstName, secondName, age, competitiveMember)));

        if (competitiveMember && age <= 18) {
            youthMemberResultsArrayList.add(new MemberResults(new Member(firstName, secondName, age, competitiveMember)));
        } else if (competitiveMember & age > 18) {
            seniorMemberResultsArrayList.add(new MemberResults(new Member(firstName, secondName, age, competitiveMember)));
        }
    }

    public void changeMemberInfo() {
        String name = Util.getStringInput(scan, "Hvilket medlem vil du gerne finde: (Brug navn)").toLowerCase();

        Member memberFound = null;
        for (Member member : members) {
            if (member.getFirstName().equals(name)) {
                memberFound = member;
            }
        }
        memberFound.setFirstName(Util.getStringInput(scan, "Hvad vil du gerne ændre fornavnet til: "));
        memberFound.setSecondName(Util.getStringInput(scan, "Hvad vil du gerne ændre efternavnet til: "));
        memberFound.setAge(Util.getIntInput(scan, "Hvad vil du gerne ændre alderen til: "));
        memberFound.setCompetitiveMember(Util.getBooleanInput(scan, "Kokurrence Status: (ja/nej)"));
        memberFound.setActiveMember(Util.getBooleanInput(scan, "Skal medlemmet gøres passiv: (ja/nej)"));

    }

    public void setResultsTime() {
        String name = Util.getStringInput(scan, "Hvilket medlem vil du gerne redigere tider for: ").toLowerCase();

        for (MemberResults memberResults : youthMemberResultsArrayList) {
            if (memberResults.getMember().getFirstName().equals(name)) {
                memberResults.setTrainingButterfly(Util.getDoubleInput(scan, "bedste tid Butterfly træning: "));
                memberResults.setCompetitveButterfly(Util.getDoubleInput(scan, "bedste tid Butterfly konkurrence: "));
                memberResults.setTrainingFreestyle(Util.getDoubleInput(scan, "bedste tid fristil træning: "));
                memberResults.setCompetitiveFreestyle(Util.getDoubleInput(scan, "bedste tid fristil konkurrence: "));
                memberResults.setTrainingButterfly(Util.getDoubleInput(scan, "bedste tid rygcrawl træning: "));
                memberResults.setTrainingButterfly(Util.getDoubleInput(scan, "bedste tid rygcrawl konkurrence: "));
                memberResults.setTrainingButterfly(Util.getDoubleInput(scan, "bedste tid Brystsvømning træning: "));
                memberResults.setTrainingButterfly(Util.getDoubleInput(scan, "bedste tid Brystsvømning konkurrence: "));
            }
        }
        for (MemberResults memberResults : seniorMemberResultsArrayList) {
            if (memberResults.getMember().getFirstName().equals(name)) {
                memberResults.setTrainingButterfly(Util.getDoubleInput(scan, "bedste tid Butterfly træning: "));
                memberResults.setCompetitveButterfly(Util.getDoubleInput(scan, "bedste tid Butterfly konkurrence: "));
                memberResults.setTrainingFreestyle(Util.getDoubleInput(scan, "bedste tid fristil træning: "));
                memberResults.setCompetitiveFreestyle(Util.getDoubleInput(scan, "bedste tid fristil konkurrence: "));
                memberResults.setTrainingButterfly(Util.getDoubleInput(scan, "bedste tid rygcrawl træning: "));
                memberResults.setTrainingButterfly(Util.getDoubleInput(scan, "bedste tid rygcrawl konkurrence: "));
                memberResults.setTrainingButterfly(Util.getDoubleInput(scan, "bedste tid Brystsvømning træning: "));
                memberResults.setTrainingButterfly(Util.getDoubleInput(scan, "bedste tid Brystsvømning konkurrence: "));
            }
        }
    }

    public void generateTop5List(String disciplin, int ageGroup) {
        ArrayList<MemberResults> selectedList;
        if (ageGroup <= 18) {
            selectedList = youthMemberResultsArrayList;
        } else {
            selectedList = seniorMemberResultsArrayList;
        }

        Collections.sort(selectedList, new Comparator<MemberResults>() {
            @Override
            public int compare(MemberResults o1, MemberResults o2) {
                double time1 = getTimeForDiscipline(o1, disciplin);
                double time2 = getTimeForDiscipline(o2, disciplin);
                return Double.compare(time1, time2);
            }
        });

        System.out.println("<<Top 5 for " + disciplin + " træningstider " + (ageGroup <= 18 ? "ungdom" : "senior") + ">>");
        printTop5(selectedList, disciplin, "Træning");
        System.out.println();

        Collections.sort(selectedList, new Comparator<MemberResults>() {
            @Override
            public int compare(MemberResults o1, MemberResults o2) {
                double time1 = getCompetitiveTimeForDiscipline(o1, disciplin);
                double time2 = getCompetitiveTimeForDiscipline(o2, disciplin);
                return Double.compare(time1, time2);
            }
        });

        System.out.println("<<Top 5 for " + disciplin + " konkurrencetider " + (ageGroup <= 18 ? "ungdom" : "senior") + ">>");
        printTop5(selectedList, disciplin, "Konkurrence");
        System.out.println();
    }

    private void printTop5(ArrayList<MemberResults> selectedList, String discipline, String type) {
        for (int i = 0; i < Math.min(5, selectedList.size()); i++) {
            MemberResults results = selectedList.get(i);
            String name = results.getMember().getFirstName();
            double time = 0.0;
            if (type.equals("Træning")) {
                time = getTimeForDiscipline(results, discipline);
            } else if (type.equals("Konkurrence")) {
                time = getCompetitiveTimeForDiscipline(results, discipline);
            }
            System.out.println((i + 1) + ". " + type + " - " + name + ": " + time + " minutter");
        }
    }

    private double getTimeForDiscipline(MemberResults result, String discipline) {
        switch (discipline) {
            case "Butterfly":
                return result.getTrainingButterfly();
            case "Freestyle":
                return result.getTrainingFreestyle();
            case "Backcrawl":
                return result.getTrainingBackCrawl();
            case "Breaststroke":
                return result.getTrainingBreaststroke();
            default:
                return 0.0;
        }
    }

    private double getCompetitiveTimeForDiscipline(MemberResults result, String discipline) {
        switch (discipline) {
            case "Butterfly":
                return result.getCompetitveButterfly();
            case "Freestyle":
                return result.getCompetitiveFreestyle();
            case "Backcrawl":
                return result.getCompetitiveBackCrawl();
            case "Breaststroke":
                return result.getCompetitiveBreastStroke();
            default:
                return 0.0;
        }
    }

    public void changeRestanceStatus() {
        String name = Util.getStringInput(scan, "Hvilket medlem vil du gerne ændre status for: ");
        for (Subscription subscription1 : subscriptions) {
            if (subscription1.getMember().getFirstName().equals(name)) {
                boolean choice = Util.getBooleanInput(scan, """
                        Hvis medlemmet ikke har betalt = ja
                        Hvis medlemmet har betalt = nej
                        """);
                subscription1.setRestance(choice);
                System.out.println("Restance status er ændret for " + subscription1.getMember().getFirstName());
            }
        }
    }
}
