package com.amex_teksystems.demo.model

data class Order(val id: Long, val items: List<Item>, var totalCost: Double = 0.0)