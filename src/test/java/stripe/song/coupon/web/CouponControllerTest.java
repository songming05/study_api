package stripe.song.coupon.web;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CouponControllerTest {

    @Test
    @DisplayName("쿠폰 id 로 조회하면 그 쿠폰 id에 해당하는 정보를 준다.")
    void test() {
        CouponController couponController = new CouponController();
        String foundCoupon = couponController.retrieveCoupon("zilzu");

        assertThat("zilzu").isEqualTo(foundCoupon);
    }
}
