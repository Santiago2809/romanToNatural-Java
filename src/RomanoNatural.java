import java.util.HashMap;
import java.util.Map;

public class RomanoNatural {
    public static void main(String[] args) {

        try {
            int res = romanToNatural("clviii");
            if(res == -1) {throw new Exception();}
            else {
                System.out.println(res);
            }
        } catch (Exception e){
            System.out.println("El numero romano no es valido");
        }
    }

    static int romanToNatural(String str) {

        if(str.length() == 0 ) return -1;
        int res = 0;
        if(str.toUpperCase().matches("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")){
            System.out.println("Es romano");
            String[] romanstr = str.toUpperCase().split("");
            Map<String, Integer> romanos = new HashMap<>();
            romanos.put("I",1);
            romanos.put("V",5);
            romanos.put("X",10);
            romanos.put("L",50);
            romanos.put("C",100);
            romanos.put("D",500);
            romanos.put("M",1000);
            int n = str.length();
            int i = n - 1;
            while (i >= 0 ){
                if(i < n-1 && romanos.get(romanstr[i]) < romanos.get(romanstr[i+1])){
                    res -= romanos.get(romanstr[i]);
                } else {
                    res += romanos.get(romanstr[i]);
                }
                i--;
            }
        } else {
            System.out.println("No es romano");
            res = -1;
        }
        return res;
    }
}
