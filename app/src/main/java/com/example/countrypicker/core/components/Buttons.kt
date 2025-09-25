package com.example.countrypicker.core.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.countrypicker.R
import com.example.countrypicker.ui.theme.Purple
import com.example.countrypicker.ui.theme.white

@Composable
fun AnimatedButton(
    modifier: Modifier = Modifier,
    animationStarted: Boolean,
    onNext: () -> Unit,
    buttonText : String
) {
    val infiniteTransition = rememberInfiniteTransition()
    val infiniteSlide by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 10f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 700),
            repeatMode = RepeatMode.Reverse
        )
    )

    AnimatedVisibility(
        visible = animationStarted,
        enter =  scaleIn(),
        exit =  scaleOut()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ActionButton(
                modifier = modifier
                    .padding(bottom = 16.dp)
                    .height(50.dp),
                onClick = { onNext() },
                contentColor = white,
                containerColor = Purple,
                content = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = buttonText,

                            modifier = Modifier
                                .animateEnterExit(
                                    enter = slideInHorizontally(initialOffsetX = { -it * 5 }),
                                    exit = slideOutHorizontally(targetOffsetX = { it * 5 })
                                )
                        )
                        Icon(
                            painter = painterResource(R.drawable.arrow_forward),
                            contentDescription = null,
                            tint = white,
                            modifier = Modifier
                                .offset(x = infiniteSlide.dp)
                        )
                    }
                }
            )
        }
    }
}

@Composable
@Stable
fun ActionButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    contentColor: Color = Color.White,
    containerColor: Color,
    content: @Composable () -> Unit
) {
    val currentOnClick by rememberUpdatedState(onClick)
    Button(
        onClick = currentOnClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        content = {
            content()
        }
    )
}
