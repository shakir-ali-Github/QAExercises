
public class Generic<G> {
	
    private G object;

    public void add(G object) {
        this.object = object;
    }

    public G get() {
        return object;
    }

}
