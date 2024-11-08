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
		val items = listOf(Item("apple", 1), Item("orange", 1))
		val order = orderService.createOrder(items)
		assertEquals(0.85, order.totalCost)
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
	
	@Test
	fun 'test order with offers applied'() {
		val items = listOf(Item("apple", 3), Item("orange", 4))
		val order = orderService.createOrder(items)
		assertEquals(1.70, order.totalCost)
	}
	
	@Test
	fun 'test get by id'() {
		val items = listOf(Item("apple", 3))
		val order = orderService.createOrder(items)
		val retrievedOrder = orderService.getOrderById(order.id)		
		assertEquals(order, retrievedOrder)
	}
	
	@Test
	fun 'test get all orders'() {
		val items1 = listOf(Item("apple", 3))
		val items2 = listOf(Item("Orange", 3))
		orderService.createOrder(items1)
		orderService.createOrder(items2)
		val allOrders = orderService.getAllOrders()
		assertEquals(2, allOrders.size)
	}

}
