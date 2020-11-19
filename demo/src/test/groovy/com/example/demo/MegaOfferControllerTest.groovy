package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Unroll

@SpringBootTest
class MegaOfferControllerTest extends spock.lang.Specification {
    @Autowired (required = false)
    MegaOfferController controller = new MegaOfferController()
    Order order = new Order();
    void setup() {
        order.setCardType("HDFC")
        order.setName("Mobile")
        order.setPrice(11000)
    }

    void cleanup() {
    }

    @Unroll
    def "TestOrder"() {
        given:
            order
        when:
            Order theUpdatedOrder = controller.testOrder(order)
            println "theUpdatedOrder = $theUpdatedOrder"
        then:
            theUpdatedOrder.getDiscount() == 10
    }
}
