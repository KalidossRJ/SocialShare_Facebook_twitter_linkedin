package com.example.social_share;

import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	ImageView facebook,twitter,linkedin;
	Intent twitterIntent,linkedinIntent,facebookIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        facebook=(ImageView)findViewById(R.id.fb_icon);
        twitter=(ImageView)findViewById(R.id.twitter_icon);
        linkedin=(ImageView)findViewById(R.id.linkedin_icon);
        
        facebook.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String urlToShare = "http://kalisandroid.blogspot.com/";
				facebookIntent = new Intent(Intent.ACTION_SEND);
				facebookIntent.setType("text/plain");
				facebookIntent.putExtra(Intent.EXTRA_TEXT, urlToShare);

				boolean facebookAppFound = false;
				List<ResolveInfo> matches = getPackageManager()
						.queryIntentActivities(facebookIntent, 0);

				for (ResolveInfo info : matches) {
					if (info.activityInfo.packageName.toLowerCase().startsWith(
							"com.facebook")) {
						facebookIntent.setPackage(info.activityInfo.packageName);
						facebookAppFound = true;
						break;
					}
				}

				if (facebookAppFound) {
					startActivity(facebookIntent);
				}
				else
				{
					Toast.makeText(MainActivity.this,"Facebook app not Insatlled in your mobile", 4).show();
				}

			}
		});
        
        twitter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String text = "...kaLis...";
				twitterIntent = new Intent(Intent.ACTION_SEND);
				twitterIntent.setType("text/plain");
				twitterIntent.putExtra(Intent.EXTRA_TEXT, text);

				boolean twitterAppFound = false;
				List<ResolveInfo> matches1 = getPackageManager()
						.queryIntentActivities(twitterIntent, 0);
				for (ResolveInfo info : matches1) {
					if (info.activityInfo.packageName.toLowerCase().startsWith(
							"com.twitter")) {
						twitterIntent.setPackage(info.activityInfo.packageName);
						twitterAppFound = true;
						break;
					}
				}

				if (twitterAppFound) {
					startActivity(twitterIntent);
				}
				else
				{
					Toast.makeText(MainActivity.this,"Twitter app not Insatlled in your mobile", 4).show();
				}
				
			}
		});
 
        linkedin.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			

			String text1 = "...kaLis...";
			linkedinIntent = new Intent(Intent.ACTION_SEND);
			linkedinIntent.setType("text/plain");
			linkedinIntent.putExtra(Intent.EXTRA_TEXT, text1);

			boolean linkedinAppFound = false;
			List<ResolveInfo> matches2 = getPackageManager()
					.queryIntentActivities(linkedinIntent, 0);

			for (ResolveInfo info : matches2) {
				if (info.activityInfo.packageName.toLowerCase().startsWith(
						"com.linkedin")) {
					linkedinIntent.setPackage(info.activityInfo.packageName);
					linkedinAppFound = true;
					break;
				}
			}

			if (linkedinAppFound) {
				startActivity(linkedinIntent);

			}
			else
			{
				Toast.makeText(MainActivity.this,"LinkedIn app not Insatlled in your mobile", 4).show();
			}
			
		}
	});

    }

}

