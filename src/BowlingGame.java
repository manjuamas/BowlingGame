public class BowlingGame {
    public static void main(String[] args) {

        Match match = new Match(10, 10);
        match.roll(10);
        match.roll(4);
        match.roll(2);
        System.out.println(match.score());
    }
}
