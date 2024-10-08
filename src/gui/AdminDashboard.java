package gui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class AdminDashboard extends javax.swing.JFrame {

    private final int id = 1;
    private final String email = "admin@gmail.com";
    private String name;
    private String role;

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

    public AdminDashboard(Integer id, String email, String name, String role) {
        initComponents();
//        this.email = email;
//        this.id = id;
        this.name = name;
        this.role = role;
        jLabel5.setText(name);
        jLabel2.setText(role);
        notiyPanel.putClientProperty(FlatClientProperties.STYLE, "arc: 999");
        TimePanel.putClientProperty(FlatClientProperties.STYLE, "arc: 999");
        this.setExtendedState(MAXIMIZED_BOTH);
        loadDashboard();
        time();

    }

    public AdminDashboard() {
        initComponents();
        notiyPanel.putClientProperty(FlatClientProperties.STYLE, "arc: 999");
        TimePanel.putClientProperty(FlatClientProperties.STYLE, "arc: 999");
        this.setExtendedState(MAXIMIZED_BOTH);
        loadDashboard();
        time();

    }

    private void time() {
        Runnable task = () -> {
            while (true) {
                LocalTime now = LocalTime.now();
                timeLabel.setText("Time :" + now.format(formatter));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted");
                    break;
                }
            }
        };

        Thread thread = new Thread(task);
        thread.start();
    }
//    public news n = new news();
//
//    private void popup() {
//        n.setBounds(1540, 55, 628, 68);
//        n.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
//        n.setVisible(true);
//    }

    private void returns() {
        issueGrn.setFont(new Font("Sylfaen", 0, 16));
        viewGrn.setFont(new Font("Sylfaen", 0, 16));
        issueReturn.setFont(new Font("Sylfaen", 0, 16));
        viewReturn.setFont(new Font("Sylfaen", 0, 16));
        viewInvoice.setFont(new Font("Sylfaen", 0, 16));
        issueInvoice.setFont(new Font("Sylfaen", 0, 16));

    }

    private void loadDashboard() {

        if (dashboardBtn.isSelected()) {
            Dashboard db2 = new Dashboard();//dashboard jPanel
            rightPanel.removeAll();
            rightPanel.add(db2, BorderLayout.CENTER);
            rightPanel.revalidate();
            rightPanel.repaint();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        leftPanel = new javax.swing.JPanel();
        logoPanel = new javax.swing.JPanel();
        logoPanelLeft = new javax.swing.JPanel();
        logoPanelRight = new javax.swing.JPanel();
        logoPanelCenter = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        menuPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Buttons = new javax.swing.JPanel();
        dashboardBtn = new javax.swing.JToggleButton();
        userBtn = new javax.swing.JToggleButton();
        customerBtn = new javax.swing.JToggleButton();
        productBtn = new javax.swing.JToggleButton();
        brandBtn = new javax.swing.JToggleButton();
        categoryBtn = new javax.swing.JToggleButton();
        down = new javax.swing.JLabel();
        GRNbtn = new javax.swing.JToggleButton();
        supplierBtn1 = new javax.swing.JToggleButton();
        companyBtn = new javax.swing.JToggleButton();
        exitBtn = new javax.swing.JToggleButton();
        GReceiveNoption = new javax.swing.JPanel();
        viewGrn = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        issueGrn = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        isuueGRNline = new javax.swing.JLabel();
        grnline = new javax.swing.JLabel();
        down1 = new javax.swing.JLabel();
        returnBtn = new javax.swing.JToggleButton();
        GReturnOption = new javax.swing.JPanel();
        viewReturn = new javax.swing.JLabel();
        returnEye = new javax.swing.JLabel();
        returnClose = new javax.swing.JLabel();
        issueReturn = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        issueReturnLine = new javax.swing.JLabel();
        viewReturnLine = new javax.swing.JLabel();
        InvoiceOption = new javax.swing.JPanel();
        viewInvoice = new javax.swing.JLabel();
        invoiceEye = new javax.swing.JLabel();
        invoiceClose = new javax.swing.JLabel();
        issueInvoice = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        issueInvoiceLine = new javax.swing.JLabel();
        viewInvoiceLine = new javax.swing.JLabel();
        stockBtn = new javax.swing.JToggleButton();
        invoiceBtn = new javax.swing.JToggleButton();
        profileBtn = new javax.swing.JToggleButton();
        topBar = new javax.swing.JPanel();
        leftTopBar = new javax.swing.JPanel();
        TimePanel = new javax.swing.JPanel();
        timeLabel = new javax.swing.JLabel();
        rightTopBar = new javax.swing.JPanel();
        notiyPanel = new javax.swing.JPanel();
        setting = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        notification = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        centerTopBar = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rightPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manager Dashboard");
        setPreferredSize(new java.awt.Dimension(1000, 883));
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        leftPanel.setPreferredSize(new java.awt.Dimension(300, 813));
        leftPanel.setLayout(new java.awt.BorderLayout());

        logoPanel.setBackground(new java.awt.Color(255, 255, 255));
        logoPanel.setPreferredSize(new java.awt.Dimension(100, 144));
        logoPanel.setLayout(new java.awt.BorderLayout());

        logoPanelLeft.setBackground(new java.awt.Color(255, 255, 255));
        logoPanelLeft.setPreferredSize(new java.awt.Dimension(50, 144));

        javax.swing.GroupLayout logoPanelLeftLayout = new javax.swing.GroupLayout(logoPanelLeft);
        logoPanelLeft.setLayout(logoPanelLeftLayout);
        logoPanelLeftLayout.setHorizontalGroup(
            logoPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        logoPanelLeftLayout.setVerticalGroup(
            logoPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 144, Short.MAX_VALUE)
        );

        logoPanel.add(logoPanelLeft, java.awt.BorderLayout.LINE_START);

        logoPanelRight.setBackground(new java.awt.Color(255, 255, 255));
        logoPanelRight.setPreferredSize(new java.awt.Dimension(50, 144));

        javax.swing.GroupLayout logoPanelRightLayout = new javax.swing.GroupLayout(logoPanelRight);
        logoPanelRight.setLayout(logoPanelRightLayout);
        logoPanelRightLayout.setHorizontalGroup(
            logoPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        logoPanelRightLayout.setVerticalGroup(
            logoPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 144, Short.MAX_VALUE)
        );

        logoPanel.add(logoPanelRight, java.awt.BorderLayout.LINE_END);

        logoPanelCenter.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dashlogo1.jpg"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout logoPanelCenterLayout = new javax.swing.GroupLayout(logoPanelCenter);
        logoPanelCenter.setLayout(logoPanelCenterLayout);
        logoPanelCenterLayout.setHorizontalGroup(
            logoPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoPanelCenterLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(41, 41, 41))
        );
        logoPanelCenterLayout.setVerticalGroup(
            logoPanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoPanelCenterLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        logoPanel.add(logoPanelCenter, java.awt.BorderLayout.CENTER);

        leftPanel.add(logoPanel, java.awt.BorderLayout.PAGE_START);

        menuPanel.setBackground(new java.awt.Color(255, 255, 255));
        menuPanel.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        Buttons.setBackground(new java.awt.Color(255, 255, 255));
        Buttons.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(dashboardBtn);
        dashboardBtn.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        dashboardBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-home-25 (1).png"))); // NOI18N
        dashboardBtn.setSelected(true);
        dashboardBtn.setText("Dashboard");
        dashboardBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashboardBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dashboardBtn.setIconTextGap(34);
        dashboardBtn.setMargin(new java.awt.Insets(2, 80, 2, 14));
        dashboardBtn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-home-25.png"))); // NOI18N
        dashboardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardBtnActionPerformed(evt);
            }
        });
        Buttons.add(dashboardBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 5, 350, 53));

        buttonGroup1.add(userBtn);
        userBtn.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        userBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-multiple-users-25 (2).png"))); // NOI18N
        userBtn.setText("Manage Users");
        userBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        userBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        userBtn.setIconTextGap(34);
        userBtn.setMargin(new java.awt.Insets(2, 80, 2, 14));
        userBtn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-multiple-users-25 (1).png"))); // NOI18N
        userBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userBtnActionPerformed(evt);
            }
        });
        Buttons.add(userBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 60, 350, 53));

        buttonGroup1.add(customerBtn);
        customerBtn.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        customerBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-customers-30.png"))); // NOI18N
        customerBtn.setText("Manage Customers");
        customerBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        customerBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        customerBtn.setIconTextGap(34);
        customerBtn.setMargin(new java.awt.Insets(2, 80, 2, 14));
        customerBtn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-customers-30 (1).png"))); // NOI18N
        customerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerBtnActionPerformed(evt);
            }
        });
        Buttons.add(customerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 115, 350, 53));

        buttonGroup1.add(productBtn);
        productBtn.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        productBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-products-25.png"))); // NOI18N
        productBtn.setText("Manage Products");
        productBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        productBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        productBtn.setIconTextGap(34);
        productBtn.setMargin(new java.awt.Insets(2, 80, 2, 14));
        productBtn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-products-25 (1).png"))); // NOI18N
        productBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productBtnActionPerformed(evt);
            }
        });
        Buttons.add(productBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 170, 350, 53));

        buttonGroup1.add(brandBtn);
        brandBtn.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        brandBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-tag-25.png"))); // NOI18N
        brandBtn.setText("Brand Registeration");
        brandBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        brandBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        brandBtn.setIconTextGap(34);
        brandBtn.setMargin(new java.awt.Insets(2, 80, 2, 14));
        brandBtn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-tag-25 (1).png"))); // NOI18N
        brandBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brandBtnActionPerformed(evt);
            }
        });
        Buttons.add(brandBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 225, 350, 53));

        buttonGroup1.add(categoryBtn);
        categoryBtn.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        categoryBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-category-25.png"))); // NOI18N
        categoryBtn.setText("Category Registeration");
        categoryBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        categoryBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        categoryBtn.setIconTextGap(34);
        categoryBtn.setMargin(new java.awt.Insets(2, 80, 2, 14));
        categoryBtn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-category-25 (1).png"))); // NOI18N
        categoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryBtnActionPerformed(evt);
            }
        });
        Buttons.add(categoryBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 280, 350, 53));

        down.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        down.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-down-20.png"))); // NOI18N
        down.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        down.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                downMouseClicked(evt);
            }
        });
        Buttons.add(down, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 510, 50, 40));

        buttonGroup1.add(GRNbtn);
        GRNbtn.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        GRNbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-open-email-25.png"))); // NOI18N
        GRNbtn.setText("Good Receive Note");
        GRNbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GRNbtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        GRNbtn.setIconTextGap(34);
        GRNbtn.setMargin(new java.awt.Insets(2, 80, 2, 14));
        GRNbtn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-supplier-25 (1).png"))); // NOI18N
        GRNbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GRNbtnActionPerformed(evt);
            }
        });
        Buttons.add(GRNbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 504, 350, 53));

        buttonGroup1.add(supplierBtn1);
        supplierBtn1.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        supplierBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-supplier-25.png"))); // NOI18N
        supplierBtn1.setText("Manage Suppliers");
        supplierBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        supplierBtn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        supplierBtn1.setIconTextGap(34);
        supplierBtn1.setMargin(new java.awt.Insets(2, 80, 2, 14));
        supplierBtn1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-supplier-25 (1).png"))); // NOI18N
        supplierBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierBtn1ActionPerformed(evt);
            }
        });
        Buttons.add(supplierBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 335, 350, 53));

        buttonGroup1.add(companyBtn);
        companyBtn.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        companyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-company-25.png"))); // NOI18N
        companyBtn.setText("Company Registration");
        companyBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        companyBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        companyBtn.setIconTextGap(34);
        companyBtn.setMargin(new java.awt.Insets(2, 80, 2, 14));
        companyBtn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-company-25 (1).png"))); // NOI18N
        companyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyBtnActionPerformed(evt);
            }
        });
        Buttons.add(companyBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 392, 350, 53));

        buttonGroup1.add(exitBtn);
        exitBtn.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-exit-25.png"))); // NOI18N
        exitBtn.setText("Exit");
        exitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        exitBtn.setIconTextGap(30);
        exitBtn.setMargin(new java.awt.Insets(2, 80, 2, 14));
        exitBtn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-exit-25 (1).png"))); // NOI18N
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });
        Buttons.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 1010, 350, 53));

        GReceiveNoption.setBackground(new java.awt.Color(255, 255, 255));
        GReceiveNoption.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewGrn.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        viewGrn.setText("View Previous Notes");
        viewGrn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewGrn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewGrnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewGrnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewGrnMouseExited(evt);
            }
        });
        GReceiveNoption.add(viewGrn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-eye.png"))); // NOI18N
        GReceiveNoption.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-close.png"))); // NOI18N
        GReceiveNoption.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        issueGrn.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        issueGrn.setText("Issue GRN");
        issueGrn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        issueGrn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                issueGrnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                issueGrnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                issueGrnMouseExited(evt);
            }
        });
        GReceiveNoption.add(issueGrn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));
        GReceiveNoption.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 300, 20));

        isuueGRNline.setText("____________");
        GReceiveNoption.add(isuueGRNline, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 90, -1));

        grnline.setText("_______________________");
        GReceiveNoption.add(grnline, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 180, -1));

        Buttons.add(GReceiveNoption, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 280, 90));

        down1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        down1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-down-20.png"))); // NOI18N
        down1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        down1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                down1MouseClicked(evt);
            }
        });
        Buttons.add(down1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 650, 50, 50));

        buttonGroup1.add(returnBtn);
        returnBtn.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        returnBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-returned-mail-25.png"))); // NOI18N
        returnBtn.setText("Good Return Note");
        returnBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        returnBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        returnBtn.setIconTextGap(34);
        returnBtn.setMargin(new java.awt.Insets(2, 80, 2, 14));
        returnBtn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-returned-mail-25 (1).png"))); // NOI18N
        returnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBtnActionPerformed(evt);
            }
        });
        Buttons.add(returnBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 650, 350, 53));

        GReturnOption.setBackground(new java.awt.Color(255, 255, 255));
        GReturnOption.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewReturn.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        viewReturn.setText("View Previous Notes");
        viewReturn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewReturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewReturnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewReturnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewReturnMouseExited(evt);
            }
        });
        GReturnOption.add(viewReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 140, -1));

        returnEye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-eye.png"))); // NOI18N
        GReturnOption.add(returnEye, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        returnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-close.png"))); // NOI18N
        GReturnOption.add(returnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        issueReturn.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        issueReturn.setText("Issue GRN");
        issueReturn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        issueReturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                issueReturnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                issueReturnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                issueReturnMouseExited(evt);
            }
        });
        GReturnOption.add(issueReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));
        GReturnOption.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 4, 300, 20));

        issueReturnLine.setText("____________");
        GReturnOption.add(issueReturnLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 90, -1));

        viewReturnLine.setText("_______________________");
        GReturnOption.add(viewReturnLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 170, -1));

        Buttons.add(GReturnOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 710, 310, -1));

        InvoiceOption.setBackground(new java.awt.Color(255, 255, 255));
        InvoiceOption.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewInvoice.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        viewInvoice.setText("View Previous Invoices");
        viewInvoice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewInvoiceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewInvoiceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewInvoiceMouseExited(evt);
            }
        });
        InvoiceOption.add(viewInvoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, -1, -1));

        invoiceEye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-eye.png"))); // NOI18N
        InvoiceOption.add(invoiceEye, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        invoiceClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-close.png"))); // NOI18N
        InvoiceOption.add(invoiceClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        issueInvoice.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        issueInvoice.setText("Issue Invoice");
        issueInvoice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        issueInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                issueInvoiceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                issueInvoiceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                issueInvoiceMouseExited(evt);
            }
        });
        InvoiceOption.add(issueInvoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));
        InvoiceOption.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 4, 300, 20));

        issueInvoiceLine.setText("______________");
        InvoiceOption.add(issueInvoiceLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 120, -1));

        viewInvoiceLine.setText("__________________________");
        InvoiceOption.add(viewInvoiceLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 180, -1));

        Buttons.add(InvoiceOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 860, 310, -1));

        buttonGroup1.add(stockBtn);
        stockBtn.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        stockBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-stocks-30.png"))); // NOI18N
        stockBtn.setText("Check Stock");
        stockBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stockBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        stockBtn.setIconTextGap(30);
        stockBtn.setMargin(new java.awt.Insets(2, 80, 2, 14));
        stockBtn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-supplier-25 (1).png"))); // NOI18N
        stockBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockBtnActionPerformed(evt);
            }
        });
        Buttons.add(stockBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 448, 350, 53));

        buttonGroup1.add(invoiceBtn);
        invoiceBtn.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        invoiceBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-invoice-25.png"))); // NOI18N
        invoiceBtn.setText("Invoice");
        invoiceBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        invoiceBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        invoiceBtn.setIconTextGap(30);
        invoiceBtn.setMargin(new java.awt.Insets(2, 80, 2, 14));
        invoiceBtn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-invoice-25 (1).png"))); // NOI18N
        invoiceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceBtnActionPerformed(evt);
            }
        });
        Buttons.add(invoiceBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 800, 350, 53));

        buttonGroup1.add(profileBtn);
        profileBtn.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        profileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-male-user-25.png"))); // NOI18N
        profileBtn.setText("Profile");
        profileBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profileBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        profileBtn.setIconTextGap(30);
        profileBtn.setMargin(new java.awt.Insets(2, 80, 2, 14));
        profileBtn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-male-user-25 (1).png"))); // NOI18N
        profileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileBtnActionPerformed(evt);
            }
        });
        Buttons.add(profileBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 950, 350, 53));

        jScrollPane1.setViewportView(Buttons);

        menuPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        leftPanel.add(menuPanel, java.awt.BorderLayout.LINE_END);

        getContentPane().add(leftPanel, java.awt.BorderLayout.LINE_START);

        topBar.setPreferredSize(new java.awt.Dimension(968, 70));
        topBar.setLayout(new java.awt.BorderLayout());

        leftTopBar.setBackground(new java.awt.Color(255, 255, 255));
        leftTopBar.setPreferredSize(new java.awt.Dimension(300, 64));

        TimePanel.setLayout(new java.awt.BorderLayout());

        timeLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        timeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLabel.setText("TODAY :1:009 AM");
        TimePanel.add(timeLabel, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout leftTopBarLayout = new javax.swing.GroupLayout(leftTopBar);
        leftTopBar.setLayout(leftTopBarLayout);
        leftTopBarLayout.setHorizontalGroup(
            leftTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftTopBarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(TimePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        leftTopBarLayout.setVerticalGroup(
            leftTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftTopBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TimePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        topBar.add(leftTopBar, java.awt.BorderLayout.LINE_START);

        rightTopBar.setBackground(new java.awt.Color(255, 255, 255));
        rightTopBar.setPreferredSize(new java.awt.Dimension(350, 250));

        notiyPanel.setBackground(new java.awt.Color(119, 82, 254));

        setting.setBackground(new java.awt.Color(119, 82, 254));
        setting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-setting-25.png"))); // NOI18N
        setting.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setting.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                settingFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                settingFocusLost(evt);
            }
        });
        setting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingMouseExited(evt);
            }
        });

        logout.setBackground(new java.awt.Color(119, 82, 254));
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-power-25 (1).png"))); // NOI18N
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutMouseExited(evt);
            }
        });
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        notification.setBackground(new java.awt.Color(119, 82, 254));
        notification.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-notification-24.png"))); // NOI18N
        notification.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        notification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                notificationMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                notificationMouseExited(evt);
            }
        });

        javax.swing.GroupLayout notiyPanelLayout = new javax.swing.GroupLayout(notiyPanel);
        notiyPanel.setLayout(notiyPanelLayout);
        notiyPanelLayout.setHorizontalGroup(
            notiyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notiyPanelLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(setting, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(notification, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        notiyPanelLayout.setVerticalGroup(
            notiyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notiyPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(notiyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(setting)
                    .addComponent(logout)
                    .addComponent(notification, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(5, 5, 5))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-male-user-30.png"))); // NOI18N
        jLabel5.setText("Thipul Liyanage");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout rightTopBarLayout = new javax.swing.GroupLayout(rightTopBar);
        rightTopBar.setLayout(rightTopBarLayout);
        rightTopBarLayout.setHorizontalGroup(
            rightTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightTopBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(notiyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        rightTopBarLayout.setVerticalGroup(
            rightTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightTopBarLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(rightTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(notiyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        topBar.add(rightTopBar, java.awt.BorderLayout.LINE_END);

        centerTopBar.setBackground(new java.awt.Color(255, 255, 255));
        centerTopBar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        centerTopBar.setPreferredSize(new java.awt.Dimension(500, 50));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel27.setText("Hi Welcome Back , ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("jLabel1");

        javax.swing.GroupLayout centerTopBarLayout = new javax.swing.GroupLayout(centerTopBar);
        centerTopBar.setLayout(centerTopBarLayout);
        centerTopBarLayout.setHorizontalGroup(
            centerTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerTopBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(169, 169, 169))
        );
        centerTopBarLayout.setVerticalGroup(
            centerTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerTopBarLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(centerTopBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel27))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        topBar.add(centerTopBar, java.awt.BorderLayout.CENTER);

        getContentPane().add(topBar, java.awt.BorderLayout.PAGE_START);

        rightPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 1, 1));
        rightPanel.setLayout(new java.awt.BorderLayout());
        getContentPane().add(rightPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void downMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downMouseClicked
    }//GEN-LAST:event_downMouseClicked

    private void viewGrnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewGrnMouseClicked
        viewGrn.setFont(new Font("Sylfaen", 1, 16));
        issueGrn.setFont(new Font("Sylfaen", 0, 16));
        issueReturn.setFont(new Font("Sylfaen", 0, 16));
        viewReturn.setFont(new Font("Sylfaen", 0, 16));
        issueInvoice.setFont(new Font("Sylfaen", 0, 16));
        viewInvoice.setFont(new Font("Sylfaen", 0, 16));

        GRNbtn.setSelected(true);
    }//GEN-LAST:event_viewGrnMouseClicked

    private void viewGrnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewGrnMouseEntered

        jLabel4.setLocation(55, 60);
        viewGrn.setLocation(105, 60);
        grnline.setLocation(105, 60);
    }//GEN-LAST:event_viewGrnMouseEntered

    private void viewGrnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewGrnMouseExited

        jLabel4.setLocation(50, 60);
        viewGrn.setLocation(100, 60);
        grnline.setLocation(100, 60);
    }//GEN-LAST:event_viewGrnMouseExited

    private void issueGrnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueGrnMouseClicked
        issueGrn.setFont(new Font("Sylfaen", 1, 16));
        viewGrn.setFont(new Font("Sylfaen", 0, 16));
        issueReturn.setFont(new Font("Sylfaen", 0, 16));
        viewReturn.setFont(new Font("Sylfaen", 0, 16));
        issueInvoice.setFont(new Font("Sylfaen", 0, 16));
        viewInvoice.setFont(new Font("Sylfaen", 0, 16));

        GRNbtn.setSelected(true);
    }//GEN-LAST:event_issueGrnMouseClicked

    private void issueGrnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueGrnMouseEntered

        jLabel3.setLocation(55, 20);
        issueGrn.setLocation(105, 20);
        isuueGRNline.setLocation(105, 20);
    }//GEN-LAST:event_issueGrnMouseEntered

    private void issueGrnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueGrnMouseExited

        jLabel3.setLocation(50, 20);
        issueGrn.setLocation(100, 20);
        isuueGRNline.setLocation(100, 20);
    }//GEN-LAST:event_issueGrnMouseExited

    private void down1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_down1MouseClicked
    }//GEN-LAST:event_down1MouseClicked

    private void GRNbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GRNbtnActionPerformed
        returns();
        GReceiveN greceive = new GReceiveN();
        rightPanel.add(greceive, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(greceive);
    }//GEN-LAST:event_GRNbtnActionPerformed

    private void viewReturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewReturnMouseClicked
        viewReturn.setFont(new Font("Sylfaen", 1, 16));
        issueReturn.setFont(new Font("Sylfaen", 0, 16));
        issueGrn.setFont(new Font("Sylfaen", 0, 16));
        viewGrn.setFont(new Font("Sylfaen", 0, 16));
        issueInvoice.setFont(new Font("Sylfaen", 0, 16));
        viewInvoice.setFont(new Font("Sylfaen", 0, 16));
        returnBtn.setSelected(true);
    }//GEN-LAST:event_viewReturnMouseClicked

    private void viewReturnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewReturnMouseEntered

        returnEye.setLocation(85, 60);
        viewReturn.setLocation(135, 60);
        viewReturnLine.setLocation(135, 60);
    }//GEN-LAST:event_viewReturnMouseEntered

    private void viewReturnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewReturnMouseExited

        returnEye.setLocation(80, 60);
        viewReturn.setLocation(130, 60);
        viewReturnLine.setLocation(130, 60);
    }//GEN-LAST:event_viewReturnMouseExited

    private void issueReturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueReturnMouseClicked
        issueReturn.setFont(new Font("Sylfaen", 1, 16));
        viewReturn.setFont(new Font("Sylfaen", 0, 16));
        issueGrn.setFont(new Font("Sylfaen", 0, 16));
        viewGrn.setFont(new Font("Sylfaen", 0, 16));
        issueInvoice.setFont(new Font("Sylfaen", 0, 16));
        viewInvoice.setFont(new Font("Sylfaen", 0, 16));

        returnBtn.setSelected(true);
    }//GEN-LAST:event_issueReturnMouseClicked

    private void issueReturnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueReturnMouseEntered

        returnClose.setLocation(85, 20);
        issueReturn.setLocation(135, 20);
        issueReturnLine.setLocation(135, 20);
    }//GEN-LAST:event_issueReturnMouseEntered

    private void issueReturnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueReturnMouseExited

        returnClose.setLocation(80, 20);
        issueReturn.setLocation(130, 20);
        issueReturnLine.setLocation(130, 20);
    }//GEN-LAST:event_issueReturnMouseExited

    private void viewInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewInvoiceMouseClicked
        viewInvoice.setFont(new Font("Sylfaen", 1, 16));
        issueReturn.setFont(new Font("Sylfaen", 0, 16));
        viewReturn.setFont(new Font("Sylfaen", 0, 16));
        issueGrn.setFont(new Font("Sylfaen", 0, 16));
        viewGrn.setFont(new Font("Sylfaen", 0, 16));
        issueInvoice.setFont(new Font("Sylfaen", 0, 16));
        invoiceBtn.setSelected(true);
    }//GEN-LAST:event_viewInvoiceMouseClicked

    private void viewInvoiceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewInvoiceMouseEntered

        invoiceEye.setLocation(85, 60);
        viewInvoiceLine.setLocation(135, 60);
        viewInvoice.setLocation(135, 60);
    }//GEN-LAST:event_viewInvoiceMouseEntered

    private void viewInvoiceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewInvoiceMouseExited

        invoiceEye.setLocation(80, 60);
        viewInvoiceLine.setLocation(130, 60);
        viewInvoice.setLocation(130, 60);
    }//GEN-LAST:event_viewInvoiceMouseExited

    private void issueInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueInvoiceMouseClicked
        issueReturn.setFont(new Font("Sylfaen", 0, 16));
        viewReturn.setFont(new Font("Sylfaen", 0, 16));
        issueGrn.setFont(new Font("Sylfaen", 0, 16));
        viewGrn.setFont(new Font("Sylfaen", 0, 16));
        viewInvoice.setFont(new Font("Sylfaen", 0, 16));
        issueInvoice.setFont(new Font("Sylfaen", 1, 16));
        invoiceBtn.setSelected(true);
    }//GEN-LAST:event_issueInvoiceMouseClicked

    private void issueInvoiceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueInvoiceMouseEntered

        invoiceClose.setLocation(85, 20);
        issueInvoice.setLocation(135, 20);
    }//GEN-LAST:event_issueInvoiceMouseEntered

    private void issueInvoiceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueInvoiceMouseExited

        invoiceClose.setLocation(80, 20);
        issueInvoice.setLocation(130, 20);
    }//GEN-LAST:event_issueInvoiceMouseExited

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitBtnActionPerformed

    private void dashboardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardBtnActionPerformed
        returns();
        Dashboard dash = new Dashboard();
        rightPanel.removeAll();
        rightPanel.add(dash, BorderLayout.CENTER);
        rightPanel.revalidate();
        rightPanel.repaint();


    }//GEN-LAST:event_dashboardBtnActionPerformed

    private void userBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userBtnActionPerformed
        returns();
        Users user = new Users();
        rightPanel.removeAll();
        rightPanel.add(user, BorderLayout.CENTER);
        rightPanel.revalidate();
        rightPanel.repaint();


    }//GEN-LAST:event_userBtnActionPerformed

    private void customerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerBtnActionPerformed
        returns();
        Customers customer = new Customers();
        rightPanel.removeAll();
        rightPanel.add(customer, BorderLayout.CENTER);
        rightPanel.revalidate();
        rightPanel.repaint();


    }//GEN-LAST:event_customerBtnActionPerformed

    private void productBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productBtnActionPerformed
        returns();
        Products product = new Products();
        rightPanel.removeAll();
        rightPanel.add(product, BorderLayout.CENTER);
        rightPanel.revalidate();
        rightPanel.repaint();


    }//GEN-LAST:event_productBtnActionPerformed

    private void brandBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brandBtnActionPerformed
        returns();
        Brands brand = new Brands();
        rightPanel.removeAll();
        rightPanel.add(brand, BorderLayout.CENTER);
        rightPanel.revalidate();
        rightPanel.repaint();


    }//GEN-LAST:event_brandBtnActionPerformed

    private void categoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryBtnActionPerformed
        returns();
        Category category = new Category();
        rightPanel.removeAll();
        rightPanel.add(category, BorderLayout.CENTER);
        rightPanel.revalidate();
        rightPanel.repaint();


    }//GEN-LAST:event_categoryBtnActionPerformed

    private void supplierBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierBtn1ActionPerformed
        returns();
        Suppliers supplier = new Suppliers();
        rightPanel.removeAll();
        rightPanel.add(supplier, BorderLayout.CENTER);
        rightPanel.revalidate();
        rightPanel.repaint();


    }//GEN-LAST:event_supplierBtn1ActionPerformed

    private void companyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyBtnActionPerformed
        returns();
        Company company = new Company();
        rightPanel.removeAll();
        rightPanel.add(company, BorderLayout.CENTER);
        rightPanel.revalidate();
        rightPanel.repaint();


    }//GEN-LAST:event_companyBtnActionPerformed

    private void stockBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockBtnActionPerformed
        returns();
        Stock stock = new Stock();
        rightPanel.removeAll();
        rightPanel.add(stock, BorderLayout.CENTER);
        rightPanel.revalidate();
        rightPanel.repaint();


    }//GEN-LAST:event_stockBtnActionPerformed

    private void returnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBtnActionPerformed
        returns();
        GReturnN greturn = new GReturnN();
        rightPanel.removeAll();
        rightPanel.add(greturn, BorderLayout.CENTER);
        rightPanel.revalidate();
        rightPanel.repaint();


    }//GEN-LAST:event_returnBtnActionPerformed

    private void invoiceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceBtnActionPerformed
        returns();
        Invoice invoice = new Invoice();
        rightPanel.removeAll();
        rightPanel.add(invoice, BorderLayout.CENTER);
        rightPanel.revalidate();
        rightPanel.repaint();


    }//GEN-LAST:event_invoiceBtnActionPerformed

    private void profileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileBtnActionPerformed
        returns();
        try {
            Profile profile = new Profile(this.id, this.email);
            rightPanel.removeAll();
            rightPanel.add(profile, BorderLayout.CENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }

        rightPanel.revalidate();
        rightPanel.repaint();
    }//GEN-LAST:event_profileBtnActionPerformed

    private void settingFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_settingFocusGained
    }//GEN-LAST:event_settingFocusGained

    private void settingFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_settingFocusLost
        //
    }//GEN-LAST:event_settingFocusLost

    private void settingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingMouseClicked
    }//GEN-LAST:event_settingMouseClicked

    private void settingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingMouseEntered

//        popup();
//        n.settings.setVisible(true);
//        n.notifi.setVisible(false);
//        n.Logout.setVisible(false);
//        n.pic.setVisible(false);
    }//GEN-LAST:event_settingMouseEntered

    private void settingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingMouseExited
//        n.dispose();
    }//GEN-LAST:event_settingMouseExited

    private void logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseEntered

//        popup();
//        n.settings.setVisible(false);
//        n.notifi.setVisible(false);
//        n.Logout.setVisible(true);
//        n.pic.setVisible(false);
    }//GEN-LAST:event_logoutMouseEntered

    private void logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseExited
//        n.dispose();

    }//GEN-LAST:event_logoutMouseExited

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        //TODO add your handling code here:

        System.exit(0);

    }//GEN-LAST:event_logoutActionPerformed

    private void notificationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationMouseEntered
//        popup();
//        n.settings.setVisible(false);
//        n.notifi.setVisible(true);
//        n.Logout.setVisible(false);
//        n.pic.setVisible(false);

    }//GEN-LAST:event_notificationMouseEntered

    private void notificationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationMouseExited

//        n.dispose();
    }//GEN-LAST:event_notificationMouseExited

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged


    }//GEN-LAST:event_formWindowStateChanged

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        returns();
        try {
            Profile profile = new Profile(this.id, this.email);
            rightPanel.removeAll();
            rightPanel.add(profile, BorderLayout.CENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        rightPanel.revalidate();
        rightPanel.repaint();
        profileBtn.setSelected(true);
    }//GEN-LAST:event_jLabel5MouseClicked

    public static void main(String args[]) {
        FlatMacLightLaf.setup();
        UIManager.put("ToggleButton.selectedBackground", new Color(119, 82, 254));
        UIManager.put("ToggleButton.hoverBackground", new Color(95, 186, 255));
        UIManager.put("ToggleButton.selectedForeground", new Color(255, 255, 255));
        UIManager.put("ToggleButton.pressedBackground", new Color(27, 155, 255));
        UIManager.put("Button.arc", 200);
        UIManager.put("Button.boldText", true);
        UIManager.put("Button.borderWidth", 0);
        UIManager.put("TextComponent.arc", 999);
        UIManager.put("Component.focusWidth", 0);
        UIManager.put("ScrollBar.thumbArc", 999);
        UIManager.put("ScrollBar.width", 7);
        UIManager.put("OptionPane.background", new Color(255, 255, 255));
        UIManager.put("ScrollBar.borderWidth", 0);
        UIManager.put("ScrollBar.hoverThumbColor", new Color(153, 51, 255));//[153,51,255]
        UIManager.put("[style]Panel.myRoundPanel",
                "[light]background: tint(@background,50%);"
                + "[dark]background: shade(@background,15%);"
                + "[light]border: 16,16,16,16,shade(@background,10%),,12;"
                + "[dark]border: 16,16,16,16,tint(@background,10%),,12");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Buttons;
    private javax.swing.JToggleButton GRNbtn;
    private javax.swing.JPanel GReceiveNoption;
    private javax.swing.JPanel GReturnOption;
    private javax.swing.JPanel InvoiceOption;
    private javax.swing.JPanel TimePanel;
    private javax.swing.JToggleButton brandBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JToggleButton categoryBtn;
    private javax.swing.JPanel centerTopBar;
    private javax.swing.JToggleButton companyBtn;
    private javax.swing.JToggleButton customerBtn;
    private javax.swing.JToggleButton dashboardBtn;
    private javax.swing.JLabel down;
    private javax.swing.JLabel down1;
    private javax.swing.JToggleButton exitBtn;
    private javax.swing.JLabel grnline;
    private javax.swing.JToggleButton invoiceBtn;
    private javax.swing.JLabel invoiceClose;
    private javax.swing.JLabel invoiceEye;
    private javax.swing.JLabel issueGrn;
    private javax.swing.JLabel issueInvoice;
    private javax.swing.JLabel issueInvoiceLine;
    private javax.swing.JLabel issueReturn;
    private javax.swing.JLabel issueReturnLine;
    private javax.swing.JLabel isuueGRNline;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel leftTopBar;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JPanel logoPanelCenter;
    private javax.swing.JPanel logoPanelLeft;
    private javax.swing.JPanel logoPanelRight;
    private javax.swing.JButton logout;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JButton notification;
    private javax.swing.JPanel notiyPanel;
    private javax.swing.JToggleButton productBtn;
    private javax.swing.JToggleButton profileBtn;
    private javax.swing.JToggleButton returnBtn;
    private javax.swing.JLabel returnClose;
    private javax.swing.JLabel returnEye;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JPanel rightTopBar;
    private javax.swing.JButton setting;
    private javax.swing.JToggleButton stockBtn;
    private javax.swing.JToggleButton supplierBtn1;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JPanel topBar;
    private javax.swing.JToggleButton userBtn;
    private javax.swing.JLabel viewGrn;
    private javax.swing.JLabel viewInvoice;
    private javax.swing.JLabel viewInvoiceLine;
    private javax.swing.JLabel viewReturn;
    private javax.swing.JLabel viewReturnLine;
    // End of variables declaration//GEN-END:variables
}
