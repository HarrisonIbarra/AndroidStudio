package com.example.ejercicio_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.TestModifierUpdaterLayout
import com.example.ejercicio_1.ui.theme.Ejercicio_1Theme



class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ejercicio_1Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    
                }
            Conversation(SampleData.conversationSample)

            MessageCard(Message("Harrison", "Jetpack Compose"))
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {

                Row(modifier = Modifier.padding(all = 8.dp)) {
                    Image(
                        painter = painterResource(R.drawable.honda_en_caballete),
                        contentDescription = "Contact profile picture",
                        modifier = Modifier
                            // Set image size to 40 dp
                            .size(60.dp)
                            // Clip image to be shaped as a circle
                            .clip(CircleShape)
                            .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
                                
                    )


                    // Add a horizontal space between the image and the column
                    Spacer(modifier = Modifier.width(8.dp))
                    var isExpanded by remember { mutableStateOf(false) }

                    Column (modifier = Modifier.clickable { isExpanded = !isExpanded }) {
                        Text(
                            text = msg.author,
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.titleLarge)

                        // Add a vertical space between the author and message texts
                        Spacer(modifier = Modifier.height(4.dp))

                        Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
                            Text(
                                text = msg.body,
                                modifier = Modifier.padding(all = 4.dp),
                                maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    }
                }

            }



@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
     Ejercicio_1Theme {
         Conversation(SampleData.conversationSample)

   }
}






    @Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)


@Preview
@Composable
fun PreviewMessageCard() {
        MessageCard(
            msg = Message("Colleague", "Hey, take a look at Jetpack Compose, it's great!")
        )
}
}












