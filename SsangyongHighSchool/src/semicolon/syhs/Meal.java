package semicolon.syhs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;
import net.htmlparser.jericho.Source;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Meal extends Activity {
   
    int month, date;
    final String URL="http://hes.cne.go.kr/sts_sci_md00_001.do?schulCode=N100002511&insttNm=%EC%B2%9C%EC%95%88%EC%8C%8D%EC%9A%A9%EA%B3%A0%EB%93%B1%ED%95%99%EA%B5%90&schulCrseScCode=4&schulKndScCode=04&schYm=2014.";

    Source source;
    Calendar cal;
    ArrayList<String> mealArr;
    TextView mealTV,dateTV;
    String dates;
   
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_meal);
      
      cal=Calendar.getInstance();
      date = cal.get(Calendar.DAY_OF_MONTH);
      month = cal.get(Calendar.MONTH)+1;
      
      dates = String.valueOf(date);
      
      dateTV = (TextView)findViewById(R.id.day);
      dateTV.setText(month+"월 "+date+"일 식단표");
      
      mealTV=(TextView)findViewById(R.id.meal);
      getData();
      
      findViewById(R.id.next).setOnClickListener(listener);
      findViewById(R.id.back).setOnClickListener(listener);
      findViewById(R.id.today).setOnClickListener(listener);         
   }
   
   /**OnClickListener**/
   View.OnClickListener listener=new View.OnClickListener() {
      
      @Override
      public void onClick(View v) {
         switch(v.getId()) {
         case R.id.back:
            cal.set(Calendar.DATE, date-1);
            if(month!=cal.get(Calendar.MONTH)+1) {
               month=cal.get(Calendar.MONTH)+1;
               initialize();
               getData();
            }
            date=cal.get(Calendar.DATE);
             mealTV.setText(mealArr.get(date-1));
            dateTV.setText(month+"월 "+date+"일 식단표");
            break;
         case R.id.today:
            cal=Calendar.getInstance();
            if(month!=cal.get(Calendar.MONTH)+1) {
               month=cal.get(Calendar.MONTH)+1;
               initialize();
               getData();
            }
            date=cal.get(Calendar.DATE);
            mealTV.setText(mealArr.get(date-1));
            dateTV.setText(month+"월 "+date+"일 식단표");
            break;
         case R.id.next:
            cal.set(Calendar.DATE, date+1);
            if(month!=cal.get(Calendar.MONTH)+1) {
               month=cal.get(Calendar.MONTH)+1;
               initialize();
               getData();
            }
            date=cal.get(Calendar.DATE);
            mealTV.setText(mealArr.get(date-1));
            dateTV.setText(month+"월 "+date+"일 식단표");
            break;
         }
      }
   };
   
   /**Call when month is Changed**/
   private void initialize() {
      source=null;
      mealArr.clear();
   }    
   
   /**getData**/
   private void getData() {
      try {
         getDataFromFile();
      } catch(FileNotFoundException e) {
         if(isNetworkAvailable()) {
            getDataFromServer();
         } else {
            Toast.makeText(this,"네트워크 상태를 확인하세요",Toast.LENGTH_SHORT).show();
            finish();
         }
      }      
   }
   
   private Boolean isNetworkAvailable(){
      ConnectivityManager connect = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
      if (connect.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == State.CONNECTED
            || connect.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == State.CONNECTED ) {
          return true;                
      } else {
          return false;    
      }
    }

   @SuppressWarnings("unchecked")
   private void getDataFromFile() throws FileNotFoundException {
      try {
         FileInputStream fis = this.openFileInput(cal.get(Calendar.YEAR)+"."+month);
         ObjectInputStream ois = new ObjectInputStream(fis);
         ArrayList<String> t = (ArrayList<String>)ois.readObject();
         mealArr = (ArrayList<String>) t.clone();         
         ois.close();
         mealTV.setText(mealArr.get(date-1));
      }
       catch (FileNotFoundException e) {
          throw e;
      } catch(IOException e) {
         e.printStackTrace();
      }
      catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
   }
   
   
   private void getDataFromServer() {      
       Thread thread=new Thread() {
         @Override
         public void run(){
            try {
               String urlMonth;
               if(month<10) {
                  urlMonth="0"+month;
                } else {
                   urlMonth=""+month;
                }
               source=new Source(new InputStreamReader(new URL(URL+urlMonth).openStream(),"UTF-8"));
               
             } catch(MalformedURLException e) {
                e.printStackTrace();
             } catch(IOException e) {
                e.printStackTrace();
             }
         }
      };
      thread.start();
      
      try {
         thread.join();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      List<Element> tr=source.getAllElements(HTMLElementName.TABLE).get(0).getAllElements(HTMLElementName.TR);
       mealArr=new ArrayList<String>();
       for(int i=0;i<tr.size();i++) {
          List<Element> tdList=tr.get(i).getAllElements(HTMLElementName.TD);
          for(int j=0;j<tdList.size();j++) {
             String toAdd=tdList.get(j).toString().replaceAll("<tr>", "")
                   .replaceAll("</tr>", "").replaceAll("<td>", "").replaceAll("</td>", "")
             .replaceAll("<br />", "\n").replace("[석식]", "\n[석식]")
             .trim();
             
             if(!toAdd.isEmpty()) {            	 
                if(toAdd.length()<5) {
                   toAdd="급식이 없습니다.";
                }
                int index=toAdd.indexOf("[");
                if(index==-1) {
                	index=0;
                }
                mealArr.add(toAdd.substring(index));
             }
          }
       }
      mealArr.add("");
      mealTV.setText(mealArr.get(date-1));
      
      try {
          FileOutputStream fos = openFileOutput(cal.get(Calendar.YEAR)+"."+month, Context.MODE_PRIVATE);
          ObjectOutputStream oos = new ObjectOutputStream(fos);
          oos.writeObject(mealArr);
          oos.close();
      } catch (IOException e) {
         e.printStackTrace();
       }
   }
}