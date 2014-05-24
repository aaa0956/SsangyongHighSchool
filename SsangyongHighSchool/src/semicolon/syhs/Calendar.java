package semicolon.syhs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.widget.TextView;

public class Calendar extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendar);
		
		final TextView cal = (TextView)findViewById(R.id.cal);
		
		final AlertDialog.Builder menuAleart = new
				AlertDialog.Builder(Calendar.this);
		final String[] menuList = { "1학기", "2학기" };
		menuAleart.setTitle("학기를 선택해주세요");
		menuAleart.setItems(menuList,new DialogInterface.OnClickListener() {
		 @Override
		public void onClick(DialogInterface dialog, int item) {
		  switch (item) {

		  case 0:
			  String cal1;
				cal1 = DownHtm("http://syhs.dothome.co.kr/calendar/1.txt");
				cal.setText(cal1);
				break;
		  case 1:
			  String cal2;
			  cal2 = DownHtm("http://syhs.dothome.co.kr/calendar/2.txt");
			  cal.setText(cal2);
			  break;
		  }
		 }
		});
		menuAleart.setOnCancelListener(new OnCancelListener() {
	         
	         @Override
	         public void onCancel(DialogInterface dialog) {
	            finish();
	            
	         }
	      });
		AlertDialog menuDrop = menuAleart.create();
		menuDrop.show();
	}
	
	String DownHtm(String address){
		StringBuilder html = new StringBuilder();
		try{
			URL url = new URL(address);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			if(conn !=null){
				conn.setConnectTimeout(10000);
				conn.setUseCaches(false);
				if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
					BufferedReader buf = new BufferedReader(
							new InputStreamReader(conn.getInputStream()));
					for (;;){
						String line = buf.readLine();
						if(line == null) break;
						html.append(line + '\n');
					}
					buf.close();
				}
				conn.disconnect();
			}
		}catch(MalformedURLException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return html.toString();
	}
}

