package composition;

public class Booking {
        private Member member;
        private TrainingSession trainingSession;
        private boolean active;

        // Constructor
        public Booking(Member member, TrainingSession trainingSession) {
            this.member = member;
            this.trainingSession = trainingSession;
            this.active = true;
        }

        // Get member
        public Member getMember() {
            return member;
        }

        // Get training session
        public TrainingSession getTrainingSession() {
            return trainingSession;
        }

        // Cancel booking
        public void cancel() {
            active = false;
        }

        // Check if booking is active
        public boolean isActive() {
            return active;
        }

        // Print booking
        public void printBooking() {
            System.out.println("Booking:");
            System.out.println("Member: " + member);
            System.out.println("Training session: " + trainingSession);
            System.out.println("Active: " + active);
        }

}
