import java.util.HashSet;
import java.util.Set;

public class Elev {
    private String nume;
    private Gen gen;
    private Set<String> activitati = new HashSet<>();
    Elev(String nume, Gen gen){
        this.nume = nume;
        this.gen = gen;
    }
    public String getNume(){return nume;}
    public Gen getGen(){return gen;}

    public void adaugaActivitate(String numeActivitate)
    {
        activitati.add(numeActivitate);
    }
    public void eliminaActivitate(String numeActivitate)
    {
        activitati.remove(numeActivitate);
    }
    public Set<String> getActivitati(){return activitati;}
}
