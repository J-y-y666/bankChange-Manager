package exams;
//零钱通 面向对象方法求解

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class smallchangeOOP {
    boolean loop = true;
    Scanner sc = new Scanner(System.in);
    double money = 0;
    double bouns = 0;

    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm");
    //时间格式化yyyy-MM-dd HH:mm
    String choice = "";
    String details = "";
    String note = "";
    String nod = "";

    public void mainDetial() {
        do {
            System.out.println("===========零钱通项目============");
            System.out.println("1,零钱通菜单");
            System.out.println("2,入账收益");
            System.out.println("3，消费");
            System.out.println("4，退出");
            System.out.println("请选择（1-4）:");
            choice = sc.next();
            switch (choice) {
                case "1":
                    this.menu();
                    break;

                case "2":
                    this.entry();
                    break;


                case "3":
                    this.pay();
                    break;


                case "4":
                    this.exit();
                    break;


                default:

                    System.out.println("输入有错误");
            }
        }
        while (loop);

    }
    public void menu() {
        System.out.println(details);
    }

    public void entry() {
        System.out.println("收益入账金额：");
        money = sc.nextInt();
        if (money <= 0) {
            System.out.println("收益要大于零");
            return;
        }

        bouns = money + bouns;

        details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + bouns;

    }

    public void pay() {
        System.out.println("消费金额：");
        money = sc.nextInt();
        if (money > bouns || money <= 0) {
            System.out.println("消费要在0-" + bouns);
            return;
        }
        System.out.println("消费说明：");
        note = sc.next();

        bouns = bouns - money;
        details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + bouns;

    }

    public void exit() {
        while (true) {
            System.out.println("确定退出吗？ 输入y/n");
            nod = sc.next();
            if ("y".equals(nod) || "n".equals(nod)) {
                break;
            }
        }
        if ("y".equals(nod)) {
            loop = false;


        }
    }
}
