/*
 * Copyright 2009 Mike Kelly <pioto@pioto.org>
 * Distributed under the terms of the GNU General Public License v2
 */
package org.pioto.locale.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;

public final class FireReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(final Context context, final Intent intent)
    {
        String dest = "9082953882";
        String msg = "test";

        SmsManager.getDefault().sendTextMessage(dest, null, msg, null, null);
    }
}

