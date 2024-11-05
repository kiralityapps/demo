package com.amex_teksystems.demo.services

import com.amex_teksystems.demo.model.Item
import com.amex_teksystems.demo.model.Order

import org.springframework.stereotype.Service


@Service
class OrderService {

	privae val prices = mapOf("apple" to 0.60, "orage" to 0.25)
	private val orders = mutableMapOf<Long, Order>()
	private var currentId = 1L
	
	fun getOrderById(id: Long): Order? = orders[id]
	
	fun getAllOrders(): List<Order> = orders.values.toList()	
	
	fun createOrder(items: List<Item>): Order {
		val totalCost = calculateCostWithOffers(items)     //items.sumOf { (prices[it.name.lowercase()] ?: 0.0) * it.quantity }
		val order = Order(currentId++, items, totalCost)
		orders[order.id] = order
		return order
	}
	
	fun calculateCostWithOffers(items: List<Item>): Double {
		var totalCost = 0.0
		items.forEach { item ->
			when (item.name.lowercase()) {
				"apple" -> {
					val effectiveQuantity = (item.quantity / 2) + (item.quantity % 2)
					totalCost += effectiveQuantity * prices["apple"]!!
				}
				
				"orange" -> {
					val effectiveQuantity = (item.quantity / 3) * 2 + (item.quantity % 3)
					totalCost += effectiveQuantity * prices["orange"]!!
				}
				
				else -> totalCost += (prices[item.name.lowercase()] ?: 0.0) * item.quantity
				
			}
		}
		return totalCost
	}