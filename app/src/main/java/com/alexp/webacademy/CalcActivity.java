package com.alexp.webacademy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class CalcActivity extends ActionBarActivity {
    EditText firstText;
    EditText secondText;
    TextView resultText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        firstText = (EditText) findViewById(R.id.editFirst);
        secondText = (EditText) findViewById(R.id.editSecond);
        resultText = (TextView) findViewById(R.id.textResult);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.helpMe) {
            Uri address = Uri.parse("http://developer.alexanderklimov.ru");
            Intent openlink = new Intent(Intent.ACTION_VIEW, address);
            startActivity(openlink);
        }
        if (id == R.id.WiFi) {
            Intent wifi = new Intent(Settings.ACTION_WIFI_SETTINGS);
            startActivity(wifi);
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean chkEdits() {
        if ((firstText.getText() == null) || (firstText.getText().toString().isEmpty())) {
            firstText.setError("Input value");
            firstText.requestFocus();
            return false;
        } else if ((secondText.getText() == null) || (secondText.getText().toString().isEmpty())) {
            secondText.setError("Input value");
            secondText.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void onClick(View v) {
        double dFirst;
        double dSecond;
        EditText fedText;

        fedText = (EditText) getCurrentFocus();
        firstText.setError(null);
        secondText.setError(null);

        switch (v.getId()) {
            case R.id.buttonPlus:
                if (!chkEdits()) {
                    break;
                }
                dFirst = Double.parseDouble(firstText.getText().toString());
                dSecond = Double.parseDouble(secondText.getText().toString());
                resultText.setText(firstText.getText().toString() + "+"
                        + secondText.getText().toString() + "="
                        + Double.toString(dFirst + dSecond));
                break;
            case R.id.buttonMinus:
                if (!chkEdits()) {
                    break;
                }
                dFirst = Double.parseDouble(firstText.getText().toString());
                dSecond = Double.parseDouble(secondText.getText().toString());
                resultText.setText(firstText.getText().toString() + "-"
                        + secondText.getText().toString() + "="
                        + Double.toString(dFirst - dSecond));
                break;
            case R.id.buttonMultiplication:
                if (!chkEdits()) {
                    break;
                }
                dFirst = Double.parseDouble(firstText.getText().toString());
                dSecond = Double.parseDouble(secondText.getText().toString());
                resultText.setText(firstText.getText().toString() + "*"
                        + secondText.getText().toString() + "="
                        + Double.toString(dFirst * dSecond));
                break;
            case R.id.buttonDivision:
                if (!chkEdits()) {
                    break;
                }
                dFirst = Double.parseDouble(firstText.getText().toString());
                dSecond = Double.parseDouble(secondText.getText().toString());
                resultText.setText(firstText.getText().toString() + "/"
                        + secondText.getText().toString() + "="
                        + Double.toString(dFirst / dSecond));
                break;
            case R.id.button_0:
                fedText.setText(fedText.getText().toString() + "0");
                break;
            case R.id.button_1:
                fedText.setText(fedText.getText().toString() + "1");
                break;
            case R.id.button_2:
                fedText.setText(fedText.getText().toString() + "2");
                break;
            case R.id.button_3:
                fedText.setText(fedText.getText().toString() + "3");
                break;
            case R.id.button_4:
                fedText.setText(fedText.getText().toString() + "4");
                break;
            case R.id.button_5:
                fedText.setText(fedText.getText().toString() + "5");
                break;
            case R.id.button_6:
                fedText.setText(fedText.getText().toString() + "6");
                break;
            case R.id.button_7:
                fedText.setText(fedText.getText().toString() + "7");
                break;
            case R.id.button_8:
                fedText.setText(fedText.getText().toString() + "8");
                break;
            case R.id.button_9:
                fedText.setText(fedText.getText().toString() + "9");
                break;
            case R.id.button_dot:
                fedText.setText(fedText.getText().toString() + ".");
                break;
            case R.id.button_backspace:
                if (fedText.getText().toString().length() > 0) {
                    fedText.setText(fedText.getText().toString().substring(0,
                            fedText.getText().toString().length() - 1));
                }
                break;
        }
    }

}
