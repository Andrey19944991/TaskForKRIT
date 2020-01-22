
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> m_values = new LinkedList<>();
        Map<Double,String> m_realVal = new LinkedHashMap<>();
        Map<String,String> m_calculated = new HashMap<>();
        Map<String,String> m_based = new HashMap<>();
        Map<String,String> m_result = new HashMap<>();
        Map<String,String> t_multiplication = new HashMap<>();
        Map<String,Integer> t_multiplicationVal = new HashMap<>();

        Map<String,String> t_convertation = new HashMap<>();
        Map<String,Double> t_convertationVal = new HashMap<>();


        t_multiplication.put("Gft3ng","ft3ng");
        t_multiplication.put("Gtce","tce");
        t_multiplication.put("Gtoe","toe");
        t_multiplication.put("MMbtu","btu");
        t_multiplication.put("Mj","j");
        t_multiplication.put("Kboe","boe");
        t_multiplication.put("Mtoe","toe");
        t_multiplication.put("Twh","wh");
        t_multiplication.put("Ktoe","toe");
        t_multiplication.put("Gj","j");
        t_multiplication.put("Mboe","boe");
        t_multiplication.put("Mtce","tce");
        t_multiplication.put("Gm3ng","m3ng");
        t_multiplication.put("Bboe","boe");
        t_multiplication.put("Qbtu","btu");
        t_multiplication.put("Mm3ng","m3ng");
        t_multiplication.put("Mft3ng","ft3ng");
        t_multiplication.put("Gwh","wh");

        t_multiplicationVal.put("Gft3ng",-9);
        t_multiplicationVal.put("Gtce",-9);
        t_multiplicationVal.put("Gtoe",-9);
        t_multiplicationVal.put("MMbtu",-6);
        t_multiplicationVal.put("Mj",-6);
        t_multiplicationVal.put("Kboe",-3);
        t_multiplicationVal.put("Mtoe",-6);
        t_multiplicationVal.put("Twh",-12);
        t_multiplicationVal.put("Ktoe",-3);
        t_multiplicationVal.put("Gj",-9);
        t_multiplicationVal.put("Mboe",-6);
        t_multiplicationVal.put("Mtce",-6);
        t_multiplicationVal.put("Gm3ng",-9);
        t_multiplicationVal.put("Bboe",-9);
        t_multiplicationVal.put("Qbtu",-15);
        t_multiplicationVal.put("Mm3ng",-6);
        t_multiplicationVal.put("Mft3ng",-6);
        t_multiplicationVal.put("Gwh",-9);





        t_convertation.put("Mtce","Mm3ng");
        t_convertation.put("Gft3ng","Twh");
        t_convertation.put("MMbtu","Mj");
        t_convertation.put("Bboe","Qbtu");
        t_convertation.put("Gtoe","Gtce");
        t_convertation.put("Gj","Gwh");
        t_convertation.put("Ktoe","Kboe");
        t_convertation.put("Gm3ng","Gft3ng");

        t_convertationVal.put("Mtce",751.4768963);
        t_convertationVal.put("Gft3ng",0.301277062);
        t_convertationVal.put("MMbtu",1055.060005);
        t_convertationVal.put("Bboe",0.58000001);
        t_convertationVal.put("Gtoe",1.4285714);
        t_convertationVal.put("Gj",0.000277778);
        t_convertationVal.put("Ktoe",6.8419054);
        t_convertationVal.put("Gm3ng",35.958043);

        m_values.add("Mtoe");
        m_realVal.put(148.67,"Mtoe");


        Set<String> temp = new HashSet<>();

        changeTables(m_calculated,m_based,m_result,m_values,t_multiplication,t_convertation);
        System.out.println("m_values "+m_values);
        System.out.println("real val" + m_realVal);
        System.out.println("calc " + m_calculated );
        System.out.println("based "+m_based);
        System.out.println("res "+m_result);

        int iter =0;

        while (m_calculated.size()!=0 || m_based.size()!=0 || m_result.size()!=0){
            if (m_calculated.size()!=0){
                for (String val: m_values) {
                    for (Map.Entry<String,String> entry: m_calculated.entrySet()){
                        if (val.equals(entry.getValue())){
                            temp.add(entry.getKey());
                            double var = 0.0;
                            for (Map.Entry<Double,String> entry1: m_realVal.entrySet()){
                                if (entry1.getValue().equals(entry.getValue())){
                                    var = entry1.getKey();
                                }
                            }
                            m_realVal.put( var*Math.pow(10.0,t_multiplicationVal.get(entry.getKey())),entry.getKey());
                        }
                    }
                }
                for (String string:temp) {
                    m_values.add(string);
                }
                temp.clear();
            }

            if (m_based.size()!=0){
                for (String val: m_values) {
                    for (Map.Entry<String,String> entry: m_based.entrySet()){
                        if (val.equals(entry.getKey())){
                            temp.add(entry.getValue());
                            double var = 0.0;
                            for (Map.Entry<Double,String> entry1: m_realVal.entrySet()){
                                if (entry1.getValue().equals(entry.getKey())){
                                    var = entry1.getKey();
                                }
                            }
                            m_realVal.put( var*Math.pow(10.0,-t_multiplicationVal.get(entry.getKey())),entry.getValue());
                        }
                    }
                }
                for (String string:temp) {
                    m_values.add(string);
                }
                temp.clear();
            }
            if (m_result.size()!=0){
                for (String val: m_values) {
                    for (Map.Entry<String,String> entry: m_result.entrySet()){
                        if (val.equals(entry.getKey())){
                            temp.add(entry.getValue());
                            double var = 0.0;
                            for (Map.Entry<Double,String> entry1: m_realVal.entrySet()){
                                if (entry1.getValue().equals(entry.getKey())){
                                    var = entry1.getKey();
                                }
                            }
                            m_realVal.put( var * t_convertationVal.get(entry.getKey()),entry.getValue());
                        }
                    }
                }
                for (String string:temp) {
                    m_values.add(string);
                }
                temp.clear();
            }
            System.out.println("iteration № "+iter+" finished");

            iter++;
            System.out.println("______________");

            System.out.println("m_values "+m_values);
            System.out.println("real val" + m_realVal);

            changeTables(m_calculated,m_based,m_result,m_values,t_multiplication,t_convertation);
            System.out.println("calc " + m_calculated );
            System.out.println("based "+m_based);
            System.out.println("res "+m_result);

        }
        System.out.println("finish");

    }

    public static void changeTables(Map<String,String> m_calc, Map<String,String> m_based, Map<String,String> m_res,
                                    List<String> val, Map<String,String> t_multipl, Map<String,String> t_conv){
        m_calc.clear();
        m_based.clear();
        m_res.clear();
        for(Map.Entry<String,String> entry: t_multipl.entrySet()){
            boolean rasch=true;
            boolean bazov=true;
            for (String value:val) {
                if (entry.getKey().equals(value)){
                    rasch=false;
                }
            }
            for (String value:val) {
                if (entry.getValue().equals(value)){
                    bazov=false;
                }
            }
            for (String value: val) {
                if (entry.getValue().equals(value) && rasch==true) {
                    m_calc.put(entry.getKey(),entry.getValue());
                }
                if(entry.getKey().equals(value)&& bazov==true){
                    m_based.put(entry.getKey(),entry.getValue());
                }
            }
        }
        for (Map.Entry<String,String> entry: t_conv.entrySet()){
            boolean result=true;
            for (String value:val) {
                if (entry.getValue().equals(value)){
                    result=false;
                }
            }
            for (String value: val) {
                if (entry.getKey().equals(value) && result==true){
                    m_res.put(entry.getKey(),entry.getValue());
                }
            }
        }
    }


}

