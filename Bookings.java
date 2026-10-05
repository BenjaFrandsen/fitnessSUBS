package composition;

import java.util.ArrayList;

public class Bookinger {

    // ---------- Medlemmer ----------
    private ArrayList<Integer> memberIds;
    private ArrayList<String> memberNames;
    private ArrayList<String> memberTypes;

    // ---------- Træningstimer ----------
    private ArrayList<String> sessionTitles;
    private ArrayList<String> sessionInstructors;
    private ArrayList<Integer> sessionCapacities;
    private ArrayList<Integer> sessionParticipantCounts;

    // ---------- Bookinger ----------
    private ArrayList<Integer> bookingMemberIds;
    private ArrayList<String> bookingSessionTitles;
    private ArrayList<Boolean> bookingActive;


    // ---------- Konstruktør ----------

    public Bookinger() {

        // Medlemmer
        memberIds = new ArrayList<>();
        memberNames = new ArrayList<>();
        memberTypes = new ArrayList<>();

        // Træningstimer
        sessionTitles = new ArrayList<>();
        sessionInstructors = new ArrayList<>();
        sessionCapacities = new ArrayList<>();
        sessionParticipantCounts = new ArrayList<>();

        // Bookinger
        bookingMemberIds = new ArrayList<>();
        bookingSessionTitles = new ArrayList<>();
        bookingActive = new ArrayList<>();
    }


    // ---------- Tilføj medlem ----------

    public void addMember(int id, String name, String type) {

        memberIds.add(id);
        memberNames.add(name);
        memberTypes.add(type);

        System.out.println("Medlem tilføjet: " + name);
    }


    // ---------- Tilføj træningstime ----------

    public void addSession(String title, String instructor, int capacity) {

        sessionTitles.add(title);
        sessionInstructors.add(instructor);
        sessionCapacities.add(capacity);

        // Der er 0 deltagere til at starte med
        sessionParticipantCounts.add(0);

        System.out.println("Træningstime tilføjet: " + title);
    }


    // ---------- Find medlem ----------

    public int findMemberIndex(int memberId) {

        for (int i = 0; i < memberIds.size(); i++) {

            if (memberIds.get(i) == memberId) {
                return i;
            }
        }

        return -1;
    }


    // ---------- Find træningstime ----------

    public int findSessionIndex(String sessionTitle) {

        for (int i = 0; i < sessionTitles.size(); i++) {

            if (sessionTitles.get(i).equals(sessionTitle)) {
                return i;
            }
        }

        return -1;
    }


    // ---------- Maks antal bookinger ----------

    public int getMaxBookings(String type) {

        if (type.equalsIgnoreCase("Basic")) {
            return 2;
        }

        if (type.equalsIgnoreCase("Premium")) {
            return 5;
        }

        return 1;
    }
    // ---------- Antal aktive bookinger ----------
    public int getActiveBookingCount(int memberId) {
        int count = 0;
        for (int i = 0; i < bookingMemberIds.size(); i++) {

            if (bookingMemberIds.get(i) == memberId
                    && bookingActive.get(i)) {
                count++;
            }
        }
        return count;
    }

    // ---------- Find aktiv booking ----------
    public int findActiveBookingIndex(int memberId, String sessionTitle) {
        for (int i = 0; i < bookingMemberIds.size(); i++) {
            if (bookingMemberIds.get(i) == memberId
                    && bookingSessionTitles.get(i).equals(sessionTitle)
                    && bookingActive.get(i)) {

                return i;
            }
        }
        return -1;
    }


    // ---------- Book træningstime ----------
    public boolean bookSession(int memberId, String sessionTitle) {
        int memberIndex = findMemberIndex(memberId);
        int sessionIndex = findSessionIndex(sessionTitle);
        if (memberIndex == -1 || sessionIndex == -1) {
            System.out.println("Medlem eller træningstime findes ikke.");
            return false;
        }
        String name = memberNames.get(memberIndex);
        String type = memberTypes.get(memberIndex);
        // Tjek om medlem allerede har booket timen
        if (findActiveBookingIndex(memberId, sessionTitle) != -1) {
            System.out.println("Bookingen blev afvist.");
            System.out.println(name + " har allerede booket " + sessionTitle + ".");
            return false;
        }
        // Tjek om træningstimen er fuld
        if (sessionParticipantCounts.get(sessionIndex)
                >= sessionCapacities.get(sessionIndex)) {
            System.out.println("Bookingen blev afvist.");
            System.out.println(sessionTitle + " er fuldt booket.");
            return false;
        }
        // Tjek hvor mange bookinger medlemmet må have
        if (getActiveBookingCount(memberId) >= getMaxBookings(type)) {
            System.out.println("Bookingen blev afvist.");
            System.out.println(
                    name + " må højst have "
                            + getMaxBookings(type)
                            + " aktive bookinger."
            );
            return false;
        }
        // Lav booking
        bookingMemberIds.add(memberId);
        bookingSessionTitles.add(sessionTitle);
        bookingActive.add(true);
        // Tilføj en deltager til træningstimen
        sessionParticipantCounts.set(
                sessionIndex,
                sessionParticipantCounts.get(sessionIndex) + 1
        );
        System.out.println("Bookingen er gennemført.");
        System.out.println(name + " er nu tilmeldt " + sessionTitle + ".");
        return true;
    }


    // ---------- Afmeld booking ----------
    public boolean cancelBooking(int memberId, String sessionTitle) {
        int memberIndex = findMemberIndex(memberId);
        int sessionIndex = findSessionIndex(sessionTitle);
        if (memberIndex == -1 || sessionIndex == -1) {

            System.out.println("Medlem eller træningstime findes ikke.");

            return false;
        }
        String name = memberNames.get(memberIndex);
        int bookingIndex =
                findActiveBookingIndex(memberId, sessionTitle);
        if (bookingIndex == -1) {
            System.out.println("Afmeldingen blev afvist.");
            System.out.println(
                    name + " har ingen aktiv booking af "
                            + sessionTitle + "."
            );
            return false;
        }
        // Gør bookingen inaktiv
        bookingActive.set(bookingIndex, false);
        // Fjern en deltager fra træningstimen
        sessionParticipantCounts.set(
                sessionIndex,
                sessionParticipantCounts.get(sessionIndex) - 1
        );
        System.out.println("Afmeldingen er gennemført.");
        System.out.println(name + " er nu afmeldt " + sessionTitle + ".");

        return true;
    }
    // ---------- Print bookinger ----------
    public void printBookings(int memberId) {

        int memberIndex = findMemberIndex(memberId);
        if (memberIndex == -1) {

            System.out.println(
                    "Medlem " + memberId + " findes ikke."
            );

            return;
        }
        String name = memberNames.get(memberIndex);
        System.out.println(
                "Aktive bookinger for " + name + ":"
        );
        if (getActiveBookingCount(memberId) == 0) {
            System.out.println(
                    "  (ingen aktive bookinger)"
            );
            return;
        }
        for (int i = 0; i < bookingMemberIds.size(); i++) {
            if (bookingMemberIds.get(i) == memberId
                    && bookingActive.get(i)) {
                String title =
                        bookingSessionTitles.get(i);
                String instructor =
                        sessionInstructors.get(
                                findSessionIndex(title)
                        );
                System.out.println(
                        "  "
                                + name
                                + " -> "
                                + title
                                + " med "
                                + instructor
                                + " (aktiv)"
                );
            }
        }
    }
}