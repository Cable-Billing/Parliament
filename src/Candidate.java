import java.util.ArrayList;

public class Candidate {

    public int id;
    public String name;
    public int team;
    public ArrayList<KnownCandidate> knownCandidates;

    public Candidate(int id, String name, int team) {
        this.id = id;
        this.name = name;
        this.team = team;
        this.knownCandidates = new ArrayList<>();
    }

    public String takeTurn() {
        return null;
    }

    public void candidateUpdate(int id, String name, int team) {
        for (KnownCandidate knownCandidate : knownCandidates) {
            if (knownCandidate.id == id) knownCandidate.name = name; return;
        }
        this.knownCandidates.add(new KnownCandidate(id, name, team));
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", team=" + team +
                '}';
    }
}
