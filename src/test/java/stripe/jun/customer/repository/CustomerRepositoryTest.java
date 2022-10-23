package stripe.jun.customer.repository;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import stripe.jun.customer.service.Customer;
import stripe.jun.customer.service.CustomerCreationRequest;
import stripe.jun.customer.service.CustomerIdGenerator;
import stripe.jun.customer.service.CustomerService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerService customerService;

    String customerId = new CustomerIdGenerator().generateCustomerId();

    @Test
    @DisplayName("Customer Id 생성 테스트")
    void customerIdGeneratorTest() {

        assertThat(customerId.length()).isEqualTo(18); /** CustomerId 는 18자리 이어야 한다. */
        assertThat(customerId.substring(0, 4)).isEqualTo("cus_"); /** CustomerId 의 앞 4글자는 cus_ 고정이다. */
        assertThat(customerId.substring(4)).containsPattern("[a-zA-Z0-9]*"); /** CustomerId 의 5번째는 영어소문자, 대문자, 숫자식으로 이루어져 있어야 한다.*/
    }

    @Test
    @DisplayName("Customer retrieve 테스트, Id 값을 조회하였을 때, Id가 있다면 CustomerId를 반환하고 없다면 메시지를 반환한다.")
    void customerRetrieveTest() {
        //Given
        CustomerCreationRequest customerCreationRequest = new CustomerCreationRequest("김준수"
                , "010-1234-5678"
                , "부자가 되고 싶은 사람");
        Customer customer = customerService.create(customerCreationRequest); /** CustomerId 저장 */

        //When
        Customer customerRetrieve = customerService.retrieve(customer.customerId); /** CustomerId 찾기 */

        //Then
        assertThat(customer.customerId).isEqualTo(customerRetrieve.customerId); /** 저장한 Id 와 찾는 Id가 같다.*/
        assertThatThrownBy(() -> customerService.retrieve("1234")).isInstanceOf(IllegalArgumentException.class); /** 저장한 적 없는 Id(1234)를 조회하였을 때, IllegalArgumentException 를 반환한다.  */


    }
}