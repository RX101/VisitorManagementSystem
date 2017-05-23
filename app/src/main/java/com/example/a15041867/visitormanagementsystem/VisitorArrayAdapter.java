package com.example.a15041867.visitormanagementsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15017082 on 24/5/2017.
 */

public class VisitorArrayAdapter extends ArrayAdapter<Visitor> {
    Context context;
    ArrayList<Visitor> visitors;
    TextView tvNRIC, tvName, tvPhoneNumber, tvEmail;
    int resource;

    public VisitorArrayAdapter(Context context, int resource, ArrayList<Visitor> visitors) {
        super(context, resource, visitors);
        this.context = context;
        this.visitors = visitors;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(resource, parent, false);

        //Match the UI components with Java variables

        tvNRIC = (TextView) rowView.findViewById(R.id.tvNRIC);
        tvName = (TextView) rowView.findViewById(R.id.tvName);
        tvPhoneNumber = (TextView) rowView.findViewById(R.id.tvPhoneNumber);
        tvEmail = (TextView) rowView.findViewById(R.id.tvEmail);

        Visitor visitor1 = visitors.get(position);
        String nric = visitor1.getVisitor_nric();
        tvNRIC.setText(nric);

        String name = visitor1.getVisitor_name();
        tvNRIC.setText(name);

        String phoneNumber = visitor1.getVisitor_phone_number();
        tvNRIC.setText(phoneNumber);

        String email = visitor1.getVisitor_email();
        tvNRIC.setText(email);

        return rowView;
    }

}
