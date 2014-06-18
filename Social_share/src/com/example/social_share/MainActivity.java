package com.example.social_share;

import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	ImageView facebook,twitter,linkedin;

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
				
				String urlToShare = "http://kalisandroid.blogspot.com";
				Intent intent = new Intent(Intent.ACTION_SEND);
				intent.setType("text/plain");
				intent.putExtra(Intent.EXTRA_TEXT, urlToShare);
				// See if official Facebook app is found
				boolean facebookAppFound = false;
				List<ResolveInfo> matches = getPackageManager().queryIntentActivities(intent, 0);
				for (ResolveInfo info : matches) {
				    if (info.activityInfo.packageName.toLowerCase().startsWith("com.facebook")) {
				        intent.setPackage(info.activityInfo.packageName);
				        facebookAppFound = true;
				        break;
				    }
				}
				//If facebook app not found, load sharer.php in a browser
				if (!facebookAppFound) {
				    String sharerUrl = "https://www.facebook.com/sharer/sharer.php?u=" + urlToShare;
				    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(sharerUrl));
				}
				startActivity(intent);
				
			}
		});
        
        twitter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String text = "...kaLis...";
				Intent intent = new Intent(Intent.ACTION_SEND);
				intent.setType("text/plain");
				intent.putExtra(Intent.EXTRA_TEXT, text);
				
				boolean twitterAppFound = false;
				List<ResolveInfo> matches = getPackageManager().queryIntentActivities(intent, 0);
				for (ResolveInfo info : matches) {
				    if (info.activityInfo.packageName.toLowerCase().startsWith("com.twitter")) {
				        intent.setPackage(info.activityInfo.packageName);
				        twitterAppFound = true;
				        break;
				    }
				}
				if (!twitterAppFound) {
				    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(text));
				}
				startActivity(intent);
				
			}
		});
 
        linkedin.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			String text = "...kaLis...";
			Intent intent = new Intent(Intent.ACTION_SEND);
			intent.setType("text/plain");
			intent.putExtra(Intent.EXTRA_TEXT, text);
			
			boolean linkedinAppFound = false;
			List<ResolveInfo> matches = getPackageManager().queryIntentActivities(intent, 0);
			for (ResolveInfo info : matches) {
			    if (info.activityInfo.packageName.toLowerCase().startsWith("com.linkedin")) {
			        intent.setPackage(info.activityInfo.packageName);
			        linkedinAppFound = true;
			        break;
			    }
			}
			if (!linkedinAppFound) 
			{
			    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(text));
			}
			startActivity(intent);
			
		}
	});

    }

}

