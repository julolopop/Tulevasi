package com.example.julolopop.tulevasi.ui.pref;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;

import com.example.julolopop.tulevasi.R;

/**
 * Created by Julolopop on 14/01/2018.
 */

public class PreferentLogin extends PreferenceActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting_login);
    }
}
