package composition;

import java.util.ArrayList;

public class Member {


    private String name;
    private int memberId;
    private String type;
    private ArrayList<String> memberNames;
    private ArrayList<Integer> memberIds;
    private ArrayList<String> memberTypes;




    Member(String name, int memberId, String type) {
        this.name = name;
        this.memberId = memberId;
        this.type = type;
        this.memberNames = new ArrayList<>();
        this.memberIds = new ArrayList<>();
        this.memberTypes = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean addMember(String name, int memberId, String type) {
        if (!type.equals("Basic") && !type.equals("Premium")) {
            System.out.println("Ukendt medlemstype: " + type);
            return false;
        }
        if (findMemberIndex(memberId) != -1) {
            System.out.println("Medlemsnummer " + memberId + " findes allerede.");
            return false;
        }
        memberNames.add(name);
        memberIds.add(memberId);
        memberTypes.add(type);
        return true;
    }

    public int findMemberIndex(int memberId) {
        for (int i = 0; i < memberIds.size(); i++) {
            if (memberIds.get(i) == memberId) {
                return i;
            }
        }
        return -1;
    }

    // Hver gang der kommer en ny medlemstype, skal denne metode rettes...
    public int getMaxBookings(String type) {
        if (type.equals("Basic")) {
            return 2;
        } else if (type.equals("Premium")) {
            return 5;
        }
        return 0;
    }

    // ...og denne metode også
    public double getMonthlyPrice(String type) {
        if (type.equals("Basic")) {
            return 199;
        } else if (type.equals("Premium")) {
            return 349;
        }
        return 0;
    }

    public int getActiveBookingCount(int memberId) {
        int count = 0;
        for (int i = 0; i < bookingMemberIds.size(); i++) {
            if (bookingMemberIds.get(i) == memberId && bookingActive.get(i)) {
                count++;
            }
        }
        return count;
    }

    public void printAllMembers() {
        System.out.println("Medlemmer i " + centerName + ":");
        for (int i = 0; i < memberNames.size(); i++) {
            String type = memberTypes.get(i);
            int id = memberIds.get(i);
            System.out.println("  #" + id + " " + memberNames.get(i) + " (" + type + ")"
                    + " - " + String.format("%.0f", getMonthlyPrice(type)) + " kr./md."
                    + ", " + getActiveBookingCount(id) + "/" + getMaxBookings(type) + " aktive bookinger");
        }
    }
}
