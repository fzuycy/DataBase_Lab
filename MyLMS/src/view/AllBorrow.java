package view;

import utils.DBUtil;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * 查看所有借书记录的类
 */
public class AllBorrow extends JFrame {
	private JScrollPane jsp = new JScrollPane();
	private JTable table = new JTable();

	private int row;
	private MyModel model;

	public AllBorrow() {
		setTitle("所有借书记录");
		setSize(600, 400);
		// 不可改变窗口大小
		setResizable(false);
		// 获取屏幕大小和当前frame的大小
		Dimension thisScreen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension thisFrame = this.getSize();
		// 使启动窗口位于屏幕的正中心
		setLocation((thisScreen.width - thisFrame.width) / 2,
				(thisScreen.height - thisFrame.height) / 2);
		setLocationRelativeTo(null);
		// 设置单击窗口的【关闭】按钮时将发生相应的动作
		setDefaultCloseOperation(HIDE_ON_CLOSE);

		model = new MyModel();
		table.setModel(model);

		table.getColumnModel().getColumn(0).setHeaderValue("借书订单号");
		table.getColumnModel().getColumn(1).setHeaderValue("书号");
		table.getColumnModel().getColumn(2).setHeaderValue("书名");
		table.getColumnModel().getColumn(3).setHeaderValue("书类");
		table.getColumnModel().getColumn(4).setHeaderValue("借书人ID");
		table.getColumnModel().getColumn(5).setHeaderValue("借书人");
		table.getColumnModel().getColumn(6).setHeaderValue("借书时间");
		table.getColumnModel().getColumn(7).setHeaderValue("还书时间");
		table.getColumnModel().getColumn(8).setHeaderValue("是否已还");
		// 设置可见视图的接口
		jsp.setViewportView(table);
		// 定义表格 宽600，高度400
		jsp.setPreferredSize(new Dimension(600, 400));
		// 设置横向和垂直滚动条可见
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		this.setLayout(new BorderLayout());
		this.add(jsp);
	}

	class MyModel extends AbstractTableModel {
		private int row;
		private int column;
		private ResultSet rs;
		private Statement stmt;
		private String sql = "select * from ycy.borrow;";

		public MyModel() {
			stmt = DBUtil.getStatement();
			try {
				rs = stmt.executeQuery(sql);
				rs.last();// 将光标移到最后一行
				row = rs.getRow();// 获取行号(最大行索引)
				ResultSetMetaData rsmd = rs.getMetaData();// 通过结果集对象来获取
				column = rsmd.getColumnCount();// 获取列数
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public int getColumnCount() {
			return column;
		}

		@Override
		public int getRowCount() {
			return row;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Object value = null;
			try {
				rs.absolute(rowIndex + 1);
				value = rs.getString(columnIndex + 1);// 获取表里的数据
			} catch (Exception e) {
				e.printStackTrace();
			}
			return value;
		}
	}
}
