package semicolon.syhs;

import android.app.Activity;
import android.widget.Toast;

public class BackPressCloseHandler {

	private long backKeyPressedTime = 0;
    private Toast toast;
 
    private Activity activity;
 
    public BackPressCloseHandler(Activity activity) {
        this.activity = activity;
    }
 
    public void onBackPressed() {
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            showGuide();
            return;
        }
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            activity.finish();
            toast.cancel();
        }
    }
 
    public void showGuide() {
        toast = Toast.makeText(activity,
                "\'�ڷ�\'��ư�� �ѹ� �� �����ø� ����˴ϴ�.", Toast.LENGTH_SHORT);
        toast.show();
    }
}
