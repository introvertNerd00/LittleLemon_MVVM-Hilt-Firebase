package com.example.littlelemon.domain

import com.example.littlelemon.data.Dish

interface DishRepository {
    suspend fun getAllDishes(): List<Dish>
}