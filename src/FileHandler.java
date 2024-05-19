import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileHandler {
    final String memberFilePath = "src/DataFiles/Member.txt";
    final String subscriptionFilePath = "src/DataFiles/Subscription.txt";
    final String memberResultsFilePath = "src/DataFiles/MemberResults.txt";

    public void saveMemberToFile(ArrayList<Member> members) throws FileNotFoundException {
        try (PrintStream ps = new PrintStream(new File(memberFilePath))) {
            for (Member member : members) {
                ps.println(member.getStringToSave());
            }
        } catch (IOException e) {
            System.out.println("Filen blev ikke fundet");
        }
    }

    public ArrayList<Member> readFromMembersFile() {
        ArrayList<Member> membersList = new ArrayList<>();
        try (Scanner scan = new Scanner(new File(memberFilePath))) {
            while (scan.hasNext()) {
                String line = scan.nextLine();
                String[] parts = line.split(",");
                membersList.add(new Member(parts[0], parts[1], Integer.parseInt(parts[2]), Boolean.parseBoolean(parts[3]), Boolean.parseBoolean(parts[4]), Boolean.parseBoolean(parts[5])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Filen blev ikke fundet" + e.getMessage());
        }
        return membersList;
    }

    public void saveSubscriptionToFile(ArrayList<Subscription> subscriptions) {
        try (PrintStream ps = new PrintStream(new File(subscriptionFilePath))) {
            for (Subscription subscription : subscriptions) {
                ps.println(subscription.getStringToSave());
            }
        } catch (IOException e) {
            System.out.println("Filen blev ikke fundet");
        }
    }

    public ArrayList<Subscription> readFromSubscriptionFile() {
        ArrayList<Subscription> subscriptionsList = new ArrayList<>();
        try (Scanner scan = new Scanner(new File(subscriptionFilePath))) {
            while (scan.hasNext()) {
                String line = scan.nextLine();
                String[] parts = line.split(",");
                subscriptionsList.add(new Subscription(new Member((parts[0]), parts[1], Integer.parseInt(parts[2]), Boolean.parseBoolean(parts[3]), Boolean.parseBoolean(parts[4]), Boolean.parseBoolean(parts[5]))));
            }
        } catch (IOException e) {
            System.out.println("Filen blev ikke fundet");
        }
        return subscriptionsList;
    }

    public void saveMemberResultsToFile(ArrayList<MemberResults> memberResultsArrayList) {
        try (PrintStream ps = new PrintStream(new FileOutputStream(memberResultsFilePath, true))) {
            for (MemberResults memberResults : memberResultsArrayList) {
                ps.println(memberResults.getStringToSave());
            }
        } catch (IOException e) {
            System.out.println("Filen blev ikke fundet");
        }
    }

    public ArrayList<MemberResults> readFromMemberResultsFileAsYouth() {
        ArrayList<MemberResults> memberResultsArrayList = new ArrayList<>();
        try (Scanner scan = new Scanner(new File(memberResultsFilePath))) {
            while (scan.hasNext()) {
                String line = scan.nextLine();
                String[] parts = line.split(",");
                if (Integer.parseInt(parts[2]) <= 18) {
                    memberResultsArrayList.add(new MemberResults(new Member(parts[0], parts[1], Integer.parseInt(parts[2]), Boolean.parseBoolean(parts[3]), Boolean.parseBoolean(parts[4]), Boolean.parseBoolean(parts[5])), Double.parseDouble(parts[6]), Double.parseDouble(parts[7]), Double.parseDouble(parts[8]), Double.parseDouble(parts[9]), Double.parseDouble(parts[10]), Double.parseDouble(parts[11]), Double.parseDouble(parts[12]), Double.parseDouble(parts[13])));
                }
            }
        } catch (IOException e) {
            System.out.println("Filen blev ikke fundet");
        }
        return memberResultsArrayList;
    }

    public ArrayList<MemberResults> readFromMemberResultsFileAsSenior() {
        ArrayList<MemberResults> memberResultsArrayList = new ArrayList<>();
        try (Scanner scan = new Scanner(new File(memberResultsFilePath))) {
            while (scan.hasNext()) {
                String line = scan.nextLine();
                String[] parts = line.split(",");
                if (Integer.parseInt(parts[2]) > 18) {
                    memberResultsArrayList.add(new MemberResults(new Member(parts[0], parts[1], Integer.parseInt(parts[2]), Boolean.parseBoolean(parts[3]), Boolean.parseBoolean(parts[4]), Boolean.parseBoolean(parts[5])), Double.parseDouble(parts[6]), Double.parseDouble(parts[7]), Double.parseDouble(parts[8]), Double.parseDouble(parts[9]), Double.parseDouble(parts[10]), Double.parseDouble(parts[11]), Double.parseDouble(parts[12]), Double.parseDouble(parts[13])));
                }
            }
        } catch (IOException e) {
            System.out.println("Filen blev ikke fundet");
        }
        return memberResultsArrayList;
    }

    public void clearFileContents() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(memberResultsFilePath))) {
            writer.print(""); // Overskriv filen med en tom streng
        } catch (IOException e) {
            System.out.println("Problemer med at cleare filen: " + e.getMessage());
        }
    }
}
