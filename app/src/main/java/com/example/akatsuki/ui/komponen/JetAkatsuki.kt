package com.example.akatsuki.ui.komponen

import android.media.Image
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.akatsuki.R
import com.example.akatsuki.model.Akatsuki
import com.example.akatsuki.model.DataAkatsuki
import com.example.akatsuki.ui.theme.AkatsukiTheme


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AkatsukiTheme {
        JetAkatsuki()
    }
}

@Composable
fun JetAkatsuki(
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            this.items(DataAkatsuki.akatsukis, key = { it.id }) { hero ->
                AkatsukiListItem(
                    akatsuki = Akatsuki(
                        "1",
                        R.drawable.gambar_conan,
                        R.drawable.cincin_conan,
                        "Cincin Burung (Byakko)",
                        "Konan",
                        "Anggota Akatsuki yang setia dan bijaksana. Dia adalah shinobi Amegakure yang menggunakan kertas untuk bertarung."
                    )
                )
            }
        }
    }
}

@Composable
fun AkatsukiListItem(
    akatsuki: Akatsuki,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.clickable {}
    ) {
        Image(
            painter = painterResource(akatsuki.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Text(
            text = akatsuki.nama,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeroListItemPreview() {
    AkatsukiTheme {
        AkatsukiListItem(
            akatsuki = Akatsuki(
                "1",
                R.drawable.gambar_conan,
                R.drawable.cincin_conan,
                "Cincin Burung (Byakko)",
                "Konan",
                "Anggota Akatsuki yang setia dan bijaksana. Dia adalah shinobi Amegakure yang menggunakan kertas untuk bertarung."
            )
        )
    }
}