package com.example.intercalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    // Declare UI elements
    TextView workingsTV;
    TextView resultsTV;
    Button root;

    // Variables to store input and formula
    String workings = "";
    String formula = "";
    String tempFormula = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize TextViews and other UI elements
        initTextViews();
    }

    private void initTextViews() {
        // Initialize TextViews
        workingsTV = (TextView) findViewById(R.id.workingsTextView);
        resultsTV = (TextView) findViewById(R.id.resultTextView);
        root = findViewById(R.id.root);
    }

    private void setWorkings(String givenValue) {
        // Append the given value to the workings and update the TextView
        workings = workings + givenValue;
        workingsTV.setText(workings);
    }

    // Method invoked when the equals button is clicked
    public void equalsOnClick(View view) {
        Double result = null;
        // Use the Rhino JavaScript engine to evaluate the formula
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        checkForPowerOf();

        try {
            result = (double) engine.eval(formula);
        } catch (ScriptException e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }

        // Display the result in the results TextView
        if (result != null)
            resultsTV.setText(String.valueOf(result.doubleValue()));
    }

    // Method to check and convert "^" to "Math.pow"
    private void checkForPowerOf() {
        ArrayList<Integer> indexOfPowers = new ArrayList<>();
        for (int i = 0; i < workings.length(); i++) {
            if (workings.charAt(i) == '^')
                indexOfPowers.add(i);
        }

        formula = workings;
        tempFormula = workings;
        for (Integer index : indexOfPowers) {
            changeFormula(index);
        }
        formula = tempFormula;
    }

    // Method to convert "^" to "Math.pow"
    private void changeFormula(Integer index) {
        String numberLeft = "";
        String numberRight = "";

        for (int i = index + 1; i < workings.length(); i++) {
            if (isNumeric(workings.charAt(i)))
                numberRight = numberRight + workings.charAt(i);
            else
                break;
        }

        for (int i = index - 1; i >= 0; i--) {
            if (isNumeric(workings.charAt(i)))
                numberLeft = numberLeft + workings.charAt(i);
            else
                break;
        }

        String original = numberLeft + "^" + numberRight;
        String changed = "Math.pow(" + numberLeft + "," + numberRight + ")";
        tempFormula = tempFormula.replace(original, changed);
    }

    // Method to check if a character is numeric
    private boolean isNumeric(char c) {
        if ((c <= '9' && c >= '0') || c == '.')
            return true;

        return false;
    }

    // Method to clear the TextViews and reset variables
    public void clearOnClick(View view) {
        workingsTV.setText("");
        workings = "";
        resultsTV.setText("");
    }

    // Method to calculate the square of a number
    public void powerOfOnClick(View view) {
        if (workingsTV.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter a valid number..", Toast.LENGTH_SHORT).show();
        } else {
            Double d1 = Double.valueOf(workingsTV.getText().toString() + "");
            Double square = d1 * d1;
            resultsTV.setText(square.toString());
            workingsTV.setText(d1 + "²");
        }
    }

    // Method to calculate the square root of a number
    public void sqr_root(View view) {
        if (workingsTV.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter a valid number..", Toast.LENGTH_SHORT).show();
        } else {
            String str = workingsTV.getText().toString();
            Double r = Math.sqrt(Double.parseDouble(str));
            String result = r.toString();
            resultsTV.setText(result);
        }
    }
    // Methods to handle numeric and operator button clicks
    // ...

    public void divisionOnClick(View view) {
        setWorkings("/");
    }

    public void sevenOnClick(View view) {
        setWorkings("7");
    }

    public void eightOnClick(View view) {
        setWorkings("8");
    }

    public void nineOnClick(View view) {
        setWorkings("9");
    }

    public void timesOnClick(View view) {
        setWorkings("*");
    }

    public void fourOnClick(View view) {
        setWorkings("4");
    }

    public void fiveOnClick(View view) {
        setWorkings("5");
    }

    public void sixOnClick(View view) {
        setWorkings("6");
    }

    public void minusOnClick(View view) {
        setWorkings("-");
    }

    public void oneOnClick(View view) {
        setWorkings("1");
    }

    public void twoOnClick(View view) {
        setWorkings("2");
    }

    public void threeOnClick(View view) {
        setWorkings("3");
    }

    public void plusOnClick(View view) {
        setWorkings("+");
    }

    public void decimalOnClick(View view) {
        setWorkings(".");
    }

    public void zeroOnClick(View view) {
        setWorkings("0");
    }
}
