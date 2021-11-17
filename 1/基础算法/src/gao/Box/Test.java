package gao.Box;

import java.util.Scanner;

public class Test{
    public static void main(String[] args) {
        Box cube = new Box(3, 4, 5);
        System.out.println(cube.volumn());

        Box[] cubes = new Box[4];
        for (int i = 0;i < 4;i++){
            System.out.println("----------------第"+ (i+1) +"个----------------");
            cubes[i] = new Box();

            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入long");
            float v = scanner.nextFloat();
            cubes[i].setLength(v);

            System.out.println("请输入weight");
            v = scanner.nextFloat();
            cubes[i].setWeith(v);

            System.out.println("请输入height");
            v = scanner.nextFloat();
            cubes[i].setHeight(v);
        }

        for (int i = 0;i < 4;i++){
            System.out.println("-------第"+ (i+1) +"个-------");
            System.out.println(cubes[i].volumn());
        }
    }
}

class Box {
    private float length;
    private float weith;
    private float height;

    //无参构造
    public Box() {
    }

    //有参构造
    public Box(float length, float weith, float height) {
        //检验输入
        setBox(length, weith, height);
        this.length = length;
        this.weith = weith;
        this.height = height;
    }

    public void setLength(float length) {
        //每一次set都检验，下面两个同
        checklength(length);
        this.length = length;
    }

    public void setWeith(float weith) {
        checkweith(weith);
        this.weith = weith;
    }

    public void setHeight(float height) {
        checkheight(height);
        this.height = height;
    }

    private void setBox(float length, float weith, float height){
        //如输入有误，抛出运行时异常，下3个方法同
        if (length < 0 || weith < 0 || height < 0){
            throw new RuntimeException("您输入有误");
        }
    }

    private void checklength(float length){
        if (length < 0){
            throw new RuntimeException("long输入有误");
        }
    }

    private void checkweith(float weith){
        if (weith < 0){
            throw new RuntimeException("weith输入有误");
        }
    }

    private void checkheight(float height){
        if (height < 0){
            throw new RuntimeException("height输入有误");
        }
    }

    public float volumn(){
        return length * weith * height;
    }
}