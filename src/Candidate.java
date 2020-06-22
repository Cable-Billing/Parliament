public class Candidate {

    public int id;
    public String name;
    public int team;

    public Candidate(int id, String name, int team) {
        this.id = id;
        this.name = name;
        this.team = team;
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
