package semicolon.syhs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Grade2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grade2);
		
		final ImageView class21 = (ImageView)findViewById(R.id.class21);
		final TextView grade21 = (TextView)findViewById(R.id.grade21);
		final ImageView class22 = (ImageView)findViewById(R.id.class22);			  
		final TextView grade22 = (TextView)findViewById(R.id.grade22);
		
		final AlertDialog.Builder menuAleart = new
				AlertDialog.Builder(Grade2.this);
		final String[] menuList = { "1,2반", "3,4반", "5,6반", "7,8반", "9,10반", "11,12반", "13반" };
		menuAleart.setTitle("반을 선택해주세요");
		menuAleart.setItems(menuList,new DialogInterface.OnClickListener() {
		 @Override
		public void onClick(DialogInterface dialog, int item) {
		  switch (item) {

		  case 0:
			  class21.setImageResource(R.drawable.class21);
			  grade21.setText("2학년 1반 시간표");
			  class22.setImageResource(R.drawable.class22);
			  grade22.setText("2학년 2반 시간표");
			  break;
		  case 1:
			  class21.setImageResource(R.drawable.class23);
			  grade21.setText("2학년 3반 시간표");
			  class22.setImageResource(R.drawable.class24);
			  grade22.setText("2학년 4반 시간표");
			  break;
		  case 2:
			  class21.setImageResource(R.drawable.class25);
			  grade21.setText("2학년 5반 시간표");
			  class22.setImageResource(R.drawable.class26);
			  grade22.setText("2학년 6반 시간표");
			  break;
		  case 3:
			  class21.setImageResource(R.drawable.class27);
			  grade21.setText("2학년 7반 시간표");
			  class22.setImageResource(R.drawable.class28);
			  grade22.setText("2학년 8반 시간표");
			  break;
		  case 4:
			  class21.setImageResource(R.drawable.class29);
			  grade21.setText("2학년 9반 시간표");
			  class22.setImageResource(R.drawable.class210);
			  grade22.setText("2학년 10반 시간표");
			  break;
		  case 5:
			  class21.setImageResource(R.drawable.class211);
			  grade21.setText("2학년 11반 시간표");
			  class22.setImageResource(R.drawable.class212);
			  grade22.setText("2학년 12반 시간표");
			  break;
		  case 6:
			  class21.setImageResource(R.drawable.class213);
			  grade21.setText("2학년 13반 시간표");
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

}
