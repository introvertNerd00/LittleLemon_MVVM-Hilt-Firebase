package com.example.littlelemon.data

import android.util.Log
import com.example.littlelemon.domain.DishRepository
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine


class FirebaseDishRepository: DishRepository {
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val collectionReference: CollectionReference = firestore.collection("dishes")


    override suspend fun getAllDishes(): List<Dish> {
        return suspendCoroutine {
            continuation ->
                collectionReference.get()
                    .addOnSuccessListener { querySnapshot ->
                        val menuItems = mutableListOf<Dish>()
                        for (document in querySnapshot) {
                            val id = document.id
                            val name = document.getString("name") ?: "404"
                            val description = document.getString("description") ?: "404"
                            Log.i("myError", "${document.get("price")}")
                            val price = document.getDouble("price") ?: 0.0
                            val imageUrl = document.getString("imageUrl") ?: "404"

                            val menuItem = Dish (
                                id = id.toInt(),
                                name = name,
                                description = description,
                                price = price,
                                imageUrl = imageUrl
                            )

                            menuItems.add(menuItem)
                        }
                        continuation.resume(menuItems)
                    }
                    .addOnFailureListener { exception ->
                        continuation.resumeWithException(exception)
                    }
        }
    }
}