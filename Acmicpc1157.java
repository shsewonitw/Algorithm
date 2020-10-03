
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Acmicpc1157 {

    public String solution(String inputStr){
        String result = "";

        result = inputStr.toUpperCase();

        HashMap<Character, Integer> checkMap = new HashMap<>();

        char[] charArry = result.toCharArray();
        Integer maxCount = -999;

        for(char ch : charArry){
            Integer keyCount = checkMap.get(ch);

            if(keyCount == null){
                keyCount = 1;
            } else{
                keyCount++;
            }

            if(keyCount >= maxCount){
                maxCount = keyCount;
            }

            checkMap.put(ch,keyCount);
        }

        Iterator<Character> iter = checkMap.keySet().iterator();

        while (iter.hasNext()) {

            Character key = iter.next();
            Integer value = checkMap.get(key);
            if( value < maxCount ){
//                checkMap.remove(key);
                iter.remove();
            }
        }


        if(checkMap.size() > 1){
            result = "?";
        } else if(checkMap.size() == 1) {
            for(Character key : checkMap.keySet()){
                result = key.toString();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String result = "";

        Acmicpc1157 acmicpc1157 = new Acmicpc1157();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = "";
        try {
            inputStr = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        result = acmicpc1157.solution(inputStr);

        System.out.print(result);
    }

}