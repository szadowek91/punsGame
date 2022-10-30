package pl.szadowek91.punsGame.model;

public class ChatMessage {

    public String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ChatMessage(String value) {
        this.value = value;
    }

    public ChatMessage() {
    }
}
