package gui;

import javax.swing.JPanel;

public class GD_QuanLySuatChieu extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField txtTim;
	private JButton btnTim;
	private DefaultTableModel dataModel;
	private JTable tableModel;
	private JTextField txtMa;
	private JDateChooser txtNgay;
	private JComboBox cbbPhim;
	private JComboBox cbbGio;
	private JComboBox cbbPhong;
	private JButton btnXoaRong;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;

	/**
	 * Create the panel.
	 */
	public GUI_SuatChieu() {
		setBackground(Color.LIGHT_GRAY);
		setSize(1140,865);
		setLayout(null);
		
		JPanel pnTop = new JPanel();
		pnTop.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnTop.setBounds(0, 0, 1140, 60);
		add(pnTop);
		pnTop.setLayout(null);
		
		JLabel lblTitle = new JLabel("Suất chiếu");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBackground(Color.BLACK);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
		lblTitle.setBounds(507, 5, 126, 30);
		pnTop.add(lblTitle);
		
		txtTim = new JTextField();
		txtTim.setBounds(250, 80, 400, 25);
		add(txtTim);
		txtTim.setColumns(10);
		
		btnTim = new JButton("Tìm");
		btnTim.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTim.setBounds(705, 80, 89, 25);
		add(btnTim);
		
		JLabel lblDSSC = new JLabel("Danh sách suất chiếu");
		lblDSSC.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 21));
		lblDSSC.setSize(220, 25);
		lblDSSC.setLocation(20, 120);
        String headers[] = {"Mã suất chiếu","Tên Phim","Ngày chiếu" ,"Thời gian bắt đầu", "Thời gian kết thúc","Mã Phòng Chiếu"};
		dataModel = new DefaultTableModel(headers,0);
		tableModel = new JTable(dataModel);
		JScrollPane scroll = new JScrollPane(tableModel);
		scroll.setSize(800, 715);
		scroll.setLocation(5, 150);
		add(lblDSSC);
		add(scroll);
		
		JLabel lblTim = new JLabel("Nhập mã suất chiếu:");
		lblTim.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTim.setBounds(20, 80, 220, 20);
		add(lblTim);
		
		JPanel pnRight = new JPanel();
		pnRight.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Nh\u1EADp th\u00F4ng tin", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnRight.setBackground(Color.LIGHT_GRAY);
		pnRight.setBounds(805, 70, 333, 790);
		add(pnRight);
		pnRight.setLayout(null);
		
		JLabel lblMa = new JLabel("Mã suất chiếu:");
		lblMa.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMa.setBounds(10, 50, 120, 20);
		pnRight.add(lblMa);
		
		JLabel lblTenPhim = new JLabel("Phim:");
		lblTenPhim.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenPhim.setBounds(10, 100, 120, 20);
		pnRight.add(lblTenPhim);
		
		txtMa = new JTextField();
		txtMa.setEnabled(false);
		txtMa.setEditable(false);
		txtMa.setBounds(120, 52, 180, 20);
		pnRight.add(txtMa);
		txtMa.setColumns(10);
		
		cbbPhim = new JComboBox();
		cbbPhim.setBounds(55, 100, 250, 22);
		pnRight.add(cbbPhim);
		
		JLabel lblNgay = new JLabel("Chọn Ngày:");
		lblNgay.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgay.setBounds(10, 150, 100, 18);
		pnRight.add(lblNgay);
		
		txtNgay = new JDateChooser();
		txtNgay.setSize(200, 20);
		txtNgay.setLocation(100, 150);
		pnRight.add(txtNgay);
		
		JLabel lblTimeBatDau = new JLabel("Thời gian bắt đầu :");
		lblTimeBatDau.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTimeBatDau.setBounds(10, 200, 150, 18);
		pnRight.add(lblTimeBatDau);
		
		cbbGio = new JComboBox();
		cbbGio.setBounds(158, 200, 100, 22);
		pnRight.add(cbbGio);
		
		JLabel lblPhong = new JLabel("Phòng Chiếu:");
		lblPhong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhong.setBounds(10, 250, 100, 18);
		pnRight.add(lblPhong);
		
		cbbPhong = new JComboBox();
		cbbPhong.setBounds(131, 250, 150, 22);
		pnRight.add(cbbPhong);
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(20, 340, 150, 50);
		pnRight.add(btnThem);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(175, 340, 150, 50);
		pnRight.add(btnXoa);
		
		btnXoaRong = new JButton("Xóa Rỗng");
		btnXoaRong.setBounds(20, 400, 150, 50);
		pnRight.add(btnXoaRong);
		
		btnSua = new JButton("Sửa");
		btnSua.setBounds(175, 400, 150, 50);
		pnRight.add(btnSua);
	}
}
