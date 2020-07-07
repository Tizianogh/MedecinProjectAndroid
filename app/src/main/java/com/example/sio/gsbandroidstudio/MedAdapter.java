package com.example.sio.gsbandroidstudio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import model.Medecin;


public class MedAdapter extends BaseAdapter {
    private  List<Medecin> lesMeds;
    private Context c;
    public MedAdapter(List<Medecin> lesMeds, Context c){
        this.lesMeds=lesMeds;
        this.c=c;

    }
    public int getCount(){return lesMeds.size();}
    public Object getItem(int position){return lesMeds.get(position);}
    public long getItemId(int position){return position;};
    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater vi =
                (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=vi.inflate(R.layout.lignemed, null);
        TextView nom=convertView.findViewById(R.id.nom);
        TextView prenom = convertView.findViewById(R.id.prenom);
        TextView adresse = convertView.findViewById(R.id.adresse);
        TextView specialite = convertView.findViewById(R.id.specialite);
        TextView tel = convertView.findViewById(R.id.tel);
        Medecin leMed = lesMeds.get(position);
        specialite.setText(leMed.getSpecialite());
        nom.setText(leMed.getNom());
        prenom.setText(leMed.getPrenom());
        adresse.setText(leMed.getAdresse());
        tel.setText(leMed.getTelephone());
        return convertView;
    }
}
