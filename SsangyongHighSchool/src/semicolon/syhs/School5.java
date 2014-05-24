package semicolon.syhs;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class School5 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_school5);
		
		Button plus = (Button)findViewById(R.id.plus);
		plus.setOnClickListener(new View.OnClickListener()
		{	
			public void onClick(View v)
			{	
				Intent intent;
				intent = new Intent(Intent.ACTION_VIEW,
	    				Uri.parse("http://map.naver.com/?dlevel=11&pinType=site&pinId=12357913&x=127.113705&y=36.788691&enc=b64"));
	    		startActivity(intent);
			}
		});
	}
}
