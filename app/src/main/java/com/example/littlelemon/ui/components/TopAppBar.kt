package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.IconButton
import androidx.compose.material.DrawerState
import androidx.compose.material.DrawerValue
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign



@Composable
fun TopAppBar(scaffoldState: ScaffoldState? = null, scope: CoroutineScope? = null, drawerContent: @Composable () -> Unit) {
    Row(horizontalArrangement = Arrangement.SpaceBetween,
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically) {
        IconButton(onClick = {
            scope?.launch { scaffoldState?.drawerState?.open() }
        }) {
            Image(
                painter = painterResource(id = R.drawable.ic_hamburger_menu),
                contentDescription = "Menu Icon",
                modifier = Modifier.size(24.dp)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.littlelemonimgtxt_nobg),
            contentDescription = "Little Lemon Logo",
            modifier = Modifier.fillMaxWidth(0.5F)
                .padding(horizontal = 20.dp)
        )
        IconButton(onClick = { }) {
            Image(
                painter = painterResource(id = R.drawable.ic_cart),
                contentDescription = "Cart",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    TopAppBar(drawerContent = { DrawerContent() })
}

@Composable
fun DrawerContent() {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Avatar
        Image(
            painter = painterResource(id = R.drawable.baseline_person_outline_24),
            contentDescription = "User Avatar",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )

        // Name
        Text(
            text = "Hamza Afzal",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        // FAQ Option
        Icon(
            painter = painterResource(id = R.drawable.baseline_question_mark_24),
            contentDescription = "FAQ",
            tint = Color.Gray,
            modifier = Modifier
                .size(24.dp)
                .padding(bottom = 8.dp)
        )
        Text(
            text = stringResource(R.string.drawer_option_faq),
            textAlign = TextAlign.Center,
            color = Color.Gray
        )

        // Divider
        Divider(Modifier.padding(vertical = 8.dp))

        // Add additional options or content here...
    }
}




