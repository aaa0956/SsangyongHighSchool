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
		final String[] menuList = { "1,2��", "3,4��", "5,6��", "7,8��", "9,10��", "11,12��", "13��" };
		menuAleart.setTitle("���� �������ּ���");
		menuAleart.setItems(menuList,new DialogInterface.OnClickListener() {
		 @Override
		public void onClick(DialogInterface dialog, int item) {
		  switch (item) {

		  case 0:
			  class31.setImageResource(R.drawable.class31);
			  grade31.setText("3�г� 1�� �ð�ǥ");
			  class32.setImageResource(R.drawable.class32);
			  grade32.setText("3�г� 2�� �ð�ǥ");
			  break;
		  case 1:
			  class31.setImageResource(R.drawable.class33);
			  grade31.setText("3�г� 3�� �ð�ǥ");
			  class32.setImageResource(R.drawable.class34);
			  grade32.setText("3�г� 4�� �ð�ǥ");
			  break;
		  case 2:
			  class31.setImageResource(R.drawable.class35);
			  grade31.setText("3�г� 5�� �ð�ǥ");
			  class32.setImageResource(R.drawable.class36);
			  grade32.setText("3�г� 6�� �ð�ǥ");
			  break;
		  case 3:
			  class31.setImageResource(R.drawable.class37);
			  grade31.setText("3�г� 7�� �ð�ǥ");
			  class32.setImageResource(R.drawable.class38);
			  grade32.setText("3�г� 8�� �ð�ǥ");
			  break;
		  case 4:
			 class31.setImageResource(R.drawable.class39);
			  grade31.setText("3�г� 9�� �ð�ǥ");
			  class32.setImageResource(R.drawable.class310);
			  grade32.setText("3�г� 10�� �ð�ǥ");
			  break;
		  case 5:
			 class31.setImageResource(R.drawable.class311);
			  grade31.setText("3�г� 11�� �ð�ǥ");
			  class32.setImageResource(R.drawable.class312);
			  grade32.setText("3�г� 12�� �ð�ǥ");
			  break;
		  case 6:
			  class31.setImageResource(R.drawable.class313);
			  grade31.setText("3�г� 13�� �ð�ǥ");
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
