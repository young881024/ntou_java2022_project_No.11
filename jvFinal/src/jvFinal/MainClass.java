package jvFinal;

import javax.management.remote.JMXServiceURL;
import javax.swing.*;
import java.awt.*;


public class MainClass {
    static GoogleMap googleMap;
    static Covid19FootprintDatabase covid19FootprintDatabase;
    static UserInput userInput;
    static UserFootprintViaNLPParser userFootprintViaNLPParser;

    public static void main(String args[]) {
        JFrame window = new JFrame("COVID-19 Footprint Checker"); //建立標題名
        window.setBounds(300,50,800,800);// 顯示X軸位置,顯示Y軸位置 ,寬,長
        window.setVisible(true); // 視窗預設是不可見的
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);//設定單擊窗體右上角關閉圖示後，程式會做出怎樣的處理。
        //----------------------------------------------------------------------------------------------------------------------------
        GridBagLayout layout = new GridBagLayout();//整個頁面的位置編排
        window.setLayout(layout);//把整個頁面的設定設為layout
        GridBagConstraints constraints= new GridBagConstraints();//紀錄位置設定的物件
        //----------------------------------------------------------------------------------------------------------------------------
        googleMap = new GoogleMap(constraints);
        layout.setConstraints(googleMap.getJp(),googleMap.getConstraints());//把大的區域(JPanel)的位置設定輸入
        window.add(googleMap.getJp());//把設定好的JPanel區域加到整個視窗

        covid19FootprintDatabase = new Covid19FootprintDatabase(constraints);
        layout.setConstraints(covid19FootprintDatabase.getJp(),covid19FootprintDatabase.getConstraints());//把大的區域(JPanel)的位置設定輸入
        window.add(covid19FootprintDatabase.getJp());//把設定好的JPanel區域加到整個視窗

        userInput = new UserInput(constraints);
        layout.setConstraints(userInput.getJp(),userInput.getConstraints());//把大的區域(JPanel)的位置設定輸入
        window.add(userInput.getJp());//把設定好的JPanel區域加到整個視窗

        userFootprintViaNLPParser = new UserFootprintViaNLPParser(constraints);
        layout.setConstraints(userFootprintViaNLPParser.getJp(),userFootprintViaNLPParser.getConstraints());//把大的區域(JPanel)的位置設定輸入
        window.add(userFootprintViaNLPParser.getJp());//把設定好的JPanel區域加到整個視窗
        //----------------------------------------------------------------------------------------------------------------------------


    }

}