package automationpractice.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@Getter
@RequiredArgsConstructor(access = PRIVATE)
public enum Url {
    AUTHENTICATION_PAGE("http://automationpractice.com/index.php?controller=authentication"),
    CONTACT_US_PAGE("http://automationpractice.com/index.php?controller=contact"),
    CREATE_ACCOUNT_PAGE("http://automationpractice.com/index.php?controller=authentication#account-creation"),
    MY_ACCOUNT_PAGE("http://automationpractice.com/index.php?controller=my-account");

    private final String url;
}
