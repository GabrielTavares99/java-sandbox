package designPatterns.builder;

public class Test {
    public static void main(String[] args) {

        MessageSenderBuilder senhazubga = new MessageSenderBuilder()
                .addEmails("xuxu@ig.com", "v@hotmail.com")
                .withCredentials("sender@ig.com", "senhazubga")
                .create();

        System.out.println(senhazubga);

    }
}
