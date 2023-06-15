package com.net.parissportifdemo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun BlurryBackgroundBox(content: @Composable () -> Unit) {
    Box(modifier = Modifier.background(Color.LightGray.copy(alpha = 0.3f))) {
        content()
    }
}

@Composable
fun BlurrySearchBar(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: @Composable (() -> Unit)? = null
) {
    BlurryBackgroundBox {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 18.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                    shape = RoundedCornerShape(15),
                    color = Color.White,
                    modifier = modifier.weight(1f)
                ) {
                    TextField(
                        value = value,
                        onValueChange = onValueChange,
                        singleLine = true,
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        leadingIcon = leadingIcon,
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        )
                    )
                }
                Text(
                    text = "Cancel",
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .clickable {
                            onValueChange("")
                        }
                )
            }
        }
    }
}