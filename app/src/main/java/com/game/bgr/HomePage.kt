package com.game.bgr

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavBackStackEntry
import com.compose.demo.ui.theme.aquamarine
import com.compose.demo.ui.theme.black
import com.compose.demo.ui.theme.darkseagreen
import com.compose.demo.ui.theme.darkturquoise
import com.compose.demo.ui.theme.deepskyblue
import com.compose.demo.ui.theme.dodgerblue
import com.compose.demo.ui.theme.ghostwhite
import com.compose.demo.ui.theme.honeydew
import com.compose.demo.ui.theme.ivory
import com.compose.demo.ui.theme.lavender
import com.compose.demo.ui.theme.lavenderblush
import com.compose.demo.ui.theme.lemonchiffon
import com.compose.demo.ui.theme.mediumorchid
import com.compose.demo.ui.theme.mediumpurple
import com.compose.demo.ui.theme.mediumseagreen
import com.compose.demo.ui.theme.mediumturquoise
import com.compose.demo.ui.theme.mistyrose
import com.compose.demo.ui.theme.moccasin
import com.compose.demo.ui.theme.orchid
import com.compose.demo.ui.theme.palevioletred
import com.compose.demo.ui.theme.pink
import com.compose.demo.ui.theme.plum
import com.compose.demo.ui.theme.skyblue
import com.compose.demo.ui.theme.thistle
import com.compose.demo.widget.CustomSeekBar
import com.compose.demo.widget.GradientText
import com.game.bgr.data.ZhenRong
import com.game.bgr.data.listDgl
import com.game.bgr.nav.NavExtrasKey
import com.game.bgr.widget.CustomTabRow
import com.game.bgr.widget.GridLayout
import com.game.bgr.widget.WaveBorderShape
import kotlinx.coroutines.launch

/**
 * coco man
 * 2024/4/6
 **/

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomePage( navTo: (tag: String, bundle: Bundle?) -> Unit){
    val bossType= rememberSaveable {
        mutableStateOf(0)
    }
    val level= rememberSaveable {
        mutableStateOf(0)
    }
    val levelResult= rememberSaveable {
        mutableStateOf(0)
    }
    val zhenRong= remember {
        mutableStateListOf<ZhenRong>()
    }
    val scope= rememberCoroutineScope()
    LaunchedEffect(key1 = levelResult.value,bossType.value, block = {
        scope.launch {
            zhenRong.clear()
            val list=listDgl.filter {
                if(it.levelMin <= levelResult.value &&levelResult.value<=it.levelMax&&it.type==bossType.value){
                    true
                }else{
                    false
                }
            }
            zhenRong.addAll(list)
        }
    })
    val list= listOf("红丝绒蛋糕龙","大天使")

        LazyColumn(modifier =Modifier.background(ivory).fillMaxSize().padding(10.dp),verticalArrangement = Arrangement.spacedBy(20.dp)){
            item {
                Column {
                    Cards1(text = "选择boss类型")
                    CustomTabRow(
                        modifier = Modifier
                            .background(aquamarine, RoundedCornerShape(25.dp))
                            .fillMaxWidth()
                            .height(50.dp),
                        selectedIndex = bossType,
                        frontIndicator = false,
                        data = list,
                        indicatorContent = {
                            Box(
                                Modifier
                                    .background(mediumpurple, RoundedCornerShape(25.dp))
                                    .fillMaxWidth()
                                    .height(50.dp)
                            ) {

                            }
                        }, autoFixedContent = true
                    ) { item: String, index: Int, selected: Boolean ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            contentAlignment = androidx.compose.ui.Alignment.Center
                        ) {
                            Text(
                                text = item,
                                color = if (selected) Color.White else Color.Black
                            )
                        }

                    }

                    Cards1(text = "拖动进度条选择boss等级")

                    Row {
                        Text(text = "当前boss等级：${level.value}")
                    }
                    CustomSeekBar(modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, darkseagreen, shape = RoundedCornerShape(20.dp)),
                        fgOffset = 40.dp,
                        barHeight = 40.dp,
                        currentProgress = level,
                        barFgColor = thistle,
                        barBgColor = Color.Transparent,
                        onStop = {
                                 levelResult.value=it
                        },
                        thumbContent = {
                            Box(
                                it
                                    .shadow(5.dp, shape = CircleShape)
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .background(darkseagreen)
                            ) {

                            }
                        })
                }
            }
            stickyHeader {
                Cards1(text = "查询结果")
            }
            items(zhenRong.count(), key = {
                zhenRong[it].id
            }){
                zhenrongItem(modifier = Modifier, zhenRong = zhenRong[it],navTo)
            }
        }
}
@Composable
fun zhenrongItem(modifier: Modifier,zhenRong: ZhenRong,navTo: (tag: String, bundle: Bundle?) -> Unit){
        Row(
            modifier
                .fillMaxWidth()
                .height(100.dp)
                .shadow(elevation = 10.dp)
                .background(mistyrose)
                .padding(10.dp)
                .clip(RoundedCornerShape(5.dp))
                .clickable {
                }, verticalAlignment = Alignment.CenterVertically) {
            GradientText(modifier = Modifier
                .weight(1f)
                .height(50.dp) ,text = zhenRong.name, brashColors = listOf(pink, skyblue, pink, palevioletred),
                textStyle = TextStyle(fontSize = 28.sp)
            )
            Box(modifier = Modifier
                .border(1.dp, orchid)
                .background(thistle)
                .padding(10.dp)
                .clickable {
                    val bundle = Bundle()
                    bundle.putInt("id", zhenRong.id)
                    navTo(CustomNavTag.PageTwo.name, bundle)
                }) {
                Text(text = "查看详情",color= Color.White, fontSize = 20.sp)
            }
        }

}

@Composable
fun ZhenRongDetail(navTo: (tag: String, bundle: Bundle?) -> Unit,
                 navToPopup: (tag: String, popupTag: String, inclusive: Boolean) -> Unit,
                 popupBack: (tag: String?, inclusive: Boolean, bundle: Bundle) -> Unit,
                 back: NavBackStackEntry?,){
    val id=back?.arguments?.getBundle(NavExtrasKey)?.getInt("id")
    Log.e("id","id${id}")
    val zhenRong= listDgl.find {
        if(it.id==id){
            true
        }else {
            false
        }
    }
    Log.e("id","zhenrong${zhenRong}")
    val scroll= rememberScrollState()
    zhenRong?.let {

        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(scroll)){
            Cards(text = "宝物")
            Row (modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .background(ghostwhite), verticalAlignment = Alignment.CenterVertically){
                Text(text ="${it.baowu}", fontSize = 18.sp)
            }
            Cards(text = "操作方法")
            Row (modifier = Modifier
                .fillMaxWidth()
                .background(lavenderblush)
                .padding(10.dp), verticalAlignment = Alignment.CenterVertically){
                Text(text = "${it.desc}", fontSize = 18.sp)
            }
            Cards(text = "配料")
            GridLayout(modifier = Modifier
                .fillMaxWidth()
                .height(500.dp), columns = 4, fixed = 0) {
                MySpan2(modifier = Modifier, text = "饼干")
                MySpan2(modifier = Modifier, text = "配料类型")
                MySpan2(modifier = Modifier, text = "CD")
                MySpan2(modifier = Modifier, text = "备注")
               zhenRong.binggan.forEach {
                   MySpan(modifier = Modifier.background(moccasin), text = it.name)
                   MySpan(Modifier.background(lemonchiffon),text = it.tiaoliao.toString())
                   MySpan(Modifier.background(honeydew),text = it.cd.toString())
//                   MySpan(Modifier.background(pink),text = it.remark, textSize = 12)
                   Box(
                       Modifier
                           .background(pink)
                           .border(1.dp, Color.Black)
                           .fillMaxSize()) {
                       GradientText(modifier = Modifier
                           .fillMaxSize()
                           .padding(3.dp),text =it.remark )
                   }

               }
           }
           Box(Modifier.clickable {
               val bundle = Bundle()
               bundle.putString("url", zhenRong.url)
               navTo(CustomNavTag.PageThree.name, bundle)
           }) {
               Cards(text = "点击查看详细打龙视频")
           }
        }
    }
}
@Composable
fun MySpan(modifier: Modifier,text: String,textSize:Int=16){
    Box (
        modifier
            .border(1.dp, Color.Black)
            .padding(10.dp)
            .fillMaxSize(),contentAlignment = Alignment.Center){
        Text(text = text, fontSize = textSize.sp)
    }
}
@Composable
fun MySpan2(modifier: Modifier,text: String){
    Box (
        modifier
            .background(darkturquoise)
            .border(1.dp, Color.Black)
            .padding(10.dp)
            .fillMaxSize(),contentAlignment = Alignment.Center){
        Text(text = text, color = Color.White, fontSize = 18.sp)
    }
}

@Composable
fun Cards(text: String) {
    Box(
        Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(10.dp)
            .background(brush = Brush.sweepGradient(listOf(plum, lavender, mediumturquoise, plum)))
            .shadow(10.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = WaveBorderShape(10.dp, 5.dp))
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            GradientText(
                modifier = Modifier
                    .width(200.dp)
                    .height(150.dp),
                text = text,
                brashColors =
                listOf(pink, black, pink),
                maxLines = 1,
            )
        }
    }
}

@Composable
fun Cards1(text: String) {
    Box(
        Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(10.dp)
            .background(Color.Black)
            .shadow(2.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = WaveBorderShape(10.dp, 5.dp))
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            GradientText(
                modifier = Modifier
                    .width(200.dp)
                    .height(150.dp),
                text = text,
                brashColors =
                listOf(mediumseagreen,dodgerblue, mediumorchid, deepskyblue),
                maxLines = 1, textStyle = TextStyle(fontSize = 20.sp)
            )
        }
    }
}

@Composable
fun WebViewContent(navTo: (tag: String, bundle: Bundle?) -> Unit,
                   navToPopup: (tag: String, popupTag: String, inclusive: Boolean) -> Unit,
                   popupBack: (tag: String?, inclusive: Boolean, bundle: Bundle) -> Unit,
                   back: NavBackStackEntry?,) {
    var url=back?.arguments?.getBundle(NavExtrasKey)?.getString("url")
//    url="https://www.baidu.com"
    if(!url.isNullOrEmpty()) {
        // 确保WebViewFeature已经初始化

        // 创建并显示WebView
        AndroidView(
            factory = { context ->
                WebView(context).apply {
                    settings.setJavaScriptEnabled(true);

                    settings.setPluginState(WebSettings.PluginState.ON);

                    settings.setUseWideViewPort(true);


                    // 加载指定的URL
                    loadUrl(url)
                }
            },
            modifier = Modifier.fillMaxSize(), update = {
            }
        )
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Text(text = "点击返回")
        }
    }else{
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Text(text = "暂无视频")
        }

    }

    }

