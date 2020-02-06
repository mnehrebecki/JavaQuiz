package com.example.javaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;


public class BeforeStart extends AppCompatActivity {
    Bundle nameBundle = new Bundle();
    String name = "";
    String selectedCategory;
    Spinner spinnerCategory ;
    List<Category> categoryList;
    String[] categoryNames = new String[3];
    Integer[] categoryId = new Integer[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_start);
        Button btn_start_game = findViewById(R.id.button_start_game);
        spinnerCategory = findViewById(R.id.spinner);
        final EditText editName = findViewById(R.id.editName);
        QuizDB db = QuizDB.getInstance(this);
        categoryList = db.categoryDAO().getAll();

        for(int i=0;i<categoryList.size();i++){
            categoryNames[i] = categoryList.get(i).name;
            categoryId[i] = categoryList.get(i).id;
        }

        ArrayAdapter<String> adapterCategory = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,categoryNames);
        adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapterCategory);

        btn_start_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editName.getText().toString();

                if(name.isEmpty()) {
                    Toast.makeText(BeforeStart.this, "Wpisz imię", Toast.LENGTH_SHORT).show();
                }else {
                    nameBundle.putString("playerName",name);
                    startGame();
                }
            }
        });
    }

    private void startGame() {
        int selectedCategoryId=1;
        selectedCategory = spinnerCategory.getSelectedItem().toString();
        for(int i = 0;i<categoryNames.length;i++) {
            if (selectedCategory.equals(categoryNames[i])){
                selectedCategoryId=categoryId[i];
            }
        }

        nameBundle.putInt("categoryId",selectedCategoryId);
        Intent start_game = new Intent(BeforeStart.this, QuizActivity.class);
        start_game.putExtras(nameBundle);
        startActivity(start_game);
    }
}
