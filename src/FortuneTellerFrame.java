import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    private JLabel titleLabel;
    private JTextArea fortuneArea;
    private JButton readButton;
    private JButton quitButton;
    private ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;

    public FortuneTellerFrame()
    {
        // Set up the JFrame
        super("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        // Load fortunes
        fortunes = new ArrayList<>();
        fortunes.add("A new opportunity will soon come your way, opening doors to exciting possibilities.");
        fortunes.add("Trust in the power of positive thinking; it will attract good fortune into your life.");
        fortunes.add("An unexpected encounter will lead to valuable connections and future success.");
        fortunes.add("Your hard work will soon pay off in ways you haven't imagined.");
        fortunes.add("A journey of personal discovery is about to begin, embrace the lessons it brings.");
        fortunes.add("The stars align in your favor, bringing luck and prosperity.");
        fortunes.add("You will find harmony in balance; remember to give time to all aspects of your life.");
        fortunes.add("A significant change is on the horizon, fear not, for it brings growth and happiness.");
        fortunes.add("Let go of the past to make room for new blessings to enter your life.");
        fortunes.add("Your intuition is strong; trust it to guide you through challenging times.");
        fortunes.add("Love is closer than you think, open your heart to receive it.");
        fortunes.add("An old dream will resurface, offering you a second chance to pursue it.");

        // Create the components
        titleLabel = new JLabel("Fortune Teller", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        ImageIcon icon = new ImageIcon("fortune-teller.png");
        titleLabel.setIcon(icon);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);

        fortuneArea = new JTextArea();
        fortuneArea.setEditable(false);
        fortuneArea.setFont(new Font("Arial", Font.PLAIN, 24));

        JScrollPane scrollPane = new JScrollPane(fortuneArea);

        readButton = new JButton("Read My Fortune!");
        readButton.setFont(new Font("Arial", Font.BOLD, 24));
        readButton.addActionListener((ActionEvent e) ->
        {
            String fortune = readRandomFortune();
            fortuneArea.append(fortune + "\n");
        });

        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Arial", Font.BOLD, 24));
        quitButton.addActionListener((ActionEvent e) ->
        {
            System.exit(0);
        });

        // Add the components to the JFrame
        add(titleLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(readButton);
        buttonPanel.add(quitButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private String readRandomFortune()
    {
        int index = lastFortuneIndex;
        while (index == lastFortuneIndex)
        {
            index = new Random().nextInt(fortunes.size());
        }
        lastFortuneIndex = index;
        return fortunes.get(index);
    }
}