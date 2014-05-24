package semicolon.syhs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Grade3 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grade3);
		
		final ImageView class31 = (ImageView)findViewById(R.id.class31);
		final TextView grade31 = (TextView)findViewById(R.id.grade31);
		final ImageView class32 = (ImageView)findViewById(R.id.class32);			  
		final TextView grade32 = (TextView)findViewById(R.id.grade32);
		
		final AlertDialog.Builder menuAleart = new
				AlertDialog.Builder(Grade3.this);
		final String[] menuList = { "1,2반", "3,4반", "5,6반", "7,8반", "9,10반", "11,12반", "13반" };
		menuAleart.setTitle("반을 선택해주세요");
		menuAleart.setItems(menuList,new DialogInterface.OnClickListener() {
		 @Override
		public void onClick(DialogInterface dialog, int item) {
		  switch (item) {

		  case 0:
			  class31.setImageResource(R.drawable.class31);
			  grade31.setText("3학년 1반 시간표");
			  class32.setImageResource(R.drawable.class32);
			  grade32.setText("3학년 2반 시간표");
			  break;
		  case 1:
			  class31.setImageResource(R.drawable.class33);
			  grade31.setText("3학년 3반 시간표");
			  class32.setImageResource(R.drawable.class34);
			  grade32.setText("3학년 4반 시간표");
			  break;
		  case 2:
			  class31.setImageResource(R.drawable.class35);
			  grade31.setText("3학년 5반 시간표");
			  class32.setImageResource(R.drawable.class36);
			  grade32.setText("3학년 6반 시간표");
			  break;
		  case 3:
			  class31.setImageResource(R.drawable.class37);
			  grade31.setText("3학년 7반 시간표");
			  class32.setImageResource(R.drawable.class38);
			  grade32.setText("3학년 8반 시간표");
			  break;
		  case 4:
			 class31.setImageResource(R.drawable.class39);
			  grade31.setText("3학년 9반 시간표");
			  class32.setImageResource(R.drawable.class310);
			  grade32.setText("3학년 10반 시간표");
			  break;
		  case 5:
			 class31.setImageResource(R.drawable.class311);
			  grade31.setText("3학년 11반 시간표");
			  class32.setImageResource(R.drawable.class312);
			  grade32.setText("3학년 12반 시간표");
			  break;
		  case 6:
			  class31.setImageResource(R.drawable.class313);
			  grade31.setText("3학년 13반 시간표");
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
