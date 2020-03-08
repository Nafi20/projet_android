package com.iam.activities;


import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ibra.com.iam.projet_android.R;

/**
 * Created by ibra on 27/03/2018.
 */
public class ListeAgenceAdapater extends ArrayAdapter<Agence>{
    int resource;
    String response;
    Context context;

    public ListeAgenceAdapater(Context context, int resource, List<Agence> items) {
        super(context, resource, items);
        this.resource=resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LinearLayout agenceView;
        Agence agence = getItem(position);
        if(convertView==null) {
            agenceView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi;
            vi = (LayoutInflater)getContext().getSystemService(inflater);
            vi.inflate(resource, agenceView, true);
        } else {
            agenceView = (LinearLayout) convertView;
        }
        TextView contactName =(TextView)agenceView.findViewById(R.id.contactName);
        contactName.setTypeface(null, Typeface.BOLD);

        contactName.setTextSize(TypedValue.COMPLEX_UNIT_PX,30);
        TextView contactPhone = (TextView)agenceView.findViewById(R.id.contactPhone);

        contactPhone.setTextSize(TypedValue.COMPLEX_UNIT_PX,28);
        contactName.setText(agence.getNom());
        contactPhone.setText(agence.getTel());
        return agenceView;
    }

}
