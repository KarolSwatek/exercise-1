package automationpractice.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@Getter
@RequiredArgsConstructor(access = PRIVATE)
public enum User {
    USER("automationpracticeuser@test.com", "Olo6pOjae8qOxdcl4J2B");

    private final String email;
    private final String password;
}
