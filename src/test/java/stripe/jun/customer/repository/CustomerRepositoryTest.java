package stripe.jun.customer.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import stripe.jun.customer.common.CustomerId;
import stripe.jun.customer.service.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerService customerService;

    String generateCustomerId = new CustomerIdGenerator().generateCustomerId();

    @Test
    @DisplayName("Customer Id 생성 테스트")
    void customerIdGeneratorTest() {

        assertThat(generateCustomerId.length()).isEqualTo(18);
        assertThat(generateCustomerId.substring(0, 4)).isEqualTo("cus_");
        assertThat(generateCustomerId.substring(4)).containsPattern("[a-zA-Z0-9]*");
    }

    @Test
    @DisplayName("Customer retrieve 테스트, Id 값을 조회하였을 때, Id가 있다면 CustomerId를 반환하고 없다면 메시지를 반환한다.")
    void customerRetrieveTest() {
        //Given
        CustomerCreationRequest customerCreationRequest = new CustomerCreationRequest("김준수"
                , "010-1234-5678"
                , "부자가 되고 싶은 사람");
        Customer customer = customerService.create(customerCreationRequest);

        //When
        Customer customerRetrieve = customerService.retrieve(customer.customerId);

        //Then
        assertThat(customer.customerId).isEqualTo(customerRetrieve.customerId);
        assertThatThrownBy(() -> customerService.retrieve("1234")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Customer delete 테스트, 존재하는 Id 를 삭제하면 remove(return value)가 되고, 존재하지 않는다면 메시지를 반환한다.")
    void customerDeleteTest() {
        //Given
        CustomerCreationRequest customerCreationRequest = new CustomerCreationRequest("김준수"
                , "010-1234-5678"
                , "부자가 되고 싶은 사람");
        Customer customer = customerService.create(customerCreationRequest);
        CustomerId customerId = new CustomerId(customer.customerId);
        CustomerId customerIdForException = new CustomerId(generateCustomerId);

        //When
        CustomerDeleteResult customerDeleteResult = customerService.delete(customerId);

        //Then
        assertThat(customer.customerId).isEqualTo(customerDeleteResult.customerId);
        assertThatThrownBy(() -> customerService.delete(customerIdForException)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Customer update 테스트, 존재하는 Id 를 수정하면 요청된 사항들이 수정되고, 존재하지 않는다면 메시지를 반환한다.")
    void customerUpdateTest() {
        //Given
        CustomerCreationRequest customerCreationRequest = new CustomerCreationRequest("김준수"
                , "010-1234-5678"
                , "부자가 되고 싶은 사람");
        Customer customer = customerService.create(customerCreationRequest);


        CustomerUpdateRequest customerUpdateRequest = new CustomerUpdateRequest(customer.customerId
                ,"리치맨 김준수"
                ,"010-8888-9999"
                ,"주식 잘 좀 돼라");

        CustomerId customerIdForException = new CustomerId(generateCustomerId);

        CustomerUpdateRequest customerUpdateException = new CustomerUpdateRequest(customerIdForException.customerId
                ,"리치맨 김준수"
                ,"010-8888-9999"
                ,"주식 잘 좀 돼라");

        //When
        CustomerUpdateResult customerUpdateResult = customerService.update(customerUpdateRequest);

        //Then
        assertThat(customer.customerId).isEqualTo(customerUpdateResult.customerId);
        assertThat(customerUpdateRequest.customerName).isEqualTo("리치맨 김준수");
        assertThat(customerUpdateRequest.customerPhone).isEqualTo("010-8888-9999");
        assertThat(customerUpdateRequest.customerDescription).isEqualTo("주식 잘 좀 돼라");
        assertThatThrownBy(() -> customerService.update(customerUpdateException)).isInstanceOf(IllegalArgumentException.class);
    }
}