package automationpractice.data.generator;

import com.github.javafaker.Faker;
import lombok.NoArgsConstructor;

import java.util.Locale;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class RandomUsAddressGenerator {
    private static final Faker FAKER = new Faker(new Locale("en-US"));

    public static String getFullAddress() {
        return FAKER.address().fullAddress();
    }

    public static String getCity() {
        return FAKER.address().city();
    }

    public static String getState() {
        return FAKER.address().state();
    }

    public static String getZipCode() {
        return String.valueOf(FAKER.number().numberBetween(10000, 99999));
    }
}
