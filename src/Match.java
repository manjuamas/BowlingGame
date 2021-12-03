import java.util.ArrayList;
import java.util.List;

public class Match {

    int maximumAttempts;
    int pinsInAFrame;
    List<Integer> scoreAttempts;
    List<Frame> frames;
    int gameScore;

    public Match(int frames, int pinsInAFrame) {
        gameScore = 0;
        this.pinsInAFrame = pinsInAFrame;
        this.maximumAttempts = frames * pinsInAFrame;
        this.scoreAttempts = new ArrayList<>();
        this.frames = new ArrayList<>();
    }

    public void roll(int noOfPins) {

        if (noOfPins == pinsInAFrame) {
            maximumAttempts = maximumAttempts - 1;
        }
        scoreAttempts.add(noOfPins);
    }

    public List<Frame> generateFrames() {

        int extra1;
        int extra2;

        for (int i = 0; i < scoreAttempts.size() && i <= maximumAttempts; i++) {

            Frame frame = new Frame(pinsInAFrame);
            extra1 = 0;
            extra2 = 0;

            frame.pinsFirstAttempt = setScore(i);

            if (frame.isAStrike()) {
                extra1 = setScore(i + 1);
                extra2 = setScore(i + 2);
            } else {
                frame.pinsSecondAttempt = setScore(i + 1);
                if (frame.isASpare()) {
                    extra1 = setScore(i + 2);
                    extra2 = setScore(i + 3);
                }
            }
            frame.setScore(extra1, extra2);
            frames.add(frame);
        }

        return frames;
    }

    public int score() {
        gameScore = 0;
        generateFrames();

        for (Frame frame : frames) {
            gameScore = gameScore + frame.getScore();
        }

        return gameScore;
    }

    public int setScore(int attempt) {

        if (scoreAttempts != null && attempt < scoreAttempts.size()) {
            return scoreAttempts.get(attempt);
        }
        return 0;
    }

}
