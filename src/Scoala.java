import java.util.*;

public class Scoala {
    private Map<String, Clasa> clase = new HashMap<>();
    private Map<String, Activitate> activitati = new HashMap<>();
    public void adaugaClasa(String identificator, Clasa clasa){
        clase.put(identificator, clasa);
    }
    public void adaugaElevInClasa(String identificator, Elev elev){
        Clasa clasa = clase.get(identificator);
        if (clasa != null) {
            clasa.adaugaElev(elev);
        } else {
            System.out.println("Clasa " + identificator + " nu exista!");
        }
    }
    public void eliminaClasa(String identificator){
        clase.remove(identificator);
    }
    public void eliminaElevDupaNume(String nume){
        for(Clasa clasa : clase.values()){
            for(Elev elev : new ArrayList<>(clasa.getElevi())){
                if(elev.getNume().equals(nume)){
                    clasa.eliminaElev(elev);
                }
            }
        }
    }
    public int getNumarClase(){return clase.size();}
    public int getTotalElevi(){
        int total = 0;
        for(Clasa clasa : clase.values()){
            total+=clasa.getTotalElevi();
        }
        return total;
    }

    public void adaugaActivitate(String nume, Activitate activitate){
        activitati.put(nume, activitate);
    }
    public void eliminaActivitate(String nume){
        Activitate activitate = activitati.get(nume);
        if(activitate != null){
            for(Elev elev : activitate.getParticipanti()){
                elev.eliminaActivitate(nume);
            }
            activitati.remove(nume);
        }
    }
    public void inscrieElev(String numeActivitate, Elev elev){
        Activitate activitate = activitati.get(numeActivitate);
        if(activitate != null){
            activitate.adaugaParticipanti(elev);
            elev.adaugaActivitate(numeActivitate);
        }
        else{
            System.out.println("Activitatea " + numeActivitate + " nu exista!");
        }
    }

    public void eliminareElevDinActivitate(String numeActivitate, Elev elev){
        Activitate activitate = activitati.get(numeActivitate);
        if(activitate != null){
            activitate.eliminaParticipanti(elev);
            elev.eliminaActivitate(numeActivitate);
        }
        else{
            System.out.println("Activitatea " + numeActivitate + " nu exista!");
        }
    }

    public void afiseazaTopActivitati(){
        List<Activitate> top = new ArrayList<>(activitati.values());
        //sortare descrescatoare dupa nr de participanti
        for(int i = 0; i < top.size() - 1; i++){
            for(int j = i + 1; j < top.size(); j++){
                if(top.get(j).getNumarParticipanti() > top.get(i).getNumarParticipanti()){
                    Activitate aux = top.get(i);
                    top.set(i, top.get(j));
                    top.set(j, aux);
                }
            }
        }
        for(Activitate activitate : top){
            System.out.println(activitate.getNume() + "- " + activitate.getNumarParticipanti()  + " elevi");
        }
    }

    public int getNumarEleviCuActivitate(){
        Set<Elev> unici = new HashSet<>();
        for(Activitate activitate : activitati.values()){
            unici.addAll(activitate.getParticipanti());
        }
        return unici.size();
    }
}
