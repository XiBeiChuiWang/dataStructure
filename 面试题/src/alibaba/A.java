package alibaba;

import java.io.*;
import java.util.Properties;

public class A {

    public static void main(String[] args) {
        SimpleFactory.newInstance(0.0).call(60);
    }
}

interface Call{
    public Double call(int second);
}

class Day implements Call{
    private static Properties properties;

    private static double DAY_MONEY_60;
    private static double DAY_MONEY_61_END;

    private static volatile Day day;

    private Day(){}

    public static Day getInstance(){
        if (day == null){
            synchronized (Night.class){
                if (day == null){
                    day = new Day();
                }
            }
        }
        return day;
    }

    static {
        try {
            properties.load(new FileInputStream(new File("")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        DAY_MONEY_60 = Double.parseDouble(properties.getProperty("DAY_MONEY_60"));
        DAY_MONEY_61_END = Double.parseDouble(properties.getProperty("DAY_MONEY_61_END"));
    }

    @Override
    public Double call(int second) {
        if (second == 0) return 0.0;

        double money = DAY_MONEY_60;

        if (second > 60){
            money = money + second / 60 * DAY_MONEY_61_END;
        }

        return money;
    }
}

class Night implements Call{
    private static Properties properties;

    private static double NIGHT_MONEY_60 ;
    private static double NIGHT_MONEY_61_6000;
    private static double NIGHT_MONEY_6001_END;

    private static volatile Night night;
    private Night(){}
    static {
        try {
            properties.load(new FileInputStream(new File("")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        NIGHT_MONEY_60 = Double.parseDouble(properties.getProperty("NIGHT_MONEY_60"));
        NIGHT_MONEY_61_6000 = Double.parseDouble(properties.getProperty("NIGHT_MONEY_61_6000"));
        NIGHT_MONEY_6001_END = Double.parseDouble(properties.getProperty("NIGHT_MONEY_6001_END"));
    }

    public static Night getInstance(){
        if (night == null){
            synchronized (Night.class){
                if (night == null){
                    night = new Night();
                }
            }
        }
        return night;
    }

    @Override
    public Double call(int second) {

        if (second == 0) return 0.0;

        double money = NIGHT_MONEY_60;

        if (second > 60){
            money = money + NIGHT_MONEY_61_6000;
        }
        if (second > 6000){
            money = money + NIGHT_MONEY_6001_END * (second - 6000)/60;
        }

        return money;
    }
}

class SimpleFactory {
    private static double DAY_BEGIN;
    private static double DAY_END;
    private static double NIGHT_BEGIN;
    private static double NIGHT_END;
    private static Properties properties;
    static {
        try {
            properties.load(new FileInputStream(new File("")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        DAY_BEGIN = Double.parseDouble(properties.getProperty("DAY_BEGIN"));
        DAY_END = Double.parseDouble(properties.getProperty("DAY_END"));
        NIGHT_BEGIN = Double.parseDouble(properties.getProperty("NIGHT_BEGIN"));
        NIGHT_END = Double.parseDouble(properties.getProperty("NIGHT_END"));
    }

    public static Call newInstance(double date){
        if (date >= DAY_BEGIN && date <= DAY_END){
            return Day.getInstance();
        }else {
            return Night.getInstance();
        }
    }

}

