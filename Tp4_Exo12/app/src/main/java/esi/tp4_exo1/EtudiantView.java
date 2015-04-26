package esi.tp4_exo1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import esi.tp4_exo1.Model.Etudiant;


/**
 * TODO: document your custom view class.
 */
public class EtudiantView extends LinearLayout {

    TextView matricule, nom, prenom, date, tel;
    private Button remove, modify;
    Etudiant std;
    EtudiantListener listener;

    public EtudiantView(Context context, Etudiant std) {
        super(context);
        bind(context);
        init(std);
    }

    public EtudiantView(Context context, AttributeSet attrs, Etudiant std) {
        super(context, attrs);
        bind(context);
        init(std);
    }

    public EtudiantView(Context context, AttributeSet attrs, int defStyleAttr, Etudiant std) {
        super(context, attrs, defStyleAttr);
        bind(context);
        init(std);
    }

    private void bind(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.etudiant_view, this, true);

        matricule = (TextView) view.findViewById(R.id.editTxt_matricule);
        nom = (TextView) view.findViewById(R.id.editTxt_nom);
        prenom = (TextView) view.findViewById(R.id.editTxt_prenom);
        date = (TextView) view.findViewById(R.id.editTxt_date);
        tel = (TextView) view.findViewById(R.id.editTxt_tel);
        
        remove = (Button) view.findViewById(R.id.remove);
        modify = (Button) view.findViewById(R.id.modify);
    }

    private void init(final Etudiant std){

        this.std = std;
        matricule.setText(""+std.matricule);
        nom.setText(std.nom);
        prenom.setText(std.prenom);
        date.setText(std.dataNaissance.toString());
        tel.setText(std.telephone);
        
        remove.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onSupprimeListener(std.matricule);
                
            }
        });

        modify.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onModifyListener(std);

            }
        });
    }

    public void setListener(EtudiantListener listener) {
        this.listener = listener;
    }

    public static interface EtudiantListener{
        
        public void onSupprimeListener(long matricule);
        public void onModifyListener(Etudiant std);
    }
}
