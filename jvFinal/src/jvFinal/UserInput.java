package jvFinal;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class UserInput{
    private JTextArea jt;
    private JPanel jp;
    private GridBagConstraints constraints;
    public UserInput(GridBagConstraints constraints)
    {
        this.jt = new JTextArea();
        this.jp=new JPanel();
        this.constraints=constraints;
        init(constraints);
    }
    public void init(GridBagConstraints constraints)
    {
        TitledBorder border = new TitledBorder("User Input");
        border.setTitleJustification(TitledBorder.CENTER);//設定標題位置(置中);
        border.setTitleFont(new Font("Arial", Font.BOLD, 20));//設定標題字體
        jp.setBorder(border);
        //----------------------------------------------------------------------文字框+滾輪//
        //JTextArea jt = new JTextArea();
        jt.setLineWrap(true);//自動換行
        jt.setFont(new Font("", Font.PLAIN, 20));//設定字體
        jt.setBackground(Color.YELLOW);
        JScrollPane js = new JScrollPane(jt);//滾輪
        //----------------------------------------------------------------------按鈕//
        JButton btn = new JButton("SEND");
        btn.setFont(new Font("Arial", Font.BOLD, 20));//設定按鈕字體
        //設定按鈕點擊事件
        btn.addActionListener(e ->
        {
            buttonClick();
        });
        //----------------------------------------------------------------------小的區域//
        jp.add(js);//把JScrollPane物件加到JPanel中
        jp.add(btn);//把JButton物件加到JPanel中
        GridBagLayout layoutP = new GridBagLayout();
        jp.setLayout(layoutP);
        GridBagConstraints constraintsP= new GridBagConstraints();
        constraintsP.fill = GridBagConstraints.BOTH;//BOTH是把空間填滿//把小的空間填滿
        //----------------------------------------------------------------------
        constraintsP.gridx = 1;//X軸座標
        constraintsP.gridy = 1;//Y軸座標
        constraintsP.gridwidth = 0;//照順序從左到右(數字不重要，但是0為最後一個)
        constraintsP.gridheight=1;//照順序從上到下(數字不重要，但是0為最後一個)
        constraintsP.weightx = 1;//佔區域寬度的權重(比例)
        constraintsP.weighty = 15;//佔區域高度的權重(比例)
        layoutP.setConstraints(js,constraintsP);//把小的區域(JScrollPane)的位置設定輸入

        constraintsP.gridx = 1;//X軸座標
        constraintsP.gridy = 2;//Y軸座標
        constraintsP.gridwidth = 0;//照順序從左到右(數字不重要，但是0為最後一個)
        constraintsP.gridheight=0;//照順序從上到下(數字不重要，但是0為最後一個)
        constraintsP.weightx = 1;//佔區域寬度的權重(比例)
        constraintsP.weighty = 1;//佔區域高度的權重(比例)
        layoutP.setConstraints(btn,constraintsP);//把小的區域(JButton)的位置設定輸入

        //---------------------------------------------------------------------大的區域//
        constraints.fill = GridBagConstraints.BOTH;//BOTH是把空間填滿//把大的空間填滿
        constraints.gridx = 2;//X軸座標
        constraints.gridy = 2;//Y軸座標
        constraints.gridwidth = 0;//照順序從左到右(數字不重要，但是0為最後一個)
        constraints.gridheight= 1;//照順序從上到下(數字不重要，但是0為最後一個)
        constraints.weightx = 3;//佔區域寬度的權重(比例)
        constraints.weighty = 1;//佔區域高度的權重(比例)
    }
    public JTextArea getJt()//取得JTextArea
    {
        return jt;
    }
    public JPanel getJp()//取得JPanel
    {
        return jp;
    }
    public GridBagConstraints getConstraints()//取得GridBagConstraints
    {
        return constraints;
    }
    public void buttonClick()//按鈕點擊後的動作
    {
        String text = this.jt.getText();//取得輸入框中的文字
        MainClass mainClass = new MainClass();
        Seg result = new Seg();
        try{
        	 mainClass.userFootprintViaNLPParser.getJt().setText(result.posStr(text));
		}
		catch(Exception e){
			System.out.print("error");
		}	
       
    }

}
