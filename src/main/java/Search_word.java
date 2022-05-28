import java.util.ArrayList;
import java.util.Scanner;

public class Search_word {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String string_1 = in.nextLine();
        String string_2 = in.nextLine();
        ArrayList arrayList = new ArrayList<>();
        char c;
        int n;

        for (int i = 0; i < string_1.length(); i++){
            if (string_2.charAt(i) == string_1.charAt(i)){
                arrayList.add(i, "correct");
                string_1 = ChangeCharInPosition(i,'Й', string_1);
                string_2 = ChangeCharInPosition(i,'У', string_2);
            }
            else arrayList.add(i, "");
        }

        for (int i = 0; i < string_1.length(); i++){
            c = string_1.charAt(i);
            n = string_1.indexOf(string_2.charAt(i));
            if ((n == -1)&(c != 'Й')){
                arrayList.set(i, "absent");
            }
            else if ((n != i)&(n != -1)){
                string_1 = ChangeCharInPosition(n,'Й', string_1);
                arrayList.set(i, "present");
            }
        }

        for (int i = 0; i < arrayList.size();i++){
            if (arrayList.get(i) == "") System.out.println("absent");
            else System.out.println(arrayList.get(i));
        }
//        System.out.println(string_1);
//        System.out.println(string_2);

    }
    public static String ChangeCharInPosition(int position, char ch, String str){
        char[] charArray = str.toCharArray();
        charArray[position] = ch;
        return new String(charArray);
    }
}
