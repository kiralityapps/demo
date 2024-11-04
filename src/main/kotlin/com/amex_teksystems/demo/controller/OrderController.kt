package com.amex_teksystems.demo.controller

import com.amex_teksystems.demo.model.Item
import com.amex_teksystems.demo.model.Order

import org.springframework.http.ResponseEntit
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/orders")
class OrderController(private val orderService: OrderService) {

		@PostMapping
		fun createOrder (@RequestBody items: List<Item>): ResponseEntity<Order> {
			val order = orderService.createOrder(items)
			return ResponseEntity.ok(order)
		}
		
