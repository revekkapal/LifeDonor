package com.iliasfotopoulos.lifedonor.Activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.iliasfotopoulos.lifedonor.Presenter.Implementation.LoginPresenterImpl;
import com.iliasfotopoulos.lifedonor.Presenter.LoginPresenter;
import com.iliasfotopoulos.lifedonor.R;
import com.iliasfotopoulos.lifedonor.View.LoginView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class LoginActivity extends BaseActivity implements LoginView
{
    private static final String TAG = "LoginActivity";

    private LoginPresenter loginPresenter;

    // UI references.
    @InjectView(R.id.email)
    protected AutoCompleteTextView mEmailView;

    @InjectView(R.id.password)
    protected EditText mPasswordView;

    //private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

        loginPresenter = new LoginPresenterImpl(this);

        // Set up the login form.
        //populateAutoComplete();

        mLoginFormView = findViewById(R.id.login_form);
        //mProgressView = findViewById(R.id.login_progress);
    }


    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented
     */
    @OnClick(R.id.email_sign_in_button)
    protected void attemptLogin() {
        resetErrors();

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString().trim();
        String password = mPasswordView.getText().toString().trim();

        loginPresenter.authenticateUser(email, password);

    }

    public void navigateToHome()
    {

    }

    public void setUsernameFocus()
    {
        mEmailView.requestFocus();
    }

    public void setPasswordFocus()
    {
        mPasswordView.requestFocus();
    }


    public void setUsernameError(String anError)
    {
        mEmailView.setError(anError);
    }

    public void setPasswordError(String anError)
    {
        mPasswordView.setError(anError);
    }

    private void resetErrors()
    {
        mEmailView.setError(null);
        mPasswordView.setError(null);
    }

    /*
    private void populateAutoComplete()
    {
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle)
    {
        return new CursorLoader(this,
                // Retrieve data rows for the device user's 'profile' contact.
                Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI,
                        ContactsContract.Contacts.Data.CONTENT_DIRECTORY), ProfileQuery.PROJECTION,

                // Select only email addresses.
                ContactsContract.Contacts.Data.MIMETYPE +
                        " = ?", new String[]{ContactsContract.CommonDataKinds.Email
                .CONTENT_ITEM_TYPE},

                // Show primary email addresses first. Note that there won't be
                // a primary email address if the user hasn't specified one.
                ContactsContract.Contacts.Data.IS_PRIMARY + " DESC");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        List<String> emails = new ArrayList<String>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            emails.add(cursor.getString(ProfileQuery.ADDRESS));
            cursor.moveToNext();
        }

        addEmailsToAutoComplete(emails);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {

    }

    private interface ProfileQuery {
        String[] PROJECTION = {
                ContactsContract.CommonDataKinds.Email.ADDRESS,
                ContactsContract.CommonDataKinds.Email.IS_PRIMARY,
        };

        int ADDRESS = 0;
        int IS_PRIMARY = 1;
    }


    private void addEmailsToAutoComplete(List<String> emailAddressCollection)
    {
        //Create adapter to tell the AutoCompleteTextView what to show in its dropdown list.
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(LoginActivity.this,
                        android.R.layout.simple_dropdown_item_1line, emailAddressCollection);

        mEmailView.setAdapter(adapter);
    }
    */

}

