package view;

import utils.DBUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 用户修改自己登录的界面
 * 
 * @author 何兴旺
 *
 */
public class UserXiugaimima extends JFrame {
	private JLabel jLabel1 = new JLabel("原  密  码：");
	private JLabel jLabel2 = new JLabel("新  密  码：");
	private JLabel jLabel3 = new JLabel("重复输入：");
	private JLabel JLabel4 = new JLabel("修  改  密  码");
	private JPasswordField JP1 = new JPasswordField();
	private JPasswordField JP2 = new JPasswordField();
	private JPasswordField JP3 = new JPasswordField();
	private JPanel panLab = new JPanel();
	private JPanel panBtn = new JPanel();
	private JButton jButton1 = new JButton("确 定");
	private JButton jButton2 = new JButton("重 置");

	public UserXiugaimima() {
		setTitle("修改密码_用户");
		setSize(350, 250);
		setResizable(false); // 不可改变窗口大小
		// 获取屏幕大小和当前frame的大小
		Dimension thisScreen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension thisFrame = this.getSize();
		// 使启动窗口位于屏幕的正中心
		setLocation((thisScreen.width - thisFrame.width) / 2,
				(thisScreen.height - thisFrame.height) / 2);
		// 设置单击窗口的【关闭】按钮时将发生相应的动作
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		JLabel4.setFont(new Font("宋体", 0, 24));
		JLabel4.setHorizontalAlignment(JLabel.CENTER);
		JLabel4.setForeground(new Color(255, 51, 51));

		jLabel1.setSize(100, 100);
		jLabel1.setLocation(50, 5);
		jLabel1.setHorizontalAlignment(JLabel.RIGHT);
		JP1.setSize(150, 30);
		JP1.setLocation(160, 40);

		jLabel2.setSize(100, 100);
		jLabel2.setLocation(15, 10);
		jLabel2.setHorizontalAlignment(JLabel.RIGHT);
		JP2.setSize(150, 30);
		JP2.setLocation(125, 45);

		jLabel3.setSize(100, 100);
		jLabel3.setLocation(15, 65);
		jLabel3.setHorizontalAlignment(JLabel.RIGHT);
		JP3.setSize(150, 30);
		JP3.setLocation(125, 100);

		panLab.setLayout(null);
//		panLab.add(jLabel1);
		panLab.add(jLabel2);
		panLab.add(jLabel3);
//		panLab.add(JP1);
		panLab.add(JP2);
		panLab.add(JP3);

		panBtn.add(jButton1);
		panBtn.add(jButton2);

		add(JLabel4, BorderLayout.NORTH);
		add(panBtn, BorderLayout.SOUTH);
		add(panLab, BorderLayout.CENTER);

		jButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String Old = new String(JP1.getPassword()).trim();
				String New = new String(JP2.getPassword()).trim();
				String Again = new String(JP3.getPassword()).trim();
				String username = LibraryUserFrame.USER_NAME;// 获取当前登录用户名

				Statement stmt = DBUtil.getStatement();
				String sql = "update ycy.users set \"userpsw\" ='" + New
						+ "' where \"username\" = '" + username + "';";
//				String sql2 = "select * from ycy.users where username='" + username
//						+ "' AND userpsw='" + Old + "';";
				try {
					if (!New.equals(Again)) {
						JOptionPane.showMessageDialog(null, "两次密码输入不一致！");
					} else {
						stmt.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "密码修改成功。");
						dispose();
					}
//					ResultSet rs = stmt.executeQuery(sql2);
//					if (rs.next()) {
//						if (!New.equals(Again)) {
//							JOptionPane.showMessageDialog(null, "两次密码输入不一致！");
//						} else {
//							stmt.executeUpdate(sql);
//							JOptionPane.showMessageDialog(null, "密码修改成功。");
//						}
//					} else {
//						JOptionPane.showMessageDialog(null, "原密码输入错误！");
//					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		jButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JP1.setText("");
				JP2.setText("");
				JP3.setText("");
			}
		});
	}
}
