package composition;

import java.util.ArrayList;

public class FitnessCenter {

    String name;
    ArrayList<Member> members;
    ArrayList<TrainingSession> sessions;

    FitnessCenter(String name) {
        this.name = name;
        this.members = new ArrayList<>();
        this.sessions = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public ArrayList<TrainingSession> getSessions() {
        return sessions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public void setSessions(ArrayList<TrainingSession> sessions) {
        this.sessions = sessions;
    }
}
