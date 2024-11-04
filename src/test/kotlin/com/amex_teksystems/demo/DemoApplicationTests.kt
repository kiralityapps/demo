package com.amex_teksystems.demo

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.beans.factory.annotation.Autowired


import com.amex_teksystems.demo.model.Item
import com.amex_teksystems.demo.services.OrderServices

@SpringBootTest
class DemoApplicationTests {

	@Test
	fun contextLoads() {
	}
	
	@Test
	fun 'test order create valid items'() {
		val items = listOf(Item("apple", 2), Item("orange", 4))
		val order = orderService.createOrder(items)
		assertEquals(2.20, order.totalCost)
	}
	
	@Test
	fun 'test order create no items'() {
		val items = emptyList<Item>()
		val order = orderService.createOrder(items)
		assertEquals(0.00, order.totalCost)
	}
	
	@Test
	fun 'test order create single fruit item'() {
		val items = listOf(Item("apple", 1))
		val order = orderService.createOrder(items)
		assertEquals(0.60, order.totalCost)
	}

}
