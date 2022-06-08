import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

public class BAC {
    public static void main(String[] args) {
        //生成随机数
        Random r = new Random();
        int num = r.nextInt(100)+1;
        //导入gui界面
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "电脑随机生成了一个随机数，请猜出这个数", "猜数字游戏", JOptionPane.PLAIN_MESSAGE);
        String Name1 = (String) JOptionPane.showInputDialog(null, "请输入您的大名：", "猜数字游戏", JOptionPane.PLAIN_MESSAGE, null, null, "");
        long startTime = System.currentTimeMillis();
        Date TstarTime = new Date(startTime);
        //设置日期格式
        TimeZone timeZoneChina = TimeZone.getTimeZone("Asia/Beijing");
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
        //开始时间
        String retStrFormatNowDate = sdFormatter.format(TstarTime);
        JOptionPane.showMessageDialog(null, "现在游戏开始！开始时间是"+ retStrFormatNowDate, "猜数字游戏", JOptionPane.PLAIN_MESSAGE);
        while(true){
            //输入数字
            String Snum1 = (String) JOptionPane.showInputDialog(null, "请输入想猜的数：", "猜数字游戏", JOptionPane.PLAIN_MESSAGE, null, null, "");
            int Snum = Integer.parseInt(Snum1); //输入的字符串进行强制转换
            //结束时间和使用多久的时间
            long completeTime1 = System.currentTimeMillis();
            Date TstarTime1 = new Date(completeTime1);
            String retStrFormatNowDate1 = sdFormatter.format(TstarTime1);
            long tcompleteTime = completeTime1 - startTime;

            //判断语句判断是否符合条件
            if(Snum<num){
                //提示评语
                JOptionPane.showMessageDialog(null, "猜的太小了，往大点猜猜。", "猜数字游戏", JOptionPane.PLAIN_MESSAGE);
                //时间
                JOptionPane.showMessageDialog(null, "耗费时间 : " + tcompleteTime / 1000 + "秒", "猜数字游戏", JOptionPane.PLAIN_MESSAGE);
            }else if(Snum>num){
                //提示评语
                JOptionPane.showMessageDialog(null, "猜的太大了，往小点猜猜。", "猜数字游戏", JOptionPane.PLAIN_MESSAGE);
                //时间
                JOptionPane.showMessageDialog(null, "耗费时间 : " + tcompleteTime / 1000 + "秒", "猜数字游戏", JOptionPane.PLAIN_MESSAGE);
            }else if(Snum==num){
                //提示评语
                JOptionPane.showMessageDialog(null, "恭喜您猜对了！", "猜数字游戏", JOptionPane.PLAIN_MESSAGE);
                //时间
                JOptionPane.showMessageDialog(null, "耗费时间 : " + tcompleteTime / 1000 + "秒", "猜数字游戏", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "结束时间 : " +retStrFormatNowDate1, "猜数字游戏", JOptionPane.PLAIN_MESSAGE);
                try {

                    File file = new File("D:\\data.txt");       //将文件保存到D盘data.txt

                    if(!file.exists()) {

                        file.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖

                    }

                    FileOutputStream fos = new FileOutputStream(file,true);

                    OutputStreamWriter osw = new OutputStreamWriter(fos);

                    BufferedWriter bw = new BufferedWriter(osw);

                    bw.write("玩家名称:" + Name1 +", 通关日期:" + retStrFormatNowDate1 +", 累计用时:" +
                            tcompleteTime / 1000 +"秒");

                    bw.newLine();

                    bw.flush();

                    bw.close();

                    osw.close();

                    fos.close();

                }catch (FileNotFoundException e1) {

                    e1.printStackTrace();

                } catch (IOException e2) {

                    e2.printStackTrace();

                }

                break;
            }else{
                JOptionPane.showMessageDialog(null, "请输入正确的数值", "猜数字游戏", JOptionPane.PLAIN_MESSAGE);
            }
        }
        System.out.println("");
    }
}
