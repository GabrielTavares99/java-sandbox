package designPatterns.builder;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ToString
public class MessageSenderBuilder {
    private MessageSenderBuilder messageSenderBuilder;
    private List<String> emails;
    private String email, password;

    public MessageSenderBuilder() {
        this.emails = new ArrayList<>();
        messageSenderBuilder = this;
    }

    public MessageSenderBuilder addEmails(String... emails) {
        this.emails.addAll(Arrays.asList(emails));
        return messageSenderBuilder;
    }

    public MessageSenderBuilder withCredentials(String email, String password) {
        this.email = email;
        this.password = password;
        return messageSenderBuilder;
    }

    public MessageSenderBuilder create() {
        return this;
    }

}
