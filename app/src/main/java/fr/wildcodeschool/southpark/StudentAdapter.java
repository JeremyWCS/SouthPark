package fr.wildcodeschool.southpark;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<StudentModel> {

    public StudentAdapter(Context context, ArrayList<StudentModel> studentModels) {

        super(context, 0, studentModels);

    }



    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position

        StudentModel studentModel = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view

        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.student_item, parent, false);

        }

        // Lookup view for data population

        TextView prénom = (TextView) convertView.findViewById(R.id.prénom_textView);

        TextView nom = (TextView) convertView.findViewById(R.id.nom_textView);

        // Populate the data into the template view using the data object

        prénom.setText(studentModel.getFistname());

        nom.setText(studentModel.getLastname());

        // Return the completed view to render on screen

        return convertView;

    }

}
