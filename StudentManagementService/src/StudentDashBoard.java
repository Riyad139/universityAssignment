import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class StudentDashBoard {
    private JPanel panel1;
    private JLabel NavLogo;
    private JPanel sidebar;
    private JPanel navbar;
    private JLabel userLogo;
    private JLabel updateLogo;
    private JLabel search;
    private JLabel Delete;
    private JTable studentDetails;
    private JPanel mainPanel;
    private JTable StudentTable;
    private JScrollPane StudentScroll;
    private JTextField SearchField;
    private JButton searchButton;
    private JTable searchStudentTable;
    private JScrollPane SearchScrollPane;
    private JPanel SerchStudentPane;
    private JTextField deleteField;
    private JPanel DeletePane;
    private JPanel UpdatePane;
    private JTextField updateIDField;
    private JLabel updateLabel;
    private JTextField updateName;
    private JTextField updateDept;
    private JTextField updateType;
    private JTextField updateEmail;
    private JPanel studentDetalisNeedToUpdate;
    private JButton updateButton;
    private JButton SearchAndUpdate;
    private JLabel updateSuccesfully;
    private JLabel deleteFeedBack;
    private JButton deleteButton;
    private JLabel SearchFeedBack;
    private JLabel updateFeedBack;
    private JFrame frame;


    private String [][]data;
    private StudentData studentData;
    private String []header = new String[]{"StudentId","Name","Dept.","Type","Email"};

    StudentDashBoard(){
       studentData = new StudentData();
       this.data = studentData.getData();

        /// creating frame ///////////////
        this.creatingFrame();
        /// inserting icon to nav bar /////////////////////////
        this.setIcons();
        /// handle opaque//////////
        this.handleOpaque();
         // handling click event on sidebar
          handleClickOnSidebar();
      ///// setting table design for table
       this.setTableDesign(this.StudentTable,data);
       handleSearch();
       handlerUpdate();
        deleteHandler();
       this.DefaultPaneActive();


    }

    private void creatingFrame(){
        this.frame = new JFrame();
        frame.add(this.panel1);
        frame.setSize(900,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800,600));
    }

    private void handleOpaque(){
        userLogo.setOpaque(true);
        Delete.setOpaque(true);
        search.setOpaque(true);
        updateLogo.setOpaque(true);
    }

    private void DefaultPaneActive(){
        removeBg();
        userLogo.setBackground(Color.lightGray);
        searchDisableOption();
        this.StudentScroll.setVisible(true);
        this.updateDisableOption();
        this.deleteDisableOption();
    }

    private void setIcons(){
        ImageIcon img = new ImageIcon("src/Logo/users.png");
        ImageIcon newImg = new ImageIcon(getScaledImage(img.getImage(),50,50));
        this.userLogo.setIcon(newImg);
        ImageIcon navImg = new ImageIcon("src/Logo/diuLogo.png");
        ImageIcon newNavImg = new ImageIcon(getScaledImage(navImg.getImage(),150,150));
        ImageIcon updateImg = new ImageIcon("src/Logo/updateUser.png");
        ImageIcon newUpdateImg = new ImageIcon(getScaledImage(updateImg.getImage(),60,60));
        updateLogo.setIcon(newUpdateImg);
        ImageIcon searchImg = new ImageIcon("src/Logo/search.png");
        ImageIcon newSearchImg = new ImageIcon(getScaledImage(searchImg.getImage(),50,50));
        ImageIcon deleteImg = new ImageIcon("src/Logo/deleteUser.png");
        ImageIcon newDeleteImg = new ImageIcon(getScaledImage(deleteImg.getImage(),50,50));
        this.search.setIcon(newSearchImg);
        this.Delete.setIcon(newDeleteImg);
        NavLogo.setIcon(newNavImg);
    }

    private void handleSearch(){
        this.searchButton.addActionListener(e->{
           String id =  SearchField.getText();
           String []res = studentData.getDataById(id);
           if(res == null){
             this.SearchFeedBack.setVisible(true);
             this.searchStudentTable.setVisible(false);
             this.SearchScrollPane.setVisible(false);
             return;
           }
           this.SearchFeedBack.setVisible(false);
           this.SearchScrollPane.setVisible(true);
            this.searchStudentTable.setVisible(true);

           String [][] data1 = {res};
            setTableDesign(this.searchStudentTable,data1);
        });
    }

    private void handlerUpdate(){

        this.SearchAndUpdate.addActionListener(e->{
            String id = updateIDField.getText();
            String []student = studentData.getDataById(id);
            if(student==null){
                this.studentDetalisNeedToUpdate.setVisible(false);
                this.updateFeedBack.setVisible(true);
                return;
            }
            this.updateFeedBack.setVisible(false);
            this.studentDetalisNeedToUpdate.setVisible(true);
            this.updateName.setText(student[1]);
            this.updateDept.setText(student[2]);
            this.updateType.setText(student[3]);
            this.updateEmail.setText(student[4]);
            updateButton.addActionListener(a->{
                studentData.updateById(id,updateName.getText(),updateDept.getText(),updateType.getText(),updateEmail.getText());
                this.updateSuccesfully.setVisible(true);
            });

        });
        this.updateButton.addActionListener(e->{
            this.updateSuccesfully.setVisible(true);
        });
    }

    private void deleteHandler (){
        this.deleteButton.addActionListener(e->{
            studentData.deleteById(deleteField.getText());
            deleteFeedBack.setVisible(true);
        });
    }

    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    private void removeBg(){
         updateLogo.setBackground(Color.white);
         userLogo.setBackground(Color.white);
         search.setBackground(Color.white);
         Delete.setBackground(Color.white);
    }



    private void handleClickOnSidebar(){

       this.userLogo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                removeBg();
                data = studentData.getData();
                StudentScroll.setVisible(true);
                SerchStudentPane.setVisible(false);
                DeletePane.setVisible(false);
                updateDisableOption();
                userLogo.setBackground(Color.lightGray);
                setTableDesign(StudentTable,data);
            }
        });

        this.Delete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                removeBg();
                StudentScroll.setVisible(false);
                SerchStudentPane.setVisible(false);
                DeletePane.setVisible(true);
                updateDisableOption();
                Delete.setBackground(Color.lightGray);
            }
        });

        this.updateLogo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                removeBg();
                UpdatePane.setVisible(true);
                StudentScroll.setVisible(false);
                SerchStudentPane.setVisible(false);
                DeletePane.setVisible(false);
                updateLogo.setBackground(Color.lightGray);

            }
        });

        this.search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                removeBg();
                StudentScroll.setVisible(false);
                DeletePane.setVisible(false);
                SerchStudentPane.setVisible(true);
                updateDisableOption();
                search.setBackground(Color.lightGray);
            }
        });

    }

    private void setTableDesign(JTable table,String[][]data){


        table.setModel( new DefaultTableModel( data,header));
        TableColumnModel column = table.getColumnModel();
        column.getColumn(1).setMinWidth(250);
        table.setRowHeight(30);
        table.getTableHeader().setPreferredSize(new Dimension(250,40));
        table.getTableHeader().setFont(new Font("roboto",Font.BOLD,18));
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        column.getColumn(0).setCellRenderer(cellRenderer);
        column.getColumn(2).setCellRenderer(cellRenderer);
        column.getColumn(3).setCellRenderer(cellRenderer);
        column.getColumn(4).setCellRenderer(cellRenderer);

    }
    public JFrame getFrame(){
        return this.frame;
    }


    public void updateDisableOption(){
        this.UpdatePane.setVisible(false);
        this.studentDetalisNeedToUpdate.setVisible(false);
        this.updateSuccesfully.setVisible(false);
        this.updateFeedBack.setVisible(false);
    }

    public void searchDisableOption(){
        this.SerchStudentPane.setVisible(false);
        this.SearchFeedBack.setVisible(false);

    }

    public void deleteDisableOption(){
        this.deleteFeedBack.setVisible(false);
        this.DeletePane.setVisible(false);
    }



}
