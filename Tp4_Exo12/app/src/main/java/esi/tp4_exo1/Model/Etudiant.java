package esi.tp4_exo1.Model;

import java.util.Date;

/**
 * Created by THEDJA on 19/04/2015.
 */
public class Etudiant {
    public String nom;
    public String prenom;
    public long matricule;
    public Date dataNaissance;
    public String telephone;

    public Etudiant (String nom, String prenom, long matricule, Date dateNaissance, String telephone){
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dataNaissance = dateNaissance;
        this.telephone = telephone;
    }

    public String toJSON(){
        String jsonObject = "{"
                + "nom:"+this.nom
                + ", prenom:"+this.prenom
                + ", matricule:"+this.matricule
                + ", dateNaissance:"+this.dataNaissance
                + ", telephone:"+this.telephone
                + "}";

        return jsonObject;
    }
}
