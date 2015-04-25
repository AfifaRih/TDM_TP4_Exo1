package esi.tp4_exo1;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListeEtudiant extends Fragment {

    public ListeEtudiant() {
        Log.i("ListeEtudiant", "ListeEtudiant ");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_liste_etudiant, container, false);
        Log.i("ListeEtudiant", "onCreateView ");
        ListView liste = (ListView) rootView.findViewById(R.id.liste);
        liste.setAdapter(new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_activated_1,
                android.R.id.text1,
                new String[]{
                        "RIH Afifa",
                        "BOUISRI Djallel",
                        "GHEZALI Meriem",
                }));
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
}



