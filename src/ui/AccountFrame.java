package ui;

import javax.accessibility.AccessibleContext;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountFrame extends JFrame{
    //上部放置查询相关组件的面板
    private JPanel PanelSearch=new JPanel();
    //下部提供add,del,modify操作的面板
    private JPanel panelProcess=new JPanel();
    //搜索框
    private  JTextField txtSearch=new JTextField();
    ////搜索按钮
    private  JButton btnSearch=new JButton("Search");
    private JLabel labView=new JLabel("看我啊");
    //添加功能所使用的面板，包含很多组件
    private JPanel panelAdd=new JPanel();

    private JLabel labAddAcount=new JLabel("账号：");
    private JTextField txtAddAcount=new JTextField("");

    private JLabel labAddPassword=new JLabel("密码");
    private JTextField txtAddPassword=new JTextField();

    private JLabel labAddnumber=new JLabel("电话号码");
    private JTextField txtAddnumber=new JTextField();

    private JLabel labAddemailbox=new JLabel("邮箱");
    private JTextField txtAddemailbox=new JTextField();

    private JButton btnAdd=new JButton("Add");
    private JButton btnDelete=new JButton("Delete");
    private JButton btnModify=new JButton("Modify");

    public AccountFrame(){
    //======初始化组件======
    //PanelSearch.setBackground(Color.BLUE);
    //panelProcess.setBackground(Color.RED);

        PanelSearch.setLayout(new BorderLayout());//设置布局
        PanelSearch.add(txtSearch);//添加搜索框到中间部分
        PanelSearch.add(btnSearch,BorderLayout.EAST);//添加搜索按钮到右边
        //=====初始化panelAdd面板组件=====
        panelAdd.setLayout(new GridLayout(4,2));
        panelAdd.add(labAddAcount);
        panelAdd.add(txtAddAcount);
        panelAdd.add(labAddPassword);
        panelAdd.add(txtAddPassword);
        panelAdd.add(labAddnumber);
        panelAdd.add(txtAddnumber);
        panelAdd.add(labAddemailbox);
        panelAdd.add(txtAddemailbox);

        // panelAdd.setVisible(false);
        //初始化底部面板
        panelProcess.add(btnAdd);
        panelProcess.add(btnDelete);
        panelProcess.add(btnModify);

        this.add(PanelSearch,BorderLayout.NORTH);//添加搜索面板到上方
        this.add(panelProcess,BorderLayout.SOUTH);//添加操作面板到下方
        //this.add(panelAdd);
        this.add(labView);

        //添加事件处理
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //1.拿到文本的text内容，根据这个内容决定逻辑
                String text = btnAdd.getText();

                if (text.equals("Add")) {
                    //进入添加记录的操作

                    //移除LabView组件
                    AccountFrame.this.remove(labView);
                    //添加panel到中间
                    AccountFrame.this.add(panelAdd);
                    btnDelete.setText("cancel");
                    btnModify.setVisible(false);
                    text = "save";
                } else {
                    //还原回初始的状态
                    text = "Add";
                    AccountFrame.this.remove(panelAdd);
                    labView.setText("保存成功！！！");
                    AccountFrame.this.add(labView);
                    btnDelete.setText("delete");
                    btnModify.setVisible(true);
                }
                btnAdd.setText(text);
                //类似于页面刷新重绘
                AccountFrame.this.setVisible(false);
                AccountFrame.this.setVisible(true);
            }
        });
      //设定窗体相关属性
        this.setSize(800,600);
        this.setTitle("账户首页");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value=txtSearch.getText();
                labView.setText(value);
            }
        });
        this.setSize(800,600);
        this.setTitle("账号首页");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
    public static void main(String...args){
        new AccountFrame();
    }
}
