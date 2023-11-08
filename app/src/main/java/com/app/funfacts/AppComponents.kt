package com.app.funfacts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBar(value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = value,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.pets),
            contentDescription = "Pet Image",
            modifier = Modifier.size(50.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar(value = "Hi There,\uD83d\uDE0A")
}

@Composable
fun TextComponent(
    textValue: String,
    textSize: TextUnit
) {
    Text(
        text = textValue,
        fontSize = textSize,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Justify
    )
}

@Preview(showBackground = true)
@Composable
fun TextCompoPreview() {
    TextComponent(
        textValue = "Text Preview",
        textSize = 24.sp
    )
}

@Composable
fun TextFieldComponent(
    onTextChange: (name: String) -> Unit
) {

    var currentValue by remember { mutableStateOf("") }
    val localFocusManager = LocalFocusManager.current


    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = currentValue,
        onValueChange = {
            currentValue = it
            onTextChange(it)
        },
        placeholder = {
            Text(
                text = stringResource(id = R.string.enter_name),
                fontSize = 20.sp
            )
        },
        textStyle = TextStyle.Default.copy(fontSize = 20.sp),
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = Color.DarkGray,
            focusedBorderColor = Color.DarkGray,
            focusedLabelColor = Color.DarkGray,
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TextFieldPreview() {
    TextFieldComponent(onTextChange = {})
}


@Composable
fun Animal(
    image: Int,
    selected: Boolean,
    animalSelected: (animalName: String) -> Unit
) {

    val localFocusManager = LocalFocusManager.current

    Card(
        modifier = Modifier
            .padding(24.dp)
            .size(120.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.dp,
                    color = if (selected) Color.Blue else Color.Transparent,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "Dog",
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .clickable {
                        val animalName = if (image == R.drawable.cat) "Cat" else "Dog"
                        animalSelected(animalName)
                        localFocusManager.clearFocus()
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnimalPreview() {
    Animal(
        image = R.drawable.cat,
        false,
        animalSelected = {}
    )
}

@Composable
fun ButtonComponent(
    detailScreen: () -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp),
        colors = ButtonDefaults.buttonColors(Color.Blue),
        onClick = {
            detailScreen()
        }) {
        TextComponent(
            textValue = stringResource(id = R.string.detail_screen),
            textSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    ButtonComponent(
        detailScreen = {}
    )
}

@Composable
fun QuoteComposable(value: String) {
    Card(
        modifier = Modifier
            .padding(40.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(18.dp, 24.dp)
        ) {
            Image(
                imageVector = Icons.Filled.FormatQuote,
                contentDescription ="Quote Image",
                modifier = Modifier.rotate(180f)
            )

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                textValue = value ,
                textSize = 28.sp
            )

            Spacer(modifier = Modifier.size(20.dp))

            Image(
                imageVector = Icons.Filled.FormatQuote,
                contentDescription ="Quote Image"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuotePreview() {
    QuoteComposable(value = "Thank You! You Are Very Well")
}




