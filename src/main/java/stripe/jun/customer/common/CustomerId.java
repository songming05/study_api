package stripe.jun.customer.common;

/**
 * CustomerId, 키 값들의 혼용 방지를 위해 객체로 생성
 */
public class CustomerId {
    public final String value;

    public CustomerId(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
