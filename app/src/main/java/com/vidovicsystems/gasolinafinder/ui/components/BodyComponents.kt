package com.vidovicsystems.gasolinafinder.ui.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vidovicsystems.gasolinafinder.domain.GasStationList


@Composable
fun TitleView(name: String) {
    Text(text = name, fontSize = 40.sp, fontWeight = FontWeight.Bold)
}

@Composable
fun Space() {
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun MainButton(name: String, backColor: Color, color: Color, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = color,
            containerColor = backColor
        )
    ) {
        Text(text = name)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(title: String, showBackButton: Boolean = false, onClickBackButton: () -> Unit) {
    TopAppBar(
        title = { Text(text = title, color = Color.White, fontWeight = FontWeight.ExtraBold) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Red
        ),

        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = { onClickBackButton() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }
        }
    )
}

@Composable
fun GasStationCard(price: GasStationList, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(10.dp)
            .shadow(40.dp)
            .clickable { onClick() }
    ) {
        Column {
            MainImage()
        }
    }
}

@Composable
fun MainImage() {
    Icon(
        imageVector = Icons.Default.LocationOn,
        contentDescription = "Icono de ubicación",
        modifier = Modifier.size(50.dp)
    )
}