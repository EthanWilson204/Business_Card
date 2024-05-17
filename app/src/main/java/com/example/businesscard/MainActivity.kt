package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardLayout()
                }
            }
        }
    }
}
//Call all functions for business card
@Composable
private fun BusinessCardLayout(
) {
    ImageAndBackground()
}

//display android logo and name
@Composable
private fun ImageAndBackground(
    modifier: Modifier = Modifier,
    image: Painter = painterResource(id = R.drawable.android_logo),
) {
    //Background
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF4169E1))
    ) {
        //White box for logo
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .offset(y = (-200).dp)
                .size(132.dp)
                .clip(shape = RoundedCornerShape(16.dp))
                .background(color = Color.White)

        ) {
            //Android Logo
            Image(
                painter = image,
                contentDescription = null,
                modifier = modifier
                    .padding(16.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
                    .background(color = Color(0xFF2C4EBD))
                    .align(Alignment.Center)

            )
        }
        //White box for contact info
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.offset(y = 120.dp)) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .width(320.dp)
                    .height(300.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
                    .background(color = Color.White)
                    .offset(y = (-32).dp)
            ) {
                ContactHeader()
            }
        }
    }
}

@Composable
private fun ContactHeader(
    modifier: Modifier = Modifier,
    name: String = stringResource(id = R.string.my_name),
    email: String = stringResource(id = R.string.my_email),
    number: String = stringResource(id = R.string.my_phone)
){

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = name,
                fontFamily = openSansFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp,
                modifier = modifier
                    .offset(y = (32).dp)
                    .padding(16.dp)
            )
            Text(
                text = "CS Major - GVSU",
                fontFamily = openSansFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = modifier
                    .padding(24.dp)
            )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = modifier.offset(y=24.dp),
        ) {
            Text(
                text = "Contact:",
                fontFamily = openSansFontFamily,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = email,
                fontFamily = openSansFontFamily,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = number,
                fontFamily = openSansFontFamily,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
 }

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardLayout()
    }
}

val openSansFontFamily = FontFamily(
    Font(R.font.opensans_light, FontWeight.Bold),
    Font(R.font.opensans_lightitalic, FontWeight.Bold),
    Font(R.font.opensans_italic, FontWeight.Bold)
)