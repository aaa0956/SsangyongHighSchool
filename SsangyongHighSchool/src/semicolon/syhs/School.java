package semicolon.syhs;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class School extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_school);
		
		ImageButton sc1 = (ImageButton)findViewById(R.id.sc1);
		sc1.setOnClickListener(new View.OnClickListener()
		{	
			@Override
			public void onClick(View v)
			{	
				Intent intent;
				intent = new Intent(Intent.ACTION_VIEW,
	    				Uri.parse("http://www.sy.caehs.kr/sub/info.do?m=0101&s=sy"));
	    		startActivity(intent);
			}
		});
		
		ImageButton sc2 = (ImageButton)findViewById(R.id.sc2);
		sc2.setOnClickListener(new View.OnClickListener()
		{	
			@Override
			public void onClick(View v)
			{	
				Intent intent = new Intent(School.this, School2.class);
				startActivity(intent);
			}
		});
		
		ImageButton sc3 = (ImageButton)findViewById(R.id.sc3);
		sc3.setOnClickListener(new View.OnClickListener()
		{	
			@Override
			public void onClick(View v)
			{	
				Intent intent;
				intent = new Intent(Intent.ACTION_VIEW,
	    				Uri.parse("http://www.sy.caehs.kr/sub/info.do?m=0103&s=sy"));
	    		startActivity(intent);
			}
		});
		
		ImageButton sc4 = (ImageButton)findViewById(R.id.sc4);
		sc4.setOnClickListener(new View.OnClickListener()
		{	
			@Override
			public void onClick(View v)
			{	
				Intent intent;
				intent = new Intent(Intent.ACTION_VIEW,
	    				Uri.parse("http://www.sy.caehs.kr/sub/info.do?page=010601&m=010601&s=sy"));
	    		startActivity(intent);
			}
		});
		
		ImageButton sc5 = (ImageButton)findViewById(R.id.sc5);
		sc5.setOnClickListener(new View.OnClickListener()
		{	
			@Override
			public void onClick(View v)
			{	
				Intent intent = new Intent(School.this, School5.class);
				startActivity(intent);
			}
		});
	}

}
