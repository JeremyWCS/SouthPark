package fr.wildcodeschool.southpark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static fr.wildcodeschool.southpark.MainActivity.EXTRA_NOM;
import static fr.wildcodeschool.southpark.MainActivity.EXTRA_PRENOM;

public class StudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        Intent intentFromMain = getIntent();
        String prénom = intentFromMain.getStringExtra(EXTRA_PRENOM);
        String nom = intentFromMain.getStringExtra(EXTRA_NOM);

        TextView tvPrénom = findViewById(R.id.prénom_id);
        tvPrénom.setText(prénom);
        TextView tvNom = findViewById(R.id.nom_id);
        tvNom.setText(nom);
    }
}
