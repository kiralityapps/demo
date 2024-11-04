package com.amex_teksystems.demo.services

import com.amex_teksystems.demo.model.Item
import com.amex_teksystems.demo.model.Order

import org.springframework.stereotype.Service


@Service
class OrderService {

	privae val prices = mapOf("apple" to 0.60, "orage" to 0.25)
	private val orders = mutableMapOf<Long, Order>()
	private var currentId = 1L
	
	
	fun createOrder(items: List<Item>): Order {
		val totalCost = items.sumOf { (prices[it.name.lowercase()] ?: 0.0) * it.quantity }
		val order = Order(currentId++, items, totalCost)
		orders[order.id] = order
		return order
	}