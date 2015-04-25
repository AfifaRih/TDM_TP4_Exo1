package esi.tp4_exo1;

import android.os.Environment;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;

import esi.tp4_exo1.Model.Etudiant;


/**
 * Created by THEDJA on 25/04/2015.
 */
public class FileEtudiantsController extends EtudiantsController {
    private final static String TAG = "MYTAG_FileEtudiantsController";
    private static String fileName = "etudiants.json";

    public FileEtudiantsController(){
        this.loadData();
    }

    @Override
    public LinkedList<Etudiant> getAll() {
        return null;
    }

    @Override
    public Etudiant get(long matricule) {
        return null;
    }

    @Override
    public void add(Etudiant etudiant) {

    }

    @Override
    public void remove(long matricule) {

    }

    @Override
    public void update(Etudiant etudiant) {

    }

    public void dispose(){
        this.saveData();
    }

    private void loadData() {
        File file = new File(Environment.getExternalStorageDirectory(), fileName);
        try {
            FileInputStream input = new FileInputStream(file);
            byte[] buffer = new byte[input.available()];
            // reading
            while (input.read(buffer) != -1) ;
            input.close();

            String jsontext = new String(buffer);
            JSONArray entries = new JSONArray(jsontext);

            for (int i=0, c=entries.length(); i<c ;i++)
            {
                JSONObject stud = entries.getJSONObject(i);
                JSONArray programmesJSON = stud.getJSONArray("programmes");
                Etudiant etudiant = new Etudiant(stud.getString("nom"), stud.getString("prenom"),
                        stud.getLong("matricule"), new Date(stud.getString("dateNaissance")), stud.getString("telephone"));

                etudiants.add(etudiant);
            }

        } catch (FileNotFoundException e) {
            Log.e(TAG, "FileNotFoundException -> file not found !\n" + e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "IOException -> unkown !\n" + e.getMessage());
        } catch (JSONException e) {
            Log.e(TAG, "JSONException -> Can't parse JSON file !\n" + e.getMessage());
        }
    }

    private void saveData() {
        File file = new File(Environment.getExternalStorageDirectory(), fileName);
        file.mkdirs();
        try {
            FileOutputStream output = new FileOutputStream(file);
            String jsonArray = "{";

            for(int i=0, c=etudiants.size(); i<c; i++){
                jsonArray += etudiants.get(i).toJSON();
                jsonArray += (i<c ? "," : "");
            }
            jsonArray += "}";

            output.write(jsonArray.getBytes());
            output.close();

        } catch (FileNotFoundException e) {
            Log.i(TAG, "FileNotFoundException");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            Log.i(TAG, "IOException");
        }
    }
}
