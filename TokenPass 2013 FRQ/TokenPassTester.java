// Updated March 2, 2023 Chris Thiel, OFMCap
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
public class TokenPassTester extends Frame implements ActionListener
{
    private Button exBtn, distBtn, newBtn; 
    private TextField num;

    private Label message;
    private TokenPass tp;
    private Panel cp;

    public  TokenPassTester() 
    {
        super("Token Pass Tester");
        setSize(800,600);
        exBtn = new Button("Example");
        distBtn = new Button("Distribute");
        newBtn = new Button("New Game");
        exBtn.addActionListener(this);
        distBtn.addActionListener(this);
        newBtn.addActionListener(this);
        num = new TextField("4");
        setLayout(new BorderLayout());
        Panel n=new Panel();
        n.setLayout(new GridLayout(0,5));
        n.add(exBtn);
        n.add(distBtn);
        n.add(num);
        n.add(new Label(" Players"));

        n.add(newBtn);
        add(BorderLayout.NORTH, n);
        message = new Label("hi");
        add(BorderLayout.SOUTH, message);
        this.addWindowListener(new WindowListener() {
                public void windowClosing(WindowEvent e) {System.exit(0);}

                public void windowClosed(WindowEvent e) {}

                public void windowOpened(WindowEvent e) {}

                public void windowIconified(WindowEvent e) {}

                public void windowDeiconified(WindowEvent e) {}

                public void windowActivated(WindowEvent e) {}

                public void windowDeactivated(WindowEvent e) {}
            }); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object btn = e.getSource();
        if (btn==exBtn){
            message.setText("Example Button pressed");
            tp= new TokenPass(4);
            int[] b={3,2,6,10};
            tp.setTokens(b);
            tp.setActive(2);
            repaint();
        }
        if (btn==distBtn){
            message.setText("Distribute Button pressed");
            tp.distributeCurrentPlayerTokens();
            int next = (1 + tp.getCurrentPlayer()) % tp.getBoard().length;
            tp.setActive(next);
            repaint();
        }
        if (btn==newBtn){
            message.setText("New Game Button pressed");
            int p=Integer.parseInt(num.getText());
            tp = new TokenPass(p);
            repaint();
        }
    }

    public void paint(Graphics g) {
        if (tp==null)
            return;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLUE);

        int n = tp.getBoard().length;
        for (int i=0; i<n; i++){
            g.drawString ("Player "+i, i*100+50, 160);
            g.drawString(tp.getBoard()[i]+" tokens", i*100+50, 200);
            if(i==tp.getCurrentPlayer())
                g.drawString("current", i*100+50, 145);
        }

    }
    public static void main(String[] args)
    {
        TokenPassTester app= new TokenPassTester();
        app.setVisible(true);
    }
}