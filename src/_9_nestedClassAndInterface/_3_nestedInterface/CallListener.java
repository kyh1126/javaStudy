package _9_nestedClassAndInterface._3_nestedInterface;

public class CallListener implements Button.OnClickListener {
    @Override
    public void onClick() {
        System.out.println("call!");
    }
}
