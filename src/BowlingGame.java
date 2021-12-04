public class BowlingGame {
    public static void main(String[] args) {

        scoreWhenPlayerDidNotScoreAStrikeOrSpare();
        scoreWhenPlayerScoredAStrike();
        scoreWhenPlayerScoredASpare();
        scoreWhenPlayerStrikesInAllAttempts();
        scoreWhenPlayerStrikesInAllAttemptsAndGetsTwoExtraAttempts();
        scoreWhenPlayerScoresASpareInLastFrameAndGetsAnExtraAttempt();
        scoreWhenThePlayerNeverGotAnySparesOrStrikesDuringTheEntireMatch();
        scoreWhenPlayerHitsFewStrikesAndSpares();

    }

    //Scenario: Basic test to find out score after 2 frames are played
    public static void scoreWhenPlayerDidNotScoreAStrikeOrSpare() {

        Match match = new Match(10, 10);

        match.roll(4);
        match.roll(3);
        match.roll(1);
        match.roll(6);

        System.out.println("Expected score when the player didn't score a strike or a spare is = 14");
        System.out.println("Actual score when the player didn't score a strike or a spare is = " + match.score());
    }

    //Scenario: Basic test to find out score after a player scores a strike in the first frame
    public static void scoreWhenPlayerScoredAStrike() {

        Match match = new Match(10, 10);

        match.roll(10);
        match.roll(3);
        match.roll(1);

        System.out.println("Expected score when the player scored a strike is = 18");
        System.out.println("Actual score when the player scored a strike is = " + match.score());
    }

    //Scenario: Basic test to find out score after a player scores a spare in the first frame
    public static void scoreWhenPlayerScoredASpare() {

        Match match = new Match(10, 10);

        match.roll(6);
        match.roll(4);
        match.roll(1);
        match.roll(7);

        System.out.println("Expected score when the player scored a strike is = 19");
        System.out.println("Actual score when the player scored a strike is = " + match.score());
    }

    //Scenario: Last frame with a Strike and 2 extras all strikes.
    public static void scoreWhenPlayerStrikesInAllAttempts() {

        Match match = new Match(10, 10);

        match.roll(10);
        match.roll(10);
        match.roll(10);
        match.roll(10);
        match.roll(10);
        match.roll(10);
        match.roll(10);
        match.roll(10);
        match.roll(10);
        match.roll(10);

        //Since the player score a strike he gets 2 more rolls, he scores strike for each of them.
        match.roll(10);
        match.roll(10);

        //If one has a strike for every roll, their score is 300
        System.out.println("Expected score when the player strikes in all attempts is = 300");
        System.out.println("Actual score when the player strikes in all attempts is = " + match.score());
    }

    //Scenario: Last frame with a Strike and 2 extras strikes.
    public static void scoreWhenPlayerStrikesInAllAttemptsAndGetsTwoExtraAttempts() {

        Match match = new Match(10, 10);

        match.roll(10);
        match.roll(10);
        match.roll(10);
        match.roll(10);
        match.roll(10);
        match.roll(10);
        match.roll(10);
        match.roll(10);
        match.roll(10);
        match.roll(10);

        //Since the player score a strike he gets 2 more rolls, but he didn't score a strike for the last 2 rolls.
        match.roll(4);
        match.roll(6);

        System.out.println("Expected score when the player strikes in all attempts except the last 2 extra attempts is = 284");
        System.out.println("Actual score when the player strikes in all attempts except the last 2 extra attempts is = " + match.score());
    }

    //Scenario: Last frame with a Spare and 1 extra bowl.
    public static void scoreWhenPlayerScoresASpareInLastFrameAndGetsAnExtraAttempt() {
        Match match = new Match(10, 10);

        match.roll(10);
        match.roll(10);
        match.roll(10);
        match.roll(10);
        match.roll(10);
        match.roll(10);
        match.roll(10);
        match.roll(10);
        match.roll(9);
        match.roll(1);

        //Since the player score a spare he gets 1 roll.
        match.roll(4);

        System.out.println("Expected score when the player scores a Spare in the last frame and gets an extra attempt is = 247");
        System.out.println("Actual sscore when the player scores a Spare in the last frame and gets an extra attempt is = " + match.score());
    }

    //Scenario: Last frame with no Spares and Strikes.
    public static void scoreWhenThePlayerNeverGotAnySparesOrStrikesDuringTheEntireMatch() {

        Match match = new Match(10, 10);

        match.roll(2);
        match.roll(1);
        match.roll(3);
        match.roll(5);
        match.roll(7);
        match.roll(0);
        match.roll(9);
        match.roll(0);
        match.roll(1);
        match.roll(4);
        match.roll(7);
        match.roll(1);
        match.roll(3);
        match.roll(5);
        match.roll(6);
        match.roll(0);
        match.roll(0);
        match.roll(0);
        match.roll(1);
        match.roll(2);

        System.out.println("Expected score when the player never got any spares or strikes during the entire match is = 57");
        System.out.println("Actual score when the player never got any spares or strikes during the entire match is = " + match.score());
    }

    //Scenario: Last frame not a Strike nor a Spare. But the match has a few Strikes and Spares in the other frames
    public static void scoreWhenPlayerHitsFewStrikesAndSpares() {

        Match match = new Match(10, 10);

        match.roll(2);
        match.roll(6);
        match.roll(10);
        match.roll(3);
        match.roll(5);
        match.roll(7);
        match.roll(3);
        match.roll(9);
        match.roll(1);
        match.roll(3);
        match.roll(1);
        match.roll(10);
        match.roll(0);
        match.roll(4);
        match.roll(1);
        match.roll(3);
        match.roll(4);
        match.roll(4);

        System.out.println("Expected score when the olayer hits few Strikes and Spares is = 100");
        System.out.println("Actual score when the olayer hits few Strikes and Spares is = " + match.score());

    }
}
