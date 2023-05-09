import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * ClassName: zzz
 * Package: PACKAGE_NAME
 * Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        String s = scanner.next();

        int m = s.indexOf("+");
        String s1 = s.substring(0,m);
        String s2 = s.substring(m+1);
        String str1 = null;
        String str2 = null;
        if (s1.contains(".")){
            int num1 = s1.indexOf(".");
            str1 = s1.replace(".", "");
        }
        if (s2.contains(".")){
            int num2 = s1.indexOf(".");
            str2 = s2.replace(".","");
        }

        Deque queue1 = new LinkedList();
        Deque queue2 = new LinkedList();
        for (int i = str1.length() - 1; i >= 0; i--) {
            queue1.add(str1.charAt(i));
        }
        for (int i = str2.length() - 1; i >= 0; i--) {
            queue2.add(str2.charAt(i));
        }
        while (queue1.size() != queue2.size()){
            if (queue1.size() < queue2.size()){
                queue1.addFirst('0');
            }else {
                queue2.addFirst('0');
            }
        }
        int temp = 0;
        String s3 = "";
        int n = 0;
        while (!queue1.isEmpty() || !queue2.isEmpty()){
            Character poll1 = (Character) queue1.poll();
            Character poll2 = (Character) queue2.poll();
            int sum = 0;
            if (!Character.isDigit(poll1) && !Character.isDigit(poll2)){
                int count = jiSuan(poll1, poll2);
                n = count;
            }
            if (Character.isDigit(poll1) && Character.isDigit(poll2)){
                int num1 = Integer.parseInt(String.valueOf(poll1));
                int num2 = Integer.parseInt(String.valueOf(poll2));
                int x = poll1 == null ? 0 : num1;
                int y = poll2 == null ? 0 : num2;

                sum = x + y + n + temp;
                n = 0;
                temp = sum /10;
                sum = sum % 10;
                s3 =sum + s3;
                if (queue1.isEmpty() && queue2.isEmpty() && temp != 0){
                    s3 = temp + s3;
                }
            }
        }
        System.out.println(s3);
    }

    public static int jiSuan(char c1, char c2){
        if (c1 == '!'&& c2 == '!'){
            return 0;
        }
        else if ((c1 == '!'&& c2 == '@')||(c1 == '@'&& c2 == '!')){
            return 13;
        }
        else if ((c1 == '!'&& c2 == '#')||(c1 == '#'&& c2 == '!')){
            return 4;
        }
        else if (c1 == '@'&& c2 == '@'){
            return 7;
        }
        else if ((c1 == '@'&& c2 == '#')||(c1 == '#'&& c2 == '@')){
            return 20;
        }
        else if (c1 == '#'&& c2 == '#'){
            return 5;
        }
        else
            return 0;
    }
}
