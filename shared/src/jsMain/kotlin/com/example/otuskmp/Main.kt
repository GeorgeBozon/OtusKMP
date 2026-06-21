package com.example.otuskmp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.otuskmp.di.initKoin
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.CSSNumeric
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.dppx
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable
import org.koin.compose.koinInject

fun main() {
    initKoin()

    renderComposable(rootElementId = "root") {
        val viewModel: StopwatchViewModel = koinInject<StopwatchViewModel>()

        val state = viewModel.uiState.collectAsState()

        Column(gap = 20.dppx, ) {
            Text(value = state.value.formattedTime)
            Row(gap = 5.dppx) {
                Button(attrs = {
                    onClick {
                        viewModel.onStartClicked()
                    }
                }) {
                    Text(value = "start")
                }
                Button(attrs = {
                    onClick {
                        viewModel.onStopClicked()
                    }
                }) {
                    Text(value = "stop")
                }
            }
            Button(attrs = {
                onClick {
                    viewModel.onCopyToClipBoard(state.value.formattedTime)
                }
            }) {
                Text(value = "Copy to clipboard")
            }
            Text(value = state.value.clipboardText)
        }
    }
}

@Composable
fun Column(gap: CSSNumeric = 0.dppx, content: @Composable () -> Unit) {
    Div(attrs = {
        style {
            padding(gap)
            display(DisplayStyle.Flex)
            alignItems(AlignItems.Center)
            flexDirection(FlexDirection.Column)
        }
    }) {
        content()
    }
}

@Composable
fun Row(gap: CSSNumeric = 0.dppx, content: @Composable () -> Unit) {
    Div(attrs = {
        style {
            padding(gap)
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Row)
            alignItems(AlignItems.Center)
        }
    }) {
        content()
    }
}

