package javat.eightid;

import cn.song.cdgenerics.Source;
import com.sun.javafx.binding.StringFormatter;

import java.text.DecimalFormat;

/**
 * Created by songzhw on 1/24/16.
 *
 * We have to generate some id which is 8 numbers to the customers.
 * We do not have too many customer(less than 100,000),
 * and we need to verify the id is not faked.
 *
 * What can we do?
 * : 1. generate a 6-number digits, save it into the database
 *   2. generate two redundancy check code
 */
public class EightIdTest {

    public static void main(String[] args) {
        EightIdTest test = new EightIdTest();

        String id = test.generateId();
        System.out.println("id = "+id);

        System.out.println("valid? = "+test.checkId("00000132"));
    }

    public String generateId(){
        String raw6 = "999999";
        String rc = generateRc(raw6);
        return raw6+rc;
    }

    private String generateRc(String raw6){
        String[] split = raw6.split("");
        int[] intArray = new int[split.length - 1];
        int i = 0;
        for(String item : split){
            if(item != null && !item.equals("")) {
                intArray[i] = Integer.parseInt(item);
                i++;
            }
        }

        int sum = 0;
        for(int item : intArray){
            sum += item;
        }

        sum = sum % 100;
        return new DecimalFormat("00").format(sum);
    }

    public boolean checkId(String id){
        String[] split = id.split("");
        int[] intArray = new int[split.length - 1];
        int i = 0;
        for(String item : split){
            if(item != null && !item.equals("")) {
                intArray[i] = Integer.parseInt(item);
                i++;
            }
        }

        String raw6 = "";
        for(int index = 0; index < 6; index++){
            raw6 = raw6 + intArray[index];
        }

        String origRc = ""+intArray[6]+intArray[7];
        String genRc = generateRc(raw6);
        return origRc.equals(genRc);


    }


}
