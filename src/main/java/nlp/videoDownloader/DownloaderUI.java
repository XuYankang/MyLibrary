package nlp.videoDownloader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by jacob on 14-10-11.
 */
public class DownloaderUI {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("CourseraFetcher");
        jFrame.setVisible(true);
        jFrame.setSize(800, 600);

        Container contentPane = jFrame.getContentPane();
        contentPane.setLayout(new GridLayout(3, 3));

        JLabel label = new JLabel("请输入Coursera课程地址");
        contentPane.add(label);

        JTextField textField = new JTextField("如https://class.coursera.org/nlp/lectureElement");
        textField.setSize(100, 30);
        contentPane.add(textField);


        JButton button = new JButton("点击开始下载");
        button.setSize(80, 30);
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("kk");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        contentPane.add(button);

    }
}
