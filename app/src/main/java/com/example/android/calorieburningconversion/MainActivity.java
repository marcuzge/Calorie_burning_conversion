package com.example.android.calorieburningconversion;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submit;
    TextView summary;
    RadioGroup unit;
    RadioGroup exercise_type;
    String selection;
    String summ;
    TextView calories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = (Button) findViewById(R.id.btn_submit);
        summary = (TextView) findViewById(R.id.summary);
        calories = (TextView) findViewById(R.id.calories);
        unit = (RadioGroup) findViewById(R.id.unit);
        exercise_type = (RadioGroup) findViewById(R.id.exercise_type);




        unit.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                EditText num = (EditText) findViewById(R.id.num_field);
                double number = Integer.parseInt(num.getText().toString());
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                RadioButton pushup = (RadioButton) findViewById(R.id.push_up);
                RadioButton situp = (RadioButton) findViewById(R.id.sit_up);
                RadioButton jumping = (RadioButton) findViewById(R.id.jumping_jacks);
                RadioButton jogging = (RadioButton) findViewById(R.id.jogging);
                switch (rb.getId()) {
                    case R.id.reps:
                        if (pushup.isChecked()) {
                            selection = convertCalories(rb, number) + "cal";
                            summ = "Situp: " + Math.floor(convertCalories(rb, number) / 100 * 200) + " Reps"
                                    + "\nJummping Jacks: " + Math.floor(convertCalories(rb, number) / 100 * 10) + " Minutes"
                                    + "\nJogging: " + Math.floor(convertCalories(rb, number) / 100 * 12) + " Minutes";
                            break;

                        } else if (situp.isChecked()) {
                            selection = convertCalories(rb, number) + "cal";
                            summ = "Pushup: " + Math.floor(convertCalories(rb, number) / 100 * 350) + " Reps"
                                    + "\nJummping Jacks: " + Math.floor(convertCalories(rb, number) / 100 * 10) + " Minutes"
                                    + "\nJogging: " + Math.floor(convertCalories(rb, number) / 100 * 12) + " Minutes";
                            break;

                        } else {
                            Toast.makeText(getApplicationContext(), "incompactible unit with the type of exercise selected", Toast.LENGTH_SHORT).show();
                            break;
                        }



                    case R.id.minutes:
                        if (jumping.isChecked()) {
                            selection = convertCalories(rb, number) + "cal";
                            summ = "Pushup: " + Math.floor(convertCalories(rb, number) / 100 * 350) + " Reps"
                                    + "\nSitup: " + Math.floor(convertCalories(rb, number) / 100 * 200) + " Minutes"
                                    + "\nJogging: " + Math.floor(convertCalories(rb, number) / 100 * 12) + " Minutes";
                            break;

                        } else if (jogging.isChecked()) {
                            selection = convertCalories(rb, number) + "cal";
                            summ = "Pushup: " + Math.floor(convertCalories(rb, number) / 100 * 350) + " Reps"
                                    + "\nSitup: " + Math.floor(convertCalories(rb, number) / 100 * 200) + " Minutes"
                                    + "\nJumpping Jacks: " + Math.floor(convertCalories(rb, number) / 100 * 10) + " Minutes";
                            break;

                        } else {
                            Toast.makeText(getApplicationContext(), "incompactible unit with the type of exercise selected", Toast.LENGTH_SHORT).show();
                            break;
                        }


                }
            }
        });

        exercise_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                EditText num = (EditText) findViewById(R.id.num_field);
                double number = Integer.parseInt(num.getText().toString());
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                RadioButton unitReps = (RadioButton) findViewById(R.id.reps);
                RadioButton unitMins = (RadioButton) findViewById(R.id.minutes);
                switch (rb.getId()) {
                    case R.id.push_up:
                        if (unitReps.isChecked()) {
                            selection = convertCalories(rb, number) + "cal";
                            summ = "Situp: " + Math.floor(convertCalories(rb, number) / 100 * 200) + " Reps"
                                    + "\nJummping Jacks: " + Math.floor(convertCalories(rb, number) / 100 * 10) + " Minutes"
                                    + "\nJogging: " + Math.floor(convertCalories(rb, number) / 100 * 12) + " Minutes";
                            break;
                        } else {
                            Toast.makeText(getApplicationContext(), "incompactible unit with the type of exercise selected", Toast.LENGTH_SHORT).show();
                            break;
                        }



                    case R.id.sit_up:
                        if (unitReps.isChecked()) {
                            selection = convertCalories(rb, number) + "cal";
                            summ = "Pushup: " + Math.floor(convertCalories(rb, number) / 100 * 350) + " Reps"
                                    + "\nJummping Jacks: " + Math.floor(convertCalories(rb, number) / 100 * 10) + " Minutes"
                                    + "\nJogging: " + Math.floor(convertCalories(rb, number) / 100 * 12) + " Minutes";
                            break;
                        }else {
                            Toast.makeText(getApplicationContext(), "incompactible unit with the type of exercise selected", Toast.LENGTH_SHORT).show();
                            break;
                        }



                    case R.id.jumping_jacks:
                        if (unitMins.isChecked()) {
                            selection = convertCalories(rb, number) + "cal";
                            summ = "Pushup: " + Math.floor(convertCalories(rb, number) / 100 * 350) + " Reps"
                                    + "\nSitup: " + Math.floor(convertCalories(rb, number) / 100 * 200) + " Minutes"
                                    + "\nJogging: " + Math.floor(convertCalories(rb, number) / 100 * 12) + " Minutes";
                            break;
                        } else {
                            Toast.makeText(getApplicationContext(), "incompactible unit with the type of exercise selected", Toast.LENGTH_SHORT).show();
                            break;
                        }


                    case R.id.jogging:
                        if (unitMins.isChecked()) {
                            selection = convertCalories(rb, number) + "cal";
                            summ = "Pushup: " + Math.floor(convertCalories(rb, number) / 100 * 350) + " Reps"
                                    + "\nSitup: " + Math.floor(convertCalories(rb, number) / 100 * 200) + " Minutes"
                                    + "\nJumpping Jacks: " + Math.floor(convertCalories(rb, number) / 100 * 10) + " Minutes";
                            break;
                        } else {
                            Toast.makeText(getApplicationContext(), "incompactible unit with the type of exercise selected", Toast.LENGTH_SHORT).show();
                            break;
                        }


                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calories.setText("" + selection);
                summary.setText("" + summ);
            }
        });
    }

    public double convertCalories(RadioButton rb, double num) {
        double CaloriesBurned;
        if (rb.getId() == R.id.push_up) {
            CaloriesBurned = Math.floor(num / 350 * 100);
        } else if (rb.getId() == R.id.sit_up) {
            CaloriesBurned = Math.floor(num / 200 * 100);
        } else if (rb.getId() == R.id.jumping_jacks) {
            CaloriesBurned = Math.floor(num / 10 * 100);
        } else {
            CaloriesBurned = Math.floor(num / 12 * 100);
        }
        return CaloriesBurned;

    }

    public void resetSco(View v) {
        summary = (TextView) findViewById(R.id.summary);
        calories = (TextView) findViewById(R.id.calories);

        calories.setText("0");
        summary.setText("");
        EditText num = (EditText) findViewById(R.id.num_field);
        num.getText().clear();

    }



}
