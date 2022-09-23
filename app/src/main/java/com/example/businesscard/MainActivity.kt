package com.example.businesscard

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
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
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    val modifier = Modifier
    Card(
        backgroundColor = colorResource(R.color.blue_gray_900)
    ) {
        ProfileInfo(
            fullName = "Hugo Simões",
            title = "Android Developer",
            modifier = modifier
        )
        ContactDetails()
    }

}

@Composable
fun ProfileInfo(fullName: String, title: String, modifier: Modifier) {
    Column(
        // Eu fiz o layout poder ter o tamanho da tela inteira e nisso alinhei conforme precisei
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        val image = painterResource(R.drawable.android_logo)
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .size(140.dp)
                .clip(CircleShape)
        )
        Text(
            text = fullName,
            style = TextStyle(
                color = colorResource(R.color.white),
                fontSize = 32.sp
            )

        )
        Text(
            text = title,
            style = TextStyle(
                color = colorResource(R.color.teal_200),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
fun ContactDetails() {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(bottom = 32.dp)
            .width(intrinsicSize = IntrinsicSize.Min)
    ) {
        Divider(
            color = colorResource(R.color.blue_gray_50),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            thickness = 1.dp
        )
        Row(
            modifier = Modifier
                .padding(horizontal = 64.dp)
                .padding(bottom = 16.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Phone,
                contentDescription = null,
                tint = colorResource(R.color.teal_200)
            )
            Text(
                color = colorResource(R.color.white),
                text = "+55 (19) 99468-8181",
                modifier = Modifier
                    .padding(start = 32.dp)
            )
        }
        Divider(
            color = colorResource(R.color.blue_gray_50),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            thickness = 1.dp
        )
        Row(
            modifier = Modifier
                .padding(horizontal = 64.dp)
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = null,
                tint = colorResource(R.color.teal_200)
            )
            Text(
                color = colorResource(R.color.white),
                text = "@hugosimoesdev",
                modifier = Modifier
                    .padding(start = 32.dp)
            )
        }
        Divider(
            color = colorResource(R.color.blue_gray_50),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            thickness = 1.dp
        )
        Row(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .padding(horizontal = 64.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = null,
                tint = colorResource(R.color.teal_200)
            )
            Text(
                color = colorResource(R.color.white),
                text = "hugosimoesdev@gmail.com",
                modifier = Modifier
                    .padding(start = 32.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TitlePreview() {
    BusinessCardTheme {
        Surface {
            BusinessCardApp()
        }
    }
}