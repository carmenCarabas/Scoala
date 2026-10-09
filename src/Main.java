//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scoala scoala = new Scoala();
    Clasa c1 = new Clasa(29, NumarClasa.I, 'A');
    Clasa c2 = new Clasa(30, NumarClasa.II, 'B');
    Clasa c3 = new Clasa(27, NumarClasa.III, 'A');
    Clasa c4 = new Clasa(28, NumarClasa.IV, 'B');

    scoala.adaugaClasa("1A", c1);
    scoala.adaugaClasa("2B", c2);
    scoala.adaugaClasa("3A", c3);
    scoala.adaugaClasa("4B", c4);

    scoala.adaugaElevInClasa("1A", new Elev("Ana", Gen.Feminin));
    scoala.adaugaElevInClasa("1A", new Elev("Ionela", Gen.Feminin));
    scoala.adaugaElevInClasa("1A", new Elev("Ion", Gen.Masculin));
    scoala.adaugaElevInClasa("2B", new Elev("Ana", Gen.Feminin));
    scoala.adaugaElevInClasa("2B", new Elev("Marius", Gen.Masculin));
    scoala.adaugaElevInClasa("3A", new Elev("Elisa", Gen.Feminin));
    scoala.adaugaElevInClasa("3A", new Elev("Gigel", Gen.Masculin));
    scoala.adaugaElevInClasa("3A", new Elev("Marian", Gen.Masculin));
    scoala.adaugaElevInClasa("4B", new Elev("Irina", Gen.Feminin));
    scoala.adaugaElevInClasa("4B", new Elev("George", Gen.Masculin));

    System.out.println("Clase: " + scoala.getNumarClase());
    System.out.println("Total elevi: "  + scoala.getTotalElevi());

    //Eliminare elev dintr-o clasa
     c1.eliminaElev(c1.getElevi().get(2)); //il eliminam pe Ion
    System.out.println("Dupa eliminarea lui Ion din 1A: " + scoala.getTotalElevi() );

    //sau
    Elev Georgiana = new Elev("Georgiana", Gen.Feminin);
    c1.adaugaElev(Georgiana);
    System.out.println("Dupa adaugarea Georgianei: " + scoala.getTotalElevi());
    c1.eliminaElev(Georgiana);
    System.out.println("Dupa eliminarea Georgianei: " + scoala.getTotalElevi());

    //Eliminare elev dupa nume (indiferent de clasa)
    scoala.eliminaElevDupaNume("Ana");
    System.out.println("Dupa eliminarea Anei: " + scoala.getTotalElevi());

    //Eliminare clasa
    scoala.eliminaClasa("1A");
    System.out.println("Clase dupa eliminare: " +  scoala.getNumarClase());
    System.out.println("Total elevi: " +  scoala.getTotalElevi());
}
