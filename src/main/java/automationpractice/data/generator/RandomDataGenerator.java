package automationpractice.data.generator;

import com.github.javafaker.Faker;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class RandomDataGenerator {

    private static final Faker FAKER = new Faker();

    public static int getRandomNumber(int min, int max) {
        return FAKER.number().numberBetween(min, max);
    }

    public static String getRandomText() {
        return FAKER.lorem().characters();
    }

    public static String getEmail() {
        return FAKER.internet().emailAddress();
    }

    public static String getPassword() {
        return FAKER.internet().password();
    }

    public static String getFirstName() {
        return FAKER.name().firstName();
    }

    public static String getLastName() {
        return FAKER.name().lastName();
    }

    public static String getMobilePhone() {
        return FAKER.phoneNumber().cellPhone();
    }
}
