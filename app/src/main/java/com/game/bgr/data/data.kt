package com.game.bgr.data




/**
 * coco man
 * 2024/4/6
 **/
data class ZhenRong(val id:Int,val type:Int,val name:String,val binggan:List<BingGan>,val url:String,val desc:String
,val levelMax:Int,val levelMin:Int,val baowu:String)
data class BingGan(val id:Int,val name: String,val tiaoliao:String,val cd:String,val remark:String)




val shanchahua=BingGan(0,"山茶花饼干","","0","")
val heiqiao=BingGan(1,"黑巧克力饼干","","0","")
val jingui=BingGan(2,"金桂饼干","","0","")
val zimogu=BingGan(3,"自蘑菇饼干","","","")
val degula=BingGan(4,"德古拉饼干","","","")
val shiliu=BingGan(5,"红石榴饼干","","","")
val yinghua=BingGan(6,"樱花饼干","","","")
val bohe=BingGan(7,"薄荷黑巧克力饼干","","","")
val heimei=BingGan(8,"黑莓饼干","","","")
val hongsirong=BingGan(9,"红丝绒饼干","","","")
val gancao=BingGan(10,"甘草饼干","","","")
val tianlajiang=BingGan(11,"甜辣酱饼干","","","")
val nongka=BingGan(12,"浓缩黑咖啡饼干","","","")
val heimai=BingGan(13,"黑麦饼干","","","")


