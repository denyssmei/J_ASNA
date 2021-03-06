package util.gui;

import util.gui.DTO.TableDTO;
import util.gui.providers.constants.ElementsOfConstantPage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    JMenuBar menuBar;

    public static final String[] columns = {
            "Index","Vector","Intens"
    };


    private static JTextField constantText1 = new JTextField(14),
            constantText2 = new JTextField(14), constantText3 = new JTextField(14);
    private static JTextField vectorText1 = new JTextField(14), vectorText2 = new JTextField(14),
            vectorText3 = new JTextField(14);
    private JTextField eventText1 = new JTextField(7), eventText2 = new JTextField(7),
            eventText3 = new JTextField(7), eventText4 = new JTextField(7),
            eventText5 = new JTextField(7), eventText6 = new JTextField(7);
    private JTextField textFieldRefuseExpression = new JTextField(30);
    private DefaultTableModel constantModel;
    private DefaultTableModel vectorModel;
    private DefaultTableModel refuseModel;
    private DefaultTableModel eventModel;
    private DefaultTableModel outModel = new DefaultTableModel(columns,0);
    private JTable constantTable;
    private JTable vectorTable;
    private JTable eventTable;
    private JTable refuseTable;
    private JTable outTable;
    private JTabbedPane tablePanel;
    private TableDTO tableDTO;

    public MyFrame(TableDTO tableDTO) throws HeadlessException {

        this.tableDTO = tableDTO;
        tablePanel = new JTabbedPane();
        JComponent constantComp = ElementsOfConstantPage
                .addElementOfConstantPage(constantModel, constantText1, constantText2, constantText3, constantTable, tableDTO);
        tablePanel.addTab("Constants and value", null, constantComp, "Press to enter constants and value");


        JComponent vectorComponent = util.gui.providers.vector.ElementsOfConstantPage
                .addElementOfConstantPage(vectorModel, vectorText1, vectorText2, vectorText3, vectorTable, tableDTO);
        tablePanel.addTab("Vectors and refuse expressions", null, vectorComponent, "Press to enter vectors and refuse expressions");


        JComponent eventComponent = util.gui.providers.event.ElementsOfConstantPage
                .addElementOfConstantPage(eventModel, eventText1, eventText2, eventText3,
                        eventText4, eventText5, eventText6, eventTable, tableDTO);
        tablePanel.addTab("Event tree", null, eventComponent, "Press to enter event tree");


        JComponent refuseComponent = util.gui.providers.refuse.exp.ElementsOfConstantPage
                .addElementOfConstantPage(refuseModel, textFieldRefuseExpression, tableDTO);
        tablePanel.addTab("Refuse Expression", null, refuseComponent, "Press to enter refuse Expression");

        JComponent outComponent = util.gui.providers.graph.ElementsOfConstantPage
                .addElementOfConstantPage(outModel, outTable, tableDTO);
        tablePanel.addTab("Output", null, outComponent, "Press to enter check Output");

        getContentPane().add(tablePanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);

        menuBar = util.gui.providers.MenuBar.getMenuBar(tableDTO, outModel);
        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Salut!");
    }
}
