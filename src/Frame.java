public class Frame {

    int score;
    int pinsFirstAttempt;
    int pinsSecondAttempt;
    int extra1;
    int extra2;
    int totalPinsInAFrame;
    int frameNumber;

    public Frame(int totalPinsInAFrame, int frameNumber) {
        pinsFirstAttempt = 0;
        pinsSecondAttempt = 0;
        extra1 = 0;
        extra2 = 0;
        score = 0;
        this.frameNumber = frameNumber;
        this.totalPinsInAFrame = totalPinsInAFrame;
    }

    public boolean isAStrike() {
        return pinsFirstAttempt == totalPinsInAFrame;
    }

    public boolean isASpare() {
        return (pinsFirstAttempt + pinsSecondAttempt) == totalPinsInAFrame;
    }

    public void calculateFrameScore() {
        this.score = pinsFirstAttempt + pinsSecondAttempt + extra1 + extra2;
    }

    public void printFrame() {
        String attempt2 = isASpare() && pinsFirstAttempt == 10 ? ", Attempt 2 = N/A" : ", Attempt 2 =" + pinsSecondAttempt;

        String scoreString = pinsFirstAttempt + (isASpare() ? "" : " + " + pinsSecondAttempt) + " + [" + extra1 + " + " + extra2 + " ] = " + score;

        System.out.println(" Frame Number : " + frameNumber +
                " [ Attempt 1 =" + pinsFirstAttempt +
                attempt2 +
                ", extra1 =" + extra1 +
                ", extra2 =" + extra2 +
                ", Frame total =" + scoreString + " ]");

    }
}
