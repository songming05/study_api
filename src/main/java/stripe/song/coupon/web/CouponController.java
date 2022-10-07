package stripe.song.coupon.web;


import org.springframework.web.bind.annotation.*;

@RestController
public class CouponController {
    @GetMapping("api/v1/coupons/{id}")
    public String retrieveCoupon(@PathVariable String id) {
        return id + " : Z4OV52SU";
    }
}
