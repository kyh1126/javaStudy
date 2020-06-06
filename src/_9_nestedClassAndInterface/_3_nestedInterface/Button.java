package _9_nestedClassAndInterface._3_nestedInterface;

public class Button {
    OnClickListener listener;

    void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    void touch() {
        listener.onClick();
    }

    // 중첩 인터페이스
    interface OnClickListener {
        void onClick();
    }
}
