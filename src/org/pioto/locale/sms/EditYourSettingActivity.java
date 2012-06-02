/*
 * Copyright 2009 Mike Kelly <pioto@pioto.org>
 * Distributed under the terms of the GNU General Public License v2
 *
 * Based upon 'src/com/yourcompany/yourapp/EditYourSettingActivity.java' from 'Toast.zip',
 * Copyright 2009 two fourty four a.m. LLC.
 */
package org.pioto.locale.sms;

import com.twofortyfouram.locale.BreadCrumber;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

public final class EditYourSettingActivity extends Activity
{
    private boolean isCancelled = false;

    private static final String TAG = "org.pioto.locale.sms.EditYourSettingActivity";

    @Override
    public void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.main);

        // so hansel and grettle don't get lost
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.locale_ellipsizing_title);

        CharSequence breadcrumbString = BreadCrumber.generateBreadcrumb(getBaseContext(), getIntent(), getString(R.string.app_name));

        ((TextView) findViewById(R.id.locale_ellipsizing_title_text)).setText(breadcrumbString);
        setTitle(breadcrumbString);

        if (savedInstanceState == null)
        {
            final String address = getIntent().getStringExtra(Constants.INTENT_EXTRA_ADDRESS);
            final String message = getIntent().getStringExtra(Constants.INTENT_EXTRA_MESSAGE);

            Log.d(TAG, "address = \""+address+"\"; message = \""+message+"\"");

            if (address != null)
                ((EditText) findViewById(R.id.address)).setText(address);
            if (message != null)
                ((EditText) findViewById(R.id.message)).setText(message);
        }
    }

    @Override
    public void finish()
    {
        if (isCancelled)
            setResult(RESULT_CANCELED);
        else
        {
            final String address = ((EditText) findViewById(R.id.address)).getText().toString();
            final String message = ((EditText) findViewById(R.id.message)).getText().toString();

            Log.d(TAG, "address = \""+address+"\"; message = \""+message+"\"");

            if (0 == address.length() || 0 == message.length())
                setResult(RESULT_CANCELED);
            else
            {
                final Intent returnIntent = new Intent();

                returnIntent.putExtra(Constants.INTENT_EXTRA_ADDRESS, address);
                returnIntent.putExtra(Constants.INTENT_EXTRA_MESSAGE, message);

                returnIntent.putExtra(com.twofortyfouram.locale.Intent.EXTRA_STRING_BLURB, address);

                setResult(RESULT_OK, returnIntent);
            }
        }

        super.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu)
    {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onMenuItemSelected(final int featureId, final MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_dontsave:
                isCancelled = true;
                finish();
                Log.v(TAG, "dontsave");
                return true;
            case R.id.menu_save:
                finish();
                Log.v(TAG, "save");
                return true;
            case R.id.menu_help:
                final Intent helpIntent = new Intent(android.content.Intent.ACTION_VIEW);
                helpIntent.setData(Constants.HELP_URL);

                Log.v(TAG, "help");

                startActivity(helpIntent);
                return true;
        }

        return super.onMenuItemSelected(featureId, item);
    }
}

