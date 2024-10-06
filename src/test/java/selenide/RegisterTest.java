package selenide;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegisterTest {
    @Test
    void fillFormTest() {
        String userName = "Ma@gmail.com";
        String password = "12345";
        open("/?");

        $("#username").setValue(userName);
        $("#password").setValue(password);

        $("#log in").click();

        $("#output #username").shouldHave(text(userName));
        $("#output #password").shouldHave(text(password));
    }
}
