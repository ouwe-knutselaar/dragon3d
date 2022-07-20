package com.sande.dialog;

import com.sande.Global;
import com.sande.tools.Log;
import com.sande.yamldata.DragonConfigReader;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class DragonDialog {

    private final Log log = new Log("DragonDialog");

    private JDialog dialog;
    private List<JCheckBox> checkboxlist = new ArrayList<>();
    private List<JSlider> sliderlist = new ArrayList<>();
    private List<JTextField> servoNumberList = new ArrayList<>();
    private JLabel isRecordingLabel;


    public DragonDialog() {
        dialog = new JDialog();
        dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        dialog.add(buildSliderPanel());
        dialog.add(buildCommPanel());
        dialog.setSize(800, 600);
        dialog.validate();

    }

    public void startDialog(){
        dialog.setVisible(true);
    }

    public void setSlider(int slider, float value){
        sliderlist.get(slider).setValue((int)(value*100));
    }


    private JPanel buildSliderPanel(){
        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridLayout(7,2));

        Global.dragonConfigReader.getServoList().forEach(servo -> {
            checkboxlist.add(new JCheckBox(servo.getName()));
            servoNumberList.add(new JTextField(servo.getNumber()));
            sliderlist.add(new JSlider(-100,100,0));
        });

        sliderPanel.setLayout(new GridLayout(checkboxlist.size(),3));

        for(int tel=0;tel<checkboxlist.size();tel++){
            sliderPanel.add(checkboxlist.get(tel));
            sliderPanel.add(servoNumberList.get(tel));
            sliderPanel.add(sliderlist.get(tel));
        }

        return sliderPanel;
    }

    private JPanel buildCommPanel(){
        JPanel commPanel = new JPanel();
        commPanel.setLayout(new GridLayout(3,3));

        JLabel host=new JLabel("host:port");
        JTextField hostname= new JTextField();
        JTextField port= new JTextField();
        commPanel.add(host);
        commPanel.add(hostname);
        commPanel.add(port);

        JButton connect =new JButton("connect");
        JLabel status = new JLabel("Status");
        JLabel statusValue = new JLabel("none");
        commPanel.add(connect);
        commPanel.add(status);
        commPanel.add(statusValue);


        JLabel recordingText=new JLabel("recording");
        JTextField recordingName= new JTextField("no record");
        isRecordingLabel = new JLabel("false");
        commPanel.add(recordingText);
        commPanel.add(recordingName);
        commPanel.add(isRecordingLabel);
        return commPanel;
    }

    public void checkVisibility(){
        if(dialog.isVisible())return;
        dialog.setVisible(true);
    }

}
