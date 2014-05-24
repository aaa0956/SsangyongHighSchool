package semicolon.syhs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	
	private BackPressCloseHandler backPressCloseHandler;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		startActivity(new Intent(MainActivity.this, SplashActivity.class));
		
		backPressCloseHandler = new BackPressCloseHandler(this);
		
		findViewById(R.id.food).setOnClickListener(l);		
		findViewById(R.id.calendar).setOnClickListener(l);		
		findViewById(R.id.school).setOnClickListener(l);
		
		findViewById(R.id.call).setOnClickListener(new View.OnClickListener()
		{	
			@Override
			public void onClick(View v)
			{	
				final AlertDialog.Builder menuAleart = new
						AlertDialog.Builder(MainActivity.this);
				final String[] menuList = { "교무실", "행정실" };
				menuAleart.setTitle("천안쌍용고등학교");
				menuAleart.setItems(menuList,new DialogInterface.OnClickListener() {
				 @Override
				public void onClick(DialogInterface dialog, int item) {
				  switch (item) {

				  case 0:
						Intent intent;
						intent = new Intent(Intent.ACTION_DIAL,
			    				Uri.parse("tel:041-592-5313"));
			    		startActivity(intent);
				  break;
				  case 1:
						intent = new Intent(Intent.ACTION_DIAL,
			    				Uri.parse("tel:041-592-5315"));
			    		startActivity(intent);
				  break;
				  }
				 }
				});

	    		AlertDialog menuDrop = menuAleart.create();
	    		menuDrop.show();
			}
		});
		
		
		findViewById(R.id.clock).setOnClickListener(new View.OnClickListener()
		{	
			@Override
			public void onClick(View v)
			{	
				final AlertDialog.Builder menuAleart = new
						AlertDialog.Builder(MainActivity.this);
				final String[] menuList = { "1학년", "2학년", "3학년" };
				menuAleart.setTitle("학년을 선택해주세요");
				menuAleart.setItems(menuList,new DialogInterface.OnClickListener() {
				 @Override
				public void onClick(DialogInterface dialog, int item) {
				  switch (item) {

				  case 0:
					  Intent Grade1 = new Intent(MainActivity.this, Grade1.class);
						startActivity(Grade1);
				  break;
				  case 1:
					  Intent Grade2 = new Intent(MainActivity.this, Grade2.class);
						startActivity(Grade2);
				  break;
				  case 2:
					  Intent Grade3 = new Intent(MainActivity.this, Grade3.class);
						startActivity(Grade3);
				  break;
				  }
				 }
				});
	    		AlertDialog menuDrop = menuAleart.create();
	    		menuDrop.show();
			}
		});
	}
	
	OnClickListener l=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch(v.getId()) {
			case R.id.food:				
				startActivity(new Intent(MainActivity.this, Meal.class)); break;
			case R.id.calendar:				
				startActivity(new Intent(MainActivity.this, Calendar.class)); break;
			case R.id.school:
				startActivity(new Intent(MainActivity.this, School.class)); break;
			case R.id.facebook:
				startActivity(new Intent(MainActivity.this, Facebook.class)); break;
			}
			
		}
	};
	
	@Override
    public void onBackPressed() {
        backPressCloseHandler.onBackPressed();
    }

}
