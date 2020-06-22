public class Parliament {

    public final Candidate[] candidates;
    public int emptyChair;

    public Parliament() {
        this.candidates = new Candidate[13];

        for (int i = 0; i < 12; i++) {
            if (i % 2 == 0) this.candidates[i] = new Candidate(i + 1, Names.NAMES[i], 1);
            else this.candidates[i] = new Candidate(i + 1, Names.NAMES[i], 2);
        }

        this.emptyChair = 12;
        this.candidates[12] = null;
    }

    public String start() {
        boolean gameFinished = false;
        int winningTeam = 0;
        while (!gameFinished) {
            int player = emptyChair - 1;
            if (player < 0) player = this.candidates.length;
            String selectedName = this.candidates[player].takeTurn();

            // UPDATE CANDIDATES

            // CHECK TO SEE IF THE GAME ENDS
            if (this.parliamentIsFilled()) {
                if (this.parliamentContainsAllTeam1Members()) {
                    winningTeam = 1;
                    gameFinished = true;
                }
                else if (this.parliamentContainsAllTeam2Members()) {
                    winningTeam = 2;
                    gameFinished = true;
                }
            }
        }

        // ANNOUNCE THE WINNING TEAM
        if (winningTeam == 1) return "Team 1 Wins";
        else return "Team 2 Wins";
    }

    private boolean parliamentIsFilled() {
        if (this.candidates[0] != null)
            if (this.candidates[1] != null)
                if (this.candidates[2] != null)
                    return this.candidates[3] != null;
        return false;
    }

    private boolean parliamentContainsAllTeam1Members() {
        if (this.candidates[0].team == 1)
            if (this.candidates[1].team == 1)
                if (this.candidates[2].team == 1)
                    return this.candidates[3].team == 1;
        return false;
    }

    private boolean parliamentContainsAllTeam2Members() {
        if (this.candidates[0].team == 2)
            if (this.candidates[1].team == 2)
                if (this.candidates[2].team == 2)
                    return this.candidates[3].team == 2;
        return false;
    }

}
