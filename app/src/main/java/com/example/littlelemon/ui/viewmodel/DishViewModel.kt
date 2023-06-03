package com.example.littlelemon.ui.viewmodel
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.littlelemon.data.Dish
import com.example.littlelemon.domain.DishRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class DishViewModel @Inject constructor(
    private val repo : DishRepository
) : ViewModel() {
    var dishes = mutableStateListOf<Dish>()
        private set

    init {
        if(dishes.isEmpty()){
            fetchDishData()
        }
    }

    private fun fetchDishData() {
        viewModelScope.launch {
            try {
                val items = repo.getAllDishes()
                dishes.addAll(items)
            } catch (e: Exception) {
                Log.e("Exception", e.toString())
            }


        }
    }

    fun getDishById(id: Int) : Dish? {
        for (dish in dishes){
            Log.i("ourError", dish.id.toString())
        }
        return dishes.firstOrNull { it.id == id }
    }

}

