package fr.wildcodeschool.southpark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public static String EXTRA_PRENOM = "EXTRA_PRENOM";
    public static String EXTRA_NOM = "EXTRA_NOM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Construct the data source

        final ArrayList<StudentModel> students = new ArrayList<>();
        students.add(new StudentModel("Stan", "Marsh"));
        students.add(new StudentModel("Eric", "Cartman"));
        students.add(new StudentModel("Kenny", "Broflovski"));
        students.add(new StudentModel("Kyle", "McCormick"));
        students.add(new StudentModel("Wendy", "Testaburger"));


        // Create the adapter to convert the array to views

        StudentAdapter adapter = new StudentAdapter(this, students);

        // Attach the adapter to a ListView

        final ListView listView = (ListView) findViewById(R.id.list_view_id);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent goToStudentActivity =
                        new Intent(MainActivity.this, StudentActivity.class);


                StudentModel student = (StudentModel) listView.getItemAtPosition(i);
                String extraPrenom = student.getFistname();
                String extraNom = student.getLastname();
                goToStudentActivity.putExtra(EXTRA_PRENOM, extraPrenom);
                goToStudentActivity.putExtra(EXTRA_NOM,extraNom);
                MainActivity.this.startActivity(goToStudentActivity);
            }
        });
    }
}
