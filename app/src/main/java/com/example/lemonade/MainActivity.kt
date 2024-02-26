package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}

@Composable
fun LemonApp() {
    // A surface container using the 'background' color from the theme


        var count by remember { mutableStateOf(1) }
        val imageResource = when (count) {
            1 -> R.drawable.lemon_tree
            2 -> R.drawable.lemon_squeeze
            3 -> R.drawable.lemon_drink
            4 -> R.drawable.lemon_restart
            else -> R.drawable.lemon_tree
        }
        val textString = when (count) {
            1 -> R.string.tree
            2 -> R.string.squeeze
            3 -> R.string.empty_glass
            4 -> R.string.lemonade_glass
            else -> R.string.tree
        }
        val contentString = when (count) {
            1 -> R.string.lt
            2 -> R.string.l
            3 -> R.string.eg
            4 -> R.string.gol
            else -> R.string.lt
        }
        if (count > 4){
            count = 1
        }
    Text(
        text = "Lamonade",
        modifier = Modifier
            .background(Color(0xFFF8E34C))
            .fillMaxHeight(.06f)
            .padding(10.dp)
            .fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold
    )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = imageResource),
                contentDescription = stringResource(id = R.string.lt),
                modifier = Modifier.background(Color(0xFFC2EBD1))
                    .fillMaxWidth(.7f)
                    .fillMaxHeight(.3f)
                    .clickable { count += 1 }


            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = stringResource(id = textString),
                fontSize = 17.sp,
                fontStyle = FontStyle.Normal
            )
        }
    }


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}