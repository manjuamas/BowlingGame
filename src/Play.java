public class Play {

    public static void main(String[] args) {

        scoreWhenPlayerDidNotScoreAStrikeOrSpare();
        scoreWhenPlayerScoredAStrike();
        scoreWhenPlayerScoredASpare();
        scoreWhenPlayerStrikesInAllAttempts();
        scoreWhenPlayerStrikesInAllAttemptsAndGetsTwoExtraAttempts();
        scoreWhenPlayerScoresASpareInLastFrameAndGetsAnExtraAttempt();
        scoreWhenPlayerNeverGotAnySparesOrStrikesDuringTheEntireMatch();
        scoreWhenPlayerHitsFewStrikesAndSpares();

    }

    //Scenario 1: Basic test to find out the score after 2 frames are played.
    public static void scoreWhenPlayerDidNotScoreAStrikeOrSpare() {

        BowlingGame bowlingGame = new BowlingGame(10, 10);

        bowlingGame.roll(4);
        bowlingGame.roll(3);
        bowlingGame.roll(1);
        bowlingGame.roll(6);

        System.out.println("Expected score when the player didn't score a strike or a spare is = 14");
        System.out.println("Actual score when the player didn't score a strike or a spare is = " + bowlingGame.score() + "\n");
    }

    //Scenario 2: Basic test to find out the score after player scores a Strike in the first frame.
    public static void scoreWhenPlayerScoredAStrike() {

        BowlingGame bowlingGame = new BowlingGame(10, 10);

        bowlingGame.roll(10);
        bowlingGame.roll(3);
        bowlingGame.roll(1);

        System.out.println("Expected score when the player scored a strike is = 18");
        System.out.println("Actual score when the player scored a strike is = " + bowlingGame.score() + "\n");
    }

    //Scenario 3: Basic test to find out the score after player scores a Spare in the first frame.
    public static void scoreWhenPlayerScoredASpare() {

        BowlingGame bowlingGame = new BowlingGame(10, 10);

        bowlingGame.roll(6);
        bowlingGame.roll(4);
        bowlingGame.roll(1);
        bowlingGame.roll(7);

        System.out.println("Expected score when the player scored a spare is = 19");
        System.out.println("Actual score when the player scored a spare is = " + bowlingGame.score() + "\n");
    }

    //Scenario 4: Last frame with a Strike and 2 extras with all strikes.
    public static void scoreWhenPlayerStrikesInAllAttempts() {

        BowlingGame bowlingGame = new BowlingGame(10, 10);

        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);

        //Since the player score a strike he gets 2 more rolls, he scores strike for each of them.
        bowlingGame.roll(10);
        bowlingGame.roll(10);

        System.out.println("Expected score when the player strikes in all attempts is = 300");
        System.out.println("Actual score when the player strikes in all attempts is = " + bowlingGame.score() + "\n");
    }

    //Scenario 5: Last frame with a Strike and 2 extras attempts.
    public static void scoreWhenPlayerStrikesInAllAttemptsAndGetsTwoExtraAttempts() {

        BowlingGame bowlingGame = new BowlingGame(10, 10);

        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);

        //Since the player score a strike he gets 2 more rolls, but he didn't score a strike for the last 2 rolls.
        bowlingGame.roll(4);
        bowlingGame.roll(6);

        System.out.println("Expected score when the player strikes in all attempts except the last 2 extra attempts is = 284");
        System.out.println("Actual score when the player strikes in all attempts except the last 2 extra attempts is = " + bowlingGame.score() + "\n");
    }

    //Scenario 6: Last frame with a Spare and 1 extra bowl.
    public static void scoreWhenPlayerScoresASpareInLastFrameAndGetsAnExtraAttempt() {
        BowlingGame bowlingGame = new BowlingGame(10, 10);

        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(9);
        bowlingGame.roll(1);

        //Since the player score a spare he gets 1 roll.
        bowlingGame.roll(4);

        System.out.println("Expected score when the player scores a spare in the last frame and gets an extra attempt is = 273");
        System.out.println("Actual score when the player scores a spare in the last frame and gets an extra attempt is = " + bowlingGame.score() + "\n");
    }

    //Scenario 7: Match of 10 frames with no Spares and Strikes.
    public static void scoreWhenPlayerNeverGotAnySparesOrStrikesDuringTheEntireMatch() {

        BowlingGame bowlingGame = new BowlingGame(10, 10);

        bowlingGame.roll(2);
        bowlingGame.roll(1);
        bowlingGame.roll(3);
        bowlingGame.roll(5);
        bowlingGame.roll(7);
        bowlingGame.roll(0);
        bowlingGame.roll(9);
        bowlingGame.roll(0);
        bowlingGame.roll(1);
        bowlingGame.roll(4);
        bowlingGame.roll(7);
        bowlingGame.roll(1);
        bowlingGame.roll(3);
        bowlingGame.roll(5);
        bowlingGame.roll(6);
        bowlingGame.roll(0);
        bowlingGame.roll(0);
        bowlingGame.roll(0);
        bowlingGame.roll(1);
        bowlingGame.roll(2);

        System.out.println("Expected score when the player never got any spares or strikes during the entire match is = 57");
        System.out.println("Actual score when the player never got any spares or strikes during the entire match is = " + bowlingGame.score() + "\n");
    }

    //Scenario 8: Last frame not a Strike nor a Spare. But the match has a few Strikes and Spares in the other frames.
    public static void scoreWhenPlayerHitsFewStrikesAndSpares() {

        BowlingGame bowlingGame = new BowlingGame(10, 10);

        bowlingGame.roll(2);
        bowlingGame.roll(6);
        bowlingGame.roll(10);
        bowlingGame.roll(3);
        bowlingGame.roll(5);
        bowlingGame.roll(7);
        bowlingGame.roll(3);
        bowlingGame.roll(9);
        bowlingGame.roll(1);
        bowlingGame.roll(3);
        bowlingGame.roll(1);
        bowlingGame.roll(10);
        bowlingGame.roll(0);
        bowlingGame.roll(4);
        bowlingGame.roll(1);
        bowlingGame.roll(3);
        bowlingGame.roll(4);
        bowlingGame.roll(4);

        System.out.println("Expected score when the player hits a few Strikes and Spares is = 100");
        System.out.println("Actual score when the player hits a few Strikes and Spares is = " + bowlingGame.score() + "\n");

    }
}
