package esi.tp4_exo1;

import java.util.LinkedList;

import esi.tp4_exo1.Model.Etudiant;

/**
 * Created by THEDJA on 25/04/2015.
 */
public abstract class EtudiantsController {
    protected LinkedList<Etudiant> etudiants;

    public EtudiantsController() {
        this.etudiants = new LinkedList<>();
    }

    public abstract LinkedList<Etudiant> getAll();

    public abstract Etudiant get(long matricule);

    public abstract void add(Etudiant etudiant);

    public abstract void remove(long matricule);

    public abstract void update(Etudiant etudiant);
}
