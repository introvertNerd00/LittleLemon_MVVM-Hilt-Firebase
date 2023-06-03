package com.example.littlelemon.ui.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.littlelemon.DishDetails
import com.example.littlelemon.R
import com.example.littlelemon.data.Dish
import com.example.littlelemon.ui.theme.LittleLemonColor
import com.example.littlelemon.ui.viewmodel.DishViewModel

@Composable
fun LowerPanel(navController: NavHostController, viewModel: DishViewModel) {
    Column {
        WeeklySpecialCard()
        Box {
            if(viewModel.dishes.isNotEmpty()){
                LazyColumn {
                    itemsIndexed(viewModel.dishes) { _, dish ->
                        MenuDish(navController, dish)
                    }
                }
            }
            else{
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = MaterialTheme.colors.primary
                )
            }

        }
    }
}

@Composable
fun WeeklySpecialCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.weekly_special),
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MenuDish(navController: NavHostController? = null, dish: Dish) {
    Card(onClick = {
        Log.d("AAA", "Click ${dish.id}")
        navController?.navigate(DishDetails.route + "/${dish.id}")
    }) {
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp))
        {
            Column {
                Text(text = dish.name, style =  MaterialTheme.typography.h2)
                Text(text = dish.description, style =  MaterialTheme.typography.body1, modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .padding(0.dp, 5.dp, 0.dp, 5.dp))
                Text(text = "$${dish.price}", style =  MaterialTheme.typography.body2)
            }
            Image(painter = rememberAsyncImagePainter(dish.imageUrl), contentDescription = null, modifier = Modifier.clip(
                RoundedCornerShape(10.dp)
            ), contentScale = ContentScale.FillWidth )
        }
    }
    Divider(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        thickness = 1.dp,
        color = LittleLemonColor.yellow
    )
}


