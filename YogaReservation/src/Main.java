import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Member> members = new ArrayList<>();
        Reservation reservation = new Reservation(members);
        reservation.reserve();
    }
}
