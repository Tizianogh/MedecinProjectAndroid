package com.example.sio.gsbandroidstudio;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sio.gsbandroidstudio.AutreActivity;
import com.example.sio.gsbandroidstudio.R;

import java.util.List;

import model.DAO;


public class MainActivity extends ListActivity {
    private List<String> dep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        new LisNoms().execute();

    }


    @Override
    protected void onListItemClick (ListView l, View v, int position, long id){
        String leNom = (String) l.getItemAtPosition(position);
        Intent inter=new Intent(this, AutreActivity.class);
        inter.putExtra("leDep", ""+l.getItemAtPosition(position));
        startActivity(inter);
    }


    // public void clickButtonAffi( v){
    //     android.widget.Toast.makeText(getApplicationContext(),"Coucou les amis", android.widget.Toast.LENGTH_LONG).show();
//}

    private class LisNoms extends AsyncTask {
        @Override
        protected Object doInBackground(Object[] params) {
            dep = DAO.getLesDep();
            return null;
        }
        protected void onPostExecute(Object o){
            ArrayAdapter<String>adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,dep);

            setListAdapter(adapter);
        }

    }
}
