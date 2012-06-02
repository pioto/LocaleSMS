/*
 * Copyright 2009, 2012 Mike Kelly <pioto@pioto.org>
 * Distributed under the terms of the GNU General Public License v2
 */
package org.pioto.locale.sms;

import android.net.Uri;

/**
 * Class of {@code Intent} constants used by this <i>Locale</i> plug-in.
 */
final class Constants
{
    /**
     * Private constructor prevents instantiation.
     *
     * @throws UnsupportedOperationException because this class cannot be instantiated.
     */
    private Constants()
    {
        throw new UnsupportedOperationException("Constants(): Cannot instantiate Constants");
    }

    /**
     * Constant for storing the address to send the SMS to in the
     * store-and-forward {@code Intent}.
     */
    protected static final String INTENT_EXTRA_ADDRESS = "org.pioto.locale.sms.extra.ADDRESS";

    /**
     * Constant for storing the message body to send the SMS to in the
     * store-and-forward {@code Intent}.
     */
    protected static final String INTENT_EXTRA_MESSAGE = "org.pioto.locale.sms.extra.MESSAGE";
    
    /**
     * The URL of our help page.
     */
    protected static final Uri HELP_URL = Uri.parse("http://www.pioto.org/android/LocaleSMS.html");
}

