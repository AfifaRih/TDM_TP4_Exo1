package esi.tp4_exo1;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

import esi.tp4_exo1.Model.Etudiant;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class FindEtudiant extends Fragment implements EtudiantView.EtudiantListener, EtudiantViewOnModify.EtudiantListener {

    EtudiantsController conroller;
    View rootView;

    public FindEtudiant(EtudiantsController conroller) {

        this.conroller = conroller;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_find_etudiant, container, false);
        Button find = (Button) rootView.findViewById(R.id.find);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewGroup viewGroup = (ViewGroup) rootView;
                long matricule = Integer.parseInt(String.valueOf(((EditText)viewGroup.findViewById(R.id.editTxt_matricule)).getText()));
                //Etudiant std = conroller.get(matricule);
                showDetail(null);
            }
        });
        return rootView;
    }

    public void showDetail(Etudiant std){
        ViewGroup viewGroup = (ViewGroup) rootView;
        View view = viewGroup.findViewById(R.id.detail_std);
        int index = viewGroup.indexOfChild(view);
        viewGroup.removeView(view);

        Etudiant std1 = new Etudiant("RIH", "Afifa", 1455, new Date(), "0550145889");
        EtudiantView detail = new EtudiantView(getActivity(), std1);
        detail.setId(R.id.detail_std);
        detail.setListener(this);
        viewGroup.addView(detail, index);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onSupprimeListener(long matricule) {
        //conroller.remove(matricule);
        ViewGroup viewGroup = (ViewGroup) rootView;
        View view = viewGroup.findViewById(R.id.detail_std);
        int index = viewGroup.indexOfChild(view);
        viewGroup.removeView(view);

        View detail = new View(getActivity());
        detail.setId(R.id.detail_std);
        viewGroup.addView(detail, index);
    }

    @Override
    public void onModifyListener(Etudiant std) {
        ViewGroup viewGroup = (ViewGroup) rootView;
        View view = viewGroup.findViewById(R.id.detail_std);
        int index = viewGroup.indexOfChild(view);
        viewGroup.removeView(view);

        Etudiant std1 = new Etudiant("BOUISRI", "Djallel", 1455, new Date(), "0550145889");

        EtudiantViewOnModify detail = new EtudiantViewOnModify(getActivity());
        detail.init(std1);
        detail.setId(R.id.detail_std);
        detail.setListener(this);
        viewGroup.addView(detail, index);
    }

    @Override
    public void onValidateListener(long matricule, Etudiant std) {
        //conroller.update(matricule, std);
        showDetail(std);
    }
}



