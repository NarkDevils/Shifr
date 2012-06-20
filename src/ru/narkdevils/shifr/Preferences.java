package ru.narkdevils.shifr;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.util.Log;

public class Preferences extends PreferenceActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preference);
		
		Preference Like = (Preference) findPreference("like_button");
		Like.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
		      public boolean onPreferenceClick(Preference arg0) {
		    	  try {
		    		  Intent intent = new Intent(Intent.ACTION_VIEW);
		    		  intent.setData(Uri.parse("market://details?id=ru.narkdevils.shifr"));
		    		  startActivity(intent);
		    	  } catch (ActivityNotFoundException e) {
		    		  Intent intent = new Intent(Intent.ACTION_VIEW);
		    		  intent.setData(Uri.parse("http://play.google.com/store/apps/details?id=ru.narkdevils.shifr"));
		    		  startActivity(intent);
		    	  }
		    	  
		          return true;
		      }
		});
		
		Preference Version = (Preference) findPreference("version");
		Version.setSummary(getVersionName(this));
	}
	
	public static String getVersionName(Context context) {
    	
    	String versionName = null;
        try {
            versionName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        }
        catch (final NameNotFoundException e) {
            Log.e(context.getClass().getSimpleName(), "Could not get version from manifest.");
        }
        if (versionName == null) {
            versionName = "unknown";
        }
        return versionName;
    }

}
