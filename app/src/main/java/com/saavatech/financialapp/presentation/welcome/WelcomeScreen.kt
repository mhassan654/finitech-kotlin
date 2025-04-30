package com.saavatech.financialapp.presentation.welcome

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.saavatech.financialapp.R
import com.saavatech.financialapp.navigation.NavRoutes
import com.saavatech.financialapp.navigation.RoutesNavigator
import com.saavatech.financialapp.ui.theme.OnBoardingText1
import com.saavatech.financialapp.ui.theme.TextColorPrimary

@Preview(showBackground = true, name = "Welcome Screen")
@Composable
fun WelcomeScreen() {

    var navController = rememberNavController()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp), // Increased padding for better spacing
            horizontalAlignment = Alignment.CenterHorizontally, // Center content horizontally
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically) // Add spacing between elements, align vertically
        ) {

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.1f),
                painter = painterResource(id = R.drawable.logo),
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
//                                        fontSize = 20.sp,
                                ),
                        ) {
                            append(stringResource(R.string.welcomeTo))
                        }
                        append(" ")
                        withStyle(
                            style =
                                SpanStyle(
                                    color = MaterialTheme.colorScheme.primary ,
                                    fontWeight = FontWeight.Bold,
                                ),
                        ) {
                            append(stringResource(R.string.app_name))
                        }
                    },
                    style = MaterialTheme.typography.headlineLarge, // Use MaterialTheme typography
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    )

                //description
                Text(
                    text =stringResource(R.string.welcome_description),
                    style = MaterialTheme.typography.bodyMedium,
                    color = OnBoardingText1,
                    textAlign = TextAlign.Center,
                )
            }

            Spacer(modifier = Modifier.height(120.dp))
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.shadow(
                elevation = 30.dp,
                ambientColor = MaterialTheme.colorScheme.primary,
                spotColor = MaterialTheme.colorScheme.primary,)){

                Button(
                    modifier = Modifier.width(201.dp),
                    onClick = { navController.navigate(NavRoutes.OnBoardingScreen.route) },
                    shape= RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(contentColor = Color.White)){
                    Text(text = "Get Started" )
                }
            }
            }


        }

}

//define constants
private val WelcomeTextColor: Color = Color.Gray
private const val IMAGE_MAX_HEIGHT = 0.1f