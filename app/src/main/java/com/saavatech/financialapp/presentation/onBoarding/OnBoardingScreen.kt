package com.saavatech.financialapp.presentation.onBoarding

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saavatech.financialapp.presentation.onBoarding.OnBoardingViewModel.OnBoardingEvent
import com.saavatech.financialapp.ui.theme.Lime20
import com.saavatech.financialapp.ui.theme.OnBoardingText1
import com.saavatech.financialapp.ui.theme.TextColorPrimary
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("SuspiciousIndentation")

@Composable
fun OnBoardingScreen(event: (OnBoardingEvent) -> Unit)
{
    val pages=listOf(
        OnBoardingItem.Second,
        OnBoardingItem.Third,
        OnBoardingItem.Fourth,
        OnBoardingItem.Fifth,
        OnBoardingItem.Sixth,
        OnBoardingItem.Seventh,
        OnBoardingItem.Eigth,
    )


    val scope = rememberCoroutineScope()
    val pageState = rememberPagerState(pageCount = {8})
    val userScroll = remember { true }

    Column(Modifier.fillMaxSize()) {
        Box(  modifier = Modifier.fillMaxSize(),  contentAlignment = Alignment.Center){

            Column(verticalArrangement =Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HorizontalPager(state = pageState, userScrollEnabled = userScroll,
                    modifier = Modifier.fillMaxSize()
                        .weight(0.8f)) {page->
                    OnBoardingPage(onBoardingPage = pages[page])
                }

                Indicators(pages.size,pageState.currentPage)

                FinishButton(modifier = Modifier.height(60.dp).padding(vertical =20.dp),
                    pageState=pageState) {
                    scope.launch {
                        if (pageState.currentPage == 7) {
                            event(OnBoardingEvent.SaveAppEntry)
                        } else {
                        if (pageState.currentPage + 1 < pages.size) {
//                            scope.launch {
                                pageState.scrollToPage(pageState.currentPage + 1)
//                            }
                        }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(60.dp))

            }
        }

        var onNextClicked: () -> Unit = {
            // Define the behavior for the next button click here
            // For example, you can navigate to the next page
            // or perform any other action you desire

            if (pageState.currentPage + 1 < pages.size) {
                scope.launch {
                    pageState.scrollToPage(pageState.currentPage + 1)
                }
            }
        }

    }
}


@Composable
fun OnBoardingPage(onBoardingPage: OnBoardingItem) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp), // Increased padding for better spacing
            horizontalAlignment = Alignment.CenterHorizontally, // Center content horizontally
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically) // Add spacing between elements, align vertically
        ) {

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f),
                painter = painterResource(id = onBoardingPage.image),
                contentDescription = "Onboarding Image", // Fixed typo and made more descriptive
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally, // Center text in column
                verticalArrangement = Arrangement.spacedBy(8.dp) //space between title and description
            ) {

                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style =
                                SpanStyle(
                                    color = TextColorPrimary,
                                ),
                        ) {
                            append(onBoardingPage.title)
                        }
                        append(" ")
                        withStyle(
                            style =
                                SpanStyle(
                                    color = MaterialTheme.colorScheme.primary ,
                                    fontWeight = FontWeight.Bold,
                                ),
                        ) {
                            append(onBoardingPage.minTitle)
                        }
                    },
                    style = MaterialTheme.typography.headlineLarge, // Use MaterialTheme typography
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,

                )

                //description
                Text(
                    text =
                        buildAnnotatedString {
                            withStyle(
                                style =
                                    SpanStyle(
                                        color = OnBoardingText1,
//                                        fontSize = 20.sp,
                                    ),
                            ) {
                                append(onBoardingPage.description)
                            }
                            append(" ")
                            withStyle(
                                style =
                                    SpanStyle(
                                        color = MaterialTheme.colorScheme.primary ,
                                        fontWeight = FontWeight.Bold,
                                    ),
                            ) {
                                append(onBoardingPage.minDescription)
                            }
                        },
                    style = MaterialTheme.typography.bodyMedium,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Composable
fun Indicators(size: Int, index: Int){
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        repeat(size){
            Indicator(isSelected = it == index)
            if (it != size - 1){
                Spacer(modifier = Modifier.padding(horizontal = 1.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingScreenPreview(){
    OnBoardingScreen {  }
}

@Composable
fun Indicator(isSelected: Boolean){
    val width = animateDpAsState(
        targetValue = if (isSelected) 10.dp else 10.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy),
    )

    Box(
        modifier = Modifier
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected){
                    MaterialTheme.colorScheme.primary
                }else{
                   Lime20 // MaterialTheme.colorScheme.secondary
                }
            )
    )
}

@Composable
fun FinishButton(
    modifier: Modifier,
    pageState: PagerState,
    onClick: () -> Unit
){
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier=Modifier.shadow(
            elevation = 20.dp,
//            shape = RoundedCornerShape(45.dp),
            ambientColor = MaterialTheme.colorScheme.primary,
            spotColor = MaterialTheme.colorScheme.primary,),
        ) {
        Button(
            onClick = { onClick.invoke() },
            shape= RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(contentColor = Color.White)){
//            AnimatedVisibility(modifier= Modifier.fillMaxWidth(),
//                visible = pageState.currentPage==1) {
//                Text(text = "Continue")
//            }
            Text(text ="Continue")

        }

    }
}

//@Preview(showBackground = true)
//@Composable
//fun OnBoardingPage1(){
//    Column(modifier = Modifier.fillMaxSize()) {
//
//        OnBoardingPage(onBoardingPage = OnBoardingItem.First)
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun OnBoardingPage2(){
//    Column(modifier = Modifier.fillMaxSize()) {
//        OnBoardingPage(onBoardingPage = OnBoardingItem.Second)
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun OnBoardingPage3(){
//    OnBoardingPage(onBoardingPage = OnBoardingItem.Third)
//}
//
//@Preview(showBackground = true)
//@Composable
//fun OnBoardingPage4(){
//    OnBoardingPage(onBoardingPage = OnBoardingItem.Fourth)
//}
//
//@Preview(showBackground = true)
//@Composable
//fun OnBoardingPage5(){
//    OnBoardingPage(onBoardingPage = OnBoardingItem.Fifth)
//}
//
//@Preview(showBackground = true)
//@Composable
//fun OnBoardingPage6(){
//    OnBoardingPage(onBoardingPage = OnBoardingItem.Sixth)
//}
//
//@Preview(showBackground = true)
//@Composable
//fun OnBoardingPage7(){
//    OnBoardingPage(onBoardingPage = OnBoardingItem.Seventh)
//}
//
//@Preview(showBackground = true)
//@Composable
//fun OnBoardingPage8(){
//    OnBoardingPage(onBoardingPage = OnBoardingItem.Eigth)
//}

//@Preview