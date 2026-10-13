import java.util.HashSet;
import java.util.Set;

public class Activitate {
    private String nume;
    private Profesor coordonator;
    private Set<Elev> participanti = new HashSet<>();

    public Activitate (String nume, Profesor coordonator){
        this.nume = nume;
        this.coordonator = coordonator;
    }

    public void adaugaParticipanti(Elev elev){
        participanti.add(elev);
    }
    public void eliminaParticipanti(Elev elev){
        participanti.remove(elev);
    }
    public int getNumarParticipanti(){
        return participanti.size();
    }
    public String getNume(){
        return nume;
    }
    public Profesor getCoordonator(){
        return coordonator;
    }
    public Set<Elev> getParticipanti(){
        return participanti;
    }
}
