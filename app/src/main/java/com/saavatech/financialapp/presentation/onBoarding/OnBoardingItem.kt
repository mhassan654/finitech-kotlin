package com.saavatech.financialapp.presentation.onBoarding

import com.saavatech.financialapp.R

sealed class OnBoardingItem(
    val image: Int,
    val title: String,
    val minTitle: String ="",
    val minDescription: String ="",
    val description: String
){
    data object First: OnBoardingItem(
        image = R.drawable.logo,
        title = "Welcome to",
        minTitle = "TransferMe.",
        description = "Your Best Money Transfer Partner"
    )

    data object Second: OnBoardingItem(
        image = R.drawable.onboarding_1,
        title = "Easy, Fast & Trusted",
        description = "Fast money transfer and gauranteed safe transactions with others."
    )

    data object Third: OnBoardingItem(
        image = R.drawable.onboarding_2,
        title = "Saving Your Money",
        description = "Track the progress of your savings and start a habit of saving with",
        minDescription = "TransferMe"
    )

    data object Fourth: OnBoardingItem(
        image = R.drawable.onboarding_3,
        title = "Free Transactions",
        description = "Provides the quality of the financial system with free money " +
                "transactions without any fees."
    )

    data object Fifth: OnBoardingItem(
        image = R.drawable.onboarding_4,
        title = "International Transactions",
        description = "Provides the 100% freedom of the financial management with lowest fees on" +
                "International transactions."
    )

    data object Sixth: OnBoardingItem(
        image = R.drawable.onboarding_5,
        title = "Multiple Credit Cards",
        description = "Provides the 100% freedom of the financial management with Multiple " +
                "Payment Options for local & International Payments."
    )

    data object Seventh: OnBoardingItem(
        image = R.drawable.onboarding_6,
        title = "Bills Payment Made Easy",
        description = "Pay monthly or daily bills at home in a site of Transfers."
    )

    data object Eigth: OnBoardingItem(
        image = R.drawable.onboarding_7,
        title = "Color Your Caards",
        description = "Provides better cards management when using Multiple Cards by using a " +
                "different color for each payment method."
    )
}