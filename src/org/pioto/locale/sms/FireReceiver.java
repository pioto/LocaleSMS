/*
 * Copyright 2009 Mike Kelly <pioto@pioto.org>
 * Distributed under the terms of the GNU General Public License v2
 */
package org.pioto.locale.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.text.TextUtils;

public final class FireReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(final Context context, final Intent intent)
    {
        if (com.twofortyfouram.Intent.ACTION_FIRE_SETTING.equals(intent.getAction()))
        {
            final String addr = intent.getStringExtra(Constants.INTENT_EXTRA_ADDRESS);
            final String msg = intent.getStringExtra(Constants.INTENT_EXTRA_MESSAGE);

            if (TextUtils.isEmpty(addr) || TextUtils.isEmpty(msg))
                return;

            SmsManager.getDefault().sendTextMessage(addr, null, msg, null, null);
        }
    }
}

