package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class GD_QuanLyPhim extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField textField;
	private JTextField txtThoiLuong;


	public GD_QuanLyPhim() {
		setBackground(new Color(217, 217, 217));
		setSize(1140, 865);
		setLayout(null);
		
		JLabel lblTitle = new JLabel("QUẢN LÝ PHIM");
		lblTitle.setBounds(450, 15, 231, 35);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		add(lblTitle);
		
		JPanel panel = new JPanel();
        panel.setBackground(new Color(217, 217, 217));
        
        // Đặt đường viền với độ dày lớn hơn và phông chữ lớn hơn cho tiêu đề
        Font borderFont = new Font("Times New Roman", Font.BOLD, 25); // Phông chữ lớn hơn cho tiêu đề
        LineBorder thickBorder = new LineBorder(new Color(0, 0, 0), 2); // Đường viền dày hơn
        TitledBorder titledBorder = new TitledBorder(thickBorder, "Thông Tin Phim", TitledBorder.LEADING, TitledBorder.TOP, borderFont, new Color(0, 0, 0));
        
        panel.setBorder(titledBorder);
        panel.setBounds(20, 60, 1100, 200);
        add(panel);
        panel.setLayout(null);
        
        JLabel lblMa = new JLabel("Mã Phim");
        lblMa.setBounds(60, 45, 110, 24);
        lblMa.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        panel.add(lblMa);
        
        JLabel lblTen = new JLabel("Tên Phim");
        lblTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblTen.setBounds(60, 90, 85, 30);
        panel.add(lblTen);
        
        JLabel lblDaoDien = new JLabel("Đạo Diễn");
        lblDaoDien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblDaoDien.setBounds(60, 130, 85, 45);
        panel.add(lblDaoDien);
        
        txtMa = new JTextField();
        txtMa.setBounds(176, 45, 200, 25);
        panel.add(txtMa);
        txtMa.setColumns(10);
        
        txtTen = new JTextField();
        txtTen.setBounds(176, 93, 200, 25);
        panel.add(txtTen);
        txtTen.setColumns(10);
        
        textField = new JTextField();
        textField.setBounds(176, 140, 200, 25);
        panel.add(textField);
        textField.setColumns(10);
        
        JLabel lblThoiLuong = new JLabel("Thời Lượng");
        lblThoiLuong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblThoiLuong.setBounds(612, 45, 200, 24);
        panel.add(lblThoiLuong);
        
        JLabel lblTheLoai = new JLabel("Thể Loại");
        lblTheLoai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblTheLoai.setBounds(612, 90, 100, 25);
        panel.add(lblTheLoai);
        
        txtThoiLuong = new JTextField();
        txtThoiLuong.setBounds(750, 45, 200, 24);
        panel.add(txtThoiLuong);
        txtThoiLuong.setColumns(10);
        
        JComboBox comboBoxTheLoai = new JComboBox();
        comboBoxTheLoai.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        comboBoxTheLoai.setBounds(750, 90, 200, 24);
        panel.add(comboBoxTheLoai);
        
        comboBoxTheLoai.addItem("Tất Cả");
        comboBoxTheLoai.addItem("Hài Hước");
        comboBoxTheLoai.addItem("Hành Động");
        comboBoxTheLoai.addItem("Lãng Mạn");
        comboBoxTheLoai.addItem("Kinh Dị");
        comboBoxTheLoai.addItem("Hoạt Hình");
        comboBoxTheLoai.setMaximumRowCount(4); 
        
        JButton btnAdd = new JButton("Thêm Phim");
        btnAdd.setBackground(new Color(0, 0, 0));
        btnAdd.setForeground(new Color(255,255,255));
        btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnAdd.setBounds(160, 296, 130, 40);
        btnAdd.setFocusPainted(false);
        add(btnAdd);
        
        JButton btnChange = new JButton("Sửa Phim");
        btnChange.setBackground(new Color(0, 0, 0));
        btnChange.setForeground(new Color(255,255,255));
        btnChange.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnChange.setBounds(350, 296, 130, 40);
        btnChange.setFocusPainted(false);
        add(btnChange);
        
        JButton btnDelete = new JButton("Xóa Phim");
        btnDelete.setBackground(new Color(0, 0, 0));
        btnDelete.setForeground(new Color(255,255,255));
        btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnDelete.setBounds(540, 296, 130, 40);
        btnDelete.setFocusPainted(false);
        add(btnDelete);

        DefaultTableModel dataModel = new DefaultTableModel();
      	String headers[] = {"Mã phim", "Tên phim", "Đạo diễn", "Thời lượng", "Thể loại"};
      	dataModel = new DefaultTableModel(headers,0);
      	JTable tableModel = new JTable(dataModel);
      	tableModel.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));
      	tableModel.setRowHeight(25);
      	tableModel.setBackground(new Color(217,217,217));
      	
      //Thêm dữ liệu mẫu
        dataModel.addRow(new Object[]{"P001", "Phim Hài Hước", "Đạo diễn A", "120 phút", "Hài Hước"});
        dataModel.addRow(new Object[]{"P002", "Phim Hành Động", "Đạo diễn B", "130 phút", "Hành Động"});
        dataModel.addRow(new Object[]{"P003", "Phim Lãng Mạn", "Đạo diễn C", "110 phút", "Lãng Mạn"});
    	
      	tableModel.setModel(dataModel);
      	JScrollPane scroll = new JScrollPane(tableModel);
      	scroll.setBounds(20, 360, 1100, 500); 
      	scroll.setBackground(new Color(217,217,217));
      	add(scroll);
      	
      	JLabel lblNewLabel = new JLabel("Lọc Theo Thể Loại");
      	lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
      	lblNewLabel.setBounds(750, 296, 150, 35);
      	add(lblNewLabel);
      	
      	JComboBox comboBoxLoc = new JComboBox();
      	comboBoxLoc.setBounds(880, 300, 150, 30);
      	add(comboBoxLoc);
      	comboBoxLoc.addItem("Tất Cả");
      	comboBoxLoc.addItem("Hài Hước");
      	comboBoxLoc.addItem("Hành Động");
      	comboBoxLoc.addItem("Lãng Mạn");
      	comboBoxLoc.addItem("Kinh Dị");
      	comboBoxLoc.addItem("Hoạt Hình");
      	comboBoxLoc.setMaximumRowCount(3);
	}
//        public static void main(String[] args) {
//            SwingUtilities.invokeLater(new Runnable() {
//                public void run() {
//                    createAndShowPanel();
//                }
//            });
//        }
//        public static void createAndShowPanel() {
//        	JFrame frame = new JFrame("Quản Lý Phim");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Đảm bảo chương trình thoát khi đóng cửa sổ
//            frame.setSize(1140, 865); // Kích thước của JFrame
//            frame.setLocationRelativeTo(null); // Đặt vị trí ở giữa màn hình
//
//            // Tạo và thêm GUI_QuanLyPhimm vào JFrame
//            GD_QuanLyPhim panel = new GD_QuanLyPhim();
//            frame.add(panel);
//
//            // Hiển thị JFrame
//            frame.setVisible(true);
//	}
}
