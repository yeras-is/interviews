package defult;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * Find the difference between 2 dates in days
 */
public class DateDifference {

   public static void main(String[] args) throws InterruptedException {
      TimeUnit unit = TimeUnit.SECONDS;
      Date date = new Date(2019, Calendar.AUGUST, 5);
      System.out.println(getDateDiff(date,new Date(2019,Calendar.AUGUST,9),TimeUnit.DAYS));
   }



   /**
    * get difference between 2 dates, TimeUnit is enum;
    * java.util.concurrent.TimeUnit
    * */
   public static long getDateDiff(Date start, Date end, TimeUnit unit){
      long diffrenceMills = end.getTime()- start.getTime();
      return unit.convert(diffrenceMills,TimeUnit.MILLISECONDS);
   }

}
