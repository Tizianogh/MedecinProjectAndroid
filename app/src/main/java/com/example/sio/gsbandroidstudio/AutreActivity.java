package com.example.sio.gsbandroidstudio;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.app.ListActivity;

import com.example.sio.gsbandroidstudio.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import model.DAO;
import model.Medecin;

public class AutreActivity extends ListActivity {
private String num;
    private List<Medecin> lesMeds;
    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_autre);
        //TextView label = findViewById(R.id.label);
        Intent inter = getIntent();
         num = inter.getStringExtra("leDep");
        //label.setText(num);
        new Lismed().execute();
    }

    class Lismed extends AsyncTask {
        @Override
        protected Object doInBackground(Object[] params) {
            lesMeds = DAO.getLesMeds(num);
            return null;
        }

        protected void onPostExecute(Object o) {


            MedAdapter adapter = new MedAdapter(lesMeds, AutreActivity.this);
            setListAdapter(adapter);
        }
    }
    public void clickButtonFilter (View v){
         List<Medecin> lesMedsFiltrer=new ArrayList<>();
         lesMedsFiltrer.clear();
         TextView searchLetter = findViewById(R.id.editText);
         String nom = searchLetter.getText().toString();
         for (Medecin unMed : lesMeds){
             if (unMed.getNom().startsWith(nom)){
                 lesMedsFiltrer.add(unMed);
             }

         }
         MedAdapter adapter = new MedAdapter(lesMedsFiltrer,this);
         setListAdapter(adapter);
    }


}


