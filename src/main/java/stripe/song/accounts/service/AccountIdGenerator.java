package stripe.song.accounts.service;

import org.apache.commons.lang3.RandomStringUtils;

public class AccountIdGenerator {
    private String value; // stripe sample : "acct_1032D82eZvKYlo2C"

    public static String generate() {
        final String typePrefix = "acct_";
        final String body = RandomStringUtils.randomAlphanumeric(16); // why RandomStringUtils / how many
        return typePrefix + body;
    }
}
