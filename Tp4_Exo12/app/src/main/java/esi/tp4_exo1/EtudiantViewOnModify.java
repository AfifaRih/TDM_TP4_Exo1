package esi.tp4_exo1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;

import esi.tp4_exo1.Model.Etudiant;


/**
 * TODO: document your custom view class.
 */
public class EtudiantViewOnModify extends LinearLayout {

    EditText matricule, nom, prenom, date, tel;
    private Button validate;
    Etudiant std;
    EtudiantListener listener;

    public EtudiantViewOnModify(Context context) {
        super(context);
        bind(context);
    }

    public EtudiantViewOnModify(Context context, AttributeSet attrs) {
        super(context, attrs);
        bind(context);
    }

    public EtudiantViewOnModify(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        bind(context);
    }

    private void bind(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.etudiant_view_onmodify, this, true);

        matricule = (EditText) view.findViewById(R.id.editTxt_matricule);
        nom = (EditText) view.findViewById(R.id.editTxt_nom);
        prenom = (EditText) view.findViewById(R.id.editTxt_prenom);
        date = (EditText) view.findViewById(R.id.editTxt_date);
        tel = (EditText) view.findViewById(R.id.editTxt_tel);
        
        validate = (Button) view.findViewById(R.id.validate);
    }

    public void init(final Etudiant std){

        this.std = std;
        matricule.setText(""+std.matricule);
        nom.setText(std.nom);
        prenom.setText(std.prenom);
        date.setText(std.dataNaissance.toString());
        tel.setText(std.telephone);

        validate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                long mat = std.matricule;
                Etudiant newStd = new Etudiant(String.valueOf(nom.getText()),
                        String.valueOf(prenom.getText()),
                        Integer.parseInt(String.valueOf(matricule.getText())),
                        new Date(String.valueOf(date.getText())),
                        String.valueOf(tel.getText()));
                listener.onValidateListener(mat, newStd);
            }
        });
    }

    public void setListener(EtudiantListener listener) {
        this.listener = listener;
    }

    public static interface EtudiantListener{
        
        public void onValidateListener(long matricule, Etudiant std);
    }
}
