package stripe.lsyeon.product.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.util.Calendar;
@Component
public class ProductsIdGenerator {

    Calendar now = Calendar.getInstance();

    public String IdGenerator() {
        // 해당연도 앞 네자리 + 랜덤문자를 포함하여 아이디를 생성한다.

        int year = now.get(Calendar.YEAR);

        String unique = RandomStringUtils.randomAlphanumeric(24);

        return year + unique;
    }

}
