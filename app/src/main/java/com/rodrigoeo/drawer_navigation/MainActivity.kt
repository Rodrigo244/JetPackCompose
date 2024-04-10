package com.rodrigoeo.drawer_navigation

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rodrigoeo.drawer_navigation.ui.theme.Drawer_NavigationTheme

class MainActivity : ComponentActivity() {


    private val messagesList: List<MyMessage> = listOf(
                MyMessage("Titulo","¡Texto de Prueba!, Lorem ipsum dolor sit amet consectetur adipiscing elit, conubia viverra ornare pulvinar fringilla non, euismod pretium tincidunt himenaeos proin sed. Dui molestie faucibus morbi volutpat non lacus aliquet id, quisque vestibulum venenatis platea pulvinar mus et viverra sociis, mauris vivamus convallis dictum eros ridiculus commodo. Nullam cursus quis risus luctus fringilla tincidunt tellus integer malesuada, ultricies nec volutpat arcu vestibulum lectus vivamus dignissim quisque, cubilia laoreet semper sagittis habitasse duis neque curae."),
                MyMessage("Titulo 1","¡Texto de Prueba!, Lorem ipsum dolor sit amet consectetur adipiscing elit, conubia viverra ornare pulvinar fringilla non, euismod pretium tincidunt himenaeos proin sed. Dui molestie faucibus morbi volutpat non lacus aliquet id, quisque vestibulum venenatis platea pulvinar mus et viverra sociis, mauris vivamus convallis dictum eros ridiculus commodo. Nullam cursus quis risus luctus fringilla tincidunt tellus integer malesuada, ultricies nec volutpat arcu vestibulum lectus vivamus dignissim quisque, cubilia laoreet semper sagittis habitasse duis neque curae."),
                MyMessage("Titulo 2","¡Texto de Prueba!, Lorem ipsum dolor sit amet consectetur adipiscing elit, conubia viverra ornare pulvinar fringilla non, euismod pretium tincidunt himenaeos proin sed. Dui molestie faucibus morbi volutpat non lacus aliquet id, quisque vestibulum venenatis platea pulvinar mus et viverra sociis, mauris vivamus convallis dictum eros ridiculus commodo. Nullam cursus quis risus luctus fringilla tincidunt tellus integer malesuada, ultricies nec volutpat arcu vestibulum lectus vivamus dignissim quisque, cubilia laoreet semper sagittis habitasse duis neque curae."),
                MyMessage("Titulo 3","¡Texto de Prueba!, Lorem ipsum dolor sit amet consectetur adipiscing elit, conubia viverra ornare pulvinar fringilla non, euismod pretium tincidunt himenaeos proin sed. Dui molestie faucibus morbi volutpat non lacus aliquet id, quisque vestibulum venenatis platea pulvinar mus et viverra sociis, mauris vivamus convallis dictum eros ridiculus commodo. Nullam cursus quis risus luctus fringilla tincidunt tellus integer malesuada, ultricies nec volutpat arcu vestibulum lectus vivamus dignissim quisque, cubilia laoreet semper sagittis habitasse duis neque curae."),
                MyMessage("Titulo 4","¡Texto de Prueba!, Lorem ipsum dolor sit amet consectetur adipiscing elit, conubia viverra ornare pulvinar fringilla non, euismod pretium tincidunt himenaeos proin sed. Dui molestie faucibus morbi volutpat non lacus aliquet id, quisque vestibulum venenatis platea pulvinar mus et viverra sociis, mauris vivamus convallis dictum eros ridiculus commodo. Nullam cursus quis risus luctus fringilla tincidunt tellus integer malesuada, ultricies nec volutpat arcu vestibulum lectus vivamus dignissim quisque, cubilia laoreet semper sagittis habitasse duis neque curae."),
                MyMessage("Titulo 5","¡Texto de Prueba!, Lorem ipsum dolor sit amet consectetur adipiscing elit, conubia viverra ornare pulvinar fringilla non, euismod pretium tincidunt himenaeos proin sed. Dui molestie faucibus morbi volutpat non lacus aliquet id, quisque vestibulum venenatis platea pulvinar mus et viverra sociis, mauris vivamus convallis dictum eros ridiculus commodo. Nullam cursus quis risus luctus fringilla tincidunt tellus integer malesuada, ultricies nec volutpat arcu vestibulum lectus vivamus dignissim quisque, cubilia laoreet semper sagittis habitasse duis neque curae."),
                MyMessage("Titulo 6","¡Texto de Prueba!, Lorem ipsum dolor sit amet consectetur adipiscing elit, conubia viverra ornare pulvinar fringilla non, euismod pretium tincidunt himenaeos proin sed. Dui molestie faucibus morbi volutpat non lacus aliquet id, quisque vestibulum venenatis platea pulvinar mus et viverra sociis, mauris vivamus convallis dictum eros ridiculus commodo. Nullam cursus quis risus luctus fringilla tincidunt tellus integer malesuada, ultricies nec volutpat arcu vestibulum lectus vivamus dignissim quisque, cubilia laoreet semper sagittis habitasse duis neque curae."),
                MyMessage("Titulo 7","¡Texto de Prueba!"),
                MyMessage("Titulo 8","¡Texto de Prueba!"),
                MyMessage("Titulo 9","¡Texto de Prueba!"),
                MyMessage("Titulo 10","¡Texto de Prueba!"),
                MyMessage("Titulo 11","¡Texto de Prueba!"),
                MyMessage("Titulo 12","¡Texto de Prueba!"),
                MyMessage("Titulo 13","¡Texto de Prueba!"))

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Drawer_NavigationTheme {
                MyMessagess(messagesList)
            }
        }
    }


    data class MyMessage(val title: String, val body: String){}

    @Composable
    fun MyMessagess(messagess: List<MyMessage>){
        LazyColumn{items(messagess){ message ->
            MyComponets(message)
        }

        }
    }

    @Composable
    fun MyComponets(message: MyMessage) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .background(Color.White)
        ) {
            MyImage()
            MyTexts(message)
        }
    }

    @Composable
    fun MyImage() {
        Image(
            painterResource(R.drawable.ic_launcher_foreground),
            "Imagen de prueba",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(Color.Blue)
        )

    }


    @Composable
    fun MyTexts(message: MyMessage) {

        var expanded by remember { mutableStateOf(false) }
        Column(modifier = Modifier.padding(start = 8.dp).clickable {
            expanded = !expanded
        }) {
            MyText(
                message.title,
                MaterialTheme.colorScheme.primary,
                MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            MyText(message.body, MaterialTheme.colorScheme.error,
                MaterialTheme.typography.titleSmall,
                if(expanded) Int.MAX_VALUE else 1)
        }
    }

    @Composable
    fun MyText(text: String, color: Color, style: androidx.compose.ui.text.TextStyle, lines : Int = Int.MAX_VALUE) {
        Text(text, color = color, style = style, maxLines = lines)
    }



    @Preview(showSystemUi = true)
    @Composable
    fun PreviewComponent() {
        Drawer_NavigationTheme {
            MyMessagess(messagesList)
        }

    }


}
