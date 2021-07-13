package com.hp.Service;

import com.hp.test.Customer;
import com.hp.test.CustomerData;
import com.hp.util.TextUtil;
import com.sun.istack.internal.NotNull;

import java.util.List;
import java.util.Scanner;

//此类是 完成 客户的 所有业务（增删改查）
public class CustomerService {
    //CustomerData customerData = CustomerData.getInstance();
    //List<Customer> customerList = customerData.getCustomerList();
    private List<Customer> customerList;
    private Customer currentCustomer;

    //1.查，登录 判断账号密码是否正确
    public void checkPwd(String cardid,String cardPwd){
        CustomerData customerData = CustomerData.getInstance();
        customerList = customerData.getCustomerList();
        //1.拿到 cardid中的账户名 和 cardPwd 对 list中的数据做对比
        System.out.println("cardid = " + cardid);
        System.out.println("cardPwd = " + cardPwd);

        for (Customer customer : customerList) {
            if (customer.getAccount().equals(cardid) && customer.getPassword().equals(cardPwd)){
                //拿出来这个人
                currentCustomer = customer;
                //账户正确
                System.out.println("欢迎"+customer.getCname()+"客户的账户密码正确");
                TextUtil.oneLeveOption();//界面
                Scanner scanner = new Scanner(System.in);
                String option = scanner.nextLine();
                option(option);
                //如何 保证换了1 3 5 ... 让他再次回到此界面呢？
                

            }
        }
    }

    private void option(@NotNull String option) {
        switch (option){
            case "1":
                System.out.println("余额查询");
                    //查询余额
                    doSelectMoney();
                    //当按下1之后，回退到1及选项
                goOneHome();
                break;
            case "2":
                //System.out.println("取款");
                goGetMoneyHome();
                goOneHome();
                break;
            case "3":
                //System.out.println("转账");
                doTruanMoney();
                goOneHome();
                break;
            case "4":
                //System.out.println("存款");
                doSaveMoney();
                goOneHome();
                break;
            case "5":
                //System.out.println("退卡");
                doQuitCard();
                goOneHome();
                break;
        }
    }

    //返回一级目录
    private void goOneHome(){
        TextUtil.oneLeveOption();
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        System.out.println("option1 = " + option);
        option(option);//递归算法
    }

    //余额查询
    private void doSelectMoney() {
        double money = currentCustomer.getMoney();
        System.out.println("余额是 " + money);
    }


    //取款
    private void goGetMoneyHome(){
        TextUtil.getMoneyUI();
        //1.让客户输入
        Scanner scanner = new Scanner(System.in);
        String moneyIn = scanner.nextLine();
        if (moneyIn.equals("1")) {
            //那么  取款100 那么就应该让顾客的钱减100
            double money = currentCustomer.getMoney();
            money=money-100;
            System.out.println("您的余额是 = " + money);
            //取完款项之后，更新原有的 存款
            currentCustomer.getMoney();
        }else if(moneyIn.equals("2")){
            //那么 取款200 那么就应该 让顾客的钱减200
            double money = currentCustomer.getMoney();
            money = money - 200;
            System.out.println("你的余额是:" + money);
            //取完款后，更新原有存款
            currentCustomer.setMoney(money);
        }else if(moneyIn.equals("3")){
            //那么 取款300 那么就应该 让顾客的钱减200
            double money = currentCustomer.getMoney();
            money = money - 300;
            System.out.println("你的余额是:" + money);
            //取完款后，更新原有存款
            currentCustomer.setMoney(money);
        }else if(moneyIn.equals("4")){
            //那么 取款400 那么就应该 让顾客的钱减200
            double money = currentCustomer.getMoney();
            money = money - 400;
            System.out.println("你的余额是:" + money);
            //取完款后，更新原有存款
            currentCustomer.setMoney(money);
        }else if(moneyIn.equals("5")){
            //那么 取款800 那么就应该 让顾客的钱减200
            double money = currentCustomer.getMoney();
            money = money - 800;
            System.out.println("你的余额是:" + money);
            //取完款后，更新原有存款
            currentCustomer.setMoney(money);
        }else if(moneyIn.equals("6")){
            //那么 取款1000 那么就应该 让顾客的钱减200
            double money = currentCustomer.getMoney();
            money = money - 1000;
            System.out.println("你的余额是:" + money);
            //取完款后，更新原有存款
            currentCustomer.setMoney(money);
        }else if(moneyIn.equals("7")){
            //那么 取款2000 那么就应该 让顾客的钱减200
            double money = currentCustomer.getMoney();
            money = money - 2000;
            System.out.println("你的余额是:" + money);
            //取完款后，更新原有存款
            currentCustomer.setMoney(money);
        }else if (moneyIn.equals("8")) {
            // 那么 取款100 那么就应该 让 顾客的 钱 -100
            double money = scanner.nextDouble();
            if (money <= currentCustomer.getMoney()) {


                if ((money % 100) == 0) {
                    money = currentCustomer.getMoney() - money;
                    currentCustomer.setMoney(money);
                    System.out.println("取款成功！ 您的余额是: " + currentCustomer.getMoney());


                } else {
                    System.out.println("取款失败 ， 请输入100或100的倍数");
                }
            }else{
                System.out.println("余额不足。");
            }
        }


    }
    //转账
    private void doTruanMoney() {
        System.out.println("请输入对方的账号");
        Scanner scanner = new Scanner(System.in);
        String otherAccount = scanner.nextLine();
        System.out.println("请输入您需要转账的金额");
        String otherMoney = scanner.nextLine();
        //做计算.     自己的钱-otherMoney， 别人的钱+otherMoney
        //自己 减钱
        Double otherMoneyInt = Double.parseDouble(otherMoney);
        double currentMoney = currentCustomer.getMoney() - otherMoneyInt;
        //别人 加钱，根据 otherAccount 本人的账户查询 别人的余额查出别人的余额后，修改别人的余额
        //因为所以人都在customerList 都在这个集合中，那么遍历这个集合
        Customer other = null;
        for (Customer customer : customerList) {
            //如果customer.getAcount 等于otherAccount那么这个人就被选出来了
            if (customer.getAccount().equals(otherAccount)) {
                other = customer;
            }
        }
        double otheroneMoney = other.getMoney()+ otherMoneyInt;
        //自己和别人 都更新一下 钱数
        currentCustomer.setMoney(currentMoney);
        other.setMoney(otheroneMoney);//注意： 有问题？ 不能够 创建  对象了

        for (Customer customer : customerList) {
            System.out.println("customer = " + customer);
        }
    }
    //存款
    private void doSaveMoney(){
       /*
        //1.有个提示界面
        System.out.println("请输入您需要存入的金额");
        //2.scanner接收钱数
        Scanner scanner = new Scanner(System.in);
        String moneyIn = scanner.nextLine();
        Double moneyInInt =Double.valueOf(moneyIn);
        double newMoney = currentCustomer.getMoney() + moneyInInt;//ctrl + alt + v 快速返回数据类型
        //3.更新当前用户的余额
        currentCustomer.setMoney(newMoney);
        System.out.println("您的余额是 =" + newMoney);*/
        TextUtil.getMoneyUI();
        //1.让客户输入
        System.out.println("请输入您需要存入的金额");
        Scanner scanner = new Scanner(System.in);
        String moneyIn = scanner.nextLine();
        Double moneyInInt =Double.valueOf(moneyIn);
        if ((moneyInInt %100) == 0 ) {

            double newMoney = currentCustomer.getMoney()+moneyInInt;
            currentCustomer.setMoney(newMoney);
            System.out.println(" 存入成功！ 您账户的余额是：" + newMoney);
        }else {
            System.out.println("存入的金额不能小于100，存入金额失败");
        }
    }

    private void doQuitCard(){
        System.out.println("您是否继续操作yes/no[Y/N]");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.equalsIgnoreCase("y")) {
            TextUtil.welcome();//结束掉
        }
        if (s.equalsIgnoreCase("n")) {
            TextUtil.welcome();
        }
    }
}
