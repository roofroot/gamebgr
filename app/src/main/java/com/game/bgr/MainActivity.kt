package com.game.bgr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.game.bgr.nav.MyNavigation2

enum class CustomNavTag {
    PageOne, PageTwo, PageThree
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.window.decorView.postDelayed({
            initData()
        },200)

    }
    fun initData() {
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                modifier = Modifier
                    .fillMaxSize(),
                startDestination = CustomNavTag.PageOne.name,
            ) {

                    composable(CustomNavTag.PageOne.name) {
                        MyNavigation2(controller = navController) { navTo, navPopupTo, popBack ->
                            HomePage(navTo = navTo)
                        }
                    }

                composable(CustomNavTag.PageTwo.name) {
                    MyNavigation2(controller = navController) { navTo, navPopupTo, popBack ->
                        ZhenRongDetail(
                            navTo = navTo,
                            navToPopup = navPopupTo,
                            popupBack = popBack,
                            it
                        )
                    }
                }
                composable(CustomNavTag.PageThree.name) {
                    MyNavigation2(controller = navController) { navTo, navPopupTo, popBack ->
                        WebViewContent(
                            navTo = navTo,
                            navToPopup = navPopupTo,
                            popupBack = popBack,
                            it
                        )
                    }
                }

            }

        }
    }

}

