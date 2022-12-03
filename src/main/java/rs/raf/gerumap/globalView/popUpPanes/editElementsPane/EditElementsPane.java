package rs.raf.gerumap.globalView.popUpPanes.editElementsPane;

import lombok.Getter;
import lombok.Setter;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.model.repository.implementation.Term;
import rs.raf.gerumap.observer.NotificationType;
;import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

@Getter
@Setter
public class EditElementsPane extends JDialog {

    private JPanel mainPanel;

    private JPanel buttonPanel;
    private JButton okButton;
    private JButton cancelButton;

    private JPanel colorPanel;

    private JLabel borderColor;
    private JLabel backgroundColor;
    private JLabel textColor;

    private JButton borderButton;
    private JButton backgroundButton;
    private JButton textButton;

    private JSlider thicknessSlider;
    private JColorChooser jColorChooserBackground;
    private JColorChooser jColorChooserBorder;
    private JColorChooser jColorChooserText;

    private JDialog jDialog;

    private MapNode model;

    public EditElementsPane(Frame parent, MapNode mapNode, String title, boolean modal, int sizeX, int sizeY) {

        this.model = mapNode;

        setSize(sizeX, sizeY);
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - sizeX, Toolkit.getDefaultToolkit().getScreenSize().height/2 - sizeY);
        setTitle(title);

        initComponents();
        setComponentAttributes();

        this.add(mainPanel);
        setResizable(false);
        setVisible(true);
    }

    private void initComponents(){

        mainPanel = new JPanel();

        colorPanel = new JPanel();

        buttonPanel = new JPanel();
        okButton = new JButton("Ok");
        cancelButton = new JButton("cancel");

        borderColor = new JLabel("borderColor");
        backgroundColor = new JLabel("backgroundColor");
        textColor = new JLabel("textColor");

        borderButton = new JButton();
        backgroundButton = new JButton();
        textButton = new JButton();

        jColorChooserBorder = new JColorChooser();
        jColorChooserText = new JColorChooser();
        jColorChooserBackground = new JColorChooser();

        thicknessSlider = new JSlider(SwingConstants.HORIZONTAL,0, 20, 3);
        jDialog = new JDialog();

    }

    private void setComponentAttributes(){

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(10,10,10,10));

        if (model instanceof Term){

            Term term = ((Term) model);

            colorPanel.setLayout(new FlowLayout());
            colorPanel.setPreferredSize(new Dimension(170, 139));

            borderColor.setPreferredSize(new Dimension(100, 40));
            backgroundColor.setPreferredSize(new Dimension(100, 40));
            textColor.setPreferredSize(new Dimension(100, 40));

            borderButton.setBackground(term.getBorderColor());
            borderButton.setPreferredSize(new Dimension(40, 40));
            borderButton.addMouseListener(new ButtonMouseListener(this, 1));

            textButton.setBackground(term.getTextColor());
            textButton.setPreferredSize(new Dimension(40, 40));
            textButton.addMouseListener(new ButtonMouseListener(this, 3));

            backgroundButton.setBackground(term.getBackgroundColor());
            backgroundButton.setPreferredSize(new Dimension(40, 40));
            backgroundButton.addMouseListener(new ButtonMouseListener(this, 2));

            setColorChooserUpdateLogic();

            colorPanel.add(borderColor); colorPanel.add(borderButton);
            colorPanel.add(backgroundColor); colorPanel.add(backgroundButton);
            colorPanel.add(textColor); colorPanel.add(textButton);

            thicknessSlider.setPreferredSize(new Dimension(150, 30));
            thicknessSlider.addChangeListener(e ->{
                term.setThickness(thicknessSlider.getValue());
                term.notifySubscribers(null, NotificationType.REPAINT);
            });

            mainPanel.add(colorPanel);
            mainPanel.add(thicknessSlider);
        }


    }

    private void setColorChooserUpdateLogic(){
        jColorChooserBorder.getSelectionModel().addChangeListener(e -> {
            borderButton.setBackground(jColorChooserBorder.getColor());
            ((Term) model).setBorderColor(jColorChooserBorder.getColor());
            model.notifySubscribers(null, NotificationType.REPAINT);
        });

        jColorChooserText.getSelectionModel().addChangeListener(e -> {
            textButton.setBackground(jColorChooserText.getColor());
            ((Term) model).setTextColor(jColorChooserText.getColor());
            model.notifySubscribers(null, NotificationType.REPAINT);
        });

        jColorChooserBackground.getSelectionModel().addChangeListener(e -> {
            backgroundButton.setBackground(jColorChooserBackground.getColor());
            ((Term) model).setBackgroundColor(jColorChooserBackground.getColor());
            model.notifySubscribers(null, NotificationType.REPAINT);
        });
    }

    public JDialog getColorChooser(int type){

        if (jDialog.isShowing()) return null;

        jDialog = new JDialog();
        jDialog.setPreferredSize(new Dimension(500, 500));
        jDialog.setSize(new Dimension(500, 500));
        jDialog.setLocation(200, 200);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(630, 420));
        panel.setSize(new Dimension(630, 420));

        switch (type){
            case 1 -> jDialog.add(jColorChooserBorder);
            case 2 -> jDialog.add(jColorChooserBackground);
            case 3 -> jDialog.add(jColorChooserText);
        }

        jDialog.setVisible(true);
        jDialog.setAlwaysOnTop(true);

        return jDialog;
    }
}

