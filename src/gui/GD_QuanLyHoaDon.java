package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.QuanLyHoaDon_Dao;
import entity.HoaDon;

public class GD_QuanLyHoaDon extends JPanel implements ActionListener,MouseListener{


	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;
	private JTable table_1;
	private DefaultTableModel tablemodel, tablemodel1;
	private JButton tim;
	private QuanLyHoaDon_Dao dshd;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public GD_QuanLyHoaDon() {
		setBackground(new Color(217, 217, 217));
	    setSize(1140, 865);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ HÓA ĐƠN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(450, 15, 330, 35);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Danh sách hóa đơn");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(96, 113, 291, 24);
		add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(96, 168, 939, 241);
		add(scrollPane);
		
		String header[]= {
				"Mã Hóa Đơn","Tổng Tiền", "Ngày Lập Hóa Đơn", "Tên Khách Hàng","Số Điện Thoại", "Mã Nhân Viên"};
		 tablemodel = new DefaultTableModel(header, 0) ;
		table = new JTable(tablemodel);
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
      	table.setRowHeight(25);
//      	table.setBackground(new Color(217,217,217));
      	scrollPane.setViewportView(table);
      	
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox.addItem("Tìm kiếm theo tên khách hàng");
		comboBox.addItem("Tìm kiếm theo ngày");
		comboBox.addItem("Tất cả");
		comboBox.setBounds(96, 452, 169, 33);
		add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(299, 452, 530, 33);
		add(textField);
		textField.setColumns(10);
		
		 tim = new JButton("Tìm");
		tim.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tim.setBounds(909, 452, 126, 33);
		tim.setForeground(Color.WHITE);
		tim.setBackground(Color.black);
		tim.setBorderPainted(false);
		add(tim);
		
		JLabel lblNewLabel_1_1 = new JLabel("Chi tiết hóa đơn");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1_1.setBounds(96, 513, 183, 24);
		add(lblNewLabel_1_1);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(96, 560, 937, 216);
		add(scrollPane_1);
		
		String heaher[] = { "Mã Vé", "Mã Hóa Đơn", "Gía Vé"};
		tablemodel1 = new DefaultTableModel(heaher, 10);
		table_1 = new JTable(tablemodel1);
		table_1.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
      	table_1.setRowHeight(25);
//      	table_1.setBackground(new Color(217,217,217));
      	scrollPane_1.setViewportView(table_1);
      	addDataHD();
      	tim.addActionListener(this);
      	comboBox.addActionListener(this);
      	table.addMouseListener(this);;
	}
	private void addDataHD()
	{
		dshd = new QuanLyHoaDon_Dao();
		ArrayList<HoaDon> list = dshd.doctuBang();
		for(HoaDon s : list)
		{
			String [] rowData = {s.getMaHD(),s.getTongTien() + "",s.getNgayLHD()+ "", s.getTenKH(),s.getSDT(),s.getNhanvien().getMaNhanVien()};
			tablemodel.addRow(rowData);
		}
		table.setModel(tablemodel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		 if (tim.equals(o)) { 
			 if (comboBox.getSelectedItem().equals("Tìm kiếm theo tên khách hàng")) {
				    String tuKhoa = textField.getText();
				    
				    if (tuKhoa.isEmpty()) {
				        JOptionPane.showMessageDialog(this, "Vui lòng nhập tên khách hàng: ");
				    } else {
				        dshd = new QuanLyHoaDon_Dao();
				        ArrayList<HoaDon> hoadonList = dshd.timKiemTheoTenKhachHang(tuKhoa);
				        
				        if (!hoadonList.isEmpty()) {
				            xoaDulieuTable();
				            xoaDulieuTable1();
				            
				            for (HoaDon hoadon : hoadonList) {
				                String[] rowData = {hoadon.getMaHD(), hoadon.getTongTien() + "", hoadon.getNgayLHD() + "", hoadon.getTenKH(), hoadon.getSDT(), hoadon.getNhanvien().getMaNhanVien()};
				                tablemodel.addRow(rowData);
				            }
				        } else {
				            JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn với tên khách hàng là: " + tuKhoa);
				        }
				    }
				}


		        if (comboBox.getSelectedItem().equals("Tìm kiếm theo ngày")) {
		            String ngayString = textField.getText();
		            
		            if (ngayString.isEmpty()) {
		                JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày");
		            } else {
		                // Kiểm tra định dạng ngày bằng biểu thức chính quy
		                if (ngayString.matches("\\d{2}-\\d{2}-\\d{4}")) { // dd-MM-yyyy
		                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		                    LocalDate ngay = LocalDate.parse(ngayString, formatter);
		                    dshd = new QuanLyHoaDon_Dao();
		                    ArrayList<HoaDon> listHoaDonTheoNgay = dshd.timkiemtheoNgay(ngay);
		                    if (!listHoaDonTheoNgay.isEmpty()) {
		                        xoaDulieuTable();
		                        xoaDulieuTable1();
		                        for (HoaDon hoaDon : listHoaDonTheoNgay) {
		                            String[] rowData = {hoaDon.getMaHD(), hoaDon.getTongTien() + "", hoaDon.getNgayLHD() + "", hoaDon.getTenKH(), hoaDon.getSDT(), hoaDon.getNhanvien().getMaNhanVien()};
		                            tablemodel.addRow(rowData);
		                        }
		                        table.setModel(tablemodel);
		                    } else {
		                        JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn có ngày " + ngayString);
		                    }
		                } else {
		                    JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày theo định dạng dd-MM-yyyy");
		                }
		            }
		        }

		        if(comboBox.getSelectedItem().equals("Tất cả"))
		        {
		        	xoaDulieuTable();
		        	xoaDulieuTable1();
		        	dshd = new QuanLyHoaDon_Dao();
					ArrayList<HoaDon> list = dshd.doctuBang();
					for(HoaDon s : list)
					{
						String [] rowData = {s.getMaHD(),s.getTongTien() + "",s.getNgayLHD()+ "", s.getTenKH(),s.getSDT(),s.getNhanvien().getMaNhanVien()};
						tablemodel.addRow(rowData);
					}
					table.setModel(tablemodel);
		        }
		    }
		}
	public void xoaDulieuTable()
	{
		while(tablemodel.getRowCount() > 0)
		{
			tablemodel.removeRow(0);
		}
	}
	
	public void xoaDulieuTable1()
	{
		while(tablemodel1.getRowCount() > 0)
		{
			tablemodel1.removeRow(0);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	    int row = table.getSelectedRow();
        // Lấy mã hóa đơn từ hàng được chọn
        String maHD = table.getValueAt(row, 0).toString();
        
        // Gọi phương thức trong DAO để lấy danh sách chi tiết hóa đơn
        ArrayList<Object[]> chiTietHoaDonList = dshd.layChiTietHoaDon(maHD);
        
        // Xóa dữ liệu cũ trong bảng table_1
        tablemodel1.setRowCount(0);
        
        // Thêm dữ liệu mới từ danh sách chi tiết hóa đơn vào bảng table_1
        for (Object[] rowData : chiTietHoaDonList) {
            tablemodel1.addRow(rowData);
        }
        
        // Cập nhật bảng table_1
        table_1.setModel(tablemodel1);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

