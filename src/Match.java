import java.util.ArrayList;
import java.util.List;

public class Match {

    //How may frames are there in a single match
    int totalFrames;

    //Total pins player gets to knock down in a frame
    int pinsInAFrame;

    //Maximum attempts if the player never scored a strike in the entire match
    int maximumAttempts;

    List<Integer> attempts;
    List<Frame> frames;
    int gameScore;

    //Lets you customize a match with number of frames and number of pins in a frame.
    // Wasn't a requirement for this game, but I thought it would be cool to implement it.
    public Match(int totalFrames, int pinsInAFrame) {
        gameScore = 0;
        this.pinsInAFrame = pinsInAFrame;
        this.totalFrames = totalFrames;
        this.maximumAttempts = totalFrames * pinsInAFrame;
        this.attempts = new ArrayList<>();
        this.frames = new ArrayList<>();
    }

    public void roll(int noOfPins) {

        // Player shouldn't be able to roll if all attempts have been attempted.
        // That is, even if the player keeps playing after all the attempts are attempted,those will not be calculated for the final score.
        if (attempts.size() == maximumAttempts) {
            return;
        }

        //In a case of a strike roll count should reduce by one, how can you knock down more pins if there are no pins to knock down!
        if (noOfPins == pinsInAFrame) {
            maximumAttempts = maximumAttempts - 1;
        }

        //Keep storing player's score attempts
        attempts.add(noOfPins);
    }

    public List<Frame> generateFrames() {

        //Travers through all the attempts and generate the frames.
        //Even though we limit the player not to play more when all the attempts are played in roll(),
        // this method too adds a validation by checking if the total frame count doesn't exceed so the number of frames for the match is as expected
        for (int i = 0; i < attempts.size() && frames.size() < totalFrames; i++) {

            Frame frame = new Frame(pinsInAFrame, frames.size() + 1);
            frame.pinsFirstAttempt = setScore(i);

            if (frame.isAStrike()) {
                frame.extra1 = setScore(i + 1);
                frame.extra2 = setScore(i + 2);
            } else {
                frame.pinsSecondAttempt = setScore(i + 1);
                if (frame.isASpare()) {
                    frame.extra1 = setScore(i + 2);
                }
                //Except for a strike, the next frame should always start after 2 attempts
                i = i + 1;
            }
            frame.calculateFrameScore();
            frames.add(frame);
        }

        return frames;
    }

    public int score() {
        gameScore = 0;
        generateFrames();

        for (Frame frame : frames) {
            frame.printFrame();
            gameScore = gameScore + frame.score;
        }
        return gameScore;
    }

    public int setScore(int attempt) {

        //Just so you don't get an IndexOutOfBoundsException if the player doesn't want to attempt extras after a strike or a Spare
        if (attempts != null && attempt < attempts.size()) {
            return attempts.get(attempt);
        }
        return 0;
    }

}
