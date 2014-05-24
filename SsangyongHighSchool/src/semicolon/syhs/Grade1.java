package semicolon.syhs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Grade1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grade1);
		
		final ImageView class11 = (ImageView)findViewById(R.id.class11);
		final TextView grade11 = (TextView)findViewById(R.id.grade11);
		final ImageView class12 = (ImageView)findViewById(R.id.class12);			  
		final TextView grade12 = (TextView)findViewById(R.id.grade12);
		
		final AlertDialog.Builder menuAleart = new
				AlertDialog.Builder(Grade1.this);
		final String[] menuList = { "1,2��", "3,4��", "5,6��", "7,8��", "9,10��", "11,12��", "13��" };
		menuAleart.setTitle("���� �������ּ���");
		menuAleart.setItems(menuList,new DialogInterface.OnClickListener() {
		 @Override
		public void onClick(DialogInterface dialog, int item) {
		  switch (item) {

		  case 0:
			  class11.setImageResource(R.drawable.class11);
			  grade11.setText("1�г� 1�� �ð�ǥ");
			  class12.setImageResource(R.drawable.class12);
			  grade12.setText("1�г� 2�� �ð�ǥ");
			  break;
		  case 1:
			  class11.setImageResource(R.drawable.class13);
			  grade11.setText("1�г� 3�� �ð�ǥ");
			  class12.setImageResource(R.drawable.class14);
			  grade12.setText("1�г� 4�� �ð�ǥ");
			  break;
		  case 2:
			  class11.setImageResource(R.drawable.class15);
			  grade11.setText("1�г� 5�� �ð�ǥ");
			  class12.setImageResource(R.drawable.class16);
			  grade12.setText("1�г� 6�� �ð�ǥ");
			  break;
		  case 3:
			  class11.setImageResource(R.drawable.class17);
			  grade11.setText("1�г� 7�� �ð�ǥ");
			  class12.setImageResource(R.drawable.class18);
			  grade12.setText("1�г� 8�� �ð�ǥ");
			  break;
		  case 4:
			  class11.setImageResource(R.drawable.class19);
			  grade11.setText("1�г� 9�� �ð�ǥ");
			  class12.setImageResource(R.drawable.class110);
			  grade12.setText("1�г� 10�� �ð�ǥ");
			  break;
		  case 5:
			  class11.setImageResource(R.drawable.class111);
			  grade11.setText("1�г� 11�� �ð�ǥ");
			  class12.setImageResource(R.drawable.class112);
			  grade12.setText("1�г� 12�� �ð�ǥ");
			  break;
		  case 6:
			  class11.setImageResource(R.drawable.class113);
			  grade11.setText("1�г� 13�� �ð�ǥ");
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
