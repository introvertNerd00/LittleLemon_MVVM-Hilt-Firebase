package com.example.littlelemon.ui.screens


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.littlelemon.DrawerContent
import com.example.littlelemon.R
import com.example.littlelemon.TopAppBar
import com.example.littlelemon.ui.viewmodel.DishViewModel

@Composable
fun DishDetails(id: Int, viewModel: DishViewModel) {
    Log.e("Why", "$id ${viewModel.dishes[id-1]}")
    val dish = requireNotNull(viewModel.getDishById(id))
    var isLoading by remember {
        mutableStateOf(true)
    }
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        TopAppBar(drawerContent = { DrawerContent() },)
        Box{
            Image(
                painter = rememberAsyncImagePainter(dish.imageUrl, onLoading = {isLoading = true}, onSuccess = {isLoading = false} ),
                contentDescription = "Dish Image",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = MaterialTheme.colors.primary
                )
            }

        }
        Column(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(10.dp)) {
            Text(text = dish.name, style = MaterialTheme.typography.h1)
            Text(text = dish.description, style = MaterialTheme.typography.body1)
            Counter()
            Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth() ) {
                Text(text = stringResource(id = R.string.add_for) + "$${dish.price}", textAlign =  TextAlign.Center )
            }
        }
    }
}

@Composable
fun Counter() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
    ) {
        var counter by remember {
            mutableStateOf(1)
        }
        TextButton(
            onClick = {
                counter--
            }
        ) {
            Text(
                text = "-",
                style = MaterialTheme.typography.h2
            )
        }
        Text(
            text = counter.toString(),
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(16.dp)
        )
        TextButton(
            onClick = {
                counter++
            }
        ) {
            Text(
                text = "+",
                style = MaterialTheme.typography.h2
            )
        }
    }
}

/*@Preview(showBackground = true)
@Composable
fun DishDetailsPreview() {
    DishDetails(id = 1)
}*/
