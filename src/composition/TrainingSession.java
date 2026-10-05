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
