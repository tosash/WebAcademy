package com.alexp.webacademy;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity {

    private static final String CHECK_USERNAME = "Web@academy.ua";
    private static final String CHECK_PASSWORD = "Web123";
    private static final int iATTEMPT = 3;
    private int numIteration;

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private TextView mAttemptsView;
    private EditText intEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        numIteration = iATTEMPT;
        mAttemptsView = (TextView) findViewById(R.id.idAttempts);
        mAttemptsView.setVisibility(View.INVISIBLE);

        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        intEdit = (EditText) findViewById(R.id.editTextIntent);
        intEdit.setText(getIntent().getStringExtra("textParam"));
    }

    public void onClickText(View v) {
        if (v.getId() == R.id.editTextIntent) {
        }
        Intent intent = new Intent();
        intent.putExtra("name", intEdit.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }


    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    public void attemptLogin() {
        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;


        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            checkUser(email, password);
        }
    }


    private void checkUser(String usr, String psw) {
        numIteration--;

        if (numIteration > 0) {
            if (usr.equals(CHECK_USERNAME) && psw.equals(CHECK_PASSWORD)) {
                Toast.makeText(this, "You data is CORRECT", Toast.LENGTH_SHORT).show();
                this.finish();
            } else {
                setAttemptsText();
            }
        } else {
            Toast.makeText(this, "Sorry. You have used all attempts", Toast.LENGTH_SHORT).show();
            this.finish();
        }

    }

    private void setAttemptsText() {
        if (numIteration > 1) {
            mAttemptsView.setText(getResources().getText(R.string.attempt_left) + Integer.toString(numIteration));
            mAttemptsView.setTextColor(Color.parseColor("#FFBA00"));
            mAttemptsView.setVisibility(View.VISIBLE);
        } else {
            mAttemptsView.setText(getResources().getText(R.string.attempt_left) + Integer.toString(numIteration));
            mAttemptsView.setTextColor(Color.parseColor("#FF0600"));
            mAttemptsView.setVisibility(View.VISIBLE);
        }
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }


    protected void onPostExecute(final Boolean success) {
        if (success) {
            finish();
        } else {
            mPasswordView.setError(getString(R.string.error_incorrect_password));
            mPasswordView.requestFocus();
        }
    }


}



