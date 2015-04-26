package esi.tp4_exo1;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

import esi.tp4_exo1.Model.Etudiant;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class AddEtudiant extends Fragment {

    EtudiantsController conroller;

    public AddEtudiant(EtudiantsController conroller) {

        this.conroller = conroller;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_add_etudiant, container, false);
        Button btn_creer = (Button) rootView.findViewById(R.id.btn_creer);
        btn_creer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String matricule = String.valueOf(((EditText)rootView.findViewById(R.id.editTxt_matricule)).getText());
                if(matricule.isEmpty()){
                    Toast.makeText(getActivity(), "Matricule : erreur", Toast.LENGTH_LONG).show();
                    return;
                }

                String nom = String.valueOf(((EditText)rootView.findViewById(R.id.editTxt_nom)).getText());
                if(nom.isEmpty()){
                    Toast.makeText(getActivity(), "nom : erreur", Toast.LENGTH_LONG).show();
                    return;
                }

                String prenom = String.valueOf(((EditText)rootView.findViewById(R.id.editTxt_prenom)).getText());
                if(prenom.isEmpty()){
                    Toast.makeText(getActivity(), "prenom : erreur", Toast.LENGTH_LONG).show();
                    return;
                }

                String tel = String.valueOf(((EditText)rootView.findViewById(R.id.editTxt_tel)).getText());
                if(tel.isEmpty()){
                    Toast.makeText(getActivity(), "tel : erreur", Toast.LENGTH_LONG).show();
                    return;
                }

                String date = String.valueOf(((EditText)rootView.findViewById(R.id.editTxt_date)).getText());
                if(date.isEmpty()){
                    Toast.makeText(getActivity(), "date : erreur", Toast.LENGTH_LONG).show();
                    return;
                }

                Etudiant std = new Etudiant(nom, prenom, Integer.parseInt(matricule), new Date(date), tel);
                //conroller.add(std);
            }
        });
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
}



