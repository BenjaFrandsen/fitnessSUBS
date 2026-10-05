package composition;

import java.util.ArrayList;

public class TrainingSession {

    private String title;
    private String trainer;
    private int capacity;
    private ArrayList<Member> participants;

    public TrainingSession(String title, String trainer, int capacity) {
        this.title = title;
        this.trainer = trainer;
        this.capacity = capacity;
        this.participants = new ArrayList<>();
    }

    public void addParticipant(Member member) {
        participants.add(member);
    }

    public void removeParticipants(Member member) {
        participants.remove(member);
    }

    public boolean hasAvailableSpaces() {
        return participants.size() < capacity;
    }

    public int getAvailableSpaces() {
        return capacity - participants.size();
    }

    public void printSession() {
        System.out.println(" === " + getTitle() + " === ");
        System.out.println("Instructor: " + getTrainer());
        System.out.println("Number of participants: " + participants.size());
        int number = 1;
        for (Member p : participants) {
            System.out.println(number + ": " + p.getName() + ", ID: " + p.getMemberID());
            number++;
        }
    }

    public String getTitle() {
        return title;
    }

    public String getTrainer() {
        return trainer;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Member> getParticipants() {
        return participants;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setParticipants(ArrayList<Member> participants) {
        this.participants = participants;
    }
}
