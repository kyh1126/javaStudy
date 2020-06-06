package _9_nestedClassAndInterface._3_nestedInterface;

public class MessageListener implements Button.OnClickListener {
    @Override
    public void onClick() {
        System.out.println("message!");
    }
}
